// Define the SSN class for demonstration purposes
class SSN {
    private String number;

    public SSN(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

// Define a basic Validator interface
interface Validator {
    boolean supports(Class<?> clazz);
    void validate(Object obj, Errors errors);
}

// Define a basic Errors class for handling validation errors
class Errors {
    public void rejectValue(String field, String errorCode, String defaultMessage) {
        System.out.println("Validation error in field: " + field + ", with error code: " + errorCode + ", and message: " + defaultMessage);
    }
}

public class SsnValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return SSN.class.equals(clazz);
    }
    
    public void validate(Object obj, Errors errors) {
        SSN ssn = (SSN) obj;
        if (!isValid(ssn)) {
            errors.rejectValue("person.ssn", "invalid.ssn.reason", "Invalid SSN reason");
        }
    }
    
    private boolean isValid(SSN ssn) {
        // Example validation logic: SSN must be 9 digits long
        return ssn.getNumber().matches("\\d{9}");
    }

    public static void main(String[] args) {
        SSN testSsn = new SSN("123456789");
        SsnValidator validator = new SsnValidator();
        Errors errors = new Errors();
        
        if (validator.supports(SSN.class)) {
            validator.validate(testSsn, errors);
        }
    }
}