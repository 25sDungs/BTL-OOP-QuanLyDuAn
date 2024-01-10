/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Acer
 */
public class QuanLyPhongBan {

    private List<PhongBan> ds = new ArrayList<>();

    public void themPhongBan(PhongBan... a) {
        this.ds.addAll(Arrays.asList(a));
    }

    public void chinhSuaQuanLy(QuanLyNhanVien ql) {
        System.out.print("Nhap ten ban can chinh sua: ");
        PhongBan pb = this.timPhongBan(CAUHINH.SC.nextLine());
        if (pb != null) {
            int flag = 0;
            do {
                System.out.print("== CHINH SUA QUAN LY ==\n1. Them quam ly\n2. Xoa quan ly\n3. Hoan thanh chinh sua\nChon chuc nang: ");
                switch (CAUHINH.SC.nextLine()) {
                    case "1": {
                        System.out.print(">Them quan ly:\n");
                        pb.themQuanLy(ql);
                        break;
                    }
                    case "2":{
                        System.out.print(">Xoa quan ly:\n");
                        pb.xoaQuanLy(ql);
                    }
                    case "3":{
                        System.out.print("Hoan thanh chinh sua\n");
                        flag = 1;
                        break;
                    }
                    default:{
                        System.out.print("Khong co chuc nang ma ban chon!\n");
                        break;
                    }
                }
            } while (flag == 0);
        }

    }

    public void xoaPhongBan(String kw, QuanLyNhanVien ql) {
        PhongBan pb = this.timPhongBan(kw);
        if (pb != null) {
            pb.xoaQuanLy(ql);
            ds.remove(pb);
            for (NhanVien nv : pb.getDsnv()) {
                System.out.print("Nhap ban moi cho nhan vien\n");
                nv.setPhongBan(this);
            }
            
        }

    }

    public PhongBan timPhongBan(String kw) {
        PhongBan kq = this.ds.stream().filter(h -> h.getTenPhongBan().contains(kw)).findFirst().orElse(null);
        if (kq == null) {
            System.out.print("Khong tim thay phong ban\n");
            return null;
        }
        return kq;
    }

    public void themPhongBan(QuanLyNhanVien ql) {
        PhongBan phongBan = new PhongBan();
        phongBan.themBan(ql);
        ds.add(phongBan);
    }

    public void hienThiDSPhongBan() {
        int dem = 1;
        if (ds.isEmpty()) {
            System.out.print("Chua co phong ban!\n");
            return;
        }
        for (PhongBan phongBan : ds) {
            System.out.printf("Phong ban %d: %s\n", dem++, phongBan.getTenPhongBan());
        }
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
