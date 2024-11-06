package vn.edu.iuh.fit.services;

import dto.request.DeTaiCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entities.DeTai;
import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.repositories.DeTaiRepository;
import vn.edu.iuh.fit.repositories.GiangVienRepository;

import java.util.List;

@Service
public class DeTaiService {

    @Autowired
    private DeTaiRepository deTaiRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    public DeTai createDeTai(long giangVienId, DeTaiCreateRequest request) {
        // Tìm giảng viên theo ID
        GiangVien giangVien = giangVienRepository.findById(giangVienId)
                .orElseThrow(() -> new RuntimeException("Giảng viên không tìm thấy với ID: " + giangVienId));

        // Tạo đối tượng DeTai mới
        DeTai deTai = new DeTai();
        deTai.setTenDeTai(request.getTenDeTai());
        deTai.setNam(request.getNam());
        deTai.setMoTaDeTai(request.getMoTaDeTai());
        deTai.setUrlHinh(request.getUrlHinh());

        // Gán giảng viên cho đề tài
        deTai.setGiangVien(giangVien);

        // Lưu vào cơ sở dữ liệu
        return deTaiRepository.save(deTai);
    }

    public List<DeTai> getDeTai(){
        return deTaiRepository.findAll();
    }
    public DeTai getDeTaiById(long id){
        return deTaiRepository.findById(id).orElseThrow( () -> new RuntimeException("De Tai khong tim thay"));
    }
    public void delDeTai(long id){
        deTaiRepository.deleteById(id);
    }

    // Hàm cập nhật đề tài
    public DeTai updateDeTai(long id, DeTaiCreateRequest request) {
        // Tìm đề tài theo ID
        DeTai deTai = deTaiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Đề tài không tìm thấy với ID: " + id));

        // Cập nhật các thuộc tính của đề tài từ request
        deTai.setTenDeTai(request.getTenDeTai());
        deTai.setNam(request.getNam());
        deTai.setMoTaDeTai(request.getMoTaDeTai());
        deTai.setUrlHinh(request.getUrlHinh());

        // Lưu lại các thay đổi
        return deTaiRepository.save(deTai);
    }
}
