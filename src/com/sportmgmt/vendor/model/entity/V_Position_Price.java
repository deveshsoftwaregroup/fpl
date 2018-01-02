package com.sportmgmt.vendor.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_POSITION_PRICE")
public class V_Position_Price {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="POSITION_PRICE_ID")
	private Integer position_price_id;
	
	@Column(name="POSITION_ID")
	private Integer position_id;
	
	@Column(name="POSITION_PRIORITY")
	private Float position_priority;
	
	@Column(name="POSITION_PRICE")
	private String position_name;
	
	@Column(name="DESCRIPTION")
	private String Description;
	
	@Column(name="PRICE")
	private Float price;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public Integer getPosition_price_id() {
		return position_price_id;
	}

	public void setPosition_price_id(Integer position_price_id) {
		this.position_price_id = position_price_id;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public Float getPosition_priority() {
		return position_priority;
	}

	public void setPosition_priority(Float position_priority) {
		this.position_priority = position_priority;
	}

	public String getPosition_name() {
		return position_name;
	}

	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	

}
