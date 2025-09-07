<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Multi-language Demo</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f7fa;
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
            justify-content: center;
            align-items: center;
        }

        .container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
            text-align: center;
            min-width: 320px;
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        select, input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        input[type="submit"] {
            background: #4a90e2;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            margin-top: 12px;
            border-radius: 6px;
            font-size: 15px;
            cursor: pointer;
            transition: background 0.3s;
        }

        input[type="submit"]:hover {
            background: #357ab8;
        }

        label {
            font-weight: bold;
        }

        table {
            width: 100%;
            margin-top: 15px;
        }

        td {
            padding: 6px;
            text-align: left;
        }
    </style>
</head>
<body>
<c:set var="languageCode" value="${param.selLanguageCode}"/>
<c:if test="${not empty languageCode}">
    <fmt:setLocale value="${languageCode}" scope="session"/>
</c:if>
<c:if test="${empty param.selLanguageCode}">
    <fmt:setLocale value="en" scope="session"/>
</c:if>
<fmt:setBundle basename="resource" scope="session"/>

<div class="container">
    <h2><fmt:message key="login"/></h2>
    <form action="login.jsp" method="POST">
        <!-- Chọn ngôn ngữ -->
        <label><fmt:message key="languageMessage"/></label>
        <select name="selLanguageCode">
            <option value="en" ${languageCode=='en' ? 'selected' : ''}>English</option>
            <option value="vi" ${languageCode=='vi' ? 'selected' : ''}>Tiếng Việt</option>
            <option value="ja" ${languageCode=='ja' ? 'selected' : ''}>日本語</option>
            <option value="zh" ${languageCode=='zh' ? 'selected' : ''}>中文</option>
            <option value="fr" ${languageCode=='fr' ? 'selected' : ''}>Français</option>
        </select>
        <input type="submit" value="<fmt:message key='chooseButton'/>"/>

        <!-- Form đăng nhập -->
        <table>
            <tr>
                <td><fmt:message key="userName"/></td>
                <td><input type="text" name="txtUserName"/></td>
            </tr>
            <tr>
                <td><fmt:message key="pass"/></td>
                <td><input type="password" name="txtPassword"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="<fmt:message key='login'/>"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
