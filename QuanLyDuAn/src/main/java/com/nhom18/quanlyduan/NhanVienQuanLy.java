/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienQuanLy extends NhanVien{

    private NhanVien nvK;
    private LocalDate ngayNhanChuc;
    private List<PhongBan> dsBanQL = new ArrayList<>();
    
    public void setQL(NhanVien nv){
        this.setMaNhanVien(nv.getMaNhanVien());
        this.hoTen = nv.getHoTen();
        this.gioiTinh = nv.getGioiTinh();
        this.ngaySinh = nv.getNgaySinh();
        this.setEmail(nv.getEmail());
        this.setChucVu(nv.getChucVu());
    }

    public NhanVienQuanLy(NhanVien nv) {
        this.setMaNhanVien(nv.getMaNhanVien());
        this.hoTen = nv.getHoTen();
        this.gioiTinh = nv.getGioiTinh();
        this.ngaySinh = nv.getNgaySinh();
        this.setEmail(nv.getEmail());
        this.setChucVu(nv.getChucVu());
        
    }
    
    public void hienThiNgayNhanChuc(){
        
    }

    public void setNgayNhanChuc() {
        System.out.print("Nhap ngay nhan chuc quan ly:\n");
        this.setNgayNhanChuc(CAUHINH.NHAP_NGAY_THANG_NAM());
    }
    
    @Override
    public void hienThiTtCoBan(){
        super.hienThiTtCoBan();
        System.out.printf("Ngay nhan chuc: %s\n", this.getNgayNhanChuc().format(DateTimeFormatter.ofPattern(CAUHINH.PATTERN)));
    }
    
    @Override
    public double tinhLuong() {
        return this.getNvK().tinhLuong();
    }

    @Override
    public void hienThi() {
        super.hienThi();
    }
    

    /**
     * @return the nvK
     */
    public NhanVien getNvK() {
        return nvK;
    }

    /**
     * @param nvK the nvK to set
     */
    public void setNvK(NhanVien nvK) {
        this.nvK = nvK;

    }

    /**
     * @return the ngayNhanChuc
     */
    public LocalDate getNgayNhanChuc() {
        return ngayNhanChuc;
    }

    /**
     * @param ngayNhanChuc the ngayNhanChuc to set
     */
    public void setNgayNhanChuc(LocalDate ngayNhanChuc) {
        this.ngayNhanChuc = ngayNhanChuc;
    }

    /**
     * @return the dsBanQL
     */
    public List<PhongBan> getDsBanQL() {
        return dsBanQL;
    }

    /**
     * @param dsBanQL the dsBanQL to set
     */
    public void setDsBanQL(List<PhongBan> dsBanQL) {
        this.dsBanQL = dsBanQL;
    }

}
