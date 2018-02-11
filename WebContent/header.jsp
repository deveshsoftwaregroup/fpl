<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <meta http-equiv="x-ua-compatible" content="ie=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>The12thman | League</title>
	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	    <c:set var="context" value="<%=request.getContextPath()%>" />
	    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %> 	
	</head> 
	
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
	                    <%-- <div style="float:right;">
	                    	<li class="pwr_text flex-item" style="float: left;"></li>
	                        <li class="flex-item" style="float: left;"><img src="${context}/redBlackTheme/images/poweredby-logo.pngggg" class="img-responsive pwr_logo"></li>
	                    </div> --%>
	                  </ul>
	                </div>  
	          </div>
	        </div>
	    </div>
    
    				
	    <header>
			<div class="row">
				<div class="col-lg-1 col-sm-1"><div class="left_img">
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
				</div>
				</div>    
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
	                        	<a href="javascript:void(0);" onclick="uploadTransferView();">Transfers</a>
	                        </li> 
	                        <li>
	                        <a href="javascript:void(0);" onclick="uploadTeamView('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');">My Team</a>		
	                        </li> 
	                        <li>
	                            <a href="javascript:void(0);" onclick="uploadMatchView('${sessionScope.gameDetails.gameId}');">Fixtures</a>
	                        </li> 
	                        <li>
	                        	<a href="javascript:void(0);" onclick="uploadLeadershipView('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','');">Leadership</a>
	                        </li>                      
	                        <li>
	                            <a href="javascript:void(0);" onclick="uploadMyPointView('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','','');">My Points</a>
	                        </li>   
	                       <%--  <li class="ism-nav__list__item">
	                            <a href="javascript:void(0);" onclick="uploadPointTableView('${sessionScope.gameDetails.gameId}');">Point Table</a>
	                        </li>  --%> 
	                          <li>
			                   <a href="javascript:void(0);" onclick="uploadCouponsView('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');">Coupons</a>
			                </li> 
	                                 
	                          <li>
	                             <a href="javascript:void(0)" onclick="uploadRulesView();">Help</a>
	                        </li>
	                        <!-- <li>
	                            <a href="/SportMgmt/FAQ.jsp" class="ism-nav__tab ">FAQ</a>
	                            <a href="javascript:void(0);"  onclick="uploadFAQView();">FAQ</a>
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
		function uploadMatchView(gameId)
		{
			if(typeof gameId != 'undefined' && gameId != '')
			{
				url ="/SportMgmt/mvc/game/MatchView/"+gameId;
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 /* console.log(resp); */
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			}
		}
		function uploadTransferView()
		{
			url ="/SportMgmt/transfer.jsp";
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadTeamView(userId,gameId)
		{
			if(typeof userGameJson != 'undefined' && userGameJson.playerList.length >= 15)
			{
				if(typeof userId != 'undefined' && userId != '' && typeof gameId != 'undefined' && gameId != '')
				{
					url ="/SportMgmt/mvc/game/MyTeamView/"+userId+"/"+gameId;
					$.ajax({
			     		  url: url,
			     		  dataType: 'html',
			     		  success: function( resp ) {
			     			 //console.log(resp); 
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
				showNotification ("Please complete the team of 15 players");
			}
		}
		function uploadRankingView()
		{
			url ="/SportMgmt/ranking.jsp";
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadLeadershipView(gameId,userId,gameWeekId)
		{
			url ="/SportMgmt/mvc/game/MyRank/"+gameId+"/"+userId;
			if(gameWeekId !=null && gameWeekId !='')
			{
				url = url+"?gameWeekId="+gameWeekId;
			}
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadMyPointView(gameId,userId,gameWeekId,direction)
		{
			if(typeof gameId != 'undefined' && gameId != '')
			{
				url ="/SportMgmt/mvc/game/MyPoint/"+gameId+"/"+userId;
				if(gameWeekId !='' && direction!='')
				{
					url =url+"?gameWeekId="+gameWeekId+"&game-week-for="+direction;
				}
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			}
		}
		function uploadCouponsView(userId, gameId)
		{
			if(typeof userId != 'undefined' && userId != '' && typeof gameId != 'undefined' && gameId != '')
			{
				url ="/SportMgmt/mvc/coupon/list/"+userId+"/"+gameId;
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
		function uploadPointTableView(gameId)
		{
			if(typeof gameId != 'undefined' && gameId != '')
			{
				url ="/SportMgmt/mvc/game/PointTableView/"+gameId;
				$.ajax({
		     		  url: url,
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			}
		}
		function uploadFAQView()
		{
			
				$.ajax({
		     		  url: "/SportMgmt/mvc/FAQView",
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadRulesView()
		{
			
				$.ajax({
		     		  url: "/SportMgmt/mvc/RulesView",
		     		  dataType: 'html',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
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
		     			 //console.log(resp); 
		     			if(typeof resp.playerList !='undefined')
		     			 playerListJson = resp.playerList;
		     			 uploadTransferView();
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

</html>