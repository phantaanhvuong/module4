package com.example.quan_ly_san_pham_thymeleaf.service;

import com.example.quan_ly_san_pham_thymeleaf.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void remove(int id);
}
