import java.lang.String;
import java.util.regex.Pattern;

// Define the custom exception class
class InvalidRequestException extends Exception {
    public InvalidRequestException(String message) {
        super(message);
    }
}

public class SortValidator {
    public static void main(String[] args) {
        // Simulate the request.getParameter("sort") method
        String sort = "field1:asc,field2:desc";

        // Move the validation code to a separate method
        validateSort(sort);
    }

    public static void validateSort(String sort) {
        String[] sortFields = sort.split(",");
        for (String field : sortFields) {
            String[] parts = field.split(":");
            if (parts.length != 2) {
                throw new RuntimeException("Invalid sort format");
            }
            String fieldName = parts[0];
            String direction = parts[1];
            if (!fieldName.matches("[a-zA-Z_][a-zA-Z_0-9]*") || !direction.matches("asc|desc")) {
                throw new RuntimeException("Invalid sort field or direction");
            }
            // Add the validated field and direction to your query
            System.out.println("Validated field: " + fieldName + ", direction: " + direction);
        }
    }
}