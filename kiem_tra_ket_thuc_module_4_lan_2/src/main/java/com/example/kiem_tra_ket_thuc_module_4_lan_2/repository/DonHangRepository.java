package com.example.kiem_tra_ket_thuc_module_4_lan_2.repository;

import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.DonHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang,Long> {
}
