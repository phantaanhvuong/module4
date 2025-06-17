package com.example.tu_dien.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("Táo", "Apple");
        map.put("Cam", "Orange");
        map.put("Chuối", "Banana");
        map.put("Dưa Hấu", "Watermelon");
        map.put("Xoài", "Mango");
    }


    @Override
    public String findByKey(String string) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(string)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
