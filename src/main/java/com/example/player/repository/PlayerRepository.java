package com.example.player.repository;

import com.example.player.model.Player;
import java.util.*;

public interface PlayerRepository {
    List<Player> getPlayers();

    Player getPlayerById(int playerId);

    Player savePlayer(Player player);

    void deletePlayer(int playerId);
}
