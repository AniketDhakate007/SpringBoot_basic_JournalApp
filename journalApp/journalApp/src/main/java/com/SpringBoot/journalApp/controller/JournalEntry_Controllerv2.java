package com.SpringBoot.journalApp.controller;

import com.SpringBoot.journalApp.Services.JournalEntryService;
import com.SpringBoot.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
class JournalEntry_Controllerv2 {

    @Autowired
    private JournalEntryService JournalEntryServ;

    @GetMapping
    public List<JournalEntry> getAll() {
        return JournalEntryServ.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myentry) {
        myentry.setDate(LocalDateTime.now());
        JournalEntryServ.saveEntry(myentry);
        return myentry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable ObjectId myId) {
        return JournalEntryServ.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean removeEntryById(@PathVariable ObjectId myId) {
        JournalEntryServ.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateById(@PathVariable ObjectId myId,@RequestBody JournalEntry myEntry) {
        myentry.setDate(LocalDateTime.now());
        JournalEntryServ.saveEntry(myentry);
        return myentry;
    }
}

