<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=request.getContextPath()%>" />
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="${context}/redBlackTheme/js/accordion.js"></script>

<div class="predict11-bg dream_help">
<div class="container-fluid">

	<div class="row">
          <div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 rules_faq">
            <ul class="nav nav-tabs">
            	<li class="active"><a data-toggle="tab" href="#menu2">CRITERIA</a></li>
                <li ><a data-toggle="tab" href="#home">RULES</a></li>
                <li><a data-toggle="tab" href="#menu1">FAQs</a></li>
              </ul>

              <div class="tab-content">
                <div id="home" class="tab-pane fade ">
                        <div class="main">
                                <div class="accordion">
                                    <div class="accordion-section">
                                        
                                        <a class="accordion-section-title" href="#accordion-1">Squad Size</a>
                                        <div id="accordion-1" class="accordion-section-content">
                                            <p>You can choose 11 players every week from any of the 20 teams in the Premier League.
                                            There are no restrictions,and you can pick as many players from the same team.
                                            The formation however ,will remain 4-3-3.</p>
                                       </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                        
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-2">Budget</a>
                                        <div id="accordion-2" class="accordion-section-content">
                                            <p>You have an unlimited budget.</p>
                                        </div><!--end .accordion-section-content-->
                                    </div><!--end .accordion-section-->
                        
                                    <div class="accordion-section">
                                        <a class="accordion-section-title" href="#accordion-3">Managing your squad</a>
                                        <div id="accordion-3" class="accordion-section-content">
                                            <p>You have to pick an entirely new squad every week.Your teams should be finalised one hour before the Gameweek starts.
                                            Once the gameweek ends,you have to pick a new team from scratch.</p>  
                                        </div>
                                    </div>
                                                                                                
                                </div><!--end .accordion-->
                            </div>   
                 </div>
                  <div id="menu2" class="tab-pane fade in active">
                  
                  <p>If two players have similar points,the following criterias would be used to select one,stated in order of priorities.</p>
                 <p> 1.Goals scored </p>
                 <p> 2.Assist made  </p>
                 <p> 3.Their team's goal difference for that gameweek.</p>
                 <p> 4.League position of player's team in the league.</p>
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