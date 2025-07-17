package com.example.kiem_tra_ket_thuc_module_4.repository;

import com.example.kiem_tra_ket_thuc_module_4.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IKhachHangRepository extends JpaRepository<KhachHang, Long> {
}
