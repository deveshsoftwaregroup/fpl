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
<div class="modal fade thankyou_Modal" id="thankyou_Modal" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">THANK YOU!</h4>
            </div>
            <div class="modal-body">
              <p><span>${param.message}</span> <br>for<br><b>'The Great Football Maniac Sale'</b><br> Do shopping and avail discount promo code. 
                Don't forget to play Predict Eleven. It's Fun as well as Rewarding.</p>
            </div>
           
          </div>
          
        </div>
      </div>
      
      <div class="modal fade" id="NonSuccessRegistrationPopup_Modal" role="dialog">
        <div class="modal-dialog">
        
          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Sorry!</h4>
            </div>
            <div class="modal-body">
              <p><span>${param.message}</span><br> 
                </p>
            </div>
           
          </div>
          
        </div>
      </div>
      <!-- 	Login popup starts -->
<div id="vendor-login" class="modal fade" role="dialog">

		<div id="login-overlay" class="modal-dialog loginForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Login</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="col-xs-12">
								<div class="row">
									<form id="loginForm" name="LoginForme" action="" method="get"
										onsubmit="event.preventDefault();" autocomplete="off">

										<div class="col-xs-12">
											<div class="row">
												<div class="form-group">

													<span class="input input--hoshi">
													<div class="col-lg-2"> 
													<span
															class="input__label-content input__label-content--hoshi">Email
																ID</span>
																</div>
																<div class="col-lg-10"> 
													<input
														class="input__field input__field--hoshi" type="email"
														name="emailId" autocomplete="off" /> <label
														class="input__label input__label--hoshi input__label--hoshi-color-1"
														for="email"> 
														
													</label>
													</div>
													</span>
												</div>
											</div>
										</div>

										<div class="col-xs-12">
											<div class="row">
												<div class="form-group">

													<span class="input input--hoshi">
													<div class="col-lg-2"> 
													<span
															class="input__label-content input__label-content--hoshi">Password</span>
															</div>
															<div class="col-lg-10">
													<input
														class="input__field input__field--hoshi" type="password"
														name="logonPassword" autocomplete="off" /> <label
														class="input__label input__label--hoshi input__label--hoshi-color-1"
														for="logonPassword">
														 
													</label>
													</div>
													</span>

												</div>
											</div>
										</div>
										<div class="col-xs-12">
											<div class="row">
												<div class="col-sm-12">
													<div class="row">
														<div class="form-group">
															<span class="input input--hoshi"> <label
																class="input__label input__label--hoshi input__label--hoshi-color-1"
																for="logonPassword"> <a
																	href="javascript:void(0);" data-toggle="modal"
																	data-target="#myModal3"><span
																		class="btn-block forgot_psw">Forgot
																			Password?</span></a>

															</label>
															</span>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
										<div class="col-lg-6 col-lg-offset-3 col-xs-12">
											
												<div id="loginErrorMsg" class="alert alert-error hide">Wrong
													username or password</div>
												<a href="javascript:void(0);" class=""
													style="position: relative;">
													<button type="submit"
														class="btn btn-block login_btn1"
														onclick="doLogin();">Login</button>
												</a>
											</div>
											 <<%-- div class="col-lg-6 col-lg-offset-3 col-xs-12 new_user_register">
											 	<a data-toggle="modal" href="#myModal1"><p>New User?<span> Register Now </span></p></a>
											 </div> --%>
										</div>
									</form>
								</div>
							</div>

							<div class="row">

								<div class="col-xs-12">
									<%-- <div class="row">
										<div class="col-sm-6">
											<br>
											<div class="form-group">

												<a href="javascript:void(0);" data-toggle="modal"
													data-target="#myModal1"
													class="loginBtn center-block loginBtn--google"> <span
													class="fa fa-envelope-o"></span>Sign Up with Email ID
												</a>

											</div>

										</div> --%>
										  <div class="col-sm-6">
											<br>
											<%-- <div class="form-group">
												<a class="loginBtn center-block loginBtn--facebook"
													href="javascript:void(0);" onclick="loginWithFB11()"> <span
													class="fa fa-facebook"></span> Sign Up with Facebook
												</a>

											</div>
 --%>										</div>  

									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
<!-- 	Login popup ends -->


</body>
</html>