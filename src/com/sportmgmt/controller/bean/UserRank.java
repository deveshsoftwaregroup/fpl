package com.sportmgmt.controller.bean;

public class UserRank implements Comparable<UserRank>{
	private Integer userId;
	private Integer point;
	private String name;
	private String favCloub;
	private String country;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavCloub() {
		return favCloub;
	}

	public void setFavCloub(String favCloub) {
		this.favCloub = favCloub;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int compareTo(UserRank userRank) {
		// TODO Auto-generated method stub
		if(this.getPoint()>userRank.getPoint())
			return -1;
		else
			return 1;
	}
}
