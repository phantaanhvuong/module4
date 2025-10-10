package com.example.quan_ly_heo.service;

import com.example.quan_ly_heo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> search(String name, String nameType , Pageable pageable);
    void add(Product product);
    Optional<Product> findById(Long id);
    void deleteById(Long id);
    void edit(Product product,Long id);
}
