package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dto.request.ProductCreateRequest;
import vn.edu.iuh.fit.dto.request.ProductUpdateRequest;
import vn.edu.iuh.fit.entities.Catergory;
import vn.edu.iuh.fit.entities.Product;
import vn.edu.iuh.fit.repositories.CatergoryRepository;
import vn.edu.iuh.fit.repositories.ProductRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CatergoryRepository catergoryRepository;

    public Product createProduct(int catergoryId, ProductCreateRequest request){
        Catergory catergory = catergoryRepository.findById(catergoryId)
                .orElseThrow(() -> new RuntimeException("Catergory khong tim thay"));

        Product product = new Product();
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setRegisterDate(request.getRegisterDate());
        product.setPrice(request.getPrice());

        product.setCatergory(catergory);

        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product khong tim thay"));
    }
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
    public Product updateProduct(int id, ProductUpdateRequest request) {
        // Tìm sản phẩm cần cập nhật
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product không tìm thấy"));

        // Tìm category mới từ request
        Catergory category = catergoryRepository.findById(request.getCatergory().getCart_id())
                .orElseThrow(() -> new RuntimeException("Category không tìm thấy"));

        // Cập nhật thông tin sản phẩm
        product.setCode(request.getCode());
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setRegisterDate(request.getRegisterDate());
        product.setPrice(request.getPrice());

        // Cập nhật category
        product.setCatergory(category);

        // Lưu và trả về sản phẩm đã cập nhật
        return productRepository.save(product);
    }
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<Product> getProductsByCategory(Integer categoryId, Pageable pageable) {
        Catergory category = catergoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return productRepository.findByCatergory(category, pageable);
    }

    public Page<Product> searchProducts(String searchTerm, Pageable pageable) {
        try {
            // Try parsing as ID
            if (searchTerm.matches("\\d+")) {
                int id = Integer.parseInt(searchTerm);
                return productRepository.findById(id, pageable);
            }

            // Try parsing as Price
            try {
                double price = Double.parseDouble(searchTerm);
                return productRepository.findByPrice(price, pageable);
            } catch (NumberFormatException e) {
                // Not a valid price, continue with other searches
            }

            // Try parsing as Date
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(searchTerm);
                return productRepository.findByRegisterDate(date, pageable);
            } catch (ParseException e) {
                // Not a valid date, continue with other searches
            }

            // Search by name and code
            return productRepository.findByNameContainingOrCodeContaining(searchTerm, searchTerm, pageable);
        } catch (Exception e) {
            // If any error occurs, return empty page
            return Page.empty(pageable);
        }
    }

}
