<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/18/2025
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiment</title>
</head>
<body>
<h2>Chọn gia vị của bạn</h2>
<form action="/save" method="post">
    <input type="checkbox" name="giaVi" value="Lettuce"/>Lettuce<br/>
    <input type="checkbox" name="giaVi" value="Tomato"/>Tomato<br/>
    <input type="checkbox" name="giaVi" value="Mustard"/>Mustard<br/>
    <input type="checkbox" name="giaVi" value="Cheese"/>Cheese<br/>
    <button type="submit">Save</button>
</form>
</body>
</html>
