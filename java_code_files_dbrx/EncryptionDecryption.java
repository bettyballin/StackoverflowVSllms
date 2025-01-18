import java.security.Key;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class EncryptionDecryption {
    public static String encrypt(String data, String keyString) throws Exception {
        Key key = generateKey(keyString);
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encVal);
        return encryptedValue;
    }

    private static Key generateKey(String keyString) throws Exception {
        byte[] keyBytes = keyString.getBytes("UTF-8");
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        return key;
    }
}