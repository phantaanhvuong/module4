package com.example.ungdungnghenhac.service;

import com.example.ungdungnghenhac.model.BaiHat;

import java.util.List;

public interface IBaiHatService {
    List<BaiHat> findAll();

    void addOrUpdate(BaiHat baiHat);

    BaiHat findById(int id);
}
