import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHasher_1_1 {
    public static String hashPassword(String password) throws Exception {
        int iterations = 10000;
        int keyLength = 256;
        byte[] salt = new byte[16];
        // Generate a random salt
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, keyLength);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();

        // Store the salt and hash in your database
        return bytesToHex(salt) + ":" + bytesToHex(hash);
    }

    public static boolean verifyPassword(String password, String storedHash) throws Exception {
        String[] parts = storedHash.split(":");
        byte[] salt = hexToBytes(parts[0]);
        byte[] storedHashBytes = hexToBytes(parts[1]);

        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 10000, 256);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();

        return MessageDigest.isEqual(hash, storedHashBytes);
    }

    // Helper functions to convert between byte arrays and hexadecimal strings
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static byte[] hexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    public static void main(String[] args) throws Exception {
        String password = "mysecretpassword";
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed password: " + hashedPassword);

        boolean isValid = verifyPassword(password, hashedPassword);
        System.out.println("Is password valid? " + isValid);
    }
}