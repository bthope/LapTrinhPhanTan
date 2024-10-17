package en.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity(name = "NhaCungCap")
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANCC")
    private long maNCC;
    @Column(name = "TENNCC", columnDefinition = "varchar(50)")
    private String tenNCC;
    @Column(name = "DIACHI", columnDefinition = "varchar(250)")
    private String diaChi;
    @Column(name = "SODIENTHOAI", columnDefinition = "varchar(15)")
    private String soDT;

    public NhaCungCap() {
    }

    public NhaCungCap(long maNCC, String tenNCC, String diaChi, String soDT) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public NhaCungCap(String tenNCC, String diaChi, String soDT) {
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public long getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(long maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNCC=" + maNCC +
                ", tenNCC='" + tenNCC + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDT='" + soDT + '\'' +
                '}';
    }
}
