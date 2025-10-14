package iuh.fit.baitap01.model;

public class SinhVien {
    private String maSV;
    private String hoTen;
    private Lop lop;

    public SinhVien() {}

    public SinhVien(String maSV, String hoTen, Lop lop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.lop = lop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return "Sinh viên: " + hoTen + " (" + maSV + ")\n" + lop;
    }
}
