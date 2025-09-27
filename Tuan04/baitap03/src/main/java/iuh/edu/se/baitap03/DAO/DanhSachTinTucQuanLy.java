package iuh.edu.se.baitap03.DAO;

import iuh.edu.se.baitap03.Model.DanhMuc;
import iuh.edu.se.baitap03.Model.TinTuc;
import java.util.List;

public interface DanhSachTinTucQuanLy {
    List<TinTuc> layTheoDanhMuc(int maDM);
    List<DanhMuc> layTatCaDanhMuc();
    boolean themTinTuc(TinTuc t);
    boolean xoaTinTuc(int maTT);
}
