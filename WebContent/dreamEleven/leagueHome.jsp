<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="context" value="<%=request.getContextPath()%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Justthinksports</title>
    <link rel="stylesheet" href="${context}/css/foundation.css">
    <link rel="stylesheet" href="${context}/css/app1.css">
    <link rel="stylesheet" href="${context}/css/superslides.css">
    <link rel="stylesheet" href="${context}/css/customMedia.css">
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
	
	/* .topHeaderText {
  display: inline-block;
  animation: scale 7s infinite;
  transform: scale(0);
  animation-direction: alternate;
  opacity: .7;
} */

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


@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}
    </style>
</head>
<body>
<div id="menuOpenOverlay"></div>

    <header class="menuOverlay">
            <div id="logo" class="large-4 columns">
            	<img src="${context}/images/logo.png" alt="logo"> 
            </div>
            <nav class="large-8 columns">
                <ul class="d-menu" >
                    <li><a href="http://the12thman.in/"> The12thMan Blog </a></li>
                    
                    <li><a href="javascript:void(0);" onclick="openHomeHome();">Fantasy League</a></li>            
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
                                <li><a href="http://the12thman.in/"> The12thMan Blog </a></li>
                                <li><a href="javascript:void(0);" onclick="openHomeHome();">Fantasy League</a></li>     
                            </div>
                        </ul>
                    </div>
                            
                </div>
                <!-- mobile menu end -->
                
                
            </nav>
    	</header>
    	
   	<!-- to make slides active...do id as slides... remove -old -->
    <div id="slides-old">
        <div class="slides-container">
            <div><img src="${context}/images/home-banner-current.jpg"><div class="overlay"></div></div>
            
           <div><img src="${context}/images/home-banner-current-2.jpg"><div class="overlay"></div></div>
        </div>
        
        <!-- <div class="shade"></div> -->
        <div id="main-content">
            <div class="banner-wrapper clearfix">
            	<p class="topHeaderText">
                	The <span>12th Man</span> Fantasy League
               	</p>
               	<p class="smtxt">
                 	Play and win <span class="highlight"> Prizes!</span>
                 </p>
            </div>
            <div class="banner-info">
            <img alt="info" src="${context}/images/football-1.png">
             &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
             <span class="s1">
             	Fantasy IPL <br/>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;A Sports Zone for
             </span>
             <BR>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
             <span class="s2">
             	Cricket lovers ! 
             </span>
             <BR>
             <span class="s3">
             	Start now and grab golden chance to win Prizes and Cash.</span>
           <BR><span class="s4"> Play and explore new features.</span>
            </div>
          
            <div class="row clearfix big-register">
                <div class="large-12 column text-center">
                    <button class="btn btn-default bigRegister" onclick="openHomeHome();"><span>Play Now</span></button>
                   
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
    
    
    <!-- <nav class="slides-navigation">
      <a href="#" class="next"></a>
      <a href="#" class="prev"></a>
    </nav> -->
   
    
    <!-- pop-up container -->
   

<div class="reveal medium" id="exampleModal1" data-reveal>
  
  
  <form name="RegisterForm" action="user/register" method="post">
  <h3>Sign Up</h3>
  <div class="large-12 columns">
            <input type="text" name="displayName" placeholder="Name" required id="name" />
        </div>
        <div class="large-12 columns">
            <input type="email" name="emailId" placeholder="Email / Login ID" required id="email" />
        </div>
        <div class="large-12 columns">
            <input type="password" name="logonPassword" placeholder="Password" required id="password" />
        </div>
        <div class="large-12 columns">
            <input type="password" name="logonPasswordConfirm" placeholder="Confirm Password" required
                id="password2" />
        </div>
        <div class="large-12 columns">
            <select name="country" placeholder="Mobile Number" required
                id="country">
            <option value="">Select Country</option>
            <c:forEach var="countryObj" items="${countryMap}">
            <option value="${countryObj.key}">${countryObj.key}</option>
            </c:forEach>
            </select>
        </div>
        <div class="large-12 columns">
            <input type="input" name="contactNumber" placeholder="Mobile Number1" required
                id="contactNumber" />
        </div>
        <div class="large-12 columns">
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
<div class="reveal medium" id="exampleModal2" data-reveal>
  <form name="LoginForm" action="" method="get" onsubmit="event.preventDefault();">
        <div class="large-12 columns">
          <label>Login Id*
            <input type="email" name="emailId" placeholder="email" required />
          </label>
        </div>
        <div class="large-12 columns">
            <label>Password*</label>
            <input type="password" name="logonPassword" placeholder="password" required />       
        </div>
         <div class="large-12 columns">
            
                <div align="right">
                    <a href="javascript:void(0);" class="button-lrg"><input type="submit" class="button btnSubmit" value="LOG IN" onclick="doLogin();"></a>
                     </div>
            </div>
    </form>
  <button class="close-button" data-close aria-label="Close modal" type="button">
    <span aria-hidden="true">&times;</span>
  </button>
