<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="context" value="<%=request.getContextPath()%>" />
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1  fixture_img_ad">
            	<img src="${context}/redBlackTheme/images/dream11-img.png" class="img-responsive center-block">
                <!-- Primary content -->
                <div id="leaguer-main" class="demo demo_fixtures">
					<div>
						<div class="col-lg-6 col-lg-offset-3 col-md-8 col-md-offset-2">
							<div id="fixtures-head" class="panel-group">
								<h3>Fixtures </h3>
								
								<div  class="panel-heading">
									
									<div class="prev_next_btn">
										<a class="btn  btnPrevious" onclick="updateMatchDetails(false);" href="javascript:void(0);">Previous</a>
										 <h5></h5>
										<a class="btn  btnNext" onclick="updateMatchDetails(true);" href="javascript:void(0);">Next</a>
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
                
<script src="${context}/redBlackTheme/js/jquery.js"></script>

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
			
			html += '<div class="date_time">'+matchesMapJson.gameWeekList[matchesMapJson.currentGameWeek-1].matchMap[key][0].formatedDate1+'</div>';
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
				var startHourStr = ''+startHour;
				if(parseInt(startHour) < 10)
				{
					startHourStr = '0'+startHour;
					//alert(startHourStr);
				}
				var startMinuteStr = ''+startMinute;
				if(parseInt(startMinute) < 10)
				{
					startMinuteStr = '0'+startMinute;
				}
				var startTime = startHourStr+':'+startMinuteStr;
				if(index == 0 && daycounter == 0)
				{
					if((parseInt(startHour)-1) < 10)
					{
						startHourStr = '0'+(parseInt(startHour)-1);
					}
					headHtml +=' '+startHourStr+':'+startMinuteStr;
				}
				var firstClubCss = clubLogoMap[firstClubId];
				var secondClubCss = clubLogoMap[secondClubId];
				html += '<div class="fixture_bar_ongoing">'+
				
				'<div class="team_points_flex1 ongoing_flex1">'+firstClubName +'<span class="badge-25 '+firstClubCss+'"></span></div>'+
				'<div class="">'+startTime+'</div>'+
				/* '<div class="team_points_flex1 points"><span></span> </div>'+ */
				
				'<div class="team_points_flex1 ongoing_flex2">'+secondClubName +'<span class="badge-25 '+secondClubCss+'"></span></div>'+
				'</div>';	
			}
			daycounter +=1;
		}
		$('.fixtures-team').html(html);
		$('#fixtures-head h5').html(headHtml);
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
