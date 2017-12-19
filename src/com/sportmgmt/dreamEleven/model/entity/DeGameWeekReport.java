package com.sportmgmt.dreamEleven.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DE_GAME_WEEK_REPORT")
public class DeGameWeekReport {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="DE_GAME_WEEK_REPORT_ID")
	private Integer reportId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="GAME_WEEK_ID")
	private Integer gameWeekId;
	
	@Column(name="WEEK_POINT")
	private Integer point;
	
	@Column(name="WEEK_RANK")
	private Integer rank;
	
	@Column(name="OVERALL_RANK")
	private Integer totalRank;
	
	@Column(name="OVERALL_POINT")
	private Integer totalPoint;
	
	@Column(name="CLUB_RANK")
	private Integer clubRank;
	
	@Column(name="COUNTRY_RANK")
	private Integer countryRank;
	
	@Column(name="USER_FAV_CLUB_ID")
	private Integer userFavClub;
	
	@Column(name="USER_COUNTRY_ID")
	private Integer userCountryId;
	
	@Column(name="USER_START_GAME_WEEK_ID")
	private Integer userStartGameWeekId;
	
	@Column(name="USER_START_GAME_WEEK_RANK")
	private Integer userStartGameWeekRank;
	
	@Column(name="GAMEWEEK_TRANSFER")
	private Integer transfer;
	
	@Column(name="FIELD1")
	private Integer filed1;
	
	@Column(name="FIELD2")
	private Integer filed2;
	
	@Column(name="FIELD3")
	private String filed3;
	
	@Column(name="PLAN_ID")
	private Integer planId;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGameWeekId() {
		return gameWeekId;
	}

	public void setGameWeekId(Integer gameWeekId) {
		this.gameWeekId = gameWeekId;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getTotalRank() {
		return totalRank;
	}

	public void setTotalRank(Integer totalRank) {
		this.totalRank = totalRank;
	}

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}

	public Integer getTransfer() {
		return transfer;
	}

	public void setTransfer(Integer transfer) {
		this.transfer = transfer;
	}

	public Integer getFiled1() {
		return filed1;
	}

	public void setFiled1(Integer filed1) {
		this.filed1 = filed1;
	}

	public Integer getFiled2() {
		return filed2;
	}

	public void setFiled2(Integer filed2) {
		this.filed2 = filed2;
	}

	public String getFiled3() {
		return filed3;
	}

	public void setFiled3(String filed3) {
		this.filed3 = filed3;
	}

	public Integer getClubRank() {
		return clubRank;
	}

	public void setClubRank(Integer clubRank) {
		this.clubRank = clubRank;
	}

	public Integer getCountryRank() {
		return countryRank;
	}

	public void setCountryRank(Integer countryRank) {
		this.countryRank = countryRank;
	}

	public Integer getUserFavClub() {
		return userFavClub;
	}

	public void setUserFavClub(Integer userFavClub) {
		this.userFavClub = userFavClub;
	}

	public Integer getUserCountryId() {
		return userCountryId;
	}

	public void setUserCountryId(Integer userCountryId) {
		this.userCountryId = userCountryId;
	}

	public Integer getUserStartGameWeekId() {
		return userStartGameWeekId;
	}

	public void setUserStartGameWeekId(Integer userStartGameWeekId) {
		this.userStartGameWeekId = userStartGameWeekId;
	}

	public Integer getUserStartGameWeekRank() {
		return userStartGameWeekRank;
	}

	public void setUserStartGameWeekRank(Integer userStartGameWeekRank) {
		this.userStartGameWeekRank = userStartGameWeekRank;
	}
	
}
