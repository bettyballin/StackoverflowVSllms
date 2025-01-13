import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenerator {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int KEY_SIZE = 128;
    private static final int IV_SIZE = 12;

    public static String generateToken(String userId) throws Exception {
        // Generate a random IV
        byte[] iv = new byte[IV_SIZE];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        // Create a secret key
        SecretKeySpec keySpec = new SecretKeySpec(getSecretKey(), "AES");

        // Encrypt the payload
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new GCMParameterSpec(KEY_SIZE, iv));
        byte[] encrypted = cipher.doFinal((userId + ":" + System.currentTimeMillis()).getBytes());

        // Return the encrypted token as a base64-encoded string
        // Prepend the IV to the encrypted data
        byte[] result = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, result, 0, iv.length);
        System.arraycopy(encrypted, 0, result, iv.length, encrypted.length);
        return Base64.getEncoder().encodeToString(result);
    }

    public static boolean verifyToken(String providedToken, String userId) throws Exception {
        // Decrypt the token
        byte[] encrypted = Base64.getDecoder().decode(providedToken);
        // Extract the IV from the encrypted data
        byte[] iv = new byte[IV_SIZE];
        System.arraycopy(encrypted, 0, iv, 0, IV_SIZE);
        byte[] data = new byte[encrypted.length - IV_SIZE];
        System.arraycopy(encrypted, IV_SIZE, data, 0, encrypted.length - IV_SIZE);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(getSecretKey(), "AES"), new GCMParameterSpec(KEY_SIZE, iv));
        byte[] decrypted = cipher.doFinal(data);

        // Verify the contents
        String[] parts = new String(decrypted).split(":");
        return parts[0].equals(userId);
    }

    private static byte[] getSecretKey() {
        // Return your secret key as a byte array
        // This is a placeholder, you should use a secure method to generate and store your secret key
        return "your_secret_key_here".getBytes();
    }

    public static void main(String[] args) throws Exception {
        String userId = "user123";
        String token = generateToken(userId);
        System.out.println("Generated Token: " + token);
        boolean verified = verifyToken(token, userId);
        System.out.println("Token Verified: " + verified);
    }
}