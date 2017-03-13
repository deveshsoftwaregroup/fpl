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
@Table(name="GAME_CLUB_PLAYER")
public class GameClubPlayer {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="GAME_CLUB_PLAYER_ID")
	private Integer gameClubPlayerId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="PLAYING_POSITION")
	private String playingPosition;
	
	@Column(name="PRICE_CURRENCY")
	private String priceCurrency;
	
	@Column(name="PRICE")
	private Integer price;
	
	@Column(name="PLAYER_TOTAL_POINT")
	private Integer playerTotalPoint;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="PLAYER_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Player player;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="GAME_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Game game;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="CLUB_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Club club;

	public Integer getGameClubPlayerId() {
		return gameClubPlayerId;
	}

	public void setGameClubPlayerId(Integer gameClubPlayerId) {
		this.gameClubPlayerId = gameClubPlayerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlayingPosition() {
		return playingPosition;
	}

	public void setPlayingPosition(String playingPosition) {
		this.playingPosition = playingPosition;
	}

	public String getPriceCurrency() {
		return priceCurrency;
	}

	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPlayerTotalPoint() {
		return playerTotalPoint;
	}

	public void setPlayerTotalPoint(Integer playerTotalPoint) {
		this.playerTotalPoint = playerTotalPoint;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	
}
