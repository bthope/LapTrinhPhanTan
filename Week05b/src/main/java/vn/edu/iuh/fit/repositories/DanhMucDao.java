package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entitties.DanhMuc;

import java.util.List;
import java.util.stream.Collectors;

public class DanhMucDao {
    private EntityManager em;

    public DanhMucDao() {
         em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertDanhMuc(DanhMuc danhMuc){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(danhMuc);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<DanhMuc> getDanhMuc(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from DanhMuc";
            List<DanhMuc> danhMucs = em.createNativeQuery(sql, DanhMuc.class).getResultList();
            tr.commit();
            return danhMucs;
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void delDanhMuc(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            DanhMuc danhMuc = em.find(DanhMuc.class, id);
            em.remove(danhMuc);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public DanhMuc getDanhMucById(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            DanhMuc danhMuc = em.find(DanhMuc.class, id);

            tr.commit();
            return danhMuc;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<String> getDanhMucId(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from DanhMuc";
            List<DanhMuc> danhMucs = em.createNativeQuery(sql, DanhMuc.class).getResultList();
            tr.commit();

            return danhMucs
                    .stream()
                    .map(
                            i-> i.getMaDM()
                    )
                    .collect(Collectors.toList());
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
