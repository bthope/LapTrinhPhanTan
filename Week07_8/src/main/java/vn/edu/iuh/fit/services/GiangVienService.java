package vn.edu.iuh.fit.services;

import dto.request.GiangVienCreateRequest;
import dto.request.GiangVienUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.repositories.GiangVienRepository;

import java.util.List;

@Service
public class GiangVienService {
    @Autowired
    private GiangVienRepository giangVienRepository;

    public GiangVien createGiangVien(GiangVienCreateRequest request){
    GiangVien giangVien = new GiangVien();
    giangVien.setTenGV(request.getTenGV());
    giangVien.setLinhVucNghienCuu(request.getLinhVucNghienCuu());
    giangVien.setDienThoai(request.getDienThoai());
    giangVien.setEmail(request.getEmail());

        return giangVienRepository.save(giangVien);
    }

    public List<GiangVien> getGiangVien(){
        return giangVienRepository.findAll();
    }
    public GiangVien getGiangVienById(long id){
        return giangVienRepository.findById(id).orElseThrow( () -> new RuntimeException("Giang vien khong tim thay"));
    }
    public void deleteGiangVien(long id){
        giangVienRepository.deleteById(id);
    }
    public GiangVien updateGiangVien(long id, GiangVienUpdateRequest request){

        GiangVien giangVien =getGiangVienById(id);
        giangVien.setLinhVucNghienCuu(request.getLinhVucNghienCuu());
        giangVien.setDienThoai(request.getDienThoai());
        giangVien.setEmail(request.getEmail());

        return giangVienRepository.save(giangVien);
    }

}
