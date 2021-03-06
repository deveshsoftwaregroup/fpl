<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- GOOGLE analytics code starts -->
	<!-- Global site tag (gtag.js) - Google Analytics -->
		<script async src="https://www.googletagmanager.com/gtag/js?id=UA-111448961-1"></script>
		<script>
		  window.dataLayer = window.dataLayer || [];
		  function gtag(){dataLayer.push(arguments);}
		  gtag('js', new Date());
		
		  gtag('config', 'UA-111448961-1');
		</script>
	<!-- Google analytics code ends -->
	

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<script type="text/javascript">
/* window.location.reload(true); */
Cache.Delete();
$('html[manifest=saveappoffline.appcache]').attr('content', '');
</script>
 
<meta http-equiv='pragma' content='no-cache'>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Fantasy League</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="<%=request.getContextPath()%>" />

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="..//WEB-INF/sportmgmt.tld" prefix="s" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<link rel="shortcut icon" type="images/x-icon"
	href="${context}/redBlackTheme/images/favicon.ico">

<link rel="stylesheet" type="text/css"
	href="${context}/redBlackTheme/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${context}/redBlackTheme/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${context}/redBlackTheme/css/jquery.bxslider.css">
<link rel="stylesheet" type="text/css"
	href="${context}/redBlackTheme/css/style-dream.css">
<link rel="stylesheet" type="text/css"
	href="${context}/redBlackTheme/css/theme.css">
<link rel="stylesheet" type="text/css"
	href="${context}/redBlackTheme/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="${context}/redBlackTheme/css/tab-style.css">

<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,600"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,500,600"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:100,300,400,600"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:100,300,400,600,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Oswald:400,500" rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="${context}/redBlackTheme/js/bootstrap.js"></script>
<script src="${context}/redBlackTheme/js/jquery.bxslider.js"></script>
<script src="${context}/redBlackTheme/js/jPushMenu.js"></script>
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<%-- <script src="${context}/redBlackTheme/js/jquery-3.2.1.js" ></script> --%>


<style>
.bx-wrapper .bx-controls-direction a {
	display: none;
}
</style>
<style type="text/css">
.slide-out-div {
	padding: 20px;
	width: 250px;
	background: #fff;
	border-radius: 5px;
	border: 1px solid #ddd;
	z-index: 500000 !important;
	position: absolute;
	right: 10px;
	height: 331px;
}

.slide-out-div textarea.form-control {
	border: 1px solid #ddd;
}
</style>
<script> window._izq = window._izq || []; window._izq.push(["init"]); </script>
<script src="https://cdn.izooto.com/scripts/974898d27dd45be07343e1a8a41e44c462902a47.js"></script>
</head>

