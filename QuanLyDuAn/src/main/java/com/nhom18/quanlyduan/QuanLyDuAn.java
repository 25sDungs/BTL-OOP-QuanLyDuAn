/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ADMIN
 */
public class QuanLyDuAn {

    private List<DuAn> dsDuAn = new ArrayList<>();

    public void themDuAn(DuAn... a) {
        dsDuAn.addAll(Arrays.asList(a));
    }

    public void themDuAn(QuanLyNhanVien ql) {
        DuAn a = new DuAn();
        a.setTenDuAn();
        a.setBatDau(CAUHINH.NHAP_NGAY_THANG_NAM());
        a.setKetThuc(CAUHINH.NHAP_NGAY_THANG_NAM());
        a.setKinhPhi();
        a.setChuNhiem(ql);
        a.suaThanhVien(ql);
        dsDuAn.add(a);
    }

    public void xoaDuAn(int kw) {
        DuAn duAn = this.timDuAn(kw);
        if (duAn != null) {
            this.dsDuAn.remove(duAn);
            duAn.setNvThamGia(null);
            duAn.getNvThamGia().stream().forEach(nv -> {
                nv.xoaDsDuAn(duAn);

            });
            duAn.getNguoiChuNhiem().xoaChuNhiem(duAn);
        }
    }

    public void suaDuAn(DuAn a) {
        int flag = 0;
        do {
            flag = 0;
            System.out.printf("Nhap lai cac thong tin du an %d: \n1. Sua ten du an\n2. Sua ngay bat dau\n"
                    + "3. Sua ngay ket thuc\n4. Sua kinh phi\n5. Hoan thanh sua\nChon thong tin can sua: ", a.getMaDuAn());
            switch (CAUHINH.SC.nextLine()){
                case "1": {
                    a.setTenDuAn();
                    break;
                }
                case "2": {
                    a.setBatDau(CAUHINH.NHAP_NGAY_THANG_NAM());
                    break;
                }
                case "3": {
                    a.setKetThuc(CAUHINH.NHAP_NGAY_THANG_NAM());
                    break;
                }
                case "4": {
                    a.getTongKinhPhi();
                    break;
                }
                case "5": {
                    System.out.print("Hoan thanh sua! Quay lai menu!\n");
                    break;
                }
                default: {
                    flag = 1;
                    System.out.print("Khong co chuc nang ma ban chon! Chon lai!\n");
                    break;
                }
            }
        } while (flag == 1);
    }

    public void timDuAn() {
        int flag2 = 0;
        do {
            System.out.print("1. Tim theo ma\n2. Tim theo ngay\nChon phuong thuc tim: ");
            switch (CAUHINH.SC.nextLine()) {
                case "1": {
                    System.out.print("=== TIM THEO MA ===\nNhap ma cua du an can tim: ");
                    DuAn a = timDuAn(Integer.parseInt(CAUHINH.SC.nextLine()));
                    if (a != null) {
                        a.hienThi();
                    }
                    break;
                }

                case "2": {
                    System.out.print("=== TIM THEO NGAY ===\nNhap ngay cua du an: ");
                    int ngay = Integer.parseInt(CAUHINH.SC.nextLine());
                    timDuAn(ngay);
                    break;
                }
                default: {
                    flag2 = 1;
                    System.out.print("Khong co phuong thuc tim!\nChon lai phuong thuc : ");
                }
            }
        } while (flag2 == 1);
    }

    public DuAn timDuAn(int kw) {
        DuAn a = this.dsDuAn.stream().filter(duAn -> duAn.getMaDuAn() == kw).findFirst().orElse(null);
        if (a != null) {
            return a;
        }
        System.out.print("Khong tim thay du an!\n");
        return null;
    }

    public void timDuAn(LocalDate kw) {
        List<DuAn> kq = this.dsDuAn.stream().filter(duAn -> duAn.getBatDau().isEqual(kw) || duAn.getKetThuc().isEqual(kw)).collect(Collectors.toList());
        kq.forEach(h -> h.hienThi());
    }

    public void sapXep() {
        this.dsDuAn.sort(Comparator.comparing(DuAn::getTongKinhPhi));
    }

    public void hienThiDS() {
        int dem1 = 1;
        if (dsDuAn.isEmpty()) {
            System.out.print("Khong co du an.\n");
            return;
        }
        for (DuAn duAn : dsDuAn) {
            System.out.printf("=>Du an thu %d:\n", dem1++);
            duAn.hienThi();
        }
    }

    public void suaDsNhanVien(QuanLyNhanVien ql) {
        System.out.print("== SUA DANH SACH NHAN VIEN ==\nNhap ma cua du an: ");
        DuAn a = this.timDuAn(Integer.parseInt(CAUHINH.SC.nextLine()));
        if (a != null) {
            a.suaThanhVien(ql);
        }
    }

    /**
     * @return the dsDuAn
     */
    public List<DuAn> getDsDuAn() {
        return dsDuAn;
    }

    /**
     * @param dsDuAn the dsDuAn to set
     */
    public void setDsDuAn(List<DuAn> dsDuAn) {
        this.dsDuAn = dsDuAn;
    }

}
