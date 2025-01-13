import java.lang.String;
import java.lang.Integer;
public class DefensiveProgrammingExample {
    public static void main(String[] args) {
        String userInput = getInputFromUser();

        // Validate user input
        if (userInput == null || userInput.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }

        try {
            // Attempt to parse user input
            int parsedInput = Integer.parseInt(userInput);

            // Perform action with validated input
            System.out.println("Parsed input: " + parsedInput);
        } catch (NumberFormatException e) {
            // Handle parsing error
            System.out.println("Invalid input format");
        }
    }

    private static String getInputFromUser() {
        // Simulate user input
        return "123";
    }
}