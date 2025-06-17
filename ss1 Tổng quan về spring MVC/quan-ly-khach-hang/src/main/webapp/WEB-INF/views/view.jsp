<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/17/2025
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>View Customer</title>
</head>
<body>
<fieldset>
    <legend>Customer Information</legend>
    <form method="post" action="">
        Id: ${customer.id} <br/>
        Name: <input type="text" name="name" value="${customer.name}" /><br/>
        Email: <input type="text" name="email" value="${customer.email}" /><br/>
        Address: <input type="text" name="address" value="${customer.address}" /><br/>
        <input type="submit" value="Update"/>
    </form>
</fieldset>
<br/>
<a href="${pageContext.request.contextPath}/customers">Back to list</a>
</body>
</html>
