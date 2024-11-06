package vn.edu.iuh.fit.controllers;

import dto.request.GiangVienCreateRequest;
import dto.request.GiangVienUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entities.GiangVien;
import vn.edu.iuh.fit.services.GiangVienService;

import java.util.List;

@RestController
@RequestMapping("/giangvien")
public class GiangVienController {
    @Autowired
    private GiangVienService giangVienService;

    @PostMapping
    GiangVien createGiangVien(@RequestBody GiangVienCreateRequest request){
        return giangVienService.createGiangVien(request);
    }
    @GetMapping
    List<GiangVien> giangViens(){
        return giangVienService.getGiangVien();
    }
    @GetMapping("/{id}")
    GiangVien getGiangVienById(@PathVariable("id") long id){
        return giangVienService.getGiangVienById(id);
    }
    @DeleteMapping("/{id}")
    String deleteGiangVien(@PathVariable long id){
        giangVienService.deleteGiangVien(id);
        return "Delete successful";
    }

    @PutMapping("/{id}")
    GiangVien updateGiangVien(@PathVariable long id, @RequestBody GiangVienUpdateRequest request){
        return giangVienService.updateGiangVien(id,request);
    }

}
