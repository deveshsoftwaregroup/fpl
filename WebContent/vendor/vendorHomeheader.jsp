<%-- <jsp:include page="${context}/dreamEleven/facebookPost.jsp" /> --%>
<jsp:include page="VendorHeader.jsp" />
<jsp:include page="popup.jsp" />
<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:set var="context" value="<%=request.getContextPath()%>" />
  <div class="container">
  
  <div class="row">
  		  
  
          <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 top_banner">
           <%-- <h4 style="color:#4dff4d;">${param.message}</h4> --%>
           
            <ul class="bxslider">
            	<li><a  href="#"><img src="${context}/redBlackTheme/images/website_banner.png" onclick="showRegistrationPopup()"/></a></li>
                <%-- <li><a target="_blank" href="#"><img src="${context}/redBlackTheme/images/banner1.png" /></a></li>
                <li><a target="_blank" href="#"><img src="${context}/redBlackTheme/images/banner1.png" /></a></li> --%>
                  
                </ul>
            </div>
          </div>
          <div class="row">
          <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
            <div class="row">
                <div class="col-lg-8 col-sm-8 col-tn-12 col-xs-12 scout_slide">
                   <ul class="bxslider_1">
						<li class="home_scout_section">
							<div class="row ">
						    	<div class="col-lg-7 col-sm-6 col-tn-6 col-xs-12">
						      		<img src="${context}/redBlackTheme/images/homeIndex/Webp.net-resizeimage-34.jpg" >
						    	</div>
						    	<div class="col-lg-5 col-sm-6 col-tn-6 col-xs-12">
						    	    <c:forEach items="${articleList}" var="item">
						      		<h4><c:out value="${item.heading}"/> </h4>
						        	<p><c:out value="${item.content}"/> </p>
						        	<p><a target="_blank" href="http://the12thman.in/defender-contender-rio-ferdinand-marks-return/"><b> READ MORE </b></a>- <i><c:out value="${item.link}"/></i></p>
						        	</c:forEach>
						    	</div>
						    </div>
						</li>
						<c:forEach items="${articleList}" var="item">
                                  <c:out value="${item.content}"/>
                               </c:forEach>
						
						<li class="home_scout_section"> 
							<div class="row">
								<div class="col-lg-7 col-sm-6 col-tn-6 col-xs-12">
									<img src="${context}/redBlackTheme/images/homeIndex/PicsArt_09-19-05.40.20-min.jpg" >
								</div>
								<div class="col-lg-5 col-sm-6 col-tn-6 col-xs-12">
								  <h4>Hazard opens up on Ligue 1 return </h4>
								    <p>Chelsea star Eden Hazard has been told to join Neymar at Paris Saint-Germain by close friend Thomas Meunier.PSG broke the bank this summer to sign Neymar from Barcelona in a world-record. </p>
								    <p><a target="_blank" href="http://the12thman.in/hazard-opens-ligue-1-return/"><b> READ MORE </b></a>- <i>the12thman.in</i></p>
								</div>
							</div>
						</li>
						<li class="home_scout_section">
							<div class="row ">
						    	<div class="col-lg-7 col-sm-6 col-tn-6 col-xs-12">
						      		<img src="${context}/redBlackTheme/images/homeIndex/jose-mourinho-chelsea-manchest.jpg" >
						    	</div>
						    		<div class="col-lg-5 col-sm-6 col-tn-6 col-xs-12">
	                            	<h4>MAanchester united Jos star opens contract talk with Manchester United </h4>
                                      <p>Manchester united have Opened Contract Negotiation with CURRENT Manchester united player of the year ander herea WHO IS READY TO FIGHT FOR HIS PLACE AT THE CLUB. </p>
	                                  <p><a target="_blank" href="http://the12thman.in/joses-star-opens-contract-talk-manchester-united/"><b> READ MORE </b></a>- <i>the12thman.in</i></p>   
	                          	</div>
						    </div>
						</li>
                       

                </ul>
                    <ul class="scout_list ">
                        <li>
                            <h4>pep Guardiola praises Manchester City players but insists that the title is far away </h4>
                              <p>MANCHESTER CITY BOSS PEP GUARDIOLA HAS INSISTED THAT HIS TEAM CANNOT CALL THEMSELVES AS GOOD AS CHELSEA AFTER LAST SEASON PERFORMANCE. </p>
                              <p><a target="_blank" href="http://the12thman.in/pep-guardiola-praises-manchester-city-players-insists-title-far-away/"><b>READ MORE</b></a>- <i>the12thman.in</i></p>
                        </li>
                        <hr>
                        <li>
                            <h4>Golden Boy 2017 Nominees: 7 players from Premier League Nominated </h4>
                              <p>Last season of football was surely the season of highly rated young talents all across the globe. Be it Kylian Mbapp rise from Monaco or Dembels performance for Dortmund which lead to the talented youngster sealing the dream move to FC Barcelona. </p>
                              <p><a target="_blank" href="http://the12thman.in/golden-boy-2017-nominees-7-players-premier-league-nominated/"><b>READ MORE</b></a>- <i>the12thman.in</i></p>
                        </li>
                        <hr>
                        <li>
                            <h4>Premier League Matchweek 5: Team of the Week </h4>
                              <p>ARSENAL AND MANCHESTER CITY LEAD THE WAY IN THE PREMIER LEAGUE TEAM OF THE WEEK AFTER MATCHWEEK 5 OF THE 2017/18 PREMIER LEAGUE SEASON. </p>
                                                            <p><a target="_blank" href="http://the12thman.in/english-premier-league-matchweek-5-team-week/"><b>READ MORE</b></a>- <i>the12thman.in</i></p>
                        </li>
                        <hr>
                        <li>
                            <h4>Aguero form a major boost for Manchester City </h4>
                              <p>SERGIO AGUERO DISPLAYED AN ABSOLUTE MASTERCLASS PERFORMANCE AGAINST WATFORD ON SATURDAY SCORING A BRILLIANT HAT-TRICK IN CITY 6-0 RIOT AT VICARAGE ROAD. </p>
                              <p><a target="_blank" href="http://the12thman.in/agueros-form-major-boost-manchester-city/"><b>READ MORE</b></a>- <i>the12thman.in</i></p>
                        </li>
                      
                    </ul>
 
                </div>
                <div class="col-lg-4 col-sm-4 col-tn-12 col-xs-12 all_play">
                <c:choose>
                    <c:when test="${empty sessionScope.user.displayName}">
                      <a href="" data-toggle="modal" data-target="#myModal"><img src="${context}/redBlackTheme/images/play-fantasy-league_1.png" class="img-responsive center-block"></a>  
                     <%-- <a href="" data-toggle="modal" data-target="#modalMessage"><img src="${context}/redBlackTheme/images/play-fantasy-league_1.png" class="img-responsive center-block"></a> --%> 
                   </c:when>
                   <c:otherwise>
                    <a href="${context}/mvc/user/UserLanding"><img src="${context}/redBlackTheme/images/play-fantasy-league_1.png" class="img-responsive center-block"></a> 
                   <%--  <a href="" data-toggle="modal" data-target="#modalMessage"><img src="${context}/redBlackTheme/images/play-fantasy-league_1.png" class="img-responsive center-block"></a>  --%>
                    
                    <%-- <a href="" data-toggle="modal" data-target="#myModal"><img src="${context}/redBlackTheme/images/play-fantasy-league_1.png" class="img-responsive center-block"></a>  --%>
                   </c:otherwise>
                </c:choose>
                   
                 <br>
                  <a href="#"><img src="${context}/redBlackTheme/images/google-adbanner.png" class="img-responsive center-block"></a>
                  <p class="sponsored_ad">sponsored</p>
                 <br>
                 
                <c:choose>
	                <c:when test="${empty sessionScope.user.displayName}">
	                	<a href="" data-toggle="modal" data-target="#myModal11"><img src="${context}/redBlackTheme/images/predict_11_section.png" class="img-responsive center-block"></a>
	             	</c:when>
		            <c:otherwise>
		              	<a href="${context}/mvc/user11/UserLanding11"><img src="${context}/redBlackTheme/images/predict_11_section.png" class="img-responsive center-block"></a>
		             </c:otherwise>
                </c:choose>
                
                </div>
                
              </div>
            </div>
          </div>
        
        <div class="row">
          <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
            <div class="row">
                <div class="col-lg-8 col-sm-8 scout-news">
                                        </div>
                <div class="col-lg-4 col-sm-4">
                  
                   
                    
                </div>
              </div>
            </div>
          </div>
          
          <!--  Wildcard Section  -->
        <!--  Copy This Section -->
        <div class="row">
                <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
                    <a href="#"><div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 unlimited_things unlimited_things_1">
                        <img src="${context}/redBlackTheme/images/wildcard/wildcard.png" class="img-responsive center-block">
                        <h4>Wildcards</h4>
                        <p>Play and Get Unlimited Wildcards</p>
                    </div></a>
                    <a href="#"><div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 unlimited_things unlimited_things_2 ">
                            <img src="${context}/redBlackTheme/images/wildcard/giftcard.png" class="img-responsive center-block">
                            <h4>Gifts</h4>
                            <p>Gift Card for Each and Every User</p>
                    </div></a>
                    <a href="#"><div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 unlimited_things">
                            <img src="${context}/redBlackTheme/images/wildcard/win.png" class="img-responsive center-block">
                            <h4>Win</h4>
                            <p>Predict Dream 11 and Win</p>
                    </div></a>
                </div>
        </div>

        <!--  / Wildcard Section -->
       
     
    
 <jsp:include page="vendorFooter.jsp" /> 

 </div> 
