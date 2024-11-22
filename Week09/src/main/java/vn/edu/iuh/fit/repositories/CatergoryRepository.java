package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entities.Catergory;

@Repository
public interface CatergoryRepository extends JpaRepository<Catergory,Integer> {
}