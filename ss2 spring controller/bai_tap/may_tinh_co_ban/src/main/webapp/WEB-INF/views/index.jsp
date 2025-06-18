<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/18/2025
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/tinh_toan" method="post">
    <input type="number" name="so1" placeholder="Số thứ nhất" value="${so1}">
    <input type="number" name="so2" placeholder="Số thứ hai" value="${so2}"><br><br>
    <button type="submit" name="chon" value="+"> Cộng</button>
    <button type="submit" name="chon" value="-"> Trừ</button>
    <button type="submit" name="chon" value="*"> Nhân</button>
    <button type="submit" name="chon" value="/"> Chia</button>
</form>
<c:if test="${not empty ketQua}">
    <h3> Kết quả:${ketQua}</h3>
</c:if>

</body>
</html>
