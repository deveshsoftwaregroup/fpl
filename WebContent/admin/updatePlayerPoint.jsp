<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.mask 
{
	background: #000;
	opacity: 0.5;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}
</style>
<script src="/SportMgmt/js/jquery.js"></script>
<script type="text/javascript">
$(document).ajaxStart(function(){
		$("#ajaxloader").css("display", "block");
		$('.mask').show();
	});

	$(document).ajaxComplete(function(){
	    $("#ajaxloader").css("display", "none");
	    $('.mask').hide();
	});
	function updatePlayerPoint()
	{
			var player = $("#player");
			var point = $("#point");
			var gameId = $("#gameId").val();
			var matchId = $("#matchId").val();
			var gameWeekId = $("#gameWeekId").val();
			console.log("player: "+player+" , point:"+point+", gameId:"+gameId+", matchId: "+matchId);
			if(player !='undefined' && point !='undefined' && gameId !='undefined' && matchId !='undefined' && gameWeekId !='undefined')
			{
				url ="/SportMgmt/mvc/game/updatePoint?matchId="+matchId+"&gameClubPlayerId="+$(player).val()+"&pointId="+$(point).val()+"&gameWeekId="+gameWeekId;
				$.ajax({
		     		  url: url,
		     		  method: 'POST',
		     		  dataType: 'json',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			// $('.ism-container').html(resp);
		     			if(resp.isSuccess == 'true')
		     			{
		     				showNotification("Point updated successfully");
		     			}
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log( 'something went wrong', status, err );
		     		  }
		     		});	
			
			}
	}
	
	function updateRank()
	{
			var gameWeekId = $("#gameWeekId").val();
			console.log("gameWeekId: "+gameWeekId);
			if(gameWeekId !='undefined')
			{
				url ="/SportMgmt/mvc/game/updateRank/"+gameWeekId;
				$.ajax({
		     		  url: url,
		     		  method: 'POST',
		     		  dataType: 'json',
		     		  success: function( resp ) {
		     			 //console.log(resp); 
		     			// $('.ism-container').html(resp);
		     			if(resp.isSuccess == 'true')
		     			{
		     				showNotification("Rank updated successfully");
		     			}
		     		  },
		     		  error: function( req, status, err ) {
		     		    console.log('something went wrong', status, err );
		     		  }
		     		});	
			
			}
	}
</script>
<title>Insert title here</title>
</head>
<body>
<c:choose>
<c:when test="${isSuccess}">
<input type="hidden" id="gameId" value="${gameId}" />
<input type="hidden" id="matchId" value="${matchId}" />
<input type="hidden" id="gameWeekId" value="${gameWeekId}" />
<select id="player" class="ism-form__select">
   <option value="0">Select Player</option>
   <c:forEach var="playerMap" items="${playerList}" >
   <option value="${playerMap.gameClubPlayerId}">${playerMap.name}</option>
   </c:forEach>
</select>
<br/><br/>
<select id="point" class="ism-form__select">
   <option value="0">Select Point To Apply</option>
   <c:forEach var="pointMap" items="${pointList}" >
   <option value="${pointMap.pointId}">${pointMap.pointName}</option>
   </c:forEach>
</select>
<br/><br/>
<button onclick="updatePlayerPoint();">ADD PLAYER POINT</button>
<br/><br/>
<button onclick="updateRank();">UPDATE RANK</button>
<div class="mask" style="display: none;"></div>
<div id="ajaxloader" style="display:none;"></div>
</c:when>
<c:otherwise>
<h1><c:out value="${message}" /></h1>
</c:otherwise>
</c:choose>
</body>
</html>