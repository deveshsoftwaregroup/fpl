package com.sportmgmt.dreamEleven.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="DE_GAME_WEEK_PLAN")
public class GameWeekPlan {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_DESC")
	private String planDesc;
	
	@Column(name="PLAN_TYPE")
	private Integer planType;
	
	@Column(name="GAME_WEEK_ID")
	private Integer gameWeekId;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
		
	@Column(name="PLAN_AMOUNT")
	private Double planAmount;
	
	@Column(name="OFFER_PRICE")
	private Double offerPrice;
	
	@Column(name="PLAN_CURRENCY")
	private String currency;
	
	@Column(name="WINING_PRICE")
	private Double winingPrice;
	
	@Column(name="WIN_AMOUNT_ALGORITHM")
	private String algorithm;

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

	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getPlanType() {
		return planType;
	}

	public void setPlanType(Integer planType) {
		this.planType = planType;
	}

	public Integer getGameWeekId() {
		return gameWeekId;
	}

	public void setGameWeekId(Integer gameWeekId) {
		this.gameWeekId = gameWeekId;
	}

	public Double getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(Double offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Double getWiningPrice() {
		return winingPrice;
	}

	public void setWiningPrice(Double winingPrice) {
		this.winingPrice = winingPrice;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	
}
