import java.lang.String;

public class UserValidator {
    public static void main(String[] args) {
        String username = "";
        String password = "";
        
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Invalid input: username and password cannot be empty.");
        } else {
            System.out.println("Valid input: username and password are not empty.");
        }
    }
}