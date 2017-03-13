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
@Table(name="USER_GAME")
public class UserGame {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="USER_GAME_ID")
	private Integer userGameId;
	
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="GAME_ID")
	private Integer gameId;
	
	@Column(name="TOTAL_POINT")
	private Integer totalPoint;
	
	@Column(name="TEAM_NAME")
	private String teamName;
	
	@Column(name="ADDED_PLAYER_COUNT")
	private Integer addedPlayerCount;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="FAV_CLUB_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Club favoriteClub;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="FAV_PLAYER_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Player favoritePlayer;
	
	@Column(name="TOTAL_RANK")
	private Integer rank;
	
	@Column(name="FIELD1")
	private String field1;
	
	@Column(name="FIELD2")
	private String field2;
	
	@Column(name="FIELD3")
	private String field3;

	public Integer getUserGameId() {
		return userGameId;
	}

	public void setUserGameId(Integer userGameId) {
		this.userGameId = userGameId;
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

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getAddedPlayerCount() {
		return addedPlayerCount;
	}

	public void setAddedPlayerCount(Integer addedPlayerCount) {
		this.addedPlayerCount = addedPlayerCount;
	}

	public Club getFavoriteClub() {
		return favoriteClub;
	}

	public void setFavoriteClub(Club favoriteClub) {
		this.favoriteClub = favoriteClub;
	}

	public Player getFavoritePlayer() {
		return favoritePlayer;
	}

	public void setFavoritePlayer(Player favoritePlayer) {
		this.favoritePlayer = favoritePlayer;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}
}
