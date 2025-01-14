import java.lang.String;
// Example code demonstrating why security through obscurity might look and behave misleadingly secure
public class ObfuscatedSecurityExample {
    private static final String OBSCURED_PASSWORD = "bG9wZXNvY2xhbA=="; // Base64 of "lopesocla"

    public static void connectToDatabase() {
        String password = new String(java.util.Base64.getDecoder().decode(OBSCURED_PASSWORD));
        System.out.println("Connecting to database with password: " + password);
        // Insecure code for demonstration purposes
    }

	public static void main(String[] args) {
	}
}