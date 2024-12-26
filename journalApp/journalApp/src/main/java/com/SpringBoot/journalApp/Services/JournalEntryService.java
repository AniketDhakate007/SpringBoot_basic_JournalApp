package com.SpringBoot.journalApp.Services;

import com.SpringBoot.journalApp.Repository.JournalEntryRepo;
import com.SpringBoot.journalApp.entity.JournalEntry;
import com.SpringBoot.journalApp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo entryRepo;

    @Autowired
    private UserService userService;

    public void saveEntry(JournalEntry jEntry, String userName){
           try {
               User user = userService.findByUsername(userName);
               jEntry.setDate(LocalDateTime.now());
               JournalEntry saved = entryRepo.save(jEntry);
               user.getJournalEntries().add(saved);
               userService.saveUser(user);
           }
           catch(Exception e){
               System.out.println(e);
               throw new RuntimeException("An error occurred while saving entry : ",e);
           }
    }
    public void saveEntry(JournalEntry jEntry){
        entryRepo.save(jEntry);
    }

    public List<JournalEntry> getAll() {
        return entryRepo.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return entryRepo.findById(id);
    }

    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUsername(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed){
                userService.saveUser(user);
                entryRepo.deleteById(id);
            }
        }
        catch (Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occurred while deleting the entry : ",e);
        }
        return removed;
    }
}
