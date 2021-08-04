package com.abhijith.pradeep.demo.controller;

import com.abhijith.pradeep.demo.entry.User;
import com.abhijith.pradeep.demo.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManager userManager;

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return userManager.getUser(userId);
    }

    @PutMapping(path = "/")
    public void addUser(@RequestBody User user) {
        userManager.addUser(user);
    }
}
