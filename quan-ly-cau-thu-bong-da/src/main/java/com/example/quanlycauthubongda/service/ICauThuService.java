package com.example.quanlycauthubongda.service;

import com.example.quanlycauthubongda.entity.CauThu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICauThuService {
    Page<CauThu> findByTen(String ten , Pageable pageable);
    void addOrUpdate(CauThu cauThu);
    Optional<CauThu> findById(Long id);
    void deleteById(Long id);
}
