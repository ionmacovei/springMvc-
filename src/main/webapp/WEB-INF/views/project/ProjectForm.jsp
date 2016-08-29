<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../menu.jsp" %>
<div align="center">
    <h1>New/Edit Project</h1>
    <table>
        <form:form action="saveProject" method="post" modelAttribute="project">
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:textarea path="discription"/></td>
            </tr>
            <c:forEach var="item" items="${users}" varStatus="loopStatus">
                <tr>
                    <td>${item.username}</td>
                    <td><form:checkbox path="users" value="${item.id}"/></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2" align="center"><input type="submit"
                                                      value="Save"></td>
            </tr>
        </form:form>
    </table>
</div>

</body>
</html>