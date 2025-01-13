import java.lang.String;
import java.lang.Integer;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHasher_2_2 {
    private static final int SALT_LENGTH = 16;
    private static final int HASH_LENGTH = 32;
    private static final int PARALLELISM = 2;
    private static final int MEMORY_SIZE = 65536;

    public static String hashPassword(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        byte[] hash = argon2.hash(HASH_LENGTH, PARALLELISM, MEMORY_SIZE, salt, password.getBytes());
        return bytesToHex(salt) + ":" + bytesToHex(hash);
    }

    public static boolean verifyPassword(String password, String storedHash) {
        String[] parts = storedHash.split(":");
        byte[] salt = hexToBytes(parts[0]);
        byte[] storedHashBytes = hexToBytes(parts[1]);
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        byte[] hash = argon2.hash(HASH_LENGTH, PARALLELISM, MEMORY_SIZE, salt, password.getBytes());
        return MessageDigest.isEqual(hash, storedHashBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static byte[] hexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(i * 2, (i + 1) * 2), 16);
        }
        return bytes;
    }

	public static void main(String[] args) {
		String password = "password123";
		String hashedPassword = hashPassword(password);
		System.out.println("Hashed Password: " + hashedPassword);
		boolean isValid = verifyPassword(password, hashedPassword);
		System.out.println("Is Password Valid: " + isValid);
	}
}