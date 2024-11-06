package dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.entities.GiangVien;


@Getter
@Setter
public class DeTaiUpdateRequest {
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
