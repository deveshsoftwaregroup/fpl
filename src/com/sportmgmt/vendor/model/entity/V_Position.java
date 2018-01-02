package com.sportmgmt.vendor.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_POSITION")
public class V_Position {
	
	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public String getPosition_code() {
		return position_code;
	}

	public void setPosition_code(String position_code) {
		this.position_code = position_code;
	}

	public String getPage_name() {
		return page_name;
	}

	public void setPage_name(String page_name) {
		this.page_name = page_name;
	}

	public String getPage_part() {
		return page_part;
	}

	public void setPage_part(String page_part) {
		this.page_part = page_part;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="POSITION_ID")
	private Integer position_id;
	
	@Column(name="POSITION_CODE")
	private String position_code;
	
	@Column(name="PAGE_NAME")
	private String page_name;
	
	@Column(name="PAGE_PART")
	private String page_part;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	

}
