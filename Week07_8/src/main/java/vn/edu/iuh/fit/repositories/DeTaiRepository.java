package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entities.DeTai;

@Repository
public interface DeTaiRepository extends JpaRepository<DeTai,Long> {
}
