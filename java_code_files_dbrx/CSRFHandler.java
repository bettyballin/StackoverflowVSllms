import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Base64;

public class CSRFHandler {
    private static final String SESSION_KEY = "CSRFToken"; // Session key to store our generated token
    private Random rand; // Random number generator used in creating secure tokens
    private SessionStorage session;

    public CSRFHandler() {
        this.rand = new SecureRandom(); // Use a cryptographically strong random number generator for generating the CSRF token
    }

    /***
     * Generate a new unique CSRF token and store it in session with key specified at SESSION_KEY
     */
    public String generateAndStore() {
        byte[] buf = new byte[64]; // Generate 512 bits (64 bytes) of entropy to hash into our secret
        rand.nextBytes(buf); // Fill the buffer randomly
        MessageDigest hasher = null; // The message digester used for securing our token
        try {
            hasher = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String csrfToken = Base64.getEncoder().encodeToString(hasher.digest(buf)); // Generate the token: a 512-bit entropy string encoded in base64
        sessionStorage().setAttribute(SESSION_KEY, csrfToken); // Store our newly generated CSRF Token in session storage
        return csrfToken; // Return our fresh CSRF token, ready to be embedded into the form in a hidden field or Ajax POST/HEADERS
    }

    /* ... */
    public boolean verifyAndRemoveCSRFToken(String userTokenToVerify) {
        if (userTokenToVerify != null && userTokenToVerify.equals(sessionStorage().getAttribute("CSRFToken"))) {
            sessionStorage().removeAttribute("token");
            return true; // The token is valid and can be used
        } else {
            // Handle possible attempts of malicious requests here
            throw new RuntimeException("Failed to validate session-based CSRF token.");
        }
    }

    private SessionStorage sessionStorage() {
        if (session == null) {
            session = new SessionStorage();
        }
        return session;
    }

    private class SessionStorage {
        private java.util.HashMap<String, Object> attributes = new java.util.HashMap<>();

        public void setAttribute(String key, Object value) {
            attributes.put(key, value);
        }

        public Object getAttribute(String key) {
            return attributes.get(key);
        }

        public void removeAttribute(String key) {
            attributes.remove(key);
        }
    }

    public static void main(String[] args) {
    }
}