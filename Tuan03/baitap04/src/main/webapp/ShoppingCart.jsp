<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" scope="session" class="iuh.edu.se.baitap04.Model.CartBean" />

<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<p>
    <a href="${pageContext.request.contextPath}/DSSP">Product List</a>
</p>
<table width="100%" border="1">
    <tr bgcolor="#CCCCCC">
        <td>Model Description</td>
        <td>Quantity</td>
        <td>Unit Price</td>
        <td>Total</td>
    </tr>

    <c:if test="${cart.lineItemCount == 0}">
        <tr>
            <td colspan="4">Cart is currently empty</td>
        </tr>
    </c:if>

    <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
        <tr>
            <td>
                <b>${cartItem.partNumber}</b><br/>
                    ${cartItem.modelDescription}
            </td>
            <td>
                <form method="POST" action="${pageContext.request.contextPath}/CartController">
                    <input type="hidden" name="itemIndex" value="${counter.index + 1}" />
                    <input type="number" name="quantity" value="${cartItem.quantity}" min="1" step="1" />
                    <input type="submit" name="action" value="Update"/>
                    <input type="submit" name="action" value="Delete"/>
                </form>
            </td>
            <td>$${cartItem.unitCost}</td>
            <td>$${cartItem.totalCost}</td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="2"></td>
        <td>Subtotal:</td>
        <td>$${cart.orderTotal}</td>
    </tr>
</table>
</body>
</html>
