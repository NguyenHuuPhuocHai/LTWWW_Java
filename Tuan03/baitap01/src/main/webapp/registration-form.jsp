<%--
  Created by IntelliJ IDEA.
  User: Phuoc Hai
  Date: 9/7/2025
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<form action="registration-form" method="get">
    <table align="center" cellpadding="5">
        <!-- First & Last Name -->
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="txtFName" required></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="txtLName" required></td>
        </tr>

        <!-- Date of Birth -->
        <tr>
            <td>Date of Birth:</td>
            <td>
                <select name="day">
                    <% for (int i = 1; i <= 31; i++) { %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
                <select name="month">
                    <option value="Jan">Jan</option>
                    <option value="Feb">Feb</option>
                    <option value="Mar">Mar</option>
                    <option value="Apr">Apr</option>
                    <option value="May">May</option>
                    <option value="Jun">Jun</option>
                    <option value="Jul">Jul</option>
                    <option value="Aug">Aug</option>
                    <option value="Sep">Sep</option>
                    <option value="Oct">Oct</option>
                    <option value="Nov">Nov</option>
                    <option value="Dec">Dec</option>
                </select>
                <select name="year">
                    <% for (int i = 1980; i <= 2025; i++) { %>
                    <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
            </td>
        </tr>

        <!-- Email & Mobile -->
        <tr>
            <td>Email:</td>
            <td><input type="email" name="txtEmail" required></td>
        </tr>
        <tr>
            <td>Mobile Number:</td>
            <td><input type="text" name="txtMobileNumber"></td>
        </tr>

        <!-- Gender -->
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="gender" value="Male" required> Male
                <input type="radio" name="gender" value="Female"> Female
            </td>
        </tr>

        <!-- Address -->
        <tr>
            <td>Address:</td>
            <td><textarea name="txtAddress" rows="3" cols="30"></textarea></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><input type="text" name="txtCity"></td>
        </tr>
        <tr>
            <td>Pin Code:</td>
            <td><input type="text" name="txtPinCode"></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><input type="text" name="txtState"></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><input type="text" name="txtCountry"></td>
        </tr>

        <!-- Hobbies -->
        <tr>
            <td>Hobbies:</td>
            <td>
                <input type="checkbox" name="chkHobbies" value="Drawing"> Drawing
                <input type="checkbox" name="chkHobbies" value="Singing"> Singing
                <input type="checkbox" name="chkHobbies" value="Dancing"> Dancing
                <input type="checkbox" name="chkHobbies" value="Sketching"> Sketching
                <input type="checkbox" name="chkHobbies" value="Others"> Others
                <input type="text" name="hobbyOthers" placeholder="If Others, specify">
            </td>
        </tr>

        <!-- Course -->
        <tr>
            <td>Course Applied For:</td>
            <td>
                <select name="txtCourse">
                    <option value="BCA">BCA</option>
                    <option value="B.Com">B.Com</option>
                    <option value="B.Sc">B.Sc</option>
                    <option value="B.A">B.A</option>
                </select>
            </td>
        </tr>

        <!-- Submit -->
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
