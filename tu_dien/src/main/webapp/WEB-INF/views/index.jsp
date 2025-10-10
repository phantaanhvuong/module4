<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2025
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Tra từ điển Việt - Anh </h1>
<form method="post" action="">
  <p>Nhập từ tiếng việt</p>
  <input type="text" name="tiengviet" value="${tiengviet}">
  <p>Nhập từ dịch</p>
  <input type="text" name="tienganh" value="${tienganh}" readonly>
  <button>Dịch</button>
</form>
<h5 name="loi" style="color: red">${loi}</h5>
</body>
</html>
