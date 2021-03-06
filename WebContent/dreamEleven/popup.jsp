<head>		
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
		 <div id="modelPlayOption" class="modal fade"   role="dialog">
		  <div class="modal-dialog modal-md">		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">		        
		        <h4 class="modal-title">Play Option <span class="close" data-dismiss="modal"><a title="dismiss this notification">X</a></span></h4>
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
            
                      <c:forEach var="gameWeekPlan" items="${sessionScope.purchableGameWeekPlanList}" >
                            <form  id="paymentForm_${gameWeekPlan.planId}" action="/SportMgmt/mvc/payment/MakePayment" method="post">
                            <input type="hidden" name="gameWeekPlanId" value="${gameWeekPlan.planId}"></input>
                            <input type="hidden" name="amount" value="${gameWeekPlan.offerPrice}"></input>
                            </form>
                      <tr>
                        <td>Eligible for</td>
                  
                        <td>${gameWeekPlan.name}</td>
                      </tr>
                  	 <c:choose>
                  	 <c:when test="${gameWeekPlan.planType eq '2'}">
                      <tr>
                        <td>Price</td>
                  
                        <td>${gameWeekPlan.price}</td>
                      </tr>
                      <tr>
                        <td>Offer Price</td>
                  
                        <td>${gameWeekPlan.offerPrice}</td>
                      </tr>
                      </c:when>
                      <c:when test="${gameWeekPlan.planType eq '1'}">
                      <tr>
                        <td>Enter Price</td>
                  
                        <td><input type="number" name="userDefineAmount" onblur="updatePriceToJson('${gameWeekPlan.planId}',this.value)"></td>
                      </tr>
                      </c:when>
                      </c:choose>
                        <tr>
                        <td>Purchase</td>
                        <td><button id="paymentButton_${gameWeekPlan.planId}" type="button" class="button" >Buy Now</button></td>
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
		function updatePriceToJson(planId,price)
		{
			console.log("update price: "+price+" for planId: "+planId);
			if(purchableGameWeekPlanJson != null && typeof purchableGameWeekPlanJson != 'undefined')
		    {
		    	console.log("Going ot iterate purchableGameWeekPlanJson");
		    	for(var i = 0;i<purchableGameWeekPlanJson.length;i++)
			    {
			    	console.log("iterating purchableGameWeekPlanJson: planId: "+purchableGameWeekPlanJson[i].planId);
			    	if(purchableGameWeekPlanJson[i].planId == planId)
			    	{
			    		purchableGameWeekPlanJson[i].offerPrice=price;;
			    	}
			    }
		    }
		
		}
	</script>

