package com.sportmgmt.model.manager;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sportmgmt.model.entity.Club;
import com.sportmgmt.model.entity.Game;
import com.sportmgmt.model.entity.GameClubPlayer;
import com.sportmgmt.model.entity.Player;
import com.sportmgmt.model.entity.UserGame;
import com.sportmgmt.model.entity.UserPlayer;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

public class GameManager {
	private static Logger logger = Logger.getLogger(GameManager.class);
	private static String errorCode;
	private static String errorMessage;
	public static String getErrorCode() {
		return errorCode;
	}
	public static void setErrorCode(String errorCode) {
		GameManager.errorCode = errorCode;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
	public static void setErrorMessage(String errorMessage) {
		GameManager.errorMessage = errorMessage;
	}
	public static List<Game>fetchActiveGames()
	{
		List<Game> gameList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchActiveGameList -------------");
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					Query query	 = session.createQuery(QueryConstrant.SELECT_ACTIVE_GAME);
					query.setParameter("isActive", SportConstrant.YES);
					gameList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch active event list: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning game List -------------"+gameList);
		return gameList;
	}
	public static List fetchGames()
	{
		logger.info("--------------- fetchGames: ---"); 
		List<Game> gameListObj = fetchActiveGames();
		ArrayList gamelist = new ArrayList();
		if(gameListObj != null && gameListObj.size() > 0)
		{
			Iterator gameListItr = gameListObj.iterator();
			while(gameListItr.hasNext())
			{
				Game game = (Game)gameListItr.next();
				HashMap gameMap = new HashMap();
				gameMap.put("gameId", String.valueOf(game.getGameId()));
				gameMap.put("gameName", game.getGameName());
				gameMap.put("gameDesc", "");
				gameMap.put("totalClub", 0);
				gameMap.put("totalPlayer", 0);
				gameMap.put("startDate", "");
				gameMap.put("endDate", "");
				if(game.getGameDesc() !=null)
				{
					gameMap.put("gameDesc", game.getGameDesc());
				}
				if(game.getTotalClub() != null)
				{
					gameMap.put("totalClub", game.getTotalClub());
				}
				if(game.getTotaPlyers() != null)
				{
					gameMap.put("totalPlayer", game.getTotaPlyers());
				}
				if(game.getStartDate() != null)
				{
					gameMap.put("startDate", game.getStartDate().toString());
				}
				if(game.getEndDate() != null)
				{
					gameMap.put("endDate", game.getEndDate().toString());
				}
				gamelist.add(gameMap);
			}
		}
		logger.info("--------------- Returning game List ---: "+gamelist); 
		return gamelist;
	}

	public static List<GameClubPlayer> fetchGameClubPlayers(Integer gameId)
	{
		List<GameClubPlayer> gameClubPlayersList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchGamePlayers -------------");
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_PLAYERS_CLUBD_OF_EVENT);
					query.addEntity(GameClubPlayer.class);
					query.setParameter("gameId", gameId);
					gameClubPlayersList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch gameClubPlayer: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning gameClubPlayersList: -------------"+gameClubPlayersList);
		return gameClubPlayersList;
	}
	
