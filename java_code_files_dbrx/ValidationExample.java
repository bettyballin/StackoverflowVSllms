import java.util.Arrays;
import java.util.List;

public class ValidationExample {
    public static void main(String[] args) {
        List<String> allowedValues = Arrays.asList("Option1", "Option2");
        String submittedValue = "Option3"; // Example submitted value

        if (!allowedValues.contains(submittedValue)) {
            // Handle error or return a validation message to the user.
            System.out.println("Error: Invalid option selected.");
        }
        // Proceed with processing if submittedValue is valid.
        else {
            System.out.println("Proceeding with valid option: " + submittedValue);
        }
    }
}