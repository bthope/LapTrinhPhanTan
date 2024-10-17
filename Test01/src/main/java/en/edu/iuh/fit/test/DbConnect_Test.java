package en.edu.iuh.fit.test;

import en.edu.iuh.fit.repositories.DbConnect;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DbConnect_Test {
    public static void main(String[] args) {
        try{
            DbConnect dbConnect = DbConnect.getInstance();
            EntityManager em = dbConnect.getEmf().createEntityManager();
            EntityTransaction tr = em.getTransaction();
            tr.begin();
            try{
                tr.commit();
            } catch (Exception e){
                tr.rollback();
                System.out.println(e.getMessage());
            } finally {
                em.close();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