<script language='javascript' type='text/javascript'>


function showRegistrationPopup()
{
	$("#myModal1").modal('show');
	$(".close").click(function(){			              
		$("#myModal1").fadeOut("slow");
	});
}

function showMyPopup()
{
	$("#modelPromotion").modal('show');
	$(".close").click(function(){			              
		$("#modelPromotion").fadeOut("slow");
	});
}
function showSuccessRegistrationPopup()
{
	$("#thankyou_Modal").modal('show');
	$(".close").click(function(){			              
		$("#thankyou_Modal").fadeOut("slow");
	});
}
function showNonSuccessRegistrationPopup()
{
	$("#NonSuccessRegistrationPopup_Modal").modal('show');
	$(".close").click(function(){			              
		$("#NonSuccessRegistrationPopup_Modal").fadeOut("slow");
	});
}
</script>
<script>
        jQuery(document).ready(function($){
        	 //alert("tt");
        	//alert('${displayPromotionPopup}');
        	//clearListCookies();
        	/* if('${displayPromotionPopup}'=="true")
        		{
	        		showMyPopup();
	                $('.demo1').dsCountDown({
	                   endDate: new Date("December 17, 2017 23:59:00")
	                });  
        		} */
        	//string. !== -1;
        	if('${param.message}'.indexOf("Congrats")!=-1)
    			{
        		//alert("some");
        		//alert('${param.message}');
        		showSuccessRegistrationPopup();                
    			}
        	if('${param.message}'.indexOf("failed")!=-1)
        		{
        		showNonSuccessRegistrationPopup();
        		}
            
        });
    </script>
 
