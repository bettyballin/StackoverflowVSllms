package com.example;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "userController")
@RequestScoped
public class UserController_5 {
    private User user = new User();

    public String saveUser() {
        // Save user to database or service layer
        return "success.xhtml";  // Navigate to success page
    }

    // Getters and setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public static void main(String[] args) {
    }
}