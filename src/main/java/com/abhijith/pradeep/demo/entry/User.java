package com.abhijith.pradeep.demo.entry;


import java.util.List;

public class User {
    private String userId;
    private String name;
    private Integer creditLeft = 100;
    private List<String> teamPlayerIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
