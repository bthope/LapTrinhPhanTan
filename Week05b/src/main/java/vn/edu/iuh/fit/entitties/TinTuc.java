package vn.edu.iuh.fit.entitties;

import jakarta.persistence.*;

@Entity
@Table(name = "TinTuc")
public class TinTuc {
    @Id
    @Column(name = "MaTinTuc", columnDefinition = "varchar(50)")
    private String maTT;
    @Column(name = "TieuDe", columnDefinition = "varchar(50)")
    private String tieuDe;
    @Column(name = "NoiDungTT", columnDefinition = "varchar(250)")
    private String noiDungTT;
    @ManyToOne
    @JoinColumn(name = "maDM")
    private DanhMuc danhMuc;

    public TinTuc() {
    }

    public TinTuc(String maTT, String tieuDe, String noiDungTT) {
        this.maTT = maTT;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
    }

    public TinTuc(String maTT, String tieuDe, String noiDungTT, DanhMuc danhMuc) {
        this.maTT = maTT;
        this.tieuDe = tieuDe;
        this.noiDungTT = noiDungTT;
        this.danhMuc = danhMuc;
    }



    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public String getNoiDungTT() {
        return noiDungTT;
    }

    public void setNoiDungTT(String noiDungTT) {
        this.noiDungTT = noiDungTT;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    @Override
    public String toString() {
        return "TinTuc{" +
                "maTT='" + maTT + '\'' +
                ", tieuDe='" + tieuDe + '\'' +
                ", noiDungTT='" + noiDungTT + '\'' +
                ", danhMuc=" + danhMuc +
                '}';
    }
}
