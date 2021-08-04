package com.abhijith.pradeep.demo.manager;

import com.abhijith.pradeep.demo.data.PlayerDb;
import com.abhijith.pradeep.demo.entry.Player;
import com.abhijith.pradeep.demo.exceptions.PlayerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerManager {

    @Autowired
    private PlayerDb playerDb;

    public Player getPlayer(String playerId) {
        Player player = playerDb.getPlayer(playerId);
        if(player == null) {
            throw new PlayerNotFoundException("player not found");
        }
        return player;
    }

    public Player updatePlayerScore(String playerId, Integer score) {
        Player player = playerDb.getPlayer(playerId);
        if(player == null) {
            throw new PlayerNotFoundException("player not found");
        }
        return playerDb.updatePlayer(playerId, score);
    }
}
