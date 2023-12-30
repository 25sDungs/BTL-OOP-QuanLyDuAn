package com.nhom18.quanlyduan;

import java.time.LocalDate;

public abstract class ThongTinConNguoi {

    protected String hoTen;
    protected LocalDate ngaySinh;
    protected GioiTinh gioiTinh;

    public GioiTinh getGioiTinh() {
        return this.gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return this.ngaySinh;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void hienThi() {
        System.out.printf("Ho Ten: %s\nNgay Sinh: %s\nGioi Tinh: %s\n",
                this.hoTen, this.ngaySinh.format(CAUHINH.PATTERN), this.gioiTinh);
    }
    public void nhapttCoBan() {
        System.out.print("Nhap thong tin Ho Ten: ");
        this.setHoTen(CAUHINH.SC.nextLine());
        System.out.print("Nhap ngay sinh: ");
        int a = Integer.parseInt(CAUHINH.SC.nextLine());
        System.out.print("Nhap thang sinh: ");
        int b = Integer.parseInt(CAUHINH.SC.nextLine());
        System.out.print("Nhap nam sinh: ");
        int c = Integer.parseInt(CAUHINH.SC.nextLine());
        this.setNgaySinh(LocalDate.of(c, b, a));
        System.out.print("Gioi Tinh: ");
        String s = CAUHINH.SC.nextLine().toUpperCase();
        switch (s) {
            case "NAM" ->
                this.setGioiTinh(GioiTinh.NAM);
            case "NU" ->
                this.setGioiTinh(GioiTinh.NU);
            default ->
                this.setGioiTinh(GioiTinh.KHAC);
        }
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
}
