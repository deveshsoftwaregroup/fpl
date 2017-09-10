<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib uri="sportmgmt.tld" prefix="s" %>  
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<s:sportExt retrieve="priceList" />
<s:sportExt retrieve="deadLine" />
<div class="row">
         <div class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1 transfers_predict11_map">
            <div>
               <h3>Select Players from List</h3>
                <p>Gameweek ${gameWeekNumber} Deadline: <time datetime="2016-08-27T10:30:00Z">${deadline}</time><p>
               
                <br>
               <p>Player Count: <span class="added-player-count"> </span> </p>
               
               
               
									
                       
                        
                   
                    <section>
                        <h3 class="visuallyHidden">My Squad</h3>
                        <div id="ismr-errors" class="ism-alert-wrap">
                            <div>
                            </div>
                        </div>
                        <div id="ismr-info" class="ism-alert-wrap">
                            <div>
                                <div id="ismjs-squad-info" tabindex="0">

                                </div>
                            </div>
                        </div>
                        <div class="ism-squad-wrapper">
                            <div class="ismjs-a11y-tabs ism-tabs">
                               

                                <section id="ismr-summary" class="ism-pitch" role="tabpanel">
                                    <div tabindex="0">

                                        <div class="ism-element-row ism-element-row--pitch">
                                            <div class="ism-pitch__unit ism-pitch__unit--4"></div>                                            
                                            <div id="ismr-pos1"  class="ism-pitch__unit ism-pitch__unit--4">
                                                <div>
                                                <s:sport position="1" playerType="Goalkeeper"/>
                                                    <div class="ism-element" tabindex="0">
                                                        <div 
                                                        <c:choose>
                                                        <c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when>
                                                        <c:otherwise>class="ismjs-select"</c:otherwise>
                                                        </c:choose>
                                                        >
                                                            <picture>
                                                            
                                                                <img src="/SportMgmt/images/animated_wk.gif"  alt="" title="Select a Goalkeeper from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Goalkeeper" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                <abbr title="Goalkeeper" class="ism-element__type"><span class="ism-element__type__short">GKP</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>                                                            
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>                                            
                                            
                                            <div class="ism-pitch__unit ism-pitch__unit--4"></div>
                                        </div>

                                        <div class="ism-element-row ism-element-row--pitch">
                                            <div id="ismr-pos3" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                <s:sport position="1" playerType="Defender"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div 
                                                        <c:choose>
                                                        	<c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"
                                                        	
                                                        	</c:when>
                                                        	<c:otherwise>class="ismjs-select"</c:otherwise>
                                                        </c:choose>
                                                        >

                                                            <picture>                                                                
                                                                <img src="/SportMgmt/images/animated_bat.gif" 
                                                                alt="" title="Select a Defender from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>
															
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                 <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                            
                                                          </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div id="ismr-pos4" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                 <s:sport position="2" playerType="Defender"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                                
                                                                <img src="/SportMgmt/images/animated_bat.gif"  alt="" title="Select a Defender from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>

                                                           
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                 <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div id="ismr-pos5" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                 <s:sport position="3" playerType="Defender"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                               
                                                                <img src="/SportMgmt/images/animated_bat.gif" alt="" title="Select a Defender from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>

                                                           
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                 <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div id="ismr-pos6" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                 <s:sport position="4" playerType="Defender"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                               <img src="/SportMgmt/images/animated_bat.gif" alt="" title="Select a Defender from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>

                                                           
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                 <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>

                                        

                                        <div class="ism-element-row ism-element-row--pitch">
                                            <div id="ismr-pos11" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                <s:sport position="1" playerType="Midfielder"/>
                                                    <div class="ism-element" tabindex="0">
                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                                <img src="/SportMgmt/images/animated_bowl.gif" alt="" title="Select a Midfielder from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>
															
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                            </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="ismr-pos12" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                 <s:sport position="2" playerType="Midfielder"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                                <img src="/SportMgmt/images/animated_bowl.gif"  alt="" title="Select a Midfielder from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>

                                                           
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div id="ismr-pos13" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                 <s:sport position="3" playerType="Midfielder"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                                 <img src="/SportMgmt/images/animated_bowl.gif"  alt="" title="Select a Midfielder from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>

                                                           
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div id="ismr-pos14" class="ism-pitch__unit ism-pitch__unit--5">
                                                <div>
                                                <s:sport position="4" playerType="Midfielder"/>
                                                    <div class="ism-element" tabindex="0">
                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                                     <img src="/SportMgmt/images/animated_bowl.gif" alt="" title="Select a Midfielder from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                 <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                           
                                        </div>
                                        <div class="ism-element-row ism-element-row--pitch">
                                            <div id="ismr-pos8" class="ism-pitch__unit ism-pitch__unit--3">
                                                <div>
                                                <s:sport position="1" playerType="Forward"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                                   <img src="/SportMgmt/images/animated_ar.gif" alt="" title="Select a Forward from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>
															
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                 <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">FWD</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div id="ismr-pos9" class="ism-pitch__unit ism-pitch__unit--3">
                                                <div>
                                                <s:sport position="2" playerType="Forward"/>
                                                    <div class="ism-element" tabindex="0">

                                                        <div <c:choose><c:when test='${isPlayerAvail}'>class="ismjs-select added-player-css" id="${gameClubPlayerId}"</c:when><c:otherwise>class="ismjs-select"</c:otherwise></c:choose>>

                                                            <picture>
                                                               <img src="/SportMgmt/images/animated_ar.gif"  alt="" title="Select a Forward from the player list" class="ism-shirt ism-element__shirt">
                                                            </picture>

                                                            
                                                             <c:choose>
                                                             <c:when test="${isPlayerAvail}">
                                                             	<div class="ism-element__name ism-element__name--placeholder">
                                                                ${playerName} <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">${price}</span></abbr>
                                                             </div>
                                                             </c:when>
                                                             <c:otherwise>
                                                             <div class="ism-element__name ism-element__name--placeholder">
                                                                <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">FWD</span></abbr>
                                                             </div>
                                                             </c:otherwise>
                                                             </c:choose>

                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>
                                        

                                    </div>
                                </section>
                               
                                <section id="ismr-detail" class="ism-detail" role="tabpanel" aria-hidden="true">
                                    <div tabindex="-1">
                                        <div>
                                            <div class="table">
                                                <table class="ism-table ism-table--el ism-table--squad">
                                                    <thead>
                                                        <tr class="ism-table__divider ism-el-type ism-el-type--1">
                                                            <th class="ism-table--squad__status"></th>
                                                            <th class="ism-table--squad__name">Goalkeeper</th>
                                                            <th class="ism-table--squad__price"><abbr title="Price in Million INR"> INR</abbr></th>
                                                            <th class="ism-table--squad__tsb"><abbr title="Teams selected by %">SB</abbr></th>
                                                            <th class="ism-table--squad__pts-tot"><abbr title="Total points">TP</abbr></th>
                                                            <th class="ism-table--squad__fixture"><abbr title="Fixture next Gameweek">FIX</abbr></th>
                                                        </tr>
                                                    </thead>
                                                    </table>
                                                    <table class="ism-table ism-table--el ism-table--squad">
                                                    <tbody>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Goalkeeper</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Goalkeeper</a>
                                                            </td>

                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="table">
                                                <table class="ism-table ism-table--el ism-table--squad">
                                                    <thead>
                                                        <tr class="ism-table__divider ism-el-type ism-el-type--2">
                                                            <th class="ism-table--squad__status"></th>
                                                            <th class="ism-table--squad__name">Defenders</th>
                                                            <th class="ism-table--squad__price"><abbr title="Price in Million INR">INR</abbr></th>
                                                            <th class="ism-table--squad__tsb"><abbr title="Teams selected by %">SB</abbr></th>
                                                            <th class="ism-table--squad__pts-tot"><abbr title="Total points">TP</abbr></th>
                                                            <th class="ism-table--squad__fixture"><abbr title="Fixture next Gameweek">FIX</abbr></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Defender</a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Defender</a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Defender</a>
                                                            </td>
                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Defender</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Defender</a>
                                                            </td>

                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div>
                                            <div class="table">
                                                <table class="ism-table ism-table--el ism-table--squad">
                                                    <thead>
                                                        <tr class="ism-table__divider ism-el-type ism-el-type--3">
                                                            <th class="ism-table--squad__status"></th>
                                                            <th class="ism-table--squad__name">Midfielders</th>
                                                            <th class="ism-table--squad__price"><abbr title="Price in Million INR">INR</abbr></th>
                                                            <th class="ism-table--squad__tsb"><abbr title="Teams selected by %">SB</abbr></th>
                                                            <th class="ism-table--squad__pts-tot"><abbr title="Total points">TP</abbr></th>
                                                            <th class="ism-table--squad__fixture"><abbr title="Fixture next Gameweek">FIX</abbr></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Midfielder</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Midfielder</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Midfielder</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Midfielder</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Midfielder</a>
                                                            </td>

                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div> 
                                                                                <div>
                                            <div class="table">
                                                <table class="ism-table ism-table--el ism-table--squad">
                                                    <thead>
                                                        <tr class="ism-table__divider ism-el-type ism-el-type--4">
                                                            <th class="ism-table--squad__status"></th>
                                                            <th class="ism-table--squad__name">Forwards</th>
                                                            <th class="ism-table--squad__price"><abbr title="Price in Million INR">INR </abbr></th>
                                                            <th class="ism-table--squad__tsb"><abbr title="Teams selected by %">SB</abbr></th>
                                                            <th class="ism-table--squad__pts-tot"><abbr title="Total points">TP</abbr></th>
                                                            <th class="ism-table--squad__fixture"><abbr title="Fixture next Gameweek">FIX</abbr></th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Forward</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Forward</a>
                                                            </td>

                                                        </tr>
                                                        <tr>

                                                            <td></td>
                                                            <td colspan="5" class="ism-table--el__placeholder">
                                                                <a href="#" class="ismjs-select">Select Forward</a>
                                                            </td>

                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>                                       
                                    </div>
                                </section>
                            </div>
                        </div>                        
                    </section>                  
                </div>                
                <div id="ismr-squad-menu"></div>
                <div id="ismr-help"></div>
                <div id="ismr-confirm"></div>
               
                <BR>
                
                
            </div>
        </div>

        <!-- Secondary content -->
        
        <div id="ismr-side" class="ism-sidebar">
            <div>
       
                <section class="ism-bordered ism-bordered--primary">

                    <div class="ism-section-header">
                        <h3 class="subHeader ism-sub-header ism-section-header__title" tabindex="0" id="ismjs-side-focus">Player Selection</h3>
                       
                    </div>

                    <div id="ismr-sideboard">
                        <div>

                            <div class="ism-deadline-bar ism-deadline-bar--side">                               
									<h4 class="league-deadline-bar__heading">Gameweek ${gameWeekNumber} Deadline: <time datetime="2016-08-27T10:30:00Z" class="league-deadline-bar__deadline">${deadline}</time></h4>
					         </div>
                        </div>

                            <div class="ism-sideboard">
                                <div class="ism-scoreboard__panel">                                   
                                	 
                                	 <div class="remain_coin">Players Selected : 
                                	 	<span id="planBalanceDiv" class="added-player-count"></span>
                                	 	</div>
       
                                </div>
              
                            </div>

                        </div>
                    </div>

                    <form class="ism-form">
                        <div class="ism-form__group">
                            <label for="ismjs-element-filter" class="ism-form__label">View</label>
                            <div class="ism-form__select-wrap">
                                <select id="ismjs-element-filter" class="ism-form__select" data-global="Global" data-position="By Position" data-team="By Team">
                                    <optgroup label="Global">
                                        <option value="all">All players</option>
                                    </optgroup>
                                    <optgroup label="By Position">
                                        <option value="Goalkeepers">Goalkeepers</option>
                                        <option value="Defenders">Defenders</option>
                                        <option value="Midfielders">Midfielders</option> 
                                        <option value="Forwards">Forwards</option>                                                                               
                                    </optgroup>
                                    <optgroup label="By Team">
                                    <c:forEach var="clubMap" items="${sessionScope.clubList}">
                                    	<option value="club_${clubMap['clubId']}">${clubMap['name']}</option>
                                    </c:forEach>
                                    </optgroup>
                                </select>
                            </div>
                        </div>                       
                        
                                         

                    </form>

                    <div id="ismr-sideboard"></div>
                    
                    <div id="ismr-elements-list"><div>

    <p class="ism-elements-shown"><strong class="ism-elements-shown__num">${fn:length(sessionScope.playerList)}</strong> players shown</p>

    <div id="ismjs-elements-list-tables"><div>
    <div class="table" id="Goalkeepers" >
        <table class="ism-table ism-table--el ism-table--el-list" style="margin-bottom: 0;">
            <thead>
                <tr class="ism-table__divider ism-el-type ism-el-type--1">
                    <th class="ism-table--el-list__status"></th>
                    <th class="ism-table--el-list__name"><a href="#" class="ism-link--bold">Goalkeepers</a></th>
                    <th class="ism-table--el-list__price"><abbr title="Price in Million INR">&#8377</abbr></th>
                    <c:choose>
                    <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><th class="ism-table--el-list__stat"><abbr title="Total Score">UC</abbr></c:when>
                    <c:otherwise><th class="ism-table--el-list__stat"><abbr title="Total Score">TS</abbr></th></c:otherwise>
                    </c:choose>
                </tr>
            </thead>
            </table>
            </div>
            <div class="table scroll-tbl" id="Goalkeepers" >
            <table class="ism-table ism-table--el ism-table--el-list">
            <tbody>
            <c:forEach var="playerMap" items="${sessionScope.playerList}">
            <c:if test="${playerMap.type eq 'Goalkeeper'}">
            <tr class="ismjs-menu ism-row-select" id="${playerMap.gameClubPlayerId}">
    <td class="ism-table--el__status text-center addPlayer">
        
            <a href="javascript:void(0);" onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');"><i class="fa fa-plus" aria-hidden="true"></i></a>
        
    </td>
    <td class="ism-table--el__primary">
        <div class="ism-media ism-media--centred">
            <div class="ism-media__figure">
				<c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
					<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
				</c:if>	
              <!--  player list image -->              
                    <img src="/SportMgmt/images/Goalkeeper_${imageSrc}" height="20" width="20" alt="Arsenal" title="${playerMap.name}" class="ism-shirt">
            </div>
            <div class="ism-media__body ism-table--el__primary-text">
                <a href="#" class="ism-table--el__name">${playerMap.name}</a>
                <span class="ism-table--el__strong"><a href="javascript:void(0);"   title="Add Player"></a></span>
            </div>
        </div>

    </td>
    <td class="ism-table--el__strong playerPrice">${playerMap.price}</td>
    <c:choose>
        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><td class="ism-table--el__strong">${playerMap.userCount}</td></c:when>
        <c:otherwise><td class="ism-table--el__strong">${playerMap.totalScore}</td></c:otherwise>
    </c:choose>
