m<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="<%=request.getContextPath()%>" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	 <%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %>   
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<script src="${context}/redBlackTheme/js/jquery.js"></script>
<s:sportExt retrieve="deadLine" />
	  <body class="body predict11-bg transfers_predict11 dream_11transfer ">
      <div class="container-fluid ">
         <!-----------Header---------------->
         <div id="header"></div> 
            <div class="row">
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-sx-12  myteam_fantasy_league">
               
               <div>
                <div class="row">
                	<div class="col-lg-8 col-sm-12">

              
                  <h3>Team Of Gameweek ${gameWeekNumber}</h3>
                		
                	                </div>
                                    
                  <div class="row">
							
						<c:choose>
              		
	              	<c:when test="${empty sportMgmtRes.result.hisotryPlayerList}">
	              		<div class="col-lg-8">
	              		<h4>No team was confirmed for this Game Week</h4>
	              		</div>
	              	</c:when>
	              	
	                <c:otherwise>
	                	<div class="col-lg-8 team_map_dream11">
	                     <div class="ism-element-row ism-element-row--pitch">
		                    	<div id="ismr-pos1" class="ism-pitch__unit ism-pitch__unit--4">
	                              <s:sport position="1" playerType="Goalkeeper" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                       	        <c:if test="${not empty clubId and clubId ne ''}">
	                                  <spring:message code="club_${clubId}_image" var="imageSrc" />
								       <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                              </div>
	                        </div>
	                   </div>
	                     <div class="ism-element-row ism-element-row--pitch">
			                <div id="ismr-pos3" class="ism-pitch__unit ism-pitch__unit--5">
	                           	  <s:sport position="1" playerType="Defender" pageName="DE_MY_POINT"/>
	                             <div class="ism-element" tabindex="0">
	                       	       <c:if test="${not empty clubId and clubId ne ''}">
	                               <spring:message code="club_${clubId}_image" var="imageSrc" />
							    	<img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								     </c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                            </div>
	                     </div>
	                           
	                       <div id="ismr-pos4" class="ism-pitch__unit ism-pitch__unit--5">
	                           <s:sport position="2" playerType="Defender" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                       	        <c:if test="${not empty clubId and clubId ne ''}">
	                                 <spring:message code="club_${clubId}_image" var="imageSrc" />
								      <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                            </div>
	                     </div>
	                       <div id="ismr-pos5" class="ism-pitch__unit ism-pitch__unit--5">
	                           <s:sport position="3" playerType="Defender" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                       	        <c:if test="${not empty clubId and clubId ne ''}">
	                                 <spring:message code="club_${clubId}_image" var="imageSrc" />
								      <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                             </div>
	                     </div>
	                       <div id="ismr-pos6" class="ism-pitch__unit ism-pitch__unit--5">
	                           <s:sport position="4" playerType="Defender" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                                <c:if test="${not empty clubId and clubId ne ''}">
	                                 <spring:message code="club_${clubId}_image" var="imageSrc" />
								      <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if>  
	                              <h4 class="ism-element__name">${playerName}</h4>
	                              </div>
	                     </div>
	             </div>
	                                 
	                     
	                     <div class="ism-element-row ism-element-row--pitch">
		                    <div id="ismr-pos11" class="ism-pitch__unit ism-pitch__unit--3">
	                           <s:sport position="1" playerType="Midfielder" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                       	        <c:if test="${not empty clubId and clubId ne ''}">
	                                 <spring:message code="club_${clubId}_image" var="imageSrc" />
								      <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                             </div>
	                       </div>
	                         <div id="ismr-pos12" class="ism-pitch__unit ism-pitch__unit--3">   
	                           <s:sport position="2" playerType="Midfielder" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                       	        <c:if test="${not empty clubId and clubId ne ''}">
	                                 <spring:message code="club_${clubId}_image" var="imageSrc" />
								      <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                             
	                           </div>
	                       </div>
	                       <div id="ismr-pos13" class="ism-pitch__unit ism-pitch__unit--3">     
	                           <s:sport position="3" playerType="Midfielder" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                       	        <c:if test="${not empty clubId and clubId ne ''}">
	                                 <spring:message code="club_${clubId}_image" var="imageSrc" />
							        	<img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                             
	                            </div>
	                       </div>
	                </div>
	                    
	                    <div class="ism-element-row ism-element-row--pitch">
		                    <div id="ismr-pos8" class="ism-pitch__unit ism-pitch__unit--3">
	                           <s:sport position="1" playerType="Forward" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
	                       	        <c:if test="${not empty clubId and clubId ne ''}">
	                                  <spring:message code="club_${clubId}_image" var="imageSrc" />
								       <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if>
	                              <h4 class="ism-element__name">${playerName}</h4>
	                             
	                            </div>
	                        </div>
	                        <div id="ismr-pos9" class="ism-pitch__unit ism-pitch__unit--3"> 
	                           <s:sport position="2" playerType="Forward" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
								    <c:if test="${not empty clubId and clubId ne ''}">
	                                  <spring:message code="club_${clubId}_image" var="imageSrc" />
								       <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if>
	                              <h4 class="ism-element__name">${playerName}</h4>
	                            </div>
	                     </div>
	                          <div id="ismr-pos10" class="ism-pitch__unit ism-pitch__unit--3"> 
	                           <s:sport position="3" playerType="Forward" pageName="DE_MY_POINT"/>
	                               <div class="ism-element" tabindex="0">
								     <c:if test="${not empty clubId and clubId ne ''}">
	                                  <spring:message code="club_${clubId}_image" var="imageSrc" />
								       <img src="${context}/images/${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
								</c:if> 
	                              <h4 class="ism-element__name">${playerName}</h4>
	                             </div>
	                       </div>
	                              </div>
	                      
	                          
	                      
	                      <div class="row">
	                        <div class="col-lg-4 pull-right claim_your_prize">
	                            <%-- <h4>Your points : ${sportMgmtRes.result.userPoint}</h4> --%>
	                          
	                          <%--  <a href="#"><button type="button" class="btn claim_btn" onclick="uploadCouponsView11('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');">Claim Your Prize</button></a> --%>
	                          </div>    
	                      </div>
	                       
	               	</c:otherwise>
               	</c:choose>
					
				</div>
			</div>
		</div>
	</div>
