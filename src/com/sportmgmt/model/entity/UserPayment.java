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
@Table(name="USER_PAYMENT")
public class UserPayment {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="TRANSACTION_ID")
	private Integer transactionId;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PLAN_DISCOUNT_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private PlanDiscount planDiscount;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PLAN_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private LeaguePlan plan;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private User user;
	
	@Column(name="MERCHAND_ID")
	private String merchantId;
	
	@Column(name="PAYU_ID")
	private String payUId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="PAYMENT_MESSAAGE")
	private String paymentMsg;
	
	@Column(name="PAYMENT_DATE")
	private Date date;
	
	@Column(name="MAIN_AMOUNT")
	private Double amount;
	
	@Column(name="EXTRA_CHARGE_AMOUNT")
	private Double extraCharge;
	
	@Column(name="TOTAL_AMOUNT")
	private Double totalAmount;
	
	@Column(name="AMOUNT_CURRENCY")
	private String currency;
	
	@Column(name="PAYMENT_MODE")
	private String paymentMode;
	
	@Column(name="BANK_CODE")
	private String bankCode;
	
	@Column(name="PG_TYPE")
	private String pgType;

	@Column(name="BANK_REF_NUMBER")
	private String bankReferenceNo;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPayUId() {
		return payUId;
	}

	public void setPayUId(String payUId) {
		this.payUId = payUId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMsg() {
		return paymentMsg;
	}

	public void setPaymentMsg(String paymentMsg) {
		this.paymentMsg = paymentMsg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getExtraCharge() {
		return extraCharge;
	}

	public void setExtraCharge(Double extraCharge) {
		this.extraCharge = extraCharge;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPgType() {
		return pgType;
	}

	public void setPgType(String pgType) {
		this.pgType = pgType;
	}

	public String getBankReferenceNo() {
		return bankReferenceNo;
	}

	public void setBankReferenceNo(String bankReferenceNo) {
		this.bankReferenceNo = bankReferenceNo;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}	
	
	
}
