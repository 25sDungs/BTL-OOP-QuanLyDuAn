/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class main {

    public static void main(String arg[]) {
        int chon = 0;
        NhanVien a1 = new KiemThuVien("Tran Van Vo", GioiTinh.NAM,
                LocalDate.of(2002, 6, 1), "VoVanT@gmail.com");
        NhanVien a2 = new NhanVienThuong("Day La Ma Nhan Vien 2", GioiTinh.NAM,
                LocalDate.of(1999, 6, 1), "VoVanT@gmail.com");
        NhanVien a3 = new LapTrinhVien("Gund ihC", GioiTinh.NAM,
                LocalDate.of(2004, 5, 10), "VoVanT@gmail.com");
        PhongBan b = new PhongBan("Van Nghe Cua Khoa IT");
        PhongBan n = new PhongBan("Nhat Ban");
        PhongBan h = new PhongBan("Han Quoc");
        ThanNhan c = new ThanNhan("Me nhan vien", LocalDate.of(1980, 12, 21),
                GioiTinh.NU, "Me-con");
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        qlnv.themNhanVien(a1, a2, a3);
        a1.setPhongBan(b);
        a2.setPhongBan(b);
        a3.setPhongBan(n);
        QuanLyPhongBan qlpb = new QuanLyPhongBan();
        qlpb.themPhongBan(b, h, n);
        qlpb.hienThiDSPhongBan();
        qlpb.xoaPhongBan("IT");
//        System.out.print("""
//                         ===============MENU===============
//                         1.Quan Ly Du An
//                         2.Quan Ly Nhan Vien
//                         3.Tim Kiem Du An
//                         4.Tim Kiem Nhan Vien
//                         
//                         999.Thoat
//                         """);
//        Xuat danh sach than nhan o ql nhan vien?
//        Tinh luong cho tat ca nhan vien, cho tat ca lap trinh vien(...) + cụ thể
//        ben trong qlda còn xem ds nhân viên tương tự qlnv
        switch (chon) {
            case 1 -> {

            }
            case 2 -> {

            }
            default -> {
            }
        }
    }
}
