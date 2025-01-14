import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class SecurePasswordStorage {
    public static void main(String[] args) {
        char[] password = "securePassword".toCharArray();

        try {
            // Hash the password
            byte[] hashedBytes = hashPassword(password);

            // At this point, you can persist `hashedBytes` to your database

        } finally {
            // Clear the password from memory
            clearPassword(password);
        }
    }

    private static byte[] hashPassword(char[] password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(toByteArray(password));
        return md.digest();
    }

    private static void clearPassword(char[] password) {
        if (password == null) return;
        for (int i = 0; i < password.length; ++i) password[i] = '\0';
    }

    // Helper method to convert char[] to byte[]
    private static byte[] toByteArray(char[] chars) {
        CharBuffer charBuffer = CharBuffer.wrap(chars);
        ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(charBuffer);
        byte[] bytes = Arrays.copyOfRange(byteBuffer.array(),
                byteBuffer.position(), byteBuffer.limit());
        Arrays.fill(byteBuffer.array(), (byte)0); // clear sensitive data
        return bytes;
    }
}