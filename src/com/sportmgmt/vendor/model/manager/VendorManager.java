package com.sportmgmt.vendor.model.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.HibernateSessionFactory;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.vendor.model.entity.V_Article;;

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
	
	
	public static HashMap<String,List<V_Article>> fetchPositionIdByPageName(String pageName)
	{
		List<String> PostionList = null;
		List<String> PostionPriceList = null;
		List<V_Article> articleList = null;
		String position_id=null ;
		String position_Price_id=null ;
		String positionCode= null;
		HashMap<String,List<V_Article>> articleMap=new HashMap<String,List<V_Article>>();
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
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_POSITION_ID_BY_PAGENAME);
					if (pageName==null){
						pageName = "homepage";
						query.setParameter("page_name", pageName);	
					}
					else
					{
						query.setParameter("page_name", pageName);
					}
					PostionList =query.list();
					
					for( int i=0;i< PostionList.size();i++)
					{
						position_id = String.valueOf((PostionList.get(i)));
						System.out.println("position_id"+ position_id);
						positionCode=fetchPositionCodeByPositionId(position_id);
					    System.out.println("positionCode"+positionCode);
						
						PostionPriceList = fetchPositionPriceIdByPositionId(position_id);
						System.out.println("PostionPriceList"+  PostionPriceList);
						articleList = new ArrayList();
						for( int j=0;j< PostionPriceList.size();j++)
						  {     
							     position_Price_id = String.valueOf((PostionPriceList.get(j)));
								articleList.add(fetchArticleByPositionPriceId(position_Price_id));
					     }
						articleMap.put(positionCode,articleList);
						System.out.println("articleMap"+ articleMap);
						
					}
					
					
				}
				
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPositionIdByPageName"+ex.getMessage());
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
		
		
		logger.info("--------------- Returning  fetchPositionIdByPageName: -------------"+articleMap);
		return articleMap;
	}
	
	public static List<String> fetchPositionPriceIdByPositionId(String position_id)
	{
		List<String> PostionPriceList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchPositionPriceIdByPositionId ------------> position_id:  "+position_id);
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
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_POSITION_PRICE_ID_BY_POSITION_ID);
					
					
						query.setParameter("position_id", position_id);
					
						PostionPriceList =query.list();
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPositionPriceIdByPositionId"+ex.getMessage());
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
		logger.info("--------------- Returning user gameClubPlayerIdSortedByNameList: -------------"+PostionPriceList);
		return PostionPriceList;
	}
	public static String fetchPositionCodeByPositionId(String position_id)
	{
		String postionCode = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchPositionPriceIdByPositionId ------------> position_id:  "+position_id);
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
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_POSITION_CODE_BY_POSITION_ID);
					
					
						query.setParameter("position_id", position_id);
					
						postionCode =(String) query.list().get(0);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPositionPriceIdByPositionId"+ex.getMessage());
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
		logger.info("--------------- Returning user gameClubPlayerIdSortedByNameList: -------------"+postionCode);
		return postionCode;
	}
	
	public static V_Article fetchArticleByPositionPriceId(String position_Price_id)
	{
		V_Article article = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchaArticleByPositionPriceId ------------> position_Price_id:  "+position_Price_id);
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
					
					Query query = session.createQuery(QueryConstrant.FROM_V_ARTICLE);
					
						query.setParameter("position_price_id", Integer.valueOf(position_Price_id));
						//query.setParameter("isActive", SportConstrant.YES);
						article = (V_Article) query.list().get(0);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPositionPriceIdByPositionId"+ex.getMessage());
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
		logger.info("--------------- Returning user gameClubPlayerIdSortedByNameList: -------------"+article);
		return article;
	}


}
