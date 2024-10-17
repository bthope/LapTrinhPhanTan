package en.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity(name = "DienThoai")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADT")
    private long maDT;
    @Column(name = "TENDT", columnDefinition = "varchar(50)")
    private String tenDT;
    @Column(name = "NAMSANXUAT")
    private int namSX;
    @Column(name = "CAUHINH", columnDefinition = "varchar(50)")
    private String cauHinh;
    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap nhaCungCap;

    public DienThoai() {
    }

    public DienThoai(long maDT, String tenDT, int namSX, String cauHinh, NhaCungCap nhaCungCap) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauHinh = cauHinh;
        this.nhaCungCap = nhaCungCap;
    }

    public DienThoai(String tenDT, int namSX, String cauHinh, NhaCungCap nhaCungCap) {
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauHinh = cauHinh;
        this.nhaCungCap = nhaCungCap;
    }

    public DienThoai(String tenDT, int namSX, String cauHinh) {
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauHinh = cauHinh;
    }

    public long getMaDT() {
        return maDT;
    }

    public void setMaDT(long maDT) {
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

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
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
                "maDT=" + maDT +
                ", tenDT='" + tenDT + '\'' +
                ", namSX=" + namSX +
                ", cauHinh='" + cauHinh + '\'' +
                ", nhaCungCap=" + nhaCungCap +
                '}';
    }
}
