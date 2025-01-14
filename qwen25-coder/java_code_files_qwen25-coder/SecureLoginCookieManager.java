import java.util.Set;
import java.security.SecureRandom;

public class SecureLoginCookieManager {
    User user = new User(); // Placeholder for user data

    // Pseudocode for setting a secure persistent login cookie
    String generateSecureToken() {
        // Generate a sufficiently long, random token
        return SecureRandomStringUtils.randomAlphanumeric(32); 
    }

    void setPersistentLoginCookie(HttpServletResponse response, String token) {
        Cookie cookie = new Cookie("persistentLogin", token);
        cookie.setHttpOnly(true);            // HttpOnly flag to prevent access via JavaScript
        cookie.setSecure(true);              // Ensure cookies are sent over HTTPS only
        cookie.setPath("/");                 // Apply the cookie across all application paths
        cookie.setMaxAge(24*60*60*30);       // Set an expiration (e.g., 30 days)
        cookie.setAttribute("SameSite", "Strict"); // Prevent sending the cookie with cross-site requests
        response.addCookie(cookie);
    }

    String newAccountCreated(AccountData data, HttpServletResponse response) {
        if (validateAccountData(data)) {
            String token = generateSecureToken();
            storeTokenOnServer(user, token); // Store the token server-side in a secure fashion
            setPersistentLoginCookie(response, token);
            return "Account created successfully";
        }
        return "Invalid account data";
    }

    boolean validateAccountData(AccountData data) {
        // Dummy implementation
        return true;
    }

    void storeTokenOnServer(User user, String token) {
        // Dummy implementation
    }

    public static void main(String[] args) {
        // Entry point of the application
    }
}

// Additional classes and stubs to make the code executable

class AccountData {
    // Placeholder for account data
}

class User {
    // Placeholder for user data
}

class SecureRandomStringUtils {
    public static String randomAlphanumeric(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
}

class Cookie {
    public Cookie(String name, String value) {
        // Constructor implementation
    }
    public void setHttpOnly(boolean flag) {
        // Implementation
    }
    public void setSecure(boolean flag) {
        // Implementation
    }
    public void setPath(String path) {
        // Implementation
    }
    public void setMaxAge(int expiry) {
        // Implementation
    }
    public void setAttribute(String name, String value) {
        // Implementation
    }
}

class HttpServletResponse {
    public void addCookie(Cookie cookie) {
        // Implementation
    }
}