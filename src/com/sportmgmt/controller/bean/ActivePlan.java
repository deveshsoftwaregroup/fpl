package com.sportmgmt.controller.bean;

import java.util.Date;

public class ActivePlan {
	private Integer userPlanId;
	private String planName;
	private Integer planTypeVal;
	private String isFree;
	private	Double planValue;
	private Integer startDay;
	private Integer startMonth;
	private Integer startYear;
	private Integer endDay;
	private Integer endMonth;
	private Integer endYear;
	private Double balance;
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getPlanTypeVal() {
		return planTypeVal;
	}
	public void setPlanTypeVal(Integer planTypeVal) {
		this.planTypeVal = planTypeVal;
	}
	public String getIsFree() {
		return isFree;
	}
	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}
	public Double getPlanValue() {
		return planValue;
	}
	public void setPlanValue(Double planValue) {
		this.planValue = planValue;
	}
		
	public Integer getStartDay() {
		return startDay;
	}
	public void setStartDay(Integer startDay) {
		this.startDay = startDay;
	}
	public Integer getStartYear() {
		return startYear;
	}
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}
	public Integer getEndDay() {
		return endDay;
	}
	public void setEndDay(Integer endDay) {
		this.endDay = endDay;
	}
	public Integer getEndMonth() {
		return endMonth;
	}
	public void setEndMonth(Integer endMonth) {
		this.endMonth = endMonth;
	}
	public Integer getEndYear() {
		return endYear;
	}
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Integer getUserPlanId() {
		return userPlanId;
	}
	public void setUserPlanId(Integer userPlanId) {
		this.userPlanId = userPlanId;
	}
	public Integer getStartMonth() {
		return startMonth;
	}
	public void setStartMonth(Integer startMonth) {
		this.startMonth = startMonth;
	}
	public String toString()
	{
		return "userPlanId = "+userPlanId+", planTypeVal =  "+planTypeVal+", planName =  "+planName+ ", isFree = "+isFree+", balance  ="+balance;
	}
}
