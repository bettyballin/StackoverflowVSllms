import java.lang.String;
import java.io.Console;

public class SecureInput {
    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            char[] password = console.readPassword("Enter password: ");
            // Use the password
        } else {
            System.out.println("Console not available");
        }
    }
}