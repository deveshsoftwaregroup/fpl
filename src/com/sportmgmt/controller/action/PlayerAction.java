package com.sportmgmt.controller.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportmgmt.controller.response.SportMgmtResponse;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PlayerManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.common.ApplicationDataUtility;
import com.sportmgmt.utility.common.PointRankingUtility;
import com.sportmgmt.utility.common.SortUtility;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.utility.exception.SportMgmtException;

@Controller
@RequestMapping("/player")
public class PlayerAction {
	
	private static Logger logger = Logger.getLogger(PlayerAction.class);
	@Autowired
	private SortUtility sortUtility;
		
	
	public SortUtility getSortUtility() {
		return sortUtility;
	}


	public void setSortUtility(SortUtility sortUtility) {
		this.sortUtility = sortUtility;
	}

	@Autowired
	private PointRankingUtility pointRankingUtility;
	
	
	
	public PointRankingUtility getPointRankingUtility() {
		return pointRankingUtility;
	}


	public void setPointRankingUtility(PointRankingUtility pointRankingUtility) {
		this.pointRankingUtility = pointRankingUtility;
	}


	@RequestMapping(value = "orderBy/{orderBy}", method = RequestMethod.GET)
	public @ResponseBody Map orderBy(@PathVariable String orderBy, HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		List playerList = (List)session.getAttribute("playerList");
		Map resultMap = new HashMap();
		if(orderBy.equals("price"))
		{
			playerList =sortUtility.sortPlayerListByPrice(playerList);
		}
		else if(orderBy.equals("total_score"))
		{
			playerList = sortUtility.sortPlayerListByTotalPoint(playerList);
		}
		else if(orderBy.equals("user_count"))
		{
			playerList = sortUtility.sortPlayerListByUserCount(playerList);
		}
		resultMap.put("success", true);
		resultMap.put("playerList", playerList);
		session.setAttribute("playerList", playerList);
		session.setAttribute("playersOrderBy", orderBy);
		return resultMap;
	}
	
	@RequestMapping(value = "make-player-history/{gameId}", method = RequestMethod.GET)
	public @ResponseBody SportMgmtResponse createGameWeekHistoryForPlayers(@PathVariable String gameId, HttpServletRequest request)
	{
		SportMgmtResponse<Map> sportMgmtResponse = new SportMgmtResponse();
		boolean isGameExist = GameManager.isGameExistAndActive(gameId);
		if(isGameExist)
		{
			try
			{
				List<String> logList =pointRankingUtility.createPlayerHistoryForUsers(gameId);
				sportMgmtResponse.setSuccess(true);
				sportMgmtResponse.setLogList(logList);
			}
			catch(SportMgmtException sme)
			{
				sportMgmtResponse.setSuccess(false);
				sportMgmtResponse.setMessage(sme.getMessage());
				logger.error("--------------- Error Occured: "+sme);
			}
			
		}
		else
		{
			sportMgmtResponse.setSuccess(false);
			sportMgmtResponse.setMessage("Invalid game Id");
		}
		return sportMgmtResponse;
	}
	@RequestMapping(value = "make-player-history/{gameId}/{gameWeekId}", method = RequestMethod.GET)
	public @ResponseBody SportMgmtResponse createGameWeekHistoryForPlayers(@PathVariable String gameId, @PathVariable String gameWeekId)
	{
		SportMgmtResponse sportMgmtResponse = new SportMgmtResponse();
		boolean isGameExist = GameManager.isGameExistAndActive(gameId);
		if(isGameExist)
		{
			try
			{
				List<String> logList =pointRankingUtility.createPlayerHistoryForUsers(gameId,gameWeekId);
				sportMgmtResponse.setSuccess(true);
				sportMgmtResponse.setLogList(logList);
			}
			catch(SportMgmtException sme)
			{
				sportMgmtResponse.setSuccess(false);
				sportMgmtResponse.setMessage(sme.getMessage());
				logger.error("--------------- Error Occured: "+sme);
			}
			
		}
		else
		{
			sportMgmtResponse.setSuccess(false);
			sportMgmtResponse.setMessage("Invalid game Id");
		}
		return sportMgmtResponse;
	}
	@RequestMapping(value = "game-week-history/{gameId}/{userId}", method = RequestMethod.GET)
	public @ResponseBody SportMgmtResponse<Map> gameWeekHistory(@PathVariable String gameId,@PathVariable String userId,HttpServletRequest request)
	{
		String gameWeekIdParam = request.getParameter("gameWeekId");
		String direction = request.getParameter("game-week-for");
		return getGameWeeKHistory(gameId, userId, gameWeekIdParam, direction,request);
	}
	
	private SportMgmtResponse<Map> getGameWeeKHistory(String gameId,String userId,String gameWeekIdParam,String direction,HttpServletRequest request)
	{
		SportMgmtResponse<Map> 	sportMgmtResponse = new SportMgmtResponse<>();
		try
			{
				
				Map<Object,Object> result = new HashMap();
				Map<String,String> gameWeek =pointRankingUtility.getGameWeekForPointView(gameId, gameWeekIdParam, direction);
				logger.info("-------- gameWeek: "+gameWeek);
				String gameWeekId = gameWeek.get("gameWeekId");
				List<Map<String,String>> historyPlayerList = PlayerManager.gameWeekPlayerList(userId, gameWeekId);
				/* Statt Code to add playerType to history player List */
				if(historyPlayerList !=null && !historyPlayerList.isEmpty())
				{
					HttpSession session = request.getSession();
					List<Map<Object,Object>> playerList = (List<Map<Object,Object>>)session.getAttribute("playerList");
					for(Map<String,String> historyPlayer:historyPlayerList)
					{
						String historyPlayerGCPID = historyPlayer.get("gameClubPlayerId");
						for(Map<Object,Object>player:playerList)
						{
							if(player.get("gameClubPlayerId").equals(historyPlayerGCPID))
							{
								historyPlayer.put("playerType",(String)player.get("type"));
								break;
							}
						}
					}
				}
				/* End Code to add playerType to history player List */
				logger.info("-- History player list: "+historyPlayerList);
				Map<String,String> gameWeekReport = GameWeeKManager.getGameWeekReport(userId, gameWeekId);
				logger.info("--- Game Week Report: "+gameWeekReport);
				gameWeek.putAll(gameWeekReport);
				result.put("hisotryPlayerList", historyPlayerList);
				result.put("gameWeek", gameWeek);
				sportMgmtResponse.setSuccess(true);
				sportMgmtResponse.setResult(result);
				
			}
			catch(Exception sme)
			{
				sportMgmtResponse.setSuccess(false);
				sportMgmtResponse.setMessage(sme.getMessage());
				logger.error("--------------- Error Occured: "+sme);
			}
			
		return sportMgmtResponse;
	}
}
