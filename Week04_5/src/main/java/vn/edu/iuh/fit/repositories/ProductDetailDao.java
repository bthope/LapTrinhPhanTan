package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.entities.ProductDetail;

import java.util.List;

public class ProductDetailDao {
    private EntityManager em;

    public ProductDetailDao() {
        em = DbConnect.getInstance().getEmf().createEntityManager();
    }
    public void insertProductDetail(ProductDetail productDetail){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            em.merge(productDetail);
            tr.commit();
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<ProductDetail> getProductDetail(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "select * from productdetail";
            List<ProductDetail> productDetails = em.createNativeQuery(sql, ProductDetail.class).getResultList();
            tr.commit();
            return productDetails;
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return  null;
    }

    public void delProductDetailById(String id){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            ProductDetail productDetail = em.find(ProductDetail.class, id);
            em.remove(productDetail);
            tr.commit();

        }catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
    }
    public ProductDetail getLastProductDetail(){
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        try{
            String sql = "SELECT * FROM product_detail ORDER BY id DESC LIMIT 1";
            List<ProductDetail> productDetail = em.createNativeQuery(sql, ProductDetail.class).getResultList();
            tr.commit();
            return productDetail.get(0);
        } catch (Exception e){
            tr.rollback();
            System.out.println(e.getMessage());
        }
        return null;
    }
}
