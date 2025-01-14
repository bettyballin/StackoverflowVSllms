import java.util.Map;
import java.util.HashMap;

// Example of a secure login system combining rate limiting and account recovery
public class SecureLoginSystem {
    public static final int ALLOWED_ATTEMPTS = 5;
    private long lockoutDuration = 300; // seconds (5 minutes)
    private Map<String, Account> accounts = new HashMap<>(); // Maps usernames to their accounts

    public boolean attemptLogin(String username, String pin) {
        if (!accounts.containsKey(username)) return false;

        Account account = accounts.get(username);
        if (account.isLocked()) {
            System.out.println("Your account is locked. Please try again later.");
            return false;
        }

        if (pin.equals(account.getHashedPIN())) {
            account.resetAttempts();
            return true; // Successful login
        } else {
            account.attemptLogin(); // Increment attempts and check lockout status
            if (account.isLocked()) {
                System.out.println("Your account is locked for " + lockoutDuration/60 + " minutes.");
            } else {
                System.out.println("Incorrect PIN. Attempts left: " + (ALLOWED_ATTEMPTS - account.getAttemptCount()));
            }
        }

        return false; // Failed login
    }

    // Main method for testing
    public static void main(String[] args) {
        SecureLoginSystem loginSystem = new SecureLoginSystem();
        // Add test accounts here
        // For example:
        loginSystem.accounts.put("user1", new Account("1234"));
        loginSystem.attemptLogin("user1", "1234"); // Should be successful
    }
}

class Account {
    private final String hashedPIN;
    private int attemptCount = 0;

    public Account(String hashedPIN) {
        this.hashedPIN = hashedPIN;
    }

    public void resetAttempts() {
        attemptCount = 0;
    }

    public void attemptLogin() {
        attemptCount++;
    }

    public boolean isLocked() {
        return attemptCount >= SecureLoginSystem.ALLOWED_ATTEMPTS;
    }

    // Getters and other methods...
    public String getHashedPIN() {
        return hashedPIN;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}