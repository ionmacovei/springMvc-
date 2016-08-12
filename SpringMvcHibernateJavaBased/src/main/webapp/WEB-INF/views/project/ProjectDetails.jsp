<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="css/objectBody.css" />" rel="stylesheet">
<%@ include file="../menu.jsp"%>
<div id="bodyObject">
	<p>Project name: ${project.name}</p>
	<p>Description: ${project.discription}</p>
	<h4>Users assign to this Project</h4>
	<table border="1">
		<th>No</th>
		<th>Name</th>
		<th>Email</th>
		<c:forEach var="user" items="${users}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${user.username}</td>
				<td>${user.email}</td>
				
			</tr>
		</c:forEach>
	</table>

</div>



</body>
</html>