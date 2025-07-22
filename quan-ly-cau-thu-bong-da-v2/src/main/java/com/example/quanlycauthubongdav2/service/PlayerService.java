package com.example.quanlycauthubongdav2.service;

import com.example.quanlycauthubongdav2.entity.Player;
import com.example.quanlycauthubongdav2.repository.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;

    @Override
    public Page<Player> findByName(String name, Pageable pageable) {
        return playerRepository.search(name, pageable);
    }

    @Override
    public void addOrUpdate(Player player) {
        playerRepository.save(player);
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
