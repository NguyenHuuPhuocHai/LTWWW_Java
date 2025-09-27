<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Baitap03</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
</head>
<body>
<header>
  <h1>Ứng dụng Quản lý Tin tức</h1>
  <nav>
    <a href="${pageContext.request.contextPath}/danh-sach-tin">Danh sách</a> |
    <a href="${pageContext.request.contextPath}/tin-form">Thêm tin</a> |
    <a href="${pageContext.request.contextPath}/quan-ly">Quản lý</a>
  </nav>
</header>

<main>
  <jsp:include page="${body}" />
</main>
</body>
</html>
