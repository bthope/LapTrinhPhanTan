package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entitties.DanhMuc;
import vn.edu.iuh.fit.repositories.DanhMucDao;

import java.util.List;

public class DanhMucService {
    private static DanhMucDao danhMucDao = new DanhMucDao();

    public static void insertDanhMuc(DanhMuc danhMuc){
        danhMucDao.insertDanhMuc(danhMuc);
    }
    public static List<DanhMuc> getDanhMuc(){
        return danhMucDao.getDanhMuc();
    }
    public static void delDanhMuc(String id){
        danhMucDao.delDanhMuc(id);
    }
    public static DanhMuc getDanhMucById(String id){
        return danhMucDao.getDanhMucById(id);
    }
    public static List<String> getDanhMucId(){
        return danhMucDao.getDanhMucId();
    }
}
