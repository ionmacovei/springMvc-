<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@ include file="../menu.jsp" %>
        <div align="center">
	        <h1>Users List</h1>
        	<table border="1">
	        	<th>No</th>
	        	<th>Username</th>
	        	<th>Email</th>
	        	<th>Actions</th>
	        	
				<c:forEach var="user" items="${userList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td><a href="userDetails?id=${user.id}">${user.username}</a></td>
					
					<td>${user.email}</td>
					<td>
						<a href="editUser?id=${user.id}">Edit</a>
						
						<a href="deleteUser?id=${user.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
