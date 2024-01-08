package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NhanVienQuanLy extends NhanVien {

    private LocalDate ngayNhamChuc;
    private List<PhongBan> dsBan = new ArrayList<>();

    public NhanVienQuanLy() {
    }

    public NhanVienQuanLy(String hoTen, GioiTinh gioiTinh, LocalDate d, String email, ChucVu chucVu, LocalDate ngayNhamChuc, double luongCB, double heSo, PhongBan phongBan) {
        super(hoTen, gioiTinh, d, email, chucVu, phongBan);
        this.ngayNhamChuc = ngayNhamChuc;
        this.luongCB = luongCB;
        this.heSoLuong = heSo;
    }

    
    @Override
    public double tinhLuong() {
        return this.getHeSoLuong() * this.getLuongCB();
    }

    /**
     * @return the ngayNhamChuc
     */
    public LocalDate getNgayNhamChuc() {
        return ngayNhamChuc;
    }

    /**
     * @param ngayNhamChuc the ngayNhamChuc to set
     */
    public void setNgayNhamChuc(LocalDate ngayNhamChuc) {
        this.ngayNhamChuc = ngayNhamChuc;
    }

    /**
     * @return the ban
     */
    public List<PhongBan> getDSBan() {
        return dsBan;
    }

    /**
     * @param ban the ban to set
     */
    public void setDSBan(List<PhongBan> ban) {
        this.dsBan = dsBan;
    }

}
