package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.Log;

import java.util.List;

public class LogDao {
    private EntityManager em;

    public LogDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    public void insertLog(Log log){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(log);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    // Xem tat ca danh sach Log
    public List<Log> getLogs(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from log";
            List<Log> logs = em.createNativeQuery(sql, Log.class).getResultList();
            tr.commit();
            return logs;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

}
