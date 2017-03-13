package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

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
@Table(name="GAME_WEEK")
public class GameWeek {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="GAME_WEEK_ID")
	private Integer gameWeekId;
	
	@Column(name="GAME_WEEK_NAME")
	private String weekName;
	
	@Column(name="IS_CURRENT_WEEK")
	private String isCurrentWeek;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="GAME_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private Game game;
	
	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;

	public Integer getGameWeekId() {
		return gameWeekId;
	}

	public void setGameWeekId(Integer gameWeekId) {
		this.gameWeekId = gameWeekId;
	}

	public String getWeekName() {
		return weekName;
	}

	public void setWeekName(String weekName) {
		this.weekName = weekName;
	}

	public String getIsCurrentWeek() {
		return isCurrentWeek;
	}

	public void setIsCurrentWeek(String isCurrentWeek) {
		this.isCurrentWeek = isCurrentWeek;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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
 
}
