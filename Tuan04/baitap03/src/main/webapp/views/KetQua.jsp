<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="layout.jsp" %>

<h2>Kết quả</h2>
<c:if test="${not empty result}">
    <div style="color:green">${result}</div>
</c:if>
<p><a href="${pageContext.request.contextPath}/danh-sach-tin">Về danh sách</a></p>
