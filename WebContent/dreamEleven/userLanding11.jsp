<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>The12thman | Fantasy League...</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="sportmgmt.tld" prefix="s"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- <link rel="stylesheet" href="/SportMgmt/css/foundation.css">
<link rel="stylesheet" href="/SportMgmt/css/app.css">
<link rel="stylesheet" href="/SportMgmt/css/superslides.css"> -->
<!-- <link rel="stylesheet" type="text/css" 	href="/SportMgmt/css/customMedia.css"> -->
<link rel="stylesheet" type="text/css" 	href="/SportMgmt/css/258578334140.css">
<script type='text/javascript' src='http://code.jquery.com/jquery-1.9.1.js'></script>
	<link rel="stylesheet" href="${context}/redBlackTheme/css/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${context}/redBlackTheme/css/style-dream.css" type="text/css">
    <link rel="stylesheet" href="${context}/redBlackTheme/css/jquery.bxslider.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700" rel="stylesheet">
    <link rel="stylesheet" href="${context}/redBlackTheme/css/theme.css" type="text/css">
    <script type='text/javascript'
         src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<style>
.addPlayer a {
	color: #blue;
	font-size: 28px;
	padding: 5px;
}
</style>
</head>
	<body class="predict11-bg transfers_predict11" onload="uploadTransferView11();">
		<s:sportExt retrieve="priceList" />
		<main id="mainContent" tabindex="0" class="ism"> 
		<%@ include	file="header11.jsp"%>
		
		<div class="ism-container"></div>	
		
		<div id="ismr-elements-menu"></div>
		 <c:if test="${not empty sessionScope.clubList}">
			<script type="text/javascript">
	   			var clubIdImageMap = {};
	   		</script>
			<jsp:useBean id="clubImageMap" class="java.util.HashMap" scope="session" />
			<c:forEach var="clubMap" items="${sessionScope.clubList}">
				<spring:message code="club_${clubMap['clubId']}_image" var="imageSrc" />;
	   			<c:set target="${clubImageMap}" property="${clubMap['clubId']}"	value="${imageSrc}" />
				<script type="text/javascript">
	    			clubIdImageMap["${clubMap['clubId']}"] = "${imageSrc}";
	    		</script>
			</c:forEach>
		</c:if> 		
		
		<%@ include file="footer.jsp"%>
		</main>
	</body>
</html>
