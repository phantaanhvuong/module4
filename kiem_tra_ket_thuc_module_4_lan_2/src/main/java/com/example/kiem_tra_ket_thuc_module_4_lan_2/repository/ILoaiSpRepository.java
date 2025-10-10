package com.example.kiem_tra_ket_thuc_module_4_lan_2.repository;

import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.LoaiSanPham;
import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoaiSpRepository extends JpaRepository<LoaiSanPham,Long> {
}
