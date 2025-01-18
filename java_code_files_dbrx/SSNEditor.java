import java.beans.PropertyEditorSupport;

public class SSNEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            // your validation and conversion logic here or delegate it to an external validator.
            String errorReason = "Invalid format"; // Placeholder for the error reason
            if (false /* some condition fails */) {
                throw new InvalidSsnException("Invalid social security number: " + errorReason);
            }
            // Successful conversion and setting the value using super's setValue().
            this.setValue(convertTextToSSN(text));
        } catch (IllegalArgumentException e) {
            throw new InvalidSsnException("Invalid social security number", e);
        }
    }

    private Object convertTextToSSN(String text) {
        // Placeholder for conversion logic
        return text; // Return the text as is for now
    }
}

class InvalidSsnException extends IllegalArgumentException {
    public InvalidSsnException(String message) {
        super(message);
    }

    public InvalidSsnException(String message, Throwable cause) {
        super(message, cause);
    }
}