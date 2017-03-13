package com.sportmgmt.utility.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmgmt.model.manager.GameManager;

public class ApplicationDataUtility {
Logger logger = Logger.getLogger(ApplicationDataUtility.class);
public ApplicationDataUtility()
{
	logger.info("--------- Data load utiliy");
	logger.info("--------- Calling game load");
	games = GameManager.fetchGames();
	logger.info("--------- Game list : "+games);
	playersList = new ArrayList();
	clubList = new ArrayList();
	if(games !=null && games.size() ==1)
	{
		String gameId = (String)((HashMap)games.get(0)).get("gameId");
		logger.info("-------- Calling to load players and clublist of gameId: "+gameId);
		if(gameId != null && !gameId.equals(""))
		{
			GameManager.updateClubListAndPlayersList(playersList, clubList, gameId);
			logger.info("---- playersList: "+playersList);
			logger.info("---- clubList: "+clubList);
			if(playersList !=null)
			{
				gameClubPlayerIdList = new ArrayList<Integer>();
				for(Object playerObj :playersList)
				{
					Map<String,String> playerMap = (Map<String,String>)playerObj;
					gameClubPlayerIdList.add(new Integer(playerMap.get("gameClubPlayerId")));
				}
			}
			logger.info("---- gameClubPlayerIdList: "+gameClubPlayerIdList);
			/* playerListJson = "";
			 clubListJson = "";
			 ObjectMapper mapperObj = new ObjectMapper();
			 try
			 {
								 
				 playerListJson = mapperObj.writeValueAsString(playersList);
				 logger.info("-------- loaded : playerListJson: "+playerListJson);
				 clubListJson = mapperObj.writeValueAsString(clubList);
				 logger.info("-------- loaded : clubListJson: "+clubListJson);
				 ;
			 }
			 catch(Exception ex)
			 {
				 logger.error("---------- Entry in parsing map to json: "+ex);
			 }
			*/

		}
	}
}

private ArrayList playersList;
private ArrayList clubList;
private List games;
private ArrayList<Integer> gameClubPlayerIdList;
/*private String playerListJson;
private String clubListJson;*/


public ArrayList getPlayersList() {
	return playersList;
}

public void setPlayersList(ArrayList playersList) {
	this.playersList = playersList;
}

public ArrayList getClubList() {
	return clubList;
}

public void setClubList(ArrayList clubList) {
	this.clubList = clubList;
}

public List getGames() {
	return games;
}

public void setGames(List games) {
	this.games = games;
}

private String msg;

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}
/*
public String getPlayerListJson() {
	return playerListJson;
}

public void setPlayerListJson(String playerListJson) {
	this.playerListJson = playerListJson;
}

public String getClubListJson() {
	return clubListJson;
}

public void setClubListJson(String clubListJson) {
	this.clubListJson = clubListJson;
}
*/

public ArrayList<Integer> getGameClubPlayerIdList() {
	return gameClubPlayerIdList;
}

public void setGameClubPlayerIdList(ArrayList<Integer> gameClubPlayerIdList) {
	this.gameClubPlayerIdList = gameClubPlayerIdList;
}


}
