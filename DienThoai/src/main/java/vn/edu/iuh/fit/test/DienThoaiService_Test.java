package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entities.DienThoai;
import vn.edu.iuh.fit.entities.NhaCungCap;
import vn.edu.iuh.fit.services.DienThoaiService;
import vn.edu.iuh.fit.services.NhaCungCapService;

public class DienThoaiService_Test {
    public static void main(String[] args) {
        NhaCungCap nhaCungCap1 = NhaCungCapService.getAllNhaCungCap().get(0);
        NhaCungCap nhaCungCap2= NhaCungCapService.getAllNhaCungCap().get(1);

        DienThoai dienThoai1 = new DienThoai("DT01","SamSung A51",2020,"Android",nhaCungCap1);
        DienThoai dienThoai2 = new DienThoai("DT02","Iphone 16",2024,"IOS",nhaCungCap2);

        DienThoaiService.insertDienThoai(dienThoai1);
        DienThoaiService.insertDienThoai(dienThoai2);

        DienThoaiService.getAllDienThoai().forEach(System.out::println);

    }
}
