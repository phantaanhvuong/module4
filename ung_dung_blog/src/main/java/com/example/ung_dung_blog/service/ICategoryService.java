package com.example.ung_dung_blog.service;

import com.example.ung_dung_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void save(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);
}
