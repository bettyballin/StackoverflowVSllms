import java.lang.String;
import java.io.Console;
import java.util.Scanner;

public class MyApp_4 {
    public static void main(String[] args) {
        Console console = System.console();
        
        if (console != null) {
            // Use the console for input/output
            String password = new String(console.readPassword("Enter your secret: "));
            console.format("Password read successfully.%n");
        } else {
            // Fallback to using Scanner when no console is available
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your secret: ");
            String password = scanner.nextLine();
            System.out.println("Password read successfully.");
            scanner.close();
        }
    }
}