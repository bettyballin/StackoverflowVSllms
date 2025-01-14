import java.util.ArrayList;
import java.util.List;

class ValidationError {
    private String field;
    private String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    // Getters and toString for display purposes
}

public class InputValidator_2 {

    public List<ValidationError> validateUserInput(String username, String ageString) {
        List<ValidationError> errors = new ArrayList<>();

        if (username == null || username.length() < 3) {
            errors.add(new ValidationError("username", "Username must be at least 3 characters long."));
        }

        try {
            int age = Integer.parseInt(ageString);
            if (age < 0 || age > 120) {
                errors.add(new ValidationError("age", "Age must be between 0 and 120 years old."));
            }
        } catch (NumberFormatException e) {
            errors.add(new ValidationError("age", "Invalid age format. Please enter a number."));
        }

        return errors;
    }

    public static void main(String[] args) {
    }
}