package com.sportmgmt.dreamEleven.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OFFER")
public class Offer {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="OFFER_ID")
	private Integer offerId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="GAME_ID")
	private Integer gameId;
	
	@Column(name="GAME_WEEK_ID")
	private Integer gameWeekId;
	
	@Column(name="MATCH_ID")
	private Integer matchId;
	
	@Column(name="LIMIT_TOTAL")
	private Integer totalLimit;
	
	@Column(name="OFFER_TYPE")
	private String offerType;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="FIELD1")
	private String filed1;

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getGameWeekId() {
		return gameWeekId;
	}

	public void setGameWeekId(Integer gameWeekId) {
		this.gameWeekId = gameWeekId;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Integer getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(Integer totalLimit) {
		this.totalLimit = totalLimit;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getFiled1() {
		return filed1;
	}

	public void setFiled1(String filed1) {
		this.filed1 = filed1;
	}
	
}
