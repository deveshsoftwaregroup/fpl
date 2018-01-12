<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="<%=request.getContextPath()%>" />
<div class="container">
    <div class="row">
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1  ">
            <div class="row clearfix socialLinksCont">
                    <div class="col-xs-6 noPadding"><a href="https://www.facebook.com/Twelfthmantimes/" target="_blank" class="text-uppercase socialBtn facebookBtn btn btn-default btn-block"><span class="fa fa-facebook socialBtnIcon"></span><span class="socialBtnTxt">Facebook</span></a></div>
                    <div class="col-xs-6 noPadding">
                        <a href="https://twitter.com/the12thmantimes" target="_blank" class="text-uppercase socialBtn twitterBtn btn btn-default btn-block"><span class="fa fa-twitter socialBtnIcon"></span><span class="socialBtnTxt">Twitter</span></a></div>
                </div>
                </div>
          <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 our_partners ">
              
            <div class="row">
              
                <div class="col-lg-12 upper_text">
                    <h3>Our Partners</h3>
                   
                </div>
              </div>  
            <div class="row">
              <div class="col-lg-1 col-md-1 col-sm-12"><h3></h3></div>
                
                    <ul class="prtnr">
		            <li><img src="${context}/redBlackTheme/images/02.png" class="center-block" ></li>		                
	                <li><img src="${context}/redBlackTheme/images/03.png" class="center-block"></li>
	                <li><img src="${context}/redBlackTheme/images/04.png" class="center-block"></li>
	                <li><img src="${context}/redBlackTheme/images/05.png" class="center-block"></li>  
	                <li><img src="${context}/redBlackTheme/images/01.png" class="center-block"></li>  
               
               
              </ul>

                
              </div>
            </div>
          </div>

<div class="row">
     <div class="col-lg-10 col-lg-offset-1  col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1  footer_btn">
         <div class="row">
           <!--  <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 btm_ftr">
                
               
                <div class="col-lg-6  col-xs-6 ">
                        <h4>Fantasy League</h4>
                    <ul class="left_text">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="transfer.html">Transfer</a></li>
                        <li><a href="myTeam.html">My Team</a></li>
                        <li><a href="fixtures.html">Fixtures</a></li>
                        <li><a href="#">Leadership</a></li>
                        <li><a href="#">Stats</a></li>
                        <li><a href="guide.html">Guide</a></li>
                        <li><a href="gifts.html">Coupon</a></li>
                        
                        
                        
                    </ul>
                </div>
                <div class="col-lg-6 col-xs-6 ">
                    <h4>Dream 11</h4>
                    <ul class="left_text">
                            
                            <li><a href="Dream11-transfer.html">Transfer</a></li>
                            <li><a href="Dream11-myTeam.html">My Team</a></li>
                            <li><a href="Dream11-fixtures.html">Fixtures</a></li>
                            <li><a href="guide.html">Guide</a></li>
                            <li><a href="gifts.html">Coupon</a></li>
                            
                            
                        </ul>
                    </div>
            </div> -->
        <!--<p>We at justthinksports.com provide ONE STOP solution for sports lovers.</p>-->
    
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 btm_ftr1">
                <h4>More</h4>
                <ul class="mid_text">
                    <li><a href="javascript:void(0);" onclick="openAboutUs();">About Us</a></li>
                    <li><a href="http://the12thman.in/">Blog</a></li>
                    <li><a href="scout.html">Scout</a></li>
                    <li><a href="#">Terms & Conditions</a></li>
                    <li> <a href="javascript:void(0);" onclick="openPrivacyPolicy();">Privacy Policy</a></li>
                    
                    <li><a href="help.html">Help</a></li>
                    
                </ul>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 btm_ftr2">
                <h4>Contact</h4>
                <p>If you have any query or want to contact us, you are most welcome to write us at</p>
                    
                <p>Just Think Sports</p> 
                <p>contactus@justthinksports.com</p>
            </div>
    </div>
    <hr>
    <div class="bottom_bit">
        <h4>Disclaimer</h4>
        <p>Lorem ipsum dolor sit amet Molestiae dolores voluptatem non modi unde dolorem ipsa perspiciatis reiciendis, expedita perferendis atque quis ipsum ea nemo enim ab repudiandae magnam! Necessitatibus asperiores architecto eum maxime quia praesentium neque sequi qui fugiat molestias quaerat aperiam harum, quod dolorum natus est reprehenderit odio quos rerum repudiandae ipsum eveniet sunt modi voluptate! Ratione praesentium placeat amet nam doloribus laborum saepe.    
    </p></div>
         </div>
</div>
<!-- BEGIN JIVOSITE CODE {literal} -->
<script type='text/javascript'>
(function(){ var widget_id = 'haxROgpGFC';var d=document;var w=window;function l(){
var s = document.createElement('script'); s.type = 'text/javascript'; s.async = true; s.src = '//code.jivosite.com/script/widget/'+widget_id; var ss = document.getElementsByTagName('script')[0]; ss.parentNode.insertBefore(s, ss);}if(d.readyState=='complete'){l();}else{if(w.attachEvent){w.attachEvent('onload',l);}else{w.addEventListener('load',l,false);}}})();</script>
<!-- {/literal} END JIVOSITE CODE -->
</div>
<script>
function openPrivacyPolicy()
{
	window.location="/SportMgmt/mvc/PrivacyPolicy";			
}
function openAboutUs()
{
	window.location="/SportMgmt/mvc/AboutUs";			
}
</script>
