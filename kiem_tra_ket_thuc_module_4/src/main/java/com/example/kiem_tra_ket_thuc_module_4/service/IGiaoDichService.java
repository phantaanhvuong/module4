package com.example.kiem_tra_ket_thuc_module_4.service;

import com.example.kiem_tra_ket_thuc_module_4.entity.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGiaoDichService {
    Page<GiaoDich> searchGiaoDich(String maKhachHang, String loaiGiaoDich, Pageable pageable);
    void add(GiaoDich giaoDich);
    void remove(Long id);
    Optional<GiaoDich> findById(Long id);
}
