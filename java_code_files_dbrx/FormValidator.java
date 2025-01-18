public class FormValidator {
    // Basic example of validating a form value in Java:
    public void checkString(String input){
        if (!isValidLength(input)) { // A method to validate length, for eg., 0-50 characters
            throw new IllegalArgumentException("Invalid length.");
        } else if (containsSQLInjectionCharacter(input)){ // Method to check SQL vulnerabilities
             throw new IllegalArgumentException("SQL injection detected");
        } else if (containsXSSChars(input)) { // Check for XSS vulnerability chars in input
            throw new IllegalArgumentException("Possible XSS detected.");
        }
    }

    private boolean isValidLength(String input) {
        return input.length() >= 0 && input.length() <= 50;
    }

    private boolean containsSQLInjectionCharacter(String input) {
        // Check for common SQL injection characters
        String[] sqlInjectionChars = {"'", "\"", ";", "--", "/*", "*/", "xp_"};
        for (String ch : sqlInjectionChars) {
            if (input.contains(ch)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsXSSChars(String input) {
        // Check for common XSS vulnerability characters
        String[] xssChars = {"<", ">", "\"", "'", "%", "&", ";"};
        for (String ch : xssChars) {
            if (input.contains(ch)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FormValidator validator = new FormValidator();
        validator.checkString("Your test input here");
    }
}