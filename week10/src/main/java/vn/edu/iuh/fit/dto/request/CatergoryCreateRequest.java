package vn.edu.iuh.fit.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatergoryCreateRequest {
    @Column(name = "name", columnDefinition = "varchar(50)")
    private String name;
}
