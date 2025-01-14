import java.lang.String;

public class AlphaNumericValidator {
    // Using regular expressions for basic validation (example: AlphaNumeric only)
    public boolean isValid(String input) {
        return input.matches("[a-zA-Z0-9]*");
    }

    public static void main(String[] args) {
    }
}