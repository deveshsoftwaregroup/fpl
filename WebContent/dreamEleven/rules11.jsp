<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="${context}/redBlackTheme/js/accordion.js"></script>

<div class="predict11-bg dream_help">
<div class="container">

	<div class="row">
          <div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 rules_faq">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">RULES</a></li>
                <li><a data-toggle="tab" href="#menu1">FAQs</a></li>
               
              </ul>

              <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                        <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        
                                        <a class="accordion-section-title" href="#accordion-1">Squad Size</a>
                                        <div id="accordion-1" class="accordion-section-content">
                                            <p>To join the game select a DreamEleven football squad of 11 players, consisting of:
                                                1 Goalkeeper
                                                4 Midfielder
                                                2 Forward
                                                4 Defenders</p>
                                            
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                        
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-2">Budget</a>
                                        <div id="accordion-2" class="accordion-section-content">
                                            <p>The total value of your initial squad must not exceed INR 100 Million.</p>
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                        
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-3">Managing your squad</a>
                                        <div id="accordion-3" class="accordion-section-content">
                                            <p>Choosing your starting 11

                                           From your 11 player squad, select 11 players by the Gameweek deadline to form your team.

                                           All your points for the Gameweek will be scored by these 11 players. 

                                           Your team can play in any formation providing that 1 Goalkeeper, at least 3 Midfielder,3 Defender and at least 1 Forward are selected at all times. 

                                           Selecting a Captain and a Vice-Captain

                                           From your starting 11 you nominate a captain and a vice-captain. Your captain's score will be doubled.</p>
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                    <!--  <div class="accordion-section">
                                            <a class="accordion-section-title" href="#accordion-5">Transfers</a>
                                            <div id="accordion-5" class="accordion-section-content">
                                                <p>After selecting your squad you can buy and sell players in the transfer market. Unlimited transfers can be made at no cost until your first deadline.

                                                After your first deadline you will receive 1 free transfer each Gameweek. Each additional transfer you make in the same Gameweek will deduct 4 points from your total score. 

                                                If you do not use your free transfer, you are able to make an additional free transfer the following Gameweek. If you do not use this saved free transfer in the following Gameweek, it will be carried over until you do. You can never have more than 1 saved transfer.</p>
                                            </div>end .accordion-section-content
                                        </div>end .accordion-section
                                        <div class="accordion-section">
                                                <a class="accordion-section-title" href="#accordion-6">Wildcards</a>
                                                <div id="accordion-6" class="accordion-section-content">
                                                    <p>To do free transfer in a week, you can use wildcard. One wild card will be free and after that you can avail more wildcard by purchasing it. It will boost your chance to win prizes.</p>
                                                </div>end .accordion-section-content
                                            </div>end .accordion-section -->
                                        <div class="accordion-section"> 
                                             <a class="accordion-section-title" href="#accordion-7">Player Prices</a>
                                            <div id="accordion-7" class="accordion-section-content">
                                                <p>
                                             Player prices may change during the season dependent on the popularity of the player. Player prices do not change until the season starts.

                                             The price shown on your transfers page is a player's selling price.
                                             All changes to your team (starting 11, transfers, captain changes, substitiution priorities) must be made by the Gameweek deadline in order to take effect for that set of matches.

                                             Deadlines are subject to change and will be 1 hour before the kick-off time in the first match of the Gameweek.</p>
                                            </div><!--end .accordion-section-content-->
                                        </div><!--end .accordion-section-->

                                              
                                                                                                
                                </div><!--end .accordion-->
                            </div>   
                 </div>
                <div id="menu1" class="tab-pane fade">
                        <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        
                                        <a class="accordion-section-title" href="#accordion-a">I have forgotten my password. What can I do?</a>
                                        <div id="accordion-a" class="accordion-section-content">
                                            <p>You can click on "Forgot password" on login page". Provide your registered email ID. We will send your password on your email ID.</p>
                                            
                                                
                                                
                                            
                                            
                                           
                                            
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                        
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-b">Manage your Squad</a>
                                        <div id="accordion-b" class="accordion-section-content">
                                            <h3>Choosing your starting 11</h3>
                                            <p> select 11 players by the Gameweek deadline to form your team.</p>
                                            <p>All your points for the Gameweek will be scored by these 11 players, however if one or more doesn't play they may be automatically substituted.</p>
                                            <p>Your team can play in any formation providing that 1 goalkeeper, at least 3 defenders and at least 1 forward are selected at all times.</p>
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                        
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-c">I can't sign in. What do I need to do?</a>
                                        <div id="accordion-c" class="accordion-section-content">
                                            <p>Please ensure you are using your registered e-mail address and correct password. Note that the password is case sensitive.</p>
                                            <BR>
			                        <p>If you have registered for the first time this season, you will need to activate your account before entering The 12thman Fantasy League team. An email will be sent to the email address you have registered with and contains a link.  You will need to click in order to activate your account. If you have not received an email, please check your spam or junk mail folders.</p>
			                        <BR>
			                        <p>If you do not receive the password reminder, please check your Junk folder in your email inbox and add noreply@mailout.users.the12thman.in to your address book.</p>
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                                    <div class="accordion-section">
                                            <a class="accordion-section-title" href="#accordion-d">I have set up a team, but I can't see my History or renew my leagues from previous seasons. Can you link my new account to my old one?</a>
                                            <div id="accordion-d" class="accordion-section-content">
                                                <p>Unfortunately, we cannot link your history from an old account to a new one. If you have set up a team for this season using a different email address, you will not be able to view your History from previous seasons on that account </p>
                                                <p>In order to see previous seasons' scores, you will need to sign in on the homepage using the registered email address and password combination from the previous seasons and set up a team using that account.</p>
                                            </div><!--end .accordion-section-content-->
                                        </div><!--end .accordion-section-->
                                        <div class="accordion-section">
                                                <a class="accordion-section-title" href="#accordion-e">I have some suggestions and great ideas. I want to implement my ideas with The12thman. the What should I do?</a>
                                                <div id="accordion-e" class="accordion-section-content">
                                                    <p>We always appreciate such initiatives. You can send your ideas at support@the12thman.in. If we like your idea or suggestion, we will implement it and will award you. If you want to work with us on your idea, you are most welcome.</p>
                                                </div><!--end .accordion-section-content-->
                                            </div><!--end .accordion-section-->
                                            <div class="accordion-section">
                                                    <a class="accordion-section-title" href="#accordion-f">How can I contact The 12thman ?</a>
                                                    <div id="accordion-f" class="accordion-section-content">
                                                        <p>You can send your query to support@the12thman.in. We will get back to you.</p>
                                                    </div><!--end .accordion-section-content-->
                                                </div><!--end .accordion-section-->
                                </div><!--end .accordion-->
                            </div>                   </div>
                
              </div>
            </div>
          </div>
</div>
</div>

      
      
        
        <script>
            $('.toggle').click(function(e) {
  	e.preventDefault();
  
    var $this = $(this);
  
    if ($this.next().hasClass('show')) {
        $this.next().removeClass('show');
        $this.next().slideUp(350);
    } else {
        $this.parent().parent().find('li .inner').removeClass('show');
        $this.parent().parent().find('li .inner').slideUp(350);
        $this.next().toggleClass('show');
        $this.next().slideToggle(350);
    }
});
            
        </script> 