<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="/SportMgmt" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="sportmgmt.tld" prefix="s" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>





<style>
         .my_team_points li {padding: 5px !important;}
      </style>
    
<s:sportExt retrieve="priceList" />
<s:sportExt retrieve="deadLine" />

<body class="predict11-bg transfers_predict11 dream_11transfer">
<div class="container ">
	<div class="row">
		<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 transfers_predict11_map">
			<img src="${context}/redBlackTheme/images/banner12.png" class="img-responsive center-block">
			<div>
				<h3>Select Players from List</h3>
				<p>Gameweek ${gameWeekNumber} Deadline: <time datetime="2016-08-27T10:30:00Z">${deadline}</time><p>
	            <p>Player Count: <span class="added-player-count"> </span> </p>			
				<div class="col-lg-8 team_map_dream11">
				<div class="row" >                              
					<!-- <div class="ism-element-row ism-element-row--pitch">-->
                    	<div id="ismr-pos1" class="ism-pitch__unit ism-pitch__unit--4"> 							
                           	<s:sport position="1" playerType="Goalkeeper"/> 
                           	<div class="ism-element" tabindex="0">                                               
							<div 
							<c:choose>
							<c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when>
							<c:otherwise>class="class="ismjs-select"</c:otherwise>
							</c:choose>
							>              
								<img src=" ${context}/redBlackTheme/images/Dream11/goalkeeper_old.png"  alt="" title="Select a Goalkeeper from the player list" class="img-responsive gaolkeeper_hvr"  onclick="openNav()">								       
								<c:choose>
									<c:when test="${isPlayerAvail}">
										<div class="ism-element__name ism-element__name--placeholder">
										  ${playerName} <abbr title="Goalkeeper" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
										</div>
									</c:when>
									<c:otherwise>
										<div class="ism-element__name ism-element__name--placeholder">
										   <abbr title="Goalkeeper" class="ism-element__type"><span class="ism-element__type__short">GKP</span></abbr>
										</div>
									</c:otherwise>
								</c:choose>                                                            
				    		</div>	
				    		</div>						
						</div>
					</div>
					<div class="ism-element-row ism-element-row--pitch">
	                    <div id="ismr-pos3" class="ism-pitch__unit ism-pitch__unit--5">
	                        <s:sport position="1" playerType="Defender"/>
                            <div class="ism-element" tabindex="0">
                                <div 
                                <c:choose>
                                	<c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"                                   	
                                	</c:when>
                                	<c:otherwise>class="ismjs-select"</c:otherwise>
                                </c:choose>
                                >                                                                                                                
                                    <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                    alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                        															
                                    <c:choose>
	                                    <c:when test="${isPlayerAvail}">
	                                       ${playerName} <abbr title="Defender">
	                                       <span class="ism-element__type__short">${price}</span></abbr>
	                                    </c:when>
	                                    <c:otherwise>
	                                         <abbr title="Defender" ><span >DEF</span></abbr>
	                                    </c:otherwise>
                                    </c:choose>                                                            
                                 </div>
                            </div>
						</div>
                    <div id="ismr-pos4" class="ism-pitch__unit ism-pitch__unit--5">
                         <s:sport position="2" playerType="Defender"/>
                            <div class="ism-element" tabindex="0">
                                <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>
                                    <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                        alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                                     <c:choose>
                                     <c:when test="${isPlayerAvail}">
                                     	<div class="ism-element__name ism-element__name--placeholder">
                                        ${playerName} <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                     </div>
                                     </c:when>
                                     <c:otherwise>
                                     <div class="ism-element__name ism-element__name--placeholder">
                                         <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr>
                                     </div>
                                     </c:otherwise>
                                     </c:choose>
                                </div>
                            </div>
                    </div>
                    <div id="ismr-pos5" class="ism-pitch__unit ism-pitch__unit--5">
                        <div>
                         <s:sport position="3" playerType="Defender"/>
                            <div class="ism-element" tabindex="0">

                                <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                    <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                        alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                            			

                                   
                                     <c:choose>
                                     <c:when test="${isPlayerAvail}">
                                     	<div class="ism-element__name ism-element__name--placeholder">
                                        ${playerName} <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                     </div>
                                     </c:when>
                                     <c:otherwise>
                                     <div class="ism-element__name ism-element__name--placeholder">
                                         <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">Defender</span></abbr>
                                     </div>
                                     </c:otherwise>
                                     </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div id="ismr-pos6" class="ism-pitch__unit ism-pitch__unit--5">
                        <div>
                         <s:sport position="4" playerType="Defender"/>
                            <div class="ism-element" tabindex="0">

                                <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                   <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                   alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                            			

                                   
                                     <c:choose>
                                     <c:when test="${isPlayerAvail}">
                                     	<div class="ism-element__name ism-element__name--placeholder">
                                        ${playerName} <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                     </div>
                                     </c:when>
                                     <c:otherwise>
                                     <div class="ism-element__name ism-element__name--placeholder">
                                         <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr>
                                     </div>
                                     </c:otherwise>
                                     </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    
                
                </div>

                                       

                                       <div class="ism-element-row ism-element-row--pitch">
                                           <div id="ismr-pos11" class="ism-pitch__unit ism-pitch__unit--5">
                                               <div>
                                               <s:sport position="1" playerType="Midfielder"/>
                                                   <div class="ism-element" tabindex="0">
                                                       <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                           <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                                               alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                                                   			
														
                                                            <c:choose>
                                                            <c:when test="${isPlayerAvail}">
                                                            	<div class="ism-element__name ism-element__name--placeholder">
                                                               ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                            </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <div class="ism-element__name ism-element__name--placeholder">
                                                               <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                            </div>
                                                            </c:otherwise>
                                                            </c:choose>
                                                           </div>
                                                   </div>
                                               </div>
                                           </div>
                                           <div id="ismr-pos12" class="ism-pitch__unit ism-pitch__unit--5">
                                               <div>
                                                <s:sport position="2" playerType="Midfielder"/>
                                                   <div class="ism-element" tabindex="0">

                                                       <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                          
                                                               <img src="${context}/redBlackTheme/images/Dream11/player.png"  alt="" title="Select a Midfielder from the player list" class="ism-shirt ism-element__shirt center-block">

                                                          
                                                            <c:choose>
                                                            <c:when test="${isPlayerAvail}">
                                                            	<div class="ism-element__name ism-element__name--placeholder">
                                                               ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                            </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <div class="ism-element__name ism-element__name--placeholder">
                                                               <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                            </div>
                                                            </c:otherwise>
                                                            </c:choose>
                                                       </div>

                                                   </div>
                                               </div>
                                           </div>
                                           <div id="ismr-pos13" class="ism-pitch__unit ism-pitch__unit--5">
                                               <div>
                                                <s:sport position="3" playerType="Midfielder"/>
                                                   <div class="ism-element" tabindex="0">

                                                       <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                           <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                                               alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                                                   			
                                                            <c:choose>
                                                            <c:when test="${isPlayerAvail}">
                                                            	<div class="ism-element__name ism-element__name--placeholder">
                                                               ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                            </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <div class="ism-element__name ism-element__name--placeholder">
                                                               <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                            </div>
                                                            </c:otherwise>
                                                            </c:choose>
                                                       </div>

                                                   </div>
                                               </div>
                                           </div>
                                           <div id="ismr-pos14" class="ism-pitch__unit ism-pitch__unit--5">
                                               <div>
                                               <s:sport position="4" playerType="Midfielder"/>
                                                   <div class="ism-element" tabindex="0">
                                                       <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                           <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                                               alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                                                   			
                                                   		<c:choose>
                                                            <c:when test="${isPlayerAvail}">
                                                            	<div class="ism-element__name ism-element__name--placeholder">
                                                               ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                            </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <div class="ism-element__name ism-element__name--placeholder">
                                                                <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                            </div>
                                                            </c:otherwise>
                                                            </c:choose>
                                                       </div>

                                                   </div>
                                               </div>
                                           </div>
                                          
                                       </div>
                                       <div class="ism-element-row ism-element-row--pitch">
                                           <div id="ismr-pos8" class="ism-pitch__unit ism-pitch__unit--3">
                                               <div>
                                               <s:sport position="1" playerType="Forward"/>
                                                   <div class="ism-element" tabindex="0">

                                                       <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                           <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                                               alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                                                   			
														
                                                            <c:choose>
                                                            <c:when test="${isPlayerAvail}">
                                                            	<div class="ism-element__name ism-element__name--placeholder">
                                                               ${playerName} <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                            </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <div class="ism-element__name ism-element__name--placeholder">
                                                                <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">FWD</span></abbr>
                                                            </div>
                                                            </c:otherwise>
                                                            </c:choose>
                                                       </div>

                                                   </div>
                                               </div>
                                           </div>
                                           <div id="ismr-pos9" class="ism-pitch__unit ism-pitch__unit--3">
                                               <div>
                                               <s:sport position="2" playerType="Forward"/>
                                                   <div class="ism-element" tabindex="0">

                                                       <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                           <img src="${context}/redBlackTheme/images/Dream11/player.png" 
                                                               alt="" title="Select a Defender from the player list" class="center-block img-responsive">
                                                   			
                                                           
                                                            <c:choose>
                                                            <c:when test="${isPlayerAvail}">
                                                            	<div class="ism-element__name ism-element__name--placeholder">
                                                               ${playerName} <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                            </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <div class="ism-element__name ism-element__name--placeholder">
                                                               <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">FWD</span></abbr>
                                                            </div>
                                                            </c:otherwise>
                                                            </c:choose>

                                                       </div>

                                                   </div>
                                               </div>
                                           </div>                                           
                                       </div>                               
                           </div>
           

        <!-- Player list starts --> 
        <div   id="myNav" >   
        <div id="ismr-side" class="ism-sidebar">             
			<h3 class="subHeader ism-sub-header ism-section-header__title" tabindex="0" id="ismjs-side-focus">PLAYERS</h3>
			 <!--<div><img src="SportMgmt/redBlackTheme/images/Dream11/player_btn.png" class="img-responsive center-block"></div>-->
            <form class="ism-form">
          		<div class="ism-form__group">
            		<label for="ismjs-element-filter" class="ism-form__label">View</label>
                	<div class="ism-form__select-wrap">
                        <select id="ismjs-element-filter" class="ism-form__select" data-global="Global" data-position="By Position" data-team="By Team">
                            <optgroup label="Global">
                                <option value="all">All players</option>
                            </optgroup>
                            <optgroup label="By Position">
                                <option value="Goalkeepers">Goalkeepers</option>
                                <option value="Defenders">Defenders</option>
                                <option value="Midfielders">Midfielders</option> 
                                <option value="Forwards">Forwards</option>                                                                               
                            </optgroup>
                            <optgroup label="By Team">
                            <c:forEach var="clubMap" items="${sessionScope.clubList}">
                            	<option value="club_${clubMap['clubId']}">${clubMap['name']}</option>
                            </c:forEach>
                            </optgroup>
                        </select>
                    </div>
                </div> 
            </form>
            <p>Total Players : ${fn:length(sessionScope.playerList)}</p>

		    <div id="ismjs-elements-list-tables">
		    	<!-- goalkeeper list starts -->
		    	<!-- below class (table) is used to filter based on player category -->
		    	<div class="table heading" id="Goalkeepers" >
		        	<table>
		                <tr>
		                    <th></th>
		                    <th>Goalkeepers</th>
		                    <th><abbr title="Price in Million INR">&#8377</abbr></th>
		                    <c:choose>
		                    <c:when test="${sessionScope.playersOrderBy eq 'user_count'}">
		                    	<th><abbr title="Total Score">TS</abbr>
		                    </c:when>
		                    <c:otherwise>
		                    	<th><abbr title="Total Score">TS</abbr></th>
		                    </c:otherwise>
		                    </c:choose>
		                </tr>		            	
		            </table>
	            </div>
	            <div class="table scroll-tbl" id="Goalkeepers" >
		            <table class="my_team_points add_players bxslider13">		           
				            <c:forEach var="playerMap" items="${sessionScope.playerList}">
					            <c:if test="${playerMap.type eq 'Goalkeeper'}">
					            	<!-- below class(ismjs-menu ism-row-select) is used to filter goalkeeper list based on team -->
						            <tr class="ismjs-menu ism-row-select" id="${playerMap.gameClubPlayerId}">
						    			<td><a href="javascript:void(0);" class="glyphicon glyphicon-plus" onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');"></a></td>
									    <td>
											<c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
												<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
											</c:if>							                           
							                <img src="/SportMgmt/images/Goalkeeper_${imageSrc}" height="20" width="20" alt="Arsenal" title="${playerMap.name}" class="ism-shirt">
							                ${playerMap.name}								        
						    			</td>
									    <td>${playerMap.price}</td>
									    <c:choose>
									        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}">
									        	<td>${playerMap.userCount}</td>
									       	</c:when>
									        <c:otherwise>
									        	<td>${playerMap.totalScore}</td>
									        </c:otherwise>
									    </c:choose>
									</tr>
								</c:if>
							</c:forEach>							
					</table>
				</div>
				<!-- Goalkeeper List ends -->
			
				<!-- Defender List starts -->
			    <div  class="table heading" id="Defenders">
			        <table>			            
		                <tr>
		                    <th></th>
		                    <th><a href="#">Defender</a></th>
		                    <th><abbr title="Price in Million INR">&#8377</abbr></th>
		                    <c:choose>
		                    	<c:when test="${sessionScope.playersOrderBy eq 'user_count'}">
		                    		<th><abbr title="Total Score">UC</abbr>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<th><abbr title="Total Score">TS</abbr></th>
		                    	</c:otherwise>
		                    </c:choose>
		                </tr>			            
			         </table>
				</div>
            	<div class="table scroll-tbl" id="Defenders">
			        <table class="my_team_points add_players bxslider13">			           
			            <c:forEach var="playerMap" items="${sessionScope.playerList}">
				            <c:if test="${playerMap.type eq 'Defender'}">
					            <tr class="ismjs-menu ism-row-select" id="${playerMap.gameClubPlayerId}">
								    <td ><a href="javascript:void(0);"  class="glyphicon glyphicon-plus" onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');"></a></td>
								    <td>
										<c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
											<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
										</c:if>
										<img src="/SportMgmt/images/Defender_${imageSrc}" height="20" width="20" alt="" title="${playerMap.name}" class="ism-shirt">
						                ${playerMap.name}						                
						            </td>
								    <td>${playerMap.price}</td>
								    <c:choose>
								        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><td>${playerMap.userCount}</td></c:when>
								        <c:otherwise><td>${playerMap.totalScore}</td></c:otherwise>
								    </c:choose>
								</tr>
							</c:if>
						</c:forEach>						
					</table>
				</div>
				<!-- Defender List ends -->
				<!-- Midfielders List starts -->
			   <div class=" table heading" id="Midfielders">
			        <table>
			            <tr>
		                    <th></th>
		                    <th><a href="#">Midfielder</a></th>
		                    <th><abbr title="Price in Million INR">&#8377</abbr></th>
		                    <c:choose>
		                    	<c:when test="${sessionScope.playersOrderBy eq 'user_count'}">
		                    		<th><abbr title="Total Score">UC</abbr></c:when>
		                    	<c:otherwise><th><abbr title="Total Score">TS</abbr></th></c:otherwise>
		                    </c:choose>
			            </tr>
			         </table>
			    </div>
				<div class="table scroll-tbl" id="Midfielders">
			        <table class="my_team_points add_players bxslider13">			            
			            <c:forEach var="playerMap" items="${sessionScope.playerList}">
				            <c:if test="${playerMap.type eq 'Midfielder'}">
					            <tr class="ismjs-menu ism-row-select" id="${playerMap.gameClubPlayerId}">
								    <td>
								    	<a href="javascript:void(0);" class="glyphicon glyphicon-plus" onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');"></a>
								    </td>
					    			<td >
										<c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
										<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
										</c:if>
						               <img src="/SportMgmt/images/Midfielder_${imageSrc}" height="20" width="20" alt="" title="${playerMap.name}">
						               ${playerMap.name }
						     		</td>
								    <td>${playerMap.price}</td>
								    <c:choose>
								        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}">
								        	<td>${playerMap.userCount}</td>
								        </c:when>
								        <c:otherwise>
								        	<td>${playerMap.totalScore}</td>
								        </c:otherwise>
								    </c:choose>
								</tr>
							</c:if>
						</c:forEach>
					</table>
			    </div>
			    <!-- Midfielders List ends -->
			
				<!-- Forwards List ends -->
			    <div class="table heading" id="Forwards" >
			        <table class="ism-table ism-table--el ism-table--el-list" >			           
		                <tr>
		                    <th></th>
		                    <th><a href="#" class="ism-link--bold">Forward</a></th>
		                    <th><abbr title="Price in Million INR">&#8377</abbr></th>
		                    <c:choose>
		                    	<c:when test="${sessionScope.playersOrderBy eq 'user_count'}">
		                    		<th><abbr title="Total Score">UC</abbr>
		                    </c:when>
		                    <c:otherwise>
		                    	<th><abbr title="Total Score">TS</abbr></th>
		                    </c:otherwise>
		                    </c:choose>
		                </tr>			            
		            </table>
				</div>
            	<div class="table scroll-tbl" id="Forwards">
			        <table class="my_team_points add_players bxslider13">
			            <c:forEach var="playerMap" items="${sessionScope.playerList}">
			            <c:if test="${playerMap.type eq 'Forward'}">
				            <tr class="ismjs-menu ism-row-select ism-element-list__info--0" id="${playerMap.gameClubPlayerId}">
							    <td>        
							    	<a href="javascript:void(0);"  class="glyphicon glyphicon-plus" onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');" ></a>
							    </td>
							    <td>
									<c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
										<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
									</c:if>
									<img src="/SportMgmt/images/Forward_${imageSrc}" height="20" width="20" alt="" title="${playerMap.name}">
					                ${playerMap.name}
				    			</td>
							    <td>${playerMap.price }</td>
							    <c:choose>
							        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}">
							        	<td>${playerMap.userCount}</td>
							        </c:when>
							        <c:otherwise>
							        	<td>${playerMap.totalScore}</td>
							        </c:otherwise>
							    </c:choose>
							</tr>
						</c:if>
						</c:forEach>
					</table>
				</div>
			</div>
		</div> <!--  side div with player list ends -->
		</div>
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
   var userGameJsonDreamEleven = null;   
   var purchableWildCardJson = null;
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
  	<c:if test="${not empty sessionScope.clubListJson}">
  	<script type="text/javascript">
		clubListJson = ${sessionScope.clubListJson};
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userGameJson}">
  	<script type="text/javascript">
  		userGameJson = ${sessionScope.userGameJson};
  		console.log("sssssssssssss" +userGameJson);
		</script>
		
	</c:if>
	<c:if test="${not empty sessionScope.userGameJsonDreamEleven}">
  	<script type="text/javascript">
  		userGameJson = ${sessionScope.userGameJsonDreamEleven};
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.purchableWildCardJson}">
  	<script type="text/javascript">
  	purchableWildCardJson = ${sessionScope.purchableWildCardJson};
  	var planDiscountId = '${sessionScope.planDiscountId}';
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userJson}">
   		<script type="text/javascript">
   		userJson = ${sessionScope.userJson};
  		</script>
	</c:if>
	<script type="text/javascript">
	
	function aa(){
		var elems2 = '<div class="ismjs-select">'+
	     '<picture>'+
	     '<img src="${context}/redBlackTheme/images/Dream11/player_old.png ">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Goalkeeper" class="ism-element__type"><span class="ism-element__type__short">Goalkeeper</span></abbr></div>';
	     
	     $('.ism-element-row.ism-element-row--pitch:first-child .ismjs-remove').click(function () {
	    	 var userId = userJson.userId;
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,elems2);
	    	 }
	    	 return false;
	    })
	};
	
	
	function defenderRemove(){
		var def2 = '<div class="ismjs-select">'+
	     '<picture>'+
	    '<img src="${context}/redBlackTheme/images/Dream11/player.png"  alt="" title="Select a Defender from player list" class="ism-shirt ism-element__shirt">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr></div>';
	     
	     
	     
	     $('.ism-element-row.ism-element-row--pitch:nth-child(2) .ismjs-remove').click(function () {
	    	 var userId = userJson.userId;
	    	 
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,def2);
	    	 }
	    	
	    	 return false;
	    })
	};
	
	
	function midfielderRemove(){
		var midd2 = '<div class="ismjs-select">'+
	     '<picture>'+
	     '<img src="${context}/redBlackTheme/images/Dream11/player.png" alt="" title="Select a Midfielder from player list" class="ism-shirt ism-element__shirt">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr></div>';
	    
	     
	     
	     $('.ism-element-row.ism-element-row--pitch:nth-child(3) .ismjs-remove').click(function () {
	    	 var userId = userJson.userId;
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,midd2);
	    	 }
	    	 return false;
	    })
	};
	
	function forwardRemove(){
		var for2 = '<div class="ismjs-select">'+
	     '<picture>'+
	    '<img src="${context}/redBlackTheme/images/Dream11/player.png" alt="" title="Select a Forward from player list" class="ism-shirt ism-element__shirt">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">FWD</span></abbr></div>';
	    
	     $('.ism-element-row.ism-element-row--pitch:nth-child(4) .ismjs-remove').click(function () {
	    	 var userId =userJson.userId;
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,for2);
	    	 }
	    	 return false;
	    })
	};
	
	<c:if test="${!isUnderDeadline}">
			$('.ism-element').mousemove(function(){
			
			aa();		
			defenderRemove();
			midfielderRemove();
			forwardRemove();
		})

	</c:if>
	
	$(document).ready(function() {
		$(".added-player-count").text(""+userGameJson.playerList.length+"/11");
		$("div.ismjs-select.added-player-css").each(function(){
			var gameClubPlayerId = $(this).attr('id');
			console.info('gameClubPlayerId: '+gameClubPlayerId);
			var playerClubId = "";
			var playerType = "";
			var playerPrice = "";
			var playerName = "";
			var userId = userJson.userId;
			if(typeof playerListJson != 'undefined')
			{
				for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
				{
				  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
					{
					  playerClubId =   playerListJson[playerListIndex].clubId;
					  playerType =   playerListJson[playerListIndex].type;
					  playerPrice =   playerListJson[playerListIndex].price;
					  playerName =   playerListJson[playerListIndex].name;
					}
					  
				}
			}
			console.info('playerClubId--: '+playerClubId);
			var clubImage = clubIdImageMap[playerClubId];
			console.info('clubImage--: '+clubImage);			
			if(playerType == 'Goalkeeper')
			 {
				$("#Goalkeepers .addPlayer>a").closest('tr').attr('disabled', 'disabled');

				var elems = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		       
		       '<picture>'+
		        '<img src="/SportMgmt/images/Goalkeeper_'+clubImage+'" alt="'+playerName+'" title="" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		        
		       
		        $('.ism-element-row.ism-element-row--pitch:first-child').find('.ismjs-select').first().replaceWith(elems); 
			 }
			 if(playerType == 'Midfielder')
			 {
				$('#Midfielders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
				
				var midfielder = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		       
		       '<picture>'+
		        '<img src="/SportMgmt/images/Midfielder_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		       
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		        
		        $('.ism-element-row.ism-element-row--pitch:nth-child(3)').find('.ismjs-select').first().replaceWith( midfielder );
			 }
			 if(playerType == 'Defender')
			 {
				$('#Defenders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
				
				var defender = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		       
		       '<picture>'+
		        '<img src="/SportMgmt/images/Defender_'+clubImage+'"  alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		        
		        $('.ism-element-row.ism-element-row--pitch:nth-child(2)').find('.ismjs-select').first().replaceWith( defender );
		       
			 }
			 if(playerType == 'Forward')
			 {
				$('#Forwards .addPlayer>a').closest('tr').attr('disabled', 'disabled');
				
				var forward = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		      
		       '<picture>'+
		        '<img src="/SportMgmt/images/Forward_'+clubImage+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		       
		       	        
		        $('.ism-element-row.ism-element-row--pitch:nth-child(4)').find('.ismjs-select').first().replaceWith( forward );
			 }

		});
		
		$("#paymentModel").find("button").click(function(){
			var planId =  $(this).attr("id").split("_")[1];
			console.log("Plan Id: "+planId);
			//var paymentForm = $("#paymentForm_"+planId);
			var paymentForm = document.createElement("form");
		    var plan = document.createElement("input"); 
		    var discount = document.createElement("input");
		    var amount = document.createElement("input");
		
		    paymentForm.method = "POST";
		    paymentForm.action = "/SportMgmt/mvc/payment/MakePayment";   
		
		    plan.value=planId;
		    plan.name="leaguePlanId";
		    paymentForm.appendChild(plan);  
		
		    discount.value=planDiscountId;
		    discount.name="planDiscountId";
		    paymentForm.appendChild(discount);
		    amount.name = "amount";
		    if(purchableWildCardJson != null && typeof purchableWildCardJson != 'undefined')
		    {
		    	console.log("Going ot iterate purchableWildCardJson");
		    	for(var i = 0;i<purchableWildCardJson.length;i++)
			    {
			    	console.log("iterating purchableWildCardJson: planId: "+purchableWildCardJson[i].planId);
			    	if(purchableWildCardJson[i].planId == planId)
			    	{
			    		console.log("gettting amount :: "+purchableWildCardJson[i].amount);
			    		amount.value = purchableWildCardJson[i].price;
			    		paymentForm.appendChild(amount);  
			    		document.body.appendChild(paymentForm);
			 			paymentForm.submit();
			    	}
			    }
		    }
		});
	});
	 $('#ismjs-element-filter').change(function(){
	  var selected = $(':selected',this); 
	  filterByView(selected);
	  
   });
 $('#ismjs-element-price').change(function(){
	 console.info("---- filter by price");
	  var filterByViewSelected = $(':selected',$('#ismjs-element-filter')); 
	  filterByView(filterByViewSelected);
	  var selected = $(':selected',this);
	  var seletedPrice = selected.attr("value");
	  console.info("---- filter by price selected value: "+seletedPrice);
	  if(seletedPrice != null && seletedPrice != 'undefined' && seletedPrice !='0')
	  {
		  $("tr.ismjs-menu.ism-row-select:visible").each(function()
					{
						var gameClubPlayerId = $(this).attr('id');
						var playerPrice = 0;
						if(typeof playerListJson != 'undefined')
						{
							for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
							{
							  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
								{
								  playerPrice =   playerListJson[playerListIndex].price;
								}
								  
							}
						}
						if(parseInt(seletedPrice) !=playerPrice)
						{
							 $(this).hide();
						}
						
					});
	  }
	$("p.ism-elements-shown strong.ism-elements-shown__num").text($("tr.ismjs-menu.ism-row-select:visible").length);
  });

 function filterByView(selected)
 {
	 console.info("---- filter by View");	
	 console.info(selected.closest('optgroup').attr('label'));
	  $("tr.ismjs-menu.ism-row-select").each(function()
		{
			$(this).show();
		});
	  $("div#ismjs-elements-list-tables").find("div.table").each(function(){
			 // console.info(" table Id: "+$(this).attr('id'));
			 $(this).show();
		})
	  if(typeof selected.closest('optgroup').attr('label') != 'undefined' && selected.closest('optgroup').attr('label') == 'By Position')
		{
		  var playerGroup = selected.attr("value");
		  console.info("--- Selected Position: "+playerGroup);
		  $("div#ismjs-elements-list-tables").find("div.table").each(function(){
			  console.info(" table Id: "+$(this).attr('id'));
			  if(typeof $(this).attr('id') != 'undefined' && $(this).attr('id')!== playerGroup)
			  {
				  $(this).hide();
			  }
		 })
		}
	  else if(typeof selected.closest('optgroup').attr('label') != 'undefined' && selected.closest('optgroup').attr('label') == 'By Team')
		{
		  var selectedClub = selected.attr("value");
		  console.info("--- Selected Club: "+selectedClub);
		  $("tr.ismjs-menu.ism-row-select").each(function()
			{
				var gameClubPlayerId = $(this).attr('id');
				var selectedClub = selected.attr("value");
				var playerClubId = "";
				if(typeof playerListJson != 'undefined')
				{
					for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
					{
					  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
						{
						  playerClubId =   playerListJson[playerListIndex].clubId;
						}
						  
					}
				}
				if(selectedClub.split('_')[1] !=playerClubId)
				{
					 $(this).hide();
				}
				
			});
		}
	  $("p.ism-elements-shown strong.ism-elements-shown__num").text(($("tr.ismjs-menu.ism-row-select:visible").length+1));
 }
     function addPlayer(userId, gameClubPlayerId)
     {   $(".added-player-count").text(""+(userGameJson.playerList.length+1)+"/11");
     	<c:choose>
     	<c:when test="${isUnderDeadline}">
     		alert("Hey buddy ! You are under deadline. Player can be added after deadline");
     	</c:when>
     	<c:otherwise>
    	 var playerType = '';
    	 var playerName = '';
    	 var playerPrice = '';
    	 var clubId = '';
			if(typeof playerListJson != 'undefined')
			{
				for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
				{
				  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
					{
					  playerType =   playerListJson[playerListIndex].type;
					  playerName = playerListJson[playerListIndex].name;
					  playerPrice = playerListJson[playerListIndex].price;
					  clubId = playerListJson[playerListIndex].clubId;
					}
					  
				}
			}
		console.info("Player Type "+playerType);
		var ajaxCall = true;
		var avialBalance = userJson.balanceCoins;
		if(playerType == '')
		{
			alert("undefied");
			ajaxCall = false;
		}
		/* else if(avialBalance < playerPrice)
		{
			alert("Bank Account is less than player price");
			ajaxCall = false;
		} */
		/* else if(!(userJson.hasActivePlan || userJson.totalTransferForGameWeek <=1 || userJson.gameWeekNumberForPlayerTransfer <=1 || userJson.totalPoint > 4))
		{
			ajaxCall = false;
			if(userJson.totalPoint < 4)
			{
				alert("Please active wild card to add player");
			}
		} */
		else if (playerType == 'Goalkeeper')
		{
			
			if(typeof userGameJson != null && typeof userGameJson!= 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJson['total']['Goalkeeper'] >=1)
				{
					ajaxCall = false;
					alert("You can add maximum 1 Goalkeeper. Please Remove any one first ");
				}
			}
		}
		else if (playerType == 'Midfielder')
		{
			
			if(typeof userGameJson != null && typeof userGameJson != 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJson['total']['Midfielder'] >=4)
				{
					ajaxCall = false;
					alert("You can add maximum 4 Midfielder. Please Remove any one first ");
				}
			}
		}
		else if (playerType == 'Forward')
		{
			if(typeof userGameJson != null && typeof userGameJson != 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJson['total']['Forward'] >=2)
				{
					ajaxCall = false;
					alert("You can add maximum 2 All Rounders. Please Remove any one first ");
				}
			}
		}
		else if (playerType == 'Defender')
		{
			if(typeof userGameJson != null && typeof userGameJson != 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJson['total']['Defender'] >=4)
				{
					ajaxCall = false;
					alert("You can add maximum 4 Defender. Please Remove any one first ");
				}
			}
		}
		console.info("--- Ajax Call: "+ajaxCall);
		if(ajaxCall)
		{
			var url = "/SportMgmt/mvc/game11/AddPlayer11?userId="+userId+"&gameClubPlayerId="+gameClubPlayerId;
	     	$.ajax({
	     		  url: url,
	     		  dataType: 'json',
	     		  success: function( resp ) {
	     			  if(resp.isSuccess)
	     			  {
	     				 userGameJson = resp.userGameJson; 
	     				 userJson = resp.userJson;
	     				$("p.added-player-count").text(""+userGameJson.playerList.length+"/11");	     				
	     				 var clubImage = clubIdImageMap[clubId];
	     				 if(typeof $('#planBalanceDiv') != 'undefined')
	     			 	 {
	     					$('#planBalanceDiv').text(userJson.balanceCoins); 
	     				 }
	     				 if(typeof $('#freeTransUsedDiv') != 'undefined')
	     			 	 {
	     					if(userJson.totalTransferForGameWeek > 1)
	     					 $('#freeTransUsedDiv').text('used'); 
	     				 }
	     				 if(playerType == 'Goalkeeper')
	     				 {
	     					$("#Goalkeepers .addPlayer>a").closest('tr').attr('disabled', 'disabled');

	     					var elems = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			        
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Goalkeeper'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			        
	     			       
	     			        $('.ism-element-row.ism-element-row--pitch:first-child').find('.ismjs-select').first().replaceWith( elems ); 
	     				 }
	     				 if(playerType == 'Midfielder')
     					 {
	     					$('#Midfielders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
	     					
	     					var midfielder = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			        
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Midfielder_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			       
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			        
	     			        $('.ism-element-row.ism-element-row--pitch:nth-child(3)').find('.ismjs-select').first().replaceWith( midfielder );
     					 }
	     				 if(playerType == 'Defender')
     					 {
	     					$('#Defenders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
	     					
	     					var defender = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			        
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Defender_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			        
	     			        $('.ism-element-row.ism-element-row--pitch:nth-child(2)').find('.ismjs-select').first().replaceWith( defender );
	     			       
     					 }
	     				 if(playerType == 'Forward')
     					 {
	     					$('#Forwards .addPlayer>a').closest('tr').attr('disabled', 'disabled');
	     					
	     					var forward = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			       
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Forward_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			       
	     			       	        
	     			        $('.ism-element-row.ism-element-row--pitch:nth-child(4)').find('.ismjs-select').first().replaceWith( forward );
     					 }
	     			  }
	     			  else
	    			  {
	    				  	alert(resp.errorMessage);
	    			  }
	     		  },
	     		  error: function( req, status, err ) {
	     		    console.log( 'something went wrong', status, err );
	     		  }
	     		});

		}
		
		</c:otherwise>
		</c:choose>
     }
     function removePlayer(userId, gameClubPlayerId,elems1,elems2)
     {
    	$(".added-player-count").text(""+(userGameJson.playerList.length-1)+"/11");
		var isPlayerPlaying = false;
		for(var i=0;i<userGameJson.playerList.length ;i++)
		{
			if(userGameJson.playerList[i].gameClubPlayerId == gameClubPlayerId)
			{
				isPlayerPlaying = true;
				break;
			}
		}
    	if(isPlayerPlaying)
   		{
    		var url = "/SportMgmt/mvc/game11/RemovePlayer11?userId="+userId+"&gameClubPlayerId="+gameClubPlayerId;
	     	$.ajax({
	     		  url: url,
	     		  dataType: 'json',
	     		  async: false,
	     		  success: function( resp ) {
	     			  if(resp.isSuccess)
	     			  {
	     				 userGameJson = resp.userGameJson;
	     				 userJson = resp.userJson;
	     				$("p.added-player-count").text(""+userGameJson.playerList.length+"/11");
	     				if(typeof $('#planBalanceDiv') != 'undefined')
	     			 	 {
	     					$('#planBalanceDiv').text(userJson.balanceCoins); 
	     				 }
	     				$(elems1).parents('.ism-element').find('.ismjs-menu').replaceWith( elems2 );
	     			  }
	     			  else
	    			  {
	    				  	alert(resp.errorMessage);
	    			  }
	     		  },
	     		  error: function( req, status, err ) {
	     		    console.log( 'something went wrong', status, err );
	     		  }
	     		});
   		}
     }
     function openNav() {
    	 alert("hi");
    	    document.getElementById("myNav").style.height = "100%";
    	}

    	function closeNav() {
    	    document.getElementById("myNav").style.height = "0%";
    	}
     

  </script>



