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
        <%-- <link rel="stylesheet" href="${context}/redBlackTheme/css/bootstrap.css" type="text/css"> --%>
          <link rel="stylesheet" href="${context}/redBlackTheme/css/style-promotion.css" type="text/css"> 
         <link rel="stylesheet" href="${context}/redBlackTheme/css/jquery.countdown.css" type="text/css"> 
			<link href="https://fonts.googleapis.com/css?family=Open+Sans:700" rel="stylesheet">
			 <link rel='stylesheet' href='${context}/redBlackTheme/css/dscountdown.css' type='text/css' media='all' />

<title>Insert title here</title>
</head>
<body>
<div id="myModalVendor" class="modal fade registration" role="dialog">

		<div id="login-overlay" class="modal-dialog loginForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
						
					</button>
					<h4 class="modal-title" id="myModalLabel">Register Now</h4>
				</div>
				<div class="modal-body">
					<form name="RegisterVendorForm" action="vendor/vendorregister" method="post">
						<div class="form-group">
							<input type="text" name="displayName" placeholder="Name" required
								id="name" class="form-control" />
						</div>
						<div class="form-group">
							<input type="email" name="emailId" placeholder="Email ID"
								required id="email" class="form-control" />
						</div>
						<div class="form-group">
							<input type="password" name="logonPassword"
								placeholder="Password" required id="password"
								class="form-control" />
						</div>
						<div class="form-group">
							<input type="password" name="logonPasswordConfirm"
								placeholder="Confirm Password" required id="password2"
								class="form-control" />
						</div>
						<div class="form-group">
							<input type="date" class="form-control" id="dob" name="dob"
								data-placeholder="Date of Birth"  required id="dob">
						</div>
						<div class="form-group">
							<select name="country" placeholder="Mobile Number" required
								id="country" class="form-control">
								<option value="">Select Country</option>
								<c:forEach var="countryObj" items="${countryMap}">
									<option value="${countryObj.key}">${countryObj.key}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<select name="club" placeholder="Favourite Club" required
								id="club" class="form-control">
								<option value="">Select Favourite Club</option>
								<c:forEach var="clubObj" items="${clubMap}">
									<option value="${clubObj.key}">${clubObj.key}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<input type="input" name="contactNumber"
								placeholder="Mobile Number" required id="contactNumber"
								class="form-control" />
						</div>
						<div class="form-group">
							<div class="register-switch">
							<input type="radio" name="gender" value="M" id="sex_m"
									class="register-switch-input" checked=""> <label for="sex_m"
									class="register-switch-label"> Male</label> &emsp;
								<input type="radio" name="gender" value="F" id="sex_f"
									class="register-switch-input" > <label
									for="sex_f" class="register-switch-label"> Female</label> 
									
							</div>
						</div>
						<div class="form-group">
							<div align="center">
								<a href="javascript:void(0);" class="button-lrg"
									onclick="submitFormVendor();" style="display: block;"><input
									type="button"
									class="btn btn-danger btn-block btn-social btn-facebook"
									value="REGISTER"></a>
							</div>

							 <div align="center">
								<br>
								<button class="loginBtn center-block loginBtn--facebook"
									onclick="loginWithFB()";>Register with Facebook</button>
							</div> 
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<!-- 	Registration popup ends -->


</body>
</html>