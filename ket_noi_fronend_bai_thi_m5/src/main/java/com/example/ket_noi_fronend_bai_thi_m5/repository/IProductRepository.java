package com.example.ket_noi_fronend_bai_thi_m5.repository;

import com.example.ket_noi_fronend_bai_thi_m5.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
