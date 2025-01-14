package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController_1 {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}