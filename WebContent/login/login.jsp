<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring3Example</title>
</head>
<body>
<h3>Login Form</h3>
<FONT color="blue">
</FONT>
<%-- <form:form action="loginform"  commandName="loginForm" >
	<table>
		<tr>
			<td>User Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td>Password:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
 --%>
 <%-- <form action="userLogin">
	<table>
		<tr>
			<td>User Name:<FONT color="red"></FONT></td>
		</tr>
		<tr>
			<td><input type="text" name="userName" /></td>
		</tr>
		<tr>
			<td>Password:<FONT color="red"></FONT></td>
		</tr>
		<tr>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form>
 --%> <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="hosted_button_id" value="CH7R235XRK4EG">
<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
</form>

 
 <br/>
 <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="hosted_button_id" value="6A7M7SJLZZ7PN">
<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_subscribeCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
</form>
 <br/> 
 <form name="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
<input type="hidden" name="cmd" value="_xclick" />
<input type="hidden" name="business" value="deveshsoftwaregroup@gmail.com" />
<input type="hidden" name="password" value="Software@123" />
<input type="hidden" name="custom" value="1123" />
<input type="text" name="item_name" value="Tshirt " />
<input type="text" name="amount" value="1.00"/>
<input type="text" name="rm" value="1" />
<input type="hidden" name="return" value="http://localhost:8080/SportMgmt/mvc/login" />
<input type="hidden" name="cancel_return" value="http://localhost:8080/SportMgmt/mvc/login" />
<input type="hidden" name="cert_id" value="AFcWxV21C7fd0v3bYYYRCpSSRl31A1tVEekunetJaAhilY2W0cqq6fhh" /><input type="submit" value="Pay with Paypal"/>
</form>
 
 </body>
</html>