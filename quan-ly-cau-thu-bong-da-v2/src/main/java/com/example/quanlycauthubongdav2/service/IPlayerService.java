package com.example.quanlycauthubongdav2.service;

import com.example.quanlycauthubongdav2.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPlayerService {
    Page<Player> findByName(String name , Pageable pageable);
    void addOrUpdate(Player player);
    Optional<Player> findById(Long id);
    void deleteById(Long id);
}