</div>    
    <script src="${context}/js/vendor/jquery.js"></script>
    <script src="${context}/js/vendor/what-input.js"></script>
    <script src="${context}/js/vendor/foundation.js"></script>
    <script src="${context}/js/app.js"></script>
    <script src="${context}/js/jquery.easing.1.3.js"></script>
    <script src="${context}/js/jquery.animate-enhanced.min.js"></script>
    <script src="${context}/js/jquery.superslides.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">	
	
	
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
        		showNotification("Please input your Name");
        		return false;
        	}
        	if(typeof regForm['emailId'] == 'undefined' || regForm['emailId'].value=='')
        	{
        		showNotification("Please input Email ID");
        		return false;
        	}
        	var isEmailValid = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(regForm['emailId'].value);
        	if(!isEmailValid)
       		{
        		showNotification("Email ID is not valid");
        		return false;
       		}
        	if(typeof regForm['logonPassword'] == 'undefined' || regForm['logonPassword'].value =='')
        	{
        		showNotification("Please input password");
        		return false;
        	}
        	if(typeof regForm['logonPasswordConfirm'] == 'undefined' || regForm['logonPasswordConfirm'].value !=regForm['logonPassword'].value)
        	{
        		showNotification("Password and confirm password should match");
        		return false;
        	}
        	
        	if(typeof regForm['contactNumber'] != 'undefined')
        	{
        		var mobNumVal = regForm['contactNumber'].value;
        		if(!(mobNumVal.length ==10 &&  /^\d+$/.test(mobNumVal)))
       			{
        			showNotification('Please input valid mobile number');
        			return false;
       			}
        	}
        	regForm.submit();
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
        				  showNotification(resp.errorMessage);
       				  }
        		  },
        		  error: function( req, status, err ) {
        		    console.log( 'something went wrong', status, err );
        		  }
        		});
        }

        $(document).ajaxStart(function(){
    		$("#ajaxloader").css("display", "block");
    		$('.mask').show();
    	});

    	$(document).ajaxComplete(function(){
    	    $("#ajaxloader").css("display", "none");
    	    $('.mask').hide();
    	});

    </script>    
    <script>
$(document).ready(function() {
	//not working. will check again
	//setbackground();
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
		$('#fbox2').animate({ right: '-350px' }, 2000);
	});
	
	 
	function openHomeHome()
	{
		window.location="LeagueLandingHome";
		
	}

</script>
 <script>
                    	/*-- button background change  --*/
	
						/*document.getElementById("ivaue5-reveal").style.setProperty("-webkit-transition", "2s");
						
						function setbackground()
						{
						window.setTimeout( "setbackground()", 2000); // 
						
						var index = Math.round(Math.random() * 3);
						
						var ColorValue = "rgba(27, 117, 188, .8)"; // default color 
						
						if(index == 1)
						ColorValue = "rgba(27, 117, 188, .8)"; 
						if(index == 2)
						ColorValue = "rgba(14, 117, 112, .8)"; 
						if(index == 3)
						ColorValue = "rgba(101, 17, 111, .8)"; 
						
						
						document.getElementById("ivaue5-reveal").style.backgroundColor = ColorValue;
						
						}*/
                    </script>

   
    <div id="ajaxloader"></div>
   <div class="mask" style="display:none;"></div>
  </body>
</body>
</html>