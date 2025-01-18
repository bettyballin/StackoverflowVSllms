public class Main {

    public static void main(String[] args) {
        try {
            // validate and throw exception if validation fails
            //...
            throw new MissileTargetValidationException("Invalid missile target");
            //...
        } catch (ValidationException ex) {
            // display message to user indicating validation failure.
            System.out.println(ex.getMessage());
        }
    }
}

abstract class ValidationException extends Exception {
    // ...
}

class MissileTargetValidationException extends ValidationException {
    // contains relevant information why input was invalid (missing target etc.)

    public MissileTargetValidationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        // Provide detailed message
        return super.getMessage();
    }
}