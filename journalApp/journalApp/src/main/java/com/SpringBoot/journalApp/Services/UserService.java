package com.SpringBoot.journalApp.Services;

import com.SpringBoot.journalApp.Repository.UserRepo;
import com.SpringBoot.journalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component

public class UserService {
    @Autowired
    private UserRepo userRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public void saveNewUser(User user){
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       user.setRoles(Arrays.asList("USER"));
        userRepo.save(user);
    }
    public void saveUser(User user){
        userRepo.save(user);
    }
    public List<User> getAll() {
        return userRepo.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepo.deleteById(id);
    }

    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
}
