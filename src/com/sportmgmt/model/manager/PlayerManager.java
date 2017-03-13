package com.sportmgmt.model.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sportmgmt.model.entity.PlayerGroup;
import com.sportmgmt.model.entity.PlayerGroupPlayer;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

public class PlayerManager {
	private static Logger logger = Logger.getLogger(PlayerManager.class);
	private static String errorCode;
	private static String errorMessage;
	
	public static String getErrorCode() {
		return errorCode;
	}

	public static void setErrorCode(String errorCode) {
		PlayerManager.errorCode = errorCode;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		PlayerManager.errorMessage = errorMessage;
	}

	public static boolean createPlayerGroupWithPlayers(List<Map<String,String>> playerList,String userId,String gameWeekId)
	{
		logger.info("----- Inside createPlayerGroupWithPlayers ---- userId: "+userId+" ,:"+gameWeekId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					if(playerList !=null && playerList.size() !=0)
					{
						List<PlayerGroupPlayer> playerHistoryList = new ArrayList<PlayerGroupPlayer>();
						for(Map<String,String> playerMap:playerList)
						{
							PlayerGroupPlayer playerGroupPlayer = new PlayerGroupPlayer();
							playerGroupPlayer.setGameClubPlayerId(new Integer(playerMap.get("gameClubPlayerId")));
							playerGroupPlayer.setPlayerCategory(playerMap.get("playerCategory"));
							playerGroupPlayer.setSegNum(new Integer(playerMap.get("playerSeqNum")));
							playerGroupPlayer.setIsPlaying(playerMap.get("isPlaying"));
							playerHistoryList.add(playerGroupPlayer);
						}
						PlayerGroup playerGroup = new PlayerGroup();
						playerGroup.setUserId(new Integer(userId));
						playerGroup.setGameWeekId(new Integer(gameWeekId));
						playerGroup.setGroupType(SportConstrant.GAME_WEEK_HISTORY);
						playerGroup.setGroupName(userId+"|"+gameWeekId+"|"+SportConstrant.GAME_WEEK_HISTORY);
						playerGroup.setPlayerList(playerHistoryList);
						session.save(playerGroup);
						logger.info("---------- commiting player group player");
						session.beginTransaction().commit();
						return true;
					}
					
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in createPlayerGroupWithPlayers: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
				}
				finally
				{
					session.close();
				}
			}
			else
			{
				setErrorCode(ErrorConstrant.SESS_NULL);
				setErrorMessage("Technical Error");
				logger.info("----- Session Object is null----");
			}
		}
		return false;
	}
	
	public static boolean isGameWeekPlayerHistoryExist(String userId,String gameWeekId)
	{
		logger.info("----- Inside isGameWeekPlayerHistoryExist ---- userId: "+userId+" ,:"+gameWeekId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_GAME_WEEK_HISTORY_PLAYER_GROUP);
					query.setParameter("userId", new Integer(userId));
					query.setParameter("gameWeekId", new Integer(gameWeekId));
					List<Object[]> gameWeekPlayeGroupHistoryList =query.list();
					if(gameWeekPlayeGroupHistoryList !=null && gameWeekPlayeGroupHistoryList.size() !=0)
					return true;
				}
				catch(Exception ex)
				{
					logger.error("Exception in isGameWeekPlayerHistoryExist: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
				}
				finally
				{
					session.close();
				}
			}
			else
			{
				setErrorCode(ErrorConstrant.SESS_NULL);
				setErrorMessage("Technical Error");
				logger.info("----- Session Object is null----");
			}
		}
		return false;
	}
	
	public static List<Integer> userListOfGame(String gameId)
	{
		logger.info("----- Inside userListOfGame ---- gameId: "+gameId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_USERS_OF_GAME);
					query.setParameter("gameId", new Integer(gameId));
					List<Integer> userListOfGame =query.list();
					logger.info("Returing userListOfGame: "+userListOfGame);
					return userListOfGame;
				}
				catch(Exception ex)
				{
					logger.error("Exception in userListOfGame: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
				}
				finally
				{
					session.close();
				}
			}
			else
			{
				setErrorCode(ErrorConstrant.SESS_NULL);
				setErrorMessage("Technical Error");
				logger.info("----- Session Object is null----");
			}
		}
		return null;
	}
	
	public static List<Map<String,String>> gameWeekPlayerList(String userId,String gameWeekId)
	{
		logger.info("----- Inside gameWeekPlayerList ---- userId: "+userId+" ,:"+gameWeekId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Map<String,String>> gameWeekPlayerList;
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					Query query = session.createQuery(QueryConstrant.SELECT_PLAYER_GROUP);
					query.setParameter("gameWeekId", new Integer(gameWeekId));
					query.setParameter("userId", new Integer(userId));
					query.setParameter("groupType",SportConstrant.GAME_WEEK_HISTORY);
					List<PlayerGroup> playerGroupList =query.list();
					if(playerGroupList !=null && !playerGroupList.isEmpty())
					{
						gameWeekPlayerList = new ArrayList<>();
						PlayerGroup playerGroup = playerGroupList.get(0);
						List<PlayerGroupPlayer> playerGroPlrList = playerGroup.getPlayerList();
						if(playerGroPlrList !=null && !playerGroPlrList.isEmpty())
						{
							for(PlayerGroupPlayer playerGrpPlr:playerGroPlrList)
							{
								gameWeekPlayerList.add(getPlayerMap(playerGrpPlr));
							}
						}
						return gameWeekPlayerList;
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in gameWeekPlayerList: method "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
				}
				finally
				{
					session.close();
				}
			}
			else
			{
				setErrorCode(ErrorConstrant.SESS_NULL);
				setErrorMessage("Technical Error");
				logger.info("----- Session Object is null----");
			}
		}
		return null;
	}
	
	private static Map<String,String> getPlayerMap(PlayerGroupPlayer playerGrpPlr)
	{
		Map<String,String> player = new HashMap<>();
		player.put("gameClubPlayerId", playerGrpPlr.getGameClubPlayerId().toString());
		player.put("isPlaying", playerGrpPlr.getIsPlaying());
		player.put("playerCategory", playerGrpPlr.getPlayerCategory());
		player.put("playerSeq", playerGrpPlr.getSegNum().toString());
		return player;
	}
}
