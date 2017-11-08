<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%-- <jsp:include page="${context}/dreamEleven/facebookPost.jsp" /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>The12thman | Fantasy League</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:set var="context" value="<%=request.getContextPath()%>" />
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s"%>
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		
				
		<link rel="stylesheet" type="text/css" 	href="${context}/redBlackTheme/toDelete/258578334140_blp.css"> 
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/jquery.bxslider.css">
		<!--  <link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style-dream.css">-->
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style-fantasy.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/theme.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/demo.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/tab-style.css">
		<link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,500,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700" rel="stylesheet">
		  
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="${context}/redBlackTheme/js/bootstrap.js"></script>
		<script src="${context}/redBlackTheme/js/jquery.bxslider.js"></script>
		<script src="${context}/redBlackTheme/js/jPushMenu.js" ></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script> 
		<script src="${context}/redBlackTheme/js/jquery-3.2.1.js" ></script> 

		<style>
		#preloader {
		  position: fixed;
		  top:0;
		  left:0;
		  right:0;
		  bottom:0;
		  background-color:#fff; /* change if the mask should have another color then white */
		  z-index:10000; /* makes sure it stays on top */
		}
		
		#status {
		  
		  width:300px;
		  height:300px;
		  position:absolute;
		  left:53%; /* centers the loading animation horizontally one the screen */
		  top:50%; /* centers the loading animation vertically one the screen */
		  background-image:url("/SportMgmt/redBlackTheme/images/load.gif"); /* path to your loading animation */
		  background-repeat:no-repeat;
		  background-position:center;
		  margin:-200px 0 0 -200px; /* is width and height divided by two */
		}
		@media screen and (min-width : 360px) and (max-width : 479px) {
		  #status { left:65%;}
		 }
		</style>
	</head>
	<!-- code for preloader starts -->
	<div id="preloader">
		<div id="status">&nbsp;</div>
	</div>
	<script type="text/javascript">
		$(window).on("load", function() { // makes sure the whole site is loaded
			$('#status').fadeOut(1000); // will first fade out the loading animation
			$('#preloader').delay(500).fadeOut(2000); // will fade out the white DIV that covers the website.
		})
	</script>
	<!-- Code for preloader ends --> 
	<body class="dream11-bg fantasy-bg transfers_predict11 dream_11transfer">
		<c:if test="${not empty sessionScope.clubList}">
			<script type="text/javascript">
	   			var clubIdImageMap = {};
	   		</script>
			<jsp:useBean id="clubImageMap" class="java.util.HashMap" scope="session" />
			<c:forEach var="clubMap" items="${sessionScope.clubList}">
				<spring:message code="club_${clubMap['clubId']}_image" var="imageSrc" />
	   			<c:set target="${clubImageMap}" property="${clubMap['clubId']}"	value="${imageSrc}" />
				<script type="text/javascript">
	    			clubIdImageMap["${clubMap['clubId']}"] = "${imageSrc}";
	    		</script>
			</c:forEach>
		</c:if>
		<s:sportExt retrieve="priceList" />
		
		<main id="mainContent" tabindex="0" class="ism">
		<%@ include	file="dreamEleven/facebookPost.jsp"%>	
		<%@ include	file="popup.jsp"%> 
		<%@ include	file="header.jsp"%>
		<div class="ism-container">
			<%@ include	file="transfer.jsp"%>
		</div>		  
		<%@ include file="footer.jsp"%>
		</main>
	</body>    
</html>