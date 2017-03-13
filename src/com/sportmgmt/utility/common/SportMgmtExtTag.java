package com.sportmgmt.utility.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.sportmgmt.controller.action.UserAction;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.utility.constrant.SportConstrant;

public class SportMgmtExtTag extends TagSupport{
	private Logger logger = Logger.getLogger(SportMgmtExtTag.class);
	private String retrieve;
	
	public String getRetrieve() {
		return retrieve;
	}

	public void setRetrieve(String retrieve) {
		this.retrieve = retrieve;
	}

	public int doStartTag() throws JspException {  
	    //JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try{  
	     //out.print(Calendar.getInstance().getTime());//printing date and time using JspWriter
	    	
		    	//pageContext.setAttribute("name", "My name is Gentle Man");
		    	boolean isPlayerAvail = false;
		    	String gameClubPlayerId = "";
		    	if(retrieve !=null && !retrieve.equals(""))
		    	{
		    		switch(retrieve)
		    		{
		    			case "priceList": pageContext.setAttribute(retrieve, getPriceList());
		    			break;
		    			case "deadLine": refreshDeadline();
		    			break;
		    		}
		    	}
	    	}
	    	catch(Exception ex)
	    	{
	    		logger.error("--- Error: "+ex);
	    	}
	    	return SKIP_BODY;//will not evaluate the body content of the tag  
	}  
	public TreeSet getPriceList()
	{
		logger.info("---------- Entry in getPriceList: ");
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
    	HttpSession session = request.getSession();
		TreeSet priceList = new TreeSet();
		ArrayList playerList = (ArrayList)session.getAttribute("playerList");
		if(playerList != null && playerList.size() > 0)
		{
			for(Object playerObj:playerList)
			{
				Map<String,String> playerMap = (Map<String,String>)playerObj;
				priceList.add(playerMap.get("price"));
			}
		
		}
		logger.info("---------- Returning in price List: "+priceList);
	return priceList;
	}
	public void refreshDeadline()
	{
		 /* code start related deadline of game week */
		 pageContext.setAttribute("isUnderDeadline", false);
		 HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
    	 HttpSession session = request.getSession();
    	 String gameId = null;
    	 if(session.getAttribute("gameDetails") != null)
    	 {
    		 gameId = (String)((HashMap)session.getAttribute("gameDetails")).get("gameId");
    	 }
    	 if(gameId != null && !gameId.equals(""))
    	 {
    		 List<Object[]> currentGameWeek = GameManager.fetchCurrenGametWeek(new Integer(gameId));
    		 if(currentGameWeek == null || currentGameWeek.size() ==0)
    		 {
    			 currentGameWeek = GameManager.fetchStartGametWeek(new Integer(gameId));
    		 }
    		 logger.info("Current Game Week: "+currentGameWeek);
    		 if(currentGameWeek != null && currentGameWeek.size() > 0)
    		 {
    			 Integer gameWeekId = (Integer)currentGameWeek.get(0)[0];
    			 logger.info("--------------- currentGameWeek: Game week ID: "+gameWeekId+"  , Date: "+currentGameWeek.get(0)[1]);
    			 List<Timestamp> firstMatchOfGameWeek = GameManager.fetchFirstMatchOfGameWeek(gameWeekId);
    			 logger.info("First Match of  Game Week: "+firstMatchOfGameWeek);
    			 int gameWeekNumber = GameManager.getGameWeekNumber(gameWeekId,new Integer(gameId));
    			 logger.info(" Game Week Number : "+gameWeekNumber);
    			 pageContext.setAttribute("gameWeekNumber", gameWeekNumber);
    			 if(firstMatchOfGameWeek != null && firstMatchOfGameWeek.size() >=0)
    			 {
    				 logger.info("First Match of  Game Week:  "+firstMatchOfGameWeek.get(0));
    				 Timestamp startTimeOfFirstMatch = firstMatchOfGameWeek.get(0);
    				 int startHour = startTimeOfFirstMatch.getHours();
    				 int startMin = startTimeOfFirstMatch.getMinutes();
    				 SimpleDateFormat sdfStart = new SimpleDateFormat("dd MMM");
    				 String formatedStartTime = sdfStart.format(startTimeOfFirstMatch);
    				 int deadLineHrsBeforeStart = 0;
    				 int deadLineHrsAfterEnd = 0;
    				 try
    				 {
    					 PropertyFileUtility  propFileUtility = new PropertyFileUtility();
    					 deadLineHrsBeforeStart = Integer.parseInt(propFileUtility.getEnvProperty().getString(SportConstrant.DEADLINE_START_HRS));
    					  deadLineHrsAfterEnd = Integer.parseInt(propFileUtility.getEnvProperty().getString(SportConstrant.DEADLINE_END_HRS));
    				 }
    				 catch(Exception ex)
    				 {
    					 logger.error("Exception from reading and parsing : "+ex.getMessage());
    				 }
    				 
    				 String deadline = formatedStartTime +" "+ (startHour-deadLineHrsBeforeStart) + ":"+startMin;
    				 logger.info("--------- Game Week: deadline  -- :"+deadline);
    				 pageContext.setAttribute("deadline", deadline);
    				 List<Timestamp> lastMatchOfGameWeek = GameManager.lastFirstMatchOfGameWeek(gameWeekId);
    				 logger.info("--------------- lastMatchOfGameWeek: "+lastMatchOfGameWeek);
    				 if(lastMatchOfGameWeek != null && lastMatchOfGameWeek.size() > 0 )
    				 {
    					 Timestamp endTimeOfLastMatch =  lastMatchOfGameWeek.get(0);
    					 long startDeadlineMils = startTimeOfFirstMatch.getTime() - TimeUnit.HOURS.toMillis(deadLineHrsBeforeStart);
    					 long endDeadlineMils = endTimeOfLastMatch.getTime() + TimeUnit.HOURS.toMillis(deadLineHrsAfterEnd);
    					 long currentTimeMils = System.currentTimeMillis();
    					 logger.info("----------- startDeadlineMils: "+startDeadlineMils);
    					 logger.info("----------- endDeadlineMils: "+endDeadlineMils);
    					 logger.info("----------- currentTimeMils: "+currentTimeMils);
    					 if(currentTimeMils >= startDeadlineMils && currentTimeMils <=endDeadlineMils)
    					 {
    						 pageContext.setAttribute("isUnderDeadline", true);
    						 logger.info("----------- isUderDeadline: is true ");
    					 }
    				 }
    			 }
    			 
    		 }
    	 
    	 }
	
	}
}
