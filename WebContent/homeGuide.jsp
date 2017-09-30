<jsp:include page="homeHeader.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:set var="context" value="<%=request.getContextPath()%>" />

  
     
     <div class="row">
          <div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 top_banner1">
            <ul class="bxslider">
                  <li>
                      <h3>CHOOSE YOUR CHALLENGE</h3>
                      <img src="${context}/redBlackTheme/images/guide/Choose-Your-challenge.png" class="center-block"/>
                        <p>Are you ready to play your favourite fantasy sports and win prizes at the same time? Go to the lobby, filter by sport and choose your challenge!</p>
                </li>
               <li>
                      <h3>SELECT YOUR PLAYERS</h3>
                      <img src="${context}/redBlackTheme/images/guide/Choose-Players.png" class="center-block"/>
                        <p>Create your lineup of players while staying within the salary cap. Which players are in good form? Who is due for a big game? What's your selection strategy?</p>
                </li>
                <li>
                      <h3>WATCH THE ACTION LIVE</h3>
                      <img src="${context}/redBlackTheme/images/guide/Watch-Live.png" class="center-block"/>
                        <p>This is where the excitement really starts! Your players accrue points based on their real life performance. Make sure you keep an eye on the live leaderboard as you climb to number one!</p>
                </li>
                <li>
                      <h3>WIN AND COLLECT</h3>
                      <img src="${context}/redBlackTheme/images/guide/win-prizes.png" class="center-block"/>
                        <p>Win your share of the prize pool in each challenge. Using the prize money in your digital wallet, check out the variety of gift vouchers and products now available at the gift store. What will you buy?</p>
                </li>
                  
                </ul>
            </div>
          </div>
          
         
       
     
 <jsp:include page="homeFooter.jsp" /> 
</div>
</body>
</html>