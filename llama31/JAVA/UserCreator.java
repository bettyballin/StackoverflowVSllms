import java.lang.String;

class PasswordGenerator {
    public static String generatePassword(int length) {
        String password = "";
        for (int i = 0; i < length; i++) {
            password += (char) ((Math.random() * 26) + 'a');
        }
        return password;
    }
}

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}

public class UserCreator {
    public static void main(String[] args) {
        // Generate a random password for the admin user
        String adminPassword = PasswordGenerator.generatePassword(12);

        // Create the admin user with the generated password
        User adminUser = new User("admin", adminPassword, "admin@example.com");
        
        // Print the generated password and admin user details
        System.out.println("Generated Password: " + adminPassword);
        System.out.println("Admin User: " + adminUser.username);
        System.out.println("Admin Email: " + adminUser.email);
    }
}