package com.example.demo.controller;

import com.example.demo.manager.DemoManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// New Project -> Web + Lombok

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DemoController {
    private final DemoManager manager;

    @GetMapping("/counter")
    public long getCounter() {
        return manager.getCounter();
    }

    @PostMapping("/counter")
    public void incrementCounter() {
        manager.incrementCounter();
    }
}
