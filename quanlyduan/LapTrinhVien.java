package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class LapTrinhVien extends NhanVien {

    private double luongCB;
    private double heSoLuong;
    private double luongOT;

    public LapTrinhVien() {
    }

    public LapTrinhVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = d;
        this.setEmail(email);
    }

    @Override
    public double tinhLuong() {
        return this.luongCB * this.heSoLuong + this.getLuongOT();
    }

    @Override
    public void hienThi() {
        super.hienThi();
    }

    /**
     * @return the luongOT
     */
    public double getLuongOT() {
        return luongOT;
    }

    /**
     * @param luongOT the luongOT to set
     */
    public void setLuongOT(double luongOT) {
        this.luongOT = luongOT;
    }

}
