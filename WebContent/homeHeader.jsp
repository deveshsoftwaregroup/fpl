<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<!--  <link rel="stylesheet" href="/SportMgmt/css/foundation.css"> -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>The 12th Man League</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %>  
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet" type="text/css" href="/SportMgmt/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/SportMgmt/assets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/SportMgmt/assets/css/animate.css">
<link rel="stylesheet" type="text/css" href="/SportMgmt/assets/css/theme.css">
<link rel="stylesheet" type="text/css" href="/SportMgmt/assets/css/style.css">
<!--[if lt IE 9]>
<script src="assets/js/html5shiv.min.js"></script>
<script src="assets/js/respond.min.js"></script>
<![endif]-->

<style>
.successBox{ display: none;}
.form-control{ border-radius:0px;}
.modal-dialog.loginForm{ width: 100%;
    max-width: 560px;}
.loginForm .modal-content{background:rgba(255,255,255,1);-webkit-background-size:cover;-moz-background-size:cover;-o-background-size:cover;background-size:cover;border-radius:0;padding:5px 10px;border:none}
.loginForm .modal-header{min-height:16.43px;padding:15px;border-bottom:none;text-align:center}
.loginForm .modal-title{margin:0;line-height:1.42857143;font-size:23px;letter-spacing:1px;font-weight:400;text-transform:uppercase;padding:6px 2px;color:#20295b;text-shadow:none}
.loginForm .modal-header .close{color:#fff;opacity:1;font-size:24px;padding:6px;border-radius:50%;width:35px;height:35px;position:absolute;top:-16px;right:-16px;background:#D94B51;text-shadow:none;-webkit-font-smoothing:antialiased;font-weight:300;outline:none!important;-webkit-transition:all 600ms ease-in-out;-moz-transition:all 600ms ease-in-out;-ms-transition:all 600ms ease-in-out;-o-transition:all 600ms ease-in-out;transition:all 600ms ease-in-out}
.loginForm .modal-header .close:hover{background:#fff;color:#D94B51}

#name{background-image:url(images/user-silhouette.png)}
#email{background-image:url(images/email-filled-closed-envelope.png)}
#password,#password2{background-image:url(images/key.png)}
.register-button:focus{outline:0}
.register-switch{height:37px;margin-bottom:0;padding:0;background:#d7d7d7;border-radius:0}
.register-switch-input{display:none}
.register-switch-label{float:left;width:50%;line-height:30px;color:#585858;text-align:center;cursor:pointer; border: solid 1px #d7d7d7;}
.register-switch-input:checked + .register-switch-label{font-weight:400;color:#585858;border-radius:0; border: solid 1px #ec5840;}
[type='radio'] + label{padding:3px;margin-left:0;margin-right:0;margin-bottom:0;vertical-align:baseline}
   
    
	@keyframes colorChange {
	0% {
        background: rgba(27, 117, 188, .8);   
		border-color:rgba(27, 117, 188, .8);
    }
    20% {
        background: rgba(14, 117, 112, .8);
		border-color: rgba(14, 117, 112, .8);
    }
    40% {
        background: rgba(101, 17, 111, .8);
		border-color: rgba(101, 17, 111, .8);
    }
    60% {
        background: rgba(27, 117, 188, .8);   
		border-color:rgba(27, 117, 188, .8);
    }
    80% {
        background: rgba(14, 117, 112, .8);
		border-color: rgba(14, 117, 112, .8);   
    }
    100% {
        background: rgba(101, 17, 111, .8);
		border-color: rgba(101, 17, 111, .8); 
    }
}
	
	
@keyframes scale {
  0% {
    transform: scale(.9);
    opacity: .5;
  }
  100% {
    transform: scale(1);
    opacity: 1;
  }
}
	
.mask{ background: #000; opacity: 0.5; position:fixed; top: 0; left: 0; width: 100%; height:100%;z-index;9000;}
@media (min-width: 768px){
	#myModal1 .modal-dialog {
	    width: 420px;
	}
}

.forgotBtn{    text-decoration: none;
    color: #2f2f2f;
    color: #a7a7a7;
    font-style: italic;
    text-transform: lowercase;
    font-size: 13px;
    position: relative;
    padding-bottom: 5px;    
    /* line-height: 25px; */}
    
    .forgotBtn:hover:after{ position: absolute; content: ''; height: 1px; width: 100%; background: #D94B51; left:0; bottom:0;}
#resetBtn{ width: 100%; border-color: rgba(0, 0, 0, 0);background-color: #3b5998;color: #fff; text-align: center;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    font-size: 13px;}
.btn-block + .btn-block {
    margin-top: 5px;
}
.btn-facebook {
    color: #fff;
    background-color: #3b5998;
    border-color: rgba(0, 0, 0, 0);
}
.btn-login{  color: #fff;
    background-color: #D94B51;
    border-color: rgba(0, 0, 0, 0);}

.btn-social {
    position: relative;
    padding-left: 44px;
    text-align: center;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    font-size: 13px;
}
.btn-block {
    display: block;
    width: 100%;
}

.btn-social :first-child {
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
    width: 42px;
    font-weight: 400;
    line-height: 40px;
    font-size: 16px;
    text-align: center;
    border-right: 1px solid rgb(255, 255, 255);
}

/* button design */
.input {
	position: relative;
	z-index: 1;
	display: inline-block;
	margin: 0em;
	max-width: 100%;
	width: calc(100%);
	vertical-align: top;
}

.input__field {
	position: relative;
	display: block;
	float: right;
	padding: 0.8em;
	width: 60%;
	border: none;
	border-radius: 0;
	background: #f0f0f0;
	color: #aaa;
	font-weight: bold;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	-webkit-appearance: none; /* for box shadows to show on iOS */
}

.input__field:focus {
	outline: none;
}

.input__label {
	display: inline-block;
	float: right;
	padding: 0 1em;
	width: 40%;
	color: #6a7989;
	font-weight: 400;
	font-size: 95%;
	-webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

.input__label-content {
	position: relative;
	display: block;
	padding: 7px 0;
	width: 100%;
}

.graphic {
	position: absolute;
	top: 0;
	left: 0;
	fill: none;
}

.icon {
	color: #ddd;
	font-size: 150%;
}

/* Individual styles */


/* Hoshi */
.input--hoshi {
	overflow: hidden;
}

.input__field--hoshi {
	margin-top: 1em;
	padding: 0.85em 0.15em;
	width: 100%;
	background: transparent;
	color: #595F6E;
}

.input__label--hoshi {
	position: absolute;
	bottom: 0;
	left: 0;
	padding: 0 0.25em;
	width: 100%;
	height: calc(100% - 1em);
	text-align: left;
	pointer-events: none;
}

.input__label-content--hoshi {
	position: absolute;
}

.input__label--hoshi::before,
.input__label--hoshi::after {
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: calc(100% - 10px);
	border-bottom: 1px solid #B9C1CA;
}

.input__label--hoshi::after {
	margin-top: 2px;
	border-bottom: 4px solid #00aaff;
	-webkit-transform: translate3d(-100%, 0, 0);
	transform: translate3d(-100%, 0, 0);
	-webkit-transition: -webkit-transform 0.3s;
	transition: transform 0.3s;
}

.input__label--hoshi-color-1::after {
	border-color: hsl(200, 100%, 50%);
}

.input__label--hoshi-color-2::after {
	border-color: hsl(160, 100%, 50%);
}

.input__label--hoshi-color-3::after {
	border-color: hsl(20, 100%, 50%);
}

.input__field--hoshi:focus + .input__label--hoshi::after,
.input--filled .input__label--hoshi::after {
	-webkit-transform: translate3d(0, 0, 0);
	transform: translate3d(0, 0, 0);
}

.input__field--hoshi:focus + .input__label--hoshi .input__label-content--hoshi,
.input--filled .input__label-content--hoshi {
	-webkit-animation: anim-1 0.3s forwards;
	animation: anim-1 0.3s forwards;
}

@-webkit-keyframes anim-1 {
	50% {
		opacity: 0;
		-webkit-transform: translate3d(1em, 0, 0);
		transform: translate3d(1em, 0, 0);
	}
	51% {
		opacity: 0;
		-webkit-transform: translate3d(-1em, -40%, 0);
		transform: translate3d(-1em, -40%, 0);
	}
	100% {
		opacity: 1;
		-webkit-transform: translate3d(0, -40%, 0);
		transform: translate3d(0, -40%, 0);
	}
}

@keyframes anim-1 {
	50% {
		opacity: 0;
		-webkit-transform: translate3d(1em, 0, 0);
		transform: translate3d(1em, 0, 0);
	}
	51% {
		opacity: 0;
		-webkit-transform: translate3d(-1em, -40%, 0);
		transform: translate3d(-1em, -40%, 0);
	}
	100% {
		opacity: 1;
		-webkit-transform: translate3d(0, -40%, 0);
		transform: translate3d(0, -40%, 0);
	}
}

input:-webkit-autofill {
    -webkit-box-shadow: 0 0 0 1000px white inset !important;
}

</style>
</head>

<body>



<div id="myModal" class="modal fade" role="dialog">
  
	<div id="login-overlay" class="modal-dialog loginForm">
	      <div class="modal-content">
	          <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	              <h4 class="modal-title" id="myModalLabel">Login Form</h4>
	          </div>
	          <div class="modal-body">
	              <div class="row">
	                  <div class="col-xs-12">
	                  
	                  <div class="col-xs-12">
	                  	<div class="row">
	                  	
	                  	     
	                          <form id="loginForm" name="LoginForm" action="" method="get" onsubmit="event.preventDefault();" autocomplete="off">
	                              
	                              <div class="col-xs-12">
	                              	<div class="row">
		                              <div class="form-group">
		                              
			                              <span class="input input--hoshi">
			                              	<input class="input__field input__field--hoshi" type="email" name="emailId" autocomplete="off" />
			                              	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="email">
			                              		<span class="input__label-content input__label-content--hoshi">Email ID</span>
			                              	</label>
			                              </span>
		                              	                              		
		                              </div>
		                             </div>
	                              </div>
	                              
	                              <div class="col-xs-12">
		                              	<div class="row">	                              
			                              <div class="form-group">
			                              
			                              	<span class="input input--hoshi">
				                              	<input class="input__field input__field--hoshi" type="password" name="logonPassword"  autocomplete="off" />
				                              	<label class="input__label input__label--hoshi input__label--hoshi-color-1" for="logonPassword">
				                              		<span class="input__label-content input__label-content--hoshi">Password</span>
				                              	</label>
				                              </span>
				                              		                                  
			                              </div>	                              
		                              </div>
	                              </div>
	                              
	                              <div class="col-xs-12">
	                              	<div class="row">
	                              		
	                              			<div class="col-sm-6 hide">
	                              				
	                              				<div class="checkbox hide">
				                                  <label>
				                                      <input type="checkbox" name="remember" id="remember"> Remember login
				                                  </label>
				                                  <p class="help-block">(if this is a private computer)</p>
				                              </div>
	                              				
	                              			</div>
	                              			<div class="col-sm-12">
		                              			<div class="row">
			                              			<div class="form-group">
			                              				<a href="javascript:void(0);" class="forgotBtn" data-toggle="modal" data-target="#myModal3">Forgot Password</a>
			                              			</div>
		                              			</div>
	                              			</div>
	                              		
		                            </div>
		                         </div>
		                         
		                         <div class="col-xs-12">
		                         <div class="row">
		                         
	                              
	                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username or password</div>
	                              
	                              <a href="javascript:void(0);" class="" style="position: relative;">
				             	
	                              <button type="submit" class="btn btn-block btn-social btn-login" onclick="doLogin();">Login</button>
	                              </a>
	                              </div>
	                              </div>
	                               
	                          </form>
	                      
	                  	</div>
	                  </div>
	                  
	                  <div class="row">
	                  
	                  	<div class="col-xs-12">
	                  		<div class="row">
	                  			<div class="col-sm-6">
	                  				
	                  					<div class="form-group">
	                  					
	                  				<a href="javascript:void(0);" data-toggle="modal" data-target="#myModal1" class="btn btn-block btn-social btn-info">
	                  					<span class="fa fa-envelope-o"></span>Register with Email ID!
	                  				</a>
	                  				
	                  				</div>
	                  	
	                  			</div>
	                  			<div class="col-sm-6">
	                  				
	                  					<div class="form-group">
	                  				<a class="btn btn-block btn-social btn-facebook" href="javascript:void(0);" onclick="loginWithFB()">
	                  					<span class="fa fa-facebook"></span> Sign in with Facebook
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

<div id="myModal1" class="modal fade" role="dialog">
  
	<div id="login-overlay" class="modal-dialog loginForm">
	      <div class="modal-content">
	          <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	              <h4 class="modal-title" id="myModalLabel">Signup</h4>
	          </div>
	          <div class="modal-body">
	              <form name="RegisterForm" action="user/register" method="post">
		  <div class="form-group">
		        <input type="text" name="displayName" placeholder="Name" required id="name" class="form-control" />
		   </div>
		   <div class="form-group">
		       <input type="email" name="emailId" placeholder="Email / Login ID" required id="email" class="form-control" />
		   </div>
		   <div class="form-group">
		       <input type="password" name="logonPassword" placeholder="Password" required id="password" class="form-control" />
		   </div>
		   <div class="form-group">
		       <input type="password" name="logonPasswordConfirm" placeholder="Confirm Password" required id="password2" class="form-control" />
		   </div>
		  <div class="form-group">
		       <select name="country" placeholder="Mobile Number" required id="country" class="form-control">
		       <option value="">Select Country</option>
		       <c:forEach var="countryObj" items="${countryMap}">
		       <option value="${countryObj.key}">${countryObj.key}</option>
		       </c:forEach>
		       </select>
		   </div>  
        <div class="form-group">
            <input type="input" name="contactNumber" placeholder="Mobile Number" required  id="contactNumber" class="form-control" />
        </div>
        <div class="form-group">
            <div class="register-switch">
                <input type="radio" name="gender" value="F" id="sex_f" class="register-switch-input"
                    checked="">
                <label for="sex_f" class="register-switch-label">
                    Female</label>
                <input type="radio" name="gender" value="M" id="sex_m" class="register-switch-input">
                <label for="sex_m" class="register-switch-label">
                    Male</label>
            </div>
        </div>   
        <div class="form-group">            
            <div align="center">
                <a href="javascript:void(0);" class="button-lrg" onclick="submitForm();" style="display: block;"><input type="button" class="btn btn-primary btn-block btn-social btn-facebook"  value="REGISTER"></a>
            </div> 
            <div align="center">
            	
            	
            	<a class="btn btn-block btn-social btn-facebook" href="javascript:void(0);"  onclick="loginWithFB()";>
	                  					<span class="fa fa-facebook"></span> Sign in with Facebook
	                  				</a>
            	
            </div>
        </div>
    </form>
	          </div>
	      </div>
	  </div>
</div>

<div id="myModal2" class="modal fade" role="dialog">
  
	<div id="login-overlay" class="modal-dialog loginForm">
	      <div class="modal-content">
	          <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
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
</div>

<div id="myModal3" class="modal fade" role="dialog">
  	<div id="login-overlay" class="modal-dialog loginForm">
	      <div class="modal-content">
	          <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	              <h4 class="modal-title" id="myModalLabel">Forgot Password</h4>
	          </div>
	          <div class="modal-body">
	          
	          <form name="ResetPassForm" class="reserForm" action="user/forgotPassword" method="get">
				   <div class="form-group">
				       <input type="email" name="emailId" placeholder="Enter your Email ID" required id="email" class="form-control" />
				   </div>
				  <div class="form-group">            
		            <div align="center">
		                <a href="javascript:void(0);" class="button-lrg" onclick="submitRSForm();"><input id="resetBtn" type="button" class="btn btn-primary" value="Send Password"></a>
		            </div> 
		          </div>
		       </form>
		       
		       <div class="successBox">
		       		<div class="col-xs-12">
		       			<div class="form-group">
		       				<p>
		       				hello ..
		       				</p>
		       			</div>
		       		</div>
		       </div>
		    
		    
	       </div>
	      </div>
	  </div>
</div>

<%-- <div class="reveal medium" id="exampleModal3" data-reveal>
     <div class="large-12 column text-center">
         <!--<p align="center" class="button btnSubmit" style="background:none; color:rgba(0,0,102,1); font-size:22px;" >
         <span class="thanksMsg">Thanks</span>
         <span class="topThanksMsg">${message}${message1}</span><span>${message2}</span></span><span>${message3} &nbsp; ${message4} <a href="http://the12thman.in">${message5}</a>  </span></p>-->
         
         <p align="center" class="button btnSubmit" style="background:none; color:rgba(0,0,102,1); font-size:22px;" >
         <span class="thanksMsg">Thanks</span>
         <span class="topThanksMsg">You are registered successfully!</span>
         <span class="s2">Launching very soon</span>
         <span class="s3">The12thMan Fantasy League !</span>
         <span class="bottomMsg"> <BR>Till then<BR>Visit our blog at <a href="http://the12thman.in/">THE TWELFTH MAN TIMES</a></span></p>
     </div>
     <button class="close-button" type="button" data-close="">×</button>
</div> --%>   


<div id="preloader">
  <div id="status">&nbsp;</div>
</div>
<a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
<div class="container">
<header id="header">
    <div class="row">
      <div class="col-lg-12 col-md-12 col-sm-12">
        <div class="header_bottom">
          <div class="logo_area" ><a href="http://the12thman.in" target="_blank" class="logo"><img src="/SportMgmt/images/logo.png" alt="" height="92" width="92">
          <span>The 12th Man <span>League</span></span>
          </a></div>
          <div class="add_banner"><a href="#"><img src="/SportMgmt/images/addbanner_728x90_V1.jpg" alt=""></a></div>
        </div>
      </div>
    </div>
</header>
<section id="newsSection">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <div class="latest_newsarea"> <span>Our Partners</span>
          <ul id="ticker01" class="news_sticker">
            <li><a href="#"><img src="/SportMgmt/images/soccer-loader.gif" alt=""></a></li>
            <li><a href="" target="_blank"><img src="/SportMgmt/images/news_thumbnail2.jpg" alt=""></a></li>    
            <li><a href="http://www.the12thman.in" target="_blank"><img src="/SportMgmt/images/logo.png" alt=""></a></li>  
            <li><a href="#"><img src="/SportMgmt/images/photograph_img2.jpg" alt=""></a></li>  
            <li><a href="#"><img src="/SportMgmt/images/img-1.jpg" alt=""></a></li>  
            <li><a href="#"><img src="/SportMgmt/images/img-2.jpg" alt=""></a></li>    
             <li><a href="#"><img src="/SportMgmt/images/football-1.png" alt=""></a></li>
            <li><a href="" target="_blank"><img src="/SportMgmt/images/news_thumbnail2.jpg" alt=""></a></li>    
            <li><a href="http://www.the12thman.in" target="_blank"><img src="/SportMgmt/images/logo.png" alt=""></a></li>  
            <li><a href="#"><img src="/SportMgmt/images/photograph_img2.jpg" alt=""></a></li>  
            <li><a href="#"><img src="/SportMgmt/images/img-1.jpg" alt=""></a></li>  
            <li><a href="#"><img src="/SportMgmt/images/img-2.jpg" alt=""></a></li>                  
          </ul>          
        </div>
      </div>
    </div>
</section>
  
<section id="navArea">
    <nav class="navbar navbar-inverse" role="navigation">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav main_nav" style=" width: 100%;">
          <li class="active"><a href="javascript:void(0);" onclick="openHomeHome();"><span class="fa fa-home desktop-home"></span><span class="mobile-show">Home</span></a></li>
          <li><a href="javascript:void(0);" onclick="homeGameGuide();">Game Guide</a></li> 
          <li><a target="_blank "href="http://the12thman.in/">Blog</a></li>               
          <c:if test="${empty sessionScope.user.displayName}">
	         <li><a href="javascript:void(0);" data-toggle="modal" data-target="#myModal">Log in</a></li>           
	         <li><a href="javascript:void(0);" data-toggle="modal" data-target="#myModal1">Sign Up</a></li> 
          </c:if> 
          <c:if test="${not empty sessionScope.user.displayName}">
          	<li><a href="/SportMgmt/mvc/user/Logout">Log out</a></li>
          </c:if> 
          <c:if test="${not empty sessionScope.user.displayName}">
          <li style="float:right; color:#ffffff; padding-top: 13px;">Welcome <font color="blue">  ${sessionScope.user.displayName}</font></li>
          </c:if>
        </ul>
        
        
      </div>
    </nav>
</section>

<section id="newsSection">
    <div class="row">
      <div class="col-lg-12 col-md-12">
        <div class="latest_newsarea"> <span>Ongoing/Upcoming Leagues</span>
          <ul id="ticker01" class="news_sticker">
            <li><a href="#"><img src="/SportMgmt/images/news_thumbnail3.jpg" alt="">Fantasy League</a></li>
            <li><a href="http://www.google.co.in" target="_blank"><img src="/SportMgmt/images/news_thumbnail3.jpg" alt="">Double your money</a></li>    
            <li><a href="#"><img src="/SportMgmt/images/news_thumbnail3.jpg" alt="">Predict top 11</a></li>  
            <li><a href="#"><img src="/SportMgmt/images/news_thumbnail3.jpg" alt="">Player with highest no of goals</a></li>  
            <li><a href="#"><img src="" alt=""></a>.</li>  
            <li><a href="#"><img src="" alt=""></a>.</li>                  
          </ul>
          <div class="social_area">
            <ul class="social_nav">
              <li class="facebook"><a href="https://www.facebook.com/the12thman.in/" target="_blank"></a></li>
              <li class="twitter"><a href="https://twitter.com/the12thmantimes" target="_blank"></a></li>              
              <li class="googleplus"><a href="https://plus.google.com/105539643606954415470" target="_blank"></a></li>
              <li class="youtube"><a href="#"></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
</section>
  
<script>
	function redirectToLeague()
	{
		window.location="user/UserLanding";
		//window.open("http://localhost:7979/SportMgmt/mvc/user/UserLanding?isLogined=true");
	}
	function homeGameGuide()
	{
		window.location="HomeGameGuide";
	}
	function openHomeHome()
	{
		window.location="LeagueLandingHome";
	}
    function submitForm()
    {
    	var regForm = document.forms['RegisterForm'];
    	if(typeof regForm['displayName'] == 'undefined' || regForm['displayName'].value=='')
    	{
    		alert("Please enter your Name");
    		return false;
    	}
    	if(typeof regForm['emailId'] == 'undefined' || regForm['emailId'].value=='')
    	{
    		alert("Please enter Email ID");
    		return false;
    	}
    	var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(regForm['emailId'].value);
    	if(!isEmailValid)
   		{
    		alert("Email ID is not valid");
    		return false;
   		}
    	if(typeof regForm['logonPassword'] == 'undefined' || regForm['logonPassword'].value =='')
    	{
    		alert("Please enter password");
    		return false;
    	}
    	if(typeof regForm['logonPasswordConfirm'] == 'undefined' || regForm['logonPasswordConfirm'].value !=regForm['logonPassword'].value)
    	{
    		alert("Password and Confirm Password is not same");
    		return false;
    	}
    	
    	if(typeof regForm['contactNumber'] != 'undefined')
    	{
    		var mobNumVal = regForm['contactNumber'].value;
    		if(!(mobNumVal.length ==10 &&  /^\d+$/.test(mobNumVal)))
   			{
    			alert('Please enter valid mobile number');
    			return false;
   			}
    	}
    	regForm.submit();
 }
    function submitRSForm()
    {
    	var resetPassForm = document.forms['ResetPassForm'];
    	if(typeof resetPassForm['emailId'] == 'undefined' || resetPassForm['emailId'].value=='')
    	{
    		alert("Please enter Email ID");
    		return false;
    	}
    	var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(resetPassForm['emailId'].value);
    	if(!isEmailValid)
   		{
    		alert("Email ID is not valid");
    		return false;
   		}
    	resetPassForm.submit();
 }
function doLogin()
{
	var loginForm = document.forms['LoginForm'];
	if(typeof loginForm['emailId'] == 'undefined' || loginForm['emailId'].value=='')
	{
		return false;
	}
	var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(loginForm['emailId'].value);
	if(!isEmailValid)
	{
		return false;
	}
	if(typeof loginForm['logonPassword'] == 'undefined' || loginForm['logonPassword'].value =='')
	{
		return false;
	}
	
	//alert(loginForm['emailId']);
	var url = "user/validate?logonId="+loginForm['emailId'].value+"&logonPassword="+loginForm['logonPassword'].value
	$.ajax({
		  url: url,
		  dataType: 'json',
		  success: function( resp ) {
			  if(resp.isValidUser)
			  {
				  window.location="user/login/"+resp.userId;
			  }
			  else
			  {
			  	alert(resp.errorMessage);
			  }
		  },
		  error: function( req, status, err ) {
		    console.log( 'something went wrong', status, err );
		  }
		});
}
</script>

<script>
$(document).ready(function() {
	var popup = new Foundation.Reveal($('#exampleModal3'));
popup.open();
Foundation.libs.reveal.locked = true;
$('#exampleModal3').data('revealInit').close_on_background_click = false 
$('#exampleModal3').data('revealInit').close_on_esc = false 
	//$('body.rightMenuOpen').parent('html').css('overflow','hidden');
		  $('.more-menu').click(function(){
			$(this).children('ul').slideToggle('fast');
			})
		  	 
		  $('#menuicon').on('click', function(event){
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
				
				$('#logoMain #dlogo').hide(300, function(){$('#logoMain #mlogo').show(300)});
				$('#logoMain').addClass('mobileLogo');				
				
			} else {
				$('#topLayer').removeClass('fixed');
				$('#menuicon').removeClass('movetop');
				
				$('#logoMain #mlogo').hide(300, function(){$('#logoMain #dlogo').show(300)});
				
				$('#logoMain').removeClass('mobileLogo');
				
				
			}
		});
	});
	
	function aa() {
            $('.euro-divider hr').css('width', '100%');
         
        }
        $(window).bind("load", function () {
            aa();

            $('#fbox1').animate({ left: '0' }, 4000);
            $('#fbox2').animate({ right: '-301px' }, 2000);
     });
        
function loginWithFB()
{
	window.location="../mvc/social/facebook/signin";
	
}
</script>

<script src="/SportMgmt/js/vendor/jquery.js"></script>    
<script src="/SportMgmt/js/vendor/foundation.js"></script>
<script src="/SportMgmt/js/app.js"></script>   
<script src="/SportMgmt/js/jquery.animate-enhanced.min.js"></script>
   <script src="/SportMgmt/js/classie.js"></script>  
   <script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}

					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();
			
			$(document).ready(function() {
				$('.main_nav').click(function(){
					$('#loginForm').find("input[type=text],input[type=password], input[type=email], textarea").val("");	
				})
				
				$('.resetBtn').click(function(){
					$('.reserForm').hide('slow');
					$('.rsuccessBox').show('slow');
				})
				
			});
			
		</script>