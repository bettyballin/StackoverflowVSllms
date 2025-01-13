import java.lang.String;

public class UsernameManager {
    private static Object lock = new Object();

    public static void manageUsername(String username) {
        synchronized (lock) {
            if (usernameExists(username)) {
                // Handle duplicate username
                System.out.println("Username already exists.");
            } else {
                insertUsername(username);
            }
        }
    }

    private static boolean usernameExists(String username) {
        // This method should be implemented to check if the username exists
        // For demonstration purposes, it always returns false
        return false;
    }

    private static void insertUsername(String username) {
        // This method should be implemented to insert the username
        // For demonstration purposes, it simply prints the username
        System.out.println("Username inserted: " + username);
    }

    public static void main(String[] args) {
        manageUsername("testUser");
    }
}