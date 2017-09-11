package com.sportmgmt.model.manager;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sportmgmt.dreamEleven.model.entity.UserPlayer;
import com.sportmgmt.model.entity.Game;
import com.sportmgmt.model.entity.GameClubPlayer;
import com.sportmgmt.model.entity.GameWeekPlayerReport;
import com.sportmgmt.model.entity.GameWeekReport;
import com.sportmgmt.model.entity.PlayerPoint;
import com.sportmgmt.model.entity.Point;
import com.sportmgmt.model.entity.UserGame;
import com.sportmgmt.model.entity.UserPoint;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.utility.exception.SportMgmtException;

public class PointRankManager {
	private static Logger logger = Logger.getLogger(PointRankManager.class);
	private static String errorCode;
	private static String errorMessage;
	
	public static String getErrorCode() {
		return errorCode;
	}

	public static void setErrorCode(String errorCode) {
		PointRankManager.errorCode = errorCode;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		PointRankManager.errorMessage = errorMessage;
	}

	public static List<Point> getMPointByGame(String gameId)
	{
		logger.info("----- Inside getMatchesByGame ---- gameId: "+gameId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Point> pointList = null;
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
				
					Query query	 = session.createQuery(QueryConstrant.SELECT_POINT_BY_GAME);
					query.setParameter("gameId", new Integer(gameId));
					logger.info("----------- Executing query to point list by game");
					pointList = query.list();
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching point list: "+ex);
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
		logger.info("----- Returning Match List  ---- : "+pointList);
		return pointList;
	}
	
	public static Integer getLastGameWeekId(String gameId)
	{
		logger.info("----- Inside getLastGameWeekId ---- gameId: "+gameId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List lastGameWeekIdList = null;
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return null;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_LAST_GAME_WEEK);
					query.setParameter("gameId", new Integer(gameId));
					query.setParameter("date", new Date(System.currentTimeMillis()));
					logger.info("----------- Executing query to point list by game");
					lastGameWeekIdList = query.list();
					logger.info("----- Returning last game week id  ---- : "+lastGameWeekIdList);
					if(lastGameWeekIdList !=null && !lastGameWeekIdList.isEmpty())
					return (Integer)lastGameWeekIdList.get(0);
					else
					return null;
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching last game week: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					return null;
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
				return null;
			}
		}
	}
	
	public static java.util.List<Integer> insertPlayerPoint(Integer gameId,Integer matchId,Integer gameClubPlayerId,Integer pointId)
	{
		logger.info("----- Inside insertPlayerPoint ---- gameId: "+gameId+", matchId: "+matchId+" , gameClubPlayerId: "+gameClubPlayerId+" , matchId: "+matchId+", pointId: "+pointId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		java.util.List<Integer> playerPointList = new java.util.ArrayList<Integer>();
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return null;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					PlayerPoint playerPoint = new PlayerPoint();
					Point point = (Point)session.load(Point.class, pointId);
					GameClubPlayer gameClubPlayer = (GameClubPlayer)session.load(GameClubPlayer.class, gameClubPlayerId);
					playerPoint.setPoint(point);
					playerPoint.setGameClubPlayer(gameClubPlayer);
					playerPoint.setDateOfArival(new java.sql.Timestamp(System.currentTimeMillis()));
					playerPoint.setGameId(gameId);
					playerPoint.setMatchId(matchId);
					session.save(playerPoint);
					logger.info("------------ inserting for player point");
					session.beginTransaction().commit();
					logger.info("------------ point for player is committed");
					playerPointList.add(playerPoint.getPlayerPointId());
					if(point.getPointToAdd() != null && point.getPointToAdd().intValue() !=0)
					{
						playerPointList.add(playerPoint.getPoint().getPointToAdd());
					}
					else if(point.getPointToDeduct() != null)
					{
						playerPointList.add(-(playerPoint.getPoint().getPointToAdd()));
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception insertPlayerPoint: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					return null;
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
				return null;
			}
		}
		return playerPointList;
	}
	
	public static List<Integer> getUserListOfPlayerByMatch(Integer gameClubPlayerId) throws SportMgmtException
	{
		logger.info("----- Inside getUserListOfPlayerByMatch ---- gameClubPlayerId: "+gameClubPlayerId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Integer> userList = null;
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return null;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_USER_LIST_OF_PLAYER);
					query.setParameter("gameClubPlayerId", gameClubPlayerId);
					logger.info("----------- Executing query get users list of player in match");
					userList = query.list();
					logger.info("----- Returning userIdList List  ---- : "+userList);
					return userList;
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching user list of player in match: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					new SportMgmtException(ex);
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
				return null;
			}
		}
		return null;
	}
	public static List<UserPlayer> getDreamElevenUserListOfPlayer(Integer gameClubPlayerId) throws SportMgmtException
	{
		logger.info("----- Inside getUserListOfPlayerByMatch ---- gameClubPlayerId: "+gameClubPlayerId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<UserPlayer> userList = null;
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return null;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					
					Criteria criteria = session.createCriteria(UserPlayer.class);
					criteria.add(Restrictions.eq("gameClubPlayerId", gameClubPlayerId));
					logger.info("----------- Executing query get users list of player in match");
					userList = criteria.list();
					logger.info("----- Returning userIdList List  ---- : "+userList);
					return userList;
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching user list of player in match: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					new SportMgmtException(ex);
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
				return null;
			}
		}
		return null;
	}
	public static boolean insertUsersPoint(Integer gameId,Integer matchId,List<Integer> userIdList,Integer playerPointId,Integer pointToUpdate) throws SportMgmtException
	{
		logger.info("----- Inside insertUsersPoint ---- gameId: "+gameId+" ,matchId: "+matchId+" ,userIdList:"+userIdList+" , playerPointId: "+playerPointId+" ,pointToUpdate: "+pointToUpdate);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		//Map<Integer,Integer> userIdAndCurrentPointMap =lastPointOfUsersByMatch(userIdList, matchId);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return false;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					PlayerPoint playerPoint = (PlayerPoint)session.load(PlayerPoint.class, playerPointId);
					for(Integer userIdTemp:userIdList)
					{
						UserPoint userPoint = new UserPoint();
						userPoint.setPlayerPoint(playerPoint);
						userPoint.setPointActivityTime(new java.sql.Timestamp(System.currentTimeMillis()));
						userPoint.setGameId(gameId);
						userPoint.setMatchId(matchId);
						userPoint.setUserId(userIdTemp);
						//userPoint.setCurrentPoint(userIdAndCurrentPointMap.get(userIdTemp)+pointToUpdate);
						Criteria cr = session.createCriteria(UserPoint.class);
						cr.add(Restrictions.eq("userId", userIdTemp));
						cr.add(Restrictions.eq("matchId", matchId));
						cr.addOrder(Order.desc("userPointId"));
						cr.setProjection(Projections.groupProperty("currentPoint"));
						//logger.info("Query: "+cr.);
						List<Integer> currentPointList = cr.list();
						Integer currentPoint = 0;
						if(currentPointList !=null && !currentPointList.isEmpty())
						{
							currentPoint = currentPointList.get(0);
						}
						logger.info("-------- current point for user: "+userIdTemp+" is: "+currentPoint);
						userPoint.setCurrentPoint(currentPoint+pointToUpdate);
						logger.info("---- saving user point for user: "+userIdTemp);
						session.save(userPoint);

					}
					logger.info("------- committing users point");
					session.beginTransaction().commit();
					return true;	
				}
				catch(Exception ex)
				{
					logger.error("Exception insertUsersPoint: "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					throw new SportMgmtException(ex);
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
				return false;
			}
		}
	}
	
	public static boolean updateGameWeekPointForUsers(Map<Integer,Integer> userIdAndPointMap ,Integer gameWeekId,Integer pointToUpdate) throws SportMgmtException
	{
		logger.info("----- Inside updateGameWeekPointForUsers ---- gameWeekId: "+gameWeekId+" ,userIdList:"+userIdAndPointMap+" ,pointToUpdate: "+pointToUpdate);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return false;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					for(Integer userId: userIdAndPointMap.keySet())
					{
						Criteria criteria = session.createCriteria(GameWeekReport.class);
						criteria.add(Restrictions.eq("gameWeekId", gameWeekId));
						criteria.add(Restrictions.eq("userId", userId));
						GameWeekReport gameWeekReport = (GameWeekReport)criteria.uniqueResult();
						if(gameWeekReport == null)
						{
							gameWeekReport = new GameWeekReport();
							gameWeekReport.setUserId(userId);
							gameWeekReport.setGameWeekId(gameWeekId);
							gameWeekReport.setPoint(0);
						}
						gameWeekReport.setPoint(gameWeekReport.getPoint()+pointToUpdate);
						gameWeekReport.setTotalPoint(userIdAndPointMap.get(userId));
						logger.info("----------- Updating game week point for users: "+userId);
						session.saveOrUpdate(gameWeekReport);
					}
					logger.info("---- commiting game week point for user");
					session.beginTransaction().commit();
					return true;
				}
				catch(Exception ex)
				{
					logger.error("Exception in updateGameWeekPointForUsers "+ex);
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					throw new SportMgmtException(ex);
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
	
	public static List<GameWeekReport> getUserAndPointListOrderByPoint(Integer gameWeekId,String orderBy)
	{
		logger.info("----- Inside getUserAndPointListOrderByPoint ---- gameWeekId: "+gameWeekId+", orderBy: "+orderBy);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return null;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					Criteria criteria = session.createCriteria(GameWeekReport.class);
					criteria.add(Restrictions.eq("gameWeekId",gameWeekId));
					//criteria.addOrder(Order.asc("contest"));
					criteria.addOrder(Order.desc(orderBy));
					List<GameWeekReport> gameWeekReportList= criteria.list();
					logger.info("---- Returning game week report list:"+gameWeekReportList);
					return gameWeekReportList;
				}
				catch(Exception ex)
				{
					logger.error("Exception in getUserAndPointListOrderByPoint "+ex);
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
	
	public static Map<Integer,Integer> updateUserTotalPointForUserList(List<Integer> userIdList,Integer gameId,Integer poinToUpdate) throws SportMgmtException
	{
		boolean isSuccess =  true;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- updateUserPointForUserList ------------> userIdList:  "+userIdList+" gameId: "+gameId+",poinToUpdate:"+poinToUpdate);
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
					Map<Integer,Integer> userIdAndPointMap = new HashMap<>();
					for(Integer userId:userIdList)
					{
						Criteria cr = session.createCriteria(UserGame.class);
						cr.add(Restrictions.eq("gameId",gameId));
						cr.add(Restrictions.eq("userId",userId));
						List results = cr.list();
						if(results == null || results.size() ==0)
						{
							logger.info(" ------- Enty not found in USER_GAME");
							logger.info(" ------- Making new Entry in USER_GAME table for user userid:"+userId);
							UserGame userGame = new UserGame();
							userGame.setUserId(userId);
							userGame.setGameId(gameId);
							userGame.setTotalPoint(poinToUpdate);
							userGame.setRank(0);
							userGame.setAddedPlayerCount(0);
							session.save(userGame);
							userIdAndPointMap.put(userId, poinToUpdate);
							
						}
						else
						{
							logger.info(" ------- Enty found in USER_GAME table ");
							UserGame userGame = (UserGame)results.get(0);
							int totalPoint = userGame.getTotalPoint()+poinToUpdate;
							userGame.setTotalPoint(totalPoint);
							logger.info(" ------- Updating user total point for user: "+userId);
							session.update(userGame);
							userIdAndPointMap.put(userId, totalPoint);
						}
					}
					logger.info("--------- Committing all insert and update----");
					session.beginTransaction().commit();
					logger.info("--------- Returning and userIdAndPointMap"+userIdAndPointMap);
					return userIdAndPointMap;
									}
				catch(Exception ex)
				{
					logger.error("Exception fetch updateUserPointForUserList: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					isSuccess = false;
					throw new SportMgmtException(ex);
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
		
		return null;
	}
	
	public static List<UserGame> getUserGAmeForUserList(List<Integer> userIdList,Integer gameId,String orderBy)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
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
					cr.add(Restrictions.eq("gameId",gameId));
					if(userIdList !=null && !userIdList.isEmpty())
					{
						cr.add(Restrictions.in("userId", userIdList));
					}
					if(orderBy != null && !orderBy.equals(""))
					{
						cr.addOrder(Order.desc(orderBy));
					}
					List<UserGame>  userGAmeList = cr.list();
					logger.info("--------- Returning user Game List: "+userGAmeList);
					return userGAmeList;
					
				}
				catch(Exception ex)
				{
					logger.error("Exception getUserGAmeForUserList: "+ex.getMessage());
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
		
		return null;
	}
	
	public static void updateRankForUser(Map<Integer,Integer> userAndTotalPointMap,Integer gameId) throws SportMgmtException
	{
		logger.info("----- Inside updateRankForUser ---- userAndTotalPointMap: "+userAndTotalPointMap+", gameId: "+gameId);
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
			try
			{
				Session session = factory.openSession();
				int rank=0;
				for(Integer userId:userAndTotalPointMap.keySet())
				{
					rank = rank+1;
					Criteria criteria = session.createCriteria(UserGame.class);
					criteria.add(Restrictions.eq("userId", userId));
					criteria.add(Restrictions.eq("gameId", gameId));
					UserGame userGame = (UserGame)criteria.uniqueResult();
					userGame.setRank(rank);
					session.save(userGame);
					
				}
				session.beginTransaction().commit();
				logger.info("Rank committed successfully:");
			}
			catch(Exception ex)
			{
				logger.error("Exception in updating rank for user: "+ex);
				throw new SportMgmtException(ex);
			}
			
		}
	}
	
	public static void updateRankOROverallRankForGameWeeK(Map<Integer,Integer> userAndGameWeeKPointOrTotalMap,Integer gameWeekId,String rankType) throws SportMgmtException
	{
		logger.info("----- Inside updateRankOROverallRankForGameWeeK ---- userAndGameWeeKPointOrTotalMap: "+userAndGameWeeKPointOrTotalMap+", gameWeekId: "+gameWeekId);
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
			try
			{
				Session session = factory.openSession();
				int rank=0;
				for(Integer userId:userAndGameWeeKPointOrTotalMap.keySet())
				{
					rank = rank+1;
					Criteria criteria = session.createCriteria(GameWeekReport.class);
					criteria.add(Restrictions.eq("userId", userId));
					criteria.add(Restrictions.eq("gameWeekId", gameWeekId));
					GameWeekReport gameWeekReport = (GameWeekReport)criteria.uniqueResult();
					if(rankType !=null && rankType.equals("rank"))
					{
						gameWeekReport.setRank(rank);
					}
					else if(rankType !=null && rankType.equals("totalRank"))
					{
						gameWeekReport.setTotalRank(rank);
					}
					
					session.save(gameWeekReport);
					
				}
				session.beginTransaction().commit();
				logger.info("Rank committed successfully:");
			}
			catch(Exception ex)
			{
				logger.error("Exception in updating rank for gameWeek: "+ex);
				throw new SportMgmtException(ex);
			}
			
		}
	}
	
	public static void updatePlayerTotalPoint(Integer gameClubPlayerId,Integer pointToUpdate) throws SportMgmtException
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- updatePlayerTotalPoint ------------> gameClubPlayerId:  "+gameClubPlayerId+" poinToUpdate: "+pointToUpdate);
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
					GameClubPlayer gameclubPlayer = (GameClubPlayer)session.load(GameClubPlayer.class, gameClubPlayerId);
					int totalPoint =pointToUpdate;
					if(gameclubPlayer.getPlayerTotalPoint() !=null)
					{
						totalPoint +=gameclubPlayer.getPlayerTotalPoint();
					}
					gameclubPlayer.setPlayerTotalPoint(totalPoint);
					session.update(gameclubPlayer);
					logger.info("--------- Committing player total point---- : "+totalPoint);
					session.beginTransaction().commit();
				}
				catch(Exception ex)
				{
					logger.error("Exception updatePlayerTotalPoint: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					throw new SportMgmtException(ex);
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
		
	}

	public static void updatePlayerPointAndTotalPointForGameWeek(Integer gameClubPlayerId,Integer pointToUpdate,Integer gameWeekId) throws SportMgmtException
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- updatePlayerPointAndTotalPointForGameWeek ------------> gameClubPlayerId:  "+gameClubPlayerId+" pointToUpdate: "+pointToUpdate+" ,gameWeekId: "+gameWeekId);
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
					
					GameClubPlayer gameClubPlayer = (GameClubPlayer)session.load(GameClubPlayer.class, gameClubPlayerId);
					Criteria criteria = session.createCriteria(GameWeekPlayerReport.class);
					criteria.add(Restrictions.eq("gameWeekId", gameWeekId));
					criteria.add(Restrictions.eq("gameClubPlayer", gameClubPlayer));
					GameWeekPlayerReport gameWeekPlayerReport = (GameWeekPlayerReport)criteria.uniqueResult();
					if(gameWeekPlayerReport == null)
					{
						logger.info("------------- GAme Week Player Report not found, going to create new player report for gameweek:");
						gameWeekPlayerReport = new GameWeekPlayerReport();
						gameWeekPlayerReport.setGameWeekId(gameWeekId);
						gameWeekPlayerReport.setGameClubPlayer(gameClubPlayer);
					}
					int gameWeekPoint = pointToUpdate;
					if(gameWeekPlayerReport.getPoint() !=null)
					{
						gameWeekPoint += gameWeekPlayerReport.getPoint();
					}
					gameWeekPlayerReport.setPoint(gameWeekPoint);
					gameWeekPlayerReport.setTotalPoint(gameClubPlayer.getPlayerTotalPoint());
					session.saveOrUpdate(gameWeekPlayerReport);
					logger.info("--------- Commiting point and total point for game week:");
					session.beginTransaction().commit();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch updatePlayerPointAndTotalPointForGameWeek: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					throw new SportMgmtException(ex);
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
	}
	
	public static List<GameWeekPlayerReport> getGameWeekPlayersReportOrderByArgs(Integer gameWeekId,String orderBy)
	{
		logger.info("----- Inside getGameWeekPlayersReportOrderByArgs ---- gameWeekId: "+gameWeekId+", orderBy: "+orderBy);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.info("----- Factory Object is null----");
			return null;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
				
					Criteria criteria = session.createCriteria(GameWeekPlayerReport.class);
					criteria.add(Restrictions.eq("gameWeekId",gameWeekId));
					//criteria.addOrder(Order.asc("contest"));
					if(orderBy.equals("rank") || orderBy.equals("totalRank"))
					criteria.addOrder(Order.asc(orderBy));
					else
					criteria.addOrder(Order.desc(orderBy));	
					List<GameWeekPlayerReport> gameWeekPlayerReportList= criteria.list();
					logger.info("---- Returning game week playerReportreport list:"+gameWeekPlayerReportList);
					return gameWeekPlayerReportList;
				}
				catch(Exception ex)
				{
					logger.error("Exception in getGameWeekOrderedPointForPlayers "+ex);
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
	
	public static List<GameClubPlayer> getGameClubPlayersOrderedByArgs(Integer gameId,String orderBy)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
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
					Criteria cr = session.createCriteria(GameClubPlayer.class);
					Game game = (Game)session.get(Game.class, gameId) ;
					cr.add(Restrictions.eq("game",game));
					if(orderBy != null && !orderBy.equals(""))
					{
						cr.addOrder(Order.desc(orderBy));
					}
					List<GameClubPlayer>  gameClubPlayerList = cr.list();
					logger.info("--------- Returning game club player listList: "+gameClubPlayerList);
					return gameClubPlayerList;
					
				}
				catch(Exception ex)
				{
					logger.error("Exception getGameClubPlayersOrderedByArgs: "+ex.getMessage());
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
		return null;
	}
	
	public static void updatePlayer_Rank_OverallRank_For_GameWeeK(List<Integer> gameClubPlayerIds,Integer gameWeekId,String rankType) throws SportMgmtException
	{
		logger.info("----- Inside updatePlayer_Rank_OverallRank_For_GameWeeK ---- gameClubPlayerIds: "+gameClubPlayerIds+", gameWeekId: "+gameWeekId+", rankType:"+rankType);
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
			try
			{
				Session session = factory.openSession();
				int rank=0;
				for(Integer gameClubPlayerId:gameClubPlayerIds)
				{
					rank = rank+1;
					Criteria criteria = session.createCriteria(GameWeekPlayerReport.class);
					GameClubPlayer gameClubPlayer = (GameClubPlayer) session.load(GameClubPlayer.class, gameClubPlayerId);
					criteria.add(Restrictions.eq("gameClubPlayer", gameClubPlayer));
					criteria.add(Restrictions.eq("gameWeekId", gameWeekId));
					GameWeekPlayerReport GameWeekPlayerReport = (GameWeekPlayerReport)criteria.uniqueResult();
					if(rankType !=null && rankType.equals(SportConstrant.GAME_WEEK_RANK))
					{
						GameWeekPlayerReport.setRank(rank);
					}
					else if(rankType !=null && rankType.equals(SportConstrant.GAME_WEEK_OVERALL_RANK))
					{
						GameWeekPlayerReport.setTotalRank(rank);
					}
					
					session.save(GameWeekPlayerReport);
					
				}
				session.beginTransaction().commit();
				logger.info("Rank committed successfully:");
			}
			catch(Exception ex)
			{
				logger.error("Exception in updating rank of player for gameWeek : "+ex);
				throw new SportMgmtException(ex);
			}
			
		}
	}
}
