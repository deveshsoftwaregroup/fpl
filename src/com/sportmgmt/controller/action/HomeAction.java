package com.sportmgmt.controller.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sportmgmt.model.entity.PointCategory;
import com.sportmgmt.model.manager.CouponManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.UserManager;
import com.sportmgmt.utility.common.CouponUtility;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.vendor.model.manager.VendorArticleUpdateManager;
import com.sportmgmt.vendor.model.manager.VendorManager;
import com.sportmgmt.vendor.model.entity.V_Article;
import com.sportmgmt.utility.common.CouponUtility;

@Controller
public class HomeAction {
	private Logger logger = Logger.getLogger(HomeAction.class);
	@Autowired
	private CouponUtility couponUtility;

	public CouponUtility getCouponUtility() {
		return couponUtility;
	}

	public void setCouponUtility(CouponUtility couponUtility) {
		this.couponUtility = couponUtility;
	}
	@RequestMapping("/Welcome")
	public ModelAndView welcome(ModelMap map)
	{
		//UserManager.getCountryStateCityMap();
		//return SportConstrant.LEAGE_HOME_PAGE;
		return new ModelAndView("redirect:/mvc/LeagueHome");

	}
	@RequestMapping("/Welcome1")
	public ModelAndView welcome1(ModelMap map)
	{
		//Integer point = couponUtility.calculateDreamElevenPrizeAmount(50, "DE_WEEKLY_AMOUNT");
		
		//System.out.println("point"+point);
		return new ModelAndView("redirect:/mvc/LeagueHome");

	}
	@RequestMapping("/VendorHome")
	public String VendorHome(ModelMap map,HttpServletRequest request)
	{
		TreeMap<String,HashMap<String,ArrayList<String>>> countryMap = UserManager.getCountryStateCityMap();
		logger.info("--------- League Home , countryMap: "+countryMap);
		map.put("countryMap", countryMap);
		TreeMap<String,HashMap<String,ArrayList<String>>> clubMap = UserManager.getClubMap();
		map.put("clubMap", clubMap);
		List positionPriceList = VendorArticleUpdateManager.fetchPositionPriceIdByVendorId("1");
		
		
		return SportConstrant.VENDOR_HOME_PAGE;

	}
	
	@RequestMapping("/LeagueHome")
	public String leagueHome(ModelMap map,HttpServletRequest request,String pageName)
	{
		TreeMap<String,HashMap<String,ArrayList<String>>> countryMap = UserManager.getCountryStateCityMap();
		logger.info("--------- League Homee , countryMap: "+countryMap);
		logger.info(System.getProperty("catalina.base"));
		logger.info(System.getProperty("catalina.home"));
		logger.info(System.getenv("CATALINA_HOME"));
		map.put("countryMap", countryMap);
		TreeMap<String,HashMap<String,ArrayList<String>>> clubMap = UserManager.getClubMap();
		map.put("clubMap", clubMap);
		/*String planId = GameWeeKManager.fetchPlanIdFromDeGameWeekReport(2, 1);
		System.out.println(planId);*/
		HashMap<String,List<V_Article>> articleMap= VendorManager.fetchPositionIdByPageName(pageName);
		map.put("articleMap", articleMap);
		System.out.println("articleMapppppppp"+articleMap);
		//map.put("displayPromotionPopup", "true");
		//String promotion = "true";
		//request.setAttribute("promotion", promotion);
		
		
		return SportConstrant.LEAGE_HOME_PAGE;

	}
	@RequestMapping("/LeagueHomeWithPromotion")
	public String leagueHomeWithPromotion(ModelMap map,HttpServletRequest request)
	{
		TreeMap<String,HashMap<String,ArrayList<String>>> countryMap = UserManager.getCountryStateCityMap();
		logger.info("--------- League Home , countryMap: "+countryMap);
		map.put("countryMap", countryMap);
		TreeMap<String,HashMap<String,ArrayList<String>>> clubMap = UserManager.getClubMap();
		map.put("clubMap", clubMap);
		map.put("displayPromotionPopup", "true");
		String promotion = "true";
		request.setAttribute("promotion", promotion);
		return SportConstrant.LEAGE_HOME_PAGE;

	}
	@RequestMapping("/LeagueLandingHome")
	public String userLandingHome(ModelMap map)
	{
		logger.info("--------- USER_LANDING_HOME_PAGE");
		TreeMap<String,HashMap<String,ArrayList<String>>> countryMap = UserManager.getCountryStateCityMap();
		logger.info("--------- League Home , countryMap: "+countryMap);
		map.put("countryMap", countryMap);
		TreeMap<String,HashMap<String,ArrayList<String>>> clubMap = UserManager.getClubMap();
		map.put("clubMap", clubMap);
		return SportConstrant.LEAGUE_LANDING_HOME_PAGE;

	}
	
	@RequestMapping(value = "HomeGameGuide", method = RequestMethod.GET)
	public  String homeGameGuide(ModelMap modeMap,HttpServletRequest request)
	{
		logger.info("---------- Forwardng to : "+SportConstrant.HOME_GAME_GUIDE);
		 return SportConstrant.HOME_GAME_GUIDE;
	}
	@RequestMapping(value = "PrivacyPolicy", method = RequestMethod.GET)
	public  String PrivacyPolicy(ModelMap modeMap,HttpServletRequest request)
	{
		logger.info("---------- Forwardng to : "+SportConstrant.PRIVACY_POLICY);
		 return SportConstrant.PRIVACY_POLICY;
	}
	@RequestMapping(value = "AboutUs", method = RequestMethod.GET)
	public  String AboutUs(ModelMap modeMap,HttpServletRequest request)
	{
		logger.info("---------- Forwardng to : "+SportConstrant.PRIVACY_POLICY);
		 return SportConstrant.ABOUT_US;
	}
	@RequestMapping(value = "HomeGuide", method = RequestMethod.GET)
	public  String homeGuide(ModelMap map,HttpServletRequest request)
	{
		TreeMap<String,HashMap<String,ArrayList<String>>> countryMap = UserManager.getCountryStateCityMap();
		logger.info("--------- League Home , countryMap: "+countryMap);
		map.put("countryMap", countryMap);
		TreeMap<String,HashMap<String,ArrayList<String>>> clubMap = UserManager.getClubMap();
		map.put("clubMap", clubMap);
		logger.info("---------- Forwardng to : "+SportConstrant.HOME_GUIDE);
		 return SportConstrant.HOME_GUIDE;
	}
	@RequestMapping("/LeagueLogin")
	public String login(ModelMap map)
	{
		//UserManager.getCountryStateCityMap();
		return SportConstrant.LEAGE_LOGIN_PAGE;
	}
	@RequestMapping(value = "FAQView", method = RequestMethod.GET)
	public  String fAQView(ModelMap modeMap)
	{
		logger.info("---------- IN FAQView");
		return SportConstrant.FAQ_PAGE;
	}
	@RequestMapping(value = "RulesView", method = RequestMethod.GET)
	public  String rulesView(ModelMap modeMap)
	{
		logger.info("IN RulesView ");
		return SportConstrant.RULES_PAGE;
	}
}
