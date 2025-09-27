<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout.jsp" %>

<c:set var="dms" value="${requestScope.danhMucs}" />
<h2>Danh sách tin tức</h2>

<form method="get" action="${pageContext.request.contextPath}/danh-sach-tin">
    Chọn danh mục:
    <select name="madm" onchange="this.form.submit()">
        <option value="">--Tất cả--</option>
        <c:forEach var="dm" items="${dms}">
            <option value="${dm.maDM}">
                    ${dm.tenDanhMuc}
            </option>
        </c:forEach>
    </select>
</form>

<table>
    <tr><th>MÃ</th><th>TIÊU ĐỀ</th><th>NỘI DUNG</th><th>LIÊN KẾT</th><th>DM</th></tr>
    <c:forEach var="t" items="${tinList}">
        <tr>
            <td>${t.maTT}</td>
            <td>${t.tieuDe}</td>
            <td>${t.noiDungTT}</td>
            <td><a href="${t.lienKet}" target="_blank">${t.lienKet}</a></td>
            <td>${t.maDM}</td>
        </tr>
    </c:forEach>
</table>