</tr>
</c:if>
 </c:forEach>
</tbody>
        </table>
    </div>
	</div>
<div>
    <div class="table" id="Defenders">
        <table class="ism-table ism-table--el ism-table--el-list" style="margin-bottom: 0;">
            <thead>
                <tr class="ism-table__divider ism-el-type ism-el-type--2">
                    <th class="ism-table--el-list__status"></th>
                    <th class="ism-table--el-list__name"><a href="#" class="ism-link--bold">Defenders</a></th>
                    <th class="ism-table--el-list__price"><abbr title="Price in Million INR">&#8377</abbr></th>
                    <c:choose>
                    <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><th class="ism-table--el-list__stat"><abbr title="Total Score">UC</abbr></c:when>
                    <c:otherwise><th class="ism-table--el-list__stat"><abbr title="Total Score">TS</abbr></th></c:otherwise>
                    </c:choose>
                </tr>
            </thead>
            </table>
            </div>
            <div class="table scroll-tbl" id="Defenders">
        <table class="ism-table ism-table--el ism-table--el-list">
            <tbody>
            <c:forEach var="playerMap" items="${sessionScope.playerList}">
            <c:if test="${playerMap.type eq 'Defender'}">
            <tr class="ismjs-menu ism-row-select" id="${playerMap.gameClubPlayerId}">
    <td class="ism-table--el__status text-center addPlayer">
        
            <a href="javascript:void(0);" onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');"><i class="fa fa-plus" aria-hidden="true"></i></a>
        
    </td>
    <td class="ism-table--el__primary">
        <div class="ism-media ism-media--centred">
            <div class="ism-media__figure">
				<c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
				<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
				</c:if>
               <img src="/SportMgmt/images/Defender_${imageSrc}" height="20" width="20" alt="Arsenal" title="${playerMap.name}" class="ism-shirt">
                
            </div>

            <div class="ism-media__body ism-table--el__primary-text">
                <a href="#" class="ism-table--el__name">${playerMap.name}</a>
                <span class="ism-table--el__strong"><a href="javascript:void(0);"  title="Add Player"></a></span>
            </div>
        </div>

    </td>
    <td class="ism-table--el__strong playerPrice">${playerMap.price}</td>
    <c:choose>
        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><td class="ism-table--el__strong">${playerMap.userCount}</td></c:when>
        <c:otherwise><td class="ism-table--el__strong">${playerMap.totalScore}</td></c:otherwise>
    </c:choose>
