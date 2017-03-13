package com.sportmgmt.utility.common;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PlayerManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.utility.exception.SportMgmtException;

public class PointRankingUtility {
	private Logger logger = Logger.getLogger(PointRankingUtility.class);
	private ApplicationDataUtility applicationDataUtility;
	
	public ApplicationDataUtility getApplicationDataUtility() {
		return applicationDataUtility;
	}
	public void setApplicationDataUtility(ApplicationDataUtility applicationDataUtility) {
		this.applicationDataUtility = applicationDataUtility;
	}
	
	private String logMessage;
	
	public String getlogMessage()
	{
		return logMessage;
	}
	private Integer getCurrentGameWeek(String gameId)
	{
		Integer gameWeekId = null;
		List<Object[]> currentGameWeek = GameManager.fetchCurrenGametWeek(new Integer(gameId));
		if(currentGameWeek != null && currentGameWeek.size() > 0)
		 {
			 gameWeekId = (Integer)currentGameWeek.get(0)[0];
		 }
	 return gameWeekId;
	}
	
	private boolean isDeadlineStart(String gameWeekId)
	{
		List<Timestamp> firstMatchOfGameWeek = GameManager.fetchFirstMatchOfGameWeek(new Integer(gameWeekId));
		if(firstMatchOfGameWeek != null && firstMatchOfGameWeek.size() >=0)
		 {
			Timestamp startTimeOfFirstMatch = firstMatchOfGameWeek.get(0);
			 int deadLineHrsBeforeStart = 0;
			 try
			 {
				 PropertyFileUtility  propFileUtility = new PropertyFileUtility();
				 deadLineHrsBeforeStart = Integer.parseInt(propFileUtility.getEnvProperty().getString(SportConstrant.DEADLINE_START_HRS));
			 }
			 catch(Exception ex)
			 {
				 logger.error("Exception from reading and parsing : "+ex.getMessage());
			 }
			 
			 long startDeadlineMils = startTimeOfFirstMatch.getTime() - TimeUnit.HOURS.toMillis(deadLineHrsBeforeStart);
			 long currentTimeMils = System.currentTimeMillis();
			 logger.info("----------- startDeadlineMils: "+startDeadlineMils);
			 logger.info("----------- currentTimeMils: "+currentTimeMils);
			 if(currentTimeMils >= startDeadlineMils)
			 {
				 logger.info("----------- isUderDeadline: is true ");
				 return true;
			 }
		 }
		return false;
	}
	
	private String getLatestGameWeekId(String gameId)
	{
		Integer currentGameWeekId =getCurrentGameWeek(gameId);
		Integer lastGameWeekId = null; 
		if(currentGameWeekId == null || !isDeadlineStart(currentGameWeekId.toString()))
		{
			lastGameWeekId = getPreviousGameWeekId(gameId);
			if(lastGameWeekId !=null)
			{
				return lastGameWeekId.toString();
			}
		}
		else
		{
			return currentGameWeekId.toString();
		}
		return null;
	}
	
	private Integer getPreviousGameWeekId(String gameId)
	{
		return PointRankManager.getLastGameWeekId(gameId);
	}
	
	private boolean createPlayerHistoryForGameWeek(String gameId,String gameWeekId,String userId) throws SportMgmtException
	{
		logMessage = "";
		boolean isSuccess = true;
		if(PlayerManager.isGameWeekPlayerHistoryExist(userId, gameWeekId))
		{
			logger.info("Game Week Player Group history already found for user: "+userId+" and gameWeekId: "+gameWeekId);
		}
		else
		{
			List<Map<String,String>> userPlayersList = GameManager.userPlayerDetailsList(new Integer(userId),Integer.valueOf(gameId));
			if(userPlayersList != null && userPlayersList.size() !=0)
			{
				isSuccess = PlayerManager.createPlayerGroupWithPlayers(userPlayersList, userId, gameWeekId);
			}
			else
			{
				logger.info("player list of user is empty userId: "+userId);
				logMessage = "Failed to load player list for userId:"+userId;
				isSuccess = false;				
			}
		}
		
		return isSuccess;
	}
	
	public List<String> createPlayerHistoryForUsers(String gameId) throws SportMgmtException
	{
		try
		{
			String gameWeekId =getLatestGameWeekId(gameId);
			return createPlayerHistoryForUsers(gameId,gameWeekId);
			
		}
		catch(Exception ex)
		{
			logger.error(ex);
			throw new SportMgmtException(ex);
		}
	}
	
