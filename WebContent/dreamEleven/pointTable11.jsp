<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="rules">
<h1 class="rule-heading">Point Tableeeee</h1>
<table class="point-table">
	<tr>
		<th>Point Detail</th>
		<th>Point To Be Added</th>
		<th>Point To Be Deducted</th>
	</tr>
	<c:forEach var="pointMap" items="${pointList}">
	<tr>
	<td><c:out value="${pointMap['pointName']}"/></td>
	<td class="green-txt"><c:out value="${pointMap['pointToAdd']}"/></td>
	<td class="red-txt"><c:out value="${pointMap['pointToDeduct']}"/> </td>
	</tr>
	</c:forEach>
</table>

      
  <br>  

</div>