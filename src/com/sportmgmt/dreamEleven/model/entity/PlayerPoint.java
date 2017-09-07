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
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="PLAYER_POINT")	
public class PlayerPoint {	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="PLAYER_POINT_ID")
	private Integer playerPointId;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="POINT_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Point point;

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="GAME_CLUB_PLAYER_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private GameClubPlayer gameClubPlayer;
	
	@Column(name="GAME_ID")
	private Integer gameId;
	
	@Column(name="MATCH_ID")
	private Integer matchId;
	
	@Column(name="DATE_OF_ARRIVAL")
	private java.sql.Timestamp dateOfArival;

	public Integer getPlayerPointId() {
		return playerPointId;
	}

	public void setPlayerPointId(Integer playerPointId) {
		this.playerPointId = playerPointId;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public GameClubPlayer getGameClubPlayer() {
		return gameClubPlayer;
	}

	public void setGameClubPlayer(GameClubPlayer gameClubPlayer) {
		this.gameClubPlayer = gameClubPlayer;
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

	public java.sql.Timestamp getDateOfArival() {
		return dateOfArival;
	}

	public void setDateOfArival(java.sql.Timestamp dateOfArival) {
		this.dateOfArival = dateOfArival;
	}

}
