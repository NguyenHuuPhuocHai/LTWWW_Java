<html>
<head><title>Edit Employee</title></head>
<body>
<h2>Edit Employee</h2>
<form action="/employees/update" method="post">
    <input type="hidden" name="id" value="${employee.id}"/>
    Name: <input type="text" name="name" value="${employee.name}"/><br>
    Email: <input type="text" name="email" value="${employee.email}"/><br>
    Position: <input type="text" name="position" value="${employee.position}"/><br>
    <button type="submit">Update</button>
</form>
<a href="/employees">Back</a>
</body>
</html>
