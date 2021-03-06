<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<head>		    
	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <c:set var="context" value="<%=request.getContextPath()%>" />
	    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 		 	
	</head> 
  <!-- code for preloader starts -->
	  <%-- <div id="preloader">
		<div id="status">&nbsp;</div>
	</div>
	<script type="text/javascript">
		$(window).on("load", function() { // makes sure the whole site is loaded
			$('#status').fadeOut(1000); // will first fade out the loading animation
			$('#preloader').delay(500).fadeOut(2000); // will fade out the white DIV that covers the website.
		}) 
	</script>--%>
	<!-- Code for preloader ends --> 
	<s:sportExt retrieve="priceList" />
	<div class="container"> 
	    <div class="row">
	    	<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 top-bnr-mobile">
  		  		<img src="${context}/redBlackTheme/images/simple-bannr.png" class="img-responsive">
  		  	</div>
	        <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
	            <div class="row dream11-top_header">
	                <div class="col-lg-12">
	                  <ul>
	                     <div  class="tect_left">
		                    <li class=" flex-item" style="float: left;"><b><i> ${sessionScope.user.displayName}                  
		                		</i></b> &nbsp;  &nbsp; <a></a>
		                	</li>
	                	</div>	                    
	                  </ul>
	                </div>  
	             </div>
	        </div>
	    </div>
    
    				
	    <header>
			<div class="row">
				<div class="col-lg-1 col-sm-1">
					<div class="left_img">
						<%-- <img src="${context}/redBlackTheme/images/left_image.png"> --%>
						<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- justthinksports_homepage_left_sidebar -->
						<ins class="adsbygoogle"
    					 style="display:inline-block;width:120px;height:600px"
    					 data-ad-client="ca-pub-9891586352099803"
     					data-ad-slot="4098742947"></ins>
					<script>
						(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
					</div></div>    
				<div class="col-lg-10 col-md-10 col-sm-10  ">
					<nav class="navbar ">
						<div class="container-fluid">
					    	<div class="navbar-header">
					        	<button type="button" class="navbar-toggle toggle-menu menu-left jPushMenuBtn menu-active" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						        	<span class="icon-bar"></span>
						        	<span class="icon-bar"></span>
						        	<span class="icon-bar"></span>                        
					        	</button>
					         	<a class="navbar-brand" ><img src="${context}/redBlackTheme/images/logo.png" class="img-responsive" href="javascript:void(0);" onclick="openHomeHome();"></a>   
					       	</div>
					       	<div class="collapse navbar-collapse cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="bs-example-navbar-collapse-1">
						        <ul class="nav navbar-nav">
						        	<!--  Close Btn -->
                 <button type="button" class="navbar-toggle manu_close_btn toggle-menu menu-left jPushMenuBtn menu-active" data-toggle="collapse">X</button>
                   <!-- / Close Btn -->
									<li>                            
						                      <a href="javascript:void(0);" onclick="openHomeHome();">League Home</a>
						                  </li> 
						               <li>
						               	<a href="javascript:void(0);" onclick="uploadTransferView11();">Transfers</a>
						               </li> 
						                <li>
						               <a href="javascript:void(0);" onclick="uploadTeamView11('${sessionScope.userId}','${sessionScope.gameDetails.gameId}',${gameWeekId});" data-nav-tab="squad">My Team</a>		
						               </li> 
						                                     
						               <li>
						                   <a href="javascript:void(0);" onclick="uploadMyPointView11('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','','');">My Points</a>
						               </li>   
						               <li>
						                   <a href="javascript:void(0);" onclick="uploadCouponsView11('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');">Coupons</a>
						               </li> 
						               <li>
						                   <a href="javascript:void(0);" onclick="uploadMatchView11('${sessionScope.gameDetails.gameId}');" data-nav-tab="squad">Fixtures</a>
						               </li> 
						               <li>
						                   <a href="javascript:void(0)" onclick="uploadRulesView11();">Help</a>
						               </li>
						               <!-- <li>
						                   <a href="javascript:void(0);" onclick="uploadFAQView11();">FAQ</a>
						               </li> -->                       
						               <li>
						                   <a href="/SportMgmt/mvc/user/Logout">Sign Out</a>
						               </li>
								</ul>
							</div>
					     </div>
					    
					</nav>  
				</div>  
				<div class="col-lg-1  col-sm-1">
					<div class="right_img">
					<%-- <img src="${context}/redBlackTheme/images/left_image.png"> --%>
					<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- justthinksports_homepage_right_sidebar -->
					<ins class="adsbygoogle"
					     style="display:inline-block;width:120px;height:600px"
					     data-ad-client="ca-pub-9891586352099803"
					     data-ad-slot="1178023996"></ins>
					<script>
					(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
					
					</div>
				</div>
			</div> 
		</header>         
   
	<script type="text/javascript">
		function openHomeHome()
		{
			window.location="/SportMgmt/mvc/LeagueLandingHome";			
		}
		function uploadMatchView11(gameId)
		{
			if(typeof gameId != 'undefined' && gameId != '')
			{
				url ="/SportMgmt/mvc/game11/MatchView11/"+gameId;
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			}
		}
		function uploadTransferView11()
		{
			url ="/SportMgmt/dreamEleven/transfer11.jsp";
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadTeamView11(userId,gameId,gameWeekID)
		{
			if(typeof userGameJson != 'undefined' && userGameJson.playerList.length >= 11)
			{
				if(typeof userId != 'undefined' && userId != '' && typeof gameId != 'undefined' && gameId != '')
				{
					url ="/SportMgmt/mvc/game/MyTeamView11/"+userId+"/"+gameId+"/"+gameWeekId;
					$.ajax({
			     		  url: url,
			     		  dataType: 'html',
			     		  success: function( resp ) {
			     			 $('.ism-container').html(resp);
			     		  },
			     		  error: function( req, status, err ) {
			     		    console.log( 'something went wrong', status, err );
			     		  }
			     		});	
				}
			}
			else
			{
				showNotification ("Please complete the team of 11 players");
			}
			
		}
		function uploadRankingView()
		{
			url ="/SportMgmt/ranking.jsp";
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadMyPointView11(gameId,userId,gameWeekId,direction)
		{
			if(typeof gameId != 'undefined' && gameId != '')
			{
				url ="/SportMgmt/mvc/game/dream-eleven-point/"+gameId+"/"+userId;
				if(gameWeekId !='' && direction!='')
				{
					url =url+"?gameWeekId="+gameWeekId+"&game-week-for="+direction;
				}
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			}
		}
		function uploadCouponsView11(userId, gameId)
		{
			if(typeof userId != 'undefined' && userId != '' && typeof gameId != 'undefined' && gameId != '')
			{
				url ="/SportMgmt/mvc/coupon/dream-elevent/list/"+userId+"/"+gameId;
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			}
		}
		function uploadFAQView11()
		{
			
				$.ajax({
		     		  url: "/SportMgmt/mvc/Home11/FAQView11",
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadRulesView11()
		{
			
				$.ajax({
		     		  url: "/SportMgmt/mvc/Home11/RulesView11",
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		 
		function orderPlayerList(orderBy)
		{	
			$.ajax({
	   		  url: "/SportMgmt/mvc/player/orderBy/"+orderBy,
	   		  dataType: 'html',
	   		  success: function( resp ) {
	   			  
	   			if(typeof resp.playerList !='undefined')
	   			 playerListJson = resp.playerList;
	   			 uploadTransferView11();
	   		  },
	   		  error: function( req, status, err ) {
	   		    console.log( 'something went wrong', status, err );
	   		  }
	   		});	
		}
		
</script>
<script type="text/javascript">
	$(document).ready(function(){
		$('.toggle-menu').jPushMenu({closeOnClickLink: true, closeOnClickOutside: false});
    });
</script>
