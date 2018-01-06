<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<meta property="og:url"           content="https://www.facebook.com/sharer/sharer.php?http://localhost:8282/SportMgmt/redGreenTheme/guide.html" />
  <meta property="og:type"          content="website" />
  <meta property="og:title"         content="DREAMELEVEN" />
  <meta property="og:description"   content="Your description..."/>
  <meta property="og:image"         content="http://localhost:8282/SportMgmt/redGreenTheme/guide.html" />
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:set var="context" value="<%=request.getContextPath()%>" />
<link rel="shortcut icon" type="images/x-icon" href="${context}/redBlackTheme/images/favicon.ico">
</head>
<body>
<!-- Load Facebook SDK for JavaScript -->
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.10&appId=1822644338025932";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
  
<!-- facebook button starts -->
			<!-- <div class="fb-share-button" data-href="http://justthinksports.com"
				 data-layout="button_count" data-size="small" data-mobile-iframe="true">
				<a class="fb-xfbml-parse-ignore" target="_blank"
					 href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2Fjustthinksports.com%3A8090%2FSportMgmt%2Fmvc%2FHomeGuide&amp;src=sdkpreparse">Share</a>
			</div>   -->
			<div class="share_buttn"><div class="fb-like" data-href="https://www.facebook.com/Twelfthmantimes/" data-layout="button_count" data-action="recommend" data-size="small" data-show-faces="false" data-share="true"></div><div><a href="https://twitter.com/share?ref_src=twsrc%5Etfw" class="twitter-share-button" data-show-count="false">Tweet</a>
 <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
 <link rel="canonical"
  href="https://twitter.com/the12thmantimes"></div>			<!-- facebook button ends -->
			</div>
			</body>
