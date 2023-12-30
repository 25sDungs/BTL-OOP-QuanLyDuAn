package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class KiemThuVien extends NhanVien {

    private double luongCB;
    private double heSoLuong;
    private int error;

    public KiemThuVien() {
    }

    public KiemThuVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = d;
        this.setEmail(email);
    }
    public KiemThuVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email,int error) {
        this(hoTen,gioiTinh,d,email);
        this.error=error;
    }
    @Override
    public double tinhLuong() {
        return this.getLuongCB() * this.getHeSoLuong() + this.getError() * 200;
    }

    @Override
    public void hienThi() {
        super.hienThi();
    }

    @Override
    public double getLuongCB() {
        return luongCB;
    }

    @Override
    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    @Override
    public double getHeSoLuong() {
        return heSoLuong;
    }

    @Override
    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    @Override
    public int getError() {
        return error;
    }

    @Override
    public void setError(int error) {
        this.error = error;
    }
}
