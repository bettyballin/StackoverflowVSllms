// Import statement is unnecessary as java.lang is imported by default
public class User_37_37 {
    private String name;
    private String email;

    public User_37(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        // Added code to test the User_37 class
        User_37 user = new User_37("John Doe", "john.doe@example.com");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }
}