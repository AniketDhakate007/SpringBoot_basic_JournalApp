package com.SpringBoot.journalApp.Services;

import com.SpringBoot.journalApp.Repository.JournalEntryRepo;
import com.SpringBoot.journalApp.entity.JournalEntry;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo entryRepo;

    public void saveEntry(JournalEntry jEntry){
        try {
            jEntry.setDate(LocalDateTime.now());
            entryRepo.save(jEntry);
        }
        catch (Exception e){
            log.error("Exception ",e);
        }

    }

    public List<JournalEntry> getAll() {
        return entryRepo.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id){
        return entryRepo.findById(id);
    }

    public void deleteById(ObjectId id){
        entryRepo.deleteById(id);
    }
}
