package com.sportmgmt.dreamEleven.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_POINT")
public class UserPoint {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="USER_POINT_ID")
	private Integer userPointId;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PLAYER_POINT_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private PlayerPoint playerPoint;

	@Column(name="GAME_ID")
	private Integer gameId;
	
	@Column(name="MATCH_ID")
	private Integer matchId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="CURRENT_POINT")
	private Integer currentPoint;
	
	@Column(name="POINT_ACTIVITY")
	private String pointActivity;
	
	@Column(name="POINT_ACTIVITY_TIME")
	private java.sql.Timestamp pointActivityTime;

	public Integer getUserPointId() {
		return userPointId;
	}

	public void setUserPointId(Integer userPointId) {
		this.userPointId = userPointId;
	}

	public PlayerPoint getPlayerPoint() {
		return playerPoint;
	}

	public void setPlayerPoint(PlayerPoint playerPoint) {
		this.playerPoint = playerPoint;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Integer currentPoint) {
		this.currentPoint = currentPoint;
	}

	public String getPointActivity() {
		return pointActivity;
	}

	public void setPointActivity(String pointActivity) {
		this.pointActivity = pointActivity;
	}

	public java.sql.Timestamp getPointActivityTime() {
		return pointActivityTime;
	}

	public void setPointActivityTime(java.sql.Timestamp pointActivityTime) {
		this.pointActivityTime = pointActivityTime;
	}
}