<body class="full-bg">
	
	<div id="myModal" class="modal fade" role="dialog">

		<div id="login-overlay" class="modal-dialog loginForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">�</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Login/Register</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-12">
							
							
								<div class="col-xs-12">
										<form id="loginForm" name="LoginForm" action="" method="get"
											onsubmit="event.preventDefault();" autocomplete="off">
											<div class="form-group">
												<div class="col-sm-3">
													<label
														class="input__label input__label--hoshi input__label--hoshi-color-1"
														for="email"> <span
														class="input__label-content input__label-content--hoshi">Email
															ID :</span>
													</label> 
													</div>
													<div class="col-sm-9">
													<input class="input__field input__field--hoshi"
														type="email" name="emailId" autocomplete="off" />

												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-3">
													<span class="input input--hoshi"> <label
														class="input__label input__label--hoshi input__label--hoshi-color-1"
														for="logonPassword"> <span
															class="input__label-content input__label-content--hoshi">Password :</span>
													</label>
													</div>
													<div class="col-sm-9"> 
													<input class="input__field input__field--hoshi"
														type="password" name="logonPassword" autocomplete="off" />

													</span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-12">
													<a href="javascript:void(0);"
														class="btn-block forgot_psw1" data-toggle="modal"
														data-target="#myModal3">Forgot Password?</a>
												</div>
											</div>
											<div class="col-lg-6 col-lg-offset-3 col-xs-12">
											<div  id="loginErrorMsg" class="alert alert-error hide">Wrong
												username or password</div>
											<a href="javascript:void(0);" class=""
												style="position: relative;">
												<button type="submit"
													class="btn btn-block login_btn1"
													onclick="doLogin();">Login</button>
											</a>
											 </div>
											 <div class="col-lg-6 col-lg-offset-3 col-xs-12 new_user_register">
											 	<a data-toggle="modal" href="#myModal1"><p>New User?<span> Register Now </span></p></a>
											 </div>
										</form>
										<div class="row">
											<div class="col-xs-12">
												<div class="row align_pd_top">
													<%-- <div class="col-sm-6">
														<div class="form-group">
															<a href="javascript:void(0);" data-toggle="modal"
																data-target="#myModal1"
																class=" loginBtn loginBtn--google center-block"> <span
																class="fa fa-envelope-o "></span>Sign Up with Google
															</a>
														</div>
													</div> --%>
													<div class="col-sm-6">
														<div class="form-group">
															<a class="loginBtn center-block loginBtn--facebook"
																href="javascript:void(0);" onclick="loginWithFB()">
																<span class="fa fa-facebook"></span> Sign Up with
																Facebook
															</a>
														</div>
													</div>

												</div>
											</div>
										</div>
									</div>
								
							</div>

						</div>

					</div>
				</div>
			</div>
		</div>
	
	


	



	<%-- <div id="myModal2" class="modal fade" role="dialog">
  
	<div id="login-overlay" class="modal-dialog loginForm">
	      <div class="modal-content">
	          <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">�</span><span class="sr-only">Close</span></button>
	          </div>
	          <div class="modal-body">
	              <p align="center" class="button btnSubmit" style="background:none; color:rgba(0,0,102,1); font-size:22px;" >
		         <span class="thanksMsg">Thanks</span>
		         <span class="topThanksMsg">You are registered successfully!</span>
		         <span class="s2">Launching very soon</span>
		         <span class="s3">The12thMan Fantasy League !</span>
		         <span class="bottomMsg"> <BR>Till then<BR>Visit our blog at <a href="http://the12thman.in/">THE TWELFTH MAN TIMES</a></span></p>
	          </div>
	      </div>
	  </div>
