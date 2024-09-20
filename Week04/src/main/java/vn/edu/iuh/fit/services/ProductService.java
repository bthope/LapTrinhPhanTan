package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.enitty.Product;
import vn.edu.iuh.fit.repository.ProductDao;

import java.util.List;

public class ProductService {
    private static ProductDao productDao = new ProductDao();

    public static void insertProduct(Product product){
        productDao.insertProduct(product);
    }
    public static List<Product> getProduct(){
        return productDao.getProduct();
    }
}
