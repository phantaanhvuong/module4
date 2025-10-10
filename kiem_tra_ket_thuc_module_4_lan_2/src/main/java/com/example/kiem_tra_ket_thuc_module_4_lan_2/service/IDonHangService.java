package com.example.kiem_tra_ket_thuc_module_4_lan_2.service;

import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IDonHangService {
    Page<DonHang> findAll(Pageable pageable);
    Optional<DonHang> findById(Long id);
    void edit(DonHang donHang,Long id);

}
