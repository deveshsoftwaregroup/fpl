<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>The12thman | Fantasy League</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" href="${context}/css/foundation.css">
<link rel="stylesheet" href="${context}/css/app.css">
<link rel="stylesheet" href="${context}/css/superslides.css">
<link rel="stylesheet" type="text/css" 	href="${context}/css/customMedia.css">
<link rel="stylesheet" type="text/css" 	href="${context}/css/258578334140.css">

<style>
.addPlayer a {
	color: #ed3a28;
	font-size: 18px;
	padding: 5px;
}

.removePlayerIcon {
	background: #de5e00;
	color: #fff !important;
	padding: 2px 5px;
	font-size: 12px;
	font-weight: bold;
}
/*  home  page */
.ism-game-header h1 a {
	color: #fff;
}

.mask {
	background: #000;
	opacity: 0.5;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

@
keyframes spin { 0% {
	transform: rotate(0deg);
}
100%
{
transform
:
 
rotate
(360deg);
 
}
}
</style>
</head>
<body class="inner_page" onload="uploadTransferView();">
	<s:sportExt retrieve="priceList" />
	<main id="mainContent" tabindex="0" class="ism"> 
	<%@ include	file="header.jsp"%>
	<div class="ism-container"></div>	
	<div id="ismr-elements-menu"></div>
	<script type="text/javascript">
          $(document).ajaxStart(function(){
 		$("#ajaxloader").css("display", "none");
 		$('.mask').hide();
 	});

 	$(document).ajaxComplete(function(){
 	    $("#ajaxloader").css("display", "block");
 	    $('.mask').show();
 	});  

   </script> <c:if test="${not empty sessionScope.clubList}">
		<script type="text/javascript">
   		var clubIdImageMap = {};
   	</script>
		<jsp:useBean id="clubImageMap" class="java.util.HashMap"
			scope="session" />
		<c:forEach var="clubMap" items="${sessionScope.clubList}">
			<spring:message code="club_${clubMap['clubId']}_image" var="imageSrc" />;
   	<c:set target="${clubImageMap}" property="${clubMap['clubId']}"
				value="${imageSrc}" />
			<script type="text/javascript">
    	clubIdImageMap["${clubMap['clubId']}"] = "${imageSrc}";
    </script>
		</c:forEach>
	</c:if> 
	<%@ include file="footer.jsp"%>
	<div class="mask" style="display: none;"></div>
	<div id="ajaxloader"></div> 

	</main>
</body>
<script src="${context}/js/vendor/what-input.js"></script>
<script src="${context}/js/vendor/foundation.js"></script>
<script src="${context}/js/app.js"></script>
<script src="${context}/js/jquery.easing.1.3.js"></script>
<script src="${context}/js/jquery.animate-enhanced.min.js"></script>
<script src="${context}/js/jquery.superslides.js" type="text/javascript" charset="utf-8"></script>
<script src="${context}/js/bootstrap.min.js"></script>
<script src="${context}/js/jquery.js"></script>
<%-- <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> --%>
<script src="${context}/js/jquery.js"></script> 
<script src="${context}/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="${context}/js/69e9bb26ef46.js"></script>
 
 
</html>
