
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/18/2025
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Bạn đã chọn</h2>
<ul>
  <c:forEach var="c" items="${giaVi}">
    <li>${c}</li>
  </c:forEach>
</ul>
<a href="/sandwich">Quay lại</a>
</body>
</html>
