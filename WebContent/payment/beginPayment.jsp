<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=request.getContextPath()%>" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
 <script src="${context}/js/vendor/jquery.js"></script>
</head>
<body>
You are being redirected to Payment gateway...
<form name="PaymentForm" action="${paymentURL}" method='post'>
<input type="hidden" name="firstname" value="${firstname}" />
<input type="hidden" name="lastname" value="${lastname}" />
<input type="hidden" name="surl" value="${surl}" />
<input type="hidden" name="phone" value="${sessionScope.user.contactNumber}" />
<input type="hidden" name="service_provider" value="payu_paisa" />
<input type="hidden" name="key" value="${key}" />
<input type="hidden" name="hash" value = "${hash}" />
<input type="hidden" name="curl" value="${curl}" />
<input type="hidden" name="furl" value="${furl}" />
<input type="hidden" name="txnid" value="${txnid}" />
<input type="hidden" name="productinfo" value="${productinfo}" />
<input type="hidden" name="amount" value="${amount}" />
<input type="hidden" name="email" value="${email}" />
<input type="hidden" name="udf1" value="${udf1}" />
<input type="hidden" name="udf2" value="${udf2}" />
<input type="hidden" name="udf3" value="${udf3}" />
<input type="hidden" name="udf4" value="${udf4}" />
<input type="hidden" name="udf5" value="${udf5}" />
</form>
<script type="text/javascript">
$(document).ready(function() {
	document.forms['PaymentForm'].submit();
	});
</script>
</body>
</html>