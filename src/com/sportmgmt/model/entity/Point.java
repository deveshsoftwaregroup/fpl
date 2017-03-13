package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="POINT")
public class Point {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="POINT_ID")
	private Integer pointId;
	
	@Column(name="POINT_NAME")
	private String pointName;
	
	@Column(name="POINT_DESC")
	private String pointDesc;
	
	@Column(name="GAME_ID")
	private Integer gameId;
	
	@Column(name="POINT_TO_DEDUCT")
	private Integer pointToDeduct;
	
	@Column(name="POINT_TO_ADD")
	private Integer pointToAdd;

	public Integer getPointId() {
		return pointId;
	}

	public void setPointId(Integer pointId) {
		this.pointId = pointId;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getPointDesc() {
		return pointDesc;
	}

	public void setPointDesc(String pointDesc) {
		this.pointDesc = pointDesc;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getPointToDeduct() {
		return pointToDeduct;
	}

	public void setPointToDeduct(Integer pointToDeduct) {
		this.pointToDeduct = pointToDeduct;
	}

	public Integer getPointToAdd() {
		return pointToAdd;
	}

	public void setPointToAdd(Integer pointToAdd) {
		this.pointToAdd = pointToAdd;
	}
}