</tr>
</c:if>
</c:forEach>
</tbody>
        </table>
    </div>
</div>


<div>
    <div class="table" id="Midfielders">
        <table class="ism-table ism-table--el ism-table--el-list" style="margin-bottom: 0">
            <thead>
                <tr class="ism-table__divider ism-el-type ism-el-type--3">
                    <th class="ism-table--el-list__status"></th>
                    <th class="ism-table--el-list__name"><a href="#" class="ism-link--bold">Midfielder</a></th>
                    <th class="ism-table--el-list__price"><abbr title="Price in Million INR">&#8377</abbr></th>
                    <c:choose>
                    <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><th class="ism-table--el-list__stat"><abbr title="Total Score">UC</abbr></c:when>
                    <c:otherwise><th class="ism-table--el-list__stat"><abbr title="Total Score">TS</abbr></th></c:otherwise>
                    </c:choose>
                </tr>
            </thead>
            </table>
            </div>
            <div class="table scroll-tbl" id="Midfielders">
        <table class="ism-table ism-table--el ism-table--el-list">
            <tbody>
            <c:forEach var="playerMap" items="${sessionScope.playerList}">
            <c:if test="${playerMap.type eq 'Midfielder'}">
            <tr class="ismjs-menu ism-row-select" id="${playerMap.gameClubPlayerId}">
    <td class="ism-table--el__status text-center addPlayer">
        
            <a href="javascript:void(0);" onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');"><i class="fa fa-plus" aria-hidden="true"></i></a>
        
    </td>
    <td class="ism-table--el__primary">
        <div class="ism-media ism-media--centred">
            <div class="ism-media__figure">
				<c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
				<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
				</c:if>
               <img src="/SportMgmt/images/Midfielder_${imageSrc}" height="20" width="20" alt="Arsenal" title="${playerMap.name}" class="ism-shirt">
                
            </div>

            <div class="ism-media__body ism-table--el__primary-text">
                <a href="#" class="ism-table--el__name">${playerMap.name }</a>
                <span class="ism-table--el__strong"><a href="javascript:void(0);"  title="Add Player"></a></span>
            </div>
        </div>

    </td>
    <td class="ism-table--el__strong playerPrice">${playerMap.price}</td>
    <c:choose>
        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><td class="ism-table--el__strong">${playerMap.userCount}</td></c:when>
        <c:otherwise><td class="ism-table--el__strong">${playerMap.totalScore}</td></c:otherwise>
    </c:choose>
