<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:set var="context" value="<%=request.getContextPath()%>" />
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
        <s:sportExt retrieve="deadLine" />	
	</head>
	
	<body>
		 <!-- Play Option payment model starts -->
		 <div id="paymentModel11" class="modal fade" role="dialog">
		  <div class="modal-dialog modal-lg">		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <a type="button" class="close" data-dismiss="modal">&times;</a>
		        <h4 class="modal-title">Play Option</h4>
		      </div>
		      <div class="modal-body">
		        <div class="table-responsive prod-tbl">
		         <a href="#"><button type="button" class="btn claim_btn" onclick="createHistory11('${sessionScope.gameDetails.gameId}','${gameWeekId}','${sessionScope.userId}');">Play Free </button></a>
                  <a href="#"><button type="button" class="btn claim_btn" data-toggle="modal" data-target="#paymentModel">Pay and Earn</button></a>
                 </div>
					
				</div>
		      </div>
		    </div>		
		  </div>
		  <!-- Play Option payment model ends --> 
		 
		<!-- payment popup starts -->
	 	<div id="paymentModel" class="modal fade" role="dialog">
		  <div class="modal-dialog modal-lg">		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <a type="button" class="close" data-dismiss="modal">&times;</a>
		        <h4 class="modal-title">Make payment1</h4>
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
		<!--Payment Popup ends -->
		
	</body>    
</html>
