import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

public class AesDecryptor {
    public static void main(String[] args) throws Exception {
        // Assuming 'result' and 'key' are defined somewhere
        byte[] result = new byte[32]; // Replace with actual data
        Key key = new javax.crypto.spec.SecretKeySpec(new byte[16], "AES"); // Replace with actual key

        // Extract the IV
        byte[] iv = new byte[16];
        System.arraycopy(result, 0, iv, 0, iv.length);

        // Decrypt the data
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
        byte[] plaintext = cipher.doFinal(result, iv.length, result.length - iv.length);
    }
}