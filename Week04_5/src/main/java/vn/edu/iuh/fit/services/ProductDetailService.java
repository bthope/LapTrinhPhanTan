package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.ProductDetail;
import vn.edu.iuh.fit.repositories.ProductDetailDao;

import java.util.List;

public class ProductDetailService {
    private static ProductDetailDao productDetailDao = new ProductDetailDao();

    public static void insertProductDetail(ProductDetail productDetail){
        productDetailDao.insertProductDetail(productDetail);
    }
    public static void delProductDetail(String id){
        productDetailDao.delProductDetailById(id);
    }
    public static List<ProductDetail> getProductDetail(){
        return productDetailDao.getProductDetail();
    }
    public static ProductDetail getLastProductDetail(){
        return productDetailDao.getLastProductDetail();
    }
}
