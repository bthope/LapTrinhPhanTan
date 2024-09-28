package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entitties.TinTuc;
import vn.edu.iuh.fit.repositories.TinTucDao;

import java.util.List;

public class TinTucService {
    private static TinTucDao tinTucDao = new TinTucDao();

    public static void insertTinTuc(TinTuc tinTuc){
        tinTucDao.insertTinTuc(tinTuc);
    }
    public static List<TinTuc> getTinTuc(){
        return tinTucDao.getTinTuc();
    }
    public static void delTinTuc(String id){
        tinTucDao.delTinTuc(id);
    }
}
