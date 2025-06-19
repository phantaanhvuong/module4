<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/19/2025
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Result</title></head>
<body>
<h2>Updated Settings</h2>
<p><strong>Language:</strong> ${mailSettings.language}</p>
<p><strong>Page Size:</strong> ${mailSettings.pageSize}</p>
<p><strong>Spam Filter:</strong> ${mailSettings.spamsFilter ? "Enabled" : "Disabled"}</p>
<p><strong>Signature:</strong><pre>${mailSettings.signature}</pre></p>
<a href="/settings">Back</a>
</body>
</html>

