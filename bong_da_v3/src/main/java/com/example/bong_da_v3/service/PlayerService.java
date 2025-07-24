package com.example.bong_da_v3.service;

import com.example.bong_da_v3.entity.Player;
import com.example.bong_da_v3.repository.IPlayerRepository;
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
    public Page<Player> search(String name,String nameLocation, Pageable pageable) {
        return playerRepository.search(name, nameLocation,pageable);
    }


    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void add(Player player) {
        if (player.getId() == null || findById(player.getId()).isEmpty()){
            playerRepository.save(player);
        }
    }

    @Override
    public void edit(Player player, Long id) {
        if (findById(id).isPresent()){
            player.setId(id);
            playerRepository.save(player);
        }
    }

    @Override
    public long countByStatus(String status) {
        return playerRepository.countByStatus(status);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);

    }
}
