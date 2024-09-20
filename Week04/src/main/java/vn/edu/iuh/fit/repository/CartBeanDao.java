package vn.edu.iuh.fit.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.enitty.CartBean;

import java.util.List;

public class CartBeanDao {
    private EntityManager em;

    public CartBeanDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertCartBean(CartBean cartBean){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(cartBean);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public List<CartBean> getCartBean(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from CartBean";
            List<CartBean> cartBeans = em.createNativeQuery(sql, CartBean.class).getResultList();
            tr.commit();
            return cartBeans;
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return  null;
    }

    public void delCartBeanById(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            CartBean cartBean = em.find(CartBean.class, id);
            em.remove(cartBean);
            tr.commit();
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

}
