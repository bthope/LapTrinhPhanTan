package en.edu.iuh.fit.services;

import en.edu.iuh.fit.entities.DienThoai;
import en.edu.iuh.fit.repositories.DienThoaiDao;

import java.util.List;

public class DienThoaiService {
    private static DienThoaiDao dienThoaiDao = new DienThoaiDao();
    public static void insertDienThoai(DienThoai dienThoai){
        dienThoaiDao.insertDienThoai(dienThoai);
    }
    public static void updateDienThoai(DienThoai dienThoai){
        dienThoaiDao.updateDienThoai(dienThoai);
    }
    public static void delDienThoai(String id){
        dienThoaiDao.delDienThoai(id);
    }
    public static List<DienThoai> getAllDienThoai(){
        return dienThoaiDao.getAllDienThoai();
    }
    public static DienThoai getDienThoaiById(String id){
        return dienThoaiDao.getDienThoaiById(id);
    }
}
