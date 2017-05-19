package com.sportmgmt.model.manager;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sportmgmt.model.entity.Coupon;
import com.sportmgmt.model.entity.CouponCategory;
import com.sportmgmt.model.entity.UsedCoupon;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

public class CouponManager {
	private static Logger logger = Logger.getLogger(CouponManager.class);
	private static String errorCode;
	private static String errorMessage;
	
	public static String getErrorCode() {
		return errorCode;
	}

	public static void setErrorCode(String errorCode) {
		CouponManager.errorCode = errorCode;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		CouponManager.errorMessage = errorMessage;
	}
	public static Integer getNumberOfCouponLimitForUser(String gameId,String gameWeekId, String userId)
	{
		logger.info("----- Inside getNumberOfCouponLimitForUser ---- gameId: "+gameId+", gameWeekId: "+gameWeekId+", userId: "+userId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Integer> numberOfCouponsList = null;
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
				
					Query query	 = session.createSQLQuery(QueryConstrant.SELECT_TOTAL_LIMIT_OF_OFFER);
					query.setParameter("gameId", new Integer(gameId));
					query.setParameter("userId", new Integer(userId));
					query.setParameter("gameWeekId", new Integer(gameWeekId));
					query.setParameter("offerType", SportConstrant.WEEKLY_COUPON);
					logger.info("----------- Executing query weekly coupon limits");
					numberOfCouponsList = query.list();
					if(numberOfCouponsList !=null && !numberOfCouponsList.isEmpty())
					{
						logger.info("----- Returning total limit of weekly Coupon  ---- : "+numberOfCouponsList.get(0));
						return numberOfCouponsList.get(0);
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching coupon limits for user: "+ex);
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

	public static CouponCategory getCouponCategory(Integer userPoint)
	{
		logger.info("----- Inside getCouponCategory ---- userPoint: "+userPoint);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<CouponCategory> couponCategoryList = null;
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
					Criteria criteria = session.createCriteria(CouponCategory.class);
					criteria.add(Restrictions.eq("isActive", SportConstrant.YES));
					criteria.add(Restrictions.eq("type", SportConstrant.WEEKLY_COUPON));
					criteria.add(Restrictions.le("minPoint", userPoint));
					criteria.add(Restrictions.ge("maxPoint", userPoint));
					logger.info("----------- Executing query to fetch coupon category");
					couponCategoryList = criteria.list();
					if(!couponCategoryList.isEmpty())
					{
						logger.info("----- Returning coupon category  ---- : "+couponCategoryList.get(0));
						return couponCategoryList.get(0);
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching coupon categories for user: "+ex);
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
		logger.info("----- Returning coupon category null ---- : ");
		return null;
	}
	public static List<Coupon> getCouponByCategoryAndVendor(Integer couponCategoryId,String vendor)
	{
		logger.info("----- Inside getCouponByCategoryAndVendor ---- couponCategoryId: "+couponCategoryId+", vendor Name: "+vendor);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Coupon> couponList = null;
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
					Criteria criteria = session.createCriteria(Coupon.class);
					criteria.add(Restrictions.eq("isActive", SportConstrant.YES));
					//criteria.add(Restrictions.eq("type", SportConstrant.WEEKLY_COUPON));
					criteria.add(Restrictions.le("couponCategoryId", couponCategoryId));
					criteria.add(Restrictions.ge("vendor", vendor));
					logger.info("----------- Executing query to fetch coupon list");
					couponList = criteria.list();
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching coupon list for user: "+ex);
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
		logger.info("----- Returning coupon list  ---- : "+couponList);
		return couponList;
	}
	
	public static Map<Integer,Integer> getTotalUsedForCouponList(String gameWeekId,List<Integer> couponList)
	{
		logger.info("----- Inside getTotalUsedForCouponList ---- gameWeekId: "+gameWeekId+", couponList: "+couponList);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		Map<Integer,Integer> couponIdAndTotalUsedMap = new HashMap<Integer,Integer>();
		List<Object[]> couponAndTotalUsedList = null;
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
				
					Query query	 = session.createSQLQuery(QueryConstrant.SELECT_TOTAL_USED_OF_COUPON_LIST);
					query.setParameter("gameWeekId", new Integer(gameWeekId));
					query.setParameter("couponList", couponList);
					logger.info("----------- Executing query to get total used of coupon for coupon list");
					couponAndTotalUsedList = query.list();
					if(couponAndTotalUsedList !=null && !couponAndTotalUsedList.isEmpty())
					{
						for(Object[] record:couponAndTotalUsedList)
						{
							couponIdAndTotalUsedMap.put((Integer)record[0], ((BigInteger)record[1]).intValue());
						}
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in getTotalUsedForCouponList: "+ex);
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
		logger.info("----- Returning map of coupon List with total used  ---- : "+couponIdAndTotalUsedMap);
		return couponIdAndTotalUsedMap;
	}
	
	public static Integer getTotalUsedOfCouponForGameWeek(String gameWeekId,Integer couponId)
	{
		logger.info("----- Inside getTotalUsedOfCouponForGameWeek ---- gameWeekId: "+gameWeekId+", couponId: "+couponId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Integer> totalUsedCouponList = null;
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
				
					Query query	 = session.createSQLQuery(QueryConstrant.SELECT_TOTAL_USED_OF_COUPON_FOR_GAME_WEEK);
					query.setParameter("gameWeekId", new Integer(gameWeekId));
					query.setParameter("couponId", couponId);
					logger.info("----------- Executing query to get total used of coupon for gameweek");
					totalUsedCouponList = query.list();
					if(totalUsedCouponList !=null && !totalUsedCouponList.isEmpty())
					{
						logger.info("------ returning total used coupon "+totalUsedCouponList.get(0));
						return totalUsedCouponList.get(0);
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in getTotalUsedOfCouponForGameWeek: "+ex);
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
	
	public static Integer getTotalUsedCouponByUserForGameWeek(String gameWeekId,Integer userId)
	{
		logger.info("----- Inside getTotalUsedCouponByUserForGameWeek ---- gameWeekId: "+gameWeekId+", userId: "+userId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List<Integer> totalUsedCouponByUser = null;
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
				
					Query query	 = session.createSQLQuery(QueryConstrant.SELECT_TOTAL_USED_COUPON_BY_USER_FOR_GAME_WEEK);
					query.setParameter("gameWeekId", new Integer(gameWeekId));
					query.setParameter("userId", userId);
					logger.info("----------- Executing query to get total used coupon by user for gameweek");
					totalUsedCouponByUser = query.list();
					if(totalUsedCouponByUser !=null && !totalUsedCouponByUser.isEmpty())
					{
						logger.info("------ returning total used coupon "+totalUsedCouponByUser.get(0));
						return totalUsedCouponByUser.get(0);
					}
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in getTotalUsedCouponByUserForGameWeek: "+ex);
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
	
	public static boolean allotCouponToUser(Integer gameWeekId,Integer userId,Integer couponId,Integer couponCategoryId,Integer gameId)
	{
		logger.info("----- Inside allotCouponToUser ---- gameWeekId: "+gameWeekId+", userId: "+userId+", couponId: "+couponId+", couponCategoryId: "+couponCategoryId+" , gameId: "+gameId);
		if(userId !=null && couponId !=null)
		{
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
					
						UsedCoupon couponUsed = new UsedCoupon();
						couponUsed.setUserId(userId);
						couponUsed.setCouponId(couponId);
						if(couponCategoryId !=null)
						{
							couponUsed.setCouponCategoryId(couponCategoryId);
						}
						if(gameWeekId !=null)
						{
							couponUsed.setGameWeekId(gameWeekId);
						}
						if(gameId !=null)
						{
							couponUsed.setGameId(gameId);
						}
						logger.info("alloting coupon to user");
						session.save(couponUsed);
						logger.info("commiting alloatment");
						session.beginTransaction().commit();
					}
					catch(Exception ex)
					{
						logger.error("Exception in allotCouponToUser: "+ex);
						setErrorMessage("Technical Error");
						setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
						return false;
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
					logger.error("----- Session Object is null----");
					return false;
				}
			}
		}
		else
		{
			logger.error("Required value is empty");
			return false;
		}
		return true;
	}
	public static void deActivateCoupon(Integer couponId)
	{
		logger.info("----- Inside deActivateCoupon ----  couponId: "+couponId);
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
				
					logger.info("loading coupon");
					Coupon coupon =(Coupon)session.load(Coupon.class,couponId);
					logger.info("updating to deactivate coupon");
					coupon.setIsActive(SportConstrant.NO);
					session.update(coupon);
					logger.info("commiting deactivation");
					session.beginTransaction().commit();
				}
				catch(Exception ex)
				{
					logger.error("Exception in deActivateCoupon: "+ex);
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
				logger.error("----- Session Object is null----");
			}
		}
	}
	
	public static boolean isActiveCoupon(Integer couponId)
	{
		logger.info("----- Inside isActiveCoupon ----  couponId: "+couponId);
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
				
					logger.info("loading coupon");
					Coupon coupon =(Coupon)session.load(Coupon.class,couponId);
					if(coupon !=null)
					{
						String isActive = coupon.getIsActive();
						logger.info("----- returning coupon isActive: "+isActive);
						return isActive.equals(SportConstrant.YES);
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception in isActiveCoupon: "+ex);
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
				logger.error("----- Session Object is null----");
			}
		}
		return false;
	}
}
