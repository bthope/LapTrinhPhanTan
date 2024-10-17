package en.edu.iuh.fit.repositories;

import en.edu.iuh.fit.entities.DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DienThoaiDao {
    private EntityManager em;

    public DienThoaiDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    public void insertDienThoai(DienThoai dienThoai){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.persist(dienThoai);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public List<DienThoai> getAllDienThoai(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from DienThoai";
            List<DienThoai> dienThoais = em.createNativeQuery(sql, DienThoai.class).getResultList();
            tr.commit();
            return dienThoais;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delDienThoai(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            DienThoai dienThoai = em.find(DienThoai.class, id);
            em.remove(dienThoai);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public DienThoai getDienThoaiById(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            DienThoai dienThoai = em.find(DienThoai.class, id);
            tr.commit();
            return dienThoai;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void updateDienThoai(DienThoai dienThoai){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(dienThoai);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

}
