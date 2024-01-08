package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThanNhan extends ThongTinConNguoi {

    private String moiQH;
    private List<ThanNhan> ds = new ArrayList<>();
    private NhanVien qhNV; 

    public void addThanNhan(ThanNhan... a) {
        this.getDs().addAll(Arrays.asList(a));
    }

    public void hienThidsNhanTHan() {
        System.out.println("=====Danh Sach Than Nhan=====");
        for (ThanNhan x : this.getDs()) {
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

    public ThanNhan(String hoTen, LocalDate d, GioiTinh g, String mqh, NhanVien nv) {
        this.hoTen = hoTen;
        this.ngaySinh = d;
        this.gioiTinh = g;
        this.moiQH = mqh;
        this.qhNV = nv;
        nv.themThanNhan(this);
    }
    
    
    public void xoaQhNV(){
        this.qhNV = null;
    }
    
    public void xoaMoiQH(){
        this.qhNV = null;
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
        this.setMoiQH(CAUHINH.SC.nextLine());
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("Moi quan he voi Nhan Vien: %s\n", this.getMoiQH());
    }

    /**
     * @return the ds
     */
    public List<ThanNhan> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<ThanNhan> ds) {
        this.ds = ds;
    }

    /**
     * @return the qhNV
     */
    public NhanVien getQhNV() {
        return qhNV;
    }

    /**
     * @param qhNV the qhNV to set
     */
    public void setQhNV(NhanVien qhNV) {
        this.qhNV = qhNV;
    }
}
