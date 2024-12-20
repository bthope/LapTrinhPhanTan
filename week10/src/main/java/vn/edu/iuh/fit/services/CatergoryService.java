package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dto.request.CatergoryCreateRequest;
import vn.edu.iuh.fit.entities.Catergory;
import vn.edu.iuh.fit.repositories.CatergoryRepository;

import java.util.List;

@Service
public class CatergoryService {
    @Autowired
    private CatergoryRepository catergoryRepository;

    public List<Catergory> getAllCatergory(){
        return catergoryRepository.findAll();
    }
    public Catergory getCatergoryById(int id){
        return catergoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Catergory khong tim thay"));
    }
    public Catergory createCatergory(CatergoryCreateRequest request){
        Catergory catergory = new Catergory();
        catergory.setName(request.getName());
        return catergoryRepository.save(catergory);
    }


}
