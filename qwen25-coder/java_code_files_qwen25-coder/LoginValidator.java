public class LoginValidator {
    public String validateUser(String username, String password) {
        if (!isValidUsername(username)) {
            return "Invalid username or password.";
        }
        
        if (!isCorrectPassword(username, password)) {
            return "Invalid username or password.";
        }
        
        return "Login successful.";
    }
    
    private boolean isValidUsername(String username) {
        // Logic to check if the username exists in your database
        return true; // Simplified for example purposes
    }
    
    private boolean isCorrectPassword(String username, String password) {
        // Logic to check if the password matches the one stored in your database
        return true; // Simplified for example purposes
    }
    
    public static void main(String[] args) {
    }
}