package com.eccco.floki.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HealthController {

    @GetMapping("/healthz")
    public ResponseEntity<HashMap<String, String>> ping() {
        HashMap<String, String> health = new HashMap<>();

        health.put("status", "healthy");

        return new ResponseEntity<>(health, HttpStatus.OK);
    }
}
