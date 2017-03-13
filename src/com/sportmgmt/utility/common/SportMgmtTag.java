package com.sportmgmt.utility.common;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//import java.util.Calendar;  
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.sportmgmt.controller.action.GameAction;
import com.sportmgmt.controller.response.SportMgmtResponse; 
public class SportMgmtTag extends TagSupport{
	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(SportMgmtTag.class);
	private static final long serialVersionUID = 1L;
	private Integer position;  
	private String playerType;
	private String pageName;
	
	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	public int doStartTag() throws JspException {  
	    //JspWriter out=pageContext.getOut();//returns the instance of JspWriter  
	    try{  
	     //out.print(Calendar.getInstance().getTime());//printing date and time using JspWriter
	    	
	    	//pageContext.setAttribute("name", "My name is Gentle Man");
	    	boolean isPlayerAvail = false;
	    	String gameClubPlayerId = "";
	    	logger.info("----- position: "+position+" , playerType: "+playerType+" , pageName: "+pageName);
	    	if(position !=null && playerType !=null && !playerType.equals(""))
	    	{
	    		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		    	HttpSession session = request.getSession();
		    	List<Map<String,String>> playerList = null;
		    	
				if(pageName !=null && pageName.equals("MY_POINT"))
				{
					SportMgmtResponse<Map<Object,Object>> sprotMgmtRes = (SportMgmtResponse<Map<Object,Object>>)request.getAttribute("sportMgmtRes");
					Map<Object,Object> result = sprotMgmtRes.getResult();
					playerList= (List<Map<String,String>>)result.get("hisotryPlayerList"); 
					
				}
				else
				{
					Map userGameMap = (Map)session.getAttribute("userGameDetails");
					if(userGameMap != null && userGameMap.size() >0)
					{
						playerList = (List<Map<String,String>>)userGameMap.get("playerList");
					}
				}
				if(playerList != null && playerList.size() >0)
				{
					int count=1;
					for(Object userPlayerObj:playerList)
					{
						Map<String,String> userPlayerMap = (Map<String,String>)userPlayerObj;
						if(userPlayerMap.get("playerType") !=null && userPlayerMap.get("playerType").equals(playerType))
						{
							if(count == position)
							{
								if(userPlayerMap.get("gameClubPlayerId") != null && !userPlayerMap.get("gameClubPlayerId").equals(""))
								{
									isPlayerAvail = true;
									gameClubPlayerId = (String)userPlayerMap.get("gameClubPlayerId");
									if(userPlayerMap.get("isPlaying") != null && !userPlayerMap.get("isPlaying").equals(""))
									pageContext.setAttribute("isPlaying", userPlayerMap.get("isPlaying"));
									if(userPlayerMap.get("playerType") != null && !userPlayerMap.get("playerType").equals(""))
									pageContext.setAttribute("playerType", userPlayerMap.get("playerType"));
									if(userPlayerMap.get("playerCategory") != null && !userPlayerMap.get("playerCategory").equals(""))
									pageContext.setAttribute("playerCategory", userPlayerMap.get("playerCategory"));
								}
								break;
							}
							count++;
						}
					}
				}
				
				if(isPlayerAvail)
				{
					pageContext.setAttribute("gameClubPlayerId", gameClubPlayerId);
					List<Map<Object,Object>> playerListAll = (List<Map<Object,Object>>)session.getAttribute("playerList");
					if(playerListAll !=null && playerListAll.size() >0)
					{
						for(Object playerObj:playerListAll)
						{
							Map playerMap = (Map)playerObj;
							if(playerMap.get("gameClubPlayerId") != null && playerMap.get("gameClubPlayerId").equals(gameClubPlayerId))
							{
									if(playerMap.get("name") != null && !playerMap.get("name").equals(""))
									pageContext.setAttribute("playerName", playerMap.get("name"));
									if(playerMap.get("price") != null)
									pageContext.setAttribute("price", playerMap.get("price"));
									pageContext.setAttribute("clubId", playerMap.get("clubId"));
							}
						}
					}
				}
			}
	    	pageContext.setAttribute("isPlayerAvail", new Boolean(isPlayerAvail));
	    	if(!isPlayerAvail)
	    	{
	    		pageContext.setAttribute("gameClubPlayerId", gameClubPlayerId);
	    		pageContext.setAttribute("playerName", "");
	    		pageContext.setAttribute("price", 0);
	    		pageContext.setAttribute("isPlaying", "");
	    		pageContext.setAttribute("playerType", "");
	    		pageContext.setAttribute("playerCategory", "");
	    		pageContext.setAttribute("clubId", "");
	    	}
	    	position = null;
	    	playerType = null;
	    }catch(Exception e)
	    {
	     logger.error(e);
	     }  
	    return SKIP_BODY;//will not evaluate the body content of the tag  
	}  

}
