package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="PLAYER_GRP_PLR")
public class PlayerGroupPlayer {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PLAYER_GRP_PLR_ID")
	private Integer playerGroupPlayerId;
	
	@Column(name="PLAYER_GROUP_ID")
	private Integer playerGroupId;
	
	@Column(name="GAME_CLUB_PLAYER_ID")
	private Integer gameClubPlayerId;
	
	@Column(name="IS_PLAYING")
	private String isPlaying;
	
	@Column(name="PLAYER_CATEGORY")
	private String playerCategory;
	
	@Column(name="SEQ_NUM")
	private Integer segNum;

	public Integer getPlayerGroupPlayerId() {
		return playerGroupPlayerId;
	}

	public void setPlayerGroupPlayerId(Integer playerGroupPlayerId) {
		this.playerGroupPlayerId = playerGroupPlayerId;
	}

	public Integer getPlayerGroupId() {
		return playerGroupId;
	}

	public void setPlayerGroupId(Integer playerGroupId) {
		this.playerGroupId = playerGroupId;
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
