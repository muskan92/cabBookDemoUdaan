package com.abhijith.pradeep.demo.controller;

import com.abhijith.pradeep.demo.entry.Player;
import com.abhijith.pradeep.demo.entry.User;
import com.abhijith.pradeep.demo.manager.PlayerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/player/{playerId}")
public class PlayerController {

    @Autowired
    private PlayerManager playerManager;

    @PutMapping(path = "/score")
    public Player updateScore(@PathVariable("playerId") String playerId, @RequestBody Player player) {
        return playerManager.updatePlayerScore(playerId, player.getScore());
    }

}
