package com.SpringBoot.journalApp.Services;

import com.SpringBoot.journalApp.Repository.JournalEntryRepo;
import com.SpringBoot.journalApp.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo entryRepo;

    public void saveEntry(JournalEntry jEntry){
        entryRepo.save(jEntry);
    }

    public List<JournalEntry> getAll() {
        return entryRepo.findAll();
    }
}
