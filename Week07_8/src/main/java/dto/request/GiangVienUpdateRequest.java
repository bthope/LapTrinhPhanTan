package dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiangVienUpdateRequest {
    @Column(name = "LINHVUCNGHIENCUU", columnDefinition = "varchar(50)")
    private String linhVucNghienCuu;
    @Column(name = "DIENTHOAI", columnDefinition = "varchar(15)")
    private String dienThoai;
    @Column(name = "EMAIL", columnDefinition = "varchar(50)")
    private String email;
}
