package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entities.DeTai;
import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.services.DeTaiService;
import dto.request.DeTaiCreateRequest;

import java.util.List;

@RestController
@RequestMapping("/detai")
public class DeTaiController {

    @Autowired
    private DeTaiService deTaiService;

    @PostMapping("/create")
    public ResponseEntity<?> createDeTai(@RequestParam long giangVienId, @RequestBody DeTaiCreateRequest request) {
        try {
            // Gọi hàm createDeTai từ service để thêm đề tài
            DeTai deTai = deTaiService.createDeTai(giangVienId, request);
            return new ResponseEntity<>(deTai, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            // Bắt lỗi và trả về phản hồi với mã lỗi 400 Bad Request
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Bắt các lỗi khác và trả về phản hồi với mã lỗi 500 Internal Server Error
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    List<DeTai> deTais(){
        return deTaiService.getDeTai();
    }
    @GetMapping("/{id}")
    DeTai getDeTaiById(@PathVariable("id") long id){
        return deTaiService.getDeTaiById(id);
    }

    @DeleteMapping("/{id}")
    String deleteDeTai(@PathVariable long id){
        deTaiService.delDeTai(id);
        return "Delete successful";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDeTai(@PathVariable("id") long id, @RequestBody DeTaiCreateRequest request) {
        try {
            // Gọi hàm updateDeTai từ service để cập nhật đề tài
            DeTai updatedDeTai = deTaiService.updateDeTai(id, request);
            return new ResponseEntity<>(updatedDeTai, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
