package com.abhijith.pradeep.demo.manager;

import com.abhijith.pradeep.demo.data.UserDb;
import com.abhijith.pradeep.demo.entry.User;
import com.abhijith.pradeep.demo.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManager {

    @Autowired
    private UserDb userDb = new UserDb();

    public User getUser(String userId) {
        return userDb.getUser(userId);
    }

    public void addUser(User user) {
        try {
            userDb.addUser(user);
        }catch (Exception e) {
            throw new BadRequestException("the request is bad", e);
        }
    }

}
