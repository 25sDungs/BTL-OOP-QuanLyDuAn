package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhongBan {

    private String tenPhongBan;
    private List<NhanVien> dsnv = new ArrayList<>();
    private NhanVienQuanLy quanLy;

    public PhongBan() {

    }

    public PhongBan(String ten, NhanVien nv, NhanVien a1, NhanVien a2, NhanVien a3) {
        this.tenPhongBan = ten;
        this.themNhanVien(a1, a2, a3);
        this.themQuanLy(nv);
    }

    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public void hienThi() {
        System.out.printf("Ten ban: %s\nNguoi quan ly: \n", this.getTenPhongBan());
        if (this.quanLy != null) {
            this.quanLy.hienThiTtCoBan();
        } else {
            System.out.print("Ban chua co quan ly\n");
        }
        System.out.print("***DANH SACH NHAN VIEN*** \n");
        if (this.dsnv.isEmpty()) {
            System.out.print("Ban chua co nhan vien\n");
        } else {
            getDsnv().forEach(nv -> nv.hienThiTtCoBan());
        }

    }

    public void themBan(QuanLyNhanVien ql) {
        System.out.print("Ten cua phong ban: ");
        this.setTenPhongBan(CAUHINH.SC.nextLine());
        System.out.print("Hoan thanh them ban\n");

    }

    public void themQuanLy(NhanVien nv) {
        this.quanLy = new NhanVienQuanLy(nv);
        quanLy.setNgayNhanChuc(LocalDate.parse("10/12/2020", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)));
        this.quanLy.getDsBanQL().add(this);
    }

    public void themQuanLy(QuanLyNhanVien ql) {
        if (this.quanLy != null) {
            System.out.print("Ban da co quang ly!\n");
        } else {
            int flag = 0;
            while (flag == 0) {
                System.out.print("Nhap ma cua nhan vien lam quan ly: ");
                NhanVien nv = ql.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));

                if (nv != null) {
                    if (nv.getDsBanQL().size() < 2) {
                        nv.setDsBanQL(this);
                        this.quanLy = new NhanVienQuanLy(nv);
                        this.quanLy.setNgayNhanChuc();
                        this.quanLy.getDsBanQL().add(this);
                        flag = 1;
                        return;
                    }
                    System.out.print("Nhan vien nay da quan ly 2 du an\n");

                }
            }
        }

    }

    public void xoaQuanLy(QuanLyNhanVien ql) {
        if (this.quanLy != null) {
            NhanVien nv = ql.timTheoMaNhanVien(quanLy.getMaNhanVien());
            nv.xoaDsBanQL(this);
            this.quanLy = null;
        }

    }

    public void themNhanVien(QuanLyNhanVien ql) {
        int flag = 0;
        do {
            System.out.print("1. Them nhan vien\n2. Ngung them\nChon: ");
            switch (Integer.parseInt(CAUHINH.SC.nextLine())) {
                case 1: {
                    System.out.print("=== THEM NHAN VIEN VAO BANG ===\nNhap ma cua nhan vien can them: ");
                    NhanVien nv = ql.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                    if (nv != null) {
                        if (nv.getPhongBan() == null) {
                            this.dsnv.add(nv);
                            nv.setPhongBan(this);
                            break;
                        }
                        System.out.print("Nhan vien da tham gia ban\n");
                    }
                    break;
                }
                case 2: {
                    flag = 1;
                    System.out.print("Hoan thanh viec them\n");
                    break;
                }
                default: {
                    System.out.print("Khong co phuong thuc ma ban chon! Chon lai!\n");
                    break;
                }
            }
        } while (flag == 0);
    }

    public void xoaNhanVien(QuanLyNhanVien ql, QuanLyPhongBan qlBan) {
        System.out.print("Nhap ma nhan vien can xoa: ");
        NhanVien nv = ql.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
        if (nv != null) {
            if (nv.getPhongBan().getTenPhongBan() == this.getTenPhongBan()) {
                this.dsnv.remove(nv);
                nv.setPhongBan(qlBan);
                return;
            }
            System.out.print("Nhan vien khong co trong ban\n");

        }
    }

    public void themNhanVien(NhanVien... a) {
        this.dsnv.addAll(Arrays.asList(a));
        for (NhanVien nv : a) {
            nv.setPhongBan(this);
        }

    }

    public void xoaNhanVien(NhanVien a) {
        this.getDsnv().remove(a);
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

    public void setDsnv(NhanVien nv) {
        for (NhanVien a : dsnv) {
            if (a.getMaNhanVien() == nv.getMaNhanVien()) {
                System.out.print("Nhan vien nay da co trong ban!\n");
                return;
            }
        }
        this.dsnv.add(nv);
    }
}
