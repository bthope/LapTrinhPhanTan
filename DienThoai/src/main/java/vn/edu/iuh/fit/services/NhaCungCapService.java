package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.NhaCungCap;
import vn.edu.iuh.fit.repositories.NhaCungCapDao;

import java.util.List;

public class NhaCungCapService {
    private static NhaCungCapDao nhaCungCapDao = new NhaCungCapDao();

    public static void insertNhaCungCap(NhaCungCap nhaCungCap){
        nhaCungCapDao.insertNhaCungCap(nhaCungCap);
    }
    public static List<NhaCungCap> getAllNhaCungCap(){
        return nhaCungCapDao.getAllNhaCungCap();
    }
    public static List<String> getNhaCungCapByName(){
        return nhaCungCapDao.getNhaCungCapByName();
    }
    public static NhaCungCap getNhaCungCapById(String id){
        return nhaCungCapDao.getNhaCungCapById(id);
    }
}
