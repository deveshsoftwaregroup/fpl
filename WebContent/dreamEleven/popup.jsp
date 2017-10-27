
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
	 <!-------------------Notification Popup---------------------->
   <!--  <div id="myModal-notification" class="modal fade" role="dialog">
            <div class="modal-dialog">
              Modal content
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Subscribe to notifications</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                            <div class="col-sm-4"><img src="images/logo.png" class="img-responsive"></div>
                            
                          <p>Some text in the modal.</p>
                    </div>
                    
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default">Allow</button>
                  <button type="button" class="btn btn-default">Cancel</button>
                </div>
              </div>
          
            </div>
          </div>  -->
          
    
    <!-------------------/ Notification Popup------------------->
	
 		<!--Notification-->
			<div id="notification" style="display: none;">
				<span class="dismiss"><a title="dismiss this notification">X</a></span>
				<div id="notificationChild"></div>
			</div> 
        <!--Notification ends--> 
         
	<!-- Play Option payment model starts -->
		 <div id="modelPlayOption" style="display: none;"  role="dialog">
		  <div class="modal-dialog modal-md">		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">		        
		        <h4 class="modal-title">Play Option <span class="close"><a title="dismiss this notification">X</a></span></h4>
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
		        <h4 class="modal-title">Make Payment</h4>
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
		
<%-- <script type="text/javascript">
	//<![CDATA[
	$(window).on("load", function() { // makes sure the whole site is loaded
	$('#status').fadeOut(1000); // will first fade out the loading animation
	$('#preloader').delay(500).fadeOut(2000); // will fade out the white DIV that covers the website.
        $('#myModal-notification').delay(500).modal('show');
		})
	//]]>
</script> --%>
		
	</body> 
	<script type="text/javascript">  
		function showNotification(message)
		{
	    	$("#notification").fadeIn("slow");
			$("#notificationChild").empty();
	 		$("#notificationChild").append(message);
	        $(".dismiss").click(function(){
	         	$("#notification").fadeOut("slow");
	       	});
	     } 
	</script>
</html>
