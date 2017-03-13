package com.sportmgmt.model.manager;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sportmgmt.model.entity.Game;
import com.sportmgmt.model.entity.GameWeekReport;
import com.sportmgmt.model.entity.Match;
import com.sportmgmt.model.entity.UserGame;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

public class GameWeeKManager {
	private static Logger logger = Logger.getLogger(GameWeeKManager.class);
	private static String errorCode;
	private static String errorMessage;
	
	public static String getErrorCode() {
		return errorCode;
	}

	public static void setErrorCode(String errorCode) {
		GameWeeKManager.errorCode = errorCode;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		GameWeeKManager.errorMessage = errorMessage;
	}

	public static List<Match> getMatchesByGame(String gameId)
	{
		logger.info("----- Inside getMatchesByGame ---- gameId: "+gameId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Match> matchList = null;
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
				
					Game game = new Game();
					game.setGameId(new Integer(gameId));
					Query query	 = session.createQuery(QueryConstrant.SELECT_MATCH_BY_GAME);
					query.setParameter("game", game);
					logger.info("----------- Executing query to match list by game");
					matchList = query.list();
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching match list by game: "+ex);
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
		logger.info("----- Returning Match List  ---- : "+matchList);
		return matchList;
	}
	
	public static List<Integer> sortedGameWeekIds(String gameId)
	{
		logger.info("----- Inside sortedGameWeekIds ---- gameId: "+gameId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Integer> sortedGameWeekIds = null;
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
				
					SQLQuery query	 = session.createSQLQuery(QueryConstrant.FETCH_SORTED_GAME_WEEK);
					query.setParameter("gameId", new Integer(gameId));
					logger.info("----------- Executing query to match list by game");
					sortedGameWeekIds = query.list();
					logger.info("----- sortedGameWeekIds  ---- : "+sortedGameWeekIds);
					return sortedGameWeekIds;
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in sortedGameWeekIds: "+ex);
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
	
	public static Object[] fetchStartEndDate(String gameWeekId)
	{
		logger.info("----- Inside fetchStartEndDate ---- gameWeekId: "+gameWeekId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Object[]> startAndEndDateList = null;
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
				
					SQLQuery query	 = session.createSQLQuery(QueryConstrant.FETCH_START_AND_END_DATE_OF_GAME_WEEK);
					query.setParameter("gameWeekId", new Integer(gameWeekId));
					logger.info("----------- Executing query fetch start and end date of game week");
					startAndEndDateList = query.list();
					logger.info("----- startAndEndDateList  ---- : "+startAndEndDateList);
					if(startAndEndDateList !=null && !startAndEndDateList.isEmpty())
					{
						return startAndEndDateList.get(0);
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetchStartEndDate: "+ex);
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
	
	public static boolean isGameStarted(String gameId,List<Integer> sortedGameWeekIds)
	{
		Object[] startAndEndDate = fetchStartEndDate(sortedGameWeekIds.get(0).toString());
		logger.info("---------- startAndEndDate: "+startAndEndDate);
		if(startAndEndDate !=null)
		{
			Timestamp startDate = (Timestamp)startAndEndDate[0];
			if(System.currentTimeMillis() >  startDate.getTime())
			return true;
		}
	 return false;
	}
	public static Map<String,String> getGameWeekReport(String userId,String gameWeekId)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- getGameWeekReport ------------> userId:  "+userId+" gameWeekId: "+gameWeekId);
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
					Criteria cr = session.createCriteria(GameWeekReport.class);
					cr.add(Restrictions.eq("gameWeekId", new Integer(gameWeekId)));
					cr.add(Restrictions.eq("userId", new Integer(userId)));
					List<GameWeekReport> results = cr.list();
					if(results != null && !results.isEmpty())
					{
						logger.info(" ------- Enrty found in GameWeekReport table");
						GameWeekReport gameWeekReport = (GameWeekReport)results.get(0);
						Map<String,String> gameWeekReportMap = new HashMap<String,String>();
						gameWeekReportMap.put("rank", gameWeekReport.getRank().toString());
						gameWeekReportMap.put("point", gameWeekReport.getPoint().toString());
						gameWeekReportMap.put("finalPoint", gameWeekReport.getTotalPoint().toString());
						gameWeekReportMap.put("finalRank", gameWeekReport.getTotalRank().toString());
						if(gameWeekReport.getTransfer() !=null)
						gameWeekReportMap.put("transfer", gameWeekReport.getTransfer().toString());
						SQLQuery sqlQuery = session.createSQLQuery(QueryConstrant.SELECT_HIEGHEST_POINT_OF_GAME_WEEK);
						sqlQuery.setParameter("gameWeekId", gameWeekId);
						List<Integer> highetRankList = sqlQuery.list();
						if(highetRankList != null && !highetRankList.isEmpty())
						{
							gameWeekReportMap.put("heighestPoint", String.valueOf(highetRankList.get(0).intValue()));
						}
						
						sqlQuery = session.createSQLQuery(QueryConstrant.SELECT_AVERAGE_POINT_OF_GAME_WEEK);
						sqlQuery.setParameter("gameWeekId", gameWeekId);
						List<BigDecimal> averageRankList = sqlQuery.list();
						if(averageRankList != null && !averageRankList.isEmpty())
						{
							gameWeekReportMap.put("averagePoint", String.valueOf(averageRankList.get(0)));
						}
						logger.info("Returning userGameMap: "+gameWeekReportMap);
						return gameWeekReportMap;
					
					}
					else
					{
						logger.info(" ------- Enty not found in GAME_WEEK_REPORT table ");
					}
									}
				catch(Exception ex)
				{
					logger.error("Exception  getGameWeekReport: "+ex.getMessage());
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
	
	public static boolean createGameWeekReport(Integer userId,Integer gameWeekId,Integer point,Integer rank,Integer transfer)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- createGameWeekReport ------------> userId:  "+userId+" gameWeekId: "+gameWeekId);
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
					GameWeekReport gameWeekReport = new GameWeekReport();
					gameWeekReport.setUserId(userId);
					gameWeekReport.setGameWeekId(gameWeekId);
					if(point !=null)
					{
						gameWeekReport.setPoint(point);
					}
					if(rank !=null)
					{
						gameWeekReport.setRank(rank);
					}
					if(transfer !=null)
					{
						gameWeekReport.setTransfer(transfer);
					}
					logger.info("---------- making entry in game week report: ");
					session.save(gameWeekReport);
					session.beginTransaction().commit();
					logger.info("----------  committed game week report: ");
					return true;
				}
				catch(Exception ex)
				{
					logger.error("Exception  createGameWeekReport: "+ex.getMessage());
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
	
	public static boolean updateGameWeekReport(Integer userId,Integer gameWeekId,Integer point,Integer rank,Integer transfer)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- updateGameWeekReport ------------> userId:  "+userId+" gameWeekId: "+gameWeekId);
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
					Criteria cr = session.createCriteria(GameWeekReport.class);
					cr.add(Restrictions.eq("gameWeekId", gameWeekId));
					cr.add(Restrictions.eq("userId", userId));
					List<GameWeekReport> gameWeekReports = cr.list();
					if(gameWeekReports == null || gameWeekReports.isEmpty())
					{
						logger.info("Game week Report not found in database, going to make new entry");
						return createGameWeekReport(userId, gameWeekId, point, rank, transfer);
					}
					else
					{
						GameWeekReport gameWeekReport = gameWeekReports.get(0);
						if(point !=null)
						{
							gameWeekReport.setPoint(point);
						}
						if(rank !=null)
						{
							gameWeekReport.setRank(rank);
						}
						if(transfer !=null)
						{
							gameWeekReport.setTransfer(transfer);
						}
						logger.info("--------------- Updating Game week Report");
						session.update(gameWeekReport);
						session.beginTransaction().commit();
						logger.info("--------------- ");
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception  updateGameWeekReport: "+ex.getMessage());
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
	
	public static int updatePlayerTransfered(Integer userId,Integer gameWeekId)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- updatePlayerTransfered ------------> userId:  "+userId+" gameWeekId: "+gameWeekId);
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
					Criteria cr = session.createCriteria(GameWeekReport.class);
					cr.add(Restrictions.eq("gameWeekId", gameWeekId));
					cr.add(Restrictions.eq("userId", userId));
					List<GameWeekReport> gameWeekReports = cr.list();
					if(gameWeekReports == null || gameWeekReports.isEmpty())
					{
						logger.info("Game week Report not found in database, going to make new entry");
						boolean isGaneWeekReportCreated =createGameWeekReport(userId, gameWeekId, null, null, 1);
						if(isGaneWeekReportCreated)
						return 1;
					}
					else
					{
						GameWeekReport gameWeekReport = gameWeekReports.get(0);
						int playerTransfer = gameWeekReport.getTransfer()+1;
						gameWeekReport.setTransfer(playerTransfer);
						logger.info("--------------- Updating Game week Report");
						session.update(gameWeekReport);
						session.beginTransaction().commit();
						logger.info("--------------- Committed update");
						return playerTransfer;
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception  updatePlayerTransfered: "+ex.getMessage());
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
		return 0;
	}
}
