<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The12thman | League</title>
    <link rel="stylesheet" href="/SportMgmt/css/foundation.css">
    <link rel="stylesheet" href="/SportMgmt/css/app1.css">
    <link rel="stylesheet" href="/SportMgmt/css/superslides.css">
    <link rel="stylesheet" href="/SportMgmt/css/customMedia.css">
    
    <style>
    #exampleModal2 .thanksMsg{ display:block; margin-bottom:20px; font-size:40px; color:#072d44;}
	.topThanksMsg{    display: block;
    margin-bottom: 20px;
    font-size: 40px;
    color: #072d44;}
	.bottomMsg{}
	.bottomMsg a{display: block;
    color: #38c4c5;
    font-size: 13px;
    margin: 6px 0px;
    padding: 4px 0px;}
	#exampleModal2 span{ display:block; color:#7b7b7b;; font-size:20px;}
    </style>
        

</head>
<body>

<div id="menuOpenOverlay"></div>

    <header class="menuOverlay">
            <div id="logo" class="large-4 columns">
            	
            </div>
            <nav class="large-8 columns">
                <ul class="d-menu" >
                    <li><a href="http://the12thman.in/"> Home </a></li>
                    <li><a href="javascript:void(0);" data-open="exampleModal2"> Log in </a></li>                  
                </ul>
                
                
                <!-- mobile menu start -->
                <div id="rightMenu" class="rightMenu">
                    
                    <a href='#' class="menuicon" id="menuicon">
                        <div class="menuText">Menu</div>
                        <div class="menuLine"><span></span><span></span></div>
                    </a>
                    
                    <div id="mmenu" class="mmenu">	<!-- Main nav links start -->
                        <ul class="clearfix nav" id="mobileMenu">
                            <div id="scrollBox" style="position:relative;">
                                <li><a href="http://the12thman.in/"> Home </a></li>
                    <li><a href="javascript:void(0);" data-open="exampleModal1"> Sign Up </a></li>              
                            </div>
                        </ul>
                    </div>
                            
                </div>
                <!-- mobile menu end -->
                
                
            </nav>
    	</header>
    <div id="slides">
        <div class="slides-container">
        	<img src="/SportMgmt/images/img-2.jpg">
        	
            <img src="/SportMgmt/images/img-1.jpg">
                      
           
            </div>
        <div id="main-content">
            <div class="reveal medium" id="exampleModal2" data-reveal>
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
                    <p><button class="close-button" type="button" data-close="">×</button>
                </div>
			<div class="banner-wrapper clearfix">
            	<p class="topHeaderText">
                	The <span>12th Man</span> Fantasy League
               	</p>
               	<p class="smtxt">
                 	Play and win <span class="highlight"> Prizes!</span>
                 </p>
            </div>
            <div class="banner-info">
            <img alt="info" src="/SportMgmt/images/football-1.png">
             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
             <span class="s1">
             	Bad performance<br/>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;in previous game weeks ? 
             </span>
             <BR>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
             <span class="s2">
             	Don't Worry ! 
             </span>
             <BR>
             <span class="s3">
             	Play Now and grab golden chance to kick up your performance. </span>
           <BR><span class="s4"> Play and explore exciting prizes and new features.</span>
            </div>
           <!--  <div class="row clearfix main-banner">
                <div class="large-12 column logo">
                    <div class="logo-container wow zoomIn" data-wow-duration=".8s" data-wow-delay="0.5s"
                        style="visibility: visible; animation-duration: 0.8s; animation-delay: 0.5s;
                        animation-name: zoomIn;">
                    </div>
                </div>
                <div class="large-12 column euro-headings">
                    <div class="euro-divider">
                        <hr>
                    </div>
                </div> 
            </div>-->
            <div class="row clearfix big-register">
                <div class="large-12 column text-center">
                    <button class="btn btn-default bigRegister"><span><a href="http://the12thman.in/">Visit our Blog</a></span></button>
                   
                </div>
            </div>
            
            <div class="fbox" id="fbox2">
                It's <span class="tag-bold">FREE</span> to play !
            </div>
            <div class="fbox" id="fbox1">
                win great <span class="tag-bold">prizes</span> <span class="and">&</span> <span class="tag-bold">cash</span>             
            </div>
            
        </div>
    </div>
    
    
    <nav class="slides-navigation">
          <a href="#" class="next"></a>
          <a href="#" class="prev"></a>
        </nav>
   
    
    <!-- pop-up container -->
   

<div class="reveal medium" id="exampleModal1" data-reveal>
  
  
  <form name="RegisterForm" action="mvc/user/register" method="post">
        <div class="large-12 columns">
          <label>Name*
            <input type="text" name="displayName" placeholder="Name" required />
          </label>
        </div>
            <!-- <div class="large-12 columns">
          <label>last name*
            <input type="text" name="lastname" placeholder="last name" required />
          </label>
        </div>
 -->            <div class="large-12 columns">
          <label>Email Address/Login ID*
            <input type="email" name="emailId" placeholder="email" required />
          </label>
        </div>
           <!--  <div class="large-12 columns">
          <label>confirm email*
            <input type="email" name="emailconfirm" placeholder="email" required />
          </label>
        </div>
 -->        <div class="large-12 columns">
            <label>Password*</label>
            <input type="password" name="logonPassword" placeholder="password" required />       
            
             </div>
        <div class="large-12 columns">
            <label>Confirm Password*</label>
              <input type="password" name="logonPasswordConfirm" placeholder="confirm password" required />
            
            </div>
            <div class="large-12 columns">
            
                <div align="right">
                    <a href="javascript:void(0);" class="button-lrg" onclick="submitForm();"><input type="button" class="button btnSubmit" value="REGISTER"></a>
                     </div>
            </div>
    </form>
  <button class="close-button" data-close aria-label="Close modal" type="button">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
    
    <script src="/SportMgmt/js/vendor/jquery.js"></script>
    <script src="/SportMgmt/js/vendor/what-input.js"></script>
    <script src="/SportMgmt/js/vendor/foundation.js"></script>
    <script src="/SportMgmt/js/app.js"></script>
    <script src="/SportMgmt/js/jquery.easing.1.3.js"></script>
    <script src="/SportMgmt/js/jquery.animate-enhanced.min.js"></script>
    <script src="/SportMgmt/js/jquery.superslides.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function () {
        	$('#slides').superslides({
                pagination:false,
        	animation:'fade',
        	play: 10000,
        	animation_speed: 3000,
            });
        });
        function submitForm()
        {
        	var regForm = document.forms['RegisterForm'];
        	if(typeof regForm['displayName'] == 'undefined' || regForm['displayName'].value=='')
        	{
        		alert("Please input your Name");
        		return false;
        	}
        	if(typeof regForm['emailId'] == 'undefined' || regForm['emailId'].value=='')
        	{
        		alert("Please input Email ID");
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
        		alert("Please input password");
        		return false;
        	}
        	if(typeof regForm['logonPasswordConfirm'] == 'undefined' || regForm['logonPasswordConfirm'].value !=regForm['logonPassword'].value)
        	{
        		alert("Password and confirm password should match");
        		return false;
        	}
        	regForm.submit();
        }
    </script>
    
    <script>
$(document).ready(function() {
	var popup = new Foundation.Reveal($('#exampleModal2'));
popup.open();
Foundation.libs.reveal.locked = true;
$('#exampleModal2').data('revealInit').close_on_background_click = false 
$('#exampleModal2').data('revealInit').close_on_esc = false 
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
		
		
</script>
  </body>
</body>
</html>