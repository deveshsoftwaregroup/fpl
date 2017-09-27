<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="context" value="/SportMgmt" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	
   <body class="predict11-bg transfers_predict11  ">
      <div class="container ">
    
      <div class="row">
         <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 transfers_predict11_map">
            <div>
               <h3>My Team</h3>
              
               <div class="row">
                  <div class="col-lg-8 team_map_dream11">
                     <div class="row ">
                         <div class="col-lg-12 goalkeeperr">
                         <s:sport position="1" playerType="Goalkeeper" pageName="DE_MY_POINT"/>
                        <ul class="itemsContainer ">
                           <li >
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/goalkeeper.png" class=" img-responsive gaolkeeper_hvr <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a>
                              <h4>${playerName}</h4>
                           </li>
                        </ul>
                             </div>
                     </div>
                     <div class="row ">
                          <div class="col-lg-12 defenderr">
                        <ul >
                           <li>
                           	  <s:sport position="1" playerType="Defender" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" > </a>
                              <h4>${playerName}</h4>
                           </li>
                           <li>
                           <s:sport position="2" playerType="Defender" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a>
                              <h4>${playerName}</h4>
                           </li>
                           <li>
                           <s:sport position="3" playerType="Defender" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a>
                              <h4>${playerName}</h4>
                           </li>
                           <li>
                           <s:sport position="4" playerType="Defender" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a> 
                              <h4>${playerName}</h4>
                           </li>
                        </ul>
                              </div>
                     </div>
                     <div class="row ">
                          <div class="col-lg-12 midfielderr">
                        <ul >
                           <li>
                           <s:sport position="1" playerType="Midfielder" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a>
                              <h4>${playerName}</h4>
                           </li>
                           <li>
                           <s:sport position="2" playerType="Midfielder" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a>
                              <h4>${playerName}</h4>
                           </li>
                           <li>
                           <s:sport position="3" playerType="Midfielder" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a>
                              <h4>${playerName}</h4>
                           </li>
                        </ul>
                              </div>
                     </div>
                     <div class="row ">
                          <div class="col-lg-12 attackerr">
                        <ul >
                            
                           <li>
                           <s:sport position="1" playerType="Forward" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a> 
                              <h4>${playerName}</h4>
                           </li>
                           <li>
                           <s:sport position="2" playerType="Forward" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>"  ></a>
                              <h4>${playerName}</h4>
                           </li>
                           <li>
                           <s:sport position="3" playerType="Forward" pageName="DE_MY_POINT"/>
                              <a href="#"> <img src="${context}/redBlackTheme/images/Dream11/player_1.png" class="center-block img-responsive <c:if test='${isPlyaerInTopElevent}'>active</c:if>" ></a>
                              <h4>${playerName}</h4>
                           </li>
                        </ul>
                              </div>
                      </div>
                      <div class="row">
                        <div class="col-lg-4 pull-right claim_your_prize">
                            <h4>Your points : ${sportMgmtRes.result.userPoint}</h4>
                          
                           <a href="#"><button type="button" class="btn claim_btn" onclick="uploadCouponsView11('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');">Claim Your Prize</button></a>
                          </div>    
                      </div>
                       <div class="row pddn_both">
                           <div class="col-lg-12 banner_align">  <img src="images/simple-bannr.png" class="img-responsive center-block"></div></div>
                         
                  </div>
                  <div class="col-lg-4 col-lg-offset-0 col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2   Dream_11_players ">
                        <div class="row"> 
                            <div class="Dream_11_list"> <h4>Dream 11</h4></div>
  <table width="100%">
  <tbody>
    <tr class="head_table">
      <td>S No.</td>

      <td>Player  </td>

      <td>Price</td>

      <td>Point</td>
    </tr>
    <c:forEach var="player" items="${sportMgmtRes.result.topElevenPlayer}" varStatus="loop">
    <tr id="1a">
      <td>${loop.index+1}</td>

      <td>
          
          <div class="player_name_list"><img src="${context}/redBlackTheme/images/top_11_tshirt.png"> <p>${player.name}<br><b>MCI</b></p></div></td>

      <td>$${player.price} </td>

      <td>${player.point} </td>
        
    </tr>
	</c:forEach>
 </tbody>
</table>
                            
                      </div>    
                  </div>
                        </div>
                         
                      </div>
                  </div>
               </div>
            </div>
         </div>
           
      </div>
        
          
      <script src="js/jquery.bxslider.js"></script>     
           
          
          <script src="js/jPushMenu.js" ></script>
      <script type="text/javascript">
         //<![CDATA[
         $(document).ready(function(){
           $('.toggle-menu').jPushMenu({closeOnClickLink: false});
          
         });
         //]]>
      </script>
          
          <script>
            $(document).on('shown.bs.tab', 'a[data-toggle="tab"]', function (e) {
    var tab = $(e.target);
    var contentId = tab.attr("href");

    //This check if the tab is active
    if (tab.parent().hasClass('active')) {
         console.log('the tab with the content id ' + contentId + ' is visible');
    } else {
         console.log('the tab with the content id ' + contentId + ' is NOT visible');
    }

});
          </script>
    
   
   </body>
</html>

