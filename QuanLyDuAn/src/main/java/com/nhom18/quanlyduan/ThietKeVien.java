package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class ThietKeVien extends NhanVien {

    private double bonus;

    public ThietKeVien() {
    }

    public ThietKeVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email, ChucVu chucVu, double luongCB, double heSo, double bonus, PhongBan phongBan) {
        super(hoTen, gioiTinh, d, email, chucVu, phongBan);
        this.luongCB = luongCB;
        this.heSoLuong = heSo;
        this.bonus = bonus;
    }

    @Override
    public void nhapttCoBan() {
        super.nhapttCoBan();
        System.out.print("Nhap tien luong bonus: ");
        this.bonus = Double.parseDouble(CAUHINH.SC.nextLine());
        
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
