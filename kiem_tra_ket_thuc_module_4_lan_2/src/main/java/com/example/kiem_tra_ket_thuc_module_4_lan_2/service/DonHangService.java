package com.example.kiem_tra_ket_thuc_module_4_lan_2.service;

import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.DonHang;
import com.example.kiem_tra_ket_thuc_module_4_lan_2.repository.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonHangService implements IDonHangService{
    @Autowired
    private DonHangRepository donHangRepository;
    @Override
    public Page<DonHang> findAll(Pageable pageable) {
        return donHangRepository.findAll(pageable);
    }

    @Override
    public Optional<DonHang> findById(Long id) {
        return donHangRepository.findById(id);
    }

    @Override
    public void edit(DonHang donHang, Long id) {
        if (findById(id).isPresent()){
            donHang.setId(id);
            donHangRepository.save(donHang);
        }
    }
}
