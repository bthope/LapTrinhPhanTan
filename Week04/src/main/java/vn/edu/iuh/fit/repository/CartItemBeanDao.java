package vn.edu.iuh.fit.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.enitty.CartItemBean;
import vn.edu.iuh.fit.services.CartBeanService;

import java.util.List;

public class CartItemBeanDao {
    private EntityManager em;

    public CartItemBeanDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertCartItemBean(CartItemBean cartItemBean){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(cartItemBean);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public List<CartItemBean> getCartItemBean(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from CartItemBean";
            List<CartItemBean> cartItemBeans = em.createNativeQuery(sql, CartItemBean.class).getResultList();
            tr.commit();
            return cartItemBeans;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return  null;
    }
    public void delCartItemBeanDao(String id) {
        EntityTransaction tr = em.getTransaction();
        if (!tr.isActive()) {
            tr.begin();
        }
        try {
            CartItemBean cartItemBean = em.find(CartItemBean.class, id);
            if (cartItemBean != null) {
                em.remove(cartItemBean);
                tr.commit();
            } else {
                System.out.println("CartItemBean with ID " + id + " not found.");
                tr.rollback(); // Rollback if item is not found
            }
        } catch (Exception e) {
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }


    public CartItemBean getCartItemById(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            CartItemBean cartBeanService = em.find(CartItemBean.class, id);
            tr.commit();
            return cartBeanService;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
