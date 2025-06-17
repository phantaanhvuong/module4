package com.example.tu_dien.service;

import com.example.tu_dien.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String findByKey(String string) {
        return dictionaryRepository.findByKey(string);
    }
}
