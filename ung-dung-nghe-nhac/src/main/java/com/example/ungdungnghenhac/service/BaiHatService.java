package com.example.ungdungnghenhac.service;

import com.example.ungdungnghenhac.model.BaiHat;
import com.example.ungdungnghenhac.repository.IBaiHatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class BaiHatService implements IBaiHatService{
    @Autowired
    private IBaiHatRepository baiHatRepository;

    @Override
    public List<BaiHat> findAll() {
        return baiHatRepository.findAll();
    }

    @Override
    public void addOrUpdate(BaiHat baiHat) {
        baiHatRepository.save(baiHat);
    }

    @Override
    public BaiHat findById(int id) {
        return baiHatRepository.findById(id).orElse(null);
    }
}
