package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entities.Catergory;
import vn.edu.iuh.fit.entities.Product;

import java.util.Date;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findByCatergory(Catergory category, Pageable pageable);
    Page<Product> findById(int id, Pageable pageable);

    // Search by Name or Code
    Page<Product> findByNameContainingOrCodeContaining(String name, String code, Pageable pageable);

    // Search by Price
    Page<Product> findByPrice(double price, Pageable pageable);

    // Search by Register Date
    Page<Product> findByRegisterDate(Date registerDate, Pageable pageable);

    // Có thể thêm tìm kiếm gần đúng cho Price nếu cần
//    @Query("SELECT p FROM Product p WHERE ABS(p.price - :price) <= 1")
//    Page<Product> findByPriceApproximate(@Param("price") double price, Pageable pageable);
}
