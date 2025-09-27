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
import java.util.regex.Pattern;

@WebServlet("/tin-form")
public class TinTucFormServlet extends HttpServlet {
    @Resource(name = "jdbc/quanlydanhmuc")
    private DataSource ds;
    private DanhSachTinTucQuanLy dao;

    private static final Pattern LINK_PATTERN = Pattern.compile("^http://.*", Pattern.CASE_INSENSITIVE);
    private static final Pattern NOIDUNG_PATTERN = Pattern.compile("^.{1,255}$", Pattern.DOTALL);

    @Override
    public void init() {
        dao = new DanhSachTinTucQuanLyImpl(ds);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DanhMuc> dms = dao.layTatCaDanhMuc();
        req.setAttribute("danhMucs", dms);
        req.getRequestDispatcher("/views/TinTucForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String tieuDe = req.getParameter("tieude");
        String noiDung = req.getParameter("noidung");
        String lienKet = req.getParameter("lienket");
        String sMaDM = req.getParameter("madm");

        String err = null;
        if (tieuDe == null || tieuDe.trim().isEmpty()) err = "Tiêu đề là bắt buộc.";
        else if (lienKet == null || !LINK_PATTERN.matcher(lienKet.trim()).matches()) err = "Liên kết phải bắt đầu bằng \"http://\"";
        else if (noiDung == null || !NOIDUNG_PATTERN.matcher(noiDung).matches()) err = "Nội dung phải không vượt quá 255 ký tự.";
        else if (sMaDM == null) err = "Danh mục là bắt buộc.";

        int maDM = 0;
        try { maDM = Integer.parseInt(sMaDM); } catch (Exception ex) { err = "Danh mục không hợp lệ."; }

        if (err != null) {
            req.setAttribute("error", err);
            req.setAttribute("tieude", tieuDe);
            req.setAttribute("noidung", noiDung);
            req.setAttribute("lienket", lienKet);
            req.setAttribute("madm", sMaDM);
            req.setAttribute("danhMucs", dao.layTatCaDanhMuc());
            req.getRequestDispatcher("/views/TinTucForm.jsp").forward(req, resp);
            return;
        }

        TinTuc t = new TinTuc();
        t.setTieuDe(tieuDe.trim());
        t.setNoiDungTT(noiDung.trim());
        t.setLienKet(lienKet.trim());
        t.setMaDM(maDM);

        boolean ok = dao.themTinTuc(t);
        req.setAttribute("result", ok ? "Thêm tin tức thành công." : "Thêm thất bại.");
        req.getRequestDispatcher("/views/KetQua.jsp").forward(req, resp);
    }
}
