package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="USER_PLAN")
public class UserPlan {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="USER_PLAN_ID")
	private Integer userPlanId;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PLAN_DISCOUNT_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private PlanDiscount planDiscount;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PLAN_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private LeaguePlan plan;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private User user;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="TRANSACTION_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private UserPayment payment;
	
	@Column(name="USER_PLAN_DESC")
	private String planDesc;
	
	@Column(name="PLAN_START_DATE")
	private Date startDate;
	
	@Column(name="PLAN_END_DATE")
	private Date endDate;
	
	@Column(name="BALANCE_AMOUNT")
	private Double balanceAmount;
	
	@Column(name="PLAN_CURRENCY")
	private String currency;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public Integer getUserPlanId() {
		return userPlanId;
	}

	public void setUserPlanId(Integer userPlanId) {
		this.userPlanId = userPlanId;
	}

	public PlanDiscount getPlanDiscount() {
		return planDiscount;
	}

	public void setPlanDiscount(PlanDiscount planDiscount) {
		this.planDiscount = planDiscount;
	}

	public LeaguePlan getPlan() {
		return plan;
	}

	public void setPlan(LeaguePlan plan) {
		this.plan = plan;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserPayment getPayment() {
		return payment;
	}

	public void setPayment(UserPayment payment) {
		this.payment = payment;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
}
