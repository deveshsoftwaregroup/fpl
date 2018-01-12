package com.sportmgmt.vendor.model.manager;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sportmgmt.model.entity.GameClubPlayer;
import com.sportmgmt.model.entity.PlayerPoint;
import com.sportmgmt.model.entity.Point;
import com.sportmgmt.model.manager.HibernateSessionFactory;
import com.sportmgmt.utility.constrant.ErrorConstrant;
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
	public static java.util.List<Integer> insertVendorArticle(Integer articleId,Integer vendorId,Integer positionId,String category,String heading,String content,String link)
	{
		logger.info("----- Inside insertvendorArticle ---- articleId: "+articleId+", vendorId: "+vendorId+"  , positionId: "+positionId);
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
				
					V_Article vendorarticle = new V_Article();
					/*Point point = (Point)session.load(Point.class, pointId);
					GameClubPlayer gameClubPlayer = (GameClubPlayer)session.load(GameClubPlayer.class, gameClubPlayerId);*/
					vendorarticle.setArticle_id(articleId);
					//System.out.println("ArticleId"+vendorarticle);
					vendorarticle.setVendor_id(vendorId);
					vendorarticle.setPosition_id(positionId);
					vendorarticle.setCategory(category);
					//System.out.println("Category "+Category);
					vendorarticle.setHeading(heading);
					vendorarticle.setContent(content);
					vendorarticle.setLink(link);
					session.save(vendorarticle);
					logger.info("------------ inserting for vendor article");
					session.beginTransaction().commit();
					logger.info("------------ article for vendor is committed");
					/*playerPointList.add(playerPoint.getPlayerPointId());
					if(point.getPointToAdd() != null && point.getPointToAdd().intValue() !=0)
					{
						playerPointList.add(playerPoint.getPoint().getPointToAdd());
					}
					else if(point.getPointToDeduct() != null)
					{
						playerPointList.add(-(playerPoint.getPoint().getPointToAdd()));
					}*/
					
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
}
