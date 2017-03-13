package com.sportmgmt.model.manager;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
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

import com.sportmgmt.controller.bean.ActivePlan;
import com.sportmgmt.model.entity.Game;
import com.sportmgmt.model.entity.LeaguePlan;
import com.sportmgmt.model.entity.PaymentExt;
import com.sportmgmt.model.entity.PlanDiscount;
import com.sportmgmt.model.entity.User;
import com.sportmgmt.model.entity.UserGame;
import com.sportmgmt.model.entity.UserPayment;
import com.sportmgmt.model.entity.UserPlan;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.QueryConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

public class PlanManager {
	private static Logger logger = Logger.getLogger(PlanManager.class);
	private static String errorCode;
	private static String errorMessage;
	public static String getErrorCode() {
		return errorCode;
	}
	public static void setErrorCode(String errorCode) {
		PlanManager.errorCode = errorCode;
	}
	public static String getErrorMessage() {
		return errorMessage;
	}
	public static void setErrorMessage(String errorMessage) {
		PlanManager.errorMessage = errorMessage;
	}
	private static SessionFactory factory = null;
	private static String leaguePlanId;
	private static String planDiscountId;
	
	public static String getLeaguePlanId() {
		return leaguePlanId;
	}
	public static void setLeaguePlanId(String leaguePlanId) {
		PlanManager.leaguePlanId = leaguePlanId;
	}
	public static String getPlanDiscountId() {
		return planDiscountId;
	}
	public static void setPlanDiscountId(String planDiscountId) {
		PlanManager.planDiscountId = planDiscountId;
	}

