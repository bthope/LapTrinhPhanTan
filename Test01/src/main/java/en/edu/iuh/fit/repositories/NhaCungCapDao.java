package en.edu.iuh.fit.repositories;

import en.edu.iuh.fit.entities.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.stream.Collectors;

public class NhaCungCapDao {
    private EntityManager em;

    public NhaCungCapDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    public void insertNhaCungCap(NhaCungCap nhaCungCap){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.persist(nhaCungCap);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public List<NhaCungCap> getAllNhaCungCap(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from NhaCungCap";
            List<NhaCungCap> nhaCungCaps = em.createNativeQuery(sql, NhaCungCap.class).getResultList();
            tr.commit();
            return nhaCungCaps;
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public NhaCungCap getNhaCungCapById(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            NhaCungCap nhaCungCap = em.find(NhaCungCap.class, id);
            tr.commit();
            return nhaCungCap;
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Long> getAllNhaCungCapByName(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from NhaCungCap";
            List<NhaCungCap> nhaCungCaps = em.createNativeQuery(sql, NhaCungCap.class).getResultList();
            tr.commit();
            return nhaCungCaps
                    .stream()
                    .map(
                            i -> i.getMaNCC()
                    ).collect(Collectors.toList());
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
