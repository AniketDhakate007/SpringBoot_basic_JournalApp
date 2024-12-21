package com.SpringBoot.journalApp.Repository;

import com.SpringBoot.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry,String> {

}
