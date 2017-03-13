package com.sportmgmt.controller.bean;

public class WildCard {
	
	private String planId;
	private String name;
	private String desc;
	private String price;
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String toString()
	{
		return "planId = "+planId+" , name= "+name+" , price = "+price;
	}

}
