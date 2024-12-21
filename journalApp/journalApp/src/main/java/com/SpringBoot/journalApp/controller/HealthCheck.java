package com.SpringBoot.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HealthCheck {
    @GetMapping("/health-check")
    String Check(){
        return "OK";
    }
}
