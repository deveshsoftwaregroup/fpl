package com.sportmgmt.controller.action;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportmgmt.model.entity.Game;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.UserManager;
import com.sportmgmt.utility.common.MailUtility;
import com.sportmgmt.utility.common.PropertyFileUtility;
import com.sportmgmt.utility.constrant.SportConstrant;

@Controller
public class TestAction {
	private Logger logger = Logger.getLogger(TestAction.class);
	@Autowired
	PropertyFileUtility propFileUtility;
	public PropertyFileUtility getPropFileUtility() {
		return propFileUtility;
	}
	public void setPropFileUtility(PropertyFileUtility propFileUtility) {
		this.propFileUtility = propFileUtility;
	}
	@Autowired
	MailUtility mailUtility;
	public MailUtility getMailUtility() {
		return mailUtility;
	}
	public void setMailUtility(MailUtility mailUtility) {
		this.mailUtility = mailUtility;
	}
	
	@RequestMapping("/hello")
	public String hello(ModelMap map, HttpServletRequest request,@RequestParam("message") String message, @ModelAttribute("message") String message1 )
	{
		System.out.println("Message: "+request.getParameter("message"));
		System.out.println("ModelMap message: "+map.get("message"));
		System.out.println("Request Pram message: "+message);
		System.out.println("Model attribute message : "+message1);
		map.put("message", request.getParameter("message"));
		System.out.println("URLLLL: "+request.getRequestURL()+ " : "+request.getRequestURL()+ " : "+request.getContextPath()+ " : "+request.getLocalAddr()+" : "+request.getServerName()+" : "+request.getServerPort()+" : "+request.getServletPath());
		String URL = "";
		try
		{
			URL = propFileUtility.getEnvProperty().getString(SportConstrant.BASE_URL);
		}
		catch(Exception ex)
		{
			System.out.println(" ----------->Exception to make URL ");
		}
		System.out.println(" ------------ BASE URL : "+URL);
		return "hello";
	}
	@RequestMapping("/login")
	public String hello(ModelMap map)
	{
		//System.out.println("<----------------- Entered By User: ");
		return "login/login";
	}
	
	@RequestMapping("/userLogin")
	public String userLogin(ModelMap map,@RequestParam Map paramMap)
	{
		//System.out.println("---------Model Map :-- User Name: "+map.get("userName"));
		System.out.println("----------- Request Param Map User Name: "+paramMap.get("userName"));
		logger.info("-----------In Logger Request Param Map User Name: "+paramMap.get("userName"));
		HashMap hmap = new HashMap();
		hmap.put("key1","val1");
		hmap.put("key2","val2");
		map.put("userName", paramMap.get("userName"));
		map.put("hmap", hmap);
		map.put("pass", "@@@@");
		return "redirect:/login/loginSuccess.jsp";
		//return "login/loginSuccess";
	}
	@RequestMapping(value = "sendMail", method = RequestMethod.GET)
	public @ResponseBody String sendMail(@RequestParam Map param,HttpServletRequest request)
	{
		try
		{
			param.put(SportConstrant.TO,request.getParameter("to"));
			param.put(SportConstrant.VELOCIYY_FILE_LOC, "com/sportmgmt/utility/vm/test.vm");
			if(param.get("userName") == null || param.get("userName").equals(""))
			{
				param.put("userName", "Mr Test");
			}
			param.put(SportConstrant.SUBJECT, "Test Mail");
			mailUtility.sendHtmlMail(param);
			System.out.println("URLLLL: "+request.getRequestURL()+ " : "+request.getRequestURL()+ " : "+request.getContextPath()+ " : ");
		}
		catch(Exception ex)
		{
			return ex.getMessage();
		}
		return "Mail Sent";
	}
}
