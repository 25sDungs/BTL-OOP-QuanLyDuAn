package com.nhom18.quanlyduan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhongBan {

    private String tenPhongBan;
    private List<NhanVien> dsnv = new ArrayList<>();
    private List<NhanVienQuanLy> dsql = new ArrayList<>();

    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public void themNhanVien(NhanVien... a) {
        this.dsnv.addAll(Arrays.asList(a));
    }

    public void xoaNhanVien(NhanVien a) {
        this.dsnv.remove(a);
    }

    public void xemDSNhanVien() {
        System.out.printf("==========Danh Sach Nhan Vien Ban %s==========\n", this.tenPhongBan);
        this.dsnv.forEach(h -> h.hienThi());
    }

    /**
     * @return the tenPhongBan
     */
    public String getTenPhongBan() {
        return tenPhongBan;
    }

    /**
     * @param tenPhongBan the tenPhongBan to set
     */
    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    /**
     * @return the ds
     */
    public List<NhanVien> getDsnv() {
        return dsnv;
    }

    /**
     * @param ds the ds to set
     */
    public void setDsnv(List<NhanVien> ds) {
        this.dsnv = ds;
    }

    /**
     * @return the dsql
     */
    public List<NhanVienQuanLy> getDsql() {
        return dsql;
    }

    /**
     * @param dsql the dsql to set
     */
    public void setDsql(List<NhanVienQuanLy> dsql) {
        this.dsql = dsql;
    }

}
