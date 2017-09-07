package com.sportmgmt.dreamEleven.controller.bean;

public class Coupon {
	
	private Integer couponId;
	
	private String name;
	
	private String description;
	
	//private CouponCategory couponCategoryId;
	
	//private String type;
	
	//private String isActive;
	
	private Integer total;
	
	private Integer total_Avail;
	
	private String code;
	
	private String vendor;
	
	private String logo;
	
	private String appURL;
	
	private String field1;
	
	private String field2;

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getAppURL() {
		return appURL;
	}

	public void setAppURL(String appURL) {
		this.appURL = appURL;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public Integer getTotal_Avail() {
		return total_Avail;
	}

	public void setTotal_Avail(Integer total_Avail) {
		this.total_Avail = total_Avail;
	}
	
}
