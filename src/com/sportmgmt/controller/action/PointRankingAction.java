package com.sportmgmt.controller.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportmgmt.utility.common.SortUtility;
import com.sportmgmt.controller.response.SportMgmtResponse;
import com.sportmgmt.model.entity.Point;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PlayerManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.common.PointRankingUtility;
import com.sportmgmt.utility.constrant.SportConstrant;

@Controller
@RequestMapping("/game")
public class PointRankingAction {
	Logger logger = Logger.getLogger(PointRankingAction.class);
	@Autowired
	private PointRankingUtility pointRankingUtility;
	
	
	
	public PointRankingUtility getPointRankingUtility() {
		return pointRankingUtility;
	}


	public void setPointRankingUtility(PointRankingUtility pointRankingUtility) {
		this.pointRankingUtility = pointRankingUtility;
	}
	
	@Autowired
	private SortUtility sortUtility;
	
	public SortUtility getSortUtility() {
		return sortUtility;
	}
	public void setSortUtility(SortUtility sortUtility) {
		this.sortUtility = sortUtility;
	}
	
	@RequestMapping(value = "MyPoint/{gameId}/{userId}", method = RequestMethod.GET)
	public String  gameWeekHistory(ModelMap modeMap,@PathVariable String gameId,@PathVariable String userId,HttpServletRequest request)
	{
		String gameWeekIdParam = request.getParameter("gameWeekId");
		String direction = request.getParameter("game-week-for");
		SportMgmtResponse<Map> 	sportMgmtResponse= getGameWeeKHistory(gameId, userId, gameWeekIdParam, direction,request);
		logger.info("---- SortMgmtResponse: "+sportMgmtResponse);
		modeMap.put("sportMgmtRes", sportMgmtResponse);
		return SportConstrant.MY_POINT_PAGE;
	}
	@RequestMapping(value = "PointTableView/{gameId}", method = RequestMethod.GET)
	public  String pointTableView(ModelMap modeMap,HttpServletRequest request,@PathVariable String gameId)
	{
		logger.info("---------- IN PointTableView to : "+gameId);
		List<Map<String,String>>pointList = pointRankingUtility.getPointList(gameId);
		modeMap.put("message", "");
		modeMap.put("pointList", pointList);
		logger.info("------------- Point Info ----------> "+pointList);
		return SportConstrant.POINT_TABLE_PAGE;
	}
	
	private SportMgmtResponse<Map> getGameWeeKHistory(String gameId,String userId,String gameWeekIdParam,String direction,HttpServletRequest request)
	{
		SportMgmtResponse<Map> 	sportMgmtResponse = new SportMgmtResponse<>();
		try
			{
				
				Map result = new HashMap();
				Map<String,String> gameWeek =pointRankingUtility.getGameWeekForPointView(gameId, gameWeekIdParam, direction);
				logger.info("-------- gameWeek: "+gameWeek);
				String gameWeekId = gameWeek.get("gameWeekId");
				List<Map<String,String>> historyPlayerList = PlayerManager.gameWeekPlayerList(userId, gameWeekId);
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
	@RequestMapping(value = "updatePlayerPoint/{gameWeekId}/{matchId}", method = RequestMethod.GET)
	public  String updatePointForm(ModelMap modeMap,@PathVariable String gameWeekId,@PathVariable String matchId,HttpServletRequest request) throws Exception
	{
		logger.info("----------- Entry in updatePlayerPoint: --gameWeekId: "+gameWeekId+" ,matchId: "+matchId);
		String gameId = (String)((Map)request.getSession().getAttribute("gameDetails")).get("gameId");
		ArrayList playersList = new ArrayList();
		ArrayList clubList = new ArrayList();
		sortUtility.getApplicationDataUtility().loadPlayers(gameId, matchId, playersList, clubList);
		playersList = sortUtility.sortPlayerListByPlayerName(playersList,sortUtility.getApplicationDataUtility().getGameClubPlayerIdsInMatch());
		logger.info("----------- sorted by name playersList: "+playersList);
		modeMap.put("playerList", playersList);
		List<Map<String,String>>pointList = pointRankingUtility.getPointList(gameId);
		logger.info("---- POint list: "+pointList);
		modeMap.put("pointList", pointList);
		modeMap.put("gameId", gameId);
		modeMap.put("gameWeekId", gameWeekId);
		modeMap.put("matchId", matchId);
		return SportConstrant.UPDATE_PLAYER_POINT_PAGE;
	}
	
	@RequestMapping(value = "updatePoint", method = RequestMethod.POST)
	public @ResponseBody  Map<String,String> updatePoint(ModelMap modeMap, @RequestParam Map<String,String>requestParam, HttpServletRequest request)
	{
		Integer gameId = Integer.valueOf(requestParam.get("gameId"));
		Integer matchId = Integer.valueOf(requestParam.get("matchId"));
		Integer gameWeekId = Integer.valueOf(requestParam.get("gameWeekId"));
		Integer gameClubPlayerId = Integer.valueOf(requestParam.get("gameClubPlayerId"));
		Integer pointId = Integer.valueOf(requestParam.get("pointId"));
		logger.info("------- gooing to insert point for player-");
		Map<String,String> result = new java.util.HashMap<>();
		result.put("isSuccess", "true");
		try
		{
			java.util.List<Integer> playerPointAndPointToUpdateList = PointRankManager.insertPlayerPoint(gameId, matchId, gameClubPlayerId, pointId);
			if(playerPointAndPointToUpdateList !=null && playerPointAndPointToUpdateList.size() >=2)
			{
				logger.info("------- Going to fetch user list who has been addded player: "+gameClubPlayerId+" in his team");
				List<Integer> userIdList = PointRankManager.getUserListOfPlayerByMatch(gameClubPlayerId);
				if(userIdList !=null && !userIdList.isEmpty())
				{
					Integer playerPointId = playerPointAndPointToUpdateList.get(0);
					Integer pointToUpdate = playerPointAndPointToUpdateList.get(1);
					logger.info("----- Goinng to insert point for user taken by player in user_point");
					boolean isTransDone =PointRankManager.insertUsersPoint(gameId, matchId, userIdList, playerPointId, pointToUpdate);
					if(isTransDone)
					{
						logger.info("----- Going to update game week point of user:"+gameWeekId);
						PointRankManager.updateGameWeekPointForUsers(userIdList, gameWeekId, pointToUpdate);
						Map<Integer,Integer> userAndPointMap= pointRankingUtility.getUserAndOderdPointMap(gameWeekId);
						logger.info("------------ User And Game week Point Map: "+userAndPointMap);
						//PointRankManager.updateRankForUser(contestUserAndPoitMap,matchId);
					}
				}
			}
		}
		catch(Exception ex)
		{
			logger.error("---- Error occurs: "+ex);
			result.put("isSuccess", "false");
			result.put("errorMsg", "Technical error");
		}
		return result;
	}
	
}
