package com.sportmgmt.dreamEleven.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUPON_USED")
public class UsedCoupon {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="COUPON_USED_ID")
	private Integer id;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="GAME_ID")
	private Integer gameId;
	
	@Column(name="GAME_WEEK_ID")
	private Integer gameWeekId;
	
	@Column(name="MATCH_ID")
	private Integer matchId;
	
	@Column(name="COUPON_ID")
	private Integer couponId;
	
	@Column(name="COUPON_CATEGORY_ID")
	private Integer couponCategoryId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getCouponCategoryId() {
		return couponCategoryId;
	}

	public void setCouponCategoryId(Integer couponCategoryId) {
		this.couponCategoryId = couponCategoryId;
	}
}