</tr>
</c:if>
</c:forEach>
</tbody>
        </table>
    </div>
</div>
<div>
    <div class="table" id="Forwards" >
        <table class="ism-table ism-table--el ism-table--el-list" style="margin-bottom: 0">
            <thead> 
                <tr class="ism-table__divider ism-el-type ism-el-type--4">
                    <th class="ism-table--el-list__status"></th>
                    <th class="ism-table--el-list__name"><a href="#" class="ism-link--bold">Forward</a></th>
                    <th class="ism-table--el-list__price"><abbr title="Price in Million INR">&#8377</abbr></th>
                    <c:choose>
                    <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><th class="ism-table--el-list__stat"><abbr title="Total Score">UC</abbr></c:when>
                    <c:otherwise><th class="ism-table--el-list__stat"><abbr title="Total Score">TS</abbr></th></c:otherwise>
                    </c:choose>
                </tr>
            </thead>
            </table>
            </div>
            <div class="table scroll-tbl" id="Forwards">
        <table class="ism-table ism-table--el ism-table--el-list">
            <tbody>
            <c:forEach var="playerMap" items="${sessionScope.playerList}">
            <c:if test="${playerMap.type eq 'Forward'}">
            <tr class="ismjs-menu ism-row-select ism-element-list__info--0" id="${playerMap.gameClubPlayerId}">
    <td class="ism-table--el__status text-center addPlayer">        
            <a href="javascript:void(0);"  onclick="addPlayer('${sessionScope.userId}','${playerMap.gameClubPlayerId}');" ><i class="fa fa-plus" aria-hidden="true"></i></a>
        
    </td>
    <td class="ism-table--el__primary">
        <div class="ism-media ism-media--centred">
            <div class="ism-media__figure">
            
               <c:if test="${not empty playerMap.clubId and playerMap.clubId ne ''}">
				<c:set value="${clubImageMap[playerMap.clubId]}" var="imageSrc" />
				</c:if>
               <img src="/SportMgmt/images/Forward_${imageSrc}" height="20" width="20" alt="Arsenal" title="${playerMap.name}" class="ism-shirt">
            </div>
            <div class="ism-media__body ism-table--el__primary-text">
                <a href="#" class="ism-table--el__name">${playerMap.name}</a>
                <span class="ism-table--el__strong"><a href="javascript:void(0);"   title="Add Player"></a></span>
            </div>
        </div>

    </td>
    <td class="ism-table--el__strong playerPrice">${playerMap.price }</td>
    <c:choose>
        <c:when test="${sessionScope.playersOrderBy eq 'user_count'}"><td class="ism-table--el__strong">${playerMap.userCount}</td></c:when>
        <c:otherwise><td class="ism-table--el__strong">${playerMap.totalScore}</td></c:otherwise>
    </c:choose>
