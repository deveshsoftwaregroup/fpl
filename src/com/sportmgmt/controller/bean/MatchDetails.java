package com.sportmgmt.controller.bean;

import java.util.Date;

public class MatchDetails implements Comparable{
private Date startTime;
private Date endTime;
private Integer startHour;
private Integer startMinute;
private Integer endHours;
private Integer endMinute;
private String formatedDate;
private String firstClubName;
private String secondClubName;
private String formatedDate1;
private String formatedDate2;
private String firstClubId;
private String secondClubId;
public Date getStartTime() {
	return startTime;
}
public void setStartTime(Date startTime) {
	this.startTime = startTime;
}
public Date getEndTime() {
	return endTime;
}
public void setEndTime(Date endTime) {
	this.endTime = endTime;
}
public String getFirstClubName() {
	return firstClubName;
}
public void setFirstClubName(String firstClubName) {
	this.firstClubName = firstClubName;
}
public String getSecondClubName() {
	return secondClubName;
}

public void setSecondClubName(String secondClubName) {
	this.secondClubName = secondClubName;
}

public Integer getStartHour() {
	return startHour;
}
public void setStartHour(Integer startHour) {
	this.startHour = startHour;
}
public Integer getStartMinute() {
	return startMinute;
}
public void setStartMinute(Integer startMinute) {
	this.startMinute = startMinute;
}
public Integer getEndHours() {
	return endHours;
}
public void setEndHours(Integer endHours) {
	this.endHours = endHours;
}
public Integer getEndMinute() {
	return endMinute;
}
public void setEndMinute(Integer endMinute) {
	this.endMinute = endMinute;
}
public String getFormatedDate() {
	return formatedDate;
}
public void setFormatedDate(String formatedDate) {
	this.formatedDate = formatedDate;
}

public String getFormatedDate1() {
	return formatedDate1;
}
public void setFormatedDate1(String formatedDate1) {
	this.formatedDate1 = formatedDate1;
}
public String getFormatedDate2() {
	return formatedDate2;
}
public void setFormatedDate2(String formatedDate2) {
	this.formatedDate2 = formatedDate2;
}

public String getFirstClubId() {
	return firstClubId;
}
public void setFirstClubId(String firstClubId) {
	this.firstClubId = firstClubId;
}
public String getSecondClubId() {
	return secondClubId;
}
public void setSecondClubId(String secondClubId) {
	this.secondClubId = secondClubId;
}
@Override
public int compareTo(Object arg0) {
	// TODO Auto-generated method stub
	MatchDetails matchDetail = (MatchDetails)arg0;
	if(this.startTime.compareTo(matchDetail.getStartTime())==0)
	{
		if(this.getFirstClubName().compareTo(matchDetail.getFirstClubName())== 0)
		{
			return this.getSecondClubName().compareTo(matchDetail.getSecondClubName());
		}
		return this.getFirstClubName().compareTo(matchDetail.getFirstClubName());
	}
	return this.startTime.compareTo(matchDetail.getStartTime());
}
}
