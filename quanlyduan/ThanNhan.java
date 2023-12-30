package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThanNhan extends ThongTinConNguoi {

    private String moiQH;
    private List<ThanNhan> ds = new ArrayList<>();

    public void addThanNhan(ThanNhan... a) {
        this.ds.addAll(Arrays.asList(a));
    }

    public void hienThidsNhanTHan() {
        System.out.println("=====Danh Sach Than Nhan=====");
        for (ThanNhan x : this.ds) {
            x.hienThi();
        }
    }

    /**
     * @return the moiQH
     */
    public String getMoiQH() {
        return moiQH;
    }

    public ThanNhan() {
    }

    public ThanNhan(String hoTen, LocalDate d, GioiTinh g, String mqh) {
        this.hoTen = hoTen;
        this.ngaySinh = d;
        this.gioiTinh = g;
        this.moiQH = mqh;
    }

    /**
     * @param moiQH the moiQH to set
     */
    public void setMoiQH(String moiQH) {
        this.moiQH = moiQH;
    }

    @Override
    public void nhapttCoBan() {
        super.nhapttCoBan();
        System.out.print("Nhap moi quan he: ");
        this.moiQH = CAUHINH.SC.nextLine();
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("Moi quan he voi Nhan Vien: %s\n", this.moiQH);
    }
}
