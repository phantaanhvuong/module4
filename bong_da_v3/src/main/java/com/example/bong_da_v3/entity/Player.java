package com.example.bong_da_v3.entity;

import com.example.bong_da_v3.validation.ValidAge;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Pattern(regexp = "^PL[0-9]{3}$",message = "Vui lòng nhập đúng định dạng PLxxx(x là số)")
    private String playerCode;


    @NotEmpty(message = "Không được để trống")
    @Size(min = 5,max = 100,message = "Tên ít nhất 5 ký tự và tối đa 100 ký tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Tên chỉ được chứa chữ cái và khoảng trắng")
    private String name;

    @ValidAge
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "Ngày sinh không được để trống")
    private LocalDate birthday;


    @NotNull(message = "Không được để trống")
    @Positive( message = "Kinh nghiệm phải là số nguyên dương")
    private Integer experience;

    private String image;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'Dự bị'")

    private String status;
    //do dùng @AllArgsConstructor nên phải dùng này để giá trị được lưu DB
    @PrePersist
    public void prePersist() {
        if (this.status == null || this.status.trim().isEmpty()) {
            this.status = "Dự bị";
        }
    }

}
