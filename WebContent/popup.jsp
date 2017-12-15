
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
		<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %> 
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>	
        <s:sportExt retrieve="deadLine" />	
        <%-- <link rel="stylesheet" href="${context}/redBlackTheme/css/bootstrap.css" type="text/css"> --%>
          <link rel="stylesheet" href="${context}/redBlackTheme/css/style-promotion.css" type="text/css"> 
         <link rel="stylesheet" href="${context}/redBlackTheme/css/jquery.countdown.css" type="text/css"> 
			<link href="https://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet">
			 <link rel='stylesheet' href='${context}/redBlackTheme/css/dscountdown.css' type='text/css' media='all' />
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
		 <div id="modelPlayOption" style="display: none;  role="dialog">
		  <div class="modal-dialog modal-lg">		
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
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                
                <h4 class="modal-title">Make payment1</h4>
              </div>
              <div class="modal-body">
                <div class="table-responsive prod-tbl">
                <table class="table table-striped table-bordered table-hover" width="100%">
                    <tbody>
            
                      <c:forEach var="wildCard" items="${sessionScope.purchableWildCardList}" >
                            <form  id="paymentForm_${wildCard.planId}" action="/SportMgmt/mvc/payment/MakePayment" method="post">
                            <input type="hidden" name="leaguePlanId" value="${wildCard.planId}"></input>
                            <input type="hidden" name="planDiscountId" value="${sessionScope.planDiscountId}"></input>
                            <input type="hidden" name="amount" value="${wildCard.price}"></input>
                            </form>
                      <tr>
                        <td>Eligible for</td>
                  
                        <td>${wildCard.name}</td>
                      </tr>
                  
                      <tr>
                        <td>Price</td>
                  
                        <td>${wildCard.price}</td>
                      </tr>
                  
                      <tr>
                        <td>Discount</td>
                          <td><input id="paymentDiscountCode_${wildCard.planId}" type="text" name="discount" value=""></input></td>
                      </tr>
                  
                      <tr>
                        <td>Total Price</td>
                  
                        <td>${wildCard.price}</td>
                      </tr>
                  
                      <tr>
                        <td>Purchase</td>
                  
                        <td><button id="paymentButton_${wildCard.planId}" type="button" class="button" >Buy Now</button></td>
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
		<div id="modalMessage" class="modal fade" role="dialog">

		<div id="login-overlay" class="modal-dialog loginForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">COMING SOON..</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							
							FANTASY LEAGUE IS COMING SOON TILL THEN PLAY DREAM ELEVEN AND WIN GIFTS.	
								
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
		
	<div id="modelPromotion" class="modal fade"  role="dialog">
		  <div class="modal-dialog modal-lg">		
		    
		    <div class="modal-content">
		     <!--  <div class="modal-header">
		     
		      <button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">x</span><span class="sr-only">Close</span>
					</button>
					 <h4 class="modal-title" >Play Option</h4>	       
		        
		      </div>-->
		      <div class="modal-body">
		      <div class="container-fluid">
    			<div class="row">
        			<div class="col-lg-6 col-lg-offset-6 col-md-7 col-md-offset-5 col-tn-7 col-tn-offset-5 col-sm-12 col-sm-offset-0  right_text">
            			<h2>THE GREAT</h2>
            <h1>FOOTBALL MANIAC</h1>
            <h3>16-17-18 DEC'17 <span id="sale">SALE</span></h3>
            <div class="below_date">
                <h3>INDIA'S BIGGEST COLLECTION OF <br>
                    <span id="football_merchn">FOOTBALL MERCHANDISE!</span></h3>
            </div>
           

            <div class="register">
                <h4>Register today to score a discount of </h4>
                <h4><span>Rs 100</span> on your purchase</h4>
            </div>

            <div class="row btn_counter ">
                <div class="col-lg-12 ">
                    <a href="#"><button type="button" class="btn register_now">REGISTER NOW</button></a>
                </div>
                <div class="col-lg-12 timer">
                        <p id="time_left" style="float:left;">Time Left : </p> <div class="demo1" style="float:left;"> </div> 
                </div>
            </div>
        </div>
    </div>

</div>
				</div>
		      </div>
		    </div>		
		  </div>
	
		
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
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  -->   
<!--<script src="${context}/redBlackTheme/js/bootstrap.js"></script>-->
<script type="text/javascript" src="${context}/redBlackTheme/js/dscountdown.min.js"></script>

</html>
