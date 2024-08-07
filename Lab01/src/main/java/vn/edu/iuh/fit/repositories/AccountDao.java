package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import vn.edu.iuh.fit.entities.Account;

import java.util.List;

public class AccountDao {
    private EntityManager em;

    public AccountDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }

    // Thêm tài khoản
    public void insertAccount(Account account){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(account);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    // Tìm kiếm Account theo id
    public Account searchAccount(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            Account account = em.find(Account.class, id);
            tr.commit();
            return account;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Xóa tài khoản theo id
    public void dellAccount(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            Account account = em.find(Account.class, id);
            if (account != null) {
                em.remove(account);
            }
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    // Xem thông tin Account
    public List<Account> getAccounts(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try {
            String sql ="select * from Account";
            List<Account> rl = em.createNativeQuery(sql, Account.class).getResultList();

            tr.commit();
            return rl;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
