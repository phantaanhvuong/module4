package com.example.quan_ly_heo.service;

import com.example.quan_ly_heo.entity.Product;
import com.example.quan_ly_heo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<Product> search(String name, String nameType, Pageable pageable) {
        return productRepository.search(name,nameType,pageable);
    }

    @Override
    public void add(Product product) {
        if (product.getId() == null || findById(product.getId()).isEmpty()){
            productRepository.save(product);
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void edit(Product product, Long id) {
        if (findById(id).isPresent()){
            product.setId(id);
            productRepository.save(product);
        }
    }
}
