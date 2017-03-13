package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="LEAGUE_PLANS")
public class LeaguePlan {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_DESC")
	private String planDesc;
	
	@Column(name="PLAN_TYPE_VAL")
	private Integer planTypeVal;
	
	@Column(name="PLAN_TYPE_NAME")
	private String planTypeName;
	
	@Column(name="ACTIVATED_DATE")
	private Date activatedDate;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="IS_FREE")
	private String isFree;
		
	@Column(name="PLAN_AMOUNT")
	private Double planAmount;
	
	@Column(name="PLAN_TOTAL_DAYS")
	private Integer totalNoOfDays;
	
	@Column(name="PLAN_CURRENCY")
	private String currency;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public Integer getPlanTypeVal() {
		return planTypeVal;
	}

	public void setPlanTypeVal(Integer planTypeVal) {
		this.planTypeVal = planTypeVal;
	}

	public String getPlanTypeName() {
		return planTypeName;
	}

	public void setPlanTypeName(String planTypeName) {
		this.planTypeName = planTypeName;
	}

	public Date getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Double getPlanAmount() {
		return planAmount;
	}

	public void setPlanAmount(Double planAmount) {
		this.planAmount = planAmount;
	}

	public Integer getTotalNoOfDays() {
		return totalNoOfDays;
	}

	public void setTotalNoOfDays(Integer totalNoOfDays) {
		this.totalNoOfDays = totalNoOfDays;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIsFree() {
		return isFree;
	}

	public void setIsFree(String isFree) {
		this.isFree = isFree;
	}

	
}
