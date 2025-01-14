import java.lang.String;
public class UserModel_1 {
    private String email;
    private String password;

    // Getters and setters...

    public boolean isValid() {
        return isValidEmail(this.email) && isValidPassword(this.password);
    }

    private boolean isValidEmail(String email) {
        // Simple regex for example
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private boolean isValidPassword(String password) {
        // Example rule: Password must be at least 8 characters long
        return password.length() >= 8;
    }

	public static void main(String[] args) {
	}
}