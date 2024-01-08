package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class LapTrinhVien extends NhanVien {

    private double luongOT;

    public LapTrinhVien() {
    }

    public LapTrinhVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email, ChucVu chucVu, double luongCB, double heSo, double luongOT, PhongBan phongBan) {
        super(hoTen, gioiTinh, d, email, chucVu, phongBan);
        this.luongCB = luongCB;
        this.heSoLuong = heSo;
        this.luongOT = luongOT;
        
    }

    @Override
    public void nhapttCoBan() {
        super.nhapttCoBan();
        System.out.print("Nhap tien luong OT: ");
        this.luongOT = Double.parseDouble(CAUHINH.SC.nextLine());
        
    }

    @Override
    public double tinhLuong() {
        return this.getLuongCB() * this.getHeSoLuong() + this.getLuongOT();
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
