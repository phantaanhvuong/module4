package com.example.kiem_tra_ket_thuc_module_4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "giao_dich")
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maGiaoDich;
    private LocalDate ngayGiaoDich;
    private boolean loaiGiaoDich;
    private double donGia;
    private double dienTich;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;
}
