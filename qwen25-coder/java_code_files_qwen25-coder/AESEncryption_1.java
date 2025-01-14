import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AESEncryption {
    public static String decrypt(byte[] encryptedData, byte[] keyBytes, byte[] ivBytes) throws Exception {
        // Ensure key and IV match those used in encryption.
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParamSpec = new IvParameterSpec(ivBytes);
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParamSpec);

        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData, StandardCharsets.UTF_8); // Ensure charset matches your data
    }

    public static void main(String[] args) throws Exception {
        byte[] encryptedMessageFromBlackBerry = null; // Received from BB app
        byte[] aesKey = null; // Shared secret key between server and BB app
        byte[] initializationVector = null; // IV used in encryption, must match

        String decryptedString = decrypt(encryptedMessageFromBlackBerry, aesKey, initializationVector);
        System.out.println("Decrypted: " + decryptedString);
    }
}