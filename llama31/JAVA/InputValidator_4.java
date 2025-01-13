import java.util.Arrays;

public class InputValidator_4_4 {
    public static void main(String[] args) {
        // Assuming you have a String variable 'selectedValue' from the request
        String selectedValue = "value4"; // Example value
        String[] expectedValues = {"value1", "value2", "value3"}; // Define your expected values

        if (!Arrays.asList(expectedValues).contains(selectedValue)) {
            // Handle invalid input, e.g., throw an exception or return an error
            System.out.println("Invalid input: " + selectedValue);
        } else {
            System.out.println("Valid input: " + selectedValue);
        }
    }
}