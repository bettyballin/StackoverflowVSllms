import java.lang.String;

public class InputValidator_1_1 {
    // Validate user input on server-side
    public static void main(String[] args) {
        // Assuming request is an HttpServletRequest object
        // For demonstration purposes, we'll use a mock array instead
        String[] fields = {"field1", "field2", "field3"};
        
        for (String field : fields) {
            // Validate field value
            if (!isValid(field)) {
                // Handle invalid input
                System.out.println("Invalid input: " + field);
            } else {
                System.out.println("Valid input: " + field);
            }
        }
    }

    // Define a simple validation method
    public static boolean isValid(String field) {
        // Implement your validation logic here
        // For example, let's assume a field is valid if it's not empty
        return field != null && !field.isEmpty();
    }
}