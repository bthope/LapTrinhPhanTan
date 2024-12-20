package vn.edu.iuh.fit.bai05;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.entities.Catergory;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.repositories.CatergoryRepository;
import vn.edu.iuh.fit.repositories.ProductRepository;

import java.util.Date;

@SpringBootTest
class Bai05ApplicationTests {
	@Autowired
	CatergoryRepository catergoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Test
	void addCatergory() {
		// Add 4 catergories
		catergoryRepository.save(new Catergory(1,"Catergory 1"));
		catergoryRepository.save(new Catergory(2,"Catergory 2"));
		catergoryRepository.save(new Catergory(3,"Catergory 3"));
		catergoryRepository.save(new Catergory(4,"Catergory 4"));
	}
	@Test
	void addProduct() {
		// Fetch categories
		Catergory cat1 = catergoryRepository.findById(1).orElseThrow();
		Catergory cat2 = catergoryRepository.findById(2).orElseThrow();
		Catergory cat3 = catergoryRepository.findById(3).orElseThrow();
		Catergory cat4 = catergoryRepository.findById(4).orElseThrow();

		// Add products for each category
		productRepository.save(new Product(1, "P001", "Product 1 of Cat 1", "Description 1", new Date(), 100.0, cat1));
		productRepository.save(new Product(2, "P002", "Product 2 of Cat 1", "Description 2", new Date(), 200.0, cat1));

		productRepository.save(new Product(3, "P003", "Product 1 of Cat 2", "Description 3", new Date(), 150.0, cat2));
		productRepository.save(new Product(4, "P004", "Product 2 of Cat 2", "Description 4", new Date(), 250.0, cat2));

		productRepository.save(new Product(5, "P005", "Product 1 of Cat 3", "Description 5", new Date(), 300.0, cat3));
		productRepository.save(new Product(6, "P006", "Product 2 of Cat 3", "Description 6", new Date(), 400.0, cat3));

		productRepository.save(new Product(7, "P007", "Product 1 of Cat 4", "Description 7", new Date(), 500.0, cat4));
		productRepository.save(new Product(8, "P008", "Product 2 of Cat 4", "Description 8", new Date(), 600.0, cat4));
	}


}
