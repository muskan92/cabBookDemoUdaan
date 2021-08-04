package com.abhijith.pradeep.demo.data;

import com.abhijith.pradeep.demo.entry.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserDb {

    private Map<String, User> userIdToUserMap = new ConcurrentHashMap<>();

    public User getUser(String userId) {
        return userIdToUserMap.get(userId);
    }

    public boolean addUser(User user) {
        if(user.getUserId() == null) {
            throw new NullPointerException("User Id cannot be null");
        }
        userIdToUserMap.putIfAbsent(user.getUserId(), user);
        return true;
    }

}
