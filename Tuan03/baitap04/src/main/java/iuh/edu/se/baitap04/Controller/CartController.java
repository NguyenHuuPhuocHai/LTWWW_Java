package iuh.edu.se.baitap04.Controller;

import iuh.edu.se.baitap04.Model.CartBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strAction = req.getParameter("action");

        if (strAction != null && !strAction.isEmpty()) {
            if (strAction.equalsIgnoreCase("add")) {
                addToCart(req);
            } else if (strAction.equalsIgnoreCase("update")) {
                updateCart(req);
            } else if (strAction.equalsIgnoreCase("delete")) {
                deleteCart(req);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/ShoppingCart.jsp");
    }

    protected void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        CartBean cartBean = getCartFromSession(session);

        String strModelNo = safe(request.getParameter("modelNo"));
        String strDescription = safe(request.getParameter("description"));
        String strPrice = safe(request.getParameter("price"));
        String strQuantity = safe(request.getParameter("quantity"));

        cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        CartBean cartBean = getCartFromSession(session);

        String strItemIndex = safe(request.getParameter("itemIndex"));
        String strQuantity = safe(request.getParameter("quantity"));

        cartBean.updateCartItem(strItemIndex, strQuantity);
    }

    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        CartBean cartBean = getCartFromSession(session);

        String strItemIndex = safe(request.getParameter("itemIndex"));
        cartBean.deleteCartItem(strItemIndex);
    }

    // Lấy CartBean từ session hoặc tạo mới nếu chưa có
    private CartBean getCartFromSession(HttpSession session) {
        CartBean cartBean = (CartBean) session.getAttribute("cart");
        if (cartBean == null) {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }
        return cartBean;
    }

    // Hàm an toàn, tránh null + trim
    private String safe(String s) {
        return s != null ? s.trim() : "";
    }
}
