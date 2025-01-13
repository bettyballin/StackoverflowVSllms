import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CDKeyGenerator {
    private static final int SALT_SIZE = 16; // 128-bit salt
    private static final int CDKEY_SIZE = 24; // 24-character CD-KEY (in hexadecimal)

    public static String generateCDKey(String productCode, String resellerCode, String dateString) {
        // Generate a random salt value using Fortuna PRNG
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_SIZE];
        secureRandom.nextBytes(salt);

        // Concatenate the input values (product code, reseller code, and date string)
        String input = productCode + resellerCode + dateString;

        // Hash the input values using SHA-256
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(input.getBytes());

            // Concatenate the salt value and hash output
            byte[] combined = new byte[salt.length + hash.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hash, 0, combined, salt.length, hash.length);

            // Convert the combined bytes to a hexadecimal string
            String hexString = bytesToHexString(combined);

            // Take the first 24 characters of the hexadecimal string as the CD-KEY
            String cdKey = hexString.substring(0, CDKEY_SIZE);

            return cdKey;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHexString(byte[] bytes) {
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
        System.out.println(generateCDKey("productCode", "resellerCode", "dateString"));
    }
}