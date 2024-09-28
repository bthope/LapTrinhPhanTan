package vn.edu.iuh.fit.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GIANGVIEN")
public class GiangVien {
    @Id
    @Column(name = "MAGV", columnDefinition = "varchar(50)")
    private String maGV;
    @Column(name = "TENGV", columnDefinition = "varchar(50)")
    private String tenGV;
    @Column(name = "LINHVUCNGHIENCUU", columnDefinition = "varchar(250)")
    private String linhVuNghienCuu;
    @Column(name = "SODIENTHOAI", columnDefinition = "varchar(50)")
    private String soDT;

    public GiangVien() {
    }

    public GiangVien(String maGV, String tenGV, String linhVuNghienCuu, String soDT) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.linhVuNghienCuu = linhVuNghienCuu;
        this.soDT = soDT;
    }

    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getLinhVuNghienCuu() {
        return linhVuNghienCuu;
    }

    public void setLinhVuNghienCuu(String linhVuNghienCuu) {
        this.linhVuNghienCuu = linhVuNghienCuu;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    @Override
    public String toString() {
        return "GiangVien{" +
                "maGV='" + maGV + '\'' +
                ", tenGV='" + tenGV + '\'' +
                ", linhVuNghienCuu='" + linhVuNghienCuu + '\'' +
                ", soDT='" + soDT + '\'' +
                '}';
    }
}
