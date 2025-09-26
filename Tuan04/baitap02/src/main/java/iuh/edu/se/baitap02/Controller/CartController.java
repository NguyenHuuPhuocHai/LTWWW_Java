package iuh.edu.se.baitap02.Controller;

import iuh.edu.se.baitap02.DAO.ProductDao;
import iuh.edu.se.baitap02.Model.CartBean;
import iuh.edu.se.baitap02.Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CartBean cart = (CartBean) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartBean();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        ProductDao dao = new ProductDao();

        if("add".equals(action)) {
            String id = req.getParameter("id");
            Product p = dao.getProductById(id);
            String quantity = req.getParameter("quantity");
            if(p != null) {
                cart.addCartItem(p.getId(), p.getModel(), String.valueOf(p.getPrice()), quantity );
            }
        } else if ("delete".equals(action)) {
            String itemIndex = req.getParameter("itemIndex");
            cart.deleteCartItem(itemIndex);
        } else if ("update".equals(action)) {
            String itemIndex = req.getParameter("itemIndex");
            String quantity = req.getParameter("quantity");
            cart.updateCartItem(itemIndex, quantity);
        }
        resp.sendRedirect("ShoppingCart.jsp");
    }
}
