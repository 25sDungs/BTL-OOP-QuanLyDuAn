package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyNhanVien {

    private List<NhanVien> dsNhanVien = new ArrayList<>();

    public void themNhanVien(NhanVien... a) {
        this.dsNhanVien.addAll(Arrays.asList(a));
    }

    public double tinhLuongChoNV() {
        double t = 0;
        for (NhanVien x : this.dsNhanVien) {
            t += x.tinhLuong();
        }
        return t;
    }

    public double tinhLuongChoNV(String classPath) {        //KHONG ON ROIIIIIIIIIIII
        double t = 0;
        for (NhanVien x : this.dsNhanVien) {
            if (x instanceof LapTrinhVien) {
                t += x.tinhLuong();
            }
        }
        return t;
    }

    public void timTheoTen(String kw) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getHoTen().contains(kw)).collect(Collectors.toList());
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoPhongBan(String kw) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getPhongBan().getTenPhongBan().contains(kw))
                        .collect(Collectors.toList());
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoNgaySinh(LocalDate t) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getNgaySinh().equals(t)).collect(Collectors.toList());
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoTuoi(int tuoi) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> -h.getNgaySinh().getYear() + LocalDate.now().getYear() == tuoi)
                        .collect(Collectors.toList());
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoTuoi(int tuoiDuoi, int tuoiTren) {
        int y = LocalDate.now().getYear();
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h
                        -> -h.getNgaySinh().getYear() + y >= tuoiDuoi && -h.getNgaySinh().getYear() + y <= tuoiTren)
                        .collect(Collectors.toList());
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoMaNhanVien(int id) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getMaNhanVien() == id).collect(Collectors.toList());
        kq.forEach(h -> h.hienThi());
    }

    public void dsNhanThanTheoID(int id) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getMaNhanVien() == id).collect(Collectors.toList());
        kq.forEach(h -> h.xuatDanhSachThanNhan());
    }
}
