<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../menu.jsp"%>
<div align="center">
	<h1>New/Edit Adress</h1>
	<table>
		<form:form action="saveAdress" method="post" modelAttribute="adress">
			<form:hidden path="id" />
			<tr>
				<td>Street:</td>
				<td><form:input path="street" /></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>Countury:</td>
				<td><form:input path="countury" /></td>
			</tr>
			<tr>
				<td>Users:</td>
				<td><form:select path="user">

						<%-- <form:options items="${users}" /> --%>
						<c:forEach var="item" items="${users}">
							<option value="${item.id}">${item.username}</option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save"></td>
			</tr>
		</form:form>
	</table>
</div>
</body>
</html>