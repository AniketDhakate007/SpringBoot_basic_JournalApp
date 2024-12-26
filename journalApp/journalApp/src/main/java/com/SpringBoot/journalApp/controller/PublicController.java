package com.SpringBoot.journalApp.controller;

import com.SpringBoot.journalApp.Services.UserService;
import com.SpringBoot.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/create_User")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }

}
