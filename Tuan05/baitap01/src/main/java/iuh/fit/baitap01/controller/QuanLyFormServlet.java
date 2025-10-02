package iuh.fit.baitap01.controller;

import iuh.fit.baitap01.dao.DienThoaiDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/quan-ly")
public class QuanLyFormServlet extends HttpServlet {
    private DienThoaiDAO dao = new DienThoaiDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String madt = req.getParameter("madt");
            if (madt != null && !madt.isEmpty()) {
                dao.delete(madt);
                req.setAttribute("message", "Xóa thành công " + madt);
            } else {
                req.setAttribute("message", "Không tìm thấy mã để xóa.");
            }
            req.getRequestDispatcher("/views/KetQua.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
