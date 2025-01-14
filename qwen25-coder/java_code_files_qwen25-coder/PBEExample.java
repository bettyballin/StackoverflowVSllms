import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class PBEExample {
    private static final int PBKDF2_ITERATIONS = 10000;
    private static final int AES_KEY_SIZE = 128; // in bits, e.g., 128, 192, or 256
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    
    public static EncryptResult encrypt(String data, String passphrase) throws Exception {
        SecureRandom rnd = new SecureRandom();
        byte[] salt = new byte[16];
        rnd.nextBytes(salt);

        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec pbeKeySpec = new PBEKeySpec(passphrase.toCharArray(), salt, PBKDF2_ITERATIONS, AES_KEY_SIZE);
        byte[] keyBytes = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        IvParameterSpec ivParamSpec = generateIv(cipher.getBlockSize());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParamSpec);

        byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));

        return new EncryptResult(Base64.getEncoder().encodeToString(salt),
                Base64.getEncoder().encodeToString(ivParamSpec.getIV()),
                Base64.getEncoder().encodeToString(encryptedData));
    }

    public static String decrypt(String encryptedData, String saltBase64, String ivBase64, String passphrase) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec pbeKeySpec = new PBEKeySpec(passphrase.toCharArray(), Base64.getDecoder().decode(saltBase64), PBKDF2_ITERATIONS, AES_KEY_SIZE);
        byte[] keyBytes = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(Base64.getDecoder().decode(ivBase64)));

        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData)), StandardCharsets.UTF_8);
    }

    private static IvParameterSpec generateIv(int size) {
        byte[] iv = new byte[size];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }
    
    public static class EncryptResult {
        private final String salt;
        private final String iv;
        private final String data;

        public EncryptResult(String salt, String iv, String data) {
            this.salt = salt;
            this.iv = iv;
            this.data = data;
        }

        public String getSalt() { return salt; }
        public String getIv()   { return iv;   }
        public String getData() { return data; }
    }

    // Example usage
    public static void main(String[] args) throws Exception {
        String passphrase = "my_secure_passphrase";
        String originalData = "Hello, World!";

        EncryptResult result = encrypt(originalData, passphrase);
        System.out.println("Salt: " + result.getSalt());
        System.out.println("IV: " + result.getIv());
        System.out.println("Encrypted Data: " + result.getData());

        String decryptedData = decrypt(result.getData(), result.getSalt(), result.getIv(), passphrase);
        System.out.println("Decrypted data: " + decryptedData);
    }
}