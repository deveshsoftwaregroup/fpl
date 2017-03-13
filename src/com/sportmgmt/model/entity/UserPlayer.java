package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_PLAYER")
public class UserPlayer {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="USER_PLAYER_ID")
	private Integer userPlayerId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="GAME_CLUB_PLAYER_ID")
	private Integer gameClubPlayerId;
	
	@Column(name="IS_PLAYING")
	private String isPlaying;
	
	@Column(name="PLAYER_CATEGORY")
	private String playerCategory;
	
	@Column(name="SEQ_NUM")
	private Integer segNum;

	public Integer getUserPlayerId() {
		return userPlayerId;
	}

	public void setUserPlayerId(Integer userPlayerId) {
		this.userPlayerId = userPlayerId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGameClubPlayerId() {
		return gameClubPlayerId;
	}

	public void setGameClubPlayerId(Integer gameClubPlayerId) {
		this.gameClubPlayerId = gameClubPlayerId;
	}

	public String getIsPlaying() {
		return isPlaying;
	}

	public void setIsPlaying(String isPlaying) {
		this.isPlaying = isPlaying;
	}
	
	
	public String getPlayerCategory() {
		return playerCategory;
	}

	public void setPlayerCategory(String playerCategory) {
		this.playerCategory = playerCategory;
	}

	public Integer getSegNum() {
		return segNum;
	}

	public void setSegNum(Integer segNum) {
		this.segNum = segNum;
	}
	
}
