package iuh.edu.se.baitap03.Controller;

import iuh.edu.se.baitap03.DAO.DanhSachTinTucQuanLy;
import iuh.edu.se.baitap03.DAO.impl.DanhSachTinTucQuanLyImpl;
import iuh.edu.se.baitap03.Model.DanhMuc;
import iuh.edu.se.baitap03.Model.TinTuc;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/quan-ly")
public class QuanLyFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource ds;
    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() {
        dao = new DanhSachTinTucQuanLyImpl(ds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DanhMuc> dms = dao.layTatCaDanhMuc();
        req.setAttribute("danhMucs", dms);
        java.util.List<TinTuc> all = new java.util.ArrayList<>();
        for (DanhMuc dm : dms) all.addAll(dao.layTheoDanhMuc(dm.getMaDM()));
        req.setAttribute("tinList", all);
        req.getRequestDispatcher("/views/QuanLyForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            String sMa = req.getParameter("matt");
            try {
                int ma = Integer.parseInt(sMa);
                boolean ok = dao.xoaTinTuc(ma);
                req.setAttribute("result", ok ? "Xóa thành công." : "Xóa thất bại.");
            } catch (Exception e) {
                req.setAttribute("result", "Mã tin không hợp lệ.");
            }
            req.getRequestDispatcher("/views/KetQua.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/quan-ly");
        }
    }
}
