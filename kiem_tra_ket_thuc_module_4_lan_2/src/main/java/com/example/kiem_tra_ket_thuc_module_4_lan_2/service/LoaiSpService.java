package com.example.kiem_tra_ket_thuc_module_4_lan_2.service;

import com.example.kiem_tra_ket_thuc_module_4_lan_2.entity.LoaiSanPham;
import com.example.kiem_tra_ket_thuc_module_4_lan_2.repository.ILoaiSpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSpService implements ILoaiSpService{
    @Autowired
    private ILoaiSpRepository loaiSpRepository;

    @Override
    public List<LoaiSanPham> findAll() {
        return loaiSpRepository.findAll();
    }
}
