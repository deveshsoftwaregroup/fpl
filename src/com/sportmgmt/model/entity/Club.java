package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLUB")
public class Club {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="CLUB_ID")
	private Integer clubID;
	
	@Column(name="CLUB_NAME")
	private String clubName;
	
	@Column(name="CLUB_DESC")
	private String clubDesc;
	
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Column(name="CLUB_LOGO")
	private String clubLogoPath;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public Integer getClubID() {
		return clubID;
	}

	public void setClubID(Integer clubID) {
		this.clubID = clubID;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubDesc() {
		return clubDesc;
	}

	public void setClubDesc(String clubDesc) {
		this.clubDesc = clubDesc;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getClubLogoPath() {
		return clubLogoPath;
	}

	public void setClubLogoPath(String clubLogoPath) {
		this.clubLogoPath = clubLogoPath;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
