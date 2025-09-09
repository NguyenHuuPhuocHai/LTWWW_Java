<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: #f2f2f2;
        }
        .container {
            background: white;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 12px;
        }
        label {
            display: block;
            margin-bottom: 6px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .gender-group {
            display: flex;
            gap: 10px;
        }
        .btn {
            background: #4CAF50;
            color: white;
            padding: 10px;
            width: 100%;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover {
            background: #45a049;
        }
    </style>
</head>
<body>
<c:if test="${not empty requestScope.error}">
    <p style="color:red">${requestScope.error}</p>
</c:if>
<div class="container">
    <h2>Register</h2>
    <form action="register" method="post">
        <div class="form-group">
            <label>First Name:</label>
            <input type="text" name="txtFirstName" required>
        </div>

        <div class="form-group">
            <label>Last Name:</label>
            <input type="text" name="txtLastName" required>
        </div>

        <div class="form-group">
            <label>Email:</label>
            <input type="email" name="txtEmail" required>
        </div>

        <div class="form-group">
            <label>Re-enter Email:</label>
            <input type="email" name="txtReEmail" required>
        </div>

        <div class="form-group">
            <label>New Password:</label>
            <input type="password" name="txtPassword" required>
        </div>

        <div class="form-group">
            <label>Birthday:</label>
            <div style="display:flex; gap:5px;">
                <select name="day" required>
                    <option value="">Day</option>
                    <% for(int i=1;i<=31;i++){ %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
                <select name="month" required>
                    <option value="">Month</option>
                    <% for(int i=1;i<=12;i++){ %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
                <select name="year" required>
                    <option value="">Year</option>
                    <% for(int i=1950;i<=2025;i++){ %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label>Gender:</label>
            <div class="gender-group">
                <label><input type="radio" name="gender" value="Female" required> Female</label>
                <label><input type="radio" name="gender" value="Male" required> Male</label>
            </div>
        </div>

        <button type="submit" class="btn">Register</button>
    </form>
</div>
</body>
</html>
