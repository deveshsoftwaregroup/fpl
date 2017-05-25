package com.sportmgmt.controller.action;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmgmt.controller.bean.Coupon;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.common.CouponUtility;
import com.sportmgmt.utility.common.PointRankingUtility;
@Controller
@RequestMapping("/coupon")
public class CouponAction {
	
	Logger logger = Logger.getLogger(CouponAction.class);
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
	
	@RequestMapping(value = "avial", method = RequestMethod.GET)
	public @ResponseBody java.util.Map avail(@PathVariable String userId,@PathVariable String gameId,@PathVariable String vendorName)
	{
		java.util.Map resultMap = new java.util.HashMap();
		return resultMap;
	}
}
