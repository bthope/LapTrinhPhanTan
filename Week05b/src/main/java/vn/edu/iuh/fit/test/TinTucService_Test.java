package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entitties.DanhMuc;
import vn.edu.iuh.fit.entitties.TinTuc;
import vn.edu.iuh.fit.services.DanhMucService;
import vn.edu.iuh.fit.services.TinTucService;

public class TinTucService_Test {
    public static void main(String[] args) {
        DanhMuc danhMuc1 = DanhMucService.getDanhMuc().get(0);
        DanhMuc danhMuc2 = DanhMucService.getDanhMuc().get(1);

        TinTuc tinTuc1 = new TinTuc("TT01","Nui Cao","Nui cao nhat the gioi",danhMuc1);
        TinTuc tinTuc2 = new TinTuc("TT02","Song sau","Song sau the gioi",danhMuc2);

        TinTucService.insertTinTuc(tinTuc1);
        TinTucService.insertTinTuc(tinTuc2);

        TinTucService.getTinTuc().forEach(System.out::println);

    }
}
