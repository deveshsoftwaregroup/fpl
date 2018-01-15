package com.sportmgmt.vendor.model.manager;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sportmgmt.model.entity.GameClubPlayer;
import com.sportmgmt.model.entity.GameWeekReport;
import com.sportmgmt.model.entity.PlayerPoint;
import com.sportmgmt.model.entity.Point;
import com.sportmgmt.model.manager.HibernateSessionFactory;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.vendor.model.entity.V_Article;



public class VendorArticleUpdateManager {

	private static Logger logger = Logger.getLogger(VendorArticleUpdateManager.class);
	private static String errorCode;
	private static String errorMessage;
	
	public static String getErrorCode() {
		return errorCode;
	}

	public static void setErrorCode(String errorCode) {
		VendorArticleUpdateManager.errorCode = errorCode;
	}

	public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		VendorArticleUpdateManager.errorMessage = errorMessage;
	}
	public static java.util.List<Integer> insertVendorArticle(Integer vendorId,Integer positionId,Integer positionPriceID,String category,String heading,String content,String link)
	{
		logger.info("----- Inside insertvendorArticle ----  vendorId: "+vendorId+"  , positionId: "+positionId+", positionPriceId: "+positionPriceID);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		java.util.List<Integer> VendorArticleList = new java.util.ArrayList<Integer>();
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
					Criteria cr = session.createCriteria(V_Article.class);
					cr.add(Restrictions.eq("position_price_id", positionPriceID));
					List<V_Article> articleDetail = cr.list();
				if(articleDetail == null || articleDetail.isEmpty())
					{
					logger.info("articleReports not found in database, going to make new entry");
					V_Article vendorarticle = new V_Article();
					//vendorarticle.setArticle_id(articleId);
					//System.out.println("ArticleId"+vendorarticle);
					vendorarticle.setVendor_id(vendorId);
					vendorarticle.setPosition_id(positionId);
					vendorarticle.setPosition_price_id(positionPriceID);
					vendorarticle.setCategory(category);
					//System.out.println("Category "+Category);
					vendorarticle.setHeading(heading);
					vendorarticle.setContent(content);
					vendorarticle.setLink(link);
					session.save(vendorarticle);
					logger.info("------------ inserting for vendor article");
					session.beginTransaction().commit();
					logger.info("------------ article for vendor is committed");
				}
				else{
					logger.info("------------ inserting for vendor article");
					V_Article articleReport =  articleDetail.get(0);
					if(category !=null)
					{
						logger.info("------------ category"+category);
						articleReport.setCategory(category);
					}
					if(heading !=null)
					{
						articleReport.setHeading(heading);
					}
					if(content !=null)
					{
						articleReport.setContent(content);
					}
					if(link !=null)
					{
						articleReport.setLink(link);
					}

					session.update(articleReport);
					session.beginTransaction().commit();
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
		return VendorArticleList;
	}
	
	public static List<String> fetchPositionIdByVendorId(String vendorId)
	{
		List<String> vendorPostionList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchPositionIdByVendorId ------------> vendorId:  "+vendorId);
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
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_POSITION_ID_BY_VENDOR_ID);
					
					
						query.setParameter("vendorId", vendorId);
					
						vendorPostionList =query.list();
						System.out.println(vendorPostionList);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPositionIdByVendorId"+ex.getMessage());
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
		logger.info("--------------- Returning vendor PostionList: -------------"+vendorPostionList);
		return vendorPostionList;
	}
	public static List<String> fetchPositionPriceIdByVendorId(String vendorId)
	{
		List<String> vendorPostionPriceList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchPositionIdByVendorId ------------> vendorId:  "+vendorId);
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
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_POSITION_PRICE_ID_BY_VENDOR_ID);
					
					
						query.setParameter("vendorId", vendorId);
					
						vendorPostionPriceList =query.list();
						System.out.println("vendorPostionPriceList"+vendorPostionPriceList);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchPositionIdByVendorId"+ex.getMessage());
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
		logger.info("--------------- Returning vendor PostionPriceList: -------------"+vendorPostionPriceList);
		return vendorPostionPriceList;
	}
	public static List<String> fetchArticleIdByVendorId(String vendorId)
	{
		List<String> vendorArticleList = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchArticleIdByVendorId ------------> vendorId:  "+vendorId);
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
					
					SQLQuery query = session.createSQLQuery(QueryConstrant.SELECT_ARTICLE_ID_BY_VENDOR_ID);
					
					
						query.setParameter("vendorId", vendorId);
					
						vendorArticleList =query.list();
						System.out.println(vendorArticleList);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch : fetchArticleIdByVendorId"+ex.getMessage());
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
		logger.info("--------------- Returning  vendorArticleList: -------------"+vendorArticleList);
		return vendorArticleList;
	}
}
