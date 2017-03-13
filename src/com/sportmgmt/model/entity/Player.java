package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER")
public class Player {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PLAYER_ID")
	private Integer playerId;
	
	@Column(name="PLAYER_NAME")
	private String PlayerName;
	
	@Column(name="PLAYER_DESC")
	private String PlayerDesc;
	
	@Column(name="WORLD_RANKING")
	private Integer worldRanking;
	
	@Column(name="HEIGHEST_SCORE")
	private Integer heighetScore;
	
	@Column(name="TOTAL_SCORE")
	private Integer totalScore;
	
	@Column(name="BEST_POSITION")
	private String bestPosition;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="IS_INTERNATIONAL_PLAYER")
	private String isInternationalPlayer;

	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	public String getPlayerDesc() {
		return PlayerDesc;
	}

	public void setPlayerDesc(String playerDesc) {
		PlayerDesc = playerDesc;
	}

	public Integer getWorldRanking() {
		return worldRanking;
	}

	public void setWorldRanking(Integer worldRanking) {
		this.worldRanking = worldRanking;
	}

	public Integer getHeighetScore() {
		return heighetScore;
	}

	public void setHeighetScore(Integer heighetScore) {
		this.heighetScore = heighetScore;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public String getBestPosition() {
		return bestPosition;
	}

	public void setBestPosition(String bestPosition) {
		this.bestPosition = bestPosition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsInternationalPlayer() {
		return isInternationalPlayer;
	}

	public void setIsInternationalPlayer(String isInternationalPlayer) {
		this.isInternationalPlayer = isInternationalPlayer;
	}
}
