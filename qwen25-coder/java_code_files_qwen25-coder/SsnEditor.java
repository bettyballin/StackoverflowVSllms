import java.beans.PropertyEditorSupport;

public class SsnEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            SSN ssn = convertTextToSSN(text); // Implement your conversion logic
            setValue(ssn);
        } catch (InvalidSsnException ex) {
            throw ex; // Re-throw the specific exception
        } catch (Exception e) {
            throw new InvalidSsnException("Invalid SSN format", "invalid.ssn.format");
        }
    }

    private SSN convertTextToSSN(String text) throws InvalidSsnException {
        // Implement your conversion logic and validation here
        if (!text.matches("\\d{3}-?\\d{2}-?\\d{4}")) { // Example regex for SSN
            throw new InvalidSsnException("Invalid SSN format", "invalid.ssn.format");
        }
        // Further validation can be done here, e.g., checksum, etc.
        return new SSN(text); // Assuming SSN has a constructor that accepts a String
    }

    public static void main(String[] args) {
    }

}

class SSN {
    private String ssn;

    public SSN(String ssn) {
        this.ssn = ssn;
    }

    // Additional methods (e.g., getters, setters) can be added here
}

class InvalidSsnException extends IllegalArgumentException {
    private String errorCode;

    public InvalidSsnException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    // Getter for the error code
    public String getErrorCode() {
        return errorCode;
    }
}