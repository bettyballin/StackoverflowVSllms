import java.util.ArrayList;
import java.util.List;

// ValidationException class
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

// ValidationService class
class ValidationService {
    public List<ValidationException> validate(Object input) {
        // Perform all validations, collect and return exceptions
        List<ValidationException> exceptions = new ArrayList<>();

        // Example validation logic (placeholder)
        // Add ValidationExceptions to the list if validations fail
        exceptions.add(new ValidationException("Validation error occurred."));

        return exceptions;
    }
}

// Validator class
class Validator {
    private ValidationService validationService = new ValidationService();

    public List<ValidationException> validateInputs(Object input) {
        return validationService.validate(input);
    }
}

// Main class to run the code
public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        List<ValidationException> errors = v.validateInputs(new Object());
        if (errors.isEmpty()) {
            // OK - fire missiles
            System.out.println("Missiles fired!");
        } else {
            // Display error messages and ask user to correct data
            for (ValidationException e : errors) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}