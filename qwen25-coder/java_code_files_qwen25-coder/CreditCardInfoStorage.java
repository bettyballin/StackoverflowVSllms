import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class CreditCardInfoStorage {
    private static final int GCM_TAG_LENGTH = 16; // in bytes
    private static final int GCM_IV_LENGTH = 12; // in bytes

    public static void main(String[] args) throws Exception {
        String lastFourDigits = "1234";
        String expirationDate = "12/25";

        SecretKey key = generateKey();
        byte[] iv = generateIv();

        String encryptedLastFourDigits = encrypt(lastFourDigits, key, iv);
        String encryptedExpirationDate = encrypt(expirationDate, key, iv);

        System.out.println("Encrypted Last Four Digits: " + encryptedLastFourDigits);
        System.out.println("Encrypted Expiration Date: " + encryptedExpirationDate);
    }

    private static SecretKey generateKey() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(256); // for example
        return generator.generateKey();
    }

    private static byte[] generateIv() {
        byte[] iv = new byte[GCM_IV_LENGTH];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    private static String encrypt(String plaintext, SecretKey key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec parameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);

        cipher.init(Cipher.ENCRYPT_MODE, key, parameterSpec);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

        return Base64.getEncoder().encodeToString(ciphertext);
    }
}