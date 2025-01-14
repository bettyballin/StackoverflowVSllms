import java.lang.String;
import java.util.Scanner;

public class ConsoleClearExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            
            // Process the command here
            processCommand(command);
            
            // Clear the console screen by printing new lines (not ideal, but works in many cases)
            clearScreen();
        }
    }

    private static void processCommand(String command) {
        // This is where you would handle different commands
        System.out.println("Output of " + command + " goes here.");
    }

    // This method attempts to clear the console screen
    public static void clearScreen() {
        // Try to clear the screen using system dependent commands
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            // Handle any exceptions.
            System.out.println(e.getMessage());
        }
    }
}