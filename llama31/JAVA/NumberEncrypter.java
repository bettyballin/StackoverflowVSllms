import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NumberEncrypter {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static String encrypt(long code, String password) throws Exception {
        byte[] key = generateKey(password);
        byte[] iv = generateIV(password);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, ALGORITHM), new IvParameterSpec(iv));
        byte[] encrypted = cipher.doFinal(numberToBytes(code));
        return bytesToNumber(encrypted).toString();
    }

    public static String decrypt(String encrypted, String password) throws Exception {
        byte[] key = generateKey(password);
        byte[] iv = generateIV(password);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, ALGORITHM), new IvParameterSpec(iv));
        byte[] decrypted = cipher.doFinal(numberToBytes(Long.parseLong(encrypted)));
        return bytesToNumber(decrypted).toString();
    }

    private static byte[] generateKey(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(password.getBytes());
    }

    private static byte[] generateIV(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(password.getBytes());
    }

    private static byte[] numberToBytes(long number) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(number);
        return buffer.array();
    }

    private static Long bytesToNumber(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        return buffer.getLong();
    }

    public static void main(String[] args) throws Exception {
        String password = "yourSecurePassword";
        long code = 981762654986L;
        String encrypted = encrypt(code, password);
        System.out.println("Encrypted: " + encrypted);
        String decrypted = decrypt(encrypted, password);
        System.out.println("Decrypted: " + decrypted);
    }
}