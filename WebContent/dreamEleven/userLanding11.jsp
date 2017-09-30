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
		<c:set var="context" value="<%=request.getContextPath()%>" />
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		
		<link rel="stylesheet" type="text/css" 	href="${context}/redBlackTheme/toDelete/258578334140_blp.css"> 
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/jquery.bxslider.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style-dream.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/theme.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/demo.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/tab-style.css">
		<link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,500,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700" rel="stylesheet">
		    
		<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<%-- <script src="${context}/redBlackTheme/js/bootstrap.js"></script>
		<script src="${context}/redBlackTheme/js/jquery.bxslider.js"></script> --%>
		
		<style>
		.addPlayer a {
			color: #blue;
			font-size: 28px;
			padding: 5px;
		}
		</style>
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
	<body class="predict11-bg transfers_predict11" onload="uploadTransferView11();">
		<s:sportExt retrieve="priceList" />
		<main id="mainContent" tabindex="0" class="ism"> 
			<%@ include	file="header11.jsp"%>
			<!-- <div id="preloader">
	    		<div id="status">&nbsp;</div>
	  		</div> -->
			<div class="ism-container"></div> <!-- Main content of every pages gets loaded at class  -->	
			
			<!-- <div id="ismr-elements-menu"></div> -->
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
		
			<%@ include file="footer.jsp"%>
		</main>
			
		<!-- Common payment popup starts -->
	 	<div id="paymentModel" class="modal fade" role="dialog">
		  <div class="modal-dialog modal-lg">		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <a type="button" class="close" data-dismiss="modal">&times;</a>
		        <h4 class="modal-title">Make payment</h4>
		      </div>
		      <div class="modal-body">
		        <div class="table-responsive prod-tbl">
					<table class="table table-striped table-bordered table-hover">
						<thead>
						  <tr>
							<th>Eligible for</th>
							<th>Product Price</th>
							<th>Discount Code</th>
							<th>Total Price</th>
							<th>Purchase It</th>
						  </tr>
						</thead>
						<tbody>
						<c:forEach var="wildCard" items="${sessionScope.purchableWildCardList}" >
						  <form  id="paymentForm_${wildCard.planId}" action="/SportMgmt/mvc/payment/MakePayment" method="post">
						  <input type="hidden" name="leaguePlanId" value="${wildCard.planId}"></input>
						  <input type="hidden" name="planDiscountId" value="${sessionScope.planDiscountId}"></input>
						  <input type="hidden" name="amount" value="${wildCard.price}"></input>
						  </form>
						  <tr>
							<td>${wildCard.name}</td>
							<td>${wildCard.price}</td>
							<td>
							<input id="paymentDiscountCode_${wildCard.planId}" type="text" name="discount" value=""></input>
							</td>
							<td>${wildCard.price}</td>
							<td>
		        			<button id="paymentButton_${wildCard.planId}" type="button" class="button" >Buy Now</button>
		     				</td>
						  </tr>
						  </c:forEach>													
						</tbody>
					  </table>
				</div>
		      </div>
		    </div>		
		  </div>
		</div>	
		<!-- Common Payment Popup ends -->
			
	</body>    
</html>
