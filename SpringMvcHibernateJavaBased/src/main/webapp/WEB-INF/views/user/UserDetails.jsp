<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="css/objectBody.css" />" rel="stylesheet">
<%@ include file="../menu.jsp"%>
<div id="bodyObject">
	<p>User name: ${user.username}</p>
	<p>User name: ${user.email}</p>
	<h4>User Addresses</h4>
	<table border="1">
		<th>No</th>
		<th>street</th>
		<th>city</th>
		<th>coutury</th>
		<c:forEach var="adress" items="${addresses}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${adress.street}</td>
				<td>${adress.city}</td>
				<td>${adress.countury}</td>
			</tr>
		</c:forEach>
	</table>

</div>



</body>
</html>