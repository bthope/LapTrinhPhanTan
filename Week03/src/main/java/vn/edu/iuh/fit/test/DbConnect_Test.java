package vn.edu.iuh.fit.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.repositories.DbConnect;

public class DbConnect_Test {
    public static void main(String[] args) {
        try{
            DbConnect dbConnect = DbConnect.getInstance();
            EntityManager em = dbConnect.getEmf().createEntityManager();

            EntityTransaction tr = em.getTransaction();
            tr.begin();
            try{
                tr.commit();
            }catch (Exception e){
                tr.rollback();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
