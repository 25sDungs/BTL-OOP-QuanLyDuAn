package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class NhanVienThuong extends NhanVien {

    private double luongCB;
    private double heSoLuong;

    public NhanVienThuong() {
    }

    public NhanVienThuong(String hoTen, GioiTinh gioiTinh, LocalDate d, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = d;
        this.setEmail(email);
    }

    @Override
    public double tinhLuong() {
        return this.luongCB * this.heSoLuong;
    }

    @Override
    public void hienThi() {
        super.hienThi();
    }

}
