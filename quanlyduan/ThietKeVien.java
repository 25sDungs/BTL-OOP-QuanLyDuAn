package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class ThietKeVien extends NhanVien {

    private double luongCB;
    private double heSoLuong;
    private double bonus;

    public ThietKeVien() {
    }

    public ThietKeVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = d;
        this.setEmail(email);
    }

    @Override
    public double tinhLuong() {
        return this.getLuongCB() * this.getHeSoLuong() + this.getBonus();
    }

    @Override
    public void hienThi() {
        super.hienThi();
    }

    /**
     * @return the bonus
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
