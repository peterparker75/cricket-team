package com.example.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.player.service.PlayerJpaService;
import com.example.player.model.Player;

import java.util.*;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerJpaService playerService;

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @GetMapping("/{playerId}")
    public Player getPlayerById(@PathVariable int playerId) {
        return playerService.getPlayerById(playerId);
    }

    @PutMapping("/{playerId}")
    public Player updatePlayer(@PathVariable int playerId, @RequestBody Player player) {
        Player existingPlayer = playerService.getPlayerById(playerId);
        existingPlayer.setPlayerName(player.getPlayerName());
        existingPlayer.setJerseyNumber(player.getJerseyNumber());
        existingPlayer.setRole(player.getRole());
        return playerService.savePlayer(existingPlayer);
    }

    @DeleteMapping("/{playerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable int playerId) {
        playerService.deletePlayer(playerId);
    }
}
