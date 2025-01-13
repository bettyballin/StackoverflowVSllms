import javax.servlet.http.HttpServletRequest;

// Simple Field class for demonstration
class Field {
    private String value;

    public Field(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

// Simple Validator interface for demonstration
interface Validator {
    boolean validate(Field field, HttpServletRequest request);
}

public class CustomValidator_2_2 implements Validator {
    @Override
    public boolean validate(Field field, HttpServletRequest request) {
        // Custom validation logic here, for example:
        return field.getValue() != null && !field.getValue().isEmpty();
    }

    public static void main(String[] args) {
        // Note: HttpServletRequest is typically managed by a web container.
        // For a command-line application, you cannot directly instantiate or use HttpServletRequest without a servlet container.
        // This main method is not suitable for testing the validate method in a non-web application context.
    }
}