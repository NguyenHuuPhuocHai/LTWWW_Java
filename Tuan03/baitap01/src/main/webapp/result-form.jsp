<%@page import="iuh.edu.se.baitap01.entities.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Result Submit</title>
</head>
<body>
    <%
        Student student = new Student();
        student = (Student)request.getAttribute("student");
        out.println(
                "First name: " + student.getFirstName()
                + "<br/> Last name: " + student.getLastName()
                + "<br/> Email: " + student.getEmail()
                + "<br/> Gender: " + student.getGender()
                + "<br/> Birthday: " + student.getBirthday()
        );
    %>
</body>
</html>
