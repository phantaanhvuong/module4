package com.example.bai_tap_gio_hang.service;

import com.example.bai_tap_gio_hang.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}