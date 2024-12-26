package com.SpringBoot.journalApp.Repository;

import com.SpringBoot.journalApp.entity.JournalEntry;
import com.SpringBoot.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {

    void deleteByUsername(String userName);
    User findByUsername(String username);

}
