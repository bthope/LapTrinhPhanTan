package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.GiangVien;

import java.util.List;

public class GiangVienDao {
    private EntityManager em;

    public GiangVienDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertGiangVien(GiangVien giangVien){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(giangVien);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public List<GiangVien> getGiangVien(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from GiangVien";
            List<GiangVien> giangViens = em.createNativeQuery(sql, GiangVien.class).getResultList();
            tr.commit();
            return giangViens;
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delGiangVien(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            GiangVien giangVien = em.find(GiangVien.class, id);
            em.remove(giangVien);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
}
