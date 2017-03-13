package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name="MATCH_DETAIL")
public class Match {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="MATCH_ID")
	private Integer matchId;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="MATCH_NAME")
	private String name;
	
	@Column(name="MATCH_DESC")
	private String desc;
	
	@Column(name="START_TIME")
	private Timestamp startTime;
	
	@Column(name="END_TIME")
	private Timestamp endTime;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="BEST_PLAYER_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Player bestPlayer;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="GAME_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Game game;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="CLUB_ONE",insertable=true, updatable=true,nullable=true,unique=true)
	private Club firstClub;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="CLUB_TWO",insertable=true, updatable=true,nullable=true,unique=true)
	private Club secondClub;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="WINNER_CLUB_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Club winnerClub;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="GAME_WEEK_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private GameWeek gameWeek;

	public Integer getMatchId() {
		return matchId;
	}

	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Player getBestPlayer() {
		return bestPlayer;
	}

	public void setBestPlayer(Player bestPlayer) {
		this.bestPlayer = bestPlayer;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Club getFirstClub() {
		return firstClub;
	}

	public void setFirstClub(Club firstClub) {
		this.firstClub = firstClub;
	}

	public Club getSecondClub() {
		return secondClub;
	}

	public void setSecondClub(Club secondClub) {
		this.secondClub = secondClub;
	}

	public Club getWinnerClub() {
		return winnerClub;
	}

	public void setWinnerClub(Club winnerClub) {
		this.winnerClub = winnerClub;
	}

	public GameWeek getGameWeek() {
		return gameWeek;
	}

	public void setGameWeek(GameWeek gameWeek) {
		this.gameWeek = gameWeek;
	}

}
