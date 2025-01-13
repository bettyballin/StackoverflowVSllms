import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class OracleDESEncryption {

    public static byte[] encrypt(String input, String key) throws Exception {
        // Oracle's DBMS_OBFUSCATION_TOOLKIT uses a 7-byte key
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        keyBytes = padKey(keyBytes, 7);

        // Use DES algorithm with ECB mode and NoPadding
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        SecretKey secretKey = new SecretKeySpec(keyBytes, "DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Convert input string to bytes and pad with zeros if necessary
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        inputBytes = padInput(inputBytes);

        // Encrypt the input bytes
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        return encryptedBytes;
    }

    private static byte[] padKey(byte[] keyBytes, int length) {
        if (keyBytes.length < length) {
            byte[] paddedKeyBytes = new byte[length];
            System.arraycopy(keyBytes, 0, paddedKeyBytes, 0, keyBytes.length);
            for (int i = keyBytes.length; i < length; i++) {
                paddedKeyBytes[i] = 0;
            }
            return paddedKeyBytes;
        } else {
            return keyBytes;
        }
    }

    private static byte[] padInput(byte[] inputBytes) {
        int blockSize = 8; // DES block size
        int remainder = inputBytes.length % blockSize;
        if (remainder != 0) {
            byte[] paddedInputBytes = new byte[inputBytes.length + (blockSize - remainder)];
            System.arraycopy(inputBytes, 0, paddedInputBytes, 0, inputBytes.length);
            for (int i = inputBytes.length; i < paddedInputBytes.length; i++) {
                paddedInputBytes[i] = 0;
            }
            return paddedInputBytes;
        } else {
            return inputBytes;
        }
    }

	public static void main(String[] args) {
	}
}