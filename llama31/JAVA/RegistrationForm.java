// RegistrationForm.java

// Define a custom exception class
class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

public class RegistrationForm {
    private int attendees;

    public void register(int attendees) throws InvalidInputException {
        if (attendees < 1 || attendees > 10) {
            throw new InvalidInputException("Attendees must be between 1 and 10");
        }
        // Process valid input...
    }

    public static void main(String[] args) {
        RegistrationForm form = new RegistrationForm();
        try {
            form.register(5); // Test with valid input
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}