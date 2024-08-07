package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.GrantAccess;

import java.util.List;

public class GrantAccessDao {
    private EntityManager em;

    public GrantAccessDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    public void insertGrantAccess(GrantAccess grantAccess){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(grantAccess);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }

    }
    public void dellGrantAccess(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "delete from grant_access where account_id= \""+id+"\"";
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    //Tim kiem grant access theo id
    public GrantAccess searchGrantAccess(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql = "select  * from grant_access where account_id=\""+id+"\"";
            List<GrantAccess> grantAccesses=em.createNativeQuery(sql, GrantAccess.class).getResultList();
            tr.commit();
            return grantAccesses.get(0);
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
    // Xem tat ca danh sach grant access
    public List<GrantAccess> getListGrantAccess(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from grant_access";
            List<GrantAccess> grantAccesses = em.createNativeQuery(sql, GrantAccess.class).getResultList();
            tr.commit();
            return  grantAccesses;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }

        return null;
    }




}
