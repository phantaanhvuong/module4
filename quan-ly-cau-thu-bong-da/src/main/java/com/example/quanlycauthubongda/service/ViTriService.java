package com.example.quanlycauthubongda.service;

import com.example.quanlycauthubongda.entity.ViTri;
import com.example.quanlycauthubongda.repository.ICauThuRepository;
import com.example.quanlycauthubongda.repository.IViTriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViTriService implements IViTriService{
    @Autowired
    private IViTriRepository viTriRepository;

    @Override
    public List<ViTri> findAll() {
        return viTriRepository.findAll();
    }
}