</tr>
</c:if>
</c:forEach>
</tbody>
        </table>
    </div>
</div>
</div>
</div></div>
                </section>

            </div>
        </div>
   
    
   <script type="text/javascript">
   var gameDetailsJson = null;
   var playerListJson = null;
   var clubListJson = null;
   var userGameJson = null;
   var userGameJsonDreamEleven = null;   
   var purchableWildCardJson = null;
   </script>
   	<c:if test="${not empty sessionScope.gameDetailsJson}">
   	<script type="text/javascript">
   		gameDetailsJson = ${sessionScope.gameDetailsJson};
   	</script>
   	</c:if>
   	<c:if test="${not empty sessionScope.playerListJson}">
   		<script type="text/javascript">
  		 playerListJson = ${sessionScope.playerListJson};
  		</script>
	</c:if>
  	<c:if test="${not empty sessionScope.clubListJson}">
  	<script type="text/javascript">
		clubListJson = ${sessionScope.clubListJson};
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userGameJson}">
  	<script type="text/javascript">
  		userGameJson = ${sessionScope.userGameJson};
  		console.log("sssssssssssss" +userGameJson);
		</script>
		
	</c:if>
	<c:if test="${not empty sessionScope.userGameJsonDreamEleven}">
  	<script type="text/javascript">
  		userGameJson = ${sessionScope.userGameJsonDreamEleven};
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.purchableWildCardJson}">
  	<script type="text/javascript">
  	purchableWildCardJson = ${sessionScope.purchableWildCardJson};
  	var planDiscountId = '${sessionScope.planDiscountId}';
		</script>
	</c:if>
	<c:if test="${not empty sessionScope.userJson}">
   		<script type="text/javascript">
   		userJson = ${sessionScope.userJson};
  		</script>
	</c:if>
	<script type="text/javascript">
	
	function aa(){
		var elems2 = '<div class="ismjs-select">'+
	     '<picture>'+
	     '<img src="/SportMgmt/images/animated_wk.gif">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Goalkeeper" class="ism-element__type"><span class="ism-element__type__short">GKP</span></abbr></div>';
	     
	     $('.ism-element-row.ism-element-row--pitch:first-child .ismjs-remove').click(function () {
	    	 var userId = userJson.userId;
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,elems2);
	    	 }
	    	 return false;
	    })
	};
	
	
	function defenderRemove(){
		var def2 = '<div class="ismjs-select">'+
	     '<picture>'+
	    '<img src="/SportMgmt/images/animated_bat.gif"  alt="" title="Select a Defender from player list" class="ism-shirt ism-element__shirt">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Defender" class="ism-element__type"><span class="ism-element__type__short">DEF</span></abbr></div>';
	     
	     
	     
	     $('.ism-element-row.ism-element-row--pitch:nth-child(2) .ismjs-remove').click(function () {
	    	 var userId = userJson.userId;
	    	 
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,def2);
	    	 }
	    	
	    	 return false;
	    })
	};
	
	
	function midfielderRemove(){
		var midd2 = '<div class="ismjs-select">'+
	     '<picture>'+
	     '<img src="/SportMgmt/images/animated_bowl.gif" alt="" title="Select a Midfielder from player list" class="ism-shirt ism-element__shirt">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Midfielder" class="ism-element__type"><span class="ism-element__type__short">MID</span></abbr></div>';
	    
	     
	     
	     $('.ism-element-row.ism-element-row--pitch:nth-child(3) .ismjs-remove').click(function () {
	    	 var userId = userJson.userId;
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,midd2);
	    	 }
	    	 return false;
	    })
	};
	
	function forwardRemove(){
		var for2 = '<div class="ismjs-select">'+
	     '<picture>'+
	    '<img src="/SportMgmt/images/animated_ar.gif" alt="" title="Select a Forward from player list" class="ism-shirt ism-element__shirt">'+
	     '</picture>'+
	     '<div class="ism-element__name ism-element__name--placeholder"> <abbr title="Forward" class="ism-element__type"><span class="ism-element__type__short">FWD</span></abbr></div>';
	    
	     $('.ism-element-row.ism-element-row--pitch:nth-child(4) .ismjs-remove').click(function () {
	    	 var userId =userJson.userId;
	    	 if($(this).parents('.ism-element').find('.ismjs-menu').attr('id') != undefined && typeof $(this).parents('.ism-element').find('.ismjs-menu').attr('id') != 'undefined')
	    	 {
	    		 var gameClubPlayerId = $(this).parents('.ism-element').find('.ismjs-menu').attr('id').split('_')[1];
		    	 removePlayer(userId,gameClubPlayerId,this,for2);
	    	 }
	    	 return false;
	    })
	};
	
	<c:if test="${!isUnderDeadline}">
			$('.ism-element').mousemove(function(){
			
			aa();		
			defenderRemove();
			midfielderRemove();
			forwardRemove();
		})

	</c:if>
	
	$(document).ready(function() {
		$(".added-player-count").text(""+userGameJson.playerList.length+"/11");
		$("div.ismjs-select.added-player-css").each(function(){
			var gameClubPlayerId = $(this).attr('id');
			console.info('gameClubPlayerId: '+gameClubPlayerId);
			var playerClubId = "";
			var playerType = "";
			var playerPrice = "";
			var playerName = "";
			var userId = userJson.userId;
			if(typeof playerListJson != 'undefined')
			{
				for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
				{
				  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
					{
					  playerClubId =   playerListJson[playerListIndex].clubId;
					  playerType =   playerListJson[playerListIndex].type;
					  playerPrice =   playerListJson[playerListIndex].price;
					  playerName =   playerListJson[playerListIndex].name;
					}
					  
				}
			}
			console.info('playerClubId--: '+playerClubId);
			var clubImage = clubIdImageMap[playerClubId];
			console.info('clubImage--: '+clubImage);			
			if(playerType == 'Goalkeeper')
			 {
				$("#Goalkeepers .addPlayer>a").closest('tr').attr('disabled', 'disabled');

				var elems = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		       
		       '<picture>'+
		        '<img src="/SportMgmt/images/Goalkeeper_'+clubImage+'" alt="" title="" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		        
		       
		        $('.ism-element-row.ism-element-row--pitch:first-child').find('.ismjs-select').first().replaceWith(elems); 
			 }
			 if(playerType == 'Midfielder')
			 {
				$('#Midfielders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
				
				var midfielder = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		       
		       '<picture>'+
		        '<img src="/SportMgmt/images/Midfielder_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		       
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		        
		        $('.ism-element-row.ism-element-row--pitch:nth-child(3)').find('.ismjs-select').first().replaceWith( midfielder );
			 }
			 if(playerType == 'Defender')
			 {
				$('#Defenders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
				
				var defender = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		       
		       '<picture>'+
		        '<img src="/SportMgmt/images/Defender_'+clubImage+'"  alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		        
		        $('.ism-element-row.ism-element-row--pitch:nth-child(2)').find('.ismjs-select').first().replaceWith( defender );
		       
			 }
			 if(playerType == 'Forward')
			 {
				$('#Forwards .addPlayer>a').closest('tr').attr('disabled', 'disabled');
				
				var forward = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
		      
		       '<picture>'+
		        '<img src="/SportMgmt/images/Forward_'+clubImage+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
		        '</picture>'+
		        '<div class="ism-element__name">'+playerName+'</div>'+
		        '<div class="ism-element__data">'+playerPrice+'</div>'+
		        '<div class="ism-element__controls">'+
		        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
		       
		       	        
		        $('.ism-element-row.ism-element-row--pitch:nth-child(4)').find('.ismjs-select').first().replaceWith( forward );
			 }

		});
		
		$("#paymentModel").find("button").click(function(){
			var planId =  $(this).attr("id").split("_")[1];
			console.log("Plan Id: "+planId);
			//var paymentForm = $("#paymentForm_"+planId);
			var paymentForm = document.createElement("form");
		    var plan = document.createElement("input"); 
		    var discount = document.createElement("input");
		    var amount = document.createElement("input");
		
		    paymentForm.method = "POST";
		    paymentForm.action = "/SportMgmt/mvc/payment/MakePayment";   
		
		    plan.value=planId;
		    plan.name="leaguePlanId";
		    paymentForm.appendChild(plan);  
		
		    discount.value=planDiscountId;
		    discount.name="planDiscountId";
		    paymentForm.appendChild(discount);
		    amount.name = "amount";
		    if(purchableWildCardJson != null && typeof purchableWildCardJson != 'undefined')
		    {
		    	console.log("Going ot iterate purchableWildCardJson");
		    	for(var i = 0;i<purchableWildCardJson.length;i++)
			    {
			    	console.log("iterating purchableWildCardJson: planId: "+purchableWildCardJson[i].planId);
			    	if(purchableWildCardJson[i].planId == planId)
			    	{
			    		console.log("gettting amount :: "+purchableWildCardJson[i].amount);
			    		amount.value = purchableWildCardJson[i].price;
			    		paymentForm.appendChild(amount);  
			    		document.body.appendChild(paymentForm);
			 			paymentForm.submit();
			    	}
			    }
		    }
		});
	});
	 $('#ismjs-element-filter').change(function(){
	  var selected = $(':selected',this); 
	  filterByView(selected);
	  
   });
 $('#ismjs-element-price').change(function(){
	 console.info("---- filter by price");
	  var filterByViewSelected = $(':selected',$('#ismjs-element-filter')); 
	  filterByView(filterByViewSelected);
	  var selected = $(':selected',this);
	  var seletedPrice = selected.attr("value");
	  console.info("---- filter by price selected value: "+seletedPrice);
	  if(seletedPrice != null && seletedPrice != 'undefined' && seletedPrice !='0')
	  {
		  $("tr.ismjs-menu.ism-row-select:visible").each(function()
					{
						var gameClubPlayerId = $(this).attr('id');
						var playerPrice = 0;
						if(typeof playerListJson != 'undefined')
						{
							for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
							{
							  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
								{
								  playerPrice =   playerListJson[playerListIndex].price;
								}
								  
							}
						}
						if(parseInt(seletedPrice) !=playerPrice)
						{
							 $(this).hide();
						}
						
					});
	  }
	$("p.ism-elements-shown strong.ism-elements-shown__num").text($("tr.ismjs-menu.ism-row-select:visible").length);
  });

 function filterByView(selected)
 {
	 console.info("---- filter by View");	
	 console.info(selected.closest('optgroup').attr('label'));
	  $("tr.ismjs-menu.ism-row-select").each(function()
		{
			$(this).show();
		});
	  $("div#ismjs-elements-list-tables").find("div.table").each(function(){
			 // console.info(" table Id: "+$(this).attr('id'));
			 $(this).show();
		})
	  if(typeof selected.closest('optgroup').attr('label') != 'undefined' && selected.closest('optgroup').attr('label') == 'By Position')
		{
		  var playerGroup = selected.attr("value");
		  console.info("--- Selected Position: "+playerGroup);
		  $("div#ismjs-elements-list-tables").find("div.table").each(function(){
			  console.info(" table Id: "+$(this).attr('id'));
			  if(typeof $(this).attr('id') != 'undefined' && $(this).attr('id')!== playerGroup)
			  {
				  $(this).hide();
			  }
		 })
		}
	  else if(typeof selected.closest('optgroup').attr('label') != 'undefined' && selected.closest('optgroup').attr('label') == 'By Team')
		{
		  var selectedClub = selected.attr("value");
		  console.info("--- Selected Club: "+selectedClub);
		  $("tr.ismjs-menu.ism-row-select").each(function()
			{
				var gameClubPlayerId = $(this).attr('id');
				var selectedClub = selected.attr("value");
				var playerClubId = "";
				if(typeof playerListJson != 'undefined')
				{
					for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
					{
					  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
						{
						  playerClubId =   playerListJson[playerListIndex].clubId;
						}
						  
					}
				}
				if(selectedClub.split('_')[1] !=playerClubId)
				{
					 $(this).hide();
				}
				
			});
		}
	  $("p.ism-elements-shown strong.ism-elements-shown__num").text(($("tr.ismjs-menu.ism-row-select:visible").length+1));
 }
     function addPlayer(userId, gameClubPlayerId)
     {   $(".added-player-count").text(""+(userGameJson.playerList.length+1)+"/11");
     	<c:choose>
     	<c:when test="${isUnderDeadline}">
     	alert("Hey buddy ! You are under deadline. Player can be added after deadline");
     	</c:when>
     	<c:otherwise>
    	 var playerType = '';
    	 var playerName = '';
    	 var playerPrice = '';
    	 var clubId = '';
			if(typeof playerListJson != 'undefined')
			{
				for(var playerListIndex = 0; playerListIndex < playerListJson.length; playerListIndex++)
				{
				  if(playerListJson[playerListIndex].gameClubPlayerId == gameClubPlayerId)
					{
					  playerType =   playerListJson[playerListIndex].type;
					  playerName = playerListJson[playerListIndex].name;
					  playerPrice = playerListJson[playerListIndex].price;
					  clubId = playerListJson[playerListIndex].clubId;
					}
					  
				}
			}
		console.info("Player Type "+playerType);
		var ajaxCall = true;
		var avialBalance = userJson.balanceCoins;
		if(playerType == '')
		{
			ajaxCall = false;
		}
		else if(avialBalance < playerPrice)
		{
			alert("Bank Account is less than player price");
			ajaxCall = false;
		}
		else if(!(userJson.hasActivePlan || userJson.totalTransferForGameWeek <=1 || userJson.gameWeekNumberForPlayerTransfer <=1 || userJson.totalPoint > 4))
		{
			ajaxCall = false;
			if(userJson.totalPoint < 4)
			{
				alert("Please active wild card to add player");
			}
		}
		else if (playerType == 'Goalkeeper')
		{
			if(typeof userGameJson != null && typeof userGameJson!= 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJsonDreamEleven['total']['Goalkeeper'] >=1)
				{
					ajaxCall = false;
					alert("You can add maximum 1 Goalkeeper. Please Remove any one first ");
				}
			}
		}
		else if (playerType == 'Midfielder')
		{
			if(typeof userGameJson != null && typeof userGameJson != 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJson['total']['Midfielder'] >=4)
				{
					ajaxCall = false;
					alert("You can add maximum 4 Midfielder. Please Remove any one first ");
				}
			}
		}
		else if (playerType == 'Forward')
		{
			if(typeof userGameJson != null && typeof userGameJson != 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJson['total']['Forward'] >=2)
				{
					ajaxCall = false;
					alert("You can add maximum 2 All Rounders. Please Remove any one first ");
				}
			}
		}
		else if (playerType == 'Defender')
		{
			if(typeof userGameJson != null && typeof userGameJson != 'undefined' && typeof userGameJson['total'] !='undefined')
			{
				if(userGameJson['total']['Defender'] >=4)
				{
					ajaxCall = false;
					alert("You can add maximum 4 Defender. Please Remove any one first ");
				}
			}
		}
		console.info("--- Ajax Call: "+ajaxCall);
		if(ajaxCall)
		{
			var url = "/SportMgmt/mvc/game11/AddPlayer11?userId="+userId+"&gameClubPlayerId="+gameClubPlayerId;
	     	$.ajax({
	     		  url: url,
	     		  dataType: 'json',
	     		  success: function( resp ) {
	     			  if(resp.isSuccess)
	     			  {
	     				 userGameJson = resp.userGameJson; 
	     				 userJson = resp.userJson;
	     				$("p.added-player-count").text(""+userGameJson.playerList.length+"/11");	     				
	     				 var clubImage = clubIdImageMap[clubId];
	     				 if(typeof $('#planBalanceDiv') != 'undefined')
	     			 	 {
	     					$('#planBalanceDiv').text(userJson.balanceCoins); 
	     				 }
	     				 if(typeof $('#freeTransUsedDiv') != 'undefined')
	     			 	 {
	     					if(userJson.totalTransferForGameWeek > 1)
	     					 $('#freeTransUsedDiv').text('used'); 
	     				 }
	     				 if(playerType == 'Goalkeeper')
	     				 {
	     					$("#Goalkeepers .addPlayer>a").closest('tr').attr('disabled', 'disabled');

	     					var elems = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			        
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Goalkeeper_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			        
	     			       
	     			        $('.ism-element-row.ism-element-row--pitch:first-child').find('.ismjs-select').first().replaceWith( elems ); 
	     				 }
	     				 if(playerType == 'Midfielder')
     					 {
	     					$('#Midfielders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
	     					
	     					var midfielder = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			        
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Midfielder_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			       
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			        
	     			        $('.ism-element-row.ism-element-row--pitch:nth-child(3)').find('.ismjs-select').first().replaceWith( midfielder );
     					 }
	     				 if(playerType == 'Defender')
     					 {
	     					$('#Defenders .addPlayer>a').closest('tr').attr('disabled', 'disabled');
	     					
	     					var defender = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			        
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Defender_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			        
	     			        $('.ism-element-row.ism-element-row--pitch:nth-child(2)').find('.ismjs-select').first().replaceWith( defender );
	     			       
     					 }
	     				 if(playerType == 'Forward')
     					 {
	     					$('#Forwards .addPlayer>a').closest('tr').attr('disabled', 'disabled');
	     					
	     					var forward = '<div class="ismjs-menu" id="'+userId+'_'+gameClubPlayerId+'">'+
	     			       
	     			       '<picture>'+
	     			        '<img src="/SportMgmt/images/Forward_'+clubImage+'" alt="'+playerName+'" title="'+playerName+'" class="ism-shirt ism-element__shirt">'+
	     			        '</picture>'+
	     			        '<div class="ism-element__name">'+playerName+'</div>'+
	     			        '<div class="ism-element__data">'+playerPrice+'</div>'+
	     			        '<div class="ism-element__controls">'+
	     			        '<div  class="ismjs-remove ism-element__control ism-element__control--primary"><a href="#" title="Remove player" class="ism-element__link removePlayerIcon rr">X</a></div></div>';
	     			       
	     			       	        
	     			        $('.ism-element-row.ism-element-row--pitch:nth-child(4)').find('.ismjs-select').first().replaceWith( forward );
     					 }
	     			  }
	     			  else
	    			  {
	    				  	alert(resp.errorMessage);
	    			  }
	     		  },
	     		  error: function( req, status, err ) {
	     		    console.log( 'something went wrong', status, err );
	     		  }
	     		});

		}
		
		</c:otherwise>
		</c:choose>
     }
     function removePlayer(userId, gameClubPlayerId,elems1,elems2)
     {
    	$(".added-player-count").text(""+(userGameJson.playerList.length-1)+"/11");
		var isPlayerPlaying = false;
		for(var i=0;i<userGameJson.playerList.length ;i++)
		{
			if(userGameJson.playerList[i].gameClubPlayerId == gameClubPlayerId)
			{
				isPlayerPlaying = true;
				break;
			}
		}
    	if(isPlayerPlaying)
   		{
    		var url = "/SportMgmt/mvc/game11/RemovePlayer11?userId="+userId+"&gameClubPlayerId="+gameClubPlayerId;
	     	$.ajax({
	     		  url: url,
	     		  dataType: 'json',
	     		  async: false,
	     		  success: function( resp ) {
	     			  if(resp.isSuccess)
	     			  {
	     				 userGameJson = resp.userGameJson;
	     				 userJson = resp.userJson;
	     				$("p.added-player-count").text(""+userGameJson.playerList.length+"/11");
	     				if(typeof $('#planBalanceDiv') != 'undefined')
	     			 	 {
	     					$('#planBalanceDiv').text(userJson.balanceCoins); 
	     				 }
	     				$(elems1).parents('.ism-element').find('.ismjs-menu').replaceWith( elems2 );
	     			  }
	     			  else
	    			  {
	    				  	alert(resp.errorMessage);
	    			  }
	     		  },
	     		  error: function( req, status, err ) {
	     		    console.log( 'something went wrong', status, err );
	     		  }
	     		});
   		}
     }
     

  </script>
