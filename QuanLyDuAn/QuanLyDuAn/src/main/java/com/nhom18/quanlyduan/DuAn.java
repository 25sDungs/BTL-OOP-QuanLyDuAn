/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author ADMIN
 */
public class DuAn {

    private static int dem = 0;
    private int maDuAn = ++dem;
    private String tenDuAn;
    private LocalDate batDau;
    private LocalDate ketThuc;
    private double tongKinhPhi;
    private NhanVien nguoiChuNhiem;
    private List<NhanVien> nvThamGia = new ArrayList<>();

    public DuAn() {

    }

    public DuAn(String tenDuAn, LocalDate batDau, LocalDate ketThuc, double tongKinhPhi, NhanVien nv, NhanVien a1, NhanVien a2, NhanVien a3) {
        this.tenDuAn = tenDuAn;
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.tongKinhPhi = tongKinhPhi;
        this.nguoiChuNhiem = nv;
        this.setNguoiThamGia(a1, a2, a3);
    }

    public void xemNvThamGia() {
        if (this.nvThamGia.isEmpty()) {
            System.out.println("Chua co nhan vien tham gia du an!");
            return;
        }
        int dem1 = 1;
        for (NhanVien nv : nvThamGia) {
            System.out.printf(">Nhan vien %d:\n", dem1++);
            nv.hienThiTtCoBan();
        }
    }

    public void hienThi() {
        System.out.printf("Ma du an: %d\nTen du an: %s\nNgay bat dau du an: %s\nNgay ket thuc du an: %s\n"
                + "Tong kinh phi: %.3f\n*Thong tin cua nguoi chu nhiem:\n", this.maDuAn, this.tenDuAn, this.batDau.format(DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), this.ketThuc.format(DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), this.tongKinhPhi);
        this.nguoiChuNhiem.hienThiTtCoBan();
        System.out.print("Danh sach nhan vien tham gia:\n");
        this.xemNvThamGia();
    }

    public void setChuNhiem(QuanLyNhanVien ql) {
        int flag = 0;
        do {
            System.out.print("Nhap ma cua nhan vien lam chu nhiem: ");
            NhanVien a = ql.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
            if (a != null) {
                if (a.getChuNhiemDuAn().size() == 3) {
                    System.out.print("Nhan vien nay da chu nhiem du du an!\n");
                } else {
                    this.nguoiChuNhiem = a;
                    a.setChuNhiem(this);
                    flag = 1;
                }
            }
        } while (flag == 0);

    }

    public void doiChuNhiem(QuanLyNhanVien ql) {
        this.nguoiChuNhiem.xoaChuNhiem(this);
        this.setChuNhiem(ql);
    }


    public void setNguoiThamGia(NhanVien... a) {
        for (NhanVien a1 : a) {
            int flag = 0;
            for (NhanVien nv : this.nvThamGia) {
                if (nv == a1) {
                    flag = 1;
                    System.out.printf("Nhan vien ma %d da tham gia du an nay!\n", a1.getMaNhanVien());
                    break;
                }
            }
            if (flag == 0) {
                if (a1.getDsDuAn().size() >= 3) {
                    System.out.print("Nhan vien nay da tham gia du 3 du an\n");
                    return;
                }
                a1.setDuAn(this);
                this.nvThamGia.add(a1);
                System.out.print("Them nhan vien thanh cong\n");
            }
        }
    }

    public void loaiNhanVien(NhanVien nv) {
        for (NhanVien a : nvThamGia) {
            if (a == nv) {
                nvThamGia.remove(nv);
                nv.xoaDsDuAn(this);
                System.out.print("Da xoa nhan vien\n");
                return;
            }
        }
        System.out.print("Khong tim thay nhan vien de xoa\n");

    }

    public void suaThanhVien(QuanLyNhanVien ql) {
        int flag = 0;
        do {
            System.out.print("== CAI DAT THANH VIEN ==\n1. Them thanh vien\n2. Xoa thanh vien\n3. Hoan thanh chinh sua\n>Chon chuc nang: ");
            switch (Integer.parseInt(CAUHINH.SC.nextLine())) {
                case 1: {
                    if (this.nvThamGia.size() == 10) {
                        System.out.print("So luong nhan vien da dat toi ta\n");
                        break;
                    }
                    System.out.print("= THEM THANH VIEN =\nNhap ma nhan vien can them vao du an: ");
                    NhanVien a = ql.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                    if (a != null) {
                        this.setNguoiThamGia(a);
                    }
                    break;
                }
                case 2: {
                    if (this.nvThamGia.isEmpty()) {
                        System.out.print("Khong co nhan vien de thuc hien chuc nang!\n");
                        break;
                    }
                    System.out.print("= XOA NHAN VIEN =\nNhap ma nhan vien can xoa: ");
                    NhanVien a = ql.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                    if (a != null) {
                        this.loaiNhanVien(a);
                    }
                    break;
                }
                case 3: {
                    if (this.nvThamGia.size() < 5) {
                        System.out.print("Du an dang thieu thanh vien!\n");
                    } else if (this.nvThamGia.size() > 10) {
                        System.out.print("So luong nhan vien da vuot qua cho phep\n");
                    } else {
                        System.out.print("Hoan thanh cai dat nhan vien\n");
                        flag = 1;
                    }

                    break;
                }
                default: {
                    System.out.print("Khong co chuc nang ma ban chon!\n");
                    break;
                }
            }

        } while (flag == 0);
    }

    public void setTenDuAn() {
        System.out.print("Nhap ten du an: ");
        this.setTenDuAn(CAUHINH.SC.nextLine());

    }

    public void setNgayBatDau() {
        System.out.print("Nhap vao ngay bat dau: ");
        this.setBatDau(LocalDate.parse(CAUHINH.SC.nextLine(), DateTimeFormatter.ofPattern(CAUHINH.PATTERN)));
    }

    public void setNgayKetThuc() {
        System.out.print("Nhap vao ngay du an ket thuc: ");
        this.setKetThuc(LocalDate.parse(CAUHINH.SC.nextLine(), DateTimeFormatter.ofPattern(CAUHINH.PATTERN)));
    }

    public void setKinhPhi() {
        System.out.print("Nhap vao kinh phi du kien: ");
        this.setTongKinhPhi(Double.parseDouble(CAUHINH.SC.nextLine()));
    }

    @Override
    public String toString() {
        return String.format("Ma du an: %d\nTen du an: %s\nNgay bat dau: %s\nNgay ket thuc: %s\nKinh phi: %.3f", this.getMaDuAn(),
                this.getBatDau().format(DateTimeFormatter.ofPattern(CAUHINH.PATTERN)),
                this.getKetThuc().format(DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), this.getTongKinhPhi());
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

    /**
     * @return the nguoiChuNhiem
     */
    public NhanVien getNguoiChuNhiem() {
        return nguoiChuNhiem;
    }

    /**
     * @param nguoiChuNhiem the nguoiChuNhiem to set
     */
    public void setNguoiChuNhiem(NhanVien nguoiChuNhiem) {
        this.nguoiChuNhiem = nguoiChuNhiem;
    }

    /**
     * @return the nvThamGia
     */
    public List<NhanVien> getNvThamGia() {
        return nvThamGia;
    }

    /**
     * @param nvThamGia the nvThamGia to set
     */
    public void setNvThamGia(List<NhanVien> nvThamGia) {
        this.nvThamGia = nvThamGia;
    }

}
