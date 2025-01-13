import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SessionValidator_1_1 {
    // Server-side
    public static String getStoredHashedPassword(String username) {
        // This method should return the stored hashed password for the given username
        // For demonstration purposes, a dummy hashed password is returned
        return "dummyHashedPassword";
    }

    public static String generateNonce() {
        // Generate a cryptographically secure pseudo-random number
        SecureRandom random = new SecureRandom();
        byte[] nonceBytes = new byte[16];
        random.nextBytes(nonceBytes);
        return bytesToHex(nonceBytes);
    }

    public static String hash(String input) {
        try {
            // Use SHA-256 hashing algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static void main(String[] args) {
        String username = "exampleUser";
        String receivedSessionToken = "exampleSessionToken"; // Replace with the actually received session token

        String storedHashedPassword = getStoredHashedPassword(username);
        String expectedSessionToken = hash(storedHashedPassword + generateNonce()); // using same CSPRNG
        if (expectedSessionToken.equals(receivedSessionToken)) {
            // Grant access
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}