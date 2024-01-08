package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class NhanVienThuong extends NhanVien {


    public NhanVienThuong() {
    }

    public NhanVienThuong(String hoTen, GioiTinh gioiTinh, LocalDate d, String email, ChucVu chucVu, double luongCB, double heSo) {
        super(hoTen, gioiTinh, d, email, chucVu);
        this.luongCB = luongCB;
        this.heSoLuong = heSo;
    }

    @Override
    public double tinhLuong() {
        return this.getLuongCB() * this.getHeSoLuong();
    }

    @Override
    public void hienThi() {
        super.hienThi();
    }

}
