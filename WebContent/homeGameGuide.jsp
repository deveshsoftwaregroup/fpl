<jsp:include page="homeHeader.jsp" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  <section id="contentSection">
    <div class="row">
      <div class="col-lg-8 col-md-8 col-sm-8">
        <div class="left_content">
          <div class="single_post_content">
                <ul class="nav nav-tabs" role="tablist">
                  <li role="presentation" class="active"><a href="#introduction" aria-controls="introduction" role="tab" data-toggle="tab">Introduction</a></li>
                  <li role="presentation"><a href="#manage" aria-controls="manage" role="tab" data-toggle="tab">Manage Your Squad</a></li>
                  <li role="presentation"><a href="#scoring" aria-controls="scoring" role="tab" data-toggle="tab">Scoring Points</a></li>
                  <li role="presentation"><a href="#competitions" aria-controls="competitions" role="tab" data-toggle="tab">Competitions</a></li>
                  <li role="presentation"><a href="#prizes" aria-controls="prizes" role="tab" data-toggle="tab">Prizes!</a></li>
                </ul>
                <div class="tab-content">
                  <div role="tabpanel" class="tab-pane active" id="introduction">
                    <img src="/SportMgmt/images/inner-img.jpg" align="left" class="img-inner">
                    <p>Welcome to Fantasy IPL 2017. Fantasy IPL returns this summer with the start of another Fantasy League season on 5th April!</p>

<p>Compete against players from far and wide and win big with over INR 50,000 in prizes across a wide range of competitions.</p>

<p>The game covers the entire 2017 IPL campaign, with competitions for overall, monthly and weekly standings!</p>

<p>Select your squad and follow your team's progress as your players score points for wickets, strike-rate, economy-rate, runs etc.</p>

<p>Select the players you want to play, and make those all-important transfers to get your team on the right track if and when things go awry.</p>

<p>Login and visit the Transfer page to get started.</p>
                  </div>
                  <div role="tabpanel" class="tab-pane" id="manage">
                    <img src="/SportMgmt/images/inner-img-2.jpg" align="left" class="img-inner">
                    <p><strong>You're in charge!</strong></p>

<p>As a Fantasy League manager, you'll pick your squad of 15 players from a budget of INR 100 Million.</p>

<p>All players and prices are listed on our Transfer page, so send your scouts off in that direction.</p>

<p>You can choose from the best talent the Fantasy League has to offer, fine tuning your squad while keeping to our club quota, formation and budget rules.</p>

<p>Tinker with your team using unlimited transfers until 07:00 PM  IST on Wednesday, 5th April, then use wildcard and transfers throughout the season to maximise your points potential.</p>

<p>Register/Login for more information.</p>
                  </div>
                  <div role="tabpanel" class="tab-pane" id="scoring">
                    <img src="/SportMgmt/images/inner-img-3.jpg" align="left" class="img-inner">
                    <p>Your team will score points based upon how your chosen players perform in IPL matches during the 2017 season.</p>

<p>Score points for making runs, taking wickets etc. Use wildcard to make unlimited free transfers!</p>

<p>Login and visit the Points Table page for more information.</p>
                  </div>
                  <div role="tabpanel" class="tab-pane" id="competitions">
                    <img src="/SportMgmt/images/inner-img-3a.jpg" align="left" class="img-inner">
                    <p>Fantasy IPL offers the widest array of competitions, with weekly and monthly leaderboards in addition to the season-long competition. Even if your initial signings fail to deliver, there is always the opportunity to turn your team around and win great prizes!</p>

<p>Embark on a quest for personal glory in our Fantasy IPL competition..</p>

<p></p>

<p>Login to Leagues page for more information.</p>
                  </div>
                  <div role="tabpanel" class="tab-pane" id="prizes">
                    <img src="/SportMgmt/images/inner-img-4.jpg" align="left" class="img-inner">
                    <p>Fantasy League offers you the chance to win over INR 50,000 worth of prizes!</p>

<p>Not only is there a fabulous first prize of INR 10,000 in cash, but there's also plenty more to be won with over 120 different cash prizes.</p>


                  </div>
                </div>
          </div>
        </div>
        <div ><a href="#"><img src="/SportMgmt/images/addbanner_728x90_V1.jpg" class="img-responsive" alt=""></a></div>
        <br>
      </div>
      <div class="col-lg-4 col-md-4 col-sm-4 select-team">
        <div class="choose-team"><img src="/SportMgmt/images/ball-1.jpg" class="img-responsive"> 
        	<span class="overlay-img">Select your Team <br/> & Play <br/>        	 
	        	<c:if test="${empty sessionScope.user.displayName}">
	        		<a class="btn btn-black" href="javascript:void(0);" data-toggle="modal" data-target="#myModal">Select Team</a>    
	        	</c:if>
	        		<c:if test="${not empty sessionScope.user.displayName}">
	        	<a class="btn btn-black" onclick="redirectToLeague();">Select Team</a>   
	        	</c:if>
        	 </span>
        </div>
      </div>
    </div>
  </section>
  

  <jsp:include page="homeFooter.jsp" />  
  </div>
<script src="/SportMgmt/assets/js/jquery.min.js"></script> 
<script src="/SportMgmt/assets/js/wow.min.js"></script> 
<script src="/SportMgmt/assets/js/bootstrap.min.js"></script> 
<script src="/SportMgmt/assets/js/slick.min.js"></script> 
<script src="/SportMgmt/assets/js/custom.js"></script>
</body>
</html>