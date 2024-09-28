package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entitties.DanhMuc;
import vn.edu.iuh.fit.services.DanhMucService;

public class DanhMucService_Test {
    public static void main(String[] args) {
        DanhMuc danhMuc1 = new DanhMuc("DM01","Danh Muc 1","Le Van Khanh","Chu thich");
        DanhMuc danhMuc2 = new DanhMuc("DM02","Danh Muc 2","Le Van Nam","Chu thich");
        DanhMuc danhMuc3 = new DanhMuc("DM03","Danh Muc 3","Le Khanh Duy","Chu thich");
        DanhMuc danhMuc4 = new DanhMuc("DM04","Danh Muc 4","Le Van Chin","Chu thich");

        DanhMucService.insertDanhMuc(danhMuc1);
        DanhMucService.insertDanhMuc(danhMuc2);
        DanhMucService.insertDanhMuc(danhMuc3);
        DanhMucService.insertDanhMuc(danhMuc4);

        DanhMucService.getDanhMuc().forEach(System.out::println);
    }
}
