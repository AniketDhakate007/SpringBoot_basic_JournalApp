package com.SpringBoot.journalApp.controller;

import com.SpringBoot.journalApp.Services.JournalEntryService;
import com.SpringBoot.journalApp.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        JournalEntryServ.saveEntry(myentry);
        return myentry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long myId) {
        return null;
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry removeEntryById(@PathVariable Long myId) {
        return null;
    }

    @PutMapping("/id/{myId}")
    public JournalEntry updateById(@PathVariable Long myId,@RequestBody JournalEntry myEntry) {
        return null;
    }
}

