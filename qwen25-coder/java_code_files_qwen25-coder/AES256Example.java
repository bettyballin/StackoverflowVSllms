import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AES256Example {
    private static final String ALGORITHM = "AES/CBC/PKCS7Padding";
    private static final int KEY_LENGTH = 256; // bits
    private static final int ITERATIONS = 10000;
    private static final byte[] SALT = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
            (byte) 0x56, (byte) 0x34, (byte) 0xE3, (byte) 0x03 }; // Ensure this is random and securely stored

    public static byte[] encrypt(String password, byte[] dataToEncrypt) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, ITERATIONS, KEY_LENGTH);
        IvParameterSpec ivParameterSpec = generateIv();

        javax.crypto.SecretKey secretKey = factory.generateSecret(spec);
        javax.crypto.spec.SecretKeySpec sks = new javax.crypto.spec.SecretKeySpec(secretKey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, sks, ivParameterSpec);
        return Base64.getEncoder().encode(cipher.doFinal(dataToEncrypt));
    }

    public static byte[] decrypt(String password, byte[] encryptedData) throws Exception {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, ITERATIONS, KEY_LENGTH);
        IvParameterSpec ivParameterSpec = generateIv();

        javax.crypto.SecretKey secretKey = factory.generateSecret(spec);
        javax.crypto.spec.SecretKeySpec sks = new javax.crypto.spec.SecretKeySpec(secretKey.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, sks, ivParameterSpec);
        return cipher.doFinal(Base64.getDecoder().decode(encryptedData));
    }

    private static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static void main(String[] args) throws Exception {
        String password = "your-secret-password";
        String textToEncrypt = "Hello, World!";
        
        byte[] encryptedData = encrypt(password, textToEncrypt.getBytes());
        System.out.println("Encrypted: " + new String(encryptedData));

        byte[] decryptedData = decrypt(password, encryptedData);
        System.out.println("Decrypted: " + new String(decryptedData));
    }
}