package com.sportmgmt.controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.sportmgmt.controller.bean.Player;
import com.sportmgmt.utility.exception.SportMgmtException;
import com.sportmgmt.model.manager.CouponManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PlayerManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.common.CouponUtility;
import com.sportmgmt.utility.common.PointRankingUtility;
import com.sportmgmt.utility.constrant.SportConstrant;
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
	public String couponList(ModelMap modeMap,@PathVariable String userId,@PathVariable String gameId,HttpServletRequest request)
	{
		Integer lastGameWeekId = PointRankManager.getLastGameWeekId(gameId);
		if(lastGameWeekId == null)
		{
			List<Integer> sortedGAmeWeekIds=  GameWeeKManager.sortedGameWeekIds(gameId);
			if(sortedGAmeWeekIds !=null && !sortedGAmeWeekIds.isEmpty())
			{
				lastGameWeekId = sortedGAmeWeekIds.get(0);
			}
			
		}
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
			String couponCode = (String)request.getParameter("couponCode");
			logger.info("---- couponCode from parameter: "+couponCode);
			if(couponCode ==null || couponCode.equals(""))
			{
				couponCode = couponUtility.getUsedCouponCodeOfUserByCategoryForGameWeek(lastGameWeekId.toString(), new Integer(userId), couponUtility.getCouponCategoryId());
			}
			logger.info("couponCode : "+couponCode);
			modeMap.put("couponCode", couponCode);
			modeMap.put("isTechnicalError", request.getParameter("isTechnicalError"));
			modeMap.put("isCouponAlreadyUsed", request.getParameter("isCouponAlreadyUsed"));
			
		}
		return "couponList";
	}
	@RequestMapping(value = "dream-elevent/list/{userId}/{gameId}", method = RequestMethod.GET)
	public String dereamElevenCouponList(ModelMap modeMap,@PathVariable String userId,@PathVariable String gameId,HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		//Integer lastGameWeekId = 1;
		Integer lastGameWeekId = PointRankManager.getLastGameWeekId(gameId);
		if(lastGameWeekId == null)
		{
			List<Integer> sortedGAmeWeekIds=  GameWeeKManager.sortedGameWeekIds(gameId);
			if(sortedGAmeWeekIds !=null && !sortedGAmeWeekIds.isEmpty())
			{
				lastGameWeekId = sortedGAmeWeekIds.get(0);
			}
			
		}
		logger.info("Last game week Id: "+lastGameWeekId);
		if(lastGameWeekId != null)
		{
			List<Map<String,String>> gameWeekPlayerList = PlayerManager.gameWeekPlayerList(userId,lastGameWeekId.toString(),"DREAM_ELEVEN");
			logger.info("---- user player list: "+gameWeekPlayerList);
			if(gameWeekPlayerList !=null && !gameWeekPlayerList.isEmpty())
			{
				List<Integer> topPlayesIdsByRank = pointRankingUtility.getTopPlayerIdsOrderedByRankForGameWeek(lastGameWeekId);
				logger.info("topPlayesIdsByRank : "+topPlayesIdsByRank);
				int userPoint = 0;
				if(topPlayesIdsByRank !=null && !topPlayesIdsByRank.isEmpty())
				{
					userPoint = pointRankingUtility.calculateUserPoint(gameWeekPlayerList, topPlayesIdsByRank);
				}
				List<Coupon> couponList =couponUtility.getDreamElevenCouponList(userPoint, lastGameWeekId.toString());
				Set<String> vendorList = couponUtility.getVendorList();
				String couponCode = (String)request.getParameter("couponCode");
				if(couponCode ==null || couponCode.equals(""))
				{
					couponCode = couponUtility.getUsedCouponCodeOfUserByCategoryForGameWeek(lastGameWeekId.toString(), new Integer(userId), couponUtility.getCouponCategoryId());
				}
				
				logger.info("couponCode : "+couponCode);
				logger.info("couponList: "+couponList);
				logger.info("vendorList: "+vendorList);
				modeMap.put("couponList", couponList);
				modeMap.put("vendorList", vendorList);
				modeMap.put("couponCode", couponCode);
				modeMap.put("isTechnicalError", request.getParameter("isTechnicalError"));
				modeMap.put("isCouponAlreadyUsed", request.getParameter("isCouponAlreadyUsed"));
				
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
		}
		return "dreamEleven/couponList";
	}
	@RequestMapping(value = "list/{userId}/{gameId}/{vendorName}", method = RequestMethod.GET)
	public @ResponseBody java.util.Map couponList(@PathVariable String userId,@PathVariable String gameId,@PathVariable String vendorName,HttpServletRequest request)
	{
		java.util.Map resultMap = new java.util.HashMap();
		Integer lastGameWeekId = PointRankManager.getLastGameWeekId(gameId);
		logger.info("Last game week Id: "+lastGameWeekId);
		if(lastGameWeekId != null)
		{
			List<Coupon> couponList =couponUtility.getCouponList(userId, lastGameWeekId.toString(),vendorName);
			logger.info("couponList: "+couponList);
			resultMap.put("couponList", couponList);
			String couponCode = (String)request.getParameter("couponCode");
			if(couponCode ==null || couponCode.equals(""))
			{
				couponCode = couponUtility.getUsedCouponCodeOfUserByCategoryForGameWeek(lastGameWeekId.toString(), new Integer(userId), couponUtility.getCouponCategoryId());
			}
			logger.info("couponCode : "+couponCode);
			resultMap.put("couponCode", couponCode);
			resultMap.put("isTechnicalError", request.getParameter("isTechnicalError"));
			resultMap.put("isCouponAlreadyUsed", request.getParameter("isCouponAlreadyUsed"));
		}
		return resultMap;
	}
	
	@RequestMapping(value = "avail", method = RequestMethod.POST)
	public String avail(@RequestParam("userId") String userId,@RequestParam("gameId") String gameId,@RequestParam("couponId") String couponId)
	{
		java.util.Map resultMap = new java.util.HashMap();
		resultMap.put("isAvialed", true);
		boolean isCouponAlreadyUsed = false; 
		boolean isTechnicalError = false;
		resultMap.put("message", "Coupon is availed");
		Integer couponIdInt = new Integer(couponId);
		Integer userIdInt = new Integer(userId);
		Integer lastGameWeekId = PointRankManager.getLastGameWeekId(gameId);
		if(lastGameWeekId == null)
		{
			List<Integer> sortedGAmeWeekIds=  GameWeeKManager.sortedGameWeekIds(gameId);
			if(sortedGAmeWeekIds !=null && !sortedGAmeWeekIds.isEmpty())
			{
				lastGameWeekId = sortedGAmeWeekIds.get(0);
			}
			
		};
		String couponCode="";
		try
		{
			couponCode = couponUtility.allotCoupon(lastGameWeekId, userIdInt, couponIdInt);
			//resultMap.put("couponCode",couponCode);
		}
		catch(SportMgmtException sme)
		{
			//resultMap.put("isAvialed", false);
			//resultMap.put("message", "Sorry Coupon is not available, Pls choose other coupon");
			isCouponAlreadyUsed = true;
		}
		catch(Exception ex)
		{
			//resultMap.put("isAvialed", false);
			//resultMap.put("message", "Technical issue");
			isTechnicalError = true;
		}
		String redirectURL=SportConstrant.COUPON_LIST_REDIRECT_PAGE+"/"+userId+"/"+gameId+"?couponCode="+couponCode+"&isTechnicalError="+isTechnicalError+"&isCouponAlreadyUsed="+isCouponAlreadyUsed;
		logger.info("----------- Redirecting to coupon list page : "+redirectURL);
		return redirectURL;	
	}
	@RequestMapping(value = "dream-eleven-avail", method = RequestMethod.POST)
	public String dreamElevenAvail(@RequestParam("userId") String userId,@RequestParam("gameId") String gameId,@RequestParam("couponId") String couponId)
	{
		boolean isCouponAlreadyUsed = false; 
		boolean isTechnicalError = false;
		String couponCode="";
		Integer couponIdInt = new Integer(couponId);
		Integer userIdInt = new Integer(userId);
		Integer lastGameWeekId = PointRankManager.getLastGameWeekId(gameId);
		if(lastGameWeekId == null)
		{
			List<Integer> sortedGAmeWeekIds=  GameWeeKManager.sortedGameWeekIds(gameId);
			if(sortedGAmeWeekIds !=null && !sortedGAmeWeekIds.isEmpty())
			{
				lastGameWeekId = sortedGAmeWeekIds.get(0);
			}
			
		}
		try
		{
			couponCode = couponUtility.allotCoupon(lastGameWeekId, userIdInt, couponIdInt);
		}
		catch(SportMgmtException sme)
		{
			isCouponAlreadyUsed = true;
		}
		catch(Exception ex)
		{
			isTechnicalError = true;
		}
		logger.info("----------- Redirecting to coupon list page");
		return SportConstrant.DE_COUPON_LIST_REDIRECT_PAGE+"/"+userId+"/"+gameId+"?couponCode="+couponCode+"&isTechnicalError="+isTechnicalError+"&isCouponAlreadyUsed="+isCouponAlreadyUsed;
	}
}
