package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entitties.TinTuc;

import java.util.List;

public class TinTucDao {
    private EntityManager em;

    public TinTucDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertTinTuc(TinTuc tinTuc){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(tinTuc);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public List<TinTuc> getTinTuc(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from TinTuc";
            List<TinTuc> tinTucs = em.createNativeQuery(sql, TinTuc.class).getResultList();
            tr.commit();
            return tinTucs;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delTinTuc(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            TinTuc tinTuc = em.find(TinTuc.class,id);
            em.remove(tinTuc);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
}
