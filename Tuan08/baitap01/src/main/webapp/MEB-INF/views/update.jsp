<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Update Employee</title></head>
<body>
<h2>Update Employee</h2>

<form method="post" action="/employees/update">
    <input type="hidden" name="id" value="${employee.id}"/>
    First Name: <input type="text" name="firstName" value="${employee.firstName}"/><br/><br/>
    Last Name: <input type="text" name="lastName" value="${employee.lastName}"/><br/><br/>
    Email: <input type="email" name="email" value="${employee.email}"/><br/><br/>
    Date Of Birth: <input type="date" name="dateOfBirth" value="${employee.dateOfBirth}"/><br/><br/>
    Phone Number: <input type="text" name="phone" value="${employee.phone}"/><br/><br/>
    Gender:
    <input type="radio" name="gender" value="Male" ${employee.gender == 'Male' ? 'checked' : ''}/> Male
    <input type="radio" name="gender" value="Female" ${employee.gender == 'Female' ? 'checked' : ''}/> Female<br/><br/>
    Address: <input type="text" name="address" value="${employee.address}"/><br/><br/>
    <button type="submit">Update</button>
    <a href="/employees"><button type="button">Back</button></a>
</form>
</body>
</html>
