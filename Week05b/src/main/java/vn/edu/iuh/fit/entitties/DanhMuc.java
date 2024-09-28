package vn.edu.iuh.fit.entitties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DanhMuc")
public class DanhMuc {
    @Id
    @Column(name = "MaDanhMuc", columnDefinition = "varchar(50)")
    private String maDM;
    @Column(name = "TenDanhMuc", columnDefinition = "varchar(50)")
    private String tenDM;
    @Column(name = "NguoiQuanLy", columnDefinition = "varchar(50)")
    private String nguoiQL;
    @Column(name = "GhiChu", columnDefinition = "varchar(250)")
    private String ghiChu;

    public DanhMuc() {
    }

    public DanhMuc(String maDM, String tenDM, String nguoiQL, String ghiChu) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.nguoiQL = nguoiQL;
        this.ghiChu = ghiChu;
    }

    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getNguoiQL() {
        return nguoiQL;
    }

    public void setNguoiQL(String nguoiQL) {
        this.nguoiQL = nguoiQL;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "DanhMuc{" +
                "maDM='" + maDM + '\'' +
                ", tenDM='" + tenDM + '\'' +
                ", nguoiQL='" + nguoiQL + '\'' +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
