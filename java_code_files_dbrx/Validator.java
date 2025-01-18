public class Validator {
    public void validateFields() throws ValidatorException {
        final MultiFieldValidationException exceptions = new MultiFieldValidationException();

        if(field1IsInvalid()) {
            exceptions.addMessage(new FacesMessage("Error Message for field 1"));
        }

        if(field2IsInvalid()) {   // assuming field2 validation fails too...
            exceptions.addMessage(new FacesMessage("Error Message for field 2"));
        }

        throw exceptions;
    }

    private boolean field1IsInvalid() {
        // Placeholder implementation
        return true;
    }

    private boolean field2IsInvalid() {
        // Placeholder implementation
        return true;
    }

    public static void main(String[] args) {
        Validator validator = new Validator();
        try {
            validator.validateFields();
        } catch (ValidatorException e) {
            System.out.println("Validation Exception: " + e);
        }
    }
}

class MultiFieldValidationException extends ValidatorException {
    public MultiFieldValidationException() {
        super();
    }

    public void addMessage(FacesMessage message) {
        // Placeholder implementation
    }
}

class FacesMessage {
    public FacesMessage(String message) {
        // Placeholder implementation
    }
}

class ValidatorException extends Exception {
    public ValidatorException() {
        super();
    }

    public ValidatorException(String message) {
        super(message);
    }
}