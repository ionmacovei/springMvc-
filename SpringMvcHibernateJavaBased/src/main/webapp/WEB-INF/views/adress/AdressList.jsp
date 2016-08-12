<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@ include file="../menu.jsp" %>
        <div align="center">
	        <h1>Users List</h1>
	        <h2><a href="newAdress">New Adress</a></h2>
	        
	        
        	<table border="1">
	        	<th>No</th>
	        	<th>street</th>
	        	<th>city</th>
	        	<th>coutury</th>
	        	<th>User</th>
	        	<th>Actions</th>
	        	
				<c:forEach var="adress" items="${adressList}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${adress.street}</td>
					<td>${adress.city}</td>
					<td>${adress.countury}</td>
					<td>${adress.user.username}</td>
					<td>
						<a href="editAdress?id=${adress.id}">Edit</a>
						
						<a href="deleteAdress?id=${adress.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>