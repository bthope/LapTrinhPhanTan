package vn.edu.iuh.fit.test;

import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.services.ProductService;

public class ProductService_test {
    public static void main(String[] args) {
        // Create 8 product objects with sample data
        Product product1 = new Product(1, "Java Programming", 50000, 10, "James Gosling", "https://cdn0.fahasa.com/media/catalog/product/c/h/chiasetutraitim-bia.jpg");
        Product product2 = new Product(2, "Python Programming", 45000, 15, "Guido van Rossum", "https://cdn0.fahasa.com/media/catalog/product/b/i/bia-1_6_6.jpg");
        Product product3 = new Product(3, "Effective C++", 60000, 8, "Scott Meyers", "https://cdn0.fahasa.com/media/catalog/product/z/4/z4118763446785_cf4bc22d353b065bbb37e686de1f9207.jpg");
        Product product4 = new Product(4, "JavaScript: The Good Parts", 40000, 12, "Douglas Crockford", "https://cdn0.fahasa.com/media/catalog/product/c/h/chiasetutraitim-bia.jpg");
        Product product5 = new Product(5, "Clean Code", 55000, 7, "Robert C. Martin", "https://cdn0.fahasa.com/media/catalog/product/c/h/chiasetutraitim-bia.jpg");
        Product product6 = new Product(6, "Introduction to Algorithms", 75000, 5, "Thomas H. Cormen", "https://cdn0.fahasa.com/media/catalog/product/c/h/chiasetutraitim-bia.jpg");
        Product product7 = new Product(7, "Design Patterns", 65000, 9, "Erich Gamma", "https://cdn0.fahasa.com/media/catalog/product/c/h/chiasetutraitim-bia.jpg");
        Product product8 = new Product(8, "Database Systems", 70000, 6, "Hector Garcia-Molina", "https://cdn0.fahasa.com/media/catalog/product/c/h/chiasetutraitim-bia.jpg");

        ProductService.insertProduct(product1);
        ProductService.insertProduct(product2);
        ProductService.insertProduct(product3);
        ProductService.insertProduct(product4);
        ProductService.insertProduct(product5);
        ProductService.insertProduct(product6);
        ProductService.insertProduct(product7);
        ProductService.insertProduct(product8);

        System.out.println("insert successful");
    }
}
