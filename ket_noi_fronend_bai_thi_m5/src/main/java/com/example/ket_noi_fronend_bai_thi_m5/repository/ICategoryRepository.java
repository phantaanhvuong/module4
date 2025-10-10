package com.example.ket_noi_fronend_bai_thi_m5.repository;

import com.example.ket_noi_fronend_bai_thi_m5.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
