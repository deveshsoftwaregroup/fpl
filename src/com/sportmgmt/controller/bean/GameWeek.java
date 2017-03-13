package com.sportmgmt.controller.bean;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class GameWeek implements Comparable{
private Date startDate;
private Date endDate;
private String gameWeekName;

private TreeMap<Integer,TreeSet<MatchDetails>> matchMap = new TreeMap<Integer,TreeSet<MatchDetails>>();

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public String getGameWeekName() {
	return gameWeekName;
}

public void setGameWeekName(String gameWeekName) {
	this.gameWeekName = gameWeekName;
}

public TreeMap<Integer, TreeSet<MatchDetails>> getMatchMap() {
	return matchMap;
}

public void setMatchMap(TreeMap<Integer, TreeSet<MatchDetails>> matchMap) {
	this.matchMap = matchMap;
}

@Override
public int compareTo(Object arg0) {
	// TODO Auto-generated method stub
	GameWeek gameWeek = (GameWeek)arg0;
	return this.startDate.compareTo(gameWeek.getStartDate());
}
@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.startDate.hashCode();
	}
@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof GameWeek)
		{
			GameWeek gameWeek = (GameWeek)obj;
			return this.startDate.equals(gameWeek.getStartDate());
		}
		else //if (obj instanceof java.sql.Date || obj instanceof java.util.Date)
		{
			java.util.Date startDate = (java.util.Date)obj;
			return this.startDate.equals(startDate);
		}
		
	}
}
