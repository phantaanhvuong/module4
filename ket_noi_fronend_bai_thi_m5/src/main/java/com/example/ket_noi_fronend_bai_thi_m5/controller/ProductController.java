package com.example.ket_noi_fronend_bai_thi_m5.controller;

import com.example.ket_noi_fronend_bai_thi_m5.entity.Product;
import com.example.ket_noi_fronend_bai_thi_m5.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Cho phép frontend React gọi
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductRepository productRepository;

    @GetMapping
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
