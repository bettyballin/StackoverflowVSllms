import java.lang.String;
public class EmailValidator_2 {
    // Simple example using regex for whitelist validation
    public boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
    }

    public static void main(String[] args) {
    }
}