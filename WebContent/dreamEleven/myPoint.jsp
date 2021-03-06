<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="context" value="<%=request.getContextPath()%>" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



   <body class="predict11-bg transfers_predict11 dream_11transfer">
   
      <div class="container-fluid ">
    
      <div class="row">
         <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 transfers_predict11_map">
            <img src="${context}/redBlackTheme/images/banner12.png" class="img-responsive center-block">
            <div>
            
            <div class="league-pager">
				<div class="pager pager-left">
						<c:choose>
							<c:when test="${sportMgmtRes.result.gameWeek.gameWeekNumber eq '19'}">
								<a href="javascript:void(0);" title="View previous" class=" btnPrevious">
									<span>  Previous</span>
								</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0);" onclick="uploadMyPointView11('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','${sportMgmtRes.result.gameWeek.gameWeekId}','prev');" title="View previous" class=" btnPrevious">
									<span> < Previous</span>
								</a>
							</c:otherwise>
						</c:choose>
					</div>
					<h3 class="subHeader pager-heading">Gameweek ${requestScope.sportMgmtRes.result.gameWeek.gameWeekNumber}</h3>
					<div class="pager pager-right">
						<c:choose>
							<c:when test="${sportMgmtRes.result.gameWeek.isLatestGameWeek eq 'Y'}">
								<a href="javascript:void(0);"  title="View next" class="pager-btn btn-next btnNext">
									<span>Next > </span>
								</a>
							</c:when>
							<c:otherwise>
								<a href="javascript:void(0)" onclick="uploadMyPointView11('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','${sportMgmtRes.result.gameWeek.gameWeekId}','next');" title="View next" class="pager-btn btn-next btnNext">
									<span>Next > </span>
								</a>
								</c:otherwise>
						</c:choose>
					</div>
				</div>
               <h3>Team Of The Week</h3>
              	
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
								       <img src="${context}/images/Goalkeeper_${imageSrc}" alt="'+playerName+'" title="" class="<c:if test='${isPlyaerInTopElevent}'>highlited_plr</c:if>" >
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
	                            <h4>Your points : ${sportMgmtRes.result.userPoint}</h4>
	                          
	                          <%--  <a href="#"><button type="button" class="btn claim_btn" onclick="uploadCouponsView11('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');">Claim Your Prize</button></a> --%>
	                          </div>    
	                      </div>
	                       <div class="row pddn_both">
	                           <div class="col-lg-12 banner_align">  <img src="images/simple-bannr.png" class="img-responsive center-block"></div></div>
	                         
	               		</div>
	               	</c:otherwise>
               	</c:choose>
               
               
                  <div class="col-lg-4 col-lg-offset-0 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2   Dream_11_players ">
                        <div class="row"> 
                            <div class="Dream_11_list"> <h4>Dream 11</h4></div>
  <table width="100%">
  <tbody>
    <tr class="head_table">
      <td>S No.</td>

      <td>Player  </td>

      <!-- <td>Price</td>

      <td>Point</td> -->
    </tr>
    
    <c:choose>
    	<c:when test="${empty sportMgmtRes.result.topElevenPlayer}">
    		<c:forEach begin="1" end="11" varStatus="loop">
    			<tr>
				    <td>${loop.index}</td>
				    <td> </td>
				    <!-- <td> </td>
				    <td> </td> -->
    			</tr>
			</c:forEach>    		
    	</c:when>
    
    	<c:otherwise>
		    <c:forEach var="player" items="${sportMgmtRes.result.topElevenPlayer}" varStatus="loop">
		    <tr id="1a">
		      <td>${loop.index+1}</td>
		
		      <td> 
					<c:if test="${not empty player.clubId and player.clubId ne ''}">
									<spring:message code="club_${player.clubId}_image" var="imageSrc" />
									</c:if>
		          
		       
		          <div class="player_name_list"><img src="${context}/images/${imageSrc}"> <p>${player.name}</p></div></td>
		          
		     <%--  <td>$${player.price} </td>		
		      <td>${player.point} </td> --%>
		        
		    </tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
 </tbody>
</table>
                            
                      </div>    
                  </div>
                       
                         
                      </div>
                  </div>
               </div>
            </div>
        
        
          
    
          
          <script>
            $(document).on('shown.bs.tab', 'a[data-toggle="tab"]', function (e) {
    var tab = $(e.target);
    var contentId = tab.attr("href");

    //This check if the tab is active
    /* if (tab.parent().hasClass('active')) {
         console.log('the tab with the content id ' + contentId + ' is visible');
    } else {
         console.log('the tab with the content id ' + contentId + ' is NOT visible');
    } */

});
          </script>
    
   
   </body>
</html>

