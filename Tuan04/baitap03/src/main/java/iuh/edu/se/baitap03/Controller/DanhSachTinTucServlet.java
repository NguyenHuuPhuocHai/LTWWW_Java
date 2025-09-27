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

@WebServlet("/danh-sach-tin")
public class DanhSachTinTucServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource ds;

    private DanhSachTinTucQuanLy dao;

    @Override
    public void init() throws ServletException {
        dao = new DanhSachTinTucQuanLyImpl(ds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sMa = req.getParameter("madm");
        int maDM = 0;
        if (sMa != null) {
            try { maDM = Integer.parseInt(sMa); } catch (NumberFormatException ignored) {}
        }
        List<DanhMuc> danhMucs = dao.layTatCaDanhMuc();
        req.setAttribute("danhMucs", danhMucs);

        List<TinTuc> tinList;
        if (maDM > 0) {
            tinList = dao.layTheoDanhMuc(maDM);
            req.setAttribute("selectedMaDM", maDM);
        } else {
            tinList = new java.util.ArrayList<>();
            for (DanhMuc dm : danhMucs) {
                tinList.addAll(dao.layTheoDanhMuc(dm.getMaDM()));
            }
        }
        req.setAttribute("tinList", tinList);
        req.getRequestDispatcher("/views/DanhSachTinTuc.jsp").forward(req, resp);
    }
}
