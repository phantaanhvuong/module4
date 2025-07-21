package com.example.quanlycauthubongda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cau_thu")
public class CauThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maCauThu;
    private String ten;
    private LocalDate ngaySinh;
    private String kinhNghiem;
    private String hinhAnh;
    @ManyToOne
    @JoinColumn(name = "vi_tri_id")
    private ViTri viTri;
}
