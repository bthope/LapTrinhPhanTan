package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.DienThoai;
import vn.edu.iuh.fit.repositories.DienThoaiDao;

import java.util.List;

public class DienThoaiService {
    private static DienThoaiDao dienThoaiDao =new DienThoaiDao();
    public static void insertDienThoai(DienThoai dienThoai){
        dienThoaiDao.insertDienThoai(dienThoai);
    }
    public static void delDienThoai(String id){
        dienThoaiDao.deltDienThoai(id);
    }
    public static List<DienThoai> getAllDienThoai(){
        return dienThoaiDao.getAllDienThoai();
    }

    public static DienThoai getDienThoaiById(String id){
        return dienThoaiDao.getDienThoaiById(id);
    }
    public static void UpdateDienThoai(DienThoai dienThoai){
        dienThoaiDao.UpdateDienThoai(dienThoai);
    }
}
