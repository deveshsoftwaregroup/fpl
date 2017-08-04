package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name="GAME_WEEK_PLR_REPORT")
public class GameWeekPlayerReport {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="GAME_WEEK_PLR_REPORT_ID")
	private Integer reportId;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="GAME_CLUB_PLAYER_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private GameClubPlayer gameClubPlayer;
	
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
	
	@Column(name="FIELD1")
	private Integer filed1;
	
	@Column(name="FIELD2")
	private Integer filed2;
	
	@Column(name="FIELD3")
	private String filed3;

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public GameClubPlayer getGameClubPlayer() {
		return gameClubPlayer;
	}

	public void setGameClubPlayer(GameClubPlayer gameClubPlayer) {
		this.gameClubPlayer = gameClubPlayer;
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
}
