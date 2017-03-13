<jsp:include page="homeHeader.jsp" />
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <section id="sliderSection">
    <div class="row">
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
      <div class="col-lg-8 col-md-8 col-sm-8 slider-col">
        <div class="slick_slider">
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/cwc-win-2016-brings-luck-real-madrid/"> <img src="/SportMgmt/images/homeIndex/CWC.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/cwc-win-2016-brings-luck-real-madrid/">After CWC win, 2016 Has More Good News For Real Madrid</a></h2>
              <p>Real Madrid finally have got some relief from the two-year transfer ban, as CAS reduces their sanction by a year.</p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/antonio-conte-seeks-reunion-bayern-ace/"> <img src="/SportMgmt/images/homeIndex/Antonio.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle"  target="_blank" href="http://the12thman.in/antonio-conte-seeks-reunion-bayern-ace/">Antonio Conte seeks reunion with Bayern Ace</a></h2>
              <p>Chelsea boss Antonio Conte wants £42m rated Bayern Munich ace at Stamford Bridge by next season</p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/marouane-fellaini-set-move-serie-club/"> <img src="/SportMgmt/images/homeIndex/merouane.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/marouane-fellaini-set-move-serie-club/">Marouane Fellaini set for a move to Serie A club</a></h2>
              <p>Manchester United midfielder Marouane Fellaini is set for a move to either of Milan clubs as per the latest reports</p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/hazard-names-title-challengers-chelsea/"> <img src="/SportMgmt/images/homeIndex/Hazard.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/hazard-names-title-challengers-chelsea/">Hazard names 2 clubs as the only title challengers to Chelsea.</a></h2>
              <p>Chelsea Superstar, Eden Hazard has named Manchester City and Liverpool as the only title challengers to his rampant Chelsea side this season</p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/chelsea-closing-in-on-world-class-real-madrid-star/"> <img src="/SportMgmt/images/homeIndex/real-madrid.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/chelsea-closing-in-on-world-class-real-madrid-star/">Chelsea closing in on Transfer of World class Real Madrid star.</a></h2>
              <p>Real Madrid ace, James Rodriguez has confessed that he could be on the move coming January transfer window...</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <section id="contentSection">
    <div class="row">
      <div class="col-lg-8 col-md-8 col-sm-8">
        <div class="left_content">
          <div class="single_post_content">
            <blockquote>Chelsea closing in on Transfer of World class Real Madrid star. </blockquote>
			<p>Chelsea Superstar, Eden Hazard has named Manchester City and Liverpool as the only title challengers to his rampant Chelsea side this season.

Chelsea after shaky start to their season have now gone on to sit of the top of the Premier League for the second week in succession with a win over their London rivals Tottenham Hotspur.

Conte's switch to 3-4-3 has done wonders to the Chelsea side who were down on confidence and belief. Their defense which was supposedly their biggest weakness going into the season has been in tremendous form, conceding just one goal in their last 5 matches.
			<a target="_blank" href="http://the12thman.in/hazard-names-title-challengers-chelsea/">Read more..</a></p>
          	
          <div ><a href="#"><img class="img-responsive" src="/SportMgmt/images/addbanner_728x90_V1.jpg" alt=""></a></div>
          </div>
           
           <div class="single_post_content">
          
            <h2><span>Latest News</span></h2>
            <div class="single_post_content_left">
              <ul class="business_catgnav">
                <li>
                  <figure class="bsbig_fig  wow fadeInDown"> <a class="featured_img" target="_blank" href="http://the12thman.in/cwc-win-2016-brings-luck-real-madrid/"> <img src="/SportMgmt/images/homeIndex/CWC.jpg" alt=""> <span class="overlay"></span> </a>
                    <figcaption> <a target="_blank" href="http://the12thman.in/cwc-win-2016-brings-luck-real-madrid/">After CWC win, 2016 Has More Good News For Real Madrid</a> </figcaption>
                    <div class="date">21st December 2016</div>
                    <p>Real Madrid in the year 2016 was sentenced to a two-year ban, after FIFA's disciplinary committee found them guilty of breaking transfer regulations. Following this prohibition the club had appealed to FIFA, which was again rejected in September.....</p>
                  </figure>
                </li>
              </ul>
            </div>
            <div class="single_post_content_right">
              <ul class="spost_nav">
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/antonio-conte-seeks-reunion-bayern-ace/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/Antonio.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/antonio-conte-seeks-reunion-bayern-ace/" class="catg_title">Antonio Conte seeks reunion with Bayern Ace</a> <div class="date">21st December 2016</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/marouane-fellaini-set-move-serie-club/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/merouane.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/marouane-fellaini-set-move-serie-club/" class="catg_title">Marouane Fellaini set for a move to Serie A club</a> <div class="date">21st December 2016</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/hazard-names-title-challengers-chelsea/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/Hazard.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/hazard-names-title-challengers-chelsea/" class="catg_title">Hazard names 2 clubs as the only title challengers to Chelsea.</a> <div class="date">20th December 2016</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/jorge-mendes-flies-manchester-complete-united-transfer/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/real-madrid.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/jorge-mendes-flies-manchester-complete-united-transfer/" class="catg_title"> Jorge Mendes flies into</a> <div class="date">20th December 2016</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/cristiano-ronaldo-workout-plan/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/ripped.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/cristiano-ronaldo-workout-plan/" class="catg_title"> Want to be Ripped like</a> <div class="date">20th December 2016</div></div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
          <div class="single_post_content">
          	<img alt="" src="/SportMgmt/images/ads-bottom.jpg" class="img-responsive">
          </div>
        </div>
      </div>
      <div class="col-lg-4 col-md-4 col-sm-4">
        <aside class="right_content">
          <div class="single_sidebar wow fadeInDown">
            <div class="choose-team side-ban-1"><img src="/SportMgmt/images/ball-1.jpg" class="img-responsive"> 
		       	<span class="overlay-img">Predict 11 and win upto INR 10,000 <br> <br>        	 
		        	<a class="btn btn-black" href="javascript:void(0);" data-open="exampleModal2">Play</a>    
		        </span>
		    </div>
		    <div class="choose-team side-ban-2"><img src="/SportMgmt/images/ball-1.jpg" class="img-responsive"> 
		       	<span class="overlay-img">Ad banner starting from INR 20,000/Month <br><br>        	 
		        </span>
		    </div>
            <!-- <a class="sideAdd" href="#"><img src="/SportMgmt/images/ball-2.jpg" alt=""></a> 
            <a class="sideAdd" href="#"><img src="/SportMgmt/images/ball-3.jpg" alt=""></a>  -->
          </div>
          <div class="single_sidebar">
          <div class="slick_slider ads-slide">
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/Antonio.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Space For Ad Banner</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/CWC.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Starting from INR 10000/month</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/Hazard.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Contact at contactus@the12thman.in</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/merouane.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Space For Ad Banner</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/real-madrid.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Starting from INR 10000/month</a></h2>
	            </div>
	          </div>
	        </div>
	        </div>
        </aside>
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
