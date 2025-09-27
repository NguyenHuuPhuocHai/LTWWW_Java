<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="layout.jsp" %>

<h2>Thêm tin tức</h2>
<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/tin-form" onsubmit="return validateForm()">
    Tiêu đề: <input type="text" name="tieude" id="tieude" value="${tieude}" required/><br/>
    Nội dung (<=255 ký tự): <textarea name="noidung" id="noidung" maxlength="255" required>${noidung}</textarea><br/>
    Liên kết (http:// hoặc https://): <input type="text" name="lienket" id="lienket" value="${lienket}" required/><br/>
    Danh mục:
    <select name="madm" id="madm" required>
        <option value="">--Chọn--</option>
        <c:forEach var="dm" items="${danhMucs}">
            <option value="${dm.maDM}" <c:if test="${dm.maDM == madm}">selected</c:if>>${dm.tenDanhMuc}</option>
        </c:forEach>
    </select><br/>
    <button type="submit">Thêm</button>
</form>

<script>
    function validateForm() {
        var link = document.getElementById('lienket').value.trim();
        var nd = document.getElementById('noidung').value;
        var re = /^https?:\/\/.+/i;
        if (!re.test(link)) { alert('Liên kết phải bắt đầu bằng http:// hoặc https://'); return false; }
        if (nd.length > 255) { alert('Nội dung không quá 255 ký tự'); return false; }
        return true;
    }
</script>
