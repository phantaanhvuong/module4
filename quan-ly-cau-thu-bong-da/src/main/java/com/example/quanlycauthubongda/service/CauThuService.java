package com.example.quanlycauthubongda.service;

import com.example.quanlycauthubongda.entity.CauThu;
import com.example.quanlycauthubongda.repository.ICauThuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CauThuService implements ICauThuService {
    @Autowired
    private ICauThuRepository cauThuRepository;

    @Override
    public Page<CauThu> findByTen(String ten, Pageable pageable ){
        return cauThuRepository.search(ten,pageable);
    }

    @Override
    public void addOrUpdate(CauThu cauThu) {
        cauThuRepository.save(cauThu);
    }

    @Override
    public Optional<CauThu> findById(Long id) {
        return cauThuRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        cauThuRepository.deleteById(id);
    }

}
