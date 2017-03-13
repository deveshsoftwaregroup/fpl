<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The12thman | Fantasy League</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %>  
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <link rel="stylesheet" href="/SportMgmt/css/foundation.css">
    <link rel="stylesheet" href="/SportMgmt/css/app.css">
    <link rel="stylesheet" href="/SportMgmt/css/superslides.css">
    <link rel="stylesheet" type="text/css" href="/SportMgmt/css/customMedia.css">
    <link rel="stylesheet" type="text/css" href="/SportMgmt/css/258578334140.css">
    <script src="https://use.fontawesome.com/d4e6d4c165.js"></script>
    <style>
    .addPlayer a{ color:#ed3a28; font-size: 18px; padding: 5px;}
    .removePlayerIcon{ background: #de5e00;
    color: #fff !important;
    padding: 2px 5px;
    font-size: 12px;
    font-weight: bold;}
    /*  home  page */
.ism-game-header h1 a{ color:#fff;}
 /*  #ajaxloader {
    border: 16px solid #f3f3f3; 
    border-top: 16px solid blue;
 	border-right: 16px solid green;
 	border-bottom: 16px solid red;
 	border-left: 16px solid pink;
    border-radius: 50%;
    width: 50px;
    height: 50px;
    animation: spin 1s linear infinite;
    position: fixed;
    left: 50%;
    top: 50%;
    margin-left: -32px; 
    margin-top: -32px;
    z-index: 999;
    display:none;
} */
.mask{ background: #000; opacity: 0.5; position:fixed; top: 0; left: 0; width: 100%; height:100%;}


@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}
</style>
</head> 
 <body class="inner_page" onload="uploadTransferView();">
 <s:sportExt retrieve="priceList" />
 <main id="mainContent" tabindex="0" class="ism">
    
        <%@ include file="header.jsp" %>
    
    <div class="ism-container">
    </div>
    <!--</div>-->
    
    <div id="ismr-elements-menu"></div>
    <!--</div>
    </div>
    </div>
    </div>-->

    
 
    
   <%--  <script src="/SportMgmt/js/vendor/jquery.js"></script> --%>
    <script src="/SportMgmt/js/vendor/what-input.js"></script>
    <script src="/SportMgmt/js/vendor/foundation.js"></script>
    <script src="/SportMgmt/js/app.js"></script>
    <script src="/SportMgmt/js/jquery.easing.1.3.js"></script>
    <script src="/SportMgmt/js/jquery.animate-enhanced.min.js"></script>
    <script src="/SportMgmt/js/jquery.superslides.js" type="text/javascript" charset="utf-8"></script>
     <script type="text/javascript">
        $(document).ajaxStart(function(){
 		$("#ajaxloader").css("display", "block");
 		$('.mask').show();
 	});

 	$(document).ajaxComplete(function(){
 	    $("#ajaxloader").css("display", "none");
 	    $('.mask').hide();
 	});

   </script>
   <c:if test="${not empty sessionScope.clubList}">
   	<script type="text/javascript">
   		var clubIdImageMap = {};
   	</script>
   	<jsp:useBean id="clubImageMap" class="java.util.HashMap" scope="session"/>
   	<c:forEach var="clubMap" items="${sessionScope.clubList}">
   	<spring:message code="club_${clubMap['clubId']}_image" var="imageSrc" />;
   	<c:set target="${clubImageMap}" property="${clubMap['clubId']}" value="${imageSrc}"/>
    <script type="text/javascript">
    	clubIdImageMap["${clubMap['clubId']}"] = "${imageSrc}";
    </script>
    </c:forEach>
   	</c:if>
    <%@ include file="footer.jsp" %>
   <!--  <div id="ajaxloader"></div>
   <div class="mask" style="display:none;"></div> -->
    </main>
  </body>
	
</html>