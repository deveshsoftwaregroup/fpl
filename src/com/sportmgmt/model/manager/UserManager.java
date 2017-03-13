package com.sportmgmt.model.manager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sportmgmt.model.entity.CountryStateCity;
import com.sportmgmt.model.entity.User;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

public class UserManager {
	private static Logger logger = Logger.getLogger(UserManager.class);
	private static String errorCode;
	private static String errorMessage;
	private static String userId;
	public static String getErrorMessage() {
		return errorMessage;
	}

	public static void setErrorMessage(String errorMessage) {
		UserManager.errorMessage = errorMessage;
	}

	public static boolean saveUser(Map<String,String> userMap)
	{
		setErrorMessage("");
		setUserId("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		if(factory == null)
		{
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
					User user = null;
					/****** Code for checking for update User */
					if(userMap.get("userId") != null && !userMap.get("userId").equals(""))
					{
						user = (User) session.load(User.class, new Integer(userMap.get("userId")));
						if(user == null)
						{
							setErrorMessage("User Id is not existing");
							return false;
						}
						user.setLastUpdate(new Date(System.currentTimeMillis()));
					}
					else
					{
						
						Query query	 = session.createQuery("FROM User U WHERE U.logonID =:logonId");
						query.setParameter("logonId", userMap.get("logonId"));
						List userRecord =query.list();
						if(userRecord.size() >= 1)
						{
							setErrorMessage("Login ID already exists");
							return false;
						}
						user = new User();
						user.setCreatedDate(new Date(System.currentTimeMillis()));
						user.setRegisterDate(new Date(System.currentTimeMillis()));
						user.setUserType("R");
						user.setStatus("A");
					}
					if(userMap.get("logonId") != null && !userMap.get("logonId").equals(""))
					{
						user.setLogonID(userMap.get("logonId"));
					}
					if(userMap.get("emailId") != null && !userMap.get("emailId").equals(""))
					{
						user.setEmailId(userMap.get("emailId"));
					}
					if(userMap.get("logonPassword") != null && !userMap.get("logonPassword").equals(""))
					{
						user.setLogonPassword(userMap.get("logonPassword"));
					}
					if(userMap.get("displayName") != null && !userMap.get("displayName").equals(""))
					{
						user.setDisplayName(userMap.get("displayName"));
					}
					if(userMap.get("userType") != null && !userMap.get("userType").equals(""))
					{
						user.setUserType(userMap.get("userType"));
					}
					if(userMap.get("firstName") != null && !userMap.get("firstName").equals(""))
					{
						user.setFirstName(userMap.get("firstName"));
					}
					if(userMap.get("lastName") != null && !userMap.get("lastName").equals(""))
					{
						user.setLastName((String)userMap.get("lastName"));
					}
					if(userMap.get("contactNumber") != null && !userMap.get("contactNumber").equals(""))
					{
						user.setContactNumber((String)userMap.get("contactNumber"));
					}
					
					if(userMap.get("dobDay") != null && !userMap.get("dobDay").equals("") && userMap.get("dobMonth") != null && !userMap.get("dobMonth").equals("") && userMap.get("dobYear") != null && !userMap.get("dobYear").equals(""))
					{
						//Date date = new Date(Integer.parseInt(userMap.get("dobDay")),Integer.parseInt(userMap.get("dobMonth")),Integer.parseInt(userMap.get("dobYear")));
						Date date = new Date(new GregorianCalendar(Integer.parseInt(userMap.get("dobYear")),Integer.parseInt(userMap.get("dobMonth"))-1,Integer.parseInt(userMap.get("dobDay"))).getTimeInMillis());
						user.setDateOfBirth(date);
					}
					if(userMap.get("gender") != null && !userMap.get("gender").equals(""))
					{
						user.setGender((String)userMap.get("gender"));
					}
					String address="";
					if(userMap.get("address1") != null && !userMap.get("address1").equals(""))
					{
						user.setAddress1((String)userMap.get("address1"));
						address += userMap.get("address1");
					}
					if(userMap.get("address2") != null && !userMap.get("address2").equals(""))
					{
						user.setAddress2((String)userMap.get("address2"));
						address += ", " +userMap.get("address2");
					}
					if(userMap.get("city") != null && !userMap.get("city").equals(""))
					{
						user.setCity((String)userMap.get("city"));
						address += ", " +userMap.get("city");
					}
					if(userMap.get("state") != null && !userMap.get("state").equals(""))
					{
						user.setState((String)userMap.get("state"));
						address += ", " +userMap.get("state");
					}
					
					if(userMap.get("country") != null && !userMap.get("country").equals(""))
					{
						user.setCountry((String)userMap.get("country"));
						address += ", " +userMap.get("country");
						
					}
					if(userMap.get("pinCode") != null && !userMap.get("pinCode").equals(""))
					{
						user.setPincode((String)userMap.get("pinCode"));
						address += ", " +userMap.get("pinCode");
					}
					if(!address.equals(""))
					{
						user.setFullAaddress(address);
					}
					session.save(user);
					setUserId(String.valueOf(user.getUserId()));
					session.beginTransaction().commit();
				
				}
				catch(Exception ex)
				{
					System.out.println("Exception in save user: "+ex);
					session.beginTransaction().rollback();
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
		setUserId(SportConstrant.NULL);
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
					Query query	 = session.createQuery("FROM User U WHERE U.logonID =:logonId");
					query.setParameter("logonId", logonId);
					List userRecord =query.list();
					if(userRecord.size() >= 1)
					{
						User user = ((User)userRecord.get(0));
						if(user.getStatus().equals(SportConstrant.INACTIVE))
						{
							setErrorCode(ErrorConstrant.ACCOUNT_INACTIVE);
							setErrorMessage("Acount is not active");
							return false;
						}
						if(user.getStatus().equals(SportConstrant.LOCKED))
						{
							setErrorCode(ErrorConstrant.ACCOUNT_LOCKED);
							setErrorMessage("Acount is locked");
							return false;
						}
						if(!user.getLogonPassword().equals(logonPassword))
						{
							setErrorCode(ErrorConstrant.INVLID_PASS);
							setErrorMessage("Incorect Password");
							return false;
						}
						else
						{
							setUserId(user.getUserId().toString());
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
	public static boolean activateUser(String userId)
	{
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		setUserId(SportConstrant.NULL);
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
					logger.info("----- Loading for user----");
					User user = (User) session.load(User.class,Integer.valueOf(userId));
					user.setStatus("A");
					logger.info("----- Calling Save Update for user----");
					session.save(user);
					session.beginTransaction().commit();
					logger.info("-----  Save Update gets executed ----");
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
				logger.info("----- Session Object is null----");
				return false;
			}
		}
		return true;
	}
	
	public static com.sportmgmt.controller.bean.User getUser(String userId)
	{
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		setUserId(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		com.sportmgmt.controller.bean.User user = null;
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
					logger.info("----- Loading for user----: "+userId);
				
					com.sportmgmt.model.entity.User modelUser = (com.sportmgmt.model.entity.User) session.load(com.sportmgmt.model.entity.User.class,Integer.valueOf(userId));
					user = getControllerUserFromModelUser(modelUser);
				}
				catch(Exception ex)
				{
					logger.error("Exception in load user: "+ex);
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
		logger.info("----- Returning User Object ----"+user);
		return user;
	}
	public static com.sportmgmt.model.entity.User getUserModel(String userId)
	{
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		setUserId(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		com.sportmgmt.model.entity.User modelUser = null;
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
					logger.info("----- Loading for user----: "+userId);
				
					 modelUser = (com.sportmgmt.model.entity.User) session.get(com.sportmgmt.model.entity.User.class,Integer.valueOf(userId));
				}
				catch(Exception ex)
				{
					logger.error("Exception in load user: "+ex);
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
		logger.info("----- Returning User Modle ----"+modelUser);
		return modelUser;
	}
	public static String getPasswordByEmail(String emailId)
	{
		logger.info("----- Indie getPasswordByEmail ----"+emailId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		setUserId(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		String password = "";
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
					logger.info("----- Loading for user----: "+userId);
				
					Query query	 = session.createQuery("FROM User U WHERE U.emailId =:emailId");
					query.setParameter("emailId", emailId);
					List userRecord =query.list();
					if(userRecord.size() >= 1)
					{
						password = ((User)userRecord.get(0)).getLogonPassword();
					}
					else
					{
						setErrorCode(ErrorConstrant.USER_NULL);
						setErrorMessage("User with email "+emailId+ " does not exist");
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception in load user: "+ex);
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
		logger.info("----- Returning Passowrd ----"+password);
		return password;
	}

	public static String getUserIdByLogonId(String loginId)
	{
		logger.info("----- Indie getUserIdByLogonId ----"+loginId);
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		setUserId(SportConstrant.NULL);
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		String userId = "";
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
					logger.info("----- Loading for user----: "+loginId);
				
					Query query	 = session.createQuery("FROM User U WHERE U.logonID =:logonId");
					query.setParameter("logonId",loginId );
					List userRecord =query.list();
					if(userRecord.size() >= 1)
					{
						userId = String.valueOf(((User)userRecord.get(0)).getUserId());
					}
					else
					{
						setErrorCode(ErrorConstrant.USER_NULL);
						setErrorMessage("User with loginId "+loginId+ " does not exist");
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception in load user: "+ex);
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
		logger.info("----- Returning userId ----"+userId);
		return userId;
	}

	public static String getErrorCode() {
		return errorCode;
	}

	public static void setErrorCode(String errorCode) {
		UserManager.errorCode = errorCode;
	}

	public static String getUserId() {
		return userId;
	}

	public static void setUserId(String userId) {
		UserManager.userId = userId;
	}
	public static com.sportmgmt.controller.bean.User getControllerUserFromModelUser(com.sportmgmt.model.entity.User modelUser) 
	{
		logger.info("-------------  Inside getControllerUserFromModelUser , Model User : "+modelUser);
		com.sportmgmt.controller.bean.User controllerUser = null;
		if(modelUser != null)
		{
			try
			{
				controllerUser = new com.sportmgmt.controller.bean.User();
				controllerUser.setUserId(modelUser.getUserId());
				controllerUser.setFirstName(modelUser.getFirstName());
				controllerUser.setLastName(modelUser.getLastName());
				controllerUser.setDisplayName(modelUser.getDisplayName());
				controllerUser.setLogonID(modelUser.getLogonID());
				controllerUser.setLogonPassword(modelUser.getLogonPassword());
				controllerUser.setUserType(modelUser.getUserType());
				controllerUser.setDateOfBirth(modelUser.getDateOfBirth());
				controllerUser.setLastLogin(modelUser.getLastLogin());
				controllerUser.setLastUpdate(modelUser.getLastUpdate());
				controllerUser.setCreatedDate(modelUser.getCreatedDate());
				controllerUser.setRegisterDate(modelUser.getRegisterDate());
				controllerUser.setEmailId(modelUser.getEmailId());
				controllerUser.setFullAaddress(modelUser.getFullAaddress());
				controllerUser.setContactNumber(modelUser.getContactNumber());
				controllerUser.setGender(modelUser.getGender());
				controllerUser.setField1_integer(modelUser.getField1_integer());
				controllerUser.setField_string(modelUser.getField_string());
				controllerUser.setField1_date(modelUser.getField1_date());
				controllerUser.setField2(modelUser.getField2());
				controllerUser.setField3(modelUser.getField3());
				controllerUser.setPolicy(modelUser.getPolicy());
				controllerUser.setStatus(modelUser.getStatus());
				controllerUser.setCountry(modelUser.getCountry());
				controllerUser.setState(modelUser.getState());
				controllerUser.setCity(modelUser.getCity());
				controllerUser.setPincode(modelUser.getPincode());
				controllerUser.setAddress1(modelUser.getAddress1());
				controllerUser.setAddress2(modelUser.getAddress2());

			}
			catch(Exception ex)
			{
				logger.error("----------- Error in Converting Model User to Controller User: "+ex);
			}
		}
		return controllerUser;
	}
	public static List fetchAllCountryStateCity()
	{
		logger.info("----- Indie fetchAllCountryStateCity ----");
		setErrorMessage(SportConstrant.NULL);
		setErrorCode(SportConstrant.NULL);
		List countryStateCityList = null;
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
				
					Query query	 = session.createQuery(QueryConstrant.FROM_COUNTRY_STATE_CITY);
					logger.info("----------- Executing query to load county city map:");
					countryStateCityList = query.list();
					
				}
				catch(Exception ex)
				{
					logger.error("Exception in fetching country state city: "+ex);
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
		logger.info("----- Returning County State City List  ----"+countryStateCityList);
		return countryStateCityList;
	}
	public static void main(String...str)
	{
		System.out.println(fetchAllCountryStateCity());
	}
	public static HashMap<String,HashMap<String,ArrayList<String>>> getCountryStateCityMap()
	{
		HashMap<String,HashMap<String,ArrayList<String>>> countryCityStateMap = new HashMap<String,HashMap<String,ArrayList<String>>>();
		List courntyCityStateList = fetchAllCountryStateCity();
		if(courntyCityStateList != null && courntyCityStateList.size() >=0)
		{
			for(int i=0;i< courntyCityStateList.size();i++)
			{
				CountryStateCity cntrySttCity = (CountryStateCity)courntyCityStateList.get(i);
				if(countryCityStateMap.containsKey(cntrySttCity.getCountryName()))
				{
					//HashMap<String,ArrayList<String>> stateMap = countryCityStateMap.get(cntrySttCity.getCountryName());
					if(countryCityStateMap.get(cntrySttCity.getCountryName()).containsKey(cntrySttCity.getStateName()))
					{
						countryCityStateMap.get(cntrySttCity.getCountryName()).get(cntrySttCity.getStateName()).add(cntrySttCity.getCityName());
					}
					else
					{
						ArrayList<String> cityList = new ArrayList<String>();
						cityList.add(cntrySttCity.getCityName());
						countryCityStateMap.get(cntrySttCity.getCountryName()).put(cntrySttCity.getStateName(),cityList);
					}
				}
				else
				{
					HashMap<String,ArrayList<String>> stateMap = new <String,ArrayList<String>>HashMap();
					ArrayList<String> cityList = new ArrayList<String>();
					cityList.add(cntrySttCity.getCityName());
					stateMap.put(cntrySttCity.getStateName(), cityList);
					countryCityStateMap.put(cntrySttCity.getCountryName(), stateMap);
				}
			}
		}
		logger.info("---------------> Returning Country State City Map: "+countryCityStateMap);
		return countryCityStateMap;
	}
}
