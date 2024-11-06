package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entities.GiangVien;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien,Long> {
}
