package com.example.kiem_tra_ket_thuc_module_4_lan_2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String maSanPham;
    private String name;
    private int gia;
    private String tinhTrang;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loai_sp_id")
    private LoaiSanPham loaiSanPham;


}
