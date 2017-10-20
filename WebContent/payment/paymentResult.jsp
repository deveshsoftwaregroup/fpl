<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Payment Status</title>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:set var="context" value="<%=request.getContextPath()%>" />
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
		
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/style-fantasy.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/jquery.bxslider.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/theme.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/tab-style.css">
		<link rel="stylesheet" type="text/css" href="${context}/redBlackTheme/css/font-awesome.min.css">
		
		<link href="https://fonts.googleapis.com/css?family=Roboto:100,300,500,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700" rel="stylesheet">
		
	</head>
	<body class="fantasy-bg  Payment">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12 ">
					<div class="my_logo" ><img src="${context}/redBlackTheme/images/logo.png" class="img-responsive logo_img"> <img src="${context}/redBlackTheme/images/simple-bannr.png" class=" img-responsive bnr_img"></div>
				</div>
				<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 col-xs-12">
					<div class="">
						<div class="Payment_detail">
						Payment Status:
						 <table width="100%" class="table  ">
					         <tbody>
					           <tr class="">
					             <td id="head1">Transaction Pay Id</td>
					             <td>${mihpayid}</td>
					           </tr>
					           <tr>
					             <td id="head1">Name</td>
					             <td>${firstname}</td>
					           </tr>
					           <tr>
					             <td id="head1">Transaction Status</td>
					             <td>${status}</td>
					           </tr>
					         </tbody>
						 </table>
						 </div>
			                 <div class="bck_of_btn"> <a href="${context}/mvc/user11/UserLanding11"><button type="button" class="btn  bck_btn">Go To The Website</button></a></div>
			          </div>
				</div>
			</div>
		</div>
	</body>
</html>