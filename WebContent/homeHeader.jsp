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
	#ajaxloader {
    border: 16px solid #f3f3f3; /* Light grey */
    border-top: 16px solid blue;
 	border-right: 16px solid green;
 	border-bottom: 16px solid red;
 	border-left: 16px solid pink;
    border-radius: 50%;
    width: 50px;
    height: 50px;
    animation: spin 1s linear infinite;
    position: fixed;
    left: 50%;
    top: 50%;
    margin-left: -32px; 
    margin-top: -32px;
    z-index: 9999;
    display:none;
}
.mask{ background: #000; opacity: 0.5; position:fixed; top: 0; left: 0; width: 100%; height:100%;z-index;9000;}
@media (min-width: 768px){
	#myModal1 .modal-dialog {
	    width: 420px;
	}
}
</style>
</head>

<body>



<div id="myModal" class="modal fade" role="dialog">
  
	<div id="login-overlay" class="modal-dialog">
	      <div class="modal-content">
	          <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	              <h4 class="modal-title" id="myModalLabel">Login</h4>
	          </div>
	          <div class="modal-body">
	              <div class="row">
	                  <div class="col-xs-6">
	                      <div class="well">
	                          <form id="loginForm" name="LoginForm" action="" method="get" onsubmit="event.preventDefault();">
	                              <div class="form-group">
	                              
	                                  <label for="username" class="control-label">Login Id*</label>
	                                  <input type="email" name="emailId" placeholder="email" required class="form-control" />
	                                  <span class="help-block"></span>
	                              </div>
	                              <div class="form-group">
	                                  <label for="password" class="control-label">Password</label>
	                                  <input type="password" name="logonPassword" placeholder="password" required class="form-control" /> 
	                                  <span class="help-block"></span>
	                              </div>
	                              <div id="loginErrorMsg" class="alert alert-error hide">Wrong username or password</div>
	                              <div class="checkbox">
	                                  <label>
	                                      <input type="checkbox" name="remember" id="remember"> Remember login
	                                  </label>
	                                  <p class="help-block">(if this is a private computer)</p>
	                              </div>
	                              <a href="javascript:void(0);" class="">
				             	
	                              <button type="submit" class="btn btn-primary btn-block" onclick="doLogin();">Login</button>
	                              </a>
	                              <a href="javascript:void(0);" data-toggle="modal" data-target="#myModal3">Forgot Password</a> 
	                          </form>
	                      </div>
	                  </div>
	                  <div class="col-xs-6">
	                      <p class="lead">Register now for <span class="text-success">FREE</span></p>
	                      <ul class="list-unstyled" style="line-height: 2">
	                          <li><span class="fa fa-check text-success"></span> Manage your team</li>
	                          <li><span class="fa fa-check text-success"></span> Great UI Experience</li>
	                          <li><span class="fa fa-check text-success"></span> Save your favorites</li>
	                          <li><span class="fa fa-check text-success"></span> See your rank</li>
	                          <li><span class="fa fa-check text-success"></span> Win prizes <small></small></li>
	                      </ul>
	                      <p><a href="javascript:void(0);" data-toggle="modal" data-target="#myModal1" class="btn btn-info btn-block">Register with Email ID!</a></p>
	                  	<div ><a href="javascript:void(0);" onclick="loginWithFB()"; class=""><img src="/SportMgmt/images/login_fb.jpg" class="img-responsive" alt="" height="75" width="270" ></a></div>
	                  </div>
	              </div>
	          </div>
	      </div>
	  </div>
</div>

<div id="myModal1" class="modal fade" role="dialog">
  
	<div id="login-overlay" class="modal-dialog">
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
                <a href="javascript:void(0);" class="button-lrg" onclick="submitForm();"><input type="button" class="btn btn-primary" value="REGISTER"></a>
            </div> 
            <div align="center"><a href="javascript:void(0);" onclick="loginWithFB()"; class=""><img src="/SportMgmt/images/login_fb.jpg" class="img-responsive" alt="" height="92" ></a></div>
        </div>
    </form>
	          </div>
	      </div>
	  </div>
</div>

<div id="myModal2" class="modal fade" role="dialog">
  
	<div id="login-overlay" class="modal-dialog">
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
  	<div id="login-overlay" class="modal-dialog">
	      <div class="modal-content">
	          <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
	              <h4 class="modal-title" id="myModalLabel">Forgot Password</h4>
	          </div>
	          <div class="modal-body">
	          <form name="ResetPassForm" action="user/forgotPassword" method="get">
				   <div class="form-group">
				       <input type="email" name="emailId" placeholder="Email / Login ID" required id="email" class="form-control" />
				   </div>
				  <div class="form-group">            
		            <div align="center">
		                <a href="javascript:void(0);" class="button-lrg" onclick="submitRSForm();"><input type="button" class="btn btn-primary" value="Send Password"></a>
		            </div> 
		          </div>
		    </form>
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
        <ul class="nav navbar-nav main_nav">
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
          <li class="active"><font color="blue">Welcome ${sessionScope.user.displayName}</font></li>
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
   