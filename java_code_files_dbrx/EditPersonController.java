import java.lang.String;

public class EditPersonController extends SimpleFormController {

    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException bindException) throws Exception {

        //... validate and other business logic.

        try {

            super.onBindAndValidate(request, command, bindException);

        } catch (InvalidSsnException ex) {

            if (command instanceof EditPersonCommand) {

                EditPersonCommand editCmd = (EditPersonCommand) command;

                // Here we pass the specific exception message to our form-backing model.

                // This would let us have access to it later on while constructing final error messages in view layer.

                bindException.reject("ssn", ex.getMessage(), "Invalid social security number");

            }

            throw ex;

        }

    }

    public static void main(String[] args) {

    }

}

class SimpleFormController {

    protected void onBindAndValidate(HttpServletRequest request, Object command, BindException bindException) throws Exception {
        // Base method
    }

}

interface HttpServletRequest {
    // Interface methods
}

class BindException extends Exception {
    public void reject(String errorCode, String defaultMessage, String errorMessage) {
        // Implementation
    }
}

class InvalidSsnException extends Exception {
    public InvalidSsnException(String message) {
        super(message);
    }
}

class EditPersonCommand {
    // Implementation
}