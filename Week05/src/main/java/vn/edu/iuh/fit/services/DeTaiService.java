package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.DeTai;
import vn.edu.iuh.fit.repositories.DeTaiDao;

import java.util.List;

public class DeTaiService {
    private static DeTaiDao deTaiDao = new DeTaiDao();

    public static void insertDeTai(DeTai deTai){
        deTaiDao.insertDeTai(deTai);
    }
    public static List<DeTai> getDeTai(){
        return deTaiDao.getDeTai();
    }
    public static void delDeTai(String id){
        deTaiDao.delDeTai(id);
    }
}
