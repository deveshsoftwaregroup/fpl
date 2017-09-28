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
    <c:set var="context" value="/SportMgmt" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %>  
<link rel="stylesheet" type="text/css" 	href="/SportMgmt/redBlackTheme/toDelete/258578334140_blp.css"> 
	
	<!-- <link rel="stylesheet" href="${context}/redBlackTheme/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${context}/redBlackTheme/css/style-dream.css" type="text/css">
    
    <link rel="stylesheet" href="${context}/redBlackTheme/css/style.css" type="text/css">
    
    <link rel="stylesheet" href="${context}/redBlackTheme/css/jquery.bxslider.css" type="text/css">
    <link rel="stylesheet" href="${context}/redBlackTheme/css/theme.css" type="text/css">
    <link rel="stylesheet" href="${context}/redBlackTheme/css/tab-style.css" type="text/css">
    <link rel="stylesheet" href="${context}/redBlackTheme/css/demo.css" type="text/css"> -->
    
    <link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style.css">
<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style-dream.css">
<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/theme.css">
<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/demo.css">
<!--  <link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/tab-style.css">-->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,600" rel="stylesheet">

      <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,500,600" rel="stylesheet">
      <link href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600" rel="stylesheet">
    
    
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700" rel="stylesheet">


</head> 
 
 <s:sportExt retrieve="priceList" />
 <div class="container">
 
    <div class="row">

        <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
            <div class="row dream11-top_header">
                <div class="col-lg-12">
                  <ul>
                     <div  class="tect_left">
	                    <li class=" flex-item" style="float: left;"><b><i> ${sessionScope.user.displayName}                  
	                		</i></b> &nbsp;  &nbsp; <a></a>
	                	</li>
                	</div>
                    <div style="float:right;">
                    	<li class="pwr_text flex-item" style="float: left;">Powered By</li>
                        <li class="flex-item" style="float: left;"><img src="${context}/redBlackTheme/images/poweredby-logo.pngggg" class="img-responsive pwr_logo"></li>
                    </div>
                  </ul>
                </div>  
             </div>
        </div>
    </div>
    <header>
             <div class="row">
                <div class="col-lg-1 col-sm-1"><div class="left_img"><img src="${context}/redBlackTheme/images/left_image.png"></div></div>    
               <div class="col-lg-10 col-md-10 col-sm-10  ">
         <nav class="navbar ">
              <div class="container-fluid">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle toggle-menu menu-left jPushMenuBtn menu-active" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>                        
                  </button>
                  <a class="navbar-brand" href="#"><img src="${context}/redBlackTheme/images/logo.png" class="img-responsive"></a>   
                </div>
                <div class="collapse navbar-collapse cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                  
                    
						<!-- <li>                            
                            <a href="javascript:void(0);" onclick="openHomeHome();">League Home</a>
                        </li> -->
                        <li>
                        	<a href="javascript:void(0);" onclick="uploadTransferView11();" data-nav-tab="squad">Transfers</a>
                        </li> 
                        <%-- <li>
                        <a href="javascript:void(0);" onclick="uploadTeamView11('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');" data-nav-tab="squad">My Team</a>		
                        </li> 
                        <li>
                            <a href="javascript:void(0);" onclick="uploadMatchView11('${sessionScope.gameDetails.gameId}');" data-nav-tab="squad">Fixtures</a>
                        </li>       --%>                
                        <li>
                            <a href="javascript:void(0);" onclick="uploadMyPointView11('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','','');">My Points</a>
                        </li>   
                        <li>
                            <a href="javascript:void(0);" onclick="uploadCouponsView11('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');">Coupons</a>
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
                        <li></li> 
                     </div>
              </div>
             </div>
                <div class="col-lg-1  col-sm-1"><div class="right_img"><img src="${context}/redBlackTheme/images/left_image.png"></div></div> 
             
            </nav>   
            
            
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
		     			 //console.log(resp); 
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
		     			 //console.log(resp); 
		     			 $('.ism-container').html(resp);
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
		}
		function uploadTeamView11(userId,gameId)
		{
			if(typeof userGameJson != 'undefined' && userGameJson.playerList.length >= 11)
			{
				if(typeof userId != 'undefined' && userId != '' && typeof gameId != 'undefined' && gameId != '')
				{
					url ="/SportMgmt/mvc/game11/MyTeamView11/"+userId+"/"+gameId;
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
				alert ("Please complete the team of 15 players");
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
		     			 //console.log(resp); 
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
		     			 //console.log(resp); 
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
		     			 //console.log(resp); 
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
   <script src="${context}/redBlackTheme/js/jPushMenu.js" ></script>
      <script type="text/javascript">
         //<![CDATA[
         $(document).ready(function(){
           $('.toggle-menu').jPushMenu({closeOnClickLink: true, closeOnClickOutside: false});
          
         });
         //]]>
      </script>
  </body>
</html>