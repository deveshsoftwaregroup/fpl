package com.sportmgmt.model.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sportmgmt.model.entity.Coupon;
import com.sportmgmt.model.entity.CouponCategory;
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
		logger.info("----- Returning total limit of weekly Coupon  ---- : "+numberOfCouponsList.get(0));
		return numberOfCouponsList.get(0);
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
		logger.info("----- Returning coupon category  ---- : "+couponCategoryList.get(0));
		return couponCategoryList.get(0);
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
	
}
