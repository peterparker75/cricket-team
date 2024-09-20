package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.player.repository.PlayerJpaRepository;
import com.example.player.repository.PlayerRepository;
import com.example.player.model.Player;

@Service
public class PlayerJpaService implements PlayerRepository {
    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Override
    public List<Player> getPlayers() {
        return playerJpaRepository.findAll();
    }

    @Override
    public Player getPlayerById(int playerId) {
        return playerJpaRepository.findById(playerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Player savePlayer(Player player) {
        return playerJpaRepository.save(player);
    }

    @Override
    public void deletePlayer(int playerId) {
        if (!playerJpaRepository.existsById(playerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        playerJpaRepository.deleteById(playerId);
    }
}
