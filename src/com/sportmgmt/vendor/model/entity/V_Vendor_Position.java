package com.sportmgmt.vendor.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_Vendor_Position")

public class V_Vendor_Position {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="VENDOR_POSITION_ID")
	private Integer vendor_position_id;
	
	@Column(name="VENDOR_ID")
	private Integer vendorId;
	
	@Column(name="POSITION_ID")
	private Integer position_id;
	
	@Column(name="POSITION_PRICE_ID")
	private Integer position_price_id;
	
	@Column(name="ACTIVE_FROM")
	private Integer active_from;
	
	@Column(name="ACTIVE_TO")
	private Integer active_to;

	public Integer getVendor_position_id() {
		return vendor_position_id;
	}

	public void setVendor_position_id(Integer vendor_position_id) {
		this.vendor_position_id = vendor_position_id;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public Integer getPosition_price_id() {
		return position_price_id;
	}

	public void setPosition_price_id(Integer position_price_id) {
		this.position_price_id = position_price_id;
	}

	public Integer getActive_from() {
		return active_from;
	}

	public void setActive_from(Integer active_from) {
		this.active_from = active_from;
	}

	public Integer getActive_to() {
		return active_to;
	}

	public void setActive_to(Integer active_to) {
		this.active_to = active_to;
	}
	

}
