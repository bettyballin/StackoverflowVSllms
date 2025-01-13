import java.lang.String;

public class UserInputValidator {

    public static void main(String[] args) {
        // Validate user input
        String userInput = null; // request.getParameter("username") is not valid in this context, as this is not a servlet.
        if (userInput == null || userInput.isEmpty()) {
            // Handle invalid input
            System.out.println("Invalid input");
        } else {
            // Sanitize user input
            String sanitizedInput = userInput.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println(sanitizedInput);
        }
    }
}