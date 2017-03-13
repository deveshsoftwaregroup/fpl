package com.sportmgmt.controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportmgmt.controller.bean.ActivePlan;
import com.sportmgmt.controller.bean.User;
import com.sportmgmt.model.entity.UserPlan;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.PlanManager;
import com.sportmgmt.model.manager.UserManager;
import com.sportmgmt.utility.common.GenerateHashCode;
import com.sportmgmt.utility.common.LeaguePlanUtil;
import com.sportmgmt.utility.common.MailUtility;
import com.sportmgmt.utility.common.PropertyFileUtility;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

@Controller
@RequestMapping("/payment")
public class PaymentAction {
	private Logger logger = Logger.getLogger(PaymentAction.class);
	MailUtility mailUtility;
	public MailUtility getMailUtility() {
		return mailUtility;
	}
	public void setMailUtility(MailUtility mailUtility) {
		this.mailUtility = mailUtility;
	}
	@Autowired
	PropertyFileUtility propFileUtility;
	public PropertyFileUtility getPropFileUtility() {
		return propFileUtility;
	}
	public void setPropFileUtility(PropertyFileUtility propFileUtility) {
		this.propFileUtility = propFileUtility;
	}
	@RequestMapping(value = "MakePayment", method = RequestMethod.POST)
	public String makePayment(ModelMap modeMap,@RequestParam Map<String,String> paymentMap,HttpServletRequest request)
	{
		boolean isFieldsAvail = true;
		boolean isTransactionBegin = false;
		if(paymentMap.get("leaguePlanId") == null || paymentMap.get("leaguePlanId").equals(""))
		{
			isFieldsAvail = false;
			modeMap.put("errorMessage", "Parameter missing");
			modeMap.put("leaguePlanIdError", "leaguePlanId missing");
		}
		if(paymentMap.get("planDiscountId") == null || paymentMap.get("planDiscountId").equals(""))
		{
			isFieldsAvail = false;
			modeMap.put("errorMessage", "Parameter missing");
			modeMap.put("planDiscountIdError", "planDiscountId missing");
		}
		if(paymentMap.get("amount") == null || paymentMap.get("amount").equals(""))
		{
			isFieldsAvail = false;
			modeMap.put("errorMessage", "Parameter missing");
			modeMap.put("amountError", "amount missing");
		}
		String firstName = null;
		String userId = null;
		String contactNumber = null;
		String email = null;
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user !=null && user.getUserId() != null && !user.getUserId().equals(SportConstrant.NULL))
		{
			userId = user.getUserId().toString();
			paymentMap.put("userId",userId);
		}
		else
		{
			isFieldsAvail = false;
			modeMap.put("errorMessage", "User Id missing");
		}
		if(user !=null && user.getDisplayName() != null && !user.getDisplayName().equals(SportConstrant.NULL))
		{
			firstName = user.getDisplayName().split(" ")[0];
		}
		else
		{
			isFieldsAvail = false;
			modeMap.put("errorMessage", "First Name missing");
		}
		if(user !=null && user.getEmailId() != null && !user.getEmailId().equals(SportConstrant.NULL))
		{
			email = user.getEmailId();
		}
		else
		{
			isFieldsAvail = false;
			modeMap.put("errorMessage", "First Name Id missing");
		}
		String surl = null;
		String furl = null;
		String curl = null;
		String paymentURL = null;
		String merchantId = null;
		try
		{
			surl = propFileUtility.getEnvProperty().getString(SportConstrant.BASE_URL)+propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_SUCS_URL);
			furl = propFileUtility.getEnvProperty().getString(SportConstrant.BASE_URL)+propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_FAIL_URL);
			curl = propFileUtility.getEnvProperty().getString(SportConstrant.BASE_URL)+propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_CANCEL_URL);
			paymentURL = propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_URL);
			merchantId = propFileUtility.getEnvProperty().getString(SportConstrant.MERCHANT_ID);
			paymentMap.put("merchantId",merchantId);
		}
		catch(Exception ex)
		{
			logger.error("Exception while  reading from properties file: "+ex.getMessage()); 
			isFieldsAvail = false;
			modeMap.put("errorMessage", "Missing key from property file");
		}
		if(isFieldsAvail)
		{
			Integer transactionId = PlanManager.createTransaction(paymentMap);
			if(transactionId != null)
			{
				String udf1 ="",udf2="",udf3="",udf4="",udf5="";
				isTransactionBegin = true;
				modeMap.put("txnid", transactionId);
				logger.info("----- txnid: "+transactionId);
				modeMap.put("key", merchantId);
				logger.info("----- key: "+merchantId);
				String amount =paymentMap.get("amount");
				modeMap.put("amount", amount);
				logger.info("----- amount: "+amount);
				String productInfo = "User_"+userId+"-Plan_"+paymentMap.get("leaguePlanId")+"-Discount_"+paymentMap.get("planDiscountId");
				modeMap.put("productinfo", productInfo);
				logger.info("----- productinfo: "+productInfo);
				modeMap.put("firstname", firstName);
				logger.info("----- firstName: "+firstName);
				modeMap.put("email", email);
				logger.info("----- email: "+email);
				modeMap.put("phone", contactNumber);
				logger.info("----- phone: "+contactNumber);
				modeMap.put("surl", surl);
				logger.info("----- surl: "+surl);
				modeMap.put("furl", furl);
				logger.info("----- furl: "+furl);
				modeMap.put("curl", curl);
				logger.info("----- curl: "+curl);
				modeMap.put("paymentURL", paymentURL);
				logger.info("----- paymentURL: "+paymentURL);
				try
				{
					String SALT = propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_SALT);
					logger.info("----- SALT: "+SALT);
					String shaKey = propFileUtility.getEnvProperty().getString(SportConstrant.SHA_KEY_FOR_PAYMENT);
					String data= merchantId+"|"+transactionId+"|"+amount+"|"+productInfo+"|"+firstName+"|"+email+"|"+udf1+"|"+udf2+"|"+udf3+"|"+udf4+"|"+udf5+"||||||"+SALT;
					String hash = GenerateHashCode.generate(data, shaKey);
					modeMap.put("hash", hash);
					logger.info("----- hash: "+hash);
				}
				catch (Exception ex)
				{
					logger.error("Exception while generating hash : "+ex.getMessage()); 
					isTransactionBegin = false;
					modeMap.put("errorMessage", "Error to generte hash value for payment");
					Map<String,String> updatePayment = new HashMap<String,String>();
					updatePayment.put("transactionId", transactionId.toString());
					updatePayment.put("message", "Error to generte hash value for payment");
					PlanManager.updateTransaction(updatePayment);
				}
			}
			else
			{
				modeMap.put("errorMessage", "Sorry, Transaction is not started");
			}
		}
			
		if(isTransactionBegin)
		return SportConstrant.MAKE_PAYMENT_SUCCESS_PAGE;
		else
		return SportConstrant.MAKE_PAYMENT_ERROR_PAGE;
	}
	@RequestMapping(value = "SuccessView", method = RequestMethod.POST)
	public String suceess(ModelMap modelMap,@RequestParam Map<String,String> paymentMap,HttpServletRequest request)
	{
		logger.info("------Response From Payment Gateway  "+paymentMap);
		boolean updateTrasaction = PlanManager.updateTransaction(paymentMap);
		logger.info("-------------------- Update Transaction is true: "+updateTrasaction);
		if(updateTrasaction)
		{
			HttpSession session = request.getSession();
			User user =(User) session.getAttribute("user");
			if(LeaguePlanUtil.activatePlanForUser(PlanManager.getLeaguePlanId(), (String)session.getAttribute("userId"), PlanManager.getPlanDiscountId(), paymentMap.get("txnid")))
			{
				modelMap.put("isSuccess", true);
				modelMap.put("message", "Plan is activated");
				ActivePlan activePlan = PlanManager.getActivePlans(String.valueOf(user.getUserId()));
				 if(activePlan == null)
				 {
					 logger.info("---------- Setting User has not active Plan");
					 user.setHasActivePlan(false);
				 }
				 else
				 {
					 logger.info("---------- Setting User has active Plan");
					 user.setHasActivePlan(true);
					 user.setActivePlan(activePlan);
					 logger.info(activePlan);
				 }
				
			}
			else
			{
				modelMap.put("isSuccess", false);
				modelMap.put("message", "Plan is not activated");
			}
		}
		modelMap.addAllAttributes(paymentMap);
		return  SportConstrant.PAYMENT_RESULT_PAGE;
	}
	@RequestMapping(value = "FailureView", method = RequestMethod.POST)
	public String failure(ModelMap modeMap,@RequestParam Map<String,String> paymentMap,HttpServletRequest request)
	{
		logger.info("------Response From Payment Gateway  "+paymentMap);
		boolean updateTrasaction = PlanManager.updateTransaction(paymentMap);
		logger.info("-------------------- Update Transaction is true: "+updateTrasaction);
		modeMap.addAllAttributes(paymentMap);
		return  SportConstrant.PAYMENT_RESULT_PAGE;
	}
	@RequestMapping(value = "DoPayment", method = RequestMethod.GET)
	public String doPayment(ModelMap modeMap,@RequestParam Map<String,String> paymentMap,HttpServletRequest request)
	{
		
		String surl = null;
		String furl = null;
		String curl = null;
		String paymentURL = null;
		String merchantId = null;
		try
		{
			surl = propFileUtility.getEnvProperty().getString(SportConstrant.BASE_URL)+propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_SUCS_URL);
			furl = propFileUtility.getEnvProperty().getString(SportConstrant.BASE_URL)+propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_FAIL_URL);
			curl = propFileUtility.getEnvProperty().getString(SportConstrant.BASE_URL)+propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_CANCEL_URL);
			paymentURL = propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_URL);
			merchantId = propFileUtility.getEnvProperty().getString(SportConstrant.MERCHANT_ID);
			paymentMap.put("merchantId",merchantId);
		}
		catch(Exception ex)
		{
			logger.error("Exception while  reading from properties file: "+ex.getMessage()); 
			modeMap.put("errorMessage", "Missing key from property file");
		}
				String udf1 ="",udf2="",udf3="",udf4="",udf5="";
				modeMap.put("txnid", "12345678");
				//logger.info("----- txnid: "+transactionId);
				modeMap.put("key", merchantId);
				logger.info("----- key: "+merchantId);
				//String amount =paymentMap.get("amount");
				modeMap.put("amount", "1");
				//logger.info("----- amount: "+amount);
				String productInfo = "Product";
				modeMap.put("productinfo", productInfo);
				logger.info("----- productinfo: "+productInfo);
				modeMap.put("firstname", "Ravi");
				//logger.info("----- firstName: "+firstName);
				modeMap.put("email", "wrshastry@gmail.com");
				//logger.info("----- email: "+email);
				modeMap.put("phone", "8860735095");
				//logger.info("----- phone: "+contactNumber);
				modeMap.put("surl", surl);
				logger.info("----- surl: "+surl);
				modeMap.put("furl", furl);
				logger.info("----- furl: "+furl);
				modeMap.put("curl", curl);
				logger.info("----- curl: "+curl);
				modeMap.put("paymentURL", paymentURL);
				logger.info("----- paymentURL: "+paymentURL);
				try
				{
					String SALT = propFileUtility.getEnvProperty().getString(SportConstrant.PAYMENT_SALT);
					logger.info("----- SALT: "+SALT);
					String shaKey = propFileUtility.getEnvProperty().getString(SportConstrant.SHA_KEY_FOR_PAYMENT);
					String data= merchantId+"|12345678|1|"+productInfo+"|Ravi|wrshastry@gmail.com|"+udf1+"|"+udf2+"|"+udf3+"|"+udf4+"|"+udf5+"||||||"+SALT;
					String hash = GenerateHashCode.generate(data, shaKey);
					modeMap.put("hash", hash);
					logger.info("----- hash: "+hash);
				}
				catch (Exception ex)
				{
					logger.error("Exception while generating hash : "+ex.getMessage()); 
					modeMap.put("errorMessage", "Error to generte hash value for payment");
					Map<String,String> updatePayment = new HashMap<String,String>();
					updatePayment.put("message", "Error to generte hash value for payment");
					PlanManager.updateTransaction(updatePayment);
				}
			
			
		return SportConstrant.MAKE_PAYMENT_SUCCESS_PAGE;
		
	}
}
