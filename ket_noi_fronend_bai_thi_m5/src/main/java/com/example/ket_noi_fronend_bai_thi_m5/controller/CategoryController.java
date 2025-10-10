package com.example.ket_noi_fronend_bai_thi_m5.controller;

import com.example.ket_noi_fronend_bai_thi_m5.entity.Category;
import com.example.ket_noi_fronend_bai_thi_m5.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
