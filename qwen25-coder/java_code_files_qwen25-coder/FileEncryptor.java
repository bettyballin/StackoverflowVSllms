import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class FileEncryptor {
    private static final int KEY_SIZE = 256;
    private static final int IV_SIZE = 128;
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String PBKDF_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 65536;

    public static void main(String[] args) throws Exception {
        String password = "MyDifficultPassword";
        byte[] dataToEncrypt = "This is some important data".getBytes(StandardCharsets.UTF_8);
        
        // Encrypt
        EncryptedDataFile encryptedFileData = encrypt(dataToEncrypt, password.toCharArray());
        System.out.println("Encrypted file content: " + Base64.getEncoder().encodeToString(encryptedFileData.encryptedData));

        // Decrypt
        byte[] decryptedData = decrypt(encryptedFileData, password.toCharArray());
        System.out.println("Decrypted data: " + new String(decryptedData, StandardCharsets.UTF_8));
    }

    public static EncryptedDataFile encrypt(byte[] dataToEncrypt, char[] password) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        byte[] iv = new byte[IV_SIZE / 8];
        random.nextBytes(salt);
        random.nextBytes(iv);

        SecretKeySpec keySpec = deriveKey(password, salt);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));

        byte[] encryptedData = cipher.doFinal(dataToEncrypt);

        return new EncryptedDataFile(salt, iv, encryptedData);
    }

    public static byte[] decrypt(EncryptedDataFile fileData, char[] password) throws Exception {
        SecretKeySpec keySpec = deriveKey(password, fileData.salt);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(fileData.iv));
        return cipher.doFinal(fileData.encryptedData);
    }

    private static SecretKeySpec deriveKey(char[] password, byte[] salt) throws Exception {
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password, salt, ITERATIONS, KEY_SIZE);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(PBKDF_ALGORITHM);
        byte[] keyBytes = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
        return new SecretKeySpec(keyBytes, "AES");
    }
}

class EncryptedDataFile {
    final byte[] salt;
    final byte[] iv;
    final byte[] encryptedData;

    EncryptedDataFile(byte[] salt, byte[] iv, byte[] encryptedData) {
        this.salt = salt;
        this.iv = iv;
        this.encryptedData = encryptedData;
    }
}