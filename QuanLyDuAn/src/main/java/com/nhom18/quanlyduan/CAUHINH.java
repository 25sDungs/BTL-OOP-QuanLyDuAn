/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom18.quanlyduan;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class CAUHINH {

    public static final String PATTERN = "dd/MM/yyy";
    public static final Scanner SC = new Scanner(System.in);

    public static int NHAP_NGAY() {
        int ngay = 0, flag = 0;
        System.out.print("Nhap ngay: ");
        do {
            try {
                flag = 0;
                ngay = Integer.parseInt(CAUHINH.SC.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen cho ngay.");
                flag = 1;
            }
        } while (flag == 1);
        return ngay;
    }

    public static int NHAP_THANG() {
        int thang = 0, flag = 0;
        System.out.print("Nhap thang: ");
        do {
            try {
                flag = 0;
                thang = Integer.parseInt(CAUHINH.SC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen cho thang.");
                flag = 1;
            }
        } while (flag == 1);
        return thang;
    }

    public static int NHAP_NAM() {
        int nam = 0, flag = 0;
        System.out.print("Nhap nam: ");
        do {
            try {
                flag = 0;
                nam = Integer.parseInt(CAUHINH.SC.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen cho nam.");
                flag = 1;
            }
        } while (flag == 1);
        return nam;
    }

    public static LocalDate NHAP_NGAY_THANG_NAM() {
        int flag = 0;
        int a = NHAP_NGAY();
        int b = NHAP_THANG();
        int c = NHAP_NAM();
        LocalDate HT = LocalDate.now();
        
        while(c > HT.getYear()){
            System.out.printf("Nam hien tai la: %d\nVui long nhap lai: \n", HT.getYear());
            c = NHAP_NAM();
        }
        
        do {
            flag = 0;

            switch (b) {
                case 2: {
                    if ((c % 4 == 0 && c % 100 != 0) || (c % 400 == 0)) {
                        while (a < 1 || a > 29) {
                            System.out.print("Nhap sai ngay! Nhap lai ngay: ");
                            a = NHAP_NGAY();
                        }
                    } else {
                        while (a < 1 || a > 28) {
                            System.out.print("Nhap sai ngay! Nhap lai ngay: ");
                            a = NHAP_NGAY();
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
                        a = NHAP_NGAY();
                    }
                    break;
                }
                case 4:
                case 6:
                case 9:
                case 11: {
                    while (a < 1 || a > 30) {
                        System.out.print("Nhap sai ngay! Nhap lai ngay: ");
                        a = NHAP_NGAY();
                    }
                    break;
                }
                default: {
                    flag = 1;
                    System.out.print("Nhap thang khong dung!\nNhap lai thang sinh: ");
                    b = NHAP_THANG();
                }
            }
        } while (flag == 1);
        return LocalDate.parse(String.format("%02d, %02d, %04d", a, b, c), DateTimeFormatter.ofPattern(CAUHINH.PATTERN));
    }
}
