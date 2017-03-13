package com.sportmgmt.utility.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sportmgmt.model.manager.GameManager;

public class SortUtility {
	private ApplicationDataUtility applicationDataUtility;
	
	public ApplicationDataUtility getApplicationDataUtility() {
		return applicationDataUtility;
	}
	public void setApplicationDataUtility(ApplicationDataUtility applicationDataUtility) {
		this.applicationDataUtility = applicationDataUtility;
	}

	public ArrayList<Map<String,String>> sortPlayerListByPrice(List playerList)
	{
		Map playerPriceMap = GameManager.getPlayerPriceMap(applicationDataUtility.getGameClubPlayerIdList());
		
		ArrayList<Map<String,String>> sortedPlayerList = new ArrayList<Map<String,String>>(); 
		for(Object priceEntryObj:playerPriceMap.entrySet())
		{
			Map.Entry<String, String> priceEntry = (Map.Entry)priceEntryObj;
			for(Object playerListObj:playerList)
			{
				Map playerListMap = (Map)playerListObj;
				if(priceEntry.getKey().equals(playerListMap.get("gameClubPlayerId")))
				{
					playerListMap.put("price", priceEntry.getValue());
					sortedPlayerList.add(playerListMap);
					break;
				}
			}
		}
		return sortedPlayerList;
	}
	public ArrayList<Map<String,String>> sortPlayerListByUserCount(List playerList)
	{
		Map playerUserCountMap = GameManager.getGameClubPlayerWithUserCountMap(applicationDataUtility.getGameClubPlayerIdList());
		ArrayList<Map<String,String>> sortedPlayerList = new ArrayList<Map<String,String>>(); 
		for(Object userCountEntryObj:playerUserCountMap.entrySet())
		{
			Map.Entry<String, String> userCountEntry = (Map.Entry)userCountEntryObj;
			for(Object playerListObj:playerList)
			{
				Map playerListMap = (Map)playerListObj;
				if(userCountEntry.getKey().equals(playerListMap.get("gameClubPlayerId")))
				{
					playerListMap.put("userCount", userCountEntry.getValue());
					sortedPlayerList.add(playerListMap);
					break;
				}
			}
		}
		return sortedPlayerList;
	}
	public ArrayList<Map<String,String>> sortPlayerListByTotalPoint(List playerList)
	{
		Map playerTotalPointMap = GameManager.getPlayerTotalPointMap(applicationDataUtility.getGameClubPlayerIdList());
		ArrayList<Map<String,String>> sortedPlayerList = new ArrayList<Map<String,String>>(); 
		for(Object playerTotalPoinEntry:playerTotalPointMap.entrySet())
		{
			Map.Entry<String, String> totalPointEntry = (Map.Entry)playerTotalPoinEntry;
			for(Object playerListObj:playerList)
			{
				Map playerListMap = (Map)playerListObj;
				if(totalPointEntry.getKey().equals(playerListMap.get("gameClubPlayerId")))
				{
					playerListMap.put("totalScore", totalPointEntry.getValue());
					sortedPlayerList.add(playerListMap);
					break;
				}
			}
		}
		return sortedPlayerList;
	}
}
