/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Acer
 */
public class QuanLyPhongBan {

    private List<PhongBan> ds = new ArrayList<>();

    public void themPhongBan(PhongBan... a) {
        this.ds.addAll(Arrays.asList(a));
    }

    public void xoaPhongBan(String kw) {
        this.ds.removeIf(h -> h.getTenPhongBan().contains(kw));
    }

    public void hienThiDSPhongBan() {
        System.out.println("===========Danh Sach Cac Phong Ban===========");
        this.ds.forEach(h -> System.out.println(h.getTenPhongBan()));
    }

    /**
     * @return the ds
     */
    public List<PhongBan> getDs() {
        return ds;
    }

    /**
     * @param ds the ds to set
     */
    public void setDs(List<PhongBan> ds) {
        this.ds = ds;
    }

}
