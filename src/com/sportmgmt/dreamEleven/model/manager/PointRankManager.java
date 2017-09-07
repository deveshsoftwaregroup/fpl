package com.sportmgmt.dreamEleven.model.manager;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sportmgmt.model.entity.UserPoint;
import com.sportmgmt.model.entity.User;
import com.sportmgmt.model.entity.GameClubPlayer;
import com.sportmgmt.model.entity.GameWeekReport;
import com.sportmgmt.model.entity.PlayerPoint;
import com.sportmgmt.model.manager.HibernateSessionFactory;
import com.sportmgmt.model.entity.Point;
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
					logger.info("----- Returning Match List  ---- : "+lastGameWeekIdList);
					return (Integer)lastGameWeekIdList.get(0);
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
	
	public static boolean updateGameWeekPointForUsers(List<Integer> userIdList,Integer gameWeekId,Integer pointToUpdate) throws SportMgmtException
	{
		logger.info("----- Inside updateGameWeekPointForUsers ---- gameWeekId: "+gameWeekId+" ,userIdList:"+userIdList+" ,pointToUpdate: "+pointToUpdate);
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
					for(Integer userId: userIdList)
					{
						Criteria criteria = session.createCriteria(GameWeekReport.class);
						criteria.add(Restrictions.eq("gameWeekId", gameWeekId));
						criteria.add(Restrictions.eq("userId", userId));
						GameWeekReport gameWeekReport = (GameWeekReport)criteria.uniqueResult();
						gameWeekReport.setPoint(gameWeekReport.getPoint()+pointToUpdate);
						logger.info("----------- Updating game week point for users: "+userId);
						session.update(gameWeekReport);
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
	
	public static List<GameWeekReport> getUserAndPointListOrderByPoint(Integer gameWeekId)
	{
		logger.info("----- Inside getUserAndPointListOrderByPoint ---- gameWeekId: "+gameWeekId);
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
					criteria.addOrder(Order.desc("point"));
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
}
