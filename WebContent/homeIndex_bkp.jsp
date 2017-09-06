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
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/lokesh-rahul-may-miss-ipl-10/"> 
          <img src="/SportMgmt/images/homeIndex/slider-img1.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/lokesh-rahul-may-miss-ipl-10/">Indian opener, KL Rahul may miss this season of Indian Premier League</a></h2>
              <p>RCB wicket keeper-batsman, KL Rahul may miss IPL 10 KL Rahul, Royal Challengers Bangalore wicket keeper-batsman, is expected to miss this season of IPL</p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/virat-kohli-break-cricket-haddin/">
           <img src="/SportMgmt/images/homeIndex/slider-img2.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle"  target="_blank" href="http://the12thman.in/virat-kohli-break-cricket-haddin/">Virat Kohli needs to take a break from cricket : Brad Haddin</a></h2>
              <p>Australian wicket keeper believes Kohli needs to take a break from the game Brad Haddin wrote in his recent column</p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/m-s-dhoni-ruled-ipl-10-hamstring-injury/"> 
          	<img src="/SportMgmt/images/homeIndex/slider-img3.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/m-s-dhoni-ruled-ipl-10-hamstring-injury/">
              M.S.Dhoni ruled out of IPL-10 with hamstring injury</a></h2>
              <p>The Indian Premier League, India biggest sporting extravaganza is about to get underway </p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/australians-blow-virat-kohli/"> 
          	<img src="/SportMgmt/images/homeIndex/slider-img4.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/australians-blow-virat-kohli/">Australians dealt with a parting blow courtesy of Virat Kohli</a></h2>
              <p>Virat Kohli is no longer friends with the Australian cricketers </p>
            </div>
          </div>
          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in/five-cheap-buys-star-performers-ipl/"> 
          	<img src="/SportMgmt/images/homeIndex/slider-img5.jpg" alt=""></a>
            <div class="slider_article">
              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in/five-cheap-buys-star-performers-ipl/">
              Five cheap buys who could be the star performers this IPL</a></h2>
              <p>Every Season of the IPL is characterised by the consistent performers, the big-hitters...</p>
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
            <blockquote>5 managers who are most likely to succeed Luis Enrique at Barcelona</blockquote>
			<p>Luis Enrique, the current Barca manager announced his decision to leave the club after a 6-1 victory over Sporting Gijon. According to Guillem Balague, the reputed Spanish football journalist, Luis Enrique made his intentions clear about leaving the club as early as pre-season. 
			Club president, Josep Maria Bartomeu left Enrique future in his own hands. The initial plan by Enrique was to announce his departure after the PSG tie. The 4-0 defeat in the first leg pushed things forward and the announcement was made before the second leg. Barcelona still remains in the Champions League and are second in the La Liga.
			<a target="_blank" href="http://the12thman.in/5-managers-barcelona/">Read more..</a></p>
          	
          <div ><a href="#"><img class="img-responsive" src="/SportMgmt/images/addbanner_728x90_V1.jpg" alt=""></a></div>
          </div>
           
           <div class="single_post_content">
          
            <h2><span>Latest News</span></h2>
            <div class="single_post_content_left">
              <ul class="business_catgnav">
                <li>
                  <figure class="bsbig_fig  wow fadeInDown"> <a class="featured_img" target="_blank" href="http://the12thman.in/five-cheap-buys-star-performers-ipl/"> <img src="/SportMgmt/images/homeIndex/slider-img5.jpg" alt=""> <span class="overlay"></span> </a>
                    <figcaption> <a target="_blank" href="http://the12thman.in/cwc-win-2016-brings-luck-real-madrid/">Five cheap buys who could be the star performers this IPL</a> </figcaption>
                    <div class="date">3rd April 2017</div>
                    <p>Every Season of the IPL is characterised by the consistent performers, the big-hitters, bowlers bowling toe-crushing yorkers and some complete packages who are batsmen, handy part-timers and excellent players. This theatre also features underdogs who set the stage on fire with their heroics......</p>
                  </figure>
                </li>
              </ul>
            </div>
            <div class="single_post_content_right">
              <ul class="spost_nav">
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/lokesh-rahul-may-miss-ipl-10/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/slider-img1.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/lokesh-rahul-may-miss-ipl-10/" class="catg_title">Indian opener, KL Rahul may miss this season of Indian Premier League</a> <div class="date">2nd April 2017</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/virat-kohli-break-cricket-haddin/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/slider-img2.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/virat-kohli-break-cricket-haddin/" class="catg_title">Virat Kohli needs to take a break from cricket : Brad Haddin</a> <div class="date">2nd April 2017</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/m-s-dhoni-ruled-ipl-10-hamstring-injury/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/slider-img3.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/m-s-dhoni-ruled-ipl-10-hamstring-injury/" class="catg_title">M.S.Dhoni ruled out of IPL-10 with hamstring injury.</a> <div class="date">2nd April 2017</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/category/cricket/page/2/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/slider-img4.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/category/cricket/page/2/" class="catg_title">Australians dealt with a parting blow courtesy of Virat Kohli</a> <div class="date">30th March 2017</div></div>
                  </div>
                </li>
                <li>
                  <div class="media wow fadeInDown"> <a target="_blank" href="http://the12thman.in/hazard-laughs-off-real-madrid-rumours/" class="media-left"> <img alt="" src="/SportMgmt/images/homeIndex/latest-img4.jpg"> </a>
                    <div class="media-body"> <a target="_blank" href="http://the12thman.in/hazard-laughs-off-real-madrid-rumours/" class="catg_title"> Football: Hazard laughs off Real Madrid rumours</a> <div class="date">4th April 2017</div></div>
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
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/slider-img1.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Space For Ad Banner</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/slider-img2.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Starting from INR 10000/month</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/slider-img3.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Contact at contactus@the12thman.in</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/slider-img4.jpg" alt=""></a>
	            <div class="slider_article">
	              <h2><a class="slider_tittle" target="_blank" href="http://the12thman.in">Space For Ad Banner</a></h2>
	            </div>
	          </div>
	          <div class="single_iteam"> <a target="_blank" href="http://the12thman.in"> <img src="/SportMgmt/images/homeIndex/slider-img3.jpg" alt=""></a>
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
