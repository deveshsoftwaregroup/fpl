<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.mask 
{
	background: #000;
	opacity: 0.5;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>
<script src="/SportMgmt/js/jquery.js"></script>
<script type="text/javascript">
$(document).ajaxStart(function(){
		$("#ajaxloader").css("display", "block");
		$('.mask').show();
	});

	$(document).ajaxComplete(function(){
	    $("#ajaxloader").css("display", "none");
	    $('.mask').hide();
	});
	function updateVendorArticle(positionPriceID)
	{
			//var player = $("#player");
			//var point = $("#point");
			var link = $("#link"+positionPriceID).val();
			alert(link);
			alert(positionPriceID);
		    var content = $("#content"+positionPriceID).val();
		    alert(content);
		    var heading = $("#heading"+positionPriceID).val();
            var category = $("#category"+positionPriceID).val();
			/* var articleId = $("#articleId").val(); */
			var vendorId = $("#vendorId").val();
			 //var positionPriceId = positionPrice; 
			 //alert("positionPriceId="+positionPriceId);
			console.log("articleId: "+articleId+" , vendorId:"+vendorId+", positionId:"+positionId+",category:"+category);
			if(articleId !='undefined' && vendorId !='undefined' && positionId!='undefined')
			{
				
				
				url ="/SportMgmt/mvc/game/VendorHome?vendorId="+vendorId+"&positionPriceID="+positionPriceID+"&category="+category+"&content="+content+"&heading="+heading+"&link="+link;
				alert("hhhh");
				$.ajax({
		     		  url: url,
		     		  method: 'POST',
		     		  dataType: 'json',
		     		  success: function( resp ) {
		     			 console.log(resp); 
		     			// $('.ism-container').html(resp);
		     			if(resp.isSuccess == 'true')
		     			{
		     				alert("Point updated successfully");
		     			}
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			
			}
	}
	
	
</script>
<title>Insert title here</title>
</head>
<body>
 <%--  <c:choose>
<c:when test="${isSuccess}">   --%>
 <input type="hidden" id="articleId" value="${articleId}" />
<input type="hidden" id="vendorId" value="${vendorId}" />
<input type="hidden" id="positionId" value="${positionId}" /> 

					<c:forEach items="${vendorPositionPriceList}" var="positionPriceID">
					    <c:out value="${positionPriceID}"></c:out>
                         <div class="form-group">
				     Category:  <input type="text" id="category${positionPriceID}"  value="${category}"placeholder="Category"
								required id="category" class="form-control" />
					    </div>
						 <div class="form-group">
					 Heading:	<input type="text" id="heading${positionPriceID}" value="${heading}"   placeholder="Heading"
								required id="heading" class="form-control" />
						</div>
						 <div class="form-group">
					 Content:	<input type="text" id="content${positionPriceID}" value="${content}"   placeholder="Content"
								required id="content" class="form-control" />
						</div>
						<div class="form-group">
					   Link:    <input type="text" id="link${positionPriceID}"    value="${link}"   placeholder="Link"
								required id="link" class="form-control" />
						</div>
						<br/><br/>
<button onclick="updateVendorArticle(${positionPriceID});">Save</button>
<br/><br/>
</c:forEach>
 <%-- </c:when>
</c:choose> --%> 
</body>
</html>