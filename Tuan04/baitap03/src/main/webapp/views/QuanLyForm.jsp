<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout.jsp" %>

<h2>Quản lý tin tức</h2>
<c:if test="${not empty result}">
    <div style="color:green">${result}</div>
</c:if>

<table>
    <tr><th>MÃ</th><th>TIÊU ĐỀ</th><th>DM</th><th>Chức năng</th></tr>
    <c:forEach var="t" items="${tinList}">
        <tr>
            <td>${t.maTT}</td>
            <td>${t.tieuDe}</td>
            <td>${t.maDM}</td>
            <td>
                <form method="post" action="${pageContext.request.contextPath}/quan-ly" style="display:inline;">
                    <input type="hidden" name="matt" value="${t.maTT}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
