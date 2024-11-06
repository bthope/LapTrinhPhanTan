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
@Entity(name = "DeTai")
public class DeTai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADETAI")
    private long maDeTai;
    @Column(name = "TENDETAI",columnDefinition = "varchar(50)")
    private String tenDeTai;
    @Column(name = "NAM")
    private int nam;
    @Column(name = "MOTADETAI",columnDefinition = "varchar(250)")
    private String moTaDeTai;
    @Column(name = "URLHINH",columnDefinition = "varchar(250)")
    private String urlHinh;
    @ManyToOne
    @JoinColumn(name = "maGV")
    private GiangVien giangVien;
}
