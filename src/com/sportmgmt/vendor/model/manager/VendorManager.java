package com.sportmgmt.vendor.model.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.HibernateSessionFactory;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;

public class VendorManager {
	private static Logger logger = Logger.getLogger(VendorManager.class);
	private static String errorCode;
	private static String errorMessage;
	public static String getErrorCode() {
		return errorCode;
	}
	public static void setErrorCode(String errorCode) {
		VendorManager.errorCode = errorCode;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
	public static void setErrorMessage(String errorMessage) {
		VendorManager.errorMessage = errorMessage;
	}
	
	
	public static List<String> fetchArticleByPageName(String pageName)
	{
		List<String> articleList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchArticleByPageName ------------> pageName:  "+pageName);
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
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_PLAYERS_IN_ORDER_BY_NAME);
					query.setParameter("pageName", pageName);
					articleList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchGameClubPlayerIdListSortedByPlayerName"+ex.getMessage());
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
		logger.info("--------------- Returning user gameClubPlayerIdSortedByNameList: -------------"+articleList);
		return articleList;
	}

}
