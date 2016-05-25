<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Spring 3 hibernate集成</title>
    </head>
    <body>
    <h2>雇员管理系统 : Spring 3 hibernate 集成</h2>
    <form:form method="post" action="add" commandName="employee">
        <table>
        <tr>
            <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
            <td><form:input path="telephone" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message code="label.add"/>"/>
            </td>
        </tr>
    </table> 
    </form:form>
    <h3>雇员</h3>
    <c:if  test="${!empty employeeList}">
    <table class="data">
    <tr>
        <th><spring:message code="label.name"/></th>
        <th><spring:message code="label.email"/></th>
        <th><spring:message code="label.telephone"/></th>
        <th><spring:message code="label.menu"/></th>
    </tr>
    <c:forEach items="${employeeList}" var="emp">
        <tr>
            <td>${emp.lastname}, ${emp.firstname} </td>
            <td>${emp.email}</td>
            <td>${emp.telephone}</td>
            <td><a href="delete/${emp.id }">delete</a></td>
        </tr>
    </c:forEach>
    </table>
    </c:if>
    </body>
</html>