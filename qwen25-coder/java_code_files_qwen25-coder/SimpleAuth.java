import java.util.Map;
import java.util.HashMap;

// Example of a simple username/password login system as an alternative
public class SimpleAuth {
    private Map<String, String> userCredentials = new HashMap<>();

    public void register(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            userCredentials.put(username, password);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    public boolean login(String username, String password) {
        return userCredentials.getOrDefault(username, "").equals(password);
    }

    public static void main(String[] args) {
    }
}