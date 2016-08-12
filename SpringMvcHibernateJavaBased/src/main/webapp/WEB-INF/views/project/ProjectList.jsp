<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../menu.jsp"%>
<div align="center">
	<h1>Users List</h1>
	<table border="1">
		<th>No</th>
		<th>Name</th>
		<th>Discription</th>
		<th>Actions</th>
		<c:forEach var="project" items="${projectsList}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td><a href="projectDetails?id=${project.id}">${project.name}</a></td>

				<td>${project.discription}</td>
				<td><a href="editProject?id=${project.id}">Edit</a> <a
					href="deleteProject?id=${project.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
