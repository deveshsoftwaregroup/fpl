package com.sportmgmt.dreamEleven.utility.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.sportmgmt.controller.bean.Coupon;
import com.sportmgmt.model.entity.CouponCategory;
import com.sportmgmt.model.manager.CouponManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.utility.constrant.SportConstrant;

public class CouponUtility {
	private Logger logger = Logger.getLogger(CouponUtility.class);
	private List<Coupon> couponList;
	private Set<String> vendorList = new TreeSet<String>();
	private Integer couponCategoryId;
	public Set<String> getVendorList() {
		return vendorList;
	}
	public void setVendorList(Set<String> vendorList) {
		this.vendorList = vendorList;
	}
	
	public Integer getCouponCategoryId() {
		return couponCategoryId;
	}
	public void setCouponCategoryId(Integer couponCategoryId) {
		this.couponCategoryId = couponCategoryId;
	}
	public List<Coupon> getCouponList(String userId,String gameWeekId,String vendor)
    {
		logger.info("method: getCouponList, userId:"+userId+" , gameWeeKId: "+gameWeekId);
		Map<String,String> gameWeeKReport = GameWeeKManager.getGameWeekReport(userId, gameWeekId);
		logger.info(" gameWeeKReport: "+gameWeeKReport);
		if(gameWeeKReport !=null && !gameWeeKReport.isEmpty() && gameWeeKReport.get("point") !=null)
		{
			CouponCategory couponCategory = CouponManager.getCouponCategory(new Integer(gameWeeKReport.get("point")));
			if(couponCategory !=null)
			{
				setCouponCategoryId(couponCategory.getCouponCategoryId());
				couponList = new ArrayList<Coupon>();
				List<com.sportmgmt.model.entity.Coupon> allCouponList= couponCategory.getCouponList();
				if(allCouponList !=null && !allCouponList.isEmpty())
				{
					
					List<Integer> limittedCouponIdList = new ArrayList<Integer>();
					for(com.sportmgmt.model.entity.Coupon couponModel:allCouponList)
					{
						if(couponModel.getIsActive().equals(SportConstrant.YES))
						{
							String vendorInDB = couponModel.getVendor();
							vendorList.add(vendorInDB);
							if(vendor.equals(vendorInDB))
							{
								Coupon couponBean = new Coupon();
								couponBean.setCouponId(couponModel.getCouponId());
								couponBean.setCode(couponModel.getCode());
								couponBean.setAppURL(couponModel.getAppURL());
								couponBean.setDescription(couponModel.getDescription());
								couponBean.setName(couponModel.getName());
								couponBean.setLogo(couponModel.getLogo());
								couponBean.setTotal(couponModel.getTotal());
								couponBean.setVendor(vendorInDB);
								couponList.add(couponBean);
								if(couponModel.getTotal() !=0)
								limittedCouponIdList.add(couponBean.getCouponId());
							}
						}
					}
					
					if(!limittedCouponIdList.isEmpty() && gameWeekId !=null && !gameWeekId.equals(""))
					{
						Map<Integer,Integer> couponIdAndTotalUsedMap = CouponManager.getTotalUsedForCouponList(gameWeekId, limittedCouponIdList);
						if(!couponIdAndTotalUsedMap.isEmpty())
						{
							for(Coupon couponBean:couponList)
							{
								int totalCoupon = couponBean.getTotal();
								Integer totalUsedCoupon = couponIdAndTotalUsedMap.get(couponBean.getCouponId());
								if(totalCoupon !=0 && totalUsedCoupon!=null)
								{
									couponBean.setTotal_Avail(totalCoupon-totalUsedCoupon);
								}
							}
						}
					}
				}
			}
		}
	
		return couponList;
    }
	
	public List<Coupon> getCouponList(String userId,String gameWeekId)
    {
		logger.info("method: getCouponList, userId:"+userId+" , gameWeeKId: "+gameWeekId);
		Map<String,String> gameWeeKReport = GameWeeKManager.getGameWeekReport(userId, gameWeekId);
		logger.info(" gameWeeKReport: "+gameWeeKReport);
		if(gameWeeKReport !=null && !gameWeeKReport.isEmpty() && gameWeeKReport.get("point") !=null)
		{
			CouponCategory couponCategory = CouponManager.getCouponCategory(new Integer(gameWeeKReport.get("point")));
			if(couponCategory !=null)
			{
				setCouponCategoryId(couponCategory.getCouponCategoryId());
				couponList = new ArrayList<Coupon>();
				List<com.sportmgmt.model.entity.Coupon> allCouponList= couponCategory.getCouponList();
				if(allCouponList !=null && !allCouponList.isEmpty())
				{
					
					List<Integer> limittedCouponIdList = new ArrayList<Integer>();
					for(com.sportmgmt.model.entity.Coupon couponModel:allCouponList)
					{
						if(couponModel.getIsActive().equals(SportConstrant.YES))
						{
							Coupon couponBean = new Coupon();
							couponBean.setCouponId(couponModel.getCouponId());
							couponBean.setCode(couponModel.getCode());
							couponBean.setAppURL(couponModel.getAppURL());
							couponBean.setDescription(couponModel.getDescription());
							couponBean.setName(couponModel.getName());
							couponBean.setLogo(couponModel.getLogo());
							couponBean.setTotal(couponModel.getTotal());
							couponBean.setVendor(couponModel.getVendor());
							vendorList.add(couponModel.getVendor());
							couponList.add(couponBean);
							if(couponModel.getTotal() !=0)
							limittedCouponIdList.add(couponBean.getCouponId());
						}
					}
					
					if(!limittedCouponIdList.isEmpty() && gameWeekId !=null && !gameWeekId.equals(""))
					{
						Map<Integer,Integer> couponIdAndTotalUsedMap = CouponManager.getTotalUsedForCouponList(gameWeekId, limittedCouponIdList);
						if(!couponIdAndTotalUsedMap.isEmpty())
						{
							for(Coupon couponBean:couponList)
							{
								int totalCoupon = couponBean.getTotal();
								Integer totalUsedCoupon = couponIdAndTotalUsedMap.get(couponBean.getCouponId());
								if(totalCoupon !=0 && totalUsedCoupon!=null)
								{
									couponBean.setTotal_Avail(totalCoupon-totalUsedCoupon);
								}
							}
						}
					}
				}
			}
		}
	
		return couponList;
    }
}
