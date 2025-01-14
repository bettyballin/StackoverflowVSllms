import java.lang.String;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordHasher_5 {
    public static void main(String[] args) throws Exception {
        String password = "userPassword123";
        byte[] salt = getSalt();
        byte[] hashedPassword = hashPassword(password, salt);

        System.out.println("Salt: " + bytesToHex(salt));
        System.out.println("Hashed Password: " + bytesToHex(hashedPassword));
    }

    public static byte[] hashPassword(String password, byte[] salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        return md.digest(password.getBytes());
    }

    private static byte[] getSalt() throws Exception {
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}