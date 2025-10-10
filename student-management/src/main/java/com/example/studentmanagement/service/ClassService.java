package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.AClass;
import com.example.studentmanagement.repository.IClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService {
    @Autowired
    private IClassRepository typeRepository;


    @Override
    public List<AClass> findAll() {
        return typeRepository.findAll();
    }
}
