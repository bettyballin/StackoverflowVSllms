public class InputValidator_1 {
    private String emailPattern;
    
    public InputValidator_1(String locale) {
        // Load pattern from a resource such as properties file based on locale
        this.emailPattern = getPatternFromConfig(locale);
    }
    
    private String getPatternFromConfig(String locale) {
        // Method to load pattern from configuration
        return ""; // Return a default pattern or load from config
    }
    
    public boolean isValidEmail(String email) {
        return email.matches(emailPattern);
    }

    public static void main(String[] args) {
    }
}