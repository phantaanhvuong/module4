package com.example.kiem_tra_ket_thuc_module_4.service;

import com.example.kiem_tra_ket_thuc_module_4.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IKhachHangService {
    List<KhachHang> findAll();
}
