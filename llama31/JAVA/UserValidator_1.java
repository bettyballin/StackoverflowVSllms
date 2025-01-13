import java.lang.String;
public class UserValidator_1 {
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    public boolean isValidEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }

    // Add more validation methods as needed

	public static void main(String[] args) {
	}
}