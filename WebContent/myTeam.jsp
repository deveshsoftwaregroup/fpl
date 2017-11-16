<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="<%=request.getContextPath()%>" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %> 
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<script src="${context}/redBlackTheme/js/jquery.js"></script>
<s:sportExt retrieve="deadLine" />
	  <body class="body predict11-bg transfers_predict11 dream_11transfer ">
      <div class="container-fluid ">
         <!-----------Header---------------->
         <div id="header"></div> 
            <div class="row">
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-sx-12 image_ad">
               <img src="images/dream11-img.png" class="img-responsive center-block">
               <div>
                  <h3>Select playing 11</h3>
                  <h3>My Team</h3>
                  <h3><p>Gameweek ${gameWeekNumber} Deadline : <time datetime="2016-08-27T10:30:00Z" class="league-deadline-bar__deadline">${deadline}</p></h3>
                  
                  <div class="row">
                  
			
            
                
               
					
						<%-- <div id="team-header">
							<div>
								<div class="ism-copy">
                                	<h3 style="color: #193782;"><i class="freeTransUsedDiv" style="color: #f00;"></i> Select playing 11</h3>
                        			
                        		 </div>
								<!-- <div class="league-copy">									
								</div> -->

								<!-- Deadline Bar -->
								
								<div class="league-deadline-bar">
									<h4 class="league-deadline-bar__heading">Gameweek ${gameWeekNumber} Deadline:</h4>
									<time datetime="2016-08-27T10:30:00Z" class="league-deadline-bar__deadline">${deadline}</time>
								</div>

							</div>
						</div> --%>

						
							
							<div class="league-squad-wrapper">
								<div class="leaguejs-a11y-tabs league-tabs">
									<section id="leaguer-summary" class="league-pitch" role="tabpanel">
										<div tabindex="0"> 
											<div class="col-lg-8 team_map_dream11">
												<div class="ism-element-row ism-element-row--pitch">
												<div id="ismr-pos1" class="ism-pitch__unit ism-pitch__unit--4">
													<div class="league-transfer--original">
													<s:sport position="1" playerType="Goalkeeper"/>
														<div class="ism-element" tabindex="0">
															
															<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>
																<picture>
																	<img src="${context}/images/Goalkeeper_${imageSrc}"  alt="Burnley" title="Burnleyyy" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="1-box" type="checkbox" name="boxes" value="check_1" title="Make Substitude" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);">
																	</div>
																	<%--  <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="#" data-toggle="modal" data-target="#myModal-1" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%> 
																	<div id="myModal-1" class="modal fade" role="dialog">
																	  <div class="modal-dialog">
																		<div class="modal-content">
																		  <div class="modal-header">
																			<button type="button" class="close" data-dleagueiss="modal">&times;</button>
																			<h4 class="modal-title">player information</h4>
																		  </div>
																		  <div class="modal-body">
																			<p>No information found.</p>
																		  </div>
																		</div>

																	  </div>
																	</div>
																</div>
															
														</div>
													</div>
												</div>
												<div id="ismr-pos2" class="ism-pitch__unit ism-pitch__unit--4">
													
													<s:sport position="2" playerType="Goalkeeper"/>
														<div class="ism-element" tabindex="0">
															<div class="ismjs-menu check_2">
															<c:set var="imageSrc" value="" />
															<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
																<picture>
																	<img src="${context}/images/Goalkeeper_${imageSrc}"  alt="West Brom" title="West Brom" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="2-box" type="checkbox" name="boxes" value="check_2" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);">
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
													
												</div>
																								
										</div>
												
												
												
											

											<div class="ism-element-row ism-element-row--pitch">
                                            <div id="ismr-pos3" class="ism-pitch__unit ism-pitch__unit--5">													
													<s:sport position="1" playerType="Defender"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_3">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}"  alt="West Brom" title="West Brom" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="3-box" type="checkbox" name="boxes" value="check_3" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);">
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
													
												</div>
												<div id="ismr-pos4" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="2" playerType="Defender"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_4">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="4-box" type="checkbox" name="boxes" value="check_4" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												<div id="ismr-pos5" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="3" playerType="Defender"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_5">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="5-box" type="checkbox" name="boxes" value="check_5" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												<div id="ismr-pos6" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="4" playerType="Defender"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_6">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="6-box" type="checkbox" name="boxes" value="check_6" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												<div id="ismr-pos7" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="5" playerType="Defender"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_7">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="7-box" type="checkbox" name="boxes" value="check_7" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												</div>
												
												<div class="ism-element-row ism-element-row--pitch">
												<div id="ismr-pos8" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="1" playerType="Midfielder"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_8">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="8-box" type="checkbox" name="boxes" value="check_8" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												<div id="ismr-pos9" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="2" playerType="Midfielder"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_9">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="9-box" type="checkbox" name="boxes" value="check_9" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												<div id="ismr-pos10" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="3" playerType="Midfielder"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_10">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="10-box" type="checkbox" name="boxes" value="check_10" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												<div id="ismr-pos11" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="4" playerType="Midfielder"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_11">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="11-box" type="checkbox" name="boxes" value="check_11" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>

												<div id="ismr-pos12" class="ism-pitch__unit ism-pitch__unit--5">
													<s:sport position="5" playerType="Midfielder"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_12">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="12-box" type="checkbox" name="boxes" value="check_12" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>

												</div>
											<div class="ism-element-row ism-element-row--pitch">
												<div id="ismr-pos13" class="ism-pitch__unit ism-pitch__unit--3">
													<s:sport position="1" playerType="Forward"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_13">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="13-box" type="checkbox" name="boxes" value="check_13" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>

												<div id="ismr-pos14" class="ism-pitch__unit ism-pitch__unit--3">
													<s:sport position="2" playerType="Forward"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_14">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																	<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="14-box" type="checkbox" name="boxes" value="check_14" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>

												<div id="ismr-pos15" class="ism-pitch__unit ism-pitch__unit--3">
													<s:sport position="3" playerType="Forward"/>
														<div class="ism-element" tabindex="0">
														<c:set var="imageSrc" value="" />
														<c:if test="${not empty clubId and clubId ne ''}">
																<spring:message code="club_${clubId}_image" var="imageSrc" />
															</c:if>		
															<div class="ismjs-menu check_15">
																<picture>
																	<img src="${context}/images/Defender_${imageSrc}" alt="West Ham" title="West Ham" class="ism-shirt ism-element__shirt">
																</picture>
																<div class="ism-element__name">${playerName}</div>
																<div class="ism-element__data">${price}</div>
																<div class="ism-element__controls">
																<div class="ismjs-remove ism-element__control ism-element__control--primary">
																		<input class="15-box" type="checkbox" name="boxes" value="check_15" <c:if test="${isPlaying eq 'Y'}">checked</c:if> onclick="activatePlayer('${sessionScope.userId}','${gameClubPlayerId}',this);"/>
																	</div>
																	<%-- <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> --%>
																</div>
															</div>

														</div>
												</div>
												

											</div>									
										<div class="col-lg-12 pull-right claim_your_prize claim_prize_align">
												<p id="countDown"></p>
                                             <!-- <a href="#"><button type="button" class="btn claim_btn" data-toggle="modal" data-target="#modelPlayOption">Confirm Your Team</button></a> -->
                                              <a href="#"><button id="confirmTeam" type="button" class="btn claim_btn confirm_team_btn" onclick="checkPlayerCountAndConfirmTeam()">Confirm Your Team</button></a>
                                          	<!-- <a href="#"><button type="button" class="btn claim_btn" data-toggle="modal" data-target="#paymentModel">Make Payment</button></a> -->
                                 </div> 
											</div>

											

										 </div>
									</section>
							   </div>
							</div>
						  
					

                <!-- Secondary content -->
                <%-- <div id="ismr-side" class="ism-sidebar">
					<div>
						<section>
							<h2 class="subHeader ism-sub-header">${sessionScope.user.displayName}</h2>

							<div class="ism-bordered ism-bordered--primary">

								<!-- ENTRY BAR -->
								<div class="ism-entry-bar">
									<div class="ism-media ism-media--centred ism-media--reversed">
										<div class="ism-media__figure">
											${sessionScope.user.country}
										</div>
										<div class="ism-media__body">
											<div class="ism-entry-bar__name"></div>
										</div>
									</div>
								</div> --%>


								<!-- POINTS / RANKINGS -->
								<div class="ism-panel ism-panel--guttered ism-panel--guttered-mobile">
									<h3 class="top_main">Points/Rankings</h3>
									<div class="ism-panel__body">

										<ul class="my_team_points check_points">
												<li>Overall Points : 
												<span class="text_right">
												${sessionScope.user.userGameMap.point}
												</span>
												</li>
												  <li>Overall Rank : 
												  <span class="text_right">
												  ${sessionScope.user.userGameMap.rank}
												  </span>
												  </li>
											      <li>Total Players : 
											      <span class="text_right">
											      ${fn:length(sessionScope.playerList)}
											      </span>
											       </li>
										</ul>
									</div>
									
								</div>

								 <!-- LEAGUES -->
								<div class="ism-panel ism-panel--guttered  ">
								<h3 class="subHeader ism-sub-header">Choose Captain/Vice-Captain</h3>
									<div class="ism-panel__body">
										<form action="#">
											<div class="form_row">
											     <input list="choose_cap" name="choose_captain" placeholder="Choose Captain" class="inp-control">
											  
											    <select id="captain-select">
											    </select>
										    </div>
										    
										    <div class="form_row">
											      <input list="choose_wisecap" name="choose_wisecaptain" placeholder="Choose Vice Captain" class="inp-control">
											   
											    <select id="vice-captain-select"></select>
										    </div>
										    <input type="button" class="btn claim_btn" value="Save" onclick="updateCaptain('${sessionScope.user.userId}');">
										</form>
									</div>
								</div>
							</div> 
						</div>
				
				
							</div>
						</section>
						<div id="ismr-elements-menu"></div>
					
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
	var playerLimits =  {"minCheckLegth":7,"min":{'Goalkeeper':1,"Defender":3,"Midfielder":3,"Forward":1},"max":{'Goalkeeper':1,"Defender":5,"Midfielder":5,"Forward":3},"total":11}
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
					alert("You can't select more than 11 Players");
					checkBox.checked = false;
					return;
				}
				console.log("total Player of your type:  "+totalPlayingJson[playerType]+" , maximum limit of your type: "+playerLimits["max"][playerType]);
				if(totalPlayingJson[playerType] >= playerLimits["max"][playerType])
				{
					alert(playerType+" Maximum limit is " +playerLimits['max'][playerType]);
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
						alert("Select minimum "+playerLimits["min"]["Goalkeeper"]+" Goalkeeper, "+playerLimits["min"]["Midfielder"]+" Midfielder, "+playerLimits["min"]["Defender"]+" Defender, "+playerLimits["min"]["Forward"]+" Forward");
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
		    				  	alert(resp.errorMessage);
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
		    				  	alert(resp.errorMessage);
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
	 		if(typeof userGameJson == 'undefined' || userGameJson.playerList.length < 15)
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
 	    				  	alert(resp.errorMessage);
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
 	    				  	alert(resp.errorMessage);
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


