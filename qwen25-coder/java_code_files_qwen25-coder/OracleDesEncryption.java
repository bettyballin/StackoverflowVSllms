import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class OracleDesEncryption {
    public static byte[] desEncrypt(byte[] inputStringBytes, String key) throws Exception {
        // DES algorithm with ECB mode and PKCS5Padding
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        
        // Create a secret key from the provided key string
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "DES");
        
        // Initialize the cipher for encryption
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        
        // Encrypt the input data
        return cipher.doFinal(inputStringBytes);
    }

    public static void main(String[] args) throws Exception {
        String v_string = "your_input_text"; // The string to encrypt
        String key_string = "12345678";       // 8-byte key

        byte[] encryptedBytes = desEncrypt(v_string.getBytes("UTF-8"), key_string);
        
        // Convert the encrypted bytes for display (e.g., Base64 encoding)
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        String encodedString = encoder.encodeToString(encryptedBytes);
        System.out.println("Encrypted string: " + encodedString);
    }
}