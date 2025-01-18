import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESCryptor {
    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] keyBytes = "ABCDEFFEDBCA".getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }
    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        byte[] keyBytes = "ABCDEFFEDBCA".getBytes();
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)));
    }
    public static void main(String[] args) {
    }
}