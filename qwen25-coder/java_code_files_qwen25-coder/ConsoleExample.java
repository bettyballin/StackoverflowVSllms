import java.lang.String;
import java.io.Console;

public class ConsoleExample {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available");
            return;
        }

        String username = console.readLine("Enter your username: ");
        char[] password = console.readPassword("Enter your password: ");

        // For demonstration purposes, convert char array to string and print.
        // In real applications, avoid converting passwords to strings to keep them secure.
        System.out.println("Username entered: " + username);
        System.out.println("Password length: " + password.length);

        // Clear the password from memory for security
        java.util.Arrays.fill(password, ' ');
    }
}