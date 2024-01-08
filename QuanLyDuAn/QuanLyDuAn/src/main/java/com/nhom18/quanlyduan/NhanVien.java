package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class NhanVien extends ThongTinConNguoi {

    private static int dem = 0;
    private int maNhanVien = ++dem;
    private String email;
    private ChucVu chucVu;
    protected double luongCB;
    protected double heSoLuong;
    private PhongBan phongBan = null;
    private List<PhongBan> dsBanQL = new ArrayList<>();
    private List<ThanNhan> dsThanNhan = new ArrayList<>();
    private List<DuAn> dsDuAn = new ArrayList<>();
    private List<DuAn> chuNhiemDuAn = new ArrayList<>();

    public NhanVien() {

    }

    public void hienThiTtCoBan() {
        System.out.printf("Ma nhan vien: %d\nTen nhan vien: %s\n", this.getMaNhanVien(), this.hoTen);
    }

    public NhanVien(String hoTen, GioiTinh gioiTinh, LocalDate d, String email, ChucVu chucVu) {
        super(hoTen, gioiTinh, d);
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = d;
        this.email = email;
        this.chucVu = chucVu;
    }

    public abstract double tinhLuong();

    @Override
    public void nhapttCoBan() {
        super.nhapttCoBan();
        System.out.print("Nhap muc luong co ban: ");
        this.setLuongCB(Double.parseDouble(CAUHINH.SC.nextLine()));
        System.out.print("Nhap he so luong cua nhan vien: ");
        this.setHeSoLuong(Double.parseDouble(CAUHINH.SC.nextLine()));
        System.out.print("Nhap dia chi email: ");
        this.setEmail(CAUHINH.SC.nextLine());
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.printf("ID: %s\nEmail: %s\nChuc vu: %s\nBan: %s\nLuong Nhan Vien: %.1f\n", this.getMaNhanVien(), this.getEmail(), this.getChucVu(), this.phongBan.getTenPhongBan(), this.tinhLuong());
    }

    public void xuatdsDuAn() {
        this.hienThiTtCoBan();
        int so = 1;
        if (getDsDuAn().isEmpty()) {
            System.out.print("Nhan vien chua tham gia du an nao!\n");
            return;
        }
        for (DuAn duAn : this.getDsDuAn()) {
            System.out.printf("Du an %d:\nMa du an: %d\nTen du an: %s\n", so++, duAn.getMaDuAn(), duAn.getTenDuAn());
        }
    }

    public void xuatDanhSachThanNhan() {
        this.hienThiTtCoBan();
        if (getDsThanNhan().isEmpty()) {
            System.out.print("Khong co thong tin than nhan cua nhan vien!\n");
            return;
        }
        this.getDsThanNhan().forEach(h -> h.hienThi());
    }

    public void setDuAn(DuAn duAn) {
        if (this.getDsDuAn().size() >= 3) {
            System.out.print("Nhan vien da tham gia du du an!\n");
            return;
        }
        this.getDsDuAn().add(duAn);
    }

    public void xoaDsDuAn(DuAn duAn) {
        this.getDsDuAn().removeIf(da -> da == duAn);
    }

    public void setChuNhiem(DuAn duAn) {
        this.getChuNhiemDuAn().add(duAn);
    }

    public void xoaChuNhiem(DuAn duAn) {
        this.getChuNhiemDuAn().remove(duAn);
    }

    public void themThanNhan() {
        ThanNhan a = new ThanNhan();
        a.nhapttCoBan();
        this.getDsThanNhan().add(a);
        a.setQhNV(this);
    }

    public void xoaThanNhan() {
        System.out.print("Nhap ten cua than nhan can xoa: ");
        this.getDsThanNhan().forEach(tN -> {
            if (tN.hoTen == CAUHINH.SC.nextLine()) {
                this.getDsThanNhan().remove(tN);
                tN.xoaMoiQH();
                tN.xoaQhNV();
            }
        });
    }

    public void themThanNhan(ThanNhan... a) {
        this.getDsThanNhan().addAll(Arrays.asList(a));
        for (ThanNhan tn : a) {
            tn.setQhNV(this);
        }
    }

    public void chinhSuaThanNhan() {
        System.out.print("=== DANH SACH THAN NHAN ===\n");
        this.xuatDanhSachThanNhan();
        int flag = 0;
        do {
            System.out.print("1. Them nhan than\n2. Xoa nhan than\n3. Hoan thanh chinh sua\nChon phuong thuc: ");
            switch (Integer.parseInt(CAUHINH.SC.nextLine())) {
                case 1: {
                    System.out.print(">Them nhan then\n");
                    this.themThanNhan();
                    break;
                }
                case 2: {
                    System.out.print(">Xoa nhan than\n");
                    this.xoaThanNhan();
                    break;
                }
                case 3: {
                    flag = 1;
                    System.out.print("Hoan thanh chinh sua\n");
                    break;
                }
                default: {
                    System.out.print("Khong co chuc nang ban chon. Chon lai!\n");
                }
            }
        } while (flag == 1);
    }

    public void setDsBanQL(PhongBan pb) {
        if (dsBanQL.size() == 2) {
            System.out.print("Nhan vien da quan ly du 2 ban\n");
            return;
        }
        dsBanQL.add(pb);
    }

    public void xoaDsBanQL(PhongBan pB) {
        for (PhongBan a : dsBanQL) {
            if (a == pB) {
                dsBanQL.remove(pB);
                System.out.print("Nhan vien da khong con quan ly ban nay\n");
                return;
            }
        }
        System.out.print("Nhan vien khong quan ly ban nay\n");
    }

    public void setError(int error) {
    }

    public int getError() {
        return 0;
    }

    public double getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PhongBan getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(PhongBan ban) {
        this.phongBan = ban;
    }

    /**
     * @return the maNhanVien
     */
    public int getMaNhanVien() {
        return maNhanVien;
    }

    /**
     * @param maNhanVien the maNhanVien to set
     */
    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    /**
     * @return the chucVu
     */
    public ChucVu getChucVu() {
        return chucVu;
    }

    /**
     * @param chucVu the chucVu to set
     */
    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    /**
     * @return the dem
     */
    public static int getDem() {
        return dem;
    }

    /**
     * @param aDem the dem to set
     */
    public static void setDem(int aDem) {
        dem = aDem;
    }

    /**
     * @return the dsThanNhan
     */
    public List<ThanNhan> getDsThanNhan() {
        return dsThanNhan;
    }

    /**
     * @param dsThanNhan the dsThanNhan to set
     */
    public void setDsThanNhan(List<ThanNhan> dsThanNhan) {
        this.dsThanNhan = dsThanNhan;
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

    /**
     * @return the chuNhiemDuAn
     */
    public List<DuAn> getChuNhiemDuAn() {
        return chuNhiemDuAn;
    }

    /**
     * @param chuNhiemDuAn the chuNhiemDuAn to set
     */
    public void setChuNhiemDuAn(List<DuAn> chuNhiemDuAn) {
        this.chuNhiemDuAn = chuNhiemDuAn;
    }

    /**
     * @return the dsBanQL
     */
    public List<PhongBan> getDsBanQL() {
        return dsBanQL;
    }

    /**
     * @param dsBanQL the dsBanQL to set
     */
    public void setDsBanQL(List<PhongBan> dsBanQL) {
        this.dsBanQL = dsBanQL;
    }

}
