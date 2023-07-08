package com.example.second_service;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/second-service")
public class SecondServiceController {
    private final Environment environment;

    public SecondServiceController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return String.format("secret : %s",
                environment.getProperty("secret"));
    }
}
