package com.sportmgmt.vendor.controller.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ravij.crypto.EncodeDecoder;
import com.sportmgmt.controller.bean.ActivePlan;
import com.sportmgmt.controller.bean.User;
import com.sportmgmt.controller.bean.WildCard;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PlanManager;
import com.sportmgmt.model.manager.UserManager;
import com.sportmgmt.utility.common.LeaguePlanUtil;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.vendor.model.entity.Vendor;
import com.sportmgmt.vendor.model.manager.VendorArticleUpdateManager;
import com.sportmgmt.vendor.model.manager.VendorManager;

@Controller
@RequestMapping("/vendor")

public class VendorAction {
private Logger logger = Logger.getLogger(VendorAction.class);

@RequestMapping(value = "vendorregister", method = RequestMethod.POST)
public String userRegister(ModelMap modeMap,@RequestParam Map<String,String> vendorMap)
{
	logger.info("Entry in register method model Map: "+modeMap);
	if(vendorMap.get("emailId") == null || vendorMap.get("emailId").equals(SportConstrant.NULL))
	{
		modeMap.put("emailIdError", "emailId is required");
	}
	if(vendorMap.get("displayName") == null || vendorMap.get("displayName").equals(SportConstrant.NULL))
	{
		modeMap.put("displayName", "name is required");
}
	if(vendorMap.get("logonId") == null || vendorMap.get("logonId").equals(SportConstrant.NULL))
	{
		vendorMap.put("logonId", vendorMap.get("emailId"));
	}
	if(vendorMap.get("logonPassword") == null || vendorMap.get("logonPassword").equals(SportConstrant.NULL))
	{
		modeMap.put("logonPasswordError", "User Password is required");
	}
	else
	{
		logger.info("--------- password: "+vendorMap.get("logonPassword"));
		try
		{
			vendorMap.put("logonPassword", EncodeDecoder.encrypt(vendorMap.get("logonPassword")));
			logger.info("--------- password: After Encoding:  "+vendorMap.get("logonPassword"));
		}
		catch(Exception ex)
		{
			logger.error("--------- Error in encoding password: "+ex);
		}
	}
	logger.info("------------ Error Map: "+modeMap);
	if(modeMap.isEmpty())
	{
		boolean isRegistered = VendorManager.saveVendor(vendorMap);
		modeMap.put("isRegistered",isRegistered);
		if(isRegistered)
		{
			modeMap.put("message","Congrats ! You are registered successfully!");
		}
		else
		{
			modeMap.put("message","Your Registration is failed as :  "+UserManager.getErrorMessage());
		}
	}
	else
	{
		modeMap.put("isRegistered",false);
		modeMap.put("message","Your Registration is failed due to incomplete info");
	}
	return "redirect:/mvc/VendorHome";
}
@RequestMapping(value = "validate", method = RequestMethod.GET)
public @ResponseBody Map validateUser(@RequestParam("logonId") String logonId, @RequestParam("logonPassword") String logonPassword)
{
 java.util.Map resultMap = new java.util.HashMap();
 boolean isValidUser = false;
 if(logonId == null || logonId.equals(SportConstrant.NULL))
 {
	 resultMap.put("errorCode", ErrorConstrant.EMPTY_LOGON);
	 resultMap.put("errorMessage", "Email Id cannot be blank");
 }
 if(logonPassword == null || logonPassword.equals(SportConstrant.NULL))
 {
	 resultMap.put("errorCode", ErrorConstrant.EMPTY_PASS);
	 resultMap.put("errorMessage", "Password Can't be blank");
 }
 else
 {
	 logger.info("--------- password: "+logonPassword);
		try
		{
			logonPassword = EncodeDecoder.encrypt(logonPassword);
			logger.info("--------- password: After Encoding:  "+logonPassword);
		}
		catch(Exception ex)
		{
			logger.error("--------- Error in encoding password: "+ex);
		}
 }
 if(resultMap.size() == 0)
 {
	 isValidUser = VendorManager.validateUser(logonId, logonPassword);
	 if(isValidUser)
	 {
		 resultMap.put("vendorId", VendorManager.getVendorId()); 
	 }
	 else
	 {
		 resultMap.put("errorCode", VendorManager.getErrorCode());
		 resultMap.put("errorMessage", VendorManager.getErrorMessage());
	 }
	
}
 resultMap.put("isValidUser", isValidUser);
 return resultMap;
}

@RequestMapping(value = "login/{vendorId}", method = RequestMethod.GET)
public  String doLogin(ModelMap modeMap,@PathVariable String vendorId,HttpServletRequest request)
{
 logger.info("---------- Entry in login  ---- Path Variable vendorId :  "+vendorId);
 List vendorPositionPriceList=VendorArticleUpdateManager.fetchPositionPriceIdByVendorId(vendorId);
 modeMap.put("vendorPositionPriceList", vendorPositionPriceList); 
 //modeMap.clear();
 /*if(userId == null || userId.equals(SportConstrant.NULL))
 {
	 modeMap.put("errorCode", ErrorConstrant.EMPTY_LOGON);
	 modeMap.put("errorMessage", "Invalid URL");
	 modeMap.put("isLogined", false);
 }

 if(modeMap.size() == 0)
 {
	 logger.info("---------- Calling Hibernate get User Method: ");
	 User user = UserManager.getUser(userId);
	 logger.info("---------- Fetche User Object: "+user);
	 if(user != null)
	 {
		 modeMap.put("isLogined", true);
		 logger.info("---------- Fetching Active Plan");
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
		 user.setBalanceCoins(PlanManager.getUserCoins(userId));
		 user.setPlanIdForCoins(PlanManager.getUserPlanIdForUserCoins(userId));
		 logger.info("---------- Getting HTTP Session: "+user);
		 HttpSession session = request.getSession();
		 logger.info("---------- Setting User to Sesison: "+user);
		 session.setAttribute("userId", String.valueOf(user.getUserId()));
		 ArrayList playersList = new ArrayList();
		 ArrayList clubList = new ArrayList();
		 HashMap gameMap = null;
		// List games = GameManager.fetchGames();
		 List games = sortUtility.getApplicationDataUtility().getGames();
		 HashMap userGameMap = new HashMap();
		if(games != null && games.size() ==1)
		{
			gameMap = (HashMap)games.get(0);
			String gameId = (String)gameMap.get("gameId");
			
			if(gameId != null && !gameId.equals(""))
			{
				//GameManager.updateClubListAndPlayersList(playersList, clubList, gameId);
				playersList = sortUtility.getApplicationDataUtility().getPlayersList();
				clubList = sortUtility.getApplicationDataUtility().getClubList();
				playersList = sortUtility.sortPlayerListByPrice(playersList);
				session.setAttribute("playersOrderBy", "price");
				user.setTotalPoint(GameManager.getUserTotalPoint(userId, gameId));
				String gameWeekIdForPlayerTrasfer = pointRankingUtility.gameWeekIdForTransferPlayer(gameId);
				if(gameWeekIdForPlayerTrasfer !=null && !gameWeekIdForPlayerTrasfer.equals(""))
				{
					int gameWeekNumberForTransferPlayer = GameManager.getGameWeekNumber(new Integer(gameWeekIdForPlayerTrasfer),new Integer(gameId));
					int totalTransfered = GameWeeKManager.getTotalTransfered(new Integer(userId), new Integer(gameWeekIdForPlayerTrasfer));
					user.setGameWeekIdForPlayerTransfer(gameWeekIdForPlayerTrasfer);
					user.setGameWeekNumberForPlayerTransfer(gameWeekNumberForTransferPlayer);
					user.setTotalTransferForGameWeek(totalTransfered);
				}
				else
				{
					user.setGameWeekNumberForPlayerTransfer(0);
					user.setTotalTransferForGameWeek(0);
				}
					
			}
			List<Map<String,String>> userPlayersList = GameManager.userPlayerDetailsList(user.getUserId(),Integer.valueOf(gameId)); 
			userGameMap.put("playerList", userPlayersList);
			HashMap totalMap= new HashMap(); 
			int totalPlayers = GameManager.totalPlayersOfUserByGame(user.getUserId(),Integer.valueOf(gameId));
			double totalPrice = GameManager.totalPlayersPriceOfUserByGame(user.getUserId(),Integer.valueOf(gameId));
			totalMap.put("price", totalPrice);
			totalMap.put("player", totalPlayers);
			//System.out.println("---------------- totalMap: "+userGameMap);
			GameManager.updateTotalPlayerByPostion(user.getUserId(),Integer.valueOf(gameId),totalMap);
			userGameMap.put("total", totalMap);
			//System.out.println("---------------- totalMap Now : "+userGameMap);
			user.setUserGameMap(GameManager.getUserGameStatus(userId, gameId));
		}
		if(gameMap != null)
		{
			session.setAttribute("gameDetails", gameMap);
			session.setAttribute("playerList", playersList);
			session.setAttribute("clubList", clubList);
			session.setAttribute("userGameDetails", userGameMap);
			String gameDetailsJson = "";
			String playerListJson = "";
			String clubListJson = "";
			String userGameJson = "";
			String userJson = "";
			 ObjectMapper mapperObj = new ObjectMapper();
			 try
			 {
				 gameDetailsJson = mapperObj.writeValueAsString(gameMap);
				 logger.info("-------- Login : gameDetailsJson: "+gameDetailsJson);
				 playerListJson = mapperObj.writeValueAsString(playersList);
				 logger.info("-------- Login : playerListJson: "+playerListJson);
				 clubListJson = mapperObj.writeValueAsString(clubList);
				 logger.info("-------- Login : clubListJson: "+clubListJson);
				 userGameJson = mapperObj.writeValueAsString(userGameMap);
				 logger.info("-------- Login : userGameJson: "+userGameJson); 
				 userJson = mapperObj.writeValueAsString(user);
				 logger.info("-------- Login : userJson: "+userJson);
				 session.setAttribute("gameDetailsJson", gameDetailsJson);
				 session.setAttribute("playerListJson", playerListJson);
				 session.setAttribute("clubListJson", clubListJson);
				 session.setAttribute("userGameJson", userGameJson);
				 session.setAttribute("userJson", userJson);
			 }
			 catch(Exception ex)
			 {
				 logger.error("---------- Entry in parsing map to json: "+ex);
			 }
			
		}
		 Code start to fetch plan list 
		String freeWildCardPlanId = LeaguePlanUtil.getFreeWildCardId(userId); 
		if(freeWildCardPlanId ==null || freeWildCardPlanId.equals(""))
		{
			session.setAttribute("hasFreeWildCard", false);
			logger.info("------------------- hasFreeWildCard: false");
		}
		else
		{
			session.setAttribute("hasFreeWildCard", true);
			logger.info("------------------- hasFreeWildCard: true");
			session.setAttribute("freeWildCardPlanId", freeWildCardPlanId);
		}
		session.setAttribute("planDiscountId", LeaguePlanUtil.getDefualtPlanDiscountId());
		List<WildCard> purchableWildCardList = LeaguePlanUtil.getPurchableWildCardList();
		session.setAttribute("purchableWildCardList", purchableWildCardList);
		
		try
		{
			ObjectMapper mapperObj = new ObjectMapper();
			String purchableWildCardJson = mapperObj.writeValueAsString(purchableWildCardList);
			session.setAttribute("purchableWildCardJson", purchableWildCardJson);
		}
		catch(Exception ex)
		 {
			 logger.error("---------- Error in parsing map to json: "+ex);
		 }
		 Code end to fetch plan list 
		session.setAttribute("user", user);
	 }
	 else
	 {
		 modeMap.put("isLogined", false);
		 modeMap.put("errorCode", UserManager.getErrorCode());
		 modeMap.put("errorMessage", UserManager.getErrorMessage());
		 if(UserManager.getErrorCode().equals(ErrorConstrant.TRANSACTION_ERROR))
		 modeMap.put("errorMessage", "Invalid URL");
	 }*/
	
//}
 
 logger.info("---------- Redircting to : "+SportConstrant.VENDOR_LOG_IN_PAGE);
 return SportConstrant.VENDOR_LOG_IN_PAGE;
}
	
}

	
	
	
	