package vn.edu.iuh.fit.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.enitty.Product;

import java.util.List;

public class ProductDao {
    private EntityManager em;

    public ProductDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertProduct(Product product){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(product);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public List<Product> getProduct(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from product";
            List<Product> products = em.createNativeQuery(sql, Product.class).getResultList();
            tr.commit();
            return products;
        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }


}
