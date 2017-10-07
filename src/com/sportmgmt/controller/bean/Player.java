package com.sportmgmt.controller.bean;

public class Player {
private Integer gameClubPlayerId;
private String name;
private double price;
private int point;
private int totalPoint;
private String type;
private int clubId;
public Integer getGameClubPlayerId() {
	return gameClubPlayerId;
}
public void setGameClubPlayerId(Integer gameClubPlayerId) {
	this.gameClubPlayerId = gameClubPlayerId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getPoint() {
	return point;
}
public void setPoint(int point) {
	this.point = point;
}
public int getTotalPoint() {
	return totalPoint;
}
public void setTotalPoint(int totalPoint) {
	this.totalPoint = totalPoint;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getClubId() {
	return clubId;
}
public void setClubId(int clubId) {
	 this.clubId = clubId;
}
public String toString()
{
	return "playerId: "+this.gameClubPlayerId+", playerName= "+this.name+", point = "+this.point+", price:"+price+", clubId:"+clubId;
}
}
