<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee List</title>
    <style>
        table, th, td { border: 1px solid black; border-collapse: collapse; padding: 8px; }
        button { margin: 2px; }
    </style>
</head>
<body>
<h2>Employee List</h2>

<form method="get" action="/employees">
    <input type="text" name="keyword" value="${keyword}" placeholder="Search by name"/>
    <button type="submit">Search</button>
    <a href="/employees/register"><button type="button">Add Employee</button></a>
</form>

<br/>

<table>
    <tr>
        <th>First Name</th><th>Last Name</th><th>Gender</th><th>Date Of Birth</th>
        <th>Email</th><th>Phone</th><th>Action</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.gender}</td>
            <td>${emp.dateOfBirth}</td>
            <td>${emp.email}</td>
            <td>${emp.phone}</td>
            <td>
                <a href="/employees/edit/${emp.id}">Update</a> |
                <a href="/employees/delete/${emp.id}" onclick="return confirm('Delete this employee?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
