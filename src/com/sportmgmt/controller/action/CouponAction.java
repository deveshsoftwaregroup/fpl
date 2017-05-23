package com.sportmgmt.controller.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String orderBy(ModelMap modeMap,@PathVariable String userId,@PathVariable String gameId)
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
			
		}
		return "couponList";
	}
}
