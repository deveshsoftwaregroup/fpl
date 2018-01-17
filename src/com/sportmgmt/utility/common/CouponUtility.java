package com.sportmgmt.utility.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.sportmgmt.controller.bean.Coupon;
import com.sportmgmt.utility.exception.SportMgmtException;
import com.sportmgmt.model.entity.PointCategory;
import com.sportmgmt.model.manager.CouponManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.utility.constrant.SportConstrant;

public class CouponUtility {
	private Logger logger = Logger.getLogger(CouponUtility.class);
	protected List<Coupon> couponList;
	protected Set<String> vendorList = new TreeSet<String>();
	protected Integer couponCategoryId;
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
			PointCategory couponCategory = CouponManager.getCouponCategory(new Integer(gameWeeKReport.get("point")));
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
			PointCategory couponCategory = CouponManager.getCouponCategory(new Integer(gameWeeKReport.get("point")));
			if(couponCategory !=null)
			{
				getCouponListByCategory(gameWeekId, couponCategory);
			}
		}
	
		return couponList;
    }
	public List<Coupon> getDreamElevenCouponList(Integer point,String gameWeekId)
    {
		logger.info("method: getDreamElevenCouponList, point:"+point+" , gameWeeKId: "+gameWeekId);
		PointCategory couponCategory = CouponManager.getCouponCategory(point,"DE_WEEKLY_COUPON");
		if(couponCategory !=null)
		{
			getCouponListByCategory(gameWeekId, couponCategory);
		}
	
		return couponList;
    }
	private void getCouponListByCategory(PointCategory couponCategory) {
		getCouponListByCategory(null,couponCategory);
	}
	private void getCouponListByCategory(String gameWeekId, PointCategory couponCategory) {
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
					couponBean.setCategoryId(couponCategory.getCouponCategoryId());
					vendorList.add(couponModel.getVendor());
					couponList.add(couponBean);
					if(couponModel.getTotal() !=0)
					limittedCouponIdList.add(couponBean.getCouponId());
				}
			}
			Map<Integer,Integer> couponIdAndTotalUsedMap = null;
			if(!limittedCouponIdList.isEmpty() && gameWeekId !=null && !gameWeekId.equals(""))
			{
				couponIdAndTotalUsedMap = CouponManager.getTotalUsedForCouponList(gameWeekId, limittedCouponIdList);
			}
			else if(!limittedCouponIdList.isEmpty())
			{
				couponIdAndTotalUsedMap =CouponManager.getTotalUsedForCouponList(limittedCouponIdList);
			}
			if(couponIdAndTotalUsedMap !=null &&!couponIdAndTotalUsedMap.isEmpty())
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
	
	public String allotCoupon(Integer gameWeekId,Integer userId,Integer couponId) throws SportMgmtException
	{
		com.sportmgmt.model.entity.Coupon coupon=CouponManager.getCouponById(couponId);
		//logger.info("---- Coupon: "+coupon);
		String couponCode = coupon.getCode();
		String isActive = coupon.getIsActive();
		logger.info("---- Coupon:code: "+couponCode);
		logger.info("coupon isActive: "+isActive);
		boolean isAlloted = false;
		if(isActive.equals(SportConstrant.YES))
		{
			Integer couponCategoryId = coupon.getCouponCategory().getCouponCategoryId();
			isAlloted =CouponManager.allotCouponToUser(gameWeekId, userId, couponId,  Integer.valueOf(couponCategoryId), null);
			logger.info("Coupon Alloted: "+isAlloted);
			int totalCoupon = coupon.getTotal();
			logger.info("totalCoupon: "+totalCoupon);
			if(isAlloted && totalCoupon!=0)
			{
				//int totalUsedByUser =CouponManager.getTotalUsedCouponByUserForGameWeek(gameWeekId, Integer.valueOf(userId));
				int totalUsedCoupon = CouponManager.getTotalUsedOfCouponForGameWeek(gameWeekId.toString(), couponId);
				logger.info("totalUsedCoupon: "+totalUsedCoupon);
				if(totalUsedCoupon >=totalCoupon)
				{
					CouponManager.deActivateCoupon(couponId);
				}
			}
		}
		else
		{
			throw new SportMgmtException("Coupon is aread used");
		}
		if(isAlloted)
		{
			return couponCode;
		}
		else
		{
			return null;
		}
		
	}
	
	public String getUsedCouponCodeOfUserByCategoryForGameWeek(String gameWeekId,Integer userId,Integer couponCategoryId)
	{
		Integer couponId =CouponManager.getUsedCouponIdByUserForGameWeekByCatergory(gameWeekId, userId, couponCategoryId);
		if(couponId !=null)
		{
			com.sportmgmt.model.entity.Coupon coupon = CouponManager.getCouponById(couponId);
			if(coupon !=null)
			{
				return coupon.getCode();
			}
		}
		return null;
	}
	public Integer calculateDreamElevenPrizeAmount(Integer point,String couponType)
    {
		logger.info("method: getDreamElevenCouponList, point:"+point+" , couponType: "+couponType);
		PointCategory couponCategory = CouponManager.getCouponCategory(point,couponType);
		int cash =point;
		String algo = couponCategory.getAlgo();
        String [] arrOfStr = algo.split("\\|");
    	String amount = arrOfStr[0];
    	System.out.println(amount);
    	System.out.println(arrOfStr[1]);
        System.out.println(arrOfStr[2]);
        
        if("PER".equalsIgnoreCase(arrOfStr[2]))
        {
        	if("ADD".equalsIgnoreCase(arrOfStr[1]))
        	{
        		cash=cash+(cash*Integer.valueOf(amount)/100);
        	}
        	else
        	{
        		cash=cash-(cash*Integer.valueOf(amount)/100);
        	}
        }
        else if("VAL".equalsIgnoreCase(arrOfStr[2]))
        {
        	if("ADD".equalsIgnoreCase(arrOfStr[1]))
        	{
        		cash=cash+Integer.valueOf(amount);
        	}
        	else
        	{
        		cash=cash-Integer.valueOf(amount);
        	}
        	
        }
        else{
        	System.out.println("no match found n databse to modify prizemoney");
        }
	
		return cash;
    }
	
}
