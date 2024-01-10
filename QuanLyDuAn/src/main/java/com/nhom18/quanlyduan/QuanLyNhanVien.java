package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyNhanVien {

    private List<NhanVien> dsNhanVien = new ArrayList<>();

    public void themNhanVien(NhanVien... a) {
        this.dsNhanVien.addAll(Arrays.asList(a));
    }

    public void xoaNhanVien(int kw) {
        NhanVien a = this.timTheoMaNhanVien(kw);
        if (a != null) {
            dsNhanVien.remove(a);
            System.out.print("Da xoa nhan vien!\n");
        }

    }

    public void nhapNhanVien(QuanLyPhongBan ql) {
        int flag = 0;
        do {
            flag = 0;
            System.out.print("===Chuc vu:\n1. Nhan vien thuong\n2. Lap trinh vien\n3. Thiet ke vien\n4. Kiem thu vien\n Chon chuc vu: ");
            switch (CAUHINH.SC.nextLine()) {
                case "1": {
                    NhanVien a = new NhanVienThuong();
                    a.setChucVu(ChucVu.NHAN_VIEN_THUONG);
                    a.nhapttCoBan();
                    a.setPhongBan(ql);
                    dsNhanVien.add(a);
                    break;
                }
                case "2": {
                    NhanVien a = new LapTrinhVien();
                    a.setChucVu(ChucVu.LAP_TRINH_VIEN);
                    a.nhapttCoBan();
                    a.setPhongBan(ql);
                    dsNhanVien.add(a);
                    break;
                }
                case "3": {
                    NhanVien a = new ThietKeVien();
                    a.setChucVu(ChucVu.THIET_KE_VIEN);
                    a.nhapttCoBan();
                    a.setPhongBan(ql);
                    dsNhanVien.add(a);
                    break;
                }

                case "4": {
                    NhanVien a = new KiemThuVien();
                    a.setChucVu(ChucVu.KIEM_THU_VIEN);
                    a.nhapttCoBan();
                    a.setPhongBan(ql);
                    dsNhanVien.add(a);
                    break;
                }
                default: {
                    System.out.print("Khong co chuc vu ma ban chon! Chon lai!\n");
                    flag = 1;
                    break;
                }
            }
        } while (flag == 1);

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

    public void timNhanVien() {
        System.out.print("1. Tim theo ma\n2. Tim theo ten nhan vien\n3. Tim theo phong ban\n4. Tim theo ngay sinh\n"
                + "5. Tim theo tuoi\n6. Tim theo do tuoi\nChon phuong thuc tim: ");

        switch (CAUHINH.SC.nextLine()) {
            case "1": {
                System.out.print(">Tim bang ma\nNhap ma cua nhan vien: ");
                NhanVien a = timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
                if (a != null) {
                    a.hienThi();
                }
                break;
            }
            case "2": {
                System.out.print(">Tim bang ten\nNhap ten nhan vien: ");
                String ten = CAUHINH.SC.nextLine();
                timTheoTen(ten);
                break;
            }
            case "3": {
                System.out.print(">Tim theo phong ban\nNhap ten cua phong ban: ");
                String ban = CAUHINH.SC.nextLine();
                timTheoPhongBan(ban);
                break;
            }
            case "4": {
                System.out.print(">Tim theo ngay sinh\nNhap ngay sinh:\n");
                LocalDate ngay = CAUHINH.NHAP_NGAY_THANG_NAM();
                timTheoNgaySinh(ngay);
                break;
            }
            case "5": {
                System.out.print(">Tim theo tuoi\nNhap tuoi cua nhan vien: ");
                int tuoi = Integer.parseInt(CAUHINH.SC.nextLine());
                timTheoTuoi(tuoi);
                break;
            }
            case "6": {
                System.out.print(">Tim theo do tuoi\nNhap muc tuoi tu: ");
                int tuoi1 = Integer.parseInt(CAUHINH.SC.nextLine());
                System.out.print("Toi: ");
                int tuoi2 = Integer.parseInt(CAUHINH.SC.nextLine());
                timTheoTuoi(tuoi1, tuoi2);
                break;
            }
            default: {
                System.out.print("Khong co phuong thuc ma ban chon! Chon lai!\nChon phuong thuc tim: ");
            }
        }
    }

    public void timTheoTen(String kw) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getHoTen().contains(kw)).collect(Collectors.toList());
        if (kq.isEmpty()) {
            System.out.print("Khong tim thay nhan vien phu hop!\n");
            return;
        }
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoPhongBan(String kw) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getPhongBan().getTenPhongBan().contains(kw))
                        .collect(Collectors.toList());
        if (kq.isEmpty()) {
            System.out.print("Khong tim thay nhan vien phu hop!\n");
            return;
        }
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoNgaySinh(LocalDate t) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> h.getNgaySinh().equals(t)).collect(Collectors.toList());
        if (kq.isEmpty()) {
            System.out.print("Khong tim thay nhan vien phu hop!\n");
            return;
        }
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoTuoi(int tuoi) {
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h -> -h.getNgaySinh().getYear() + LocalDate.now().getYear() == tuoi)
                        .collect(Collectors.toList());
        if (kq.isEmpty()) {
            System.out.print("Khong tim thay nhan vien phu hop!\n");
            return;
        }
        kq.forEach(h -> h.hienThi());
    }

    public void timTheoTuoi(int tuoiDuoi, int tuoiTren) {
        int y = LocalDate.now().getYear();
        List<NhanVien> kq
                = this.dsNhanVien.stream().filter(h
                        -> -h.getNgaySinh().getYear() + y >= tuoiDuoi && -h.getNgaySinh().getYear() + y <= tuoiTren)
                        .collect(Collectors.toList());
        if (kq.isEmpty()) {
            System.out.print("Khong tim thay nhan vien phu hop!\n");
            return;
        }
        kq.forEach(h -> h.hienThi());
    }

    public NhanVien timTheoMaNhanVien(int id) {
        NhanVien nv = this.dsNhanVien.stream().filter(h -> h.getMaNhanVien() == id).findFirst().orElse(null);
        if (nv != null) {
            return nv;
        }
        System.out.print("Khong tim thay nhan vien\n");
        return null;
    }

    public void xuatDsNhanVien() {
        if (dsNhanVien.isEmpty()) {
            System.out.print("Khong co nhan vien!\n");
            return;
        }
        for (NhanVien nv : dsNhanVien) {
            nv.hienThi();
        }
    }

    public void chinhSuaThanNhan() {
        NhanVien a = timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
        if (a != null) {
            a.chinhSuaThanNhan();
        }
    }

    public void suaThongTin() {
        System.out.print("Nhap ma nhan vien can sua: ");
        NhanVien a = timTheoMaNhanVien(Integer.parseInt(CAUHINH.SC.nextLine()));
        if (a != null) {
            int flag = 0;
            System.out.print("Thong tin cua nhan vien: \n");
            a.hienThi();
            do {
                System.out.print("1. Sua ten\n2. Sua ngay thang nam sinh\n3. Sua gioi tinh\n4. Sua luong\n5. Hoan thanh sua\nChon thong tin can sua: ");
                switch (CAUHINH.SC.nextLine()) {
                    case "1": {
                        System.out.print(">Sua ten\nNhap ten moi: ");
                        a.setHoTen();
                        break;
                    }
                    case "2": {
                        System.out.print(">Sua ngay sinh\n");
                        a.setNgaySinh();
                        break;
                    }
                    case "3": {
                        System.out.print(">Sua gioi tinh\n");
                        a.setGioiTinh();
                        break;
                    }
                    case "4": {
                        System.out.print(">Sua luong\nNhap luong co ban: ");
                        a.setLuongCB(Double.parseDouble(CAUHINH.SC.nextLine()));
                        System.out.print("Nhap he so moi: ");
                        a.setHeSoLuong(Double.parseDouble(CAUHINH.SC.nextLine()));
                        break;
                    }
                    case "5":{
                        flag = 1;
                        System.out.print("Hoan thanh sua\n");
                        break;
                    }
                    default: {
                        System.out.print("Khong co chuc nang! Chon lai!\n");
                        break;
                    }

                }
            } while (flag == 0);
        }
    }
}
