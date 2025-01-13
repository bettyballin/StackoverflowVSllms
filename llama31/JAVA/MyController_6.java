package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Assuming MyService is in the same package
class MyService {}

@Controller
public class MyController_6_6 {
    private MyService myService;
    
    public void setMyService(MyService myService) {
        this.myService = myService;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String handleGet() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}