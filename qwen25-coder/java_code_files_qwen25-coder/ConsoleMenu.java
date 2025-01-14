import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleMenu {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        
        try {
            while (true) {
                System.out.println("Console Menu:");
                System.out.println("1. Option 1");
                System.out.println("2. Option 2");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                
                choice = reader.readLine();
                
                switch (choice) {
                    case "1":
                        System.out.println("You selected Option 1.");
                        break;
                    case "2":
                        System.out.println("You selected Option 2.");
                        break;
                    case "3":
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}