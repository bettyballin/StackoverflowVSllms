import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

public class BlockCipherManager {
    private Cipher ecipher;
    private Cipher dcipher;

    private byte[] keyBytes;
    private byte[] ivBytes;

    private SecretKeySpec key;
    private IvParameterSpec iv;

    public BlockCipherManager(String keyStr, String ivStr, String algorithm, String mode) {
        try {
            ecipher = Cipher.getInstance(algorithm + "/" + mode + "/PKCS5Padding");
            dcipher = Cipher.getInstance(algorithm + "/" + mode + "/PKCS5Padding");

            keyBytes = hexStringToByteArray(keyStr);
            ivBytes = hexStringToByteArray(ivStr);

            key = new SecretKeySpec(keyBytes, algorithm);
            iv = new IvParameterSpec(ivBytes);

            ecipher.init(Cipher.ENCRYPT_MODE, key, iv);
            dcipher.init(Cipher.DECRYPT_MODE, key, iv);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                InvalidAlgorithmParameterException e) {
            System.err.println("Cipher initialization failed: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                              + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    } 

    public static void main(String[] args) {
    }
}