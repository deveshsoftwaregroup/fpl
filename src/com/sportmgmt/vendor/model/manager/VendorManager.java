package com.sportmgmt.vendor.model.manager;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sportmgmt.model.entity.User;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.HibernateSessionFactory;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.vendor.model.entity.V_Article;
import com.sportmgmt.vendor.model.entity.Vendor;

public class VendorManager {
	private static Logger logger = Logger.getLogger(VendorManager.class);
	private static String errorCode;
	private static String errorMessage;
	private static String vendorId;
	public static String getVendorId() {
		return vendorId;
	}
	public static void setVendorId(String vendorId) {
		VendorManager.vendorId = vendorId;
	}
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
						pageName = "HOME";
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
	public static boolean saveVendor(Map<String,String> vendorMap)
	{
		setErrorMessage("");
		setVendorId("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorMessage("Technical Error");
			return false;
		}
		else
		{
			Session session = factory.openSession();
			Transaction trasaction = session.beginTransaction();
			if(session != null)
			{
				try
				{
					Vendor vendor = null;
					/****** Code for checking for update User */
					if(vendorMap.get("vendorId") != null && !vendorMap.get("vendorId").equals(""))
					{
						vendor = (Vendor) session.load(Vendor.class, new Integer(vendorMap.get("vendorId")));
						if(vendor == null)
						{
							setErrorMessage("User Id is not existing");
							return false;
						}
						vendor.setLastUpdate(new Date(System.currentTimeMillis()));
					}
					else
					{
						
						Query query	 = session.createQuery("FROM Vendor U WHERE U.logonID =:logonId");
						query.setParameter("logonId", vendorMap.get("logonId"));
						List vendorRecord =query.list();
						if(vendorRecord.size() >= 1)
						{
							setErrorMessage("Login ID already exists");
							return false;
						}
						vendor = new Vendor();
						vendor.setCreatedDate(new Date(System.currentTimeMillis()));
						vendor.setRegisterDate(new Date(System.currentTimeMillis()));
						vendor.setVendorType("R");
						vendor.setStatus("A");
					}
					if(vendorMap.get("logonId") != null && !vendorMap.get("logonId").equals(""))
					{
						vendor.setLogonID(vendorMap.get("logonId"));
					}
					if(vendorMap.get("emailId") != null && !vendorMap.get("emailId").equals(""))
					{
						vendor.setEmailId(vendorMap.get("emailId"));
					}
					if(vendorMap.get("logonPassword") != null && !vendorMap.get("logonPassword").equals(""))
					{
						vendor.setLogonPassword(vendorMap.get("logonPassword"));
					}
					if(vendorMap.get("displayName") != null && !vendorMap.get("displayName").equals(""))
					{
						vendor.setDisplayName(vendorMap.get("displayName"));
					}
					if(vendorMap.get("vendorType") != null && !vendorMap.get("vendorType").equals(""))
					{
						vendor.setVendorType(vendorMap.get("vendorType"));
					}
					if(vendorMap.get("firstName") != null && !vendorMap.get("firstName").equals(""))
					{
						vendor.setFirstName(vendorMap.get("firstName"));
					}
					if(vendorMap.get("lastName") != null && !vendorMap.get("lastName").equals(""))
					{
						vendor.setLastName((String)vendorMap.get("lastName"));
					}
					if(vendorMap.get("contactNumber") != null && !vendorMap.get("contactNumber").equals(""))
					{
						vendor.setContactNumber((String)vendorMap.get("contactNumber"));
					}
					if(vendorMap.get("dob") != null && !vendorMap.get("dob").equals(""))
					{
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date date = sdf1.parse(vendorMap.get("dob"));
						java.sql.Date sqlDOB = new java.sql.Date(date.getTime());  
						vendor.setDateOfBirth(sqlDOB);
					}
					/*if(userMap.get("dobDay") != null && !userMap.get("dobDay").equals("") && userMap.get("dobMonth") != null && !userMap.get("dobMonth").equals("") && userMap.get("dobYear") != null && !userMap.get("dobYear").equals(""))
					{
						//Date date = new Date(Integer.parseInt(userMap.get("dobDay")),Integer.parseInt(userMap.get("dobMonth")),Integer.parseInt(userMap.get("dobYear")));
						Date date = new Date(new GregorianCalendar(Integer.parseInt(userMap.get("dobYear")),Integer.parseInt(userMap.get("dobMonth"))-1,Integer.parseInt(userMap.get("dobDay"))).getTimeInMillis());
						user.setDateOfBirth(date);
					}*/
					if(vendorMap.get("gender") != null && !vendorMap.get("gender").equals(""))
					{
						vendor.setGender((String)vendorMap.get("gender"));
					}
					String address="";
					if(vendorMap.get("address1") != null && !vendorMap.get("address1").equals(""))
					{
						vendor.setAddress1((String)vendorMap.get("address1"));
						address += vendorMap.get("address1");
					}
					if(vendorMap.get("address2") != null && !vendorMap.get("address2").equals(""))
					{
						vendor.setAddress2((String)vendorMap.get("address2"));
						address += ", " +vendorMap.get("address2");
					}
					if(vendorMap.get("city") != null && !vendorMap.get("city").equals(""))
					{
						vendor.setCity((String)vendorMap.get("city"));
						address += ", " +vendorMap.get("city");
					}
					if(vendorMap.get("state") != null && !vendorMap.get("state").equals(""))
					{
						vendor.setState((String)vendorMap.get("state"));
						address += ", " +vendorMap.get("state");
					}
					
					if(vendorMap.get("country") != null && !vendorMap.get("country").equals(""))
					{
						vendor.setCountry((String)vendorMap.get("country"));
						address += ", " +vendorMap.get("country");
						
					}
					if(vendorMap.get("club") != null && !vendorMap.get("club").equals(""))
					{
						vendor.setField_string((String)vendorMap.get("club"));
					}
					if(vendorMap.get("pinCode") != null && !vendorMap.get("pinCode").equals(""))
					{
						vendor.setPincode((String)vendorMap.get("pinCode"));
						address += ", " +vendorMap.get("pinCode");
					}
					if(!address.equals(""))
					{
						vendor.setFullAaddress(address);
					}
					session.save(vendor);
					setVendorId(String.valueOf(vendor.getVendorId()));
					trasaction.commit();
				
				}
				catch(Exception ex)
				{
					System.out.println("Exception in save user: "+ex);
					trasaction.rollback();
					setErrorMessage("Technical Error");
					return false;
				}
				finally
				{
					session.close();
				}
			}
		}
		
		return true;
	}
	public static boolean validateUser(String logonId,String logonPassword)
	{
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		setVendorId(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			return false;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					Query query	 = session.createQuery("FROM Vendor U WHERE U.logonID =:logonId");
					query.setParameter("logonId", logonId);
					List userRecord =query.list();
					if(userRecord.size() >= 1)
					{
						Vendor vendor = ((Vendor)userRecord.get(0));
						if(vendor.getStatus().equals(SportConstrant.INACTIVE))
						{
							setErrorCode(ErrorConstrant.ACCOUNT_INACTIVE);
							setErrorMessage("Acount is not active");
							return false;
						}
						if(vendor.getStatus().equals(SportConstrant.LOCKED))
						{
							setErrorCode(ErrorConstrant.ACCOUNT_LOCKED);
							setErrorMessage("Acount is locked");
							return false;
						}
						if(!vendor.getLogonPassword().equals(logonPassword))
						{
							setErrorCode(ErrorConstrant.INVLID_PASS);
							setErrorMessage("Incorect Password");
							return false;
						}
						else
						{
							setVendorId(vendor.getVendorId().toString());
						}
					}
					else
					{
						setErrorCode(ErrorConstrant.USER_NULL);
						setErrorMessage("Logon Id does not exist");
						return false;
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception in save user: "+ex);
					session.beginTransaction().rollback();
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
				return false;
			}
		}
		return true;
	}

}