<!--  <script>
         $("#notification").fadeIn("slow").append('your Notification');
         $(".dismiss").click(function(){
                $("#notification").fadeOut("slow");
         });
         
                 
      </script> -->
<!-- <script>
	$(document).on('shown.bs.tab', 'a[data-toggle="tab"]', function (e) 
	{
	    var tab = $(e.target);
	    var contentId = tab.attr("href");
	
	    //This check if the tab is active
	    if (tab.parent().hasClass('active'))
	    {
	         console.log('the tab with the content id ' + contentId + ' is visible');
	    } 
	    else
	    {
	         console.log('the tab with the content id ' + contentId + ' is NOT visible');
	    }
	});
</script> -->
<script type="text/javascript">


/* function clearListCookies()
{   //alert("hi");
    var cookies = document.cookie.split(";");
    for (var i = 0; i < cookies.length; i++)
    {   
        var spcook =  cookies[i].split("=");
        deleteCookie(spcook[0]);
    }
    function deleteCookie(cookiename)
    {
        var d = new Date();
        d.setDate(d.getDate() - 1);
        var expires = ";expires="+d;
        var name=cookiename;
        //alert(name);
        var value="";
        document.cookie = name + "=" + value + expires + "; path=/acc/html";                    
    }
    //window.location = ""; // TO REFRESH THE PAGE
    window.reload(true);
} */
</script>
 
</body>
</html>
