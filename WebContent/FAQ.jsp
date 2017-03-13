<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="WEB-INF/sportmgmt.tld" prefix="s" %>  
 <style>
@import url("https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css");
.static_container{
	font-family: Opensans-reg, "Helvetica Neue",Helvetica,Arial,sans-serif;
    font-size: 14px;
    line-height: 1.42857143;
    color: #fff;
        padding: 10px 20px;min-height: 540px;
}
.panel-heading > a > .panel-title:before{
    float: right !important;
    font-family: FontAwesome;
    content:"\f067";
    padding-right: 5px;
}
.panel-heading > a.collapsed > .panel-title:before {
    float: right !important;
    content:"\f068";
}
a > .panel-title:hover, 
a > .panel-title:active, 
a > .panel-title:focus  {
    text-decoration:none;
	color:#fff;
}
.panel-heading > a { color: inherit; text-decoration:none; display:block;border-top-left-radius: 3px; 
border-top-right-radius: 3px; color: #fff; border: solid 1px #2dbb62; padding: 8px 15px; background: #3adb64;}
.panel-heading > a.collapsed {
    color: #c1c1c1;
    background-color: #000;
    border-color: transparent;
}
.panel-heading > a:hover{color:#fff;}
.panel-heading > a.collapsed:hover {
    background: #3adb64;
    border: solid 1px #2dbb62;
	color: #fff;
}
.panel {
    margin-bottom: 12px;
    background-color: rgba(58, 58, 58, 0.7);
    border: 1px solid transparent;
    border-radius: 4px;
    -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
    box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}
.panel-default {
    border-color: #565656;
}
.panel-heading {

}
.panel-title {
    margin-top: 0;
    margin-bottom: 0;
    font-size: 15px;
    color: inherit;
	font-weight: normal;
}
.collapse {
    display: none;
}
.collapse.in {
    display: block;
}
.panel-body {
    padding: 15px;
}
.panel-default > .panel-heading + .panel-collapse > .panel-body {
    border-top: solid 1px #ddd;
}
.panel-body:before{
	display: table;
    content: " ";
}
.panel-body:after{
	display: table;
    content: " ";
	clear:both;
}
.collapsing {
    position: relative;
    height: 0;
    overflow: hidden;
    -webkit-transition-timing-function: ease;
    -o-transition-timing-function: ease;
    transition-timing-function: ease;
    -webkit-transition-duration: .35s;
    -o-transition-duration: .35s;
    transition-duration: .35s;
    -webkit-transition-property: height, visibility;
    -o-transition-property: height, visibility;
    transition-property: height, visibility;
}
h2.head {margin: 15px 0 20px 0; font-size: 17px;}
.panel-body ol.list {
    margin: 0 0 0 20px;
    padding: 0;
}
.static_container p {margin:5px 0; color:#fff;}
</style>

 <main id="mainContent" tabindex="0" class="ism">
        <div class="static_container">
			        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			            <h2 class="head">How Can We Help?<br/></h2>
			            <div class="panel panel-default">
			                <div class="panel-heading" role="tab" id="headingOne">
			                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne" class="collapsed">
			                      <h4 class="panel-title">I want to reset my password. What can I do?</h4>
			                    </a>
			                </div>
			                <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
			                    <div class="panel-body">
			                        
			                        <p>You can write us at support@the12thman.in and we will resolve your problem</p>
			                        
			                    </div>
			                </div>
			            </div>
			            <div class="panel panel-default">
			                <div class="panel-heading" role="tab" id="headingTwo">
			                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
			                      <h4 class="panel-title">I can't sign in. What do I need to do?</h4>
			                    </a>
			              	</div>
			                <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
			                    <div class="panel-body">
			                        <p>Please ensure you are using your registered e-mail address and correct password. Note that the password is case sensitive.</p>
			                        <BR>
			                        <p>If you have registered for the first time this season, you will need to activate your account before entering The 12thman Fantasy League team. An email will be sent to the email address you have registered with and contains a link.  You will need to click in order to activate your account. If you have not received an email, please check your spam or junk mail folders.</p>
			                        <BR>
			                        <p>If you do not receive the password reminder, please check your Junk folder in your email inbox and add noreply@mailout.users.the12thman.in to your address book.</p>
			                    </div>
			                </div>
			            </div>
			            <div class="panel panel-default">
			                <div class="panel-heading" role="tab" id="headingThree">
			                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
			                      <h4 class="panel-title">I have set up a team, but I can't see my History or renew my leagues from previous seasons. Can you link my new account to my old one?</h4>
			                    </a>
			        		</div>
			                <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
			                    <div class="panel-body">
			                        <p>Unfortunately, we cannot link your history from an old account to a new one. If you have set up a team for this season using a different email address, you will not be able to view your History from previous seasons on that account.</p>
			    
			                        <p>In order to see previous seasons' scores, you will need to sign in on the homepage using the registered email address and password combination from the previous seasons and set up a team using that account.</p> 
			                    </div>
			                </div>
			            </div>
			            
			            
			            <div class="panel panel-default">
			                <div class="panel-heading" role="tab" id="heading5">
			                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse5" aria-expanded="false" aria-controls="collapse5">
			                      <h4 class="panel-title">I have some suggestions and great ideas. I want to implement my ideas with The12thman. the What should I do?</h4>
			                    </a>
			        		</div>
			                <div id="collapse5" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading5">
			                    <div class="panel-body">We always appreciate such initiatives. You can send your ideas at support@the12thman.in. If we like your idea or suggestion, we will implement it and will award you. If you want to work with us on your idea, you are most welcome. </div>
			                </div>
			            </div>
			            <div class="panel panel-default">
			                <div class="panel-heading" role="tab" id="heading4">
			                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse4" aria-expanded="false" aria-controls="collapse4">
			                      <h4 class="panel-title">How can I contact The 12thman ?</h4>
			                    </a>
			        		</div>
			                <div id="collapse4" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading4">
			                    <div class="panel-body">You can send your query to support@the12thman.in. We will get back to you. </div>
			                </div>
			            </div>
			            
			        </div>
			    </div>

        <!-- Secondary content -->

    <div id="ismr-elements-menu"></div>
 
</main>
    
 
    
    <%-- <script src="/SportMgmt/js/vendor/jquery.js"></script> --%>
    <script src="/SportMgmt/js/vendor/what-input.js"></script>
    <script src="/SportMgmt/js/vendor/foundation.js"></script>
    <script src="/SportMgmt/js/app.js"></script>
    <script src="/SportMgmt/js/jquery.easing.1.3.js"></script>
    <script src="/SportMgmt/js/jquery.animate-enhanced.min.js"></script>
    <script src="/SportMgmt/js/jquery.superslides.js" type="text/javascript" charset="utf-8"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
