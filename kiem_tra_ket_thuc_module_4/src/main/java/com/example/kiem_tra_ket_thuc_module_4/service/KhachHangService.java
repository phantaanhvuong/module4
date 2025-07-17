package com.example.kiem_tra_ket_thuc_module_4.service;

import com.example.kiem_tra_ket_thuc_module_4.entity.KhachHang;
import com.example.kiem_tra_ket_thuc_module_4.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService{
    @Autowired
    private IKhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }
}
