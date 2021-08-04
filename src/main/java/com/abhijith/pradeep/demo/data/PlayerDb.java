package com.abhijith.pradeep.demo.data;

import com.abhijith.pradeep.demo.entry.Player;
import com.abhijith.pradeep.demo.entry.PlayerType;
import com.abhijith.pradeep.demo.exceptions.PlayerNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PlayerDb {

    private Map<String, Player> idToPlayerMap = new ConcurrentHashMap<>();

    public PlayerDb() {
        idToPlayerMap.put("kohli", new Player("kohli", "virat", 10, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli2", new Player("kohli", "virat", 1, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli3", new Player("kohli", "virat", 3, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli4", new Player("kohli", "virat", 20, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli5", new Player("kohli", "virat", 1, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli6", new Player("kohli", "virat", 99, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli7", new Player("kohli", "virat", 1, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli8", new Player("kohli", "virat", 1, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli9", new Player("kohli", "virat", 1, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli10", new Player("kohli", "virat", 1, PlayerType.BATSMAN));
        idToPlayerMap.put("kohli11", new Player("kohli", "virat", 1, PlayerType.WICKET_KEEPER));
        idToPlayerMap.put("kohli12", new Player("kohli", "virat", 1, PlayerType.BOWLER));
        idToPlayerMap.put("kohli13", new Player("kohli", "virat", 1, PlayerType.BOWLER));
        idToPlayerMap.put("kohli14", new Player("kohli", "virat", 1, PlayerType.BOWLER));
    }

    public Player getPlayer(String playerId) {
        return idToPlayerMap.get(playerId);
    }

    public Player updatePlayer(String playerId, Integer score) {
        Player player = idToPlayerMap.get(playerId);
        player.setScore(score);
        return player;
    }
}
