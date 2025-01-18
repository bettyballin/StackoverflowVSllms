import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class DecryptExample {
    public static void main(String[] args) throws Exception {
        // Define your key and IV (Initialization Vector)
        byte[] keyBytes = "0123456789abcdef".getBytes("UTF-8"); // 16-byte key for AES-128
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");

        byte[] ivBytes = "fedcba9876543210".getBytes("UTF-8"); // 16-byte IV for AES
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Your encrypted data (ciphertext)
        byte[] encrypted = new byte[] { /* your encrypted data here */ };

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] data = cipher.doFinal(encrypted);
        String plaintext = new String(data, "UTF-8"); // Get plainText from encrypted bytes using the specified character set encoding
        System.out.println("Decrypted text: " + plaintext);
    }
}