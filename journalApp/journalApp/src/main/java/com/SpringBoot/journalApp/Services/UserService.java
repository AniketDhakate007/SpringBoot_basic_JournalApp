package com.SpringBoot.journalApp.Services;

import com.SpringBoot.journalApp.Repository.UserRepo;
import com.SpringBoot.journalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void saveEntry(User user){
        try {
            userRepo.save(user);
        }
        catch (Exception e){
            log.error("Exception ",e);
        }
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