</body>
			
			
	

 
<script type="text/javascript">
   var gameDetailsJson = null;
   var playerListJson = null;
   var clubListJson = null;
   var userGameJson = null;
   var totalPlayingJson = null;
   </script>
   	<c:if test="${not empty sessionScope.gameDetailsJson}">
   	<script type="text/javascript">
   		gameDetailsJson = ${sessionScope.gameDetailsJson};
   	</script>
   	</c:if>
   	<c:if test="${not empty sessionScope.playerListJson}">
   		<script type="text/javascript">
  		 playerListJson = ${sessionScope.playerListJson};
  		</script>
	</c:if>
  	<c:if test="${not empty sessionScope.userGameJson}">
  	<script type="text/javascript">
  		userGameJson = ${sessionScope.userGameJson};
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.clubListJson}">
  	<script type="text/javascript">
		clubListJson = ${sessionScope.clubListJson};
		</script>
	</c:if>
	<c:if test="${not empty totalPlayingJson}">
  	<script type="text/javascript">
  		totalPlayingJson = ${totalPlayingJson};
		</script>
	</c:if>
<script type="text/javascript">
	$(window).load(function(){
	ToggleShow('.1-box', '.check_1'); ToggleShow('.2-box', '.check_2');
	ToggleShow('.3-box', '.check_3');
	ToggleShow('.4-box', '.check_4');
	ToggleShow('.5-box', '.check_5');
	ToggleShow('.6-box', '.check_6');
	ToggleShow('.7-box', '.check_7');
	ToggleShow('.8-box', '.check_8');
	ToggleShow('.9-box', '.check_9');
	ToggleShow('.10-box', '.check_10');
	ToggleShow('.11-box', '.check_11');
	ToggleShow('.12-box', '.check_12');
	ToggleShow('.13-box', '.check_13');
	ToggleShow('.14-box', '.check_14');
	ToggleShow('.15-box', '.check_15');
	ToggleShow('.16-box', '.check_16');

	function ToggleShow(checkbox, div) {
		$(checkbox).change(function () {
			$(div).toggleClass('enable');
		});
	}
	});
	var playerLimits =  {"minCheckLegth":7,"min":{'Goalkeeper':1,"Defender":3,"Midfielder":3,"Forward":1},"max":{'Goalkeeper':1,"Defender":4,"Midfielder":4,"Forward":2},"total":11}
	function activatePlayer(userId,gameClubPlayerId,checkBox)
	
	{
		if(typeof userId !='undefined' && typeof gameClubPlayerId !='undefined' &&  typeof checkBox != 'undefined')
		{    
			var url="";
			var playerType = "";
			if(checkBox.checked)
			{
				for(var i=0;i<playerListJson.length;i++)
				{
					if(playerListJson[i].gameClubPlayerId == gameClubPlayerId)
					{
						playerType = playerListJson[i].type;
						//document.getElementById("leaguer-pos" +i).className ="enable";
					}
					
				}
				console.log("player Type: "+playerType);
				console.log("total Player: "+totalPlayingJson["player"]+" , player total limit: "+playerLimits["total"]);
				if(totalPlayingJson["player"] >= playerLimits["total"])
				{
					showNotification("You can't select more than 11 Players");
					checkBox.checked = false;
					return;
				}
				console.log("total Player of your type:  "+totalPlayingJson[playerType]+" , maximum limit of your type: "+playerLimits["max"][playerType]);
				if(totalPlayingJson[playerType] >= playerLimits["max"][playerType])
				{
					showNotification(playerType+" Maximum limit is " +playerLimits['max'][playerType]);
					checkBox.checked = false;
					return;
				}
				var leftMinPlayers = 0;
				if(totalPlayingJson["Goalkeeper"] < playerLimits["min"]["Goalkeeper"])
				{
					leftMinPlayers += playerLimits["min"]["Goalkeeper"] - totalPlayingJson["Goalkeeper"];
				}
				if(totalPlayingJson["Defender"] < playerLimits["min"]["Defender"])
				{
					leftMinPlayers += playerLimits["min"]["Defender"] - totalPlayingJson["Defender"];
				}
				if(totalPlayingJson["Midfielder"] < playerLimits["min"]["Midfielder"])
				{
					leftMinPlayers += playerLimits["min"]["Midfielder"] - totalPlayingJson["Midfielder"];
				}
				if(totalPlayingJson["Forward"] < playerLimits["min"]["Forward"])
				{
					leftMinPlayers += playerLimits["min"]["Forward"] - totalPlayingJson["Forward"];
				}
				var leftTotalPlayer = playerLimits["total"]-totalPlayingJson["player"];
				console.log("<-------- Left total Player: "+leftTotalPlayer+",  leftMinPlayers: "+leftMinPlayers);
				if(leftTotalPlayer <= leftMinPlayers)
				{
					if(totalPlayingJson[playerType] >= playerLimits["min"][playerType])
					{
						showNotification("Select minimum "+playerLimits["min"]["Goalkeeper"]+" Goalkeeper, "+playerLimits["min"]["Midfielder"]+" Midfielder, "+playerLimits["min"]["Defender"]+" Defender, "+playerLimits["min"]["Forward"]+" Forward");
						checkBox.checked = false;
						return;

					}	
				}
				url ="/SportMgmt/mvc/game/ActivatePlayer?userId="+userId+"&gameClubPlayerId="+gameClubPlayerId;
				$.ajax({
					
					
		     		  url: url,
		     		  dataType: 'json',
		     		  success: function( resp ) {
		     			  if(resp.isSuccess)
		     			  {
		     				 if(typeof resp.userGameJson != 'undefined')
		     				  userGameJson = resp.userGameJson;
		     				 if(typeof resp.totalPlayingJson != 'undefined')
		     					totalPlayingJson = resp.totalPlayingJson;
		     				updatePlayerList();
		     			  }
		     			  else
		    			  {
		     				 showNotification(resp.errorMessage);
		    			  }
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});
			}
			else
			{
				url ="/SportMgmt/mvc/game/DeActivatePlayer?userId="+userId+"&gameClubPlayerId="+gameClubPlayerId;
				$.ajax({
		     		  url: url,
		     		  dataType: 'json',
		     		  success: function( resp ) {
		     			  if(resp.isSuccess)
		     			  {
		     				 if(typeof resp.userGameJson != 'undefined')
			     				  userGameJson = resp.userGameJson;
			     			  if(typeof resp.totalPlayingJson != 'undefined')
			     				totalPlayingJson = resp.totalPlayingJson;
			     			  updatePlayerList();
		     			  }
		     			  else
		    			  {
		     				 showNotification(resp.errorMessage);
		    			  }
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});

			}
		}
	}
	  function checkPlayerCountAndConfirmTeam()
	 	{ 
	 		if(totalPlayingJson["player"] < playerLimits["total"])
	 		{
	 			showNotification('Please select 11 players');			
	 		}
	 		else
	 		{	 
	 			$("#modelPlayOption").fadeIn("slow");
	 			$(".close").click(function(){			              
	 				$("#modelPlayOption").fadeOut("slow");
	 			});
	 		}
	 	} 
		 function createHistory11( gameId, gameWeekId, userId)
		 	{ 
			 if(totalPlayingJson["player"] >= playerLimits["total"])
					 {
			 url ="/SportMgmt/mvc/player/check-player-history/"+gameId+"/"+gameWeekId+"/"+userId+"?gameType=" ;
					$.ajax({
		     		  url: url,
		     		 dataType: 'html',
		     		  success: function( resp ) {
		     			 console.log(resp);
		     			 if(resp=="true")
		     			 {
		     				showNotification('your team is already confirmed for current Gameweek');
		     			}
		     			 else
		     				 {
				
		     				url ="/SportMgmt/mvc/player/make-player-history-for-user/"+gameId+"/"+gameWeekId+"/"+userId+"?gameType=" ;
		    	 			$.ajax({
		    	 	     		  url: url,
		    	 	     		 dataType: 'html',
		    	 	     		  success: function( resp ) {
		    	 	     			console.log("resp"+resp);
		    	 	     			showNotification('your team has been confirmed');	    	 	     				 
		    	 	     		},
		    	 	     		  
		    	 	     		  error: function( req, status, err ) {
		    	 	     		    console.log( 'something went wrong', status, err );
		    	 	     		  }
		    	 	     		    
		    	 	     		  });
		     				 }	     		  
		     		 },
		     		 
		     		   error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		   }
		     		}); 
			 }
			 else
			 {
				 showNotification('Please select 11 players');
			 }		
		}
	$(document).ajaxStart(function(){
 		$("#ajaxloader").css("display", "block");
 		$('.mask').show();
 	});

 	$(document).ajaxComplete(function(){
 	    $("#ajaxloader").css("display", "none");
 	    $('.mask').hide();
 	});
 	function updatePlayerList()
 	{
 		if(typeof userGameJson !='undefined')
 		{
 			var activePlayerHtml = '<option value="0">Select Captain</option>';
 			var activePlayerHtml1 = '<option value="0">Select Vice Captain</option>';
 			var selectedCaptain = $('#captain-select option:selected').val();
 			var selectedViceCaptain = $('#vice-captain-select option:selected').val();
 			console.log('selectedCaptain: '+selectedCaptain+" , selectedViceCaptain: "+selectedViceCaptain);
 			for(var i=0;i<userGameJson.playerList.length;i++)
 			{
 				
 				if(userGameJson.playerList[i].isPlaying == 'Y')
 				{
 					var gameClubPlayerId = userGameJson.playerList[i].gameClubPlayerId;
 					//console.log("i: "+i+" , gameClubPlayerId: "+userGameJson.playerList[i].gameClubPlayerId);
 					var playerName='';
 					for(var j=0;j<playerListJson.length;j++)
 					{
 						if(playerListJson[j].gameClubPlayerId == gameClubPlayerId)
 						{
 							playerName = playerListJson[j].name;
 						}
 						
 					}
 					if(typeof selectedCaptain == 'undefined' && userGameJson.playerList[i].playerCategory == 'C')
 					{
 						selectedCaptain = gameClubPlayerId;
 					}
 					if(typeof selectedViceCaptain == 'undefined' && userGameJson.playerList[i].playerCategory == 'V')
 					{
 						selectedViceCaptain = gameClubPlayerId;
 					}
 					//console.log("playerName: "+playerName);
 					if(gameClubPlayerId == selectedCaptain)
 					activePlayerHtml +='<option value="'+gameClubPlayerId+'" selected>'+playerName+'</option>';
 					else
 					activePlayerHtml +='<option value="'+gameClubPlayerId+'">'+playerName+'</option>';
 					
 					if(gameClubPlayerId == selectedViceCaptain)
 	 				activePlayerHtml1 +='<option value="'+gameClubPlayerId+'" selected>'+playerName+'</option>';
 	 				else
 	 				activePlayerHtml1 +='<option value="'+gameClubPlayerId+'">'+playerName+'</option>';
 				}
 			}
 			console.log("activePlayerHtml: "+activePlayerHtml);
 			$('#captain-select').html(activePlayerHtml);
 			$('#vice-captain-select').html(activePlayerHtml1);
 		}
 	}
 	function updateCaptain(userId)
 	{
 		var selectedCaptain = $('#captain-select option:selected').val();
 		var selectedViceCaptain = $('#vice-captain-select option:selected').val();
 		if(typeof selectedCaptain != 'undefined' && selectedCaptain !=0)
 		{
 			url ="/SportMgmt/mvc/game/MakeCaptain?userId="+userId+"&gameClubPlayerId="+selectedCaptain;
 			$.ajax({
 	     		  url: url,
 	     		  dataType: 'json',
 	     		  async: false,
 	     		  success: function( resp ) {
 	     			  if(resp.isSuccess)
 	     			  {
 	     				 if(typeof resp.userGameJson != 'undefined')
 	     				  userGameJson = resp.userGameJson;
 	     				 if(typeof resp.totalPlayingJson != 'undefined')
 	     					totalPlayingJson = resp.totalPlayingJson;
 	     				//updatePlayerList();
 	     			  }
 	     			  else
 	    			  {
 	     				showNotification(resp.errorMessage);
 	    			  }
 	     		  },
 	     		  error: function( req, status, err ) {
 	     		    console.log( 'something went wrong', status, err );
 	     		  }
 	     		})
 		}
 		if(typeof selectedViceCaptain != 'undefined' && selectedViceCaptain !=0)
 		{
 			url ="/SportMgmt/mvc/game/MakeViceCaptain?userId="+userId+"&gameClubPlayerId="+selectedViceCaptain;
 			$.ajax({
 	     		  url: url,
 	     		  dataType: 'json',
 	     		  async: false,
 	     		  success: function( resp ) {
 	     			  if(resp.isSuccess)
 	     			  {
 	     				 if(typeof resp.userGameJson != 'undefined')
 	     				  userGameJson = resp.userGameJson;
 	     				 if(typeof resp.totalPlayingJson != 'undefined')
 	     					totalPlayingJson = resp.totalPlayingJson;
 	     				//updatePlayerList();
 	     			  }
 	     			  else
 	    			  {
 	     				showNotification(resp.errorMessage);
 	    			  }
 	     		  },
 	     		  error: function( req, status, err ) {
 	     		    console.log( 'something went wrong', status, err );
 	     		  }
 	     		})
 		}
 	}
 	$(document).ready(function(){
 		updatePlayerList();
 	});
</script>
<script>
// Set the date we're counting down to
var countDownDate = new Date("${deadline}").getTime();
//var countDownDate = new Date("27 Oct 2017 01:01:01").getTime();

// Update the count down every 1 second
var x = setInterval(function() {

    // Get todays date and time
    var now = new Date().getTime();
    
    // Find the distance between now an the count down date
    var distance = countDownDate - now;
    
    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    // Output the result in an element with id="demo"
    document.getElementById("countDown").innerHTML = days + "d " + hours + "h "
    + minutes + "m " + seconds + "s " +"left until you can ";
    
    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("countDown").innerHTML = "Team Confirmation is closed for current Gameweek";
        //document.getElementById("confirmTeam").className += " disabled";
        document.getElementById("confirmTeam").setAttribute('disabled','disabled');
    }
}, 1000);
</script>


