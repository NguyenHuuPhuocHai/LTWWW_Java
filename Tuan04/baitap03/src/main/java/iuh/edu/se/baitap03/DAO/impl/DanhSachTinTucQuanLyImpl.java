package iuh.edu.se.baitap03.DAO.impl;

import iuh.edu.se.baitap03.DAO.DanhSachTinTucQuanLy;
import iuh.edu.se.baitap03.Model.DanhMuc;
import iuh.edu.se.baitap03.Model.TinTuc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhSachTinTucQuanLyImpl implements DanhSachTinTucQuanLy {
    private final DataSource ds;

    public DanhSachTinTucQuanLyImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<TinTuc> layTheoDanhMuc(int maDM) {
        String sql = "SELECT MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM FROM TINTUC WHERE MADM = ?";
        List<TinTuc> list = new ArrayList<>();
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maDM);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new TinTuc(
                            rs.getInt("MATT"),
                            rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"),
                            rs.getString("LIENKET"),
                            rs.getInt("MADM")
                    ));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public List<DanhMuc> layTatCaDanhMuc() {
        String sql = "SELECT MADM, TENDANHMUC, NGUOIQUANLY, GHICHU FROM DANHMUC";
        List<DanhMuc> list = new ArrayList<>();
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new DanhMuc(
                        rs.getInt("MADM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("NGUOIQUANLY"),
                        rs.getString("GHICHU")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public boolean themTinTuc(TinTuc t) {
        String sql = "INSERT INTO TINTUC (TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?, ?, ?, ?)";
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, t.getTieuDe());
            ps.setString(2, t.getNoiDungTT());
            ps.setString(3, t.getLienKet());
            ps.setInt(4, t.getMaDM());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    @Override
    public boolean xoaTinTuc(int maTT) {
        String sql = "DELETE FROM TINTUC WHERE MATT = ?";
        try (Connection con = ds.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maTT);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}
