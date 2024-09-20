package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.enitty.Product;
import vn.edu.iuh.fit.services.ProductService;

public class ProductService_Test {
    public static void main(String[] args) {
        // Create product instances with valid data
        Product product1 = new Product("S1", "Apple iPhone", "iOS smartphone", 9, 29000.10, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");
        Product product2 = new Product("S2", "Samsung Galaxy", "Android smartphone", 15, 25000.20, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");
        Product product3 = new Product("S3", "HTC One", "Android smartphone", 12, 23000.30, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");
        Product product4 = new Product("S4", "Sony Xperia", "Android smartphone", 7, 21000.40, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");
        Product product5 = new Product("S5", "Sony Xperia", "Android smartphone", 7, 21000.40, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");
        Product product6 = new Product("S6", "Sony Xperia", "Android smartphone", 7, 21000.40, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");
        Product product7 = new Product("S7", "Sony Xperia", "Android smartphone", 7, 21000.40, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");
        Product product8 = new Product("S8", "Sony Xperia", "Android smartphone", 7, 21000.40, "https://cdn.tgdd.vn/Products/Images/42/329135/iphone-16-blue-600x600.png");


        // Insert products using the ProductService
        ProductService.insertProduct(product1);
        ProductService.insertProduct(product2);
        ProductService.insertProduct(product3);
        ProductService.insertProduct(product4);
        ProductService.insertProduct(product5);
        ProductService.insertProduct(product6);
        ProductService.insertProduct(product7);
        ProductService.insertProduct(product8);

        System.out.println("Products inserted successfully!");
    }
}
