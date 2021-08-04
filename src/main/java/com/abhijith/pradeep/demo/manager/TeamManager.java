package com.abhijith.pradeep.demo.manager;

import com.abhijith.pradeep.demo.data.TeamDb;
import com.abhijith.pradeep.demo.entry.Player;
import com.abhijith.pradeep.demo.entry.PlayerType;
import com.abhijith.pradeep.demo.entry.Team;
import com.abhijith.pradeep.demo.exceptions.InvalidTeamException;
import com.abhijith.pradeep.demo.exceptions.TeamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TeamManager {

    private static Integer TEAM_PLAYER_COUNT = 11;
    private static Integer MIN_BOWLER_COUNT = 3;
    private static Integer MIN_BATSMAN_COUNT = 3;
    private static Integer MIN_WICKET_KEEPER_COUNT = 1;
    private static Integer MAX_CREDIT_FOR_TEAM = 100;

    @Autowired
    private TeamDb teamDb;

    @Autowired
    private PlayerManager playerManager;

    public void createTeam(String teamId, List<String> playerIds) {
        Set<Player> players =  playerIds.stream().distinct().map(playerManager::getPlayer).collect(Collectors.toSet());
        validateTeam(players);
        teamDb.updateOrInsertTeam(teamId, playerIds.stream().distinct().collect(Collectors.toList()));
    }

    public Team getTeam(String teamId) {
        List<String> playerIds = teamDb.getTeam(teamId);
        if(playerIds == null) {
            throw new TeamNotFoundException("team not found");
        }
        List<Player> players = playerIds.stream().map(playerManager::getPlayer).collect(Collectors.toList());
        Integer netScore = players.stream().mapToInt(Player::getScore).sum();
        return new Team(teamId, players, netScore);
    }

    public Team updateTeam(String teamId, List<String> newPlayers, List<String> playersToBeRemoved) {

    }

    private void validateTeam(Set<Player> players) {
        if(players.size() != TEAM_PLAYER_COUNT) {
            throw new InvalidTeamException("playerId Should be :" + TEAM_PLAYER_COUNT);
        }
        if(players.stream().filter(pl -> pl.getPlayerType().equals(PlayerType.BOWLER)).count() < MIN_BOWLER_COUNT) {
            throw new InvalidTeamException("Min bowler count not met");
        }
        if(players.stream().filter(pl -> pl.getPlayerType().equals(PlayerType.BATSMAN)).count() < MIN_BATSMAN_COUNT) {
            throw new InvalidTeamException("min batsmancount not met");
        }
        if(players.stream().filter(pl -> pl.getPlayerType().equals(PlayerType.WICKET_KEEPER)).count() < MIN_WICKET_KEEPER_COUNT) {
            throw new InvalidTeamException("min player count not met");
        }
        if(players.stream().mapToInt(pl -> pl.getCreditValue()).sum() > MAX_CREDIT_FOR_TEAM) {
            throw new InvalidTeamException("Team too costly");
        }
    }
}
