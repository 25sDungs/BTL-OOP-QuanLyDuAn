package com.nhom18.quanlyduan;

import java.time.LocalDate;

public class KiemThuVien extends NhanVien {

    private int error;

    public KiemThuVien() {
    }

    public KiemThuVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email, ChucVu chucVu, double luongCB, double heSo, int error) {
        super(hoTen, gioiTinh, d, email, chucVu);
        this.luongCB = luongCB;
        this.heSoLuong = heSo;
        this.error = error;
        
    }
    /*public KiemThuVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email,int error) {
        this(hoTen,gioiTinh,d,email);
        this.error=error;
    }*/
    
    
    @Override
    public void nhapttCoBan() {
        super.nhapttCoBan();
        System.out.print("Nhap so luong error phat hien duoc: ");
        this.error = Integer.parseInt(CAUHINH.SC.nextLine());
        
    }
    @Override
    public double tinhLuong() {
        return this.getLuongCB() * this.getHeSoLuong() + (this.getError() * 200000);
    }

    @Override
    public void hienThi() {
        super.hienThi();
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
