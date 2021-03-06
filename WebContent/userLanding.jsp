<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%-- <jsp:include page="${context}/dreamEleven/facebookPost.jsp" /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- GOOGLE analytics code starts -->
		<!-- Global site tag (gtag.js) - Google Analytics -->
			<script async src="https://www.googletagmanager.com/gtag/js?id=UA-111448961-1"></script>
			<script>
			  window.dataLayer = window.dataLayer || [];
			  function gtag(){dataLayer.push(arguments);}
			  gtag('js', new Date());
			
			  gtag('config', 'UA-111448961-1');
			</script>
		<!-- Google analytics code ends -->
		<meta http-equiv='cache-control' content='no-cache'>
		<meta http-equiv='expires' content='0'>
		<meta http-equiv='pragma' content='no-cache'>
		<script type="text/javascript">
		/* window.location.reload(true); */
		Cache.Delete();
		$('html[manifest=saveappoffline.appcache]').attr('content', '');
		</script>

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
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/jquery.dataTables.css">
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
		<script src="${context}/redBlackTheme/js/jquery.dataTables.min.js"></script>
		<script src="${context}/redBlackTheme/js/jquery.bxslider.js"></script>
		<script src="${context}/redBlackTheme/js/jPushMenu.js" ></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script> 
		<%-- <script src="${context}/redBlackTheme/js/jquery-3.2.1.js" ></script>  --%>
		<!-- <script src="${context}/redBlackTheme/js/modernizr.min.js" ></script> -->

		
	</head>	
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
		<br>	<br><br>	  
		<%@ include file="footer.jsp"%>
		</main>
	</body>    
</html>