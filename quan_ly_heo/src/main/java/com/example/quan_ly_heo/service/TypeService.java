package com.example.quan_ly_heo.service;

import com.example.quan_ly_heo.entity.Product;
import com.example.quan_ly_heo.entity.Type;
import com.example.quan_ly_heo.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository typeRepository;


    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }
}
