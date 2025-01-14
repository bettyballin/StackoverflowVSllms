import java.lang.String;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.nio.ByteBuffer;

public class TokenGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String ALGORITHM = "SHA-256";

    public static byte[] generateSecureToken(int numBytes) {
        byte[] token = new byte[numBytes];
        random.nextBytes(token);
        return token;
    }

    public static byte[] hashToken(byte[] token) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
        return digest.digest(token);
    }

    public static void main(String[] args) {
        try {
            // Generate a 32-byte secure random token
            byte[] token = generateSecureToken(32);

            // Hash the generated token for storage
            byte[] hashedToken = hashToken(token);

            // Convert to hex format for easier handling (for display or storage)
            System.out.println("Generated Token: " + bytesToHex(token));
            System.out.println("Hashed Token: " + bytesToHex(hashedToken));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String bytesToHex(byte[] hash) {
        ByteBuffer buffer = ByteBuffer.wrap(hash);
        StringBuilder sb = new StringBuilder();
        while (buffer.hasRemaining()) {
            sb.append(String.format("%02x", buffer.get()));
        }
        return sb.toString();
    }
}