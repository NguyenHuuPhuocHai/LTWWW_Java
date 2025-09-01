<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login BT01</title>
</head>
<body>
<h2>Login</h2>

<%-- Hiển thị lỗi nếu có --%>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<p style="color: red;"><%= error %></p>
<%
    }
%>

<form action="<%= request.getContextPath() %>/login" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br><br>

    <label>Password:</label>
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>
</body>
</html>