</div> --%>

	<div id="myModal3" class="modal fade" role="dialog">
		<div id="login-overlay" class="modal-dialog loginForm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">�</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Forgot Password</h4>
				</div>
				<div class="modal-body">

					<form name="ResetPassForm" class="reserForm"
						action="user/forgotPassword" method="get">
						<div class="form-group">
							<input type="email" name="emailId"
								placeholder="Enter your Email ID" required id="email"
								class="form-control" />
						</div>
						<div class="form-group">
							<div align="center">
								<a href="javascript:void(0);" class="button-lrg"
									onclick="resetPassword();"><input id="resetBtn"
									type="button" class="btn btn-primary" value="Send Password"></a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 top-bnr-mobile">
				<img src="${context}/redBlackTheme/images/simple-bannr.png"
					class="img-responsive"> 
					<%-- <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
									<!-- justthinksports_homepage_top -->
									<ins class="adsbygoogle"
									     style="display:inline-block;width:728px;height:90px"
									     data-ad-client="ca-pub-9891586352099803"
									     data-ad-slot="3401696803"></ins>
									<script>
									(adsbygoogle = window.adsbygoogle || []).push({});
									</script> --%>
			
			</div>
			<div
				class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1  marg_top">
				<div class="row top_header">
					<div class="col-lg-12">
						<ul>
							<li class="flex-item"><img
								src="${context}/redBlackTheme/images/logo.png"
								class="img-responsive "></li>
							<li class="pwr_text flex-item"></li>
							<li class="flex-item"><img src=""
								class="img-responsive pwr_logo"></li>
							<li class="flex-item">
							<%-- <img
								src="${context}/redBlackTheme/images/simple-bannr.png"
								class="img-responsive pull-right"> --%>
								<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
									<!-- justthinksports_homepage_top -->
									<ins class="adsbygoogle"
									     style="display:inline-block;width:728px;height:90px"
									     data-ad-client="ca-pub-9891586352099803"
									     data-ad-slot="3401696803"></ins>
									<script>
									(adsbygoogle = window.adsbygoogle || []).push({});
									</script>
								</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<header>
		<div class="row">
			<div class="col-lg-1 col-sm-1">
				<div class="left_img">
					<%-- <img src="${context}/redBlackTheme/images/left_image.png"> --%>
					
					<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- justthinksports_homepage_left_sidebar -->
						<ins class="adsbygoogle"
    					 style="display:inline-block;width:120px;height:600px"
    					 data-ad-client="ca-pub-9891586352099803"
     					data-ad-slot="4098742947"></ins>
					<script>
						(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
					
						<br><br>
						
					<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- justhinksports_homepage_left_sidebar2 -->
					<ins class="adsbygoogle"
					     style="display:inline-block;width:120px;height:600px"
					     data-ad-client="ca-pub-9891586352099803"
					     data-ad-slot="5792766864"></ins>
					<script>
						(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
				</div>
			</div>
			<div class="col-lg-10 col-md-10 col-sm-10  ">
				<nav class="navbar ">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button"
							class="navbar-toggle toggle-menu menu-left jPushMenuBtn menu-active"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
					</div>
					<div
						class="collapse navbar-collapse cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<!--  Close Btn -->
                 <button type="button" class="navbar-toggle manu_close_btn toggle-menu menu-left jPushMenuBtn menu-active" data-toggle="collapse">X</button>
                   <!-- / Close Btn -->
							<%-- <li class="active"><a href="javascript:void(0);"
								onclick="openHomeHome();">HOME</a></li>
							<li><a href="javascript:void(0);" onclick="homeGuide();">GUIDE</a></li>
							<li><a target="_blank" href="http://the12thman.in/">BLOG</a></li>

							<c:choose>
								<c:when test="${not empty sessionScope.user.displayName}">
									<li><a href="" data-toggle="modal" data-target="#myModal1">FANTASY
											LEAGUE</a></li>
									<li><a href="${context}/mvc/user11/UserLanding11">PREDICT
											11</a></li>
									<li><a href="${context}/mvc/user/Logout">SIGN OUT</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="" data-toggle="modal" data-target="#myModal1">FANTASY
											LEAGUE</a></li>
									<li><a href="" data-toggle="modal"
										data-target="#myModal11">PREDICT 11</a></li>
										</c:otherwise>
							</c:choose> --%>
									<li><a href="" data-toggle="modal"
										data-target="#vendor-login">SIGN IN</a></li>

						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="get_in_touch"><a href="" data-toggle="modal"
								data-target="#myModalVendor"> REGISTER</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-lg-1  col-sm-1">
				<div class="right_img">
					<%-- <img src="${context}/redBlackTheme/images/left_image.png"> --%>
					
					<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
					<!-- justthinksports_homepage_right_sidebar -->
					<ins class="adsbygoogle"
					     style="display:inline-block;width:120px;height:600px"
					     data-ad-client="ca-pub-9891586352099803"
					     data-ad-slot="1178023996"></ins>
					<script>
					(adsbygoogle = window.adsbygoogle || []).push({});
					</script>
					<br><br>
					<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
						<!-- justthinksports_homepage_rightsidebar2 -->
						<ins class="adsbygoogle"
						     style="display:inline-block;width:120px;height:600px"
						     data-ad-client="ca-pub-9891586352099803"
						     data-ad-slot="7568882961"></ins>
						<script>
						(adsbygoogle = window.adsbygoogle || []).push({});
						</script>
				</div>
			</div>
			</nav>
		</div>
		</header>

    



		<script>
			function redirectToLeague() {
				window.location = "user/UserLanding";
			}
			function redirectToLeague11() {
				window.location = "user11/UserLanding11";
			}
			function homeGameGuide() {
				window.location = "HomeGameGuide";
			}
			function homeGuide() {
				window.location = "HomeGuide";
			}
			function openHomeHome() {
				window.location = "LeagueLandingHome";
			}
			function submitFormVendor() {
				var regForm = document.forms['RegisterVendorForm'];
				if (typeof regForm['displayName'] == 'undefined'
						|| regForm['displayName'].value == '') {
					showNotification("Please enter your Name");
					return false;
				}
				if (typeof regForm['emailId'] == 'undefined'
						|| regForm['emailId'].value == '') {
					showNotification("Please enter Email ID");
					return false;
				}
				var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
						.test(regForm['emailId'].value);
				if (!isEmailValid) {
					showNotification("Email ID is not valid");
					return false;
				}
				if (typeof regForm['logonPassword'] == 'undefined'
						|| regForm['logonPassword'].value == '') {
					showNotification("Please enter password");
					return false;
				}
				if (typeof regForm['logonPasswordConfirm'] == 'undefined'
						|| regForm['logonPasswordConfirm'].value != regForm['logonPassword'].value) {
					showNotification("Password and Confirm Password is not same");
					return false;
				}

				if (typeof regForm['contactNumber'] != 'undefined') {
					var mobNumVal = regForm['contactNumber'].value;
					if (!(mobNumVal.length == 10 && /^\d+$/.test(mobNumVal))) {
						showNotification('Please enter valid mobile number');
						return false;
					}
				}
				regForm.submit();
			}
			function submitRSForm() {
				var resetPassForm = document.forms['ResetPassForm'];
				if (typeof resetPassForm['emailId'] == 'undefined'
						|| resetPassForm['emailId'].value == '') {
					showNotification("Please enter Email ID");
					return false;
				}
				var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
						.test(resetPassForm['emailId'].value);
				if (!isEmailValid) {
					showNotification("Email ID is not valid");
					return false;
				}
				resetPassForm.submit();
			}
			function resetPassword() {
				var resetPassForm = document.forms['ResetPassForm'];
				if (typeof resetPassForm['emailId'] == 'undefined'
						|| resetPassForm['emailId'].value == '') {
					showNotification("Please enter Email ID");
					return false;
				}
				var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
						.test(resetPassForm['emailId'].value);
				if (!isEmailValid) {
					showNotification("Email ID is not valid");
					return false;
				}
				var url = "user/resetPassword?emailId="
						+ resetPassForm['emailId'].value;
				$.ajax({
					url : url,
					dataType : 'text',
					success : function(resp) {
						showNotification(resp);
					},
					error : function(req, status, err) {
						console.log('something went wrong', status, err);
					}
				});
			}
			function doLogin() {
				var loginForm = document.forms['LoginForm'];
				if (typeof loginForm['emailId'] == 'undefined'
						|| loginForm['emailId'].value == '') {
					return false;
				}
				var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
						.test(loginForm['emailId'].value);
				if (!isEmailValid) {
					return false;
				}
				if (typeof loginForm['logonPassword'] == 'undefined'
						|| loginForm['logonPassword'].value == '') {
					return false;
				}

				//alert(loginForm['emailId']);
				var url = "vendor/validate?logonId=" + loginForm['emailId'].value
						+ "&logonPassword=" + loginForm['logonPassword'].value
				$.ajax({
					url : url,
					dataType : 'json',
					success : function(resp) {
						if (resp.isValidUser) {
							window.location = "vendor/login/" + resp.vendorId;
						} else {
							showNotification(resp.errorMessage);
						}
					},
					error : function(req, status, err) {
						console.log('something went wrong', status, err);
					}
				});
			}
			function doLogin11() {
				var loginForm = document.forms['LoginForme'];
				if (typeof loginForm['emailId'] == 'undefined'
						|| loginForm['emailId'].value == '') {
					return false;
				}
				var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
						.test(loginForm['emailId'].value);
				if (!isEmailValid) {
					return false;
				}
				if (typeof loginForm['logonPassword'] == 'undefined'
						|| loginForm['logonPassword'].value == '') {
					return false;
				}

				//alert(loginForm['emailId']);
				var url = "user/validate?logonId=" + loginForm['emailId'].value
						+ "&logonPassword=" + loginForm['logonPassword'].value
				$.ajax({
					url : url,
					dataType : 'json',
					success : function(resp) {
						console.log(resp);
						if (resp.isValidUser)

						{
							window.location.href = "user11/login11/"
									+ resp.userId;
						} else {
							showNotification(resp.errorMessage);
						}
					},
					error : function(req, status, err) {
						console.log('something went wrong', status, err);
					}
				});
			}
		</script>

		<script>
			$(document)
					.ready(
							function() {
								var popup = new Foundation.Reveal(
										$('#exampleModal3'));
								popup.open();
								Foundation.libs.reveal.locked = true;
								$('#exampleModal3').data('revealInit').close_on_background_click = false
								$('#exampleModal3').data('revealInit').close_on_esc = false
								$('.more-menu').click(function() {
									$(this).children('ul').slideToggle('fast');
								})

								$('#menuicon').on('click', function(event) {
									event.preventDefault();
									$('body').toggleClass('rightMenuOpen');
								});
							});
			$(function() {
				$(window).scroll(function() {
					var scroll = $(window).scrollTop();

					if (scroll >= 40) {
						$('#topLayer').addClass('fixed');
						$('#menuicon').addClass('movetop');

						$('#logoMain #dlogo').hide(300, function() {
							$('#logoMain #mlogo').show(300)
						});
						$('#logoMain').addClass('mobileLogo');

					} else {
						$('#topLayer').removeClass('fixed');
						$('#menuicon').removeClass('movetop');

						$('#logoMain #mlogo').hide(300, function() {
							$('#logoMain #dlogo').show(300)
						});

						$('#logoMain').removeClass('mobileLogo');

					}
				});
			});

			function aa() {
				$('.euro-divider hr').css('width', '100%');

			}
			$(window).bind("load", function() {
				aa();

				$('#fbox1').animate({
					left : '0'
				}, 4000);
				$('#fbox2').animate({
					right : '-301px'
				}, 2000);
			});

			function loginWithFB() {

				window.location = "../mvc/social/facebook/signin";

			}
			function loginWithFB11() {

				window.location = "../mvc/social/facebook/dream_eleven_signin";

			}
		</script>


		<script type="text/javascript">
			<script>(
					function() {
						if (!String.prototype.trim) {
							(function() {
								// Make sure we trim BOM and NBSP
								var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
								String.prototype.trim = function() {
									return this.replace(rtrim, '');
								};
							})();
						}

						[].slice
								.call(
										document
												.querySelectorAll('input.input__field'))
								.forEach(
										function(inputEl) {
											// in case the input is already filled..
											if (inputEl.value.trim() !== '') {
												classie.add(inputEl.parentNode,
														'input--filled');
											}

											// events:
											inputEl.addEventListener('focus',
													onInputFocus);
											inputEl.addEventListener('blur',
													onInputBlur);
										});

						function onInputFocus(ev) {
							classie.add(ev.target.parentNode, 'input--filled');
						}

						function onInputBlur(ev) {
							if (ev.target.value.trim() === '') {
								classie.remove(ev.target.parentNode,
										'input--filled');
							}
						}
					})();

			$(document)
					.ready(
							function() {
								$('.main_nav')
										.click(
												function() {
													$('#loginForm')
															.find(
																	"input[type=text],input[type=password], input[type=email], textarea")
															.val("");
												})

								$('.resetBtn').click(function() {
									$('.reserForm').hide('slow');
									$('.rsuccessBox').show('slow');
								})

							});
		</script>
		<script>
			$(document).ready(function() {
				$('.bxslider').bxSlider({
					auto : true

				});
			});
		</script>
		<script>
			$(document).ready(function() {
				$('.bxslider_1').bxSlider({
					auto : true,
					autoControls : true
				});

			});
		</script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.toggle-menu').jPushMenu({
					closeOnClickLink : true,
					closeOnClickOutside : false
				});
			});
		
			
		</script>