package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.DeTai;

import java.util.List;

public class DeTaiDao {
    private EntityManager em;

    public DeTaiDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertDeTai(DeTai deTai){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(deTai);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<DeTai> getDeTai(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from DeTai";
            List<DeTai> deTais = em.createNativeQuery(sql, DeTai.class).getResultList();
            tr.commit();
            return deTais;
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void delDeTai(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            DeTai deTai = em.find(DeTai.class, id);
            em.remove(deTai);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
}
