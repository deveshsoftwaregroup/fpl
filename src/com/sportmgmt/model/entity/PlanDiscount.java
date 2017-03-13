package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PLAN_DISCOUNT")
public class PlanDiscount {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PLAN_DISCOUNT_ID")
	private Integer planDiscountId;
	
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="PLAN_DISCOUNT_CODE")
	private String planDiscountCode;
	
	@Column(name="PLAN_DISCOUNT_DESC")
	private String planDiscountDesc;
	
	@Column(name="PLAN_DISCOUNT_MSG")
	private String planDiscountMsg;
	
	@Column(name="ACTIVATED_DATE")
	private Date activatedDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="PLAN_DISCOUNT_VALUE")
	private Double planDiscountValue;
	
	@Column(name="DISCOUNT_CURRENCY")
	private String currency;

	public Integer getPlanDiscountId() {
		return planDiscountId;
	}

	public void setPlanDiscountId(Integer planDiscountId) {
		this.planDiscountId = planDiscountId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPlanDiscountCode() {
		return planDiscountCode;
	}

	public void setPlanDiscountCode(String planDiscountCode) {
		this.planDiscountCode = planDiscountCode;
	}

	public String getPlanDiscountDesc() {
		return planDiscountDesc;
	}

	public void setPlanDiscountDesc(String planDiscountDesc) {
		this.planDiscountDesc = planDiscountDesc;
	}

	public String getPlanDiscountMsg() {
		return planDiscountMsg;
	}

	public void setPlanDiscountMsg(String planDiscountMsg) {
		this.planDiscountMsg = planDiscountMsg;
	}

	public Date getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Double getPlanDiscountValue() {
		return planDiscountValue;
	}

	public void setPlanDiscountValue(Double planDiscountValue) {
		this.planDiscountValue = planDiscountValue;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
