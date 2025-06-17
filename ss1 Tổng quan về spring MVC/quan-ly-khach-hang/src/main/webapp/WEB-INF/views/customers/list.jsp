<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2025
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
  table {
    border: 1px solid #000;
  }

  th, td {
    border: 1px dotted #555;
  }
</style>
There are ${requestScope.customers.size()} customer(s) in list.
<body>
<table>
  <caption>Customer List</caption>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
  </tr>
  </thead>
  <tbody>
<c:forEach var="c" items="${requestScope.customers}">
  <tr>
    <td>
      <c:out value="${c.id}"/>
    </td>
    <td>
      <a href="${pageContext.request.contextPath}/customers/${c.id}">${c.name}</a>
    </td>
    <td>
      <c:out value="${c.email}"/>
    </td>
    <td>
      <c:out value="${c.address}"/>
    </td>
  </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>
