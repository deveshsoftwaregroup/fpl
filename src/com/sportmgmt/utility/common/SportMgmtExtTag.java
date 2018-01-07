package com.sportmgmt.utility.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.GameWeeKManager;
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
	//int counter=0;
	Integer gameWeekId=null;
	public void refreshDeadline()
	{
		 /* code start related deadline of game week */
		logger.info("----------- entry in refresh deadline");
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
    		logger.info("inside SportMgmtExt currentGameWeek="+currentGameWeek);
    		 if(currentGameWeek == null || currentGameWeek.size() ==0)
    		 {
    			 logger.info("inside SportMgmtExt going to fetch StartGametWeek");
    			 //fetchStartGametWeek() this method will also give next upcoming gameweek in case
    			 // if current date is not in between of any gameweek
    			 currentGameWeek = GameManager.fetchStartGametWeek(new Integer(gameId));
    			 logger.info("inside SportMgmtExt StartGametWeek.. currentGameWeek="+currentGameWeek);
    		 }
    		 logger.info("Current Game Week: "+currentGameWeek);
    		 if(currentGameWeek != null && currentGameWeek.size() > 0)
    		 {
    			 logger.info("gameWeekId=="+gameWeekId);  
    			 
    			 //This check is used to prevent resetting of current gameWeekId when
    			 //currentGameWeekId has been set to NEXT GAME WEEK ID in case of deadline is open 
    			 //check condition in below lines (else if(currentTimeMils >endDeadlineMils))
    			 if(gameWeekId == null)
    			 {
    				 logger.info("gameWeekId is null. It will be fetched from DB now.");
    				 gameWeekId = (Integer)currentGameWeek.get(0)[0];
    			 }
    			 
    			 logger.info("going to fetch first match of  Game week ID: "+gameWeekId);// , Date: "+currentGameWeek.get(0)[1]);
    			 List<Timestamp> firstMatchOfGameWeek = GameManager.fetchFirstMatchOfGameWeek(gameWeekId);
    			 logger.info("First Match of  Game Week: "+firstMatchOfGameWeek);
    			 int gameWeekNumber = GameManager.getGameWeekNumber(gameWeekId,new Integer(gameId));
    			 logger.info(" Game Week Number : "+gameWeekNumber);
    			 pageContext.setAttribute("gameWeekNumber", gameWeekNumber);
    			 pageContext.setAttribute("gameWeekId", gameWeekId);
    			 if(firstMatchOfGameWeek != null && firstMatchOfGameWeek.size() >0)
    			 {
    				 logger.info("First Match of  Game Week:  "+firstMatchOfGameWeek.get(0));
    				 Timestamp startTimeOfFirstMatch = firstMatchOfGameWeek.get(0);
    				 int startHour = startTimeOfFirstMatch.getHours();
    				 logger.info("startHour"+startHour);
    				 int startMin = startTimeOfFirstMatch.getMinutes();
    				 logger.info("startMin"+startMin);
    				 SimpleDateFormat sdfStart = new SimpleDateFormat("dd MMM YYYY");
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
    				 String startMinStr = ""+startMin;
    				 if(startMin <10)
    				 {
    					 startMinStr = "0"+startMinStr;
    				 }
    				 String startHrsStr= ""+(startHour-deadLineHrsBeforeStart);
    				 if((startHour-deadLineHrsBeforeStart) <10)
    					 startHrsStr = "0"+(startHour-deadLineHrsBeforeStart);
    				 String deadline = formatedStartTime +" "+ startHrsStr + ":"+startMinStr;
    				 logger.info("Game Week: deadline  -- :"+deadline);
    				 pageContext.setAttribute("deadline", deadline);
    				 logger.info("going to fetch last match of gameWeekId="+gameWeekId);
    				 List<Timestamp> lastMatchOfGameWeek = GameManager.lastFirstMatchOfGameWeek(gameWeekId);
    				 logger.info("lastMatchOfGameWeek: "+lastMatchOfGameWeek);
    				 if(lastMatchOfGameWeek != null && lastMatchOfGameWeek.size() > 0 )
    				 {
    					 Timestamp endTimeOfLastMatch =  lastMatchOfGameWeek.get(0);
    					 long startDeadlineMils = startTimeOfFirstMatch.getTime() - TimeUnit.HOURS.toMillis(deadLineHrsBeforeStart);
    					// long endDeadlineMils = endTimeOfLastMatch.getTime() + TimeUnit.HOURS.toMillis(deadLineHrsAfterEnd);
    					 long endDeadlineMils = startTimeOfFirstMatch.getTime() + TimeUnit.HOURS.toMillis(deadLineHrsAfterEnd);
    					 long currentTimeMils = System.currentTimeMillis();
    					 logger.info("startDeadlineMils: "+startDeadlineMils);
    					 logger.info("endDeadlineMils: "+endDeadlineMils);
    					 logger.info("currentTimeMils: "+currentTimeMils);
    					 if(currentTimeMils >= startDeadlineMils && currentTimeMils <=endDeadlineMils)
    					 {
    						 pageContext.setAttribute("isUnderDeadline", true);
    						 logger.info("isUderDeadline: is true ");
    					 }
    					 else if(currentTimeMils >endDeadlineMils)
    					 {
    						 List<Integer> sortedGameWeekIds = GameWeeKManager.sortedGameWeekIds(gameId);
    						 if(sortedGameWeekIds.size() > gameWeekNumber)
    						 {
    							 gameWeekId =sortedGameWeekIds.get(gameWeekNumber);
    							 logger.info("else if gameWeekId="+gameWeekId);
    							 logger.info("else if gameWeekNumber="+gameWeekNumber);
        						 pageContext.setAttribute("gameWeekNumber", gameWeekNumber+1);
        		    			 pageContext.setAttribute("gameWeekId", gameWeekId);
        		    			 
        		    			 /*if (counter==0)
        		    			{	
        		    				 counter++;
        		    				 refreshDeadline();
        		    			}
        		    			 */
    						 }
    						 else
    						 {
    							 logger.info("else: isUnderDeadline is set true");
    							 pageContext.setAttribute("isUnderDeadline", true);
    							 pageContext.setAttribute("isLastGameWeek", true);
    						 }
    					 }
    				 }
    			 }
    			 
    		 }
    	 
    	 }
	
	}
}
