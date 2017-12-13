package com.sportmgmt.controller.bean;

public class GameWeekPlan {
	private String planId;
	private String name;
	private String desc;
	private String price;
	private String offerPrice;
	private String planType;
	private String winningAmount;
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
	
	public String getOfferPrice() {
		return offerPrice;
	}
	public void setOfferPrice(String offerPrice) {
		this.offerPrice = offerPrice;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getWinningAmount() {
		return winningAmount;
	}
	public void setWinningAmount(String winningAmount) {
		this.winningAmount = winningAmount;
	}
	public String toString()
	{
		return "planId = "+planId+" , name= "+name+" , price = "+price+", planType="+planType;
	}
}
