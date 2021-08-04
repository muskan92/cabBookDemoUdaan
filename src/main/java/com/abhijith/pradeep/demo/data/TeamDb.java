package com.abhijith.pradeep.demo.data;

import com.abhijith.pradeep.demo.exceptions.TeamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class TeamDb {

    private Map<String, List<String>> teamIdToPlayerList = new ConcurrentHashMap<>();

    public void updateOrInsertTeam(String teamId, List<String> players) {
        teamIdToPlayerList.put(teamId, players);
    }

    public List<String> getTeam(String teamId) {
        if(!teamIdToPlayerList.containsKey(teamId)) {
            throw new TeamNotFoundException("team not found");
        }
        return teamIdToPlayerList.get(teamId);
    }

}
