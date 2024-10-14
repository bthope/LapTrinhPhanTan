package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity(name = "NhaCungCap")
public class NhaCungCap {
    @Id
    @Column(name = "MANCC",columnDefinition = "varchar(6)")
    private String maNCC;
    @Column(name = "TENNCC",columnDefinition = "varchar(50)")
    private String tenNCC;
    @Column(name = "DIACHI",columnDefinition = "varchar(250)")
    private String diachi;
    @Column(name = "SODT",columnDefinition = "varchar(15)")
    private String soDT;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNCC, String diachi, String soDT) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diachi = diachi;
        this.soDT = soDT;
    }

    public NhaCungCap(String tenNCC, String diachi, String soDT) {
        this.tenNCC = tenNCC;
        this.diachi = diachi;
        this.soDT = soDT;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}
