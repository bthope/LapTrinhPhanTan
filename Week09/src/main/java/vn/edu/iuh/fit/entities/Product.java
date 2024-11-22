package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
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
