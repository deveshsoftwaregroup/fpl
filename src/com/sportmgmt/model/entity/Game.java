package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="GAME")
public class Game {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="GAME_ID")
	private Integer gameId;
	
	@Column(name="GAME_NAME")
	private String gameName;
	
	@Column(name="GAME_DESC")
	private String gameDesc;
	
	@Column(name="TOTAL_CLUB")
	private Integer totalClub;
	
	@Column(name="TOTAL_PLAYERS")
	private Integer totaPlyers;
	
	@Column(name="WINNER_CLUB_ID")
	private Integer winnerClubId;
	
	@Column(name="BEST_PLAYER_ID")
	private Integer bestPlayerId;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDesc() {
		return gameDesc;
	}

	public void setGameDesc(String gameDesc) {
		this.gameDesc = gameDesc;
	}

	public Integer getTotalClub() {
		return totalClub;
	}

	public void setTotalClub(Integer totalClub) {
		this.totalClub = totalClub;
	}

	public Integer getTotaPlyers() {
		return totaPlyers;
	}

	public void setTotaPlyers(Integer totaPlyers) {
		this.totaPlyers = totaPlyers;
	}

	public Integer getWinnerClubId() {
		return winnerClubId;
	}

	public void setWinnerClubId(Integer winnerClubId) {
		this.winnerClubId = winnerClubId;
	}

	public Integer getBestPlayerId() {
		return bestPlayerId;
	}

	public void setBestPlayerId(Integer bestPlayerId) {
		this.bestPlayerId = bestPlayerId;
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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
