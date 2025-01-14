import java.lang.String;
// EncryptionJava.java
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionJava {
    private static final byte[] key = new byte[]{0x00,0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08,0x09,0x0A,0x0B,0x0C,0x0D,0x0E,0x0F};

    public static String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return java.util.Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decodedValue = java.util.Base64.getDecoder().decode(encryptedText);
        return new String(cipher.doFinal(decodedValue));
    }

	public static void main(String[] args) {
	}
}