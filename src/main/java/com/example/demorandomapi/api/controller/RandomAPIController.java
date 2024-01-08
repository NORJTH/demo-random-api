package com.example.demorandomapi.api.controller;

import com.example.demorandomapi.api.model.UserResults;
import com.example.demorandomapi.service.RandomAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/v1")
public class RandomAPIController {
    private final RandomAPIService service;

    @Autowired
    public RandomAPIController(RandomAPIService service) {
        this.service = service;
    }

    @GetMapping("/users/{seed}")
    public UserResults getRandomUserApi(@PathVariable String seed) {
        return service.getRandomUser(seed);
    }
}
