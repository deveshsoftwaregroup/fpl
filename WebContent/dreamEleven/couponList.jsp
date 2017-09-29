<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<body class="predict11-bg coupon_predict">
      <div class="container my-container">
<div class="row">
          <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 image_ad">
            
              <div>
                <h3>Gifts</h3>
                <c:if test="${not empty couponCode}">
                	<div><h4>Your coupon code is ${couponCode}</h4></div>
                </c:if>
                <c:if test="${isCouponAlreadyUsed}">
                	<div><c:out value="Coupon is not avialable, Please choose other."/></div>
                </c:if>
                 <c:if test="${isTechnicalError}">
                	<div><c:out value="Technical error to allot coupon"/></div>
                </c:if>
                <div class="row">
                  <c:forEach var="coupon" items="${couponList}">
                  <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" data-toggle="modal" data-target="#myModal-gift1" ><img src="${context}/redBlackTheme/images/${coupon.logo}" class="img-responsive" alt="${coupon.name}">
                      <p>${coupon.description}</p></div>
                     <button type="button" class="btn btn-danger claim_btn <c:if test='${not empty couponCode}'> disabled</c:if>" onclick="allotCoupon('${sessionScope.userId}','${sessionScope.gameDetails.gameId}','${coupon.couponId}');">Claim Now</button>
                  </div>
                  </c:forEach>
<%--                     <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button"  class="btn btn-danger claim_btn ">Claim Now</button>
                  </div>
                    <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button" class="btn btn-danger claim_btn ">Claim Now</button>
                  </div>
                    <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button"  class="btn btn-danger claim_btn ">Claim Now</button>
                  </div>
                    <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button"  class="btn btn-danger claim_btn ">Claim Now</button>
                  </div>
                    <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button"  class="btn btn-danger claim_btn ">Claim Now</button>
                  </div>
                    <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                         <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button"  class="btn btn-danger claim_btn  ">Claim Now</button>
                  </div>
                    <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button"  class="btn btn-danger claim_btn ">Claim Now</button>
                  </div>
                    <div class="col-lg-4 col-sm-6 col-xs-6 coupon_card">
                    <div class="details_adjust" ><img src="${context}/redBlackTheme/images/freecharge.png" class="img-responsive">
                      <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p></div>
                     <button type="button"  class="btn btn-danger claim_btn ">Claim Now</button>
                  </div> --%>
                  </div>  
               
              </div>
            </div>
          </div>
          </div>
</body>
<script type="text/javascript">
function allotCoupon(userId,gameId,couponId)
{
	if(typeof gameId != 'undefined' && gameId != '')
	{
		url ="/SportMgmt/mvc/coupon/dream-eleven-avail?userId="+userId+"&gameId="+gameId+"&couponId="+couponId;
		$.ajax({
     		  url: url,
     		  method: 'post',
     		  dataType: 'html',
     		  success: function( resp ) {
     			 //console.log(resp); 
     			 $('.ism-container').html(resp);
     		  },
     		  error: function( req, status, err ) {
     		    console.log( 'something went wrong', status, err );
     		  }
     		});	
	}
}
</script>
