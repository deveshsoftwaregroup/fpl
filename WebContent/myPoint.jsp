<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="context" value="<%=request.getContextPath()%>" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %> 
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	
<s:sportExt retrieve="deadLine" />
<body class="predict11-bg transfers_predict11 dream_11transfer">
   
      <div class="container-fluid ">
    
      <div class="row">
      <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 transfers_predict11_map"> 
         <div class=" align_div_center">

							<div class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2 league-pager">
								<div class="pager pager-left">
									<c:choose>
									<c:when test="${sportMgmtRes.result.gameWeek.gameWeekNumber eq '1'}">
									<a href="javascript:void(0);" title="View previous" class="btnPrevious">
										<span>Previous</span>
									</a>
									</c:when>
									<c:otherwise>
									<a href="javascript:void(0);" onclick="uploadMyPointView('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','${sportMgmtRes.result.gameWeek.gameWeekId}','prev');" title="View previous" class="btnPrevious">
										<span>Previous</span>
									</a>
									</c:otherwise>
									</c:choose>
								</div>
								<h3 class="subHeader pager-heading pager-heading1">Gameweek ${requestScope.sportMgmtRes.result.gameWeek.gameWeekNumber}</h3>
								
								<div class="pager pager-right">
									<c:choose>
									<c:when test="${sportMgmtRes.result.gameWeek.isLatestGameWeek eq 'Y'}">
									<a href="javascript:void(0);"  title="View next" class="pager-btn btn-next btnNext">
									<span>Next</span>
										
									</a>
									</c:when>
									<c:otherwise>
									<a href="javascript:void(0)" onclick="uploadMyPointView('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','${sportMgmtRes.result.gameWeek.gameWeekId}','next');" title="View next" class="pager-btn btn-next btnNext">
									<span>Next</span>
										
									</a>
									</c:otherwise>
									</c:choose>
								</div>
							</div>
						
						<%-- <div class="points-area">
							<div class="final-points">
								Final Points
								<span>${sportMgmtRes.result.gameWeek.finalPoint}</span>
							</div>
							<div class="points-container">
								<div class="point-row">
									<div class="pt-col pt-txt">Average Pts</div>
									<div class="pt-col pt-no">${sportMgmtRes.result.gameWeek.averagePoint}</div>
								</div>
								<div class="point-row">
									<div class="pt-col pt-txt">Highest Pts</div>
									<div class="pt-col pt-no highest">${sportMgmtRes.result.gameWeek.heighestPoint}</div>
								</div>
								<div class="point-row">
									<div class="pt-col pt-txt">GW Rank</div>
									<div class="pt-col pt-no">${sportMgmtRes.result.gameWeek.rank}</div>
								</div>
								<div class="point-row">
									<div class="pt-col pt-txt">Transfers</div>
									<div class="pt-col pt-no">${sportMgmtRes.result.gameWeek.transfer} (-4pts)</div>
								</div>
							</div>
						</div>
						

						<section>
							<div id="leaguer-errors" class="league-alert-wrap">
								<div></div>
							</div>
							<div id="leaguer-info" class="league-alert-wrap">
								<div>
									<div id="leaguejs-squad-info" tabindex="0"></div>
								</div>
							</div>
							
							<div class="league-squad-wrapper">
								<div class="leaguejs-a11y-tabs league-tabs">
									<section id="leaguer-summary" class="league-pitch" role="tabpanel">
										<div tabindex="0"> --%>
										
              	
              	<c:choose>
              		
	              	<c:when test="${empty sportMgmtRes.result}">
	              		<div class="col-lg-8">
	              		<h4>No team was confirmed for this Game Week</h4>
	              		</div>
	              	</c:when>
	              	
	                <c:otherwise>
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
																	  <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="#" data-toggle="modal" data-target="#myModal-1" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div>  
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	< <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	<div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	<div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
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
																	 <div class="leaguejs-info league-element__control league-element__control--info">
																		<a href="javascript:void(0);" title="View player information" class="fa fa-info" onclick="showPlayerDetails('${gameClubPlayerId}');"></a>
																	</div> 
																</div>
															</div>

														</div>
												</div>
												

												</div>									
												 
											</div>
						</c:otherwise>
					</c:choose>

										</div>
							   
						
								
					

                <!-- Secondary content -->
                <div id="ismr-side" class="col-lg-4 secondary_header_text">
					<div>
							<h2 class="subHeader1 ism-sub-header">${sessionScope.user.displayName}</h2>

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
								</div> 


								<!-- POINTS / RANKINGS -->
								<div class="">
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
									</div>
									</div>
									

								<!-- LEAGUES -->
							<%-- <div class="ism-panel">
									<div class="ism-panel__body">
										<div id="ismr-fan-league"><div>

										<div class="ism-panel ism-panel--dark ism-panel--guttered">
											<h3 class="ism-panel__heading">Fan League</h3>
											<div class="ism-panel__body ism-panel--dark__body">
												<div class="ism-panel__centre league-panel__badge">
													<a href="#" class="ism-panel__badge__link">
														 <img src="${context}/images/logo.png" title="Arsenal" alt="Arsenal" class="ism-panel__badge__img">													 </a>												</div>
											</div>
											</div>

									</div>
								</div>
								</div>
								</div> --%>
							
							
							
							</div>
							</div>
						
				<%-- <div class="league-panel__footer league-panel__footer--guttered">
					<a href="#" class="leaguejs-link btn btn-secondary league-button league-button--full">Create and join leagues<span class="fa fa-caret-right"></span></a>
				</div>
				<div class="league-panel league-panel--dark">
                    <h3 class="league-panel__heading league-panel__heading--guttered">Cup</h3>
                    
                        <div class="league-panel__body league-panel--dark__body">
                            <p>The cup will start in Gameweek 18.</p>
                        </div>
                    
                    <div class="league-panel__footer league-panel__footer--guttered">
                        <a href="#" class="leaguejs-link league-link league-link--more">View cup history<span class="fa fa-angle-double-right"></span></a>
                    </div>
                </div> --%>
							</div>
						
						<div id="ismr-elements-menu"></div>
					
						
						</div>
					
	

 </body>
  <c:if test="${empty sportMgmtRes.result}">
  <script type="text/javascript">
   //alert("Hey ! This page can be viewed after your 1st game week ends. Now you will be redirected to My Team page ");
 // uploadTeamView('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');
  </script>
  </c:if>
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
	
</script> 


