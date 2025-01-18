import java.lang.String;
import java.lang.Integer;
import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        // Get console object
        Console c = System.console();

        if (c != null) {
            // Input a string and display the result of the entered line
            String inputLine = c.readLine("Enter something here :");
            System.out.println(inputLine);

            // Enter an integer value from user
            int number = Integer.parseInt(c.readLine("Enter an integer :"));
            System.out.println("Entered integer is: "+number);
        } else {
            throw new RuntimeException("No console available.");
        }
    }
}