package en.edu.iuh.fit.test;

import en.edu.iuh.fit.entities.NhaCungCap;
import en.edu.iuh.fit.services.NhaCungCapService;

public class NhaCungCapService_Test {
    public static void main(String[] args) {
        NhaCungCap nhaCungCap1 = new NhaCungCap("SamSung","12 Nguyen Van Bao","0837699806");
        NhaCungCap nhaCungCap2 = new NhaCungCap("Apple","12 Nguyen Thai Son","0837699807");

        NhaCungCapService.insertNhaCungCap(nhaCungCap1);
        NhaCungCapService.insertNhaCungCap(nhaCungCap2);

        NhaCungCapService.getAllNhaCungCap().forEach(System.out::println);
    }
}
