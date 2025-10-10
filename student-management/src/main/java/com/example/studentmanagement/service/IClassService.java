package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.AClass;

import java.util.List;

public interface IClassService {
    List<AClass> findAll();
}