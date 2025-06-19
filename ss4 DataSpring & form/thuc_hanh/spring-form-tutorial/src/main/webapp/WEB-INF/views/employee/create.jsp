<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/19/2025
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="post" action="addEmployee" modelAttribute="employee">
  <table>
    <tr>
      <td><form:label path="id">Employee ID:</form:label></td>
      <td><form:input path="id"/></td>
    </tr>
    <tr>
      <td><form:label path="name">Employee's Name:</form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td><form:label path="contactNumber">Contact's Number:</form:label></td>
      <td><form:input path="contactNumber"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit"/></td>
    </tr>
  </table>

</form:form>
</body>
</html>
