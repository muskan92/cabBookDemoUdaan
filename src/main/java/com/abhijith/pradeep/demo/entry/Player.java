package com.abhijith.pradeep.demo.entry;

import lombok.Builder;
import lombok.Data;


public class Player {

    private String id;
    private String name;
    private Integer creditValue;
    private PlayerType playerType;
    private Integer score;

    public Player(String id, String name, Integer creditValue, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.creditValue = creditValue;
        this.playerType = playerType;
        this.score = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
