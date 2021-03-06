package com.sportmgmt.utility.common;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.sportmgmt.controller.action.GameAction;
import com.sportmgmt.controller.bean.GameWeekPlan;
import com.sportmgmt.controller.bean.WildCard;
import com.sportmgmt.model.entity.LeaguePlan;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.PlanManager;

public class LeaguePlanUtil {
	
	private static Logger logger = Logger.getLogger(LeaguePlanUtil.class);
	public static String getFreeWildCardId(String userId)
	{
		logger.info("---------- Started getting free wild card in Plan Util ");
		logger.info("---------- Calling PlanManager.fetchFreeWildCardPlanId() ");
		String freeWildCardPlanId = PlanManager.fetchFreeWildCardPlanId();
		if(!freeWildCardPlanId.equals(""))
		{
			if(PlanManager.isWildCardPlanUsed(freeWildCardPlanId, userId))
			freeWildCardPlanId = "";
		}
		logger.info("----------Returning freeWildCardPlanId: in Plan Util : "+freeWildCardPlanId);
		return freeWildCardPlanId;
	}
	public static String getFreeGameWeekPlanId(String userId)
	{
		logger.info("---------- Started getting free game week in Plan Util ");
		logger.info("---------- Calling PlanManager.fetchFreeWildCardPlanId() ");
		String freeGameWeekPlanId = com.sportmgmt.dreamEleven.model.manager.PlanManager.fetchFreePlanId();
		logger.info("----------Returning freeGameWeekPlanId: in Plan Util : "+freeGameWeekPlanId);
		return freeGameWeekPlanId;
	}
	public static boolean activatePlanForUser(String planId,String userId,String planDiscountId,String transactionId)
	{
		logger.info("---------- Started activating Plan for user in Plan Util ");
		Map userPlanMap = new HashMap();
		userPlanMap.put("planId", planId);
		userPlanMap.put("userId", userId);
		if(planDiscountId != null && !planDiscountId.equals(""))
		userPlanMap.put("planDiscountId", planDiscountId);
		if(transactionId != null && !transactionId.equals(""))
		{
			userPlanMap.put("transactionId", transactionId);
			userPlanMap.put("planDesc", "Payment has bee done for this plan");
		}
		else
		userPlanMap.put("planDesc", "This is the free wild Card Plan");
		logger.info("---------- Calling PlanManager.fetchLeaguePlan method ");
		LeaguePlan leaguePlan= PlanManager.fetchLeaguePlan(new Integer(planId));
		if(leaguePlan.getCurrency() != null)
		{
			userPlanMap.put("currency", leaguePlan.getCurrency());
		}
		if(leaguePlan.getPlanTypeVal() == 0)
		{
			userPlanMap.put("balanceAmount", leaguePlan.getTotalNoOfDays());
		}
		else if(leaguePlan.getPlanTypeVal() == 1)
		{
			int totalNumberOfDays = leaguePlan.getTotalNoOfDays();
			List<Timestamp> endDateList = GameManager.fetchEndDateListOfGameWeekFromToday();
			Timestamp endDate = endDateList.get(totalNumberOfDays-1);
			userPlanMap.put("startDate", new java.sql.Date(System.currentTimeMillis()));
			userPlanMap.put("endDate", endDate);
		}
		boolean isDone = false;
		logger.info("---------- Calling PlanManager.inActivePlansOfUser ");
		if(PlanManager.inActivePlansOfUser(userId))
		{
			logger.info("---------- Inactivating plans of user is done completely ");
			isDone = PlanManager.doEntryForUsrPlan(userPlanMap);
		}
		logger.info("---------- Activation for user: "+userId+" of plan: "+planId + " is : "+isDone);
		return true;
	}
	public static List<WildCard> getPurchableWildCardList()
	{
		logger.info("---------- Inside getPurchableWildCardList of Plan Util");
		List<WildCard> purchableWildCardList = new ArrayList<WildCard>();
		logger.info("---------- Calling PlanManager.fetchNonFreeActivePlan()");
		List<LeaguePlan> leaguePlanList = PlanManager.fetchNonFreeActivePlan();
		logger.info("---------------- leaguePlanList: "+leaguePlanList);
		if(leaguePlanList != null && leaguePlanList.size() > 0)
		{
			for(Object leagePlanObj:leaguePlanList)
			{
				LeaguePlan leaguePlan = (LeaguePlan)leagePlanObj;
				WildCard wildCard = new WildCard();
				wildCard.setPlanId(leaguePlan.getPlanId().toString());
				wildCard.setPrice(leaguePlan.getPlanAmount().toString());
				if(leaguePlan.getTotalNoOfDays() == 1)
				wildCard.setName(leaguePlan.getTotalNoOfDays()+" gameweek");
				else
				wildCard.setName(leaguePlan.getTotalNoOfDays()+" gameweeks");	
				purchableWildCardList.add(wildCard);
			}
		}
		logger.info("----------------Returning  purchableWildCardList: "+purchableWildCardList);
		return purchableWildCardList;
	}
	public static String getDefualtPlanDiscountId()
	{
		return PlanManager.fetchDefualtDiscount();
	}
	public static List<GameWeekPlan> getPurchableGameWeekPlanList()
	{
		logger.info("---------- Inside getPurchableGameWeekPlanList of Plan Util");
		List<GameWeekPlan> purchableGameWeekPlanList = new ArrayList<GameWeekPlan>();
		logger.info("---------- Calling PlanManager.fetchNonFreeActivePlan()");
		List<com.sportmgmt.dreamEleven.model.entity.GameWeekPlan> gameWeekPlanList = com.sportmgmt.dreamEleven.model.manager.PlanManager.fetchNonFreeActivePlan();
		logger.info("---------------- gameWeekPlanList: "+gameWeekPlanList);
		if(gameWeekPlanList != null && gameWeekPlanList.size() > 0)
		{
			for(Object gameWeekPlanObj:gameWeekPlanList)
			{
				com.sportmgmt.dreamEleven.model.entity.GameWeekPlan gameWeekPlanEntity = (com.sportmgmt.dreamEleven.model.entity.GameWeekPlan)gameWeekPlanObj;
				GameWeekPlan gameWeekPlan = new GameWeekPlan();
				gameWeekPlan.setPlanId(gameWeekPlanEntity.getPlanId().toString());
				gameWeekPlan.setPrice(gameWeekPlanEntity.getPlanAmount().toString());
				gameWeekPlan.setOfferPrice(gameWeekPlanEntity.getOfferPrice().toString());
				gameWeekPlan.setWinningAmount(gameWeekPlanEntity.getWiningPrice().toString());
				gameWeekPlan.setPlanType(gameWeekPlanEntity.getPlanType().toString());
				/*if(leaguePlan.getTotalNoOfDays() == 1)
					gameWeekPlan.setName(leaguePlan.getTotalNoOfDays()+" gameweek");
				else
					gameWeekPlan.setName(leaguePlan.getTotalNoOfDays()+" gameweeks");	*/
				purchableGameWeekPlanList.add(gameWeekPlan);
			}
		}
		logger.info("----------------Returning  purchableGameWeekPlanList: "+purchableGameWeekPlanList);
		return purchableGameWeekPlanList;
	}
}
