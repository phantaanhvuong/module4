package com.example.kiem_tra_ket_thuc_module_4.service;

import com.example.kiem_tra_ket_thuc_module_4.entity.GiaoDich;
import com.example.kiem_tra_ket_thuc_module_4.repository.IGiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiaoDichService implements IGiaoDichService {
    @Autowired
    private IGiaoDichRepository giaoDichRepository;

    @Override
    public Page<GiaoDich> searchGiaoDich(String maKhachHang, String loaiGiaoDich, Pageable pageable) {
        return giaoDichRepository.searchGiaoDich(maKhachHang,loaiGiaoDich,pageable);
    }

    @Override
    public void add(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    @Override
    public void remove(Long id) {
        giaoDichRepository.deleteById(id);
    }

    @Override
    public Optional<GiaoDich> findById(Long id) {
        return giaoDichRepository.findById(id);
    }
}
