import java.lang.String;
// Secure coding practice: Input validation
public class SecureInputValidator {
    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        // Additional validation logic can be added here
    }

	public static void main(String[] args) {
	}
}