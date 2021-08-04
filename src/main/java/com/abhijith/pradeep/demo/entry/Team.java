package com.abhijith.pradeep.demo.entry;

import java.util.List;

public class Team {

    private String teamId;
    private List<Player> players;
    private Integer netScore;

    public Team(String teamId, List<Player> players, Integer netScore) {
        this.teamId = teamId;
        this.players = players;
        this.netScore = netScore;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Integer getNetScore() {
        return netScore;
    }

    public void setNetScore(Integer netScore) {
        this.netScore = netScore;
    }


}
