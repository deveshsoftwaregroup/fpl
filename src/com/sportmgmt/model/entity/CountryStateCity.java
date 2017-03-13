package com.sportmgmt.model.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY_STATE_CITY")
public class CountryStateCity {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="COUNTRY_STATE_CITY_ID")
	private Integer countryStateCityId;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@Column(name="STATE_NAME")
	private String stateName;
	
	@Column(name="CITY_NAME")
	private String cityName;
		
	@Column(name="AREA_CODE")
	private String areaCode;
	
	@Column(name="FIELD1")
	private String field1;
	
	@Column(name="FIELD2")
	private String field2;
	
	public Integer getCountryStateCityId() {
		return countryStateCityId;
	}

	public void setCountryStateCityId(Integer countryStateCityId) {
		this.countryStateCityId = countryStateCityId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String toString()
	{
		return "countryName = "+getCountryName()+" , stateName = "+getStateName()+" , cityName = "+getCityName();
	}
	
}
