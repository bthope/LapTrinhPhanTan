package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "GiangVien")
public class GiangVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAGV")
    private long maGV;
    @Column(name = "TENGV", columnDefinition = "varchar(50)")
    private String tenGV;
    @Column(name = "LINHVUCNGHIENCUU", columnDefinition = "varchar(50)")
    private String linhVucNghienCuu;
    @Column(name = "DIENTHOAI", columnDefinition = "varchar(15)")
    private String dienThoai;
    @Column(name = "EMAIL", columnDefinition = "varchar(50)")
    private String email;
}
