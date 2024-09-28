package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DETAI")
public class DeTai {
    @Id
    @Column(name = "MADT", columnDefinition = "varchar(50)")
    private String maDT;
    @Column(name = "TENDT", columnDefinition = "varchar(50)")
    private String tenDT;
    @Column(name = "NAMDANGKY", columnDefinition = "varchar(50)")
    private String namDangKy;
    @ManyToOne
    @JoinColumn(name = "maGV")
    private GiangVien giangVien;

    public DeTai() {
    }

    public DeTai(String maDT, String tenDT, String namDangKy, GiangVien giangVien) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namDangKy = namDangKy;
        this.giangVien = giangVien;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getNamDangKy() {
        return namDangKy;
    }

    public void setNamDangKy(String namDangKy) {
        this.namDangKy = namDangKy;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    @Override
    public String toString() {
        return "DeTai{" +
                "maDT='" + maDT + '\'' +
                ", tenDT='" + tenDT + '\'' +
                ", namDangKy='" + namDangKy + '\'' +
                ", giangVien=" + giangVien +
                '}';
    }
}
