import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class SecureData {
    private static final String ALGORITHM = "AES";
    private byte[] keyValue;

    public SecureData(String encryptionKey) {
        this.keyValue = encryptionKey.getBytes();
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(keyValue, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);

        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // encode bytes to string
    }

    public String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        SecretKeySpec keySpec = new SecretKeySpec(keyValue, ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec);

        byte[] decodedBytes = Base64.getDecoder().decode(data); // decode string to bytes
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
    }
}