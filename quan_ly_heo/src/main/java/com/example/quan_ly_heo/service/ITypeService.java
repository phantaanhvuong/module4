package com.example.quan_ly_heo.service;

import com.example.quan_ly_heo.entity.Product;
import com.example.quan_ly_heo.entity.Type;

import java.util.List;

public interface ITypeService{
    List<Type> findAll();
}