package vn.edu.iuh.fit.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vn.edu.iuh.fit.entities.Catergory;

import java.util.Date;

@Getter
@Setter
public class ProductCreateRequest {
    @Column(name = "code", columnDefinition = "varchar(20)")
    private String code;
    @Column(name = "name", columnDefinition = "varchar(20)")
    private String name;
    @Column(name = "description", columnDefinition = "varchar(255)")
    private String description;
    @Column(name = "registerDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;
    @Column(name = "price")
    private double price;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Catergory catergory;
}

