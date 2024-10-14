package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity(name = "DienThoai")
public class DienThoai {
    @Id
    @Column(name = "MADT",columnDefinition = "varchar(6)")
    private String maDT;
    @Column(name = "TENDT",columnDefinition = "varchar(50)")
    private String tenDT;
    @Column(name = "NAMSX")
    private int namSX;
    @Column(name = "CAUHINH",columnDefinition = "varchar(50)")
    private String cauhinh;
    @ManyToOne
    @JoinColumn(name = "maNCC")
    private NhaCungCap nhaCungCap;

    public DienThoai(String maDT, String tenDT, int namSX, String cauhinh, NhaCungCap nhaCungCap) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauhinh = cauhinh;
        this.nhaCungCap = nhaCungCap;
    }

    public DienThoai(String maDT, String tenDT, int namSX, String cauhinh) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauhinh = cauhinh;
    }

    public DienThoai(String tenDT, int namSX, String cauhinh, NhaCungCap nhaCungCap) {
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauhinh = cauhinh;
        this.nhaCungCap = nhaCungCap;
    }

    public DienThoai() {
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

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getCauhinh() {
        return cauhinh;
    }

    public void setCauhinh(String cauhinh) {
        this.cauhinh = cauhinh;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public String toString() {
        return "DienThoai{" +
                "maDT='" + maDT + '\'' +
                ", tenDT='" + tenDT + '\'' +
                ", namSX=" + namSX +
                ", cauhinh='" + cauhinh + '\'' +
                ", nhaCungCap=" + nhaCungCap +
                '}';
    }
}
