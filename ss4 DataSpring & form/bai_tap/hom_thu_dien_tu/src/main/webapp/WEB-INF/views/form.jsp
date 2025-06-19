<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/19/2025
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<form:form  action="/update" method="post" modelAttribute="mailSettings">
    <label>Languages</label>
    <form:select path="language" items="${languages}"/><br>
    <label>Page Size</label>
    Show <form:select path="pageSize" items="${pageSizes}"/> emails per page<br>
    <label>Spams filter</label>
    <form:checkbox path="spamsFilter"/> Enable spams filter<br>
    <label>Signature</label>
    <form:textarea path="signature"/><br>
    <input type="submit" value="Update"/>
    <input type="reset" value="Cancel"/>
</form:form>



</body>
</html>
