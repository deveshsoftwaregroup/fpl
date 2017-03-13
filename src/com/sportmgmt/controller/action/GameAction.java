package com.sportmgmt.controller.action;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmgmt.controller.bean.GameWeek;
import com.sportmgmt.controller.bean.MatchDetails;
import com.sportmgmt.controller.bean.User;
import com.sportmgmt.model.entity.Match;
import com.sportmgmt.model.manager.GameManager;
import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PlanManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.common.MailUtility;
import com.sportmgmt.utility.common.PointRankingUtility;
import com.sportmgmt.utility.common.PropertyFileUtility;
import com.sportmgmt.utility.constrant.ErrorConstrant;
import com.sportmgmt.utility.constrant.SportConstrant;

@Controller
@RequestMapping("/game")
public class GameAction {
	private Logger logger = Logger.getLogger(GameAction.class);
	@Autowired
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
	
	@Autowired
	private PointRankingUtility pointRankingUtility;
	
	
	
	public PointRankingUtility getPointRankingUtility() {
		return pointRankingUtility;
	}


	public void setPointRankingUtility(PointRankingUtility pointRankingUtility) {
		this.pointRankingUtility = pointRankingUtility;
	}
	
	@RequestMapping(value = "AddPlayer", method = RequestMethod.GET)
	public @ResponseBody Map addPlayer(@RequestParam("userId") String userId, @RequestParam("gameClubPlayerId") String gameClubPlayerId,HttpServletRequest request)
	{
		Map resultMap = new HashMap();
		boolean isSuccess = false;
		String errorMessage = "";
		String errorCode = "";
		logger.info("------------ addPlayer ");
		if(userId == null || userId.equals("") || gameClubPlayerId == null || gameClubPlayerId.equals(""))
		{
			errorMessage = "Parameter missing";
			errorCode = ErrorConstrant.INVALID_PARAMETER;
			logger.info("------------ Parameter is invalid/missing ");
		}
		else
		{
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user != null)
			{
				boolean hasActivePlan = user.isHasActivePlan();
				if(hasActivePlan)
				{
					isSuccess = GameManager.addPlayeOfGametToUserAccount(userId, gameClubPlayerId);
					Integer price = null;
					logger.info("------------ Add Player Call isSuccess: "+isSuccess);
					if(isSuccess)
					{
						
						logger.info("------------ Updating session and json value");
						try
						{
							
							Map userGameMap = (Map)session.getAttribute("userGameDetails");
							String gameId = (String)((Map)session.getAttribute("gameDetails")).get("gameId");
							List<Map<String,String>> userPlayersList = (List<Map<String,String>>)userGameMap.get("playerList");
							Map<String,String> playerDetails = new HashMap<String,String>();
							playerDetails.put("gameClubPlayerId", gameClubPlayerId);
							playerDetails.put("isPlaying", SportConstrant.NO);
							playerDetails.put("playerType", SportConstrant.NULL);
							playerDetails.put("playerType", SportConstrant.NULL);
							playerDetails.put("playerCategory", SportConstrant.PLAYER_TYPE_NORMAL);
							playerDetails.put("playerSeqNum", "0");
							List playersList = (List)session.getAttribute("playerList");
							if(playersList.size()>0)
							{
								for(Object playerDetailObj :playersList)
								{
									Map playerDetailMap = (Map)playerDetailObj;
									if(playerDetailMap.get("gameClubPlayerId") !=null && playerDetailMap.get("gameClubPlayerId").equals(gameClubPlayerId))
									{
										playerDetails.put("playerType", (String)playerDetailMap.get("type"));
										price = (Integer)playerDetailMap.get("price");
									}
								}
							}
							userPlayersList.add(playerDetails);
							Map totalMap = (Map)userGameMap.get("total");
							totalMap.put("player", (Integer)totalMap.get("player")+1);
							totalMap.put("price", GameManager.totalPlayersPriceOfUserByGame(Integer.valueOf(userId),Integer.valueOf(gameId)));
							GameManager.updateTotalPlayerByPostion(Integer.valueOf(userId),Integer.valueOf(gameId),totalMap);
							session.setAttribute("userGameDetails", userGameMap);
							ObjectMapper mapperObj = new ObjectMapper();
							 try
							 {
								 
								 String userGameJson = mapperObj.writeValueAsString(userGameMap);
								 logger.info("--------  : userGameJson: "+userGameJson);
								 session.setAttribute("userGameJson", userGameJson);
								 
							 }
							 catch(Exception ex)
							 {
								 logger.error("---------- Entry in parsing map to json: "+ex);
							 }


							resultMap.put("userGameJson", userGameMap);
							int addedPlayerCount =GameManager.increaseAddedPlayerCountToUserGame(userId,gameId);
							if((Integer)totalMap.get("player") ==15)
							{
								GameManager.checkAndIsertUserGameStatus(userId,gameId);
							}
							String gameWeekIdForPlayerTrasfer = pointRankingUtility.gameWeekIdForTransferPlayer(gameId);
							logger.info("------ gameWeekIdForPlayerTrasfer: "+gameWeekIdForPlayerTrasfer);
							if(gameWeekIdForPlayerTrasfer !=null && !gameWeekIdForPlayerTrasfer.equals(""))
							{
								int playerTransfered = GameWeeKManager.updatePlayerTransfered(new Integer(userId), new Integer(gameWeekIdForPlayerTrasfer));
								logger.info("total player transfer= "+playerTransfered+" for game_week: "+gameWeekIdForPlayerTrasfer);
							}
							logger.info("--------  : Starting deducting point: "+price);
							if(price != null && user.getActivePlan() != null && user.getActivePlan().getPlanTypeVal() == 0)
							{
								logger.info("--------  : plan typ vlaue: "+user.getActivePlan().getPlanTypeVal());
								try
								{
									double balance = 0;
									if(addedPlayerCount > 1)
									balance= PlanManager.deductPointFromUserPlan(user.getActivePlan().getUserPlanId(), price.doubleValue()+4);
									else
									balance= PlanManager.deductPointFromUserPlan(user.getActivePlan().getUserPlanId(), price.doubleValue());	
									user.getActivePlan().setBalance(balance);
									resultMap.put("activePlanBalance", balance);
									
									logger.info("--------  : Now balance is: "+balance);
									/*if(balance <=0)
									{
										if(PlanManager.deActivateUserPlan(user.getActivePlan().getUserPlanId()))
										{
											logger.info("--------  :User Plan Deactivated ");
											user.setHasActivePlan(false);
										}
										else
										{
											logger.info("--------  :Failed to deactivate plan ");
										}
									}*/
								}
								catch(Exception ex)
								{
									logger.error("--------- Error in deducting point "+ex.getMessage());
								}
								
							}
						}
						catch(Exception ex)
						{
							logger.error("error to creating userGameJson: "+ex.getMessage());
							ex.printStackTrace();
						}
						
					}
					else
					{
						errorMessage = GameManager.getErrorMessage();
						errorCode = GameManager.getErrorCode();
					}

				}
				else
				{
					errorMessage = "No Plan is active to add the player";
					errorCode = "NO_PLAN_ACTIVE";
				}
			}
			else
			{
				errorMessage = "Invalid Sesison";
				errorCode = "ERROR_INVALID_SESSION";
			}
		}
		resultMap.put("isSuccess", isSuccess);
		resultMap.put("errorMessage", errorMessage);
		resultMap.put("errorCode", errorCode);
		logger.info("Returning action: with reuslt-- : "+resultMap);
		return resultMap;
	}
	@RequestMapping(value = "RemovePlayer", method = RequestMethod.GET)
	public @ResponseBody Map removePlayer(@RequestParam("userId") String userId, @RequestParam("gameClubPlayerId") String gameClubPlayerId,HttpServletRequest request)
	{
		Map resultMap = new HashMap();
		boolean isSuccess = false;
		String errorMessage = "";
		String errorCode = "";
		logger.info("------------ RemovePlayer ");
		if(userId == null || userId.equals("") || gameClubPlayerId == null || gameClubPlayerId.equals(""))
		{
			errorMessage = "Parameter missing";
			errorCode = ErrorConstrant.INVALID_PARAMETER;
			logger.info("------------ Parameter is invalid/missing ");
		}
		else
		{
			isSuccess = GameManager.removePlayeOfGameFromUserAccount(userId, gameClubPlayerId);
			logger.info("------------ Remove Player Call isSuccess: "+isSuccess);
			if(isSuccess)
			{
				logger.info("------------ Updating session and json value");
				try
				{
					HttpSession session = request.getSession();
					Map userGameMap = (Map)session.getAttribute("userGameDetails");
					String gameId = (String)((Map)session.getAttribute("gameDetails")).get("gameId");
					List<Map<String,String>> userPlayersList = (List<Map<String,String>>)userGameMap.get("playerList");
					Map<String,String> playerDetails = null;
					for(Object userPlayerObj:userPlayersList)
					{
						Map<String,String> userPlayerMap = (Map<String,String>)userPlayerObj;
						if(userPlayerMap.get("gameClubPlayerId") !=null && userPlayerMap.get("gameClubPlayerId").equals(gameClubPlayerId))
						{
							playerDetails = userPlayerMap;
						}
					}
					if(playerDetails !=null)
					{
						userPlayersList.remove(playerDetails);
					}
					Map totalMap = (Map)userGameMap.get("total");
					totalMap.put("player", (Integer)totalMap.get("player")-1);
					totalMap.put("price", GameManager.totalPlayersPriceOfUserByGame(Integer.valueOf(userId),Integer.valueOf(gameId)));
					GameManager.updateTotalPlayerByPostion(Integer.valueOf(userId),Integer.valueOf(gameId),totalMap);
					session.setAttribute("userGameDetails", userGameMap);
					ObjectMapper mapperObj = new ObjectMapper();
					 try
					 {
						 
						 String userGameJson = mapperObj.writeValueAsString(userGameMap);
						 logger.info("--------  : userGameJson: "+userGameJson);
						 session.setAttribute("userGameJson", userGameJson);
						 
					 }
					 catch(Exception ex)
					 {
						 logger.error("---------- Entry in parsing map to json: "+ex);
					 }


					resultMap.put("userGameJson", userGameMap);
					User user = (User)session.getAttribute("user");
					if(user.isHasActivePlan() && user.getActivePlan() !=null)
					{
						if(user.getActivePlan().getPlanTypeVal() == 0)
						{
							Integer price =null;
							List playersList = (List)session.getAttribute("playerList");
							if(playersList.size()>0)
							{
								for(Object playerDetailObj :playersList)
								{
									Map playerDetailMap = (Map)playerDetailObj;
									if(playerDetailMap.get("gameClubPlayerId") !=null && playerDetailMap.get("gameClubPlayerId").equals(gameClubPlayerId))
									{
										price = (Integer)playerDetailMap.get("price");
									}
								}
							}
							logger.info("------ Started adding point---: "+price);
							double balance= PlanManager.addPointToUserPlan(user.getActivePlan().getUserPlanId(), price.doubleValue());
							resultMap.put("activePlanBalance", balance);
							user.getActivePlan().setBalance(balance);
							logger.info("------ Current balance is ---: "+balance);
						}
					}
				}
				catch(Exception ex)
				{
					logger.error("error to creating userGameJson: "+ex.getMessage());
					ex.printStackTrace();
				}
				
			}
			else
			{
				errorMessage = GameManager.getErrorMessage();
				errorCode = GameManager.getErrorCode();
			}
		}
		resultMap.put("isSuccess", isSuccess);
		resultMap.put("errorMessage", errorMessage);
		resultMap.put("errorCode", errorCode);
		logger.info("Returning action: with reuslt-- : "+resultMap);
		return resultMap;
	}
	@RequestMapping(value = "ActivatePlayer", method = RequestMethod.GET)
	public @ResponseBody Map activatePlayer(@RequestParam("userId") String userId, @RequestParam("gameClubPlayerId") String gameClubPlayerId,HttpServletRequest request)
	{
		logger.info("------------ activate Player :-- calling update player");
		return updatePlayer(userId,gameClubPlayerId,SportConstrant.YES,null,null,request);
	}
	@RequestMapping(value = "DeActivatePlayer", method = RequestMethod.GET)
	public @ResponseBody Map deActivatePlayer(@RequestParam("userId") String userId, @RequestParam("gameClubPlayerId") String gameClubPlayerId,HttpServletRequest request)
	{
		logger.info("------------ de-activate Player :-- calling update player");
		return updatePlayer(userId,gameClubPlayerId,SportConstrant.NO,null,null,request);
	}
	@RequestMapping(value = "MakeCaptain", method = RequestMethod.GET)
	public @ResponseBody Map makeCaptain(@RequestParam("userId") String userId, @RequestParam("gameClubPlayerId") String gameClubPlayerId,HttpServletRequest request)
	{
		logger.info("------------ MakeCaptain  :-- calling update player");
		List<Integer> playerList =GameManager.fetchUserPlayerOfGameByType(userId, SportConstrant.PLAYER_TYPE_CAPTAIN);
		Map updateMap = null;
		if(playerList != null && playerList.size() >=1)
		{
			updateMap= updatePlayer(userId,playerList.get(0).toString(),null,SportConstrant.PLAYER_TYPE_NORMAL,null,request);
		}
		if(updateMap == null || (Boolean)updateMap.get("isSuccess"))
		return updatePlayer(userId,gameClubPlayerId,null,SportConstrant.PLAYER_TYPE_CAPTAIN,null,request);
		else
		return updateMap;
	}
	@RequestMapping(value = "MakeViceCaptain", method = RequestMethod.GET)
	public @ResponseBody Map makeViceCaptain(@RequestParam("userId") String userId, @RequestParam("gameClubPlayerId") String gameClubPlayerId,HttpServletRequest request)
	{
		logger.info("------------ MakeViceCaptain  :-- calling update player");
		List<Integer> playerList =GameManager.fetchUserPlayerOfGameByType(userId, SportConstrant.PLAYER_TYPE_VICE_CAPTAIN);
		Map updateMap = null;
		if(playerList != null && playerList.size() ==1)
		{
			updateMap= updatePlayer(userId,playerList.get(0).toString(),null,SportConstrant.PLAYER_TYPE_NORMAL,null,request);
		}
		if(updateMap == null || (Boolean)updateMap.get("isSuccess"))
		return updatePlayer(userId,gameClubPlayerId,null,SportConstrant.PLAYER_TYPE_VICE_CAPTAIN,null,request);
		else
		return updateMap;
	}
	public Map updatePlayer(String userId, String gameClubPlayerId,String isPlaying, String playerCategory,String seqNum,HttpServletRequest request)
	{
		Map resultMap = new HashMap();
		boolean isSuccess = false;
		String errorMessage = "";
		String errorCode = "";
		logger.info("------------ update Player ");
		if(userId == null || userId.equals("") || gameClubPlayerId == null || gameClubPlayerId.equals(""))
		{
			errorMessage = "Parameter missing";
			errorCode = ErrorConstrant.INVALID_PARAMETER;
			logger.info("------------ Parameter is invalid/missing ");
		}
		else
		{
			isSuccess = GameManager.updatePlayeOfGameFromUserAccount(userId, gameClubPlayerId,isPlaying,playerCategory,seqNum);
			logger.info("------------ update Player Call isSuccess: "+isSuccess);
			if(isSuccess)
			{
				logger.info("------------ Updating session and json value");
				try
				{
					HttpSession session = request.getSession();
					Map userGameMap = (Map)session.getAttribute("userGameDetails");
					String gameId = (String)((Map)session.getAttribute("gameDetails")).get("gameId");
					List<Map<String,String>> userPlayersList = (List<Map<String,String>>)userGameMap.get("playerList");
					for(Object userPlayerObj:userPlayersList)
					{
						Map<String,String> userPlayerMap = (Map<String,String>)userPlayerObj;
						if(userPlayerMap.get("gameClubPlayerId") !=null && userPlayerMap.get("gameClubPlayerId").equals(gameClubPlayerId))
						{
							if(isPlaying != null && !isPlaying.equals(""))
							userPlayerMap.put("isPlaying", isPlaying);
							if(playerCategory != null && !playerCategory.equals(""))
							{
								userPlayerMap.put("playerCategory",playerCategory);
							}
							if(seqNum != null && !seqNum.equals(""))
							{
								userPlayerMap.put("playerSeqNum",seqNum);
							}
						}
					}
					
					if(isPlaying != null && !isPlaying.equals(""))
					{
						 HashMap totalPlayingMap= new HashMap(); 
						 //int player = GameManager.totalPlayingPlayersOfUserByGame(Integer.valueOf(userId),Integer.valueOf(gameId));
						 //totalPlayingMap.put("player", player);
						 GameManager.updateTotalPlayingPlayerByPostion(Integer.valueOf(userId),Integer.valueOf(gameId),totalPlayingMap);
						 resultMap.put("totalPlayingJson", totalPlayingMap);;
					}
					
					/*totalMap.put("player", (Integer)totalMap.get("player")-1);
					totalMap.put("price", GameManager.totalPlayersPriceOfUserByGame(Integer.valueOf(userId),Integer.valueOf(gameId)));
					GameManager.updateTotalPlayerByPostion(Integer.valueOf(userId),Integer.valueOf(gameId),totalMap);*/
					session.setAttribute("userGameDetails", userGameMap);
					ObjectMapper mapperObj = new ObjectMapper();
					 try
					 {
						 
						 String userGameJson = mapperObj.writeValueAsString(userGameMap);
						 logger.info("--------  : userGameJson: "+userGameJson);
						 session.setAttribute("userGameJson", userGameJson);
						 
					 }
					 catch(Exception ex)
					 {
						 logger.error("---------- Entry in parsing map to json: "+ex);
					 }

					resultMap.put("userGameJson", userGameMap);
				}
				catch(Exception ex)
				{
					logger.error("error to creating userGameJson: "+ex.getMessage());
					ex.printStackTrace();
				}
				
			}
			else
			{
				errorMessage = GameManager.getErrorMessage();
				errorCode = GameManager.getErrorCode();
			}
		}
		resultMap.put("isSuccess", isSuccess);
		resultMap.put("errorMessage", errorMessage);
		resultMap.put("errorCode", errorCode);
		logger.info("Returning action: with reuslt-- : "+resultMap);
		return resultMap;
	}
	@RequestMapping(value = "MyTeamView/{userId}/{gameId}", method = RequestMethod.GET)
	public  String myTeamView(ModelMap modeMap,HttpServletRequest request,@PathVariable String userId,@PathVariable String gameId)
	{
		logger.info("---------- IN MyTeamView to : ");
		 //int player = GameManager.totalPlayingPlayersOfUserByGame(Integer.valueOf(userId),Integer.valueOf(gameId));
		 HashMap totalPlayingMap= new HashMap();
		 //totalPlayingMap.put("player", player);
		 GameManager.updateTotalPlayingPlayerByPostion(Integer.valueOf(userId),Integer.valueOf(gameId),totalPlayingMap);
		 //modeMap.put("userGameMap",GameManager.getUserGameStatus(userId, gameId));
		 String totalPlayingJson = "";
		 modeMap.put("totalPlayingMap", totalPlayingMap);
		 logger.info("-------- MyTeamView : totalPlayingMap: "+totalPlayingMap);
		 ObjectMapper mapperObj = new ObjectMapper();
		 try
		 {
			 
			 totalPlayingJson = mapperObj.writeValueAsString(totalPlayingMap);
			 logger.info("-------- MyTeamView : totalPlayingJson: "+totalPlayingJson);
			 
		 }
		 catch(Exception ex)
		 {
			 logger.error("---------- Entry in parsing map to json: "+ex);
		 }
		 modeMap.put("totalPlayingJson", totalPlayingJson);
			
		 return SportConstrant.MY_TEAM_PAGE;
	}
	
	@RequestMapping(value = "MatchView/{gameId}", method = RequestMethod.GET)
	public  String matchView(ModelMap modeMap,HttpServletRequest request,@PathVariable String gameId)
	{
		logger.info("---------- IN matchView to : "+gameId);
		TreeSet<GameWeek> gameWeekList = new TreeSet<GameWeek>();
		List<Match> matchList = GameWeeKManager.getMatchesByGame(gameId);
		SimpleDateFormat sdfStart;
		if(matchList != null && matchList.size() >=1)
		{
			for(Object matchObj : matchList)
			{
				Match match = (Match)matchObj;
				MatchDetails matchDetails = new MatchDetails();
				SimpleDateFormat sdfTime = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
				//String startDateStr = sdfTime.format(match.getStartTime());
				logger.info("Date: "+match.getStartTime());
				//String endDateStr = sdfTime.format(match.getEndTime());
				try
				{
					//matchDetails.setEndTime(sdfTime.parse(endDateStr));
					matchDetails.setEndTime(match.getEndTime());
					//Date dateObj = new Date(match.getStartTime().getYear(), match.getStartTime().getMonth(), match.getStartTime().getDay(), match.getStartTime().getHours(), match.getStartTime().getMinutes(), match.getStartTime().getSeconds());
					//matchDetails.setStartTime(dateObj);
					matchDetails.setStartHour(match.getStartTime().getHours());
					matchDetails.setStartMinute(match.getStartTime().getMinutes());
					matchDetails.setEndHours(match.getEndTime().getHours());
					matchDetails.setEndMinute(match.getEndTime().getMinutes());
					matchDetails.setStartTime(match.getStartTime());
					sdfStart = new SimpleDateFormat("EEE, dd MMM yyyy");
					String startDateStr = sdfStart.format(match.getStartTime());
					matchDetails.setFormatedDate(startDateStr);
					sdfStart = new SimpleDateFormat("EEEE dd MMMM");
					startDateStr = sdfStart.format(match.getStartTime());
					matchDetails.setFormatedDate1(startDateStr);
					sdfStart = new SimpleDateFormat("dd MMM");
					startDateStr = sdfStart.format(match.getStartTime());
					matchDetails.setFormatedDate2(startDateStr);
					
					
				}
				catch(Exception ex)
				{
					logger.error("------------- Error to parsing date: "+ex);
				}
				
				matchDetails.setFirstClubName(match.getFirstClub().getClubName());
				matchDetails.setSecondClubName(match.getSecondClub().getClubName());
				matchDetails.setFirstClubId(match.getFirstClub().getClubID().toString());
				matchDetails.setSecondClubId(match.getSecondClub().getClubID().toString());
				boolean gameWeekFound = false;
				GameWeek gameWeek = null;
				for(Object gameWeekObj:gameWeekList)
				{
					GameWeek gameWeekTemp = (GameWeek)gameWeekObj;
					if(gameWeekTemp.equals(match.getGameWeek().getStartDate()))
					{
						gameWeek = gameWeekTemp;
						break;
					}
				}
				if(gameWeek == null)
				{
					gameWeek = new GameWeek();
					gameWeek.setStartDate(match.getGameWeek().getStartDate());
					gameWeek.setEndDate(match.getGameWeek().getEndDate());
					gameWeek.setGameWeekName(match.getGameWeek().getWeekName());
				}
				sdfStart = new SimpleDateFormat("yyMMdd");
				String startDateStr = sdfStart.format(match.getStartTime());
				logger.info("------------ Start date Key: "+startDateStr);
				Integer startDayInt = Integer.parseInt(startDateStr);
				if(gameWeek.getMatchMap().containsKey(startDayInt))
				{
					gameWeek.getMatchMap().get(startDayInt).add(matchDetails);
				}
				else
				{
					TreeSet<MatchDetails> matchDetailList = new TreeSet<MatchDetails>();
					//List<MatchDetails> matchDetailList = new ArrayList<MatchDetails>();
					matchDetailList.add(matchDetails);
					gameWeek.getMatchMap().put(startDayInt, matchDetailList);
				}
				gameWeekList.add(gameWeek);
			}
		}
		logger.info("----------- Game Week List: "+gameWeekList);
		 Map<String,Object> matchesMap = new HashMap<String,Object>();
		 matchesMap.put("currentGameWeek", 0);
		 matchesMap.put("totalGameWeek", gameWeekList.size());
		 matchesMap.put("gameWeekList", gameWeekList);
		logger.info("----------- matchesMap: "+matchesMap);
		modeMap.put("matchesMap", matchesMap);
		 ObjectMapper mapperObj = new ObjectMapper();
		 try
		 {
			 
			 String matchesMapJson = mapperObj.writeValueAsString(matchesMap);
			 logger.info("-------- matchView : matchesMapJson: "+matchesMapJson);
			 modeMap.put("matchesMapJson", matchesMapJson);
			 
		 }
		 catch(Exception ex)
		 {
			 logger.error("---------- Entry in parsing map to json: "+ex);
		 }
		 
		 return SportConstrant.MATCH_PAGE;
	}
	
	@RequestMapping(value = "SortPlayer/{orderBy}", method = RequestMethod.GET)
	public  String orderBy(ModelMap modeMap,HttpServletRequest request,@PathVariable String orderBy)
	{
		logger.info("---------- IN MyTeamView to : ");
		 //int player = GameManager.totalPlayingPlayersOfUserByGame(Integer.valueOf(userId),Integer.valueOf(gameId));
		 HashMap totalPlayingMap= new HashMap();
		 //totalPlayingMap.put("player", player);
		// GameManager.updateTotalPlayingPlayerByPostion(Integer.valueOf(userId),Integer.valueOf(gameId),totalPlayingMap);
		 String totalPlayingJson = "";
		 modeMap.put("totalPlayingMap", totalPlayingMap);
		 logger.info("-------- MyTeamView : totalPlayingMap: "+totalPlayingMap);
		 ObjectMapper mapperObj = new ObjectMapper();
		 try
		 {
			 
			 totalPlayingJson = mapperObj.writeValueAsString(totalPlayingMap);
			 logger.info("-------- MyTeamView : totalPlayingJson: "+totalPlayingJson);
			 
		 }
		 catch(Exception ex)
		 {
			 logger.error("---------- Entry in parsing map to json: "+ex);
		 }
		 modeMap.put("totalPlayingJson", totalPlayingJson);
			
		 return SportConstrant.MY_TEAM_PAGE;
	}

}