	public static boolean isGameExistAndActive(String gameId)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- isGameExist -------------gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					Game game = (Game)session.load(Game.class, new Integer(gameId));
					return game.getIsActive().equals(SportConstrant.YES);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch isGameExist: "+ex.getMessage());
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
			}
		}
		return false;
	}
	
	public static void updateClubListAndPlayersList(List playersList, List clubList,String gameId)
	{
		logger.info("--------------- updateClubListAndPlayersList: ---gameId: "+gameId); 
		List<GameClubPlayer> gameClubPlayersList = fetchGameClubPlayers(Integer.parseInt(gameId));
		
		if(gameClubPlayersList != null && gameClubPlayersList.size() > 0)
		{
			logger.info("--------Started Updating Club List---: "+clubList); 
			logger.info("--------------- Started Updating Player List ---: "+playersList);
			Iterator gameClubPlayerItr = gameClubPlayersList.iterator();
			while(gameClubPlayerItr.hasNext())
			{
				GameClubPlayer gameClubPlayer = (GameClubPlayer)gameClubPlayerItr.next();
				Player player = gameClubPlayer.getPlayer();
				Club club = gameClubPlayer.getClub();
				HashMap playerMap = null;
				HashMap clubMap = null;
				if(player != null)
				{
					playerMap = new HashMap();
					
					playerMap.put("gameClubPlayerId", gameClubPlayer.getGameClubPlayerId().toString());
					
					playerMap.put("playerId", player.getPlayerId().toString());
					
					playerMap.put("type", "");
					if(gameClubPlayer.getPlayingPosition() != null)
					playerMap.put("type", gameClubPlayer.getPlayingPosition());
					
					playerMap.put("bestPostion", "");
					if(player.getBestPosition() !=null)
					playerMap.put("bestPostion", player.getBestPosition());
								
					playerMap.put("price", 0);
					if(gameClubPlayer.getPrice() !=null)
					playerMap.put("price", gameClubPlayer.getPrice());
					
					playerMap.put("currency", "");
					if(gameClubPlayer.getPriceCurrency() != null)
					playerMap.put("currency", gameClubPlayer.getPriceCurrency());
					
					playerMap.put("totalPoint", 0);
					if(gameClubPlayer.getPlayerTotalPoint()!=null)
					playerMap.put("totalPoint", gameClubPlayer.getPlayerTotalPoint());
					
					playerMap.put("name", player.getPlayerName());
					
					playerMap.put("status", "");
					if(player.getStatus() != null)
					playerMap.put("status", player.getStatus());
					
					playerMap.put("worldRanking", 0);
					if(player.getWorldRanking() !=null)
					playerMap.put("worldRanking", player.getWorldRanking());
					
					playerMap.put("highestScore", 0);
					if(player.getHeighetScore() !=null)
					playerMap.put("highestScore", player.getHeighetScore());
					
					playerMap.put("totalScore", 0);
					if(player.getTotalScore() !=null)
					playerMap.put("totalScore", player.getTotalScore());
					
				}
				if(club != null)
				{
					clubMap = new HashMap();
					clubMap.put("clubId", club.getClubID().toString());
					clubMap.put("name", club.getClubName());
					if(playerMap != null)
					{
						playerMap.put("clubId", club.getClubID().toString());
						playerMap.put("clubName", club.getClubName());
					}
					
					clubMap.put("desc", "");
					if(club.getClubDesc() != null)
					clubMap.put("desc", club.getClubDesc());
					
					clubMap.put("createdDate", "");
					if(club.getCreatedDate() != null)
					clubMap.put("createdDate", club.getCreatedDate().toString());
					
					clubMap.put("logoPath", "");
					if(club.getClubLogoPath() != null)
					clubMap.put("logoPath", club.getClubLogoPath());
					
				}
				if(playerMap !=null)
				{
					playersList.add(playerMap);
				}
				if(clubMap != null)
				{
					boolean isClubExist = false;
					for(Object tempClubObj:clubList)
					{
						if(((HashMap)tempClubObj).get("clubId").equals(clubMap.get("clubId")))
							isClubExist = true;
					}
					if(!isClubExist)
					clubList.add(clubMap);
				}
			}
		
		}
		logger.info("-------- Updated Club List ---: "+clubList); 
		logger.info("--------------- Updated Player List ---: "+playersList);
	}
	public static List<String> fetchUserPlayersList(Integer userId, Integer gameId)
	{
		List<String> userPlayersList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- userPlayersList ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_USER_PLAYER_LIST);
					query.setParameter("userId", userId);
					query.setParameter("gameId", gameId);
					userPlayersList =(List<String>)query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch userPlayersList: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user Player List: -------------"+userPlayersList);
		return userPlayersList;
	}
	public static List<Object[]> fetchUserPlayersDetailsList(Integer userId, Integer gameId)
	{
		List<Object[]> userPlayersList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchUserPlayersDetailsList ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_USER_PLAYER_DETAIL_LIST);
					query.setParameter("userId", userId);
					query.setParameter("gameId", gameId);
					userPlayersList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch userPlayersList: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user Player List: -------------"+userPlayersList);
		return userPlayersList;
	}
	public static List<Object[]> fetchTotalPlayerByPostion(Integer userId, Integer gameId)
	{
		List<Object[]> totalPlayerByPisitionList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchTotalPlayerByPostion ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_TOTAL_PLAYER_BY_POSITION);
					query.setParameter("userId", userId);
					query.setParameter("gameId", gameId);
					totalPlayerByPisitionList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch fetchTotalPlayerByPostion: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user totalPlayerByPisitionList: -------------"+totalPlayerByPisitionList);
		return totalPlayerByPisitionList;
	}
	
	public static List<Object[]> fetchTotalPayingPlayerByPostion(Integer userId, Integer gameId)
	{
		List<Object[]> totalPlayerByPisitionList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchTotalPayingPlayerByPostion ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_TOTAL_PLAYING_PLAYER_BY_POSITION);
					query.setParameter("userId", userId);
					query.setParameter("gameId", gameId);
					query.setParameter("isPlaying", SportConstrant.YES);
					totalPlayerByPisitionList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch fetchTotalPayingPlayerByPostion: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user fetchTotalPayingPlayerByPostion: -------------"+totalPlayerByPisitionList);
		return totalPlayerByPisitionList;
	}
	
	public static List<Object[]> fetchCountOfPlayersByUser(List gameClubPlayerIdList)
	{
		List<Object[]> countOfPlayerByUser = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchCountOfPlayersByUser ------------> gameClubPlayerList:  "+gameClubPlayerIdList);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_COUNT_OF_PLAYER_BY_USER);
					query.setParameterList("gameClubPlayerIdList", gameClubPlayerIdList);
					countOfPlayerByUser =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchCountOfPlayersByUser"+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user countOfPlayerByUser: -------------"+countOfPlayerByUser);
		return countOfPlayerByUser;
	}
	
	public static BigInteger fetchTotalUserOfGame()
	{
		List totalUserOfGame = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchTotalUserOfGame ------------ ");
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_TOTAL_USER_FOR_GAME);
					totalUserOfGame =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchTotalUserOfGame = "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user countOfPlayerByUser: -------------"+totalUserOfGame);
		return (BigInteger)totalUserOfGame.get(0);
	}
	public static List<Object[]> fetchPlayerWithPrice(List gameClubPlayerIdList)
	{
		List<Object[]> playerWithPriceList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchPlayerWithPrice ------------> gameClubPlayerList:  "+gameClubPlayerIdList);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_PLAYER_WITH_PRICE_IN_ORDER);
					query.setParameterList("gameClubPlayerIdList", gameClubPlayerIdList);
					playerWithPriceList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPlayerWithPrice"+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user playerWithPriceList: -------------"+playerWithPriceList);
		return playerWithPriceList;
	}
	public static List<Object[]> fetchPlayerWithTotalPoint(List gameClubPlayerIdList)
	{
		List<Object[]> playerWithTotalPointList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchPlayerWithTotalPoint ------------> gameClubPlayerList:  "+gameClubPlayerIdList);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_PLAYER_WITH_TOTAL_POINT_IN_ORDER);
					query.setParameterList("gameClubPlayerIdList", gameClubPlayerIdList);
					playerWithTotalPointList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPlayerWithTotalPoint"+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user playerWithTotalPointList: -------------"+playerWithTotalPointList);
		return playerWithTotalPointList;
	}
	public static int totalPlayersOfUserByGame(Integer userId, Integer gameId)
	{
		int totalPlayers = 0;
		List<Object> totalPlayerFetchList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- totalPlayersOfUserByEvent ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_USER_TOTAL_PLAYER);
					query.setParameter("userId", userId);
					query.setParameter("gameId", gameId);
					totalPlayerFetchList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch totalPlayersOfUserByEvent: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user totalPlayerFetchList: -------------"+totalPlayerFetchList);
		if(totalPlayerFetchList !=null && totalPlayerFetchList.size() >=0 && totalPlayerFetchList.get(0) !=null)
		{
			totalPlayers = ((java.math.BigInteger)totalPlayerFetchList.get(0)).intValue();
		}
		return totalPlayers;
	}
	public static int totalPlayingPlayersOfUserByGame(Integer userId, Integer gameId)
	{
		int totalPlyingPlayers = 0;
		List<Object> totalPlayingPlayerFetchList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- totalPlayingPlayersOfUserByGame ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_USER_TOTAL_ACTIVE_PLAYER);
					query.setParameter("userId", userId);
					query.setParameter("gameId", gameId);
					query.setParameter("isPlaying", SportConstrant.YES);
					totalPlayingPlayerFetchList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch totalPlayersOfUserByEvent: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user totalPlayingPlayerFetchList: -------------"+totalPlayingPlayerFetchList);
		if(totalPlayingPlayerFetchList !=null && totalPlayingPlayerFetchList.size() >=0 && totalPlayingPlayerFetchList.get(0) !=null)
		{
			totalPlyingPlayers = ((java.math.BigInteger)totalPlayingPlayerFetchList.get(0)).intValue();
		}
		return totalPlyingPlayers;
	}
	public static double totalPlayersPriceOfUserByGame(Integer userId, Integer gameId)
	{
		double totalPlayersPrice = 0;
		List<Object> totalPlayerPriceFetchList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- totalPlayersPriceOfUserByGame ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_USER_PLAYER_TOTAL_PRICE);
					query.setParameter("userId", userId);
					query.setParameter("gameId", gameId);
					totalPlayerPriceFetchList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch totalPlayersPriceOfUserByEvent: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning user totalPlayerPriceFetchList: -------------"+totalPlayerPriceFetchList);
		if(totalPlayerPriceFetchList !=null && totalPlayerPriceFetchList.size() >=0)
		{
			if(totalPlayerPriceFetchList.get(0) != null)
			{
				totalPlayersPrice = ((java.math.BigDecimal)totalPlayerPriceFetchList.get(0)).doubleValue();
			}
				
		}
		return totalPlayersPrice;
	}
	
	public static void updateTotalPlayerByPostion(Integer userId, Integer gameId,Map totalMap)
	{
		logger.info("---------- Inside updateTotalPlayerByPostion: ");
		List<Object[]> totalPlayerByPisitionList = fetchTotalPlayerByPostion(userId,gameId);
		totalMap.put(SportConstrant.MID_PLAYER, 0);
		totalMap.put(SportConstrant.FORE_PLAYER, 0);
		totalMap.put(SportConstrant.DEFENDER, 0);
		totalMap.put(SportConstrant.GOAL_KEEPER, 0);
		if(totalPlayerByPisitionList != null && totalPlayerByPisitionList.size() >0)
		{
			logger.info("---------- Started updating totalMap -------- ");
			for(Object[] row:totalPlayerByPisitionList)
			{
				totalMap.put(row[0], row[1]);
			}
		}
		else
		{
			logger.info("------------ no update found due to totalPlayerByPisitionList is empty ");
			
		}
		
	}
	public static void updateTotalPlayingPlayerByPostion(Integer userId, Integer gameId,Map totalPlayingMap)
	{
		logger.info("---------- Inside updateTotalPlayingPlayerByPostion: ");
		List<Object[]> totalPlayerByPisitionList = fetchTotalPayingPlayerByPostion(userId,gameId);
		totalPlayingMap.put(SportConstrant.MID_PLAYER, 0);
		totalPlayingMap.put(SportConstrant.FORE_PLAYER, 0);
		totalPlayingMap.put(SportConstrant.DEFENDER, 0);
		totalPlayingMap.put(SportConstrant.GOAL_KEEPER, 0);
		totalPlayingMap.put(SportConstrant.PLAYER, 0);
		if(totalPlayerByPisitionList != null && totalPlayerByPisitionList.size() >0)
		{
			int totalPlayer = 0;
			logger.info("---------- Started updating totalMap -------- ");
			for(Object[] row:totalPlayerByPisitionList)
			{
				totalPlayingMap.put(row[0], row[1]);
				totalPlayer += ((BigInteger)row[1]).intValue();
			}
			totalPlayingMap.put(SportConstrant.PLAYER, totalPlayer);
			
		}
		else
		{
			logger.info("------------ no update found due to updateTotalPlayingPlayerByPostion is empty ");
			
		}
		
	}
	public static Map<String,Integer>  getGameClubPlayerWithUserCountMap(List gameClubPlayerIdList)
	{
		logger.info("---------- Inside getGameClubPlayerWithUserCountMap: ");
		List<Object[]> countOfPlayerByUser = fetchCountOfPlayersByUser(gameClubPlayerIdList);
		int totalUserOfGame = fetchTotalUserOfGame().intValue();
		Map<String,Integer> gameClubPlayerWithUserCountMap = new LinkedHashMap<String,Integer>();
		for(Object[] row:countOfPlayerByUser)
		{
			int countPercentage = (((BigInteger)row[1]).intValue()*100)/totalUserOfGame;
			//gameClubPlayerWithUserCountMap.put(row[0].toString(), ((BigInteger)row[1]).intValue());
			gameClubPlayerWithUserCountMap.put(row[0].toString(), countPercentage);
			//logger.info("-------Inside loop--- gameClubPlayerWithUserCountMap: "+gameClubPlayerWithUserCountMap);
		}
		Map<String,Integer> playerUserSelectedByPercentageMap = new LinkedHashMap<String,Integer>();
		for(Object gameClubPlayerIdObj:gameClubPlayerIdList)
		{
			if(!gameClubPlayerWithUserCountMap.containsKey(gameClubPlayerIdObj.toString()))
			{
				playerUserSelectedByPercentageMap.put(gameClubPlayerIdObj.toString(), 0);
			}
				
		}
		playerUserSelectedByPercentageMap.putAll(gameClubPlayerWithUserCountMap);
		//logger.info("--------1--- gameClubPlayerWithUserCountMap: "+gameClubPlayerWithUserCountMap);
			
	logger.info("------2----- playerUserSelectedByPercentageMap: "+playerUserSelectedByPercentageMap);	
	return playerUserSelectedByPercentageMap;
	}
	
	public static Map<String,Integer>  getPlayerPriceMap(List gameClubPlayerIdList)
	{
		logger.info("---------- Inside getPlayerPriceMap: ");
		List<Object[]> playerWithPriceList = fetchPlayerWithPrice(gameClubPlayerIdList);
		Map<String,Integer> playerPriceMap = new LinkedHashMap<String,Integer>();
		
		for(Object[] row:playerWithPriceList)
		{
			playerPriceMap.put(row[0].toString(), (Integer)row[1]);
		}
		for(Object gameClubPlayerIdObj:gameClubPlayerIdList)
		{
			if(!playerPriceMap.containsKey(gameClubPlayerIdObj.toString()))
			{
				playerPriceMap.put(gameClubPlayerIdObj.toString(), 0);
			}
				
		}	
	logger.info("----------- playerPriceMap: "+playerPriceMap);	
	return playerPriceMap;
	}
	
	public static Map<String,Integer>  getPlayerTotalPointMap(List gameClubPlayerIdList)
	{
		logger.info("---------- Inside getPlayerTotalPointMap: ");
		List<Object[]> playerWithTotalPointList = fetchPlayerWithTotalPoint(gameClubPlayerIdList);
		Map<String,Integer> playerTotalPointMap = new LinkedHashMap<String,Integer>();
		
		for(Object[] row:playerWithTotalPointList)
		{
			playerTotalPointMap.put(row[0].toString(), (Integer)row[1]);
		}
		for(Object gameClubPlayerIdObj:gameClubPlayerIdList)
		{
			if(!playerTotalPointMap.containsKey(gameClubPlayerIdObj.toString()))
			{
				playerTotalPointMap.put(gameClubPlayerIdObj.toString(), 0);
			}
				
		}	
	logger.info("----------- playerTotalPointMap: "+playerTotalPointMap);	
	return playerTotalPointMap;
	}
	
	public static List<Map<String,String>> userPlayerDetailsList(Integer userId, Integer gameId)
	{
		logger.info("---------- Inside userPlayerDetailsList userId: "+userId+" , gameId: "+gameId);
		List<Map<String,String>> userPlayDetailsList = new ArrayList<Map<String,String>>();
		List<Object[]> userPlayerDetailListObj = fetchUserPlayersDetailsList(userId,gameId);
		if(userPlayerDetailListObj != null && userPlayerDetailListObj.size() >0)
		{
			logger.info("---------- Started updating totalMap -------- ");
			for(Object[] row:userPlayerDetailListObj)
			{
				Map<String,String> userPlayerDetail = new HashMap<String,String>();
				userPlayerDetail.put("gameClubPlayerId", row[0].toString());
				userPlayerDetail.put("playerType", row[1].toString());
				userPlayerDetail.put("isPlaying", row[2].toString());
				userPlayerDetail.put("playerCategory", row[4].toString());
				userPlayerDetail.put("playerSeqNum", row[5].toString());
				userPlayDetailsList.add(userPlayerDetail);
			}
		}
		else
		{
			logger.info("------------ userPlayerDetailListObj is empty ");
		}
		return userPlayDetailsList;
	}
	public static boolean addPlayeOfGametToUserAccount(String userId,String gameClubPlayerId)
	{
		boolean isAdded =  false;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- addPlayeOfGametToUserAccount ------------> userId:  "+userId+" gameClubPlayerId: "+gameClubPlayerId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Criteria cr = session.createCriteria(UserPlayer.class);
					cr.add(Restrictions.eq("gameClubPlayerId", new Integer(gameClubPlayerId)));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						UserPlayer userPlayer = new UserPlayer();
						userPlayer.setGameClubPlayerId(new Integer(gameClubPlayerId)); 
						userPlayer.setUserId(new Integer(userId));
						userPlayer.setIsPlaying(SportConstrant.NO);
						userPlayer.setPlayerCategory(SportConstrant.PLAYER_TYPE_NORMAL);
						userPlayer.setSegNum(0);
						session.save(userPlayer);
						session.beginTransaction().commit();
						isAdded = true;
					}
					else
					{
						logger.info(" ------- Player is already asssociated with user ");
						setErrorMessage("Player is already added");
						setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch addPlayeOfEventToUserAccount: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.DUPLICATE_ENTRY);
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
			}
		}
		
		return isAdded;
	}
	
	public static boolean removePlayeOfGameFromUserAccount(String userId,String gameClubPlayerId)
	{
		boolean isRemoved =  false;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- removePlayeOfGameFromUserAccount ------------> userId:  "+userId+" gameClubPlayerId: "+gameClubPlayerId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Criteria cr = session.createCriteria(UserPlayer.class);
					cr.add(Restrictions.eq("gameClubPlayerId", new Integer(gameClubPlayerId)));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- Player is not found to remove ");
						setErrorMessage("Player is  not associated with user");
						setErrorCode(ErrorConstrant.RECORD_NOT_FOUND);
					}
					else
					{
						UserPlayer userPlayer = (UserPlayer)results.get(0);
						session.delete(userPlayer);
						session.beginTransaction().commit();
						isRemoved = true;
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch totalPlayersOfUserByEvent: "+ex.getMessage());
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
			}
		}
		
		return isRemoved;
	}
	public static boolean updatePlayeOfGameFromUserAccount(String userId,String gameClubPlayerId,String isPlaying,String playerCategory,String seqNum)
	{
		boolean isUpdated =  false;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- updatePlayeOfGameFromUserAccount ------------> userId:  "+userId+" gameClubPlayerId: "+gameClubPlayerId+" ,isPlaying: "+isPlaying+" , playerCategory: "+playerCategory+" , seqNum: "+seqNum);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Criteria cr = session.createCriteria(UserPlayer.class);
					cr.add(Restrictions.eq("gameClubPlayerId", new Integer(gameClubPlayerId)));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- Player is not found to update ");
						setErrorMessage("Player is  not associated with user");
						setErrorCode(ErrorConstrant.RECORD_NOT_FOUND);
					}
					else
					{
						UserPlayer userPlayer = (UserPlayer)results.get(0);
						if(isPlaying != null && !isPlaying.equals(""))
						{
							userPlayer.setIsPlaying(isPlaying.toUpperCase());
							if(isPlaying.toUpperCase().equals(SportConstrant.NO))
							{
								userPlayer.setPlayerCategory(SportConstrant.PLAYER_TYPE_NORMAL);
							}
						}
						
						if(playerCategory != null && !playerCategory.equals(""))
						userPlayer.setPlayerCategory(playerCategory);
						if(seqNum !=null && !seqNum.equals(""))
						userPlayer.setSegNum(Integer.valueOf(seqNum));
						//session.save(userPlayer);
						session.beginTransaction().commit();
						isUpdated = true;
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch update Player: "+ex.getMessage());
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
			}
		}
		
		return isUpdated;
	}
	public static List<Integer> fetchUserPlayerOfGameByType(String userId,String playerCategory)
	{
		List<Integer> results = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchUserPlayerOfGameByType ------------> userId:  "+userId+" playerCategory: "+playerCategory);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Criteria cr = session.createCriteria(UserPlayer.class);
					cr.add(Restrictions.eq("playerCategory", playerCategory));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					cr.setProjection(Projections.property("gameClubPlayerId"));
					results= cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- Player is not found  ");
						setErrorMessage("Player not found");
						setErrorCode(ErrorConstrant.RECORD_NOT_FOUND);
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch Player: "+ex.getMessage());
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
			}
		}
		logger.info("----------- REturning player: "+results);
		return results;
	}
	public static boolean checkAndIsertUserGameStatus(String userId,String gameId)
	{
		boolean isSuccess =  true;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- checkAndIsertUserGameStatus ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			isSuccess =false;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Criteria cr = session.createCriteria(UserGame.class);
					cr.add(Restrictions.eq("gameId", new Integer(gameId)));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- Enty not found in UserGameStatus");
						logger.info(" ------- Making new Entry in USER_GAME table for user and game");
						UserGame userGame = new UserGame();
						userGame.setUserId(new Integer(userId));
						userGame.setGameId(new Integer(gameId));
						userGame.setTotalPoint(0);
						userGame.setRank(0);
						userGame.setAddedPlayerCount(0);
						session.save(userGame);
						session.beginTransaction().commit();
					}
					else
					{
						logger.info(" ------- Enty found in USER_GAME_STATUS table ");
					}
									}
				catch(Exception ex)
				{
					logger.error("Exception fetch checkAndIsertUserGameStatus: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					isSuccess = false;
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
				isSuccess = false;
			}
		}
		
		return isSuccess;
	}
	public static Map<String,String> getUserGameStatus(String userId,String gameId)
	{
		Map<String,String> userGameMap = new HashMap<String,String>();
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- getUserGameStatus ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Criteria cr = session.createCriteria(UserGame.class);
					cr.add(Restrictions.eq("gameId", new Integer(gameId)));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					List results = cr.list();
					if(results != null && results.size() !=0)
					{
						logger.info(" ------- Enrty found in UserGameStatus");
						UserGame userGame = (UserGame)results.get(0);
						if(userGame.getTotalPoint() !=null && !userGame.getTotalPoint().equals(""))
						userGameMap.put("point", userGame.getTotalPoint().toString());
						else
						userGameMap.put("point", "0");
						
						if(userGame.getRank() !=null && !userGame.getRank().equals("") )
						userGameMap.put("rank", userGame.getRank().toString());
						else
						userGameMap.put("rank", "0");
						
						if(userGame.getTeamName() !=null)
						userGameMap.put("teamName", userGame.getTeamName());
						else
						userGameMap.put("teamName", "");
						
						if(userGame.getFavoriteClub() !=null)
						{
							userGameMap.put("favoriteClubId", userGame.getFavoriteClub().getClubID().toString());
							userGameMap.put("favoriteClubName", userGame.getFavoriteClub().getClubName());
						}
						else
						{
							userGameMap.put("favoriteClubId", "");
							userGameMap.put("favoriteClubName", "");
						}
						
						if(userGame.getFavoritePlayer() !=null)
						{
							userGameMap.put("favoritePlayerId", userGame.getFavoritePlayer().getPlayerId().toString());
							userGameMap.put("favoritePlayerName", userGame.getFavoritePlayer().getPlayerName());
						}
						else
						{
							userGameMap.put("favoritePlayerId", "");
							userGameMap.put("favoritePlayerName", "");
						}
					
					}
					else
					{
						logger.info(" ------- Enty not found in USER_GAME table ");
					}
									}
				catch(Exception ex)
				{
					logger.error("Exception  getUserGameStatus: "+ex.getMessage());
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
			}
		}
		logger.info("Returning userGameMap: "+userGameMap);
		return userGameMap;
	}
	public static int increaseAddedPlayerCountToUserGame(String userId,String gameId)
	{
		boolean isSuccess =  true;
		int addedPlayerCount = 0;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- increaseAddedPlayerCountToUserGame ------------> userId:  "+userId+" gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			isSuccess =false;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Criteria cr = session.createCriteria(UserGame.class);
					cr.add(Restrictions.eq("gameId", new Integer(gameId)));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- Enty not found in UserGameStatus");
						logger.info("-- User Team is still not completed---");
					}
					else
					{
						logger.info(" ------- Enty found in USER_GAME_STATUS table ");
						UserGame userGame = (UserGame)results.get(1);
						userGame.setAddedPlayerCount(userGame.getAddedPlayerCount()+1);	
						addedPlayerCount = userGame.getAddedPlayerCount();
						//session.save(userGame);
						session.beginTransaction().commit();
						logger.info(" ------- Increasing Added Player Count is done ");
					}
									}
				catch(Exception ex)
				{
					logger.error("Exception fetch increaseAddedPlayerCountToUserGame: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					isSuccess = false;
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
				isSuccess = false;
			}
		}
		return addedPlayerCount;
	}
	public static List<Object[]> fetchCurrenGametWeek(Integer gameId)
	{
		List<Object[]> currentGameWeek = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchCurrenGametWeek ------------> gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.FETCH_CURRENT_GAME_WEEK);
					query.setParameter("gameId", gameId);
					query.setParameter("date", new Date(System.currentTimeMillis()));
					currentGameWeek =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch CurrenGametWeek: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning currentGameWeek: -------------"+currentGameWeek);
		return currentGameWeek;
	}
	public static List<Object[]> fetchStartGametWeek(Integer gameId)
	{
		List<Object[]> startGameWeek = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchStartGametWeek ------------> gameId: "+gameId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.FETCH_START_GAME_WEEK);
					query.setParameter("gameId", gameId);
					query.setParameter("date", new Date(System.currentTimeMillis()));
					startGameWeek =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch startGameWeek: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning startGameWeek: -------------"+startGameWeek);
		return startGameWeek;
	}
	public static List<Timestamp> fetchFirstMatchOfGameWeek(Integer gameWeekId)
	{
		List<Timestamp> firstMatchOfGameWeek = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchFirstMatchOfGameWeek ------------> gameWeekId: "+gameWeekId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.FETCH_START_MATCH_TIME_OF_GAME_WEEK);
					query.setParameter("gameWeekId", gameWeekId);
					firstMatchOfGameWeek =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch firstMatchOfGameWeek: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning firstMatchOfGameWeek: -------------"+firstMatchOfGameWeek);
		return firstMatchOfGameWeek;
	}
	public static List<Timestamp> lastFirstMatchOfGameWeek(Integer gameWeekId)
	{
		List<Timestamp> lastMatchOfGameWeek = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- lastFirstMatchOfGameWeek ------------> gameWeekId: "+gameWeekId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.FETCH_END_MATCH_TIME_OF_GAME_WEEK);
					query.setParameter("gameWeekId", gameWeekId);
					lastMatchOfGameWeek =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch lastMatchOfGameWeek: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning lastMatchOfGameWeek: -------------"+lastMatchOfGameWeek);
		return lastMatchOfGameWeek;
	}
	public static int getGameWeekNumber(Integer gameWeekId,Integer gameId)
	{
		List<Integer> gameWeekList = null;
		int gameWeekNumber = 0;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- getGameWeekNumber ------------> gameWeekId: "+gameWeekId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					//SQLQuery query = session.createSQLQuery("select gcp.game_club_player_id from game_club_player gcp, user_player up where gcp.game_club_player_id = up.game_club_player_id and up.user_id =20 and gcp.game_id =1");
					SQLQuery query = session.createSQLQuery(QueryConstrant.FETCH_SORTED_GAME_WEEK);
					query.setParameter("gameId", gameId);
					gameWeekList =query.list();
					if(gameWeekList != null && gameWeekList.size() > 0)
					{
						int count = 1;
						for(Integer tempGameWeekId:gameWeekList)
						{
							if(tempGameWeekId == gameWeekId)
							{
								gameWeekNumber = count;
							}
							count++;
						}
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch getGameWeekNumber: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning gameWeekNumber: -------------"+gameWeekNumber);
		return gameWeekNumber;
	}
	public static List<Timestamp> fetchEndDateListOfGameWeekFromToday()
	{
		List<Timestamp> endDateListOfGameWeekFromToday = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchEndDateListOfGameWeekFromToday ------------>");
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.FETCH_END_DATE_LIST_OF_GAME_WEEK_FROM_TODAY);
					query.setParameter("date", new Date(System.currentTimeMillis()));
					endDateListOfGameWeekFromToday =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch fetchEndDateListOfGameWeekFromToday: "+ex.getMessage());
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
			}
		}
		logger.info("--------------- Returning endDateListOfGameWeekFromToday: -------------"+endDateListOfGameWeekFromToday);
		return endDateListOfGameWeekFromToday;
	}
}
