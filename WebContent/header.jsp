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
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %>  
    <link rel="stylesheet" href="/SportMgmt/css/foundation.css">
    <link rel="stylesheet" href="/SportMgmt/css/app.css">
    <link rel="stylesheet" href="/SportMgmt/css/superslides.css">
    <link rel="stylesheet" type="text/css" href="/SportMgmt/css/customMedia.css">
    <link rel="stylesheet" type="text/css" href="/SportMgmt/css/258578334140.css">
    <link rel="stylesheet" type="text/css" href="/SportMgmt/css/font-awesome.css">
	<link rel="stylesheet" href="/SportMgmt/css/team.css" type="text/css">
	
    <style>
    
.ism .ism-element__name {
    font-family: inherit;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    
    color: #f1f1f1;
    font-weight: 600;
}
.ism-game-header h1 a{ color:#fff;}

.mask{ background: #000; opacity: 0.5; position:fixed; top: 0; left: 0; width: 100%; height:100%;}


@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}
</style>



<style class="cp-pen-styles">
.top-banner {
    position: relative;
	height: 50px;
    margin-top: 10px;
}
.top-banner .visible {
    font-weight: 500;
    overflow: hidden;
    height: 40px;
    padding: 0;
    color: #ccc;
    border: solid 1px #9a1500;
    margin: 0 10px;
	background: #38003c;
}
.top-banner .visible:before {
  content: '[';
  left: 6px;
  line-height: 40px;
}
.top-banner .visible:after {
  content: ']';
  position: absolute;
  right: 7px;
  line-height: 40px;
}
.top-banner .visible:after, .top-banner .visible:before {
  position: absolute;
  top: -3px;
  color: #d60000;
  font-size: 42px;
  -webkit-animation-name: opacity;
  -webkit-animation-duration: 3s;
  -webkit-animation-iteration-count: infinite;
  -webkit-animation-name: opacity;
          animation-name: opacity;
  -webkit-animation-duration: 3s;
          animation-duration: 3s;
  -webkit-animation-iteration-count: infinite;
          animation-iteration-count: infinite;
}

.top-banner p {
  display: inline;
  float: left;
  margin: 0;
  line-height: 40px;
  color: #ccc;
	background: #3c0000;
    padding: 0 10px;
    border-right: solid 1px #880000;
}

.top-banner ul {
  margin-top: 0;
  padding-left: 150px;
  text-align: left;
  list-style: none;
  -webkit-animation-name: change;
  -webkit-animation-duration: 10s;
  -webkit-animation-iteration-count: infinite;
  -webkit-animation-name: change;
          animation-name: change;
  -webkit-animation-duration: 10s;
          animation-duration: 10s;
  -webkit-animation-iteration-count: infinite;
          animation-iteration-count: infinite;
}

.top-banner ul li {
  line-height: 40px;
  margin: 0;
}

@-webkit-keyframes opacity {
  0%, 100% {
    opacity: 0;
  }
  50% {
    opacity: 1;
  }
}
@-webkit-keyframes change {
  0%, 12%, 100% {
    -webkit-transform: translateY(0);
            transform: translateY(0);
  }
  /*17%,29% {
    -webkit-transform: translateY(-25%);
            transform: translateY(-25%);
  }*/
  34%,46% {
    -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
  }
  /*51%,63% {
    -webkit-transform: translateY(-75%);
            transform: translateY(-75%);
  }*/
  68%,80% {
    -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
  }
  /*85%,97% {
    -webkit-transform: translateY(-25%);
            transform: translateY(-25%);
  }*/
}
@keyframes opacity {
  0%, 100% {
    opacity: 0;
  }
  50% {
    opacity: 1;
  }
}
@keyframes change {
  0%, 12%, 100% {
    -webkit-transform: translateY(0);
            transform: translateY(0);
  }
  
  34%,46% {
    -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
  }
 
  68%,80% {
    -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
  }
  
}
.top-ads {
    width: 33%;
    float: left;
    position: relative;
    height: 50px;
}
</style>



</head> 
 <body>
 <s:sportExt retrieve="priceList" />
 <div class="league_header">
 
    <div class="ism-header">

        <div class="wrapper">
            <div class="ism-game-header-wrap">
                <div class="ism-game-header">
                   

                    <h1>
                    	<a href="/a/">THE 12TH MAN FANTASY LEAGUE</a>
                    </h1>  
                    <span class="user-name"><i class="fa fa-user" ></i> ${sessionScope.user.displayName}</span>                  
                </div>
                
            </div>
        </div>
        <div class="menu-bar">
        <div class="wrapper">
       		 <img src ="/SportMgmt/images/menu-logo.png" class="lft-logo">   
             <img src ="/SportMgmt/images/menu-logo1.png" class="rgt-logo"> 
        <nav role="navigation" class="ism-nav ismjs-priority-nav ismjs-nav priority-nav" instance="0">
                    
                    <ul class="ism-nav__list ismjs-main-nav">   
						<li class="ism-nav__list__item">                            
                            <a href="javascript:void(0);" class="ism-nav__tab" onclick="openHomeHome();">League Home</a>
                        </li>
                        <li class="ism-nav__list__item">
                        	<a href="javascript:void(0);" class="ism-nav__tab" onclick="uploadTransferView();" data-nav-tab="squad">Transfers</a>
                        </li> 
                        <li class="ism-nav__list__item">
                        <a href="javascript:void(0);" class="ism-nav__tab" onclick="uploadTeamView('${sessionScope.userId}','${sessionScope.gameDetails.gameId}');" data-nav-tab="squad">My Team</a>		
                        </li> 
                        <li class="ism-nav__list__item">
                            <a href="javascript:void(0);" class="ism-nav__tab" onclick="uploadMatchView('${sessionScope.gameDetails.gameId}');" data-nav-tab="squad">Fixtures</a>
                        </li>                      
                        <li class="ism-nav__list__item">
                            <a href="javascript:void(0);" class="ism-nav__tab" onclick="uploadMyPointView('${sessionScope.gameDetails.gameId}','${sessionScope.userId}','','');">My Points</a>
                        </li>   
                        <li class="ism-nav__list__item">
                            <a href="javascript:void(0);" class="ism-nav__tab" onclick="uploadPointTableView('${sessionScope.gameDetails.gameId}');">Point Table</a>
                        </li>  
                                     
                            
                        <li class="ism-nav__list__item">
                            <a href="javascript:void(0)" class="ism-nav__tab " onclick="uploadRulesView();">Rules</a>
                        </li>
                        <li class="ism-nav__list__item">
                            <!-- <a href="/SportMgmt/FAQ.jsp" class="ism-nav__tab ">FAQ</a> -->
                            <a href="javascript:void(0);" class="ism-nav__tab" onclick="uploadFAQView();">FAQ</a>
                        </li>                       
                        <li class="ism-nav__list__item">
                            <a href="/SportMgmt/mvc/user/Logout" class="ism-nav__tab ">Sign Out</a>
                        </li>
                        <li class="ism-nav__list__item"></li> 
                    </ul>
                    
                  <span class="ism-nav__dropdown-wrapper priority-nav__wrapper" aria-haspopup="false">
					<button aria-controls="menu" type="button" class="ism-nav__dropdown-toggle priority-nav__dropdown-toggle priority-nav-is-hidden">More</button>
					<ul aria-hidden="true" class="ism-nav__dropdown priority-nav__dropdown"></ul>
					</span>
           </nav>
           </div>
           </div>
    </div>  
   </div>  

    
 
    
   
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
		     			 //console.log(resp); 
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
  </body>
</html>