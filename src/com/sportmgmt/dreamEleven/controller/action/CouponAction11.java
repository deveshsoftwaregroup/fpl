package com.sportmgmt.dreamEleven.controller.action;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmgmt.controller.bean.Coupon;
import com.sportmgmt.model.manager.CouponManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.common.CouponUtility;
import com.sportmgmt.utility.common.PointRankingUtility;
import com.sportmgmt.utility.constrant.SportConstrant;
@Controller
@RequestMapping("/coupon11")
public class CouponAction11 {
	
	Logger logger = Logger.getLogger(CouponAction11.class);
	@Autowired
	private CouponUtility couponUtility;

	public CouponUtility getCouponUtility() {
		return couponUtility;
	}

	public void setCouponUtility(CouponUtility couponUtility) {
		this.couponUtility = couponUtility;
	}
	
	@Autowired
	private PointRankingUtility pointRankingUtility;
	
	
	
	public PointRankingUtility getPointRankingUtility() {
		return pointRankingUtility;
	}


	public void setPointRankingUtility(PointRankingUtility pointRankingUtility) {
		this.pointRankingUtility = pointRankingUtility;
	}
	
	@RequestMapping(value = "list/{userId}/{gameId}", method = RequestMethod.GET)
	public String couponList(ModelMap modeMap,@PathVariable String userId,@PathVariable String gameId)
	{
		Integer lastGameWeekId = PointRankManager.getLastGameWeekId(gameId);
		logger.info("Last game week Id: "+lastGameWeekId);
		if(lastGameWeekId != null)
		{
			List<Coupon> couponList =couponUtility.getCouponList(userId, lastGameWeekId.toString());
			Set<String> vendorList = couponUtility.getVendorList();
			logger.info("couponList: "+couponList);
			logger.info("vendorList: "+vendorList);
			modeMap.put("couponList", couponList);
			modeMap.put("vendorList", vendorList);
			try
			{
				ObjectMapper mapperObj = new ObjectMapper();
				String couponListJson = mapperObj.writeValueAsString(couponList);
				modeMap.put("couponListJson", couponListJson);
			}
			catch(Exception ex)
			{
				 logger.error("---------- Error in parsing map to json: "+ex);
			}
			
		}
		return "couponList";
	}
	
	@RequestMapping(value = "list/{userId}/{gameId}/{vendorName}", method = RequestMethod.GET)
	public @ResponseBody java.util.Map couponList(@PathVariable String userId,@PathVariable String gameId,@PathVariable String vendorName)
	{
		java.util.Map resultMap = new java.util.HashMap();
		Integer lastGameWeekId = PointRankManager.getLastGameWeekId(gameId);
		logger.info("Last game week Id: "+lastGameWeekId);
		if(lastGameWeekId != null)
		{
			List<Coupon> couponList =couponUtility.getCouponList(userId, lastGameWeekId.toString(),vendorName);
			logger.info("couponList: "+couponList);
			resultMap.put("couponList", couponList);
			
		}
		return resultMap;
	}
	
	@RequestMapping(value = "avail", method = RequestMethod.POST)
	public @ResponseBody java.util.Map avail(@RequestParam("userId") String userId,@RequestParam("gameWeekId") String gameWeekId,@RequestParam("couponId") String couponId)
	{
		java.util.Map resultMap = new java.util.HashMap();
		resultMap.put("isAvialed", true);
		resultMap.put("message", "Coupon is availed");
		Integer couponIdInt = new Integer(couponId);
		Integer userIdInt = new Integer(userId);
		Integer gameWeekIdInt = new Integer(gameWeekId);
		com.sportmgmt.model.entity.Coupon coupon=CouponManager.getCouponById(couponIdInt);
		//logger.info("---- Coupon: "+coupon);
		String couponCode = coupon.getCode();
		String isActive = coupon.getIsActive();
		logger.info("---- Coupon:code: "+couponCode);
		resultMap.put("couponCode",couponCode);
		logger.info("coupon isActive: "+isActive);
		if(isActive.equals(SportConstrant.YES))
		{
			Integer couponCategoryId = coupon.getCouponCategory().getCouponCategoryId();
			boolean isAlloted =CouponManager.allotCouponToUser(gameWeekIdInt, userIdInt, couponIdInt,  Integer.valueOf(couponCategoryId), null);
			logger.info("Coupon Alloted: "+isAlloted);
			int totalCoupon = coupon.getTotal();
			logger.info("totalCoupon: "+totalCoupon);
			if(isAlloted && totalCoupon!=0)
			{
				//int totalUsedByUser =CouponManager.getTotalUsedCouponByUserForGameWeek(gameWeekId, Integer.valueOf(userId));
				int totalUsedCoupon = CouponManager.getTotalUsedOfCouponForGameWeek(gameWeekId, couponIdInt);
				logger.info("totalUsedCoupon: "+totalUsedCoupon);
				if(totalUsedCoupon >=totalCoupon)
				{
					CouponManager.deActivateCoupon(couponIdInt);
				}
			}
			
		}
		else
		{
			resultMap.put("isAvialed", false);
			resultMap.put("message", "Sorry Coupon is not aviable, Pls choose other coupon");
		}
		return resultMap;
	}
	
}
