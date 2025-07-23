package com.example.bong_da_v3.service;

import com.example.bong_da_v3.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IPlayerService {
    Page<Player> search(String name ,String nameLocation, Pageable pageable);

    Optional<Player> findById(Long id);
    void deleteById(Long id);
    void add(Player player);
    void edit(Player player,Long id);
}
