package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class ThongTinConNguoi {

    protected String hoTen;
    protected LocalDate ngaySinh;
    protected GioiTinh gioiTinh;
    
    public ThongTinConNguoi(){
        
    }
    
    public ThongTinConNguoi(String hoTen, GioiTinh gioiTinh,LocalDate ngaySinh){
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public GioiTinh getGioiTinh() {
        return this.gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return this.ngaySinh;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void hienThi() {
        System.out.printf("Ho Ten: %s\nNgay Sinh: %s\nGioi Tinh: %s\n",
                this.hoTen, this.ngaySinh.format(DateTimeFormatter.ofPattern(CAUHINH.PATTERN)), this.gioiTinh);
    }

    public void setHoTen() {
        System.out.print("Nhap thong tin Ho Ten: ");
        this.setHoTen(CAUHINH.SC.nextLine());
        this.hoTen = this.getHoTen().replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ").trim().toLowerCase();
        this.kiemSoatChinhta(hoTen);
    }

    public void setNgaySinh() {
        int flag = 0;
        System.out.print("Nhap ngay sinh: ");
        int a = Integer.parseInt(CAUHINH.SC.nextLine());
        System.out.print("Nhap thang sinh: ");
        int b = Integer.parseInt(CAUHINH.SC.nextLine());
        System.out.print("Nhap nam sinh: ");
        int c = Integer.parseInt(CAUHINH.SC.nextLine());
        do {
            flag = 0;

            switch (b) {
                case 2: {
                    if ((c % 4 == 0 && c % 100 != 0) || (c % 400 == 0)) {
                        while (a < 1 || a > 29) {
                            System.out.print("Nhap sai ngay! Nhap lai ngay: ");
                            a = Integer.parseInt(CAUHINH.SC.nextLine());
                        }
                    } else {
                        while (a < 1 || a > 28) {
                            System.out.print("Nhap sai ngay! Nhap lai ngay: ");
                            a = Integer.parseInt(CAUHINH.SC.nextLine());
                        }
                    }
                }

                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: {
                    while (a < 1 || a > 31) {
                        System.out.print("Nhap sai ngay! Nhap lai ngay: ");
                        a = Integer.parseInt(CAUHINH.SC.nextLine());
                    }
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    while (a < 1 || a > 30) {
                        System.out.print("Nhap sai ngay! Nhap lai ngay: ");
                        a = Integer.parseInt(CAUHINH.SC.nextLine());
                    }
                    break;
                }
                default: {
                    flag = 1;
                    System.out.print("Nhap thang khong dung!\nNhap lai thang sinh: ");
                    b = Integer.parseInt(CAUHINH.SC.nextLine());
                }
            }
        } while (flag == 1);
        this.setNgaySinh(LocalDate.of(c, b, a));
    }
    
    public void setGioiTinh(){
        int flag = 0;
         do {
             flag = 0;
            System.out.print("Gioi Tinh: \n1. NAM\n2. NU\n3. KHAC\nChon gioi tinh: ");
            switch (Integer.parseInt(CAUHINH.SC.nextLine())) {
                case 1: {
                    this.setGioiTinh(GioiTinh.NAM);
                    break;
                }
                case 2: {
                    this.setGioiTinh(GioiTinh.NU);
                    break;
                }
                case 3: {
                    this.setGioiTinh(GioiTinh.KHAC);
                    break;
                }
                default: {
                    flag = 1;
                    System.out.print("Chon sai!\n");
                    break;
                }
            }
        } while (flag == 1);
    }

    public void nhapttCoBan() {
          this.setHoTen();
          this.setNgaySinh();
          this.setGioiTinh();
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void kiemSoatChinhta(String a) {
        String[] words = a.split("\\s");
        StringBuilder sua = new StringBuilder();
        for (String word : words) {
            sua = sua.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        this.hoTen = sua.toString();
    }
}
