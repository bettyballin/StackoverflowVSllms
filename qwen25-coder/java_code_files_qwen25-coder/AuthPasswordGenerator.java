import java.security.SecureRandom;
import java.util.Arrays;

public class AuthPasswordGenerator {
    public static void main(String[] args) {
        // Example password
        String password = "your_password_here";

        // Client generates a random 16-byte challenge (nonce)
        byte[] random_challenge = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(random_challenge); // Generate 16 random bytes

        // Get password bytes
        byte[] passwordBytes = password.getBytes();

        // Calculate padding length according to PKCS#7
        int blockSize = 16; // Block size in bytes
        int messageLength = 16 + passwordBytes.length; // 16 bytes random challenge + password bytes
        int paddingLength = blockSize - (messageLength % blockSize);
        if (paddingLength == 0) {
            paddingLength = blockSize;
        }

        // Total length including padding
        int totalLength = messageLength + paddingLength;

        // Prepare unencrypted_AUTH_PASSWORD array
        byte[] unencrypted_AUTH_PASSWORD = new byte[totalLength];

        // Fill the first 16 bytes of unencrypted_AUTH_PASSWORD with the random challenge
        System.arraycopy(random_challenge, 0, unencrypted_AUTH_PASSWORD, 0, 16); // Assign the generated random bytes

        // The remainder is filled as described in step 5

        // Copy password bytes into unencrypted_AUTH_PASSWORD starting at index 16
        System.arraycopy(passwordBytes, 0, unencrypted_AUTH_PASSWORD, 16, passwordBytes.length);

        // Apply PKCS#7 padding
        byte paddingByte = (byte) paddingLength;
        Arrays.fill(unencrypted_AUTH_PASSWORD, 16 + passwordBytes.length, totalLength, paddingByte);

        // unencrypted_AUTH_PASSWORD now contains:
        // [0 .. 15]: random_challenge
        // [16 .. 16 + len(password) - 1]: password bytes
        // [16 + len(password) .. ]: PKCS#7 padding

        // (Optional) Print the unencrypted_AUTH_PASSWORD in hex format
        System.out.println(bytesToHex(unencrypted_AUTH_PASSWORD));
    }

    // Helper method to convert bytes to hex string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}