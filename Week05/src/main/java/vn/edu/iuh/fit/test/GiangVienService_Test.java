package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.services.GiangVienService;

public class GiangVienService_Test {
    public static void main(String[] args) {
        GiangVien giangVien1 = new GiangVien("GV0001","Nguyen Bui Thanh Hoa","Linh vuc ve khoa hoc co ban", "0837699806");
        GiangVien giangVien2 = new GiangVien("GV0002","Ho Huynh Thuy An","Linh vuc ve khoa hoc co ban", "0837699806");
        GiangVien giangVien3 = new GiangVien("GV0003","Le Hoang Hoa","Linh vuc ve khoa hoc co ban", "0837699806");
        GiangVien giangVien4 = new GiangVien("GV0004","Tran Bao Chau","Linh vuc ve khoa hoc co ban", "0837699806");
        GiangVien giangVien5 = new GiangVien("GV0005","Nguyen Le Giao","Linh vuc ve khoa hoc co ban", "0837699806");
        GiangVien giangVien6 = new GiangVien("GV0006","Hoang Thi Ngoc Anh","Linh vuc ve khoa hoc co ban", "0837699806");

        GiangVienService.insertGiangVien(giangVien1);
        GiangVienService.insertGiangVien(giangVien2);
        GiangVienService.insertGiangVien(giangVien3);
        GiangVienService.insertGiangVien(giangVien4);
        GiangVienService.insertGiangVien(giangVien5);
        GiangVienService.insertGiangVien(giangVien6);

        GiangVienService.getGiangVien().forEach(System.out::println);
    }
}
