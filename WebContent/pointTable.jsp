<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div style="color: #ccc;font-size: 16px; padding:20px">
<h1 class="rule-heading">Point Table</h1>
<table class="point-table" style="background:#ABC; color:Green">
	<tr>
		<th>Point Detail</th>
		<th>Point To Be Added</th>
		<th>Point To Be Deducted</th>
	</tr>
	<c:forEach var="pointMap" items="${pointList}">
	<tr>
	<td><c:out value="${pointMap['pointName']}"/></td>
	<td><c:out value="${pointMap['pointToAdd']}"/></td>
	<td><c:out value="${pointMap['pointToDeduct']}"/> </td>
	</tr>
	</c:forEach>
</table>

      
  <br>  

</div>