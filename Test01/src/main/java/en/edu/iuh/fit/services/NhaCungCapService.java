package en.edu.iuh.fit.services;

import en.edu.iuh.fit.entities.NhaCungCap;
import en.edu.iuh.fit.repositories.NhaCungCapDao;

import java.util.List;

public class NhaCungCapService {
    private static NhaCungCapDao nhaCungCapDao = new NhaCungCapDao();

    public static void insertNhaCungCap(NhaCungCap nhaCungCap){
        nhaCungCapDao.insertNhaCungCap(nhaCungCap);
    }
    public static List<NhaCungCap> getAllNhaCungCap(){
        return nhaCungCapDao.getAllNhaCungCap();
    }
    public static NhaCungCap getNhaCungCapById(String id){
        return nhaCungCapDao.getNhaCungCapById(id);
    }
    public static List<Long> getAllNhaCungCapByName(){
        return nhaCungCapDao.getAllNhaCungCapByName();
    }
}
