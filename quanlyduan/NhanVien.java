package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class NhanVien extends ThongTinConNguoi {

    private static int dem = 0;
    private int maNhanVien = ++dem;
    protected String email;
    private double luongCB;
    private double heSoLuong;
    private PhongBan phongBan;
    private List<ThanNhan> dsThanNhan = new ArrayList();
    private List<DuAn> dsDuAn = new ArrayList<>();

    public void themThanNhan(ThanNhan... a) {
        this.dsThanNhan.addAll(Arrays.asList(a));
    }

    public NhanVien() {
    }

    public NhanVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = d;
        this.email = email;
    }

    public abstract double tinhLuong();

    @Override
    public void nhapttCoBan() {
        super.nhapttCoBan();
        System.out.print("Nhap dia chi email: ");
        this.setEmail(CAUHINH.SC.nextLine());
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("ID: %s\nEmail: %s\nLuong Nhan Vien: %.1f\n", this.getMaNhanVien(), this.getEmail(), this.tinhLuong());
    }

    public void xuatdsDuAn() {
    }

    public void xuatDanhSachThanNhan() {
        this.dsThanNhan.forEach(h -> h.hienThi());
    }

    public void setError(int error) {
    }

    public int getError() {
        return 0;
    }

    public double getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan ban) {
        if (this.phongBan != null) {
            phongBan.xoaNhanVien(this);
        }
        this.phongBan = ban;
        ban.themNhanVien(this);
    }

    /**
     * @return the maNhanVien
     */
    public int getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

}
