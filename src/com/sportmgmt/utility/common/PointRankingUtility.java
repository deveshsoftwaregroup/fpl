package com.sportmgmt.utility.common;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.sportmgmt.controller.bean.Player;
import com.sportmgmt.dreamEleven.model.entity.UserPlayer;
import com.sportmgmt.model.entity.GameClubPlayer;
import com.sportmgmt.model.entity.GameWeekPlayerReport;
import com.sportmgmt.model.entity.GameWeekReport;
import com.sportmgmt.model.entity.Point;
import com.sportmgmt.model.entity.UserGame;
import com.sportmgmt.model.entity.Club;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PlayerManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.utility.exception.SportMgmtException;

public class PointRankingUtility {
	private Logger logger = Logger.getLogger(PointRankingUtility.class);
	PropertyFileUtility  propFileUtility = new PropertyFileUtility();
	private ApplicationDataUtility applicationDataUtility;
	
	public ApplicationDataUtility getApplicationDataUtility() {
		return applicationDataUtility;
	}
	public void setApplicationDataUtility(ApplicationDataUtility applicationDataUtility) {
		this.applicationDataUtility = applicationDataUtility;
	}
	
	private String logMessage;
	
	private List<Player> topElevenPlayers;
	
	public List<Player> getTopElevenPlayers() {
		return topElevenPlayers;
	}
	public void setTopElevenPlayers(List<Player> topElevenPlayers) {
		this.topElevenPlayers = topElevenPlayers;
	}
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
		if(firstMatchOfGameWeek != null && firstMatchOfGameWeek.size() >0)
		 {
			Timestamp startTimeOfFirstMatch = firstMatchOfGameWeek.get(0);
			 int deadLineHrsBeforeStart = 0;
			 try
			 {
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
	private boolean isDreamEleven;
	
	public boolean isDreamEleven() {
		return isDreamEleven;
	}
	public void setDreamEleven(boolean isDreamEleven) {
		this.isDreamEleven = isDreamEleven;
	}
	public boolean createPlayerHistoryForGameWeek(String gameId,String gameWeekId,String userId) throws SportMgmtException
	{
		logMessage = "";
		boolean isSuccess = true;
		
		PlayerManager.setDreamEleven(isDreamEleven());
		
		if(PlayerManager.isGameWeekPlayerHistoryExist(userId, gameWeekId))
		{
			logger.info("Game Week Player Group history already found for user: "+userId+" and gameWeekId: "+gameWeekId);
			isSuccess = false;
		}
		else
		{
			List<Map<String,String>> userPlayersList = null;
			if(isDreamEleven())
			{
				userPlayersList = com.sportmgmt.dreamEleven.model.manager.GameManager.userPlayerDetailsList(new Integer(userId),Integer.valueOf(gameId));
			}
			else
			{
				userPlayersList = GameManager.userPlayerDetailsList(new Integer(userId),Integer.valueOf(gameId));
			}
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
			PlayerManager.setDreamEleven(isDreamEleven());
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
	public List<String> createPlayerHistoryForUsers(String gameId,String gameWeekId,String userId) throws SportMgmtException
	{
		if(gameWeekId !=null && !gameWeekId.equals(""))
		{
			PlayerManager.setDreamEleven(isDreamEleven());
			if(userId !=null)
			{
				List<String> logList = new ArrayList<String>();
				
				
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
	public List<Map<String,String>> getPointList(String gameId)
	{
		List<Point> pointObjList = PointRankManager.getMPointByGame(gameId);
		List<Map<String,String>> pointList = new ArrayList<Map<String,String>>();
		if(pointObjList != null)
		{
			for(Object pointObj:pointObjList)
			{
				Point point = (Point) pointObj;
				Map<String,String> map = new TreeMap<String,String>();
				map.put("pointId", point.getPointId().toString());
				map.put("pointName", "");
				map.put("pointDesc", "");
				map.put("pointToAdd", "");
				map.put("pointToDeduct", "");
				if(point.getPointName() !=null)
				map.put("pointName", point.getPointName());
				if(point.getPointDesc() != null)
				map.put("pointDesc", point.getPointDesc());
				if(point.getPointToAdd() !=null)
					//System.out.println("pointToAdd="+point.getPointToAdd().toString());
				map.put("pointToAdd", point.getPointToAdd().toString());
				if(point.getPointToDeduct() != null)
				map.put("pointToDeduct", point.getPointToDeduct().toString());
				//System.out.println("pointToDeduct="+point.getPointToDeduct().toString());
				pointList.add(map);
			}
		}
		
		return pointList;
	}
	
	public Map<Integer,Integer> getUserAndOderdGameWeeKPointMap(Integer gameWeeKId)
	{
		if(gameWeeKId !=null)
		{
			List<GameWeekReport>  gameWeekReportList = PointRankManager.getUserAndPointListOrderByPoint(gameWeeKId,SportConstrant.GAME_WEEK_POINT);
			if(gameWeekReportList !=null && !gameWeekReportList.isEmpty())
			{
				 Map<Integer,Integer> userAndPointMap = new LinkedHashMap<>();
				for(GameWeekReport gameWeekReport:gameWeekReportList)
				{
					userAndPointMap.put(gameWeekReport.getUserId(), gameWeekReport.getPoint());							
				}
				return userAndPointMap;
			}
		}
		return null;
	}
	
	public Map<Integer,Integer> getUserAndOderdGameWeeKTotalPointMap(Integer gameWeeKId)
	{
		if(gameWeeKId !=null)
		{
			List<GameWeekReport>  gameWeekReportList = PointRankManager.getUserAndPointListOrderByPoint(gameWeeKId,SportConstrant.GAME_WEEK_OVERALL_POINT);
			if(gameWeekReportList !=null && !gameWeekReportList.isEmpty())
			{
				 Map<Integer,Integer> userAndTotalPointMap = new LinkedHashMap<>();
				for(GameWeekReport gameWeekReport:gameWeekReportList)
				{
					userAndTotalPointMap.put(gameWeekReport.getUserId(), gameWeekReport.getTotalPoint());							
				}
				return userAndTotalPointMap;
			}
		}
		return null;
	}
	
	public Map<Integer,Integer> getUserAndOderdTotalPointMap(Integer gameId)
	{
		if(gameId !=null)
		{
			List<UserGame>  userGAmeList = PointRankManager.getUserGAmeForUserList(null,gameId,SportConstrant.USER_TOTAL_POINT);
			if(userGAmeList !=null && !userGAmeList.isEmpty())
			{
				 Map<Integer,Integer> userAndTotalPointMap = new LinkedHashMap<>();
				for(UserGame userGame:userGAmeList)
				{
					userAndTotalPointMap.put(userGame.getUserId(), userGame.getTotalPoint());							
				}
				return userAndTotalPointMap;
			}
		}
		return null;
	}
	
	public List<Integer> getGPlayerIdsOrderedByArg(Integer gameWeekId,String orderBy)
	{
		List<Player> players =getPlayersOrderedByArg(gameWeekId,orderBy,"updateRank");
		 if(players !=null && !players.isEmpty())
		 {
			 List<Integer> gameClubPlayerIds = new ArrayList<>();
			 for(Player player :players)
			 {
				 gameClubPlayerIds.add(player.getGameClubPlayerId());
				 
			 }
			 return gameClubPlayerIds;
		 }
		 
		return null;
	}
	public List<Player> getPlayersOrderedByArg(Integer gameWeekId,final String orderBy,String action)
	{
		List<Player> players  = null;
		List<GameWeekPlayerReport> gameWeekPlayersReport = PointRankManager.getGameWeekPlayersReportOrderByArgs(gameWeekId, orderBy);
		if(gameWeekPlayersReport !=null && !gameWeekPlayersReport.isEmpty())
		 {
			 players = new ArrayList<>();
			 for(GameWeekPlayerReport gameWeekPlayerReport :gameWeekPlayersReport)
			 {
				 Player player = new Player();
				 player.setGameClubPlayerId(gameWeekPlayerReport.getGameClubPlayer().getGameClubPlayerId());
				 player.setName(gameWeekPlayerReport.getGameClubPlayer().getPlayer().getPlayerName());
				 player.setType(gameWeekPlayerReport.getGameClubPlayer().getPlayingPosition());
				 player.setPoint(gameWeekPlayerReport.getPoint());
				 player.setTotalPoint(gameWeekPlayerReport.getTotalPoint());
				 player.setPrice(gameWeekPlayerReport.getGameClubPlayer().getPrice());
				 player.setClubId(gameWeekPlayerReport.getGameClubPlayer().getClub().getClubID() );
				 logger.info("------- Going to fetch user list who has been addded player: "+gameWeekPlayerReport.getGameClubPlayer().getClub().getClubID()+" in his team");
				 players.add(player);
				 
			 }
			 // this is to for updating rank in table first time
			 if(action !=null && action.equals("updateRank"))
			 {
				 Collections.sort(players, new java.util.Comparator<Player>()
				 {

					@Override
					public int compare(Player player1, Player player2) {
						// TODO Auto-generated method stub
						if((orderBy.equals("point") && player1.getPoint() == player2.getPoint()) || (orderBy.equals("totalPoint") && player1.getPoint() == player2.getPoint()))
						{
							try
							{
								List<UserPlayer> userListForPlayer1= PointRankManager.getDreamElevenUserListOfPlayer(player1.getGameClubPlayerId());
								List<UserPlayer> userListForPlayer2= PointRankManager.getDreamElevenUserListOfPlayer(player2.getGameClubPlayerId());
								if(userListForPlayer1 !=null && userListForPlayer2 !=null)
								{
									if(userListForPlayer1.size() > userListForPlayer2.size())
									return -1;
									else
									return 1;
								}
							}
							catch(Exception ex)
							{
								
							}
							
						}
						return 0;
					}
					 
				 }
				);

			 }
			 return players;
		 }
		 
		return null;
	}
	public List<Integer> getTopPlayerIdsOrderedByRankForGameWeek(List<Player> playersOrderedByRank)
	{
		if(playersOrderedByRank != null && !playersOrderedByRank.isEmpty())
		{
			List<Integer> topPlayesIdsByRank = new ArrayList<>();
			topElevenPlayers = new ArrayList<>();
			updateTopPlayerIds(playersOrderedByRank, topPlayesIdsByRank, "Goalkeeper", 1);
			updateTopPlayerIds(playersOrderedByRank, topPlayesIdsByRank, "Defender", 4);
			updateTopPlayerIds(playersOrderedByRank, topPlayesIdsByRank, "Midfielder", 3);
			updateTopPlayerIds(playersOrderedByRank, topPlayesIdsByRank, "Forward", 3);
			return topPlayesIdsByRank;
		}
		return null;
	}
	public List<Integer> getTopPlayerIdsOrderedByRankForGameWeek(Integer gameWeekId)
	{
		List<Player> playersOrderedByRank=getPlayersOrderedByArg(gameWeekId, "rank", "");
		return getTopPlayerIdsOrderedByRankForGameWeek(playersOrderedByRank);
	}
	private void updateTopPlayerIds(List<Player> playersOrderedByRank,List<Integer> topPlayesIdsByRank,String playerType,int totalPlayer)
	{
		int playerCount = 0;
		for(Player player:playersOrderedByRank)
		{
			if(totalPlayer <=playerCount)
			{
				return;
			}
			if(player.getType().equals(playerType))
			{
				topPlayesIdsByRank.add(player.getGameClubPlayerId());
				topElevenPlayers.add(player);
				playerCount++;
			}
		}
	}
	public int getTotalUserPlayerMatchInTopPlayer(List<Map<String,String>> gameWeekPlayerList,List<Integer> topPlayesIdsByRank)
	{
		int totalTopPlayerInUserAccount = 0;
		for(Map<String,String> playerMap:gameWeekPlayerList)
		{
			if(topPlayesIdsByRank.contains(new Integer(playerMap.get("gameClubPlayerId"))))
			{
				totalTopPlayerInUserAccount++;
			}
		}
		logger.info("----- total Match: "+totalTopPlayerInUserAccount);
		return totalTopPlayerInUserAccount;
	}
	
	public int calculateUserPoint(int totalUserPlayerMatchInTopPlayer)
	{
		int pointMultiplyer=0;
		try
		{
			pointMultiplyer = Integer.parseInt(propFileUtility.getEnvProperty().getString(SportConstrant.POINT_MULTIPLYER));
			logger.info("pointMultiplyer="+pointMultiplyer);
		}
		catch(Exception ex)
		 {
			 logger.error("Exception from reading and parsing : "+ex.getMessage());
		 }
		return totalUserPlayerMatchInTopPlayer * pointMultiplyer;
	}
	
	public int calculateUserPoint(List<Map<String,String>> gameWeekPlayerList,List<Integer> topPlayesIdsByRank)
	{
		int pointMultiplyer=0;
		try
		{
			pointMultiplyer = Integer.parseInt(propFileUtility.getEnvProperty().getString(SportConstrant.POINT_MULTIPLYER));
			logger.info("pointMultiplyer="+pointMultiplyer);
		}
		catch(Exception ex)
		 {
			 logger.error("Exception from reading and parsing : "+ex.getMessage());
		 }
		int totalTopPlayerInUserAccount =getTotalUserPlayerMatchInTopPlayer(gameWeekPlayerList, topPlayesIdsByRank);
		return totalTopPlayerInUserAccount * pointMultiplyer;
	}
	
}
