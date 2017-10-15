<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=request.getContextPath()%>" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Success</title>
</head>
<body>
Payment Status:  <br>
First Name: ${firstname}<br>
mihpayid: ${mihpayid}<br>
status : ${status}<br>
<a href="${context}/mvc/user11/UserLanding11">GO TO justthinksports.com</a>
</body>
</html>