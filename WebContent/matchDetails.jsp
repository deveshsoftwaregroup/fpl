<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet" href="/SportMgmt/css/font-awesome.css" type="text/css">
	<link rel="stylesheet" href="/SportMgmt/css/team.css" type="text/css">
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <div class="league-pusher leaguejs-page-transition">
                <!-- Primary content -->
                <div id="leaguer-main" class="league-main">
					<div>
						<div class="fixtures league-bordered league-bordered--highlight">
							<div class="fixtures-head">
								<h5> </h5>
								<div class="head-main">
									<div class="fixtures-logo">
										Fixtures <span></span>
									</div>
									<div class="fixtures-pegination">
										<a class="peg-lnk" onclick="updateMatchDetails(false);" href="javascript:void(0);">Previous <i class="fa fa-angle-left"></i></a>
										<a class="peg-lnk" onclick="updateMatchDetails(true);" href="javascript:void(0);">Next <i class="fa fa-angle-right"></i></a>
									</div>
								</div>
							</div>
							<div class="fixtures-team">
								<div class="team-row date">Match Date</div>
								<div class="team-row">
									<div class="row-lft">Team A<span class="badge-25 MUN"></span></div>
									<div class="row-mid">Match Time</div>
									<div class="row-rgt"><span class="badge-25 MCI"></span>Team B</div>
								</div>
							
							</div>
						</div>
					</div>
				</div>
</div>
                <!-- Secondary content -->
                
 <script src="/SportMgmt/js/jquery.js"></script> 
  <script src="/SportMgmt/js/bootstrap.min.js"></script> 
<script type="text/javascript">
	$(window).load(function(){
	ToggleShow('.1-box', '.check_1'); ToggleShow('.2-box', '.check_2');
	ToggleShow('.3-box', '.check_3');
	ToggleShow('.4-box', '.check_4');
	ToggleShow('.5-box', '.check_5');
	ToggleShow('.6-box', '.check_6');
	ToggleShow('.7-box', '.check_7');
	ToggleShow('.8-box', '.check_8');
	ToggleShow('.9-box', '.check_9');
	ToggleShow('.10-box', '.check_10');
	ToggleShow('.11-box', '.check_11');
	ToggleShow('.12-box', '.check_12');
	ToggleShow('.13-box', '.check_13');
	ToggleShow('.14-box', '.check_14');
	ToggleShow('.15-box', '.check_15');
	ToggleShow('.16-box', '.check_16');

	function ToggleShow(checkbox, div) {
		$(checkbox).change(function () {
			$(div).toggleClass('enable');
		});
	}
	});
	var matchesMapJson = null;
	$( document ).ready(function() {
 	    console.log("ready!" );
 	   updateMatchDetails(true);
 	});
	function updateMatchDetails(isNext)
	{
		var html='';
		if(isNext)
		{
			
			matchesMapJson.currentGameWeek = matchesMapJson.currentGameWeek +1;
		}
		else
		{
			matchesMapJson.currentGameWeek = matchesMapJson.currentGameWeek -1;
		}
		if(matchesMapJson.currentGameWeek <=0)
		{
			matchesMapJson.currentGameWeek = matchesMapJson.totalGameWeek;
		}
		else if(matchesMapJson.currentGameWeek > matchesMapJson.totalGameWeek)
		{
			matchesMapJson.currentGameWeek = 1;
		}
		var headHtml = matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].gameWeekName+' - ';
		var daycounter = 0;
		for (var key in matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap) {
			
			html += '<div class="team-row date">'+matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][0].formatedDate1+'</div>';
			if(daycounter ==0)
			headHtml +=matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][0].formatedDate2;
			for(var index = 0;index < matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key].length; index++)
			{
				var firstClubName = matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][index].firstClubName;
				var secondClubName = matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][index].secondClubName;
				var firstClubId = matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][index].firstClubId;
				var secondClubId = matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][index].secondClubId;
				var startHour = matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][index].startHour;
				var startMinute = matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][index].startMinute;
				var startTime = startHour+':'+startMinute;
				if(index == 0 && daycounter == 0)
				{
					headHtml +=' '+(startHour-1)+':'+startMinute;
				}
				var firstClubCss = clubLogoMap[firstClubId];
				var secondClubCss = clubLogoMap[secondClubId];
				html += '<div class="team-row">'+
				'<div class="row-lft">'+firstClubName +'<span class="badge-25 '+firstClubCss+'"></span></div>'+
				'<div class="row-mid">'+startTime+'</div>'+
				'<div class="row-rgt">'+secondClubName +'<span class="badge-25 '+secondClubCss+'"></span></div>'+
				'</div>';	
			}
			daycounter +=1;
		}
		$('.fixtures-team').html(html);
		$('.fixtures-head h5').html(headHtml);
	}
</script>
<c:if test="${not empty matchesMapJson}">
   	<script type="text/javascript">
   	matchesMapJson = ${matchesMapJson};
   	</script>
</c:if>
<c:if test="${not empty sessionScope.clubList}">
   	<script type="text/javascript">
   		var clubLogoMap = {};
   	</script>
   	<c:forEach var="clubMap" items="${sessionScope.clubList}">
   	<spring:message code="club_${clubMap['clubId']}_logo_css" var="imageSrc" />;
    <script type="text/javascript">
    clubLogoMap["${clubMap['clubId']}"] = "${imageSrc}";
    </script>
    </c:forEach>
  </c:if>