	public List<String> createPlayerHistoryForUsers(String gameId,String gameWeekId) throws SportMgmtException
	{
		if(gameWeekId !=null && !gameWeekId.equals(""))
		{
			List<Integer> userListOfGame = PlayerManager.userListOfGame(gameId);
			if(userListOfGame !=null && userListOfGame.size() !=0)
			{
				List<String> logList = new ArrayList<String>();
				for(Integer userIdBigInt:userListOfGame)
				{
					String userId = String.valueOf(userIdBigInt.intValue());
					logger.info("Going to create player history of user: "+userId+" for gameWeekId: "+gameWeekId+" of gameId: "+gameId);
					boolean isSuccess = createPlayerHistoryForGameWeek(gameId,gameWeekId,userId);
					logger.info("player history creation went :"+isSuccess);
					if(!isSuccess)
					{
						if(!logMessage.equals(""))
						{
							logList.add(logMessage);
						}
						else
						{
							logList.add("Failed userId="+userId+" gameWeekId="+gameWeekId);
						}
					}
					
				}
				return logList;
			}
			else
			{
				logger.info("User List for game: "+gameId+" is empty");
				throw new SportMgmtException("User List for game: "+gameId+" is empty");
			}
	    }
		else
		{
			logger.info("skiping to create player history of users, becuase of game week id is empty:");
			throw new SportMgmtException("game week id is empty");
		}
	}
	public Map<String,String> getGameWeekForPointView(String gameId, String gameWeekIdParam,String direction)
	{
		Map<String,String> gameWeekForPoint = new HashMap<>();
		gameWeekForPoint.put("isLatestGameWeek", SportConstrant.NO);
		String latestGameWeekId = getLatestGameWeekId(gameId);
		if(latestGameWeekId != null && !latestGameWeekId.equals(""))
		{
			List<Integer> sortedGameWeekIds = GameWeeKManager.sortedGameWeekIds(gameId);
			if(sortedGameWeekIds !=null && !sortedGameWeekIds.isEmpty())
			{
				if(gameWeekIdParam == null || gameWeekIdParam.equals(""))
				{
					gameWeekForPoint.put("isLatestGameWeek", SportConstrant.YES);
					gameWeekForPoint.put("gameWeekId", latestGameWeekId);
					int gameWeekNumber = 0;
					for(Integer gameWeekId:sortedGameWeekIds)
					{
						if(latestGameWeekId.equals(gameWeekId.toString()))
						{
							gameWeekForPoint.put("gameWeekNumber", String.valueOf(gameWeekNumber+1));
							break;
						}
						gameWeekNumber++;
					}
				}
				else
				{
					int gameWeekNumber = 0;
					for(Integer gameWeekId:sortedGameWeekIds)
					{
						if(gameWeekIdParam.equals(gameWeekId.toString()))
						{
							if(direction.equals(SportConstrant.PREVIOUS))
							{
								gameWeekForPoint.put("gameWeekId", sortedGameWeekIds.get(gameWeekNumber-1).toString());
								gameWeekForPoint.put("gameWeekNumber", String.valueOf(gameWeekNumber));
								break;
							}
							else if(direction.equals(SportConstrant.NEXT))
							{
								gameWeekForPoint.put("gameWeekId", sortedGameWeekIds.get(gameWeekNumber+1).toString());
								gameWeekForPoint.put("gameWeekNumber", String.valueOf(gameWeekNumber+2));
							}
							if(gameWeekForPoint.get("gameWeekId").equals(latestGameWeekId))
							{
								gameWeekForPoint.put("isLatestGameWeek", SportConstrant.YES);
							}
							break;
						}
						gameWeekNumber++;
					}
		
				}
							
			}
		}
		
		return gameWeekForPoint;
	}
	
	
	public String gameWeekIdForTransferPlayer(String gameId)
	{
		List<Integer> sortedGameWeekIds  = GameWeeKManager.sortedGameWeekIds(gameId);
		logger.info("--------- sortedGameWeekIds: "+sortedGameWeekIds);
		if(sortedGameWeekIds !=null && !sortedGameWeekIds.isEmpty())
		{
			boolean isGameStarted = GameWeeKManager.isGameStarted(gameId, sortedGameWeekIds);
			logger.info("-------- isGameStarted: "+isGameStarted);
			if(isGameStarted)
			{
				Integer currentGameWeekId = getCurrentGameWeek(gameId);
				logger.info("-------- Current Game Week ID: "+currentGameWeekId);
				if(currentGameWeekId != null)
				{
					boolean isDeadlineStart = isDeadlineStart(currentGameWeekId.toString());
					logger.info(" ---- deadline start for current game Week: "+isDeadlineStart);
					String gameWeekId = currentGameWeekId.toString();
					if(isDeadlineStart)
					{
						gameWeekId = getNextGameWeekId(sortedGameWeekIds,gameWeekId);
					}
					return gameWeekId;
				}
			}
		}
		return null;
	}
	private String getNextGameWeekId(List<Integer> sortedGameWeekIds,String currentGameWeekId)
	{
		int index = 0;
		if(sortedGameWeekIds.get(sortedGameWeekIds.size()-1).toString().equals(currentGameWeekId))
		{
			logger.info("--------- Current game week is already last game week of game , last Game Week ID: "+sortedGameWeekIds.get(sortedGameWeekIds.size()-1));
			return null;
		}
		for(Integer gameWeekIdTemp:sortedGameWeekIds)
		{
			if(gameWeekIdTemp.toString().equals(currentGameWeekId.toString()))
			{
				return sortedGameWeekIds.get(index+1).toString();
			}
			index++;
		}
		return null;
	}
	private void createPlayerHistoryForGame()
	{
		List gameList =applicationDataUtility.getGames();
		for(int i=0; i< gameList.size();i++)
		{
			String gameId = (String)((HashMap)gameList.get(i)).get("gameId");
			logger.info("Going to create player history for gameId: "+gameId);
			//createPlayerHistoryForUsers(gameId);
		}
		
	}
}