	static
	{
		try
		{
			if(factory == null)
			{
				setErrorMessage("");
				factory = HibernateSessionFactory.getSessionFacotry();
			}
		}
		catch(Exception ex)
		{
			logger.error("Exception fetch factory "+ex.getMessage());
		}
	}
	public static LeaguePlan fetchLeaguePlan(Integer leaguePlanId)
	{
		logger.info("--------------- fetchLeaguePlan -------------");
		LeaguePlan leaguePlan = null;
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
					
					leaguePlan	 = (LeaguePlan)session.get(LeaguePlan.class,leaguePlanId);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch leaguePlan: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
				}
				finally
				{
					session.close();
					//factory.close();
				}
			}
			else
			{
				setErrorCode(ErrorConstrant.SESS_NULL);
				setErrorMessage("Technical Error");
			}
		}
		logger.info("--------------- Returning leaguePlan -------------"+leaguePlan);
		return leaguePlan;
	}
	public static PlanDiscount fetchPlanDiscount(Integer planDiscountId)
	{
		logger.info("--------------- fetchPlanDiscount -------------");
		PlanDiscount planDiscount = null;
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
					
					planDiscount	 = (PlanDiscount)session.get(PlanDiscount.class,planDiscountId);
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch fetchPlanDiscount: "+ex.getMessage());
					setErrorMessage("Technical Error");
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
				}
				finally
				{
					session.close();
					//factory.close();
				}
			}
			else
			{
				setErrorCode(ErrorConstrant.SESS_NULL);
				setErrorMessage("Technical Error");
			}
		}
		logger.info("--------------- Returning planDiscount -------------"+planDiscount);
		return planDiscount;
	}
	
	public static Integer createTransaction(Map<String,String> paymentDetails)
	{
		logger.info("--------------- createTransaction ------------: plndId: "+paymentDetails.get("leaguePlanId")+" , discount Id: "+paymentDetails.get("planDiscountId")+ " , userId: "+paymentDetails.get("userId"));
		Integer transactionId =null;
		logger.info("----- fetching plan------------------ ");
		LeaguePlan leaguePlan = fetchLeaguePlan(Integer.valueOf((String)paymentDetails.get("leaguePlanId")));
		logger.info("----- fetching discount------------------ ");
		PlanDiscount planDiscount = fetchPlanDiscount(Integer.valueOf((String)paymentDetails.get("planDiscountId")));
		logger.info("----- fetching user------------------ ");
		User user = UserManager.getUserModel((String)paymentDetails.get("userId"));
		UserPayment userPayment = null;
		if(leaguePlan !=null && planDiscount != null && user != null)
		{
			userPayment = new UserPayment();
			userPayment.setAmount(Double.valueOf((String)paymentDetails.get("amount")));
			userPayment.setPlan(leaguePlan);
			userPayment.setPlanDiscount(planDiscount);
			userPayment.setUser(user);
			if(paymentDetails.get("merchantId") != null && !paymentDetails.get("merchantId").equals(""))
			userPayment.setMerchantId((String)paymentDetails.get("merchantId"));
			userPayment.setStatus(SportConstrant.INITIATED);
			userPayment.setCurrency("INR");
			userPayment.setDate(new Date(System.currentTimeMillis()));
			userPayment.setPaymentMode("DEFAULT");
			//userPayment.setPaymentMsg(paymentMsg);
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
						//session.beginTransaction().begin();;
						session.save(userPayment);
						transactionId = userPayment.getTransactionId();
						session.beginTransaction().commit();
					}
					catch(Exception ex)
					{
						logger.error("Exception to create new user transaction: "+ex.getMessage());
						setErrorMessage("Technical Error");
						setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
						//session.beginTransaction().rollback();
					}
					finally
					{
						session.close();
						//factory.close();
					}
				}
				else
				{
					setErrorCode(ErrorConstrant.SESS_NULL);
					setErrorMessage("Technical Error");
				}
			}

		}
		logger.info("--------------- createTransaction returning transactionId: -------------"+transactionId);
		return transactionId;
	}
	public static boolean updateTransaction(Map<String,String> paymentDetails)
	{
		logger.info("--------------- updateTransaction ------------: transactionId: "+paymentDetails.get("txnid")+" ,  status : "+paymentDetails.get("status")+ " , message: "+paymentDetails.get("error_Message"));
		boolean updateTransaction =false;
		String transactionId = paymentDetails.get("txnid");
		if(transactionId !=null && !transactionId.equals(""))
		{
				
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
						//session.beginTransaction().begin();;UserPayment userPayment = new UserPayment();
						UserPayment userPayment = (UserPayment)session.load(UserPayment.class, new Integer(transactionId));
						//userPayment.setTransactionId(Integer.valueOf(transactionId));
						if(paymentDetails.get("amount") != null && !paymentDetails.get("amount").equals(""))
						userPayment.setAmount(Double.valueOf((String)paymentDetails.get("amount")));
						if(paymentDetails.get("status") != null && !paymentDetails.get("status").equals(""))
						userPayment.setStatus(paymentDetails.get("status"));
						if(paymentDetails.get("error_Message") != null && !paymentDetails.get("error_Message").equals(""))
						userPayment.setPaymentMsg(paymentDetails.get("error_Message"));
						if(paymentDetails.get("mihpayid") != null && !paymentDetails.get("mihpayid").equals(""))
						userPayment.setPayUId(paymentDetails.get("mihpayid"));
						if(paymentDetails.get("net_amount_debit") != null && !paymentDetails.get("net_amount_debit").equals(""))
						{
							double net_amount_debit = Double.valueOf(paymentDetails.get("net_amount_debit"));
							userPayment.setTotalAmount(net_amount_debit);
						}
						if(paymentDetails.get("extraCharge") != null && !paymentDetails.get("extraCharge").equals(""))
						{
							double extraCharge = Double.valueOf(paymentDetails.get("extraCharge"));
							double amount = userPayment.getAmount();
							double totalAmount = amount + extraCharge;
							userPayment.setExtraCharge(extraCharge);
							userPayment.setTotalAmount(totalAmount);
						}
						
						if(paymentDetails.get("mode") != null && !paymentDetails.get("mode").equals(""))
						userPayment.setPaymentMode(paymentDetails.get("mode"));
						if(paymentDetails.get("bankcode") != null && !paymentDetails.get("bankcode").equals(""))
						userPayment.setBankCode(paymentDetails.get("bankcode"));
						if(paymentDetails.get("PG_TYPE") != null && !paymentDetails.get("PG_TYPE").equals(""))
						userPayment.setPgType(paymentDetails.get("PG_TYPE"));
						if(paymentDetails.get("bank_ref_num") != null && !paymentDetails.get("bank_ref_num").equals(""))
						userPayment.setBankReferenceNo(paymentDetails.get("bank_ref_num"));
						
						setLeaguePlanId(String.valueOf(userPayment.getPlan().getPlanId()));
						
						setPlanDiscountId(String.valueOf(userPayment.getPlanDiscount().getPlanDiscountId())); 
						
						session.update(userPayment);
						session.beginTransaction().commit(); 
						logger.info("Payment table updated ----------------");
						logger.info("Started to update Payment_Ext table ----------------");
						PaymentExt paymentExt = new PaymentExt();
						paymentExt.setTransactionId(Integer.valueOf(transactionId));
						if(paymentDetails.get("key") != null && !paymentDetails.get("key").equals(""))
							paymentExt.setMerchantKey(paymentDetails.get("key"));
						
						if(paymentDetails.get("email") != null && !paymentDetails.get("email").equals(""))
							paymentExt.setEmail(paymentDetails.get("email"));	
						
						if(paymentDetails.get("phone") != null && !paymentDetails.get("phone").equals(""))
							paymentExt.setPhone(paymentDetails.get("phone"));
						
						if(paymentDetails.get("udf1") != null && !paymentDetails.get("udf1").equals(""))
							paymentExt.setUdf1(paymentDetails.get("udf1"));
						
						if(paymentDetails.get("udf2") != null && !paymentDetails.get("udf2").equals(""))
							paymentExt.setUdf2(paymentDetails.get("udf2"));
						
						if(paymentDetails.get("udf3") != null && !paymentDetails.get("udf3").equals(""))
							paymentExt.setUdf3(paymentDetails.get("udf3"));
						
						if(paymentDetails.get("udf4") != null && !paymentDetails.get("udf4").equals(""))
							paymentExt.setUdf4(paymentDetails.get("udf4"));
						
						if(paymentDetails.get("udf5") != null && !paymentDetails.get("udf5").equals(""))
							paymentExt.setUdf5(paymentDetails.get("udf5"));
						
						if(paymentDetails.get("udf6") != null && !paymentDetails.get("udf6").equals(""))
							paymentExt.setUdf6(paymentDetails.get("udf6"));
						
						if(paymentDetails.get("udf7") != null && !paymentDetails.get("udf7").equals(""))
							paymentExt.setUdf7(paymentDetails.get("udf7"));
						
						if(paymentDetails.get("udf8") != null && !paymentDetails.get("udf8").equals(""))
							paymentExt.setUdf8(paymentDetails.get("udf8"));
						
						if(paymentDetails.get("udf9") != null && !paymentDetails.get("udf9").equals(""))
							paymentExt.setUdf9(paymentDetails.get("udf9"));
						
						if(paymentDetails.get("udf10") != null && !paymentDetails.get("udf10").equals(""))
							paymentExt.setUdf10(paymentDetails.get("udf10"));
						
						if(paymentDetails.get("hash") != null && !paymentDetails.get("hash").equals(""))
							paymentExt.setHash(paymentDetails.get("hash"));
						
						if(paymentDetails.get("field1") != null && !paymentDetails.get("field1").equals(""))
							paymentExt.setField1(paymentDetails.get("field1"));
						
						if(paymentDetails.get("field2") != null && !paymentDetails.get("field2").equals(""))
						paymentExt.setField2(paymentDetails.get("field2"));
						
						if(paymentDetails.get("field3") != null && !paymentDetails.get("field3").equals(""))
							paymentExt.setField3(paymentDetails.get("field3"));
						
						if(paymentDetails.get("field4") != null && !paymentDetails.get("field4").equals(""))
							paymentExt.setField4(paymentDetails.get("field4"));
						
						if(paymentDetails.get("field5") != null && !paymentDetails.get("field5").equals(""))
							paymentExt.setField5(paymentDetails.get("field5"));
						
						if(paymentDetails.get("field6") != null && !paymentDetails.get("field6").equals(""))
							paymentExt.setField6(paymentDetails.get("field6"));
						
						if(paymentDetails.get("field7") != null && !paymentDetails.get("field7").equals(""))
							paymentExt.setField7(paymentDetails.get("field7"));
						
						if(paymentDetails.get("field8") != null && !paymentDetails.get("field8").equals(""))
							paymentExt.setField8(paymentDetails.get("field8"));
						
						if(paymentDetails.get("field9") != null && !paymentDetails.get("field9").equals(""))
							paymentExt.setField9(paymentDetails.get("field9"));
						
						if(paymentDetails.get("field10") != null && !paymentDetails.get("field10").equals(""))
							paymentExt.setField10(paymentDetails.get("field10"));
						
						if(paymentDetails.get("field11") != null && !paymentDetails.get("field11").equals(""))
							paymentExt.setField11(paymentDetails.get("field11"));
						
						if(paymentDetails.get("payuMoneyId") != null && !paymentDetails.get("payuMoneyId").equals(""))
							paymentExt.setPayuMoneyId(paymentDetails.get("payuMoneyId"));
						
						if(paymentDetails.get("cardnum") != null && !paymentDetails.get("cardnum").equals(""))
							paymentExt.setCardNum(paymentDetails.get("cardnum"));
						
						if(paymentDetails.get("name_on_card") != null && !paymentDetails.get("name_on_card").equals(""))
							paymentExt.setNameOnCard(paymentDetails.get("name_on_card"));
							
						if(paymentDetails.get("unmappedstatus") != null && !paymentDetails.get("unmappedstatus").equals(""))
						 paymentExt.setUnMappedStatus(paymentDetails.get("unmappedstatus")); 
						 
						 if(paymentDetails.get("encryptedPaymentId") != null && !paymentDetails.get("encryptedPaymentId").equals(""))
							 paymentExt.setIncPayMoneyId(paymentDetails.get("encryptedPaymentId"));
						logger.info(" ****** Making entry in payment ext table ");
						session.save(paymentExt);
						session.beginTransaction().commit();
						logger.info(" ****** Entry Done in payment ext table ");
						updateTransaction = true;
					}
					catch(Exception ex)
					{
						logger.error("Exception to update transaction: "+ex.getMessage());
						setErrorMessage("Technical Error");
						setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
						//session.beginTransaction().rollback();
					}
					finally
					{
						session.close();
						//factory.close();
					}
				}
				else
				{
					setErrorCode(ErrorConstrant.SESS_NULL);
					setErrorMessage("Technical Error");
				}
			}

		}
		logger.info("--------------- update returning -------------"+updateTransaction);
		return updateTransaction;
	}
	public static ActivePlan getActivePlans(String userId)
	{
		ActivePlan activePlan = null;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchActivePlans ------------> userId:  "+userId);
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
					Criteria cr = session.createCriteria(UserPlan.class);
					User user = new User();
					user.setUserId(new Integer(userId));
					cr.add(Restrictions.eq("isActive", SportConstrant.YES));
					cr.add(Restrictions.eq("user", user));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- Active Plans does not found--");
					}
					else
					{
						
							UserPlan userPlan = (UserPlan)results.get(0);
							activePlan = new ActivePlan();
							activePlan.setUserPlanId(userPlan.getUserPlanId());
							if(userPlan.getPlan().getPlanName() != null)
							activePlan.setPlanName(userPlan.getPlan().getPlanName());
							if(userPlan.getPlan().getPlanTypeVal() != null)
							activePlan.setPlanTypeVal(userPlan.getPlan().getPlanTypeVal());
							activePlan.setIsFree(userPlan.getPlan().getIsFree());
							if(userPlan.getStartDate() != null)
							{
								activePlan.setStartDay(userPlan.getStartDate().getDay());
								activePlan.setStartMonth(userPlan.getStartDate().getMonth());
								activePlan.setStartMonth(userPlan.getStartDate().getMonth());
							}
							if(userPlan.getEndDate() != null)
							{
								activePlan.setEndDay(userPlan.getEndDate().getDay());
								activePlan.setEndMonth(userPlan.getEndDate().getMonth());
								activePlan.setEndMonth(userPlan.getEndDate().getMonth());
							}
							if(userPlan.getBalanceAmount() != null)
							activePlan.setBalance(userPlan.getBalanceAmount());							
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch fetchActivePlans: "+ex.getMessage());
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
		return activePlan;
	}
	public static boolean deActivateUserPlan(Integer userPlanId)
	{
		boolean isSuccess = false;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- deActivateUserPlan ------------> userPlanId:  "+userPlanId);
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
					
					UserPlan userPlan = new UserPlan();
					userPlan.setUserPlanId(userPlanId);
					userPlan.setIsActive(SportConstrant.NO);
					session.update(userPlan);
					session.beginTransaction().commit();
					isSuccess = true;
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch deActivateUserPlan: "+ex.getMessage());
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
		logger.info("--------------- Returning DeActiveate Success:  "+isSuccess);
		return isSuccess;
	}
	public static double deductPointFromUserPlan(Integer userPlanId,double point) throws Exception
	{
		double balance =0;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- deductPointFromUserPlan ------------> userPlanId:  "+userPlanId+" , point: "+point);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			throw new Exception("Session Facoty is null");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					UserPlan userPlan = (UserPlan)session.load(UserPlan.class, userPlanId);
					balance = userPlan.getBalanceAmount() - point;
					userPlan.setBalanceAmount(balance);
					//session.update(userPlan);
					session.beginTransaction().commit();
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
				throw new Exception("Session  is null");
			}
		}
		logger.info("--------------- Returning balance After Deduction:  "+balance);
		return balance;
	}
	
	public static boolean addDefaultPlanToUser(String userId)
	{
		double balance =0;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- addDefaultPlanToUser ------------> userId:  "+userId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.error("Session Facoty is null");
			return false;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					logger.info("----- Trying to insert defaul plan for user");
					SQLQuery query = session.createSQLQuery(QueryConstrant.INSERT_DEFAULT_USER_PLAN);
					query.setParameter("userId", new Integer(userId));
					query.executeUpdate();
					session.beginTransaction().commit();
				}
				catch(Exception ex)
				{
					logger.error("---- Getting error to inser defualt plan to user: "+ex);
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					setErrorMessage("Technical Error");
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
				logger.error("Session  is null");
				return false;
			}
		}
		logger.info("--------------- Defualt Plan for user is added  ");
		return true;
	}
	public static double addPointToUserPlan(Integer userPlanId,double point) throws Exception
	{
		double balance =0;
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- addPointToUserPlan ------------> userPlanId:  "+userPlanId+" , point: "+point);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			throw new Exception("Session Facoty is null");
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					UserPlan userPlan = (UserPlan)session.load(UserPlan.class, userPlanId);
					balance = userPlan.getBalanceAmount() + point;
					userPlan.setBalanceAmount(balance);
					//session.update(userPlan);
					session.beginTransaction().commit();
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
				throw new Exception("Session  is null");
			}
		}
		logger.info("--------------- Returning balance After Adding:  "+balance);
		return balance;
	}
	public static String fetchFreeWildCardPlanId()
	{
		setErrorMessage("");
		String freeWildCardPlanId = "";
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchFreeWildCardPlanId ------------>");
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
					Criteria cr = session.createCriteria(LeaguePlan.class);
					cr.add(Restrictions.eq("isActive", SportConstrant.YES));
					cr.add(Restrictions.eq("isFree", SportConstrant.YES));
					cr.add(Restrictions.eq("planTypeVal", 1));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- Active Free Wild card does not found--");
					}
					else
					{
						LeaguePlan leaguePlan = (LeaguePlan)results.get(0);	
						freeWildCardPlanId = leaguePlan.getPlanId().toString();
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch free WildCard PlanId: "+ex.getMessage());
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
		logger.info("---------- Returning free wild card league plan Id: "+freeWildCardPlanId);
		return freeWildCardPlanId;
	}
	public static List<LeaguePlan> fetchNonFreeActivePlan()
	{
		setErrorMessage("");
		List<LeaguePlan> purchableActivePlanList = new ArrayList<LeaguePlan>();
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchFreeWildCardPlanId ------------>");
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
					Criteria cr = session.createCriteria(LeaguePlan.class);
					cr.add(Restrictions.eq("isActive", SportConstrant.YES));
					cr.add(Restrictions.eq("isFree", SportConstrant.NO));
					purchableActivePlanList = cr.list();
					if(purchableActivePlanList == null || purchableActivePlanList.size() ==0)
					{
						logger.info(" ------- Active Pucrchable Wild card does not found--");
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch free WildCard PlanId: "+ex.getMessage());
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
		logger.info("---------- Returning purchable Plan List "+purchableActivePlanList);
		return purchableActivePlanList;
	}
	public static boolean isWildCardPlanUsed(String wildCardPlanId,String userId)
	{
		setErrorMessage("");
		boolean isWildCardPlanUsed = false;
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- isWildCardPlanUsed ------------> : wildCardPlanId: "+wildCardPlanId+" ,, userId :"+userId);
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
					Criteria cr = session.createCriteria(UserPlan.class);
					User user = new User();
					user.setUserId(new Integer(userId));
					LeaguePlan leaguePlan = new LeaguePlan();
					leaguePlan.setPlanId(new Integer(wildCardPlanId));
					cr.add(Restrictions.eq("user", user));
					cr.add(Restrictions.eq("plan", leaguePlan));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- isWildCardPlanUsed not found ");
					}
					else
					{
						isWildCardPlanUsed = true;
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception fetch isWildCardPlanUsed: "+ex.getMessage());
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
		logger.info("---------- Returning isWildCardPlanUsed "+isWildCardPlanUsed);
		return isWildCardPlanUsed;
	}
	
	public static String fetchDefualtDiscount()
	{
		setErrorMessage("");
		String defultDiscountId = "";
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- fetchDefualtDiscount ------------>");
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
					Criteria cr = session.createCriteria(PlanDiscount.class);
					cr.add(Restrictions.eq("isActive", SportConstrant.YES));
					cr.add(Restrictions.eq("planId", 0));
					cr.add(Restrictions.eq("userId", 0));
					cr.add(Restrictions.eq("planDiscountValue", (double)0));
					List results = cr.list();
					if(results == null || results.size() ==0)
					{
						logger.info(" ------- No Defult plan discount found ");
					}
					else
					{
						PlanDiscount planDiscount = (PlanDiscount)results.get(0);	
						defultDiscountId = planDiscount.getPlanDiscountId().toString();
					}
				}
				catch(Exception ex)
				{
					logger.error("Exception Defult Plan Discount ID:  "+ex.getMessage());
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
		logger.info("---------- Returning defultDiscountId: "+defultDiscountId);
		return defultDiscountId;
	}
	
	public static boolean doEntryForUsrPlan(Map userPlanMap)
	{
		setErrorMessage("");
		boolean isDone = false;
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- doEntryForUsrPlan ------------> userPlanMap: "+userPlanMap);
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
					logger.info("----------- Started to make enty in user plan -----");
					UserPlan userPlan = new UserPlan();
					LeaguePlan leaguePlan = (LeaguePlan)session.load(LeaguePlan.class,new Integer((String)userPlanMap.get("planId")));
					userPlan.setPlan(leaguePlan);
					
					User user = (User)session.load(User.class,new Integer((String)userPlanMap.get("userId")));
					userPlan.setUser(user);
					
					if(userPlanMap.get("planDiscountId") != null && !userPlanMap.get("planDiscountId").equals(""))
					{
						PlanDiscount planDiscount = (PlanDiscount)session.load(PlanDiscount.class,new Integer((String)userPlanMap.get("planDiscountId")));
						userPlan.setPlanDiscount(planDiscount);
					}
					if(userPlanMap.get("transactionId") != null && !userPlanMap.get("transactionId").equals(""))
					{
						UserPayment payment = new UserPayment();
						payment.setTransactionId(new Integer((String)userPlanMap.get("transactionId")));
						userPlan.setPayment(payment);
					}
					if(userPlanMap.get("planDesc") != null && !userPlanMap.get("planDesc").equals(""))
					{
						userPlan.setPlanDesc((String)userPlanMap.get("planDesc"));
					}
					
					if(userPlanMap.get("currency") != null && !userPlanMap.get("currency").equals(""))
					{
						userPlan.setCurrency((String)userPlanMap.get("currency"));
					}
					
					if(userPlanMap.get("balanceAmount") != null && !userPlanMap.get("balanceAmount").equals(""))
					{
						userPlan.setBalanceAmount(new Double((String)userPlanMap.get("balanceAmount")));
					}
					
					if(userPlanMap.get("startDate") != null && !userPlanMap.get("startDate").equals(""))
					{
						userPlan.setStartDate((Date)userPlanMap.get("startDate"));
					}
					
					if(userPlanMap.get("endDate") != null && !userPlanMap.get("endDate").equals(""))
					{
						userPlan.setEndDate(new Date(((Timestamp)userPlanMap.get("endDate")).getTime()));
					}
					userPlan.setIsActive(SportConstrant.YES);
					logger.info("----------- Making entry for user plan table-----");
					session.save(userPlan);
					logger.info("----------- Commiting to database -----");
					session.beginTransaction().commit();
					logger.info("----------- Done completely -----");
					isDone = true;
				}
				catch(Exception ex)
				{
					logger.error("Exception Defult Plan Discount ID:  "+ex.getMessage());
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
		logger.info("---------- Returning isDone: "+isDone);
		return isDone;
	}
	
	public static boolean inActivePlansOfUser(String userId)
	{
		setErrorMessage("");
		SessionFactory factory = HibernateSessionFactory.getSessionFacotry();
		logger.info("--------------- inActivePlansOfUser ------------> userId:  "+userId);
		if(factory == null)
		{
			setErrorCode(ErrorConstrant.SESS_FACT_NULL);
			setErrorMessage("Technical Error");
			logger.error("Session Facoty is null");
			return false;
		}
		else
		{
			Session session = factory.openSession();
			if(session != null)
			{
				try
				{
					
					logger.info("----- Trying to make plan of user as inactive");
					SQLQuery query = session.createSQLQuery(QueryConstrant.MAKE_USER_PLAN_INACTIVE);
					query.setParameter("userId", new Integer(userId));
					query.executeUpdate();
					session.beginTransaction().commit();
				}
				catch(Exception ex)
				{
					logger.error("---- Error to inActivePlansOfUser: "+ex);
					setErrorCode(ErrorConstrant.TRANSACTION_ERROR);
					setErrorMessage("Technical Error");
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
				logger.error("Session  is null");
				return false;
			}
		}
		logger.info("--------------- User Plans has been made as inactive ");
		return true;
	}
}
