/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Acer
 */
public class main {

    public static void main(String arg[]) {
        PhongBan c1 = new PhongBan("Ban 1");
        PhongBan c2 = new PhongBan("Ban 2");
        QuanLyPhongBan quanLyPhongBan = new QuanLyPhongBan();
        quanLyPhongBan.themPhongBan(c1, c2);        
        
        NhanVien a1 = new NhanVienThuong("Ng vv a", GioiTinh.NAM, LocalDate.parse("26/11/2000", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.NHAN_VIEN_THUONG, 10000, 20, c1);
        NhanVien a2 = new NhanVienThuong("Ng vv b", GioiTinh.NAM, LocalDate.parse("26/11/2000", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.NHAN_VIEN_THUONG, 10000, 20, c2);
        NhanVien a3 = new LapTrinhVien("Ng vv c", GioiTinh.NAM, LocalDate.parse("26/11/2000", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.LAP_TRINH_VIEN, 10000, 20, 30000, c2);
        NhanVien a4 = new NhanVienThuong("Ng vv d", GioiTinh.NAM, LocalDate.parse("15/01/2000", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.NHAN_VIEN_THUONG, 10000, 20, c2);
        NhanVien a5 = new KiemThuVien("Ng vv e", GioiTinh.NAM, LocalDate.parse("12/12/2004", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.KIEM_THU_VIEN, 10000, 20, 7, c1);
        NhanVien a7 = new ThietKeVien("Ng vv g", GioiTinh.NAM, LocalDate.parse("26/11/2000", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.THIET_KE_VIEN, 10000, 20, 25000, c1);
        NhanVien a8 = new ThietKeVien("Ng vv h", GioiTinh.NAM, LocalDate.parse("26/11/1990", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.THIET_KE_VIEN, 10000, 20, 25000, c1);
        NhanVien a9 = new ThietKeVien("Ng vv i", GioiTinh.NAM, LocalDate.parse("12/09/1996", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.THIET_KE_VIEN, 10000, 20, 25000, c1);
        NhanVien a10 = new ThietKeVien("Ng vv k", GioiTinh.NAM, LocalDate.parse("26/09/2000", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.THIET_KE_VIEN, 10000, 20, 25000, c1);
        NhanVien a6 = new ThietKeVien("Ng vv l", GioiTinh.NAM, LocalDate.parse("26/11/2000", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), "afdd@", ChucVu.THIET_KE_VIEN, 10000, 20, 25000, c1);

        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        quanLyNhanVien.themNhanVien(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10);
        DuAn b1 = new DuAn("Du an 1", LocalDate.parse("26/11/2022", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), LocalDate.parse("26/12/2005", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), 500, a1, a3, a2, a4);
        DuAn b2 = new DuAn("Du an 2", LocalDate.parse("26/10/1990", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), LocalDate.parse("26/05/1995", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), 500, a1, a3, a2, a4);
        DuAn b3 = new DuAn("Du an 3", LocalDate.parse("26/10/1890", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), LocalDate.parse("26/05/1995", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), 500, a1, a3, a2, a4);

        QuanLyDuAn quanLyDuAn = new QuanLyDuAn();
        quanLyDuAn.themDuAn(b1, b2, b3);


        ThanNhan d1 = new ThanNhan("Vo vi a", LocalDate.parse("26/11/2022", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), GioiTinh.KHAC, "Ba con", a1);
        ThanNhan d2 = new ThanNhan("Vo vi b", LocalDate.parse("26/11/2022", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), GioiTinh.KHAC, "Ba con", a2);
        ThanNhan d3 = new ThanNhan("Vo vi c", LocalDate.parse("26/11/2022", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), GioiTinh.KHAC, "Ba con", a3);
        ThanNhan d4 = new ThanNhan("Vo vi d", LocalDate.parse("26/11/2022", DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), GioiTinh.KHAC, "Ba con", a4);

        int flag = 0;
        do {
            flag = 0;
            System.out.print("\nMENU\n1. Quan ly nhan vien\n2. Quan ly du an\n3. Quan ly phong ban\n4. Thoat!\nChon chuc nang: ");
            switch (CAUHINH.SC.nextLine()) {
                case "1": {
                    int flag1 = 0;
                    do {
                        System.out.print("=== QUAN LY NHAN VIEN ===\n");
                        flag1 = 0;
                        System.out.print("1. Them nhan vien\n2. Xoa nhan vien\n3. Sua thong tin nhan vien\n4. Tim kiem\n5. Tinh luong\n6. Xem thong tin nhan vien\n7. Xem danh sach du an\n"
                                + "8. Chinh sua than nhan\n9. Xem nhan than\n"
                                + "10. Danh sach nhan vien\n11. Quay lai MENU\nChon chuc nang: ");
                        switch (CAUHINH.SC.nextLine()) {
                            case "1": {
                                System.out.print("=== THEM NHAN VIEN ===\n");
                                quanLyNhanVien.nhapNhanVien(quanLyPhongBan);
                                break;
                            }
                            case "2": {
                                System.out.print("=== XOA NHAN VIEN ===\nNhap ma nhan vien: ");
                                quanLyNhanVien.xoaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                                break;
                            }
                            case "3": {
                                System.out.print("=== SUA THONG TIN ===\n");
                                quanLyNhanVien.suaThongTin();
                                break;

                            }
                            case "4": {
                                System.out.print("=== TIM NHAN VIEN ===\n");
                                quanLyNhanVien.timNhanVien();
                                break;
                            }

                            case "5": {
                                System.out.print("=== TINH LUONG ===\n");
                                System.out.print("Nhap vao ma cua nhan vien muon tinh luong: ");
                                NhanVien a = quanLyNhanVien.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                                if (a != null) {
                                    System.out.printf("Luong cua nhan vien: %.3f\n", a.tinhLuong());
                                }
                                break;
                            }
                            case "6": {
                                System.out.print("=== XEM THONG TIN ===\n");
                                System.out.print("Nhap vao ma cua nhan vien muon xem thong tin: ");
                                NhanVien a = quanLyNhanVien.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                                if (a != null) {
                                    a.hienThi();
                                }
                                break;
                            }
                            case "7": {
                                System.out.print("=== Xem cac du an cua mot nhan vien ===\nNhap ma cua nhan vien can xem: ");
                                NhanVien a = quanLyNhanVien.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                                if (a != null) {
                                    a.xuatdsDuAn();
                                }

                                break;
                            }
                            case "8": {
                                System.out.print("=== CHINH SUA THAN NHAN ===\nNhap ma cua nhan vien can sua: ");
                                quanLyNhanVien.chinhSuaThanNhan();
                                break;
                            }
                            case "9": {
                                System.out.print("=== XEM NHAN THAN ===\nNhap ma cua nhan vien can xem: ");
                                NhanVien a = quanLyNhanVien.timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                                if (a != null) {
                                    System.out.print("Danh sach nhan than: \n");
                                    a.xuatDanhSachThanNhan();
                                }
                                break;
                            }
                            case "10": {
                                System.out.print("=== XEM DANH SACH NHAN VIEN ===\n");
                                quanLyNhanVien.xuatDsNhanVien();
                                break;
                            }
                            case "11": {
                                flag1 = 1;
                                System.out.print("Quay lai menu\n");
                                break;
                            }
                            default: {
                                System.out.print("Khong co chuc nang ma ban chon! Chon lai!\n");
                                break;
                            }
                        }
                    } while (flag1 == 0);
                    break;
                }

                case "2": {

                    int flag1 = 0;
                    do {
                        System.out.print("=== QUAN LY DU AN ===\n");
                        System.out.print("1. Xem toan bo du an\n2. Them du an\n3. Xoa du an\n4. Sua du an\n5. Tim du an\n6. Sap xep du an\n7. Chinh sua thanh vien trong du an\n"
                                + "8. Quay lai menu\nChon chuc nang: ");
                        switch (CAUHINH.SC.nextLine()) {
                            case "1": {
                                System.out.print("=== DANH SACH DU AN ===\n");
                                quanLyDuAn.hienThiDS();
                                break;
                            }
                            case "2": {
                                System.out.print("=== THEM DU AN ===\n");
                                quanLyDuAn.themDuAn(quanLyNhanVien);
                                System.out.print("Da them thanh cong\n");
                                break;
                            }
                            case "3": {
                                System.out.print("=== XOA DU AN ===\nNhap ma du an can xoa: ");
                                quanLyDuAn.xoaDuAn(Integer.parseInt(CAUHINH.SC.nextLine()));
                                break;
                            }
                            case "4": {
                                System.out.print("=== SUA DU AN ===\nNhap ma cua du an can sua: ");
                                DuAn a = quanLyDuAn.timDuAn(Integer.parseInt(CAUHINH.SC.nextLine()));
                                if (a != null) {
                                    quanLyDuAn.suaDuAn(a);
                                    break;
                                }
                            }
                            case "5": {
                                System.out.print("=== TIM DU AN ===\n");
                                quanLyDuAn.timDuAn();
                                break;
                            }

                            case "6": {
                                System.out.print("=== SAP XEP DU AN ===\n");
                                quanLyDuAn.sapXep();
                                break;
                            }
                            case "7": {
                                System.out.print("=== SUA THANH VIEN ===\n");
                                quanLyDuAn.suaDsNhanVien(quanLyNhanVien);
                                break;
                            }
                            case "8": {
                                flag1 = 1;
                                System.out.print("Quay tro lai menu\n");
                                break;
                            }
                            default: {
                                System.out.print("Khong co chuc nang ma ban chon! Chon lai!\n");
                            }
                        }
                    } while (flag1 == 0);
                    break;
                }

                case "3": {

                    int flag1 = 0;
                    do {
                        System.out.print("=== QUAN LY PHONG BAN ===\n");
                        System.out.print("1. Danh sach phong ban\n2. Them phong ban\n3. Xoa phong ban\n4. Tim phong ban\n5. Chinh sua quan ly\n6. Them nhan vien vao bang\n7. Xoa nhan vien khoi bang\n"
                                + "8. Danh sach nhan vien trong bang\n9. Quay lai menu\nChon chuc nang: ");
                        switch (CAUHINH.SC.nextLine()) {
                            case "1": {
                                System.out.print("=== DANH SACH PHONG BAN ===\n");
                                quanLyPhongBan.hienThiDSPhongBan();
                                break;
                            }
                            case "2": {
                                System.out.print("=== THEM PHONG BAN ===\n");
                                quanLyPhongBan.themPhongBan(quanLyNhanVien);
                                break;
                            }
                            case "3": {
                                System.out.print("=== XOA PHONG BAN ===\nNhap ten ban muon xoa: ");
                                quanLyPhongBan.xoaPhongBan(CAUHINH.SC.nextLine(), quanLyNhanVien);
                                break;
                            }
                            case "4": {
                                System.out.print("=== TIM PHONG BAN ===\nNhap ten ban can tim: ");
                                PhongBan pb = quanLyPhongBan.timPhongBan(CAUHINH.SC.nextLine());
                                pb.hienThi();
                                break;
                            }
                            case "5": {
                                System.out.print("=== CHINH SUA QUAN LY ===\n");
                                quanLyPhongBan.chinhSuaQuanLy(quanLyNhanVien);
                                break;
                            }
                            case "6": {
                                System.out.print("=== THEM NHAN VIEN VAO BANG ===\nNhap ten ban can them thanh vien: ");
                                PhongBan pb = quanLyPhongBan.timPhongBan(CAUHINH.SC.nextLine());
                                pb.themNhanVien(quanLyNhanVien);
                                
                                break;
                            }
                            case "7": {
                                System.out.print("=== XOA NHAN VIEN RA KHOI BANG ===\nNhap ten ban can xoa thanh vien: ");
                                PhongBan pb = quanLyPhongBan.timPhongBan(CAUHINH.SC.nextLine());
                                pb.xoaNhanVien(quanLyNhanVien, quanLyPhongBan);
                                break;
                            }
                            case "8": {
                                System.out.print("=== DANH SACH NHAN VIEN TRONG BAN ===\nNhap ten ban can xem danh sach: ");
                                String kw = CAUHINH.SC.nextLine();
                                PhongBan kq = quanLyPhongBan.timPhongBan(kw);
                                if (kq != null) {
                                    kq.hienThi();
                                }

                                break;
                            }
                            case "9": {
                                flag1 = 1;
                                System.out.print("Quay lai menu\n");
                                break;
                            }
                            default: {
                                System.out.print("Khong co phuong thuc ban chon! Hay chon lai!\n");
                            }
                        }
                    } while (flag1 == 0);
                    break;
                }
                case "4": {
                    flag = 1;
                    System.out.print("Thoat chuong trinh\n");
                    break;
                }
                default: {
                    System.out.print("Khong co chuc nang ma ban chon! Chon lai!\n");
                    break;
                }
            }
        } while (flag == 0);

    }
}
