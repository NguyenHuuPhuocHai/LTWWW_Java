<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Employee List</title></head>
<body>
<h2>Employees</h2>
<a href="employees/add">Add New Employee</a>
<table border="1" cellpadding="8">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Position</th><th>Action</th></tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.email}</td>
            <td>${emp.position}</td>
            <td>
                <a href="employees/edit/${emp.id}">Edit</a> |
                <a href="employees/delete/${emp.id}" onclick="return confirm('Delete?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
