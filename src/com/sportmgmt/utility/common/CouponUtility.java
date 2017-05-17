package com.sportmgmt.utility.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.sportmgmt.controller.bean.Coupon;
import com.sportmgmt.model.entity.CouponCategory;
import com.sportmgmt.model.manager.CouponManager;
import com.sportmgmt.utility.constrant.SportConstrant;

public class CouponUtility {
	private Logger logger = Logger.getLogger(CouponUtility.class);
	private List<Coupon> couponList;
	private Set<String> vendorList = new TreeSet<String>();
	public List<Coupon> getCouponList(Integer userPoint)
	{
		CouponCategory couponCategory = CouponManager.getCouponCategory(userPoint);
		if(couponCategory !=null)
		{
			couponList = new ArrayList<Coupon>();
			List<com.sportmgmt.model.entity.Coupon> allCouponList= couponCategory.getCouponList();
			if(allCouponList !=null && !allCouponList.isEmpty())
			{
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
					}
					
				}
			}
		}
		
	return couponList;
	}
}
