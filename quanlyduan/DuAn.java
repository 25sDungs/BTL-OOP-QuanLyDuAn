package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuAn {
    
    private int maDuAn;
    private String tenDuAn;
    private LocalDate batDau;
    private LocalDate ketThuc;
    private double tongKinhPhi;
    private List<NhanVien> dsNV = new ArrayList<>();
    
    public void xuatDSNhanVien() {
        this.dsNV.forEach(h -> h.hienThi());
    }
    
    public void themNhanVien(NhanVien... a) {
        this.dsNV.addAll(Arrays.asList(a));
        //kiem soat 5..10 nhan vien
    }
    
    public void doiQuanLy() {
        
    }
    
    public DuAn() {
    }

    /**
     * @return the maDuAn
     */
    public int getMaDuAn() {
        return maDuAn;
    }

    /**
     * @param maDuAn the maDuAn to set
     */
    public void setMaDuAn(int maDuAn) {
        this.maDuAn = maDuAn;
    }

    /**
     * @return the tenDuAn
     */
    public String getTenDuAn() {
        return tenDuAn;
    }

    /**
     * @param tenDuAn the tenDuAn to set
     */
    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    /**
     * @return the batDau
     */
    public LocalDate getBatDau() {
        return batDau;
    }

    /**
     * @param batDau the batDau to set
     */
    public void setBatDau(LocalDate batDau) {
        this.batDau = batDau;
    }

    /**
     * @return the ketThuc
     */
    public LocalDate getKetThuc() {
        return ketThuc;
    }

    /**
     * @param ketThuc the ketThuc to set
     */
    public void setKetThuc(LocalDate ketThuc) {
        this.ketThuc = ketThuc;
    }

    /**
     * @return the tongKinhPhi
     */
    public double getTongKinhPhi() {
        return tongKinhPhi;
    }

    /**
     * @param tongKinhPhi the tongKinhPhi to set
     */
    public void setTongKinhPhi(double tongKinhPhi) {
        this.tongKinhPhi = tongKinhPhi;
    }
    
}
