<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Register Employee</title></head>
<body>
<h2>Register New Employee</h2>

<form method="post" action="/employees/save">
    First Name: <input type="text" name="firstName"/><br/><br/>
    Last Name: <input type="text" name="lastName"/><br/><br/>
    Email: <input type="email" name="email"/><br/><br/>
    Date Of Birth: <input type="date" name="dateOfBirth"/><br/><br/>
    Phone Number: <input type="text" name="phone"/><br/><br/>
    Gender:
    <input type="radio" name="gender" value="Male"/> Male
    <input type="radio" name="gender" value="Female"/> Female<br/><br/>
    Address: <input type="text" name="address"/><br/><br/>
    <button type="submit">Register</button>
    <a href="/employees"><button type="button">Back</button></a>
</form>
</body>
</html>
