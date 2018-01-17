package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="POINT_CATEGORY")
public class PointCategory {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="POINT_CATEGORY_ID")
	private Integer couponCategoryId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="POINT_CATEGORY_ID",insertable=true, updatable=true,nullable=true,unique=true)
	private List<Coupon> couponList;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="MIN_POINT")
	private Integer minPoint;
	
	@Column(name="MAX_POINT")
	private Integer maxPoint;
	
	@Column(name="ALGO")
	private String algo;
	
	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}

	@Column(name="FIELD1")
	private String field1;

	public Integer getCouponCategoryId() {
		return couponCategoryId;
	}

	public void setCouponCategoryId(Integer couponCategoryId) {
		this.couponCategoryId = couponCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Coupon> getCouponList() {
		return couponList;
	}

	public void setCouponList(List<Coupon> couponList) {
		this.couponList = couponList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMinPoint() {
		return minPoint;
	}

	public void setMinPoint(Integer minPoint) {
		this.minPoint = minPoint;
	}

	public Integer getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(Integer maxPoint) {
		this.maxPoint = maxPoint;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}
}
