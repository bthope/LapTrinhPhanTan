package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.repositories.GiangVienDao;

import java.util.List;

public class GiangVienService {
    private static GiangVienDao giangVienDao = new GiangVienDao();

    public static void insertGiangVien(GiangVien giangVien){
        giangVienDao.insertGiangVien(giangVien);
    }
    public static List<GiangVien> getGiangVien(){
        return giangVienDao.getGiangVien();
    }
    public static void delGiangVien(String id){
        giangVienDao.delGiangVien(id);
    }
}
