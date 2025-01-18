import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.PBEParameterSpec;

public class CryptoExample {

    private static String password = "examplePassword";
    private static byte[] salt = "1234567890abcdef".getBytes(); // Sample salt
    private static SecretKeyFactory factory = null;
    private static SecretKey temporarySecretKey = null;

    private Cipher cipher; // Cipher used to encrypt/decrypt the data
    private byte[] encryptedData;
    private byte[] originalData;

    static {
        try {
            // Create a temporary key using the password from the user, and the salt
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, 20); // Iteration count is 20 here - change appropriately
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1"); // Use PBKDF2 to create a key of the appropriate length from our password and a salt.
            temporarySecretKey = factory.generateSecret(pbeKeySpec);
        } catch (Exception e) {
            throw new IllegalStateException(e); // Never caught
        }
    }

    void setupCrypto() throws Exception {
        cipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_128"); // Use PBE, with AES 128-bit keys and HMAC SHA-256 as PRF (Password-Based Key Derivation Function)
    }

    void encryptData(byte[] data, byte[] salt) throws Exception {
        // Create a new Cipher called "cipher" using our previously generated key factory and the initialization vector we have received from server. The cipher will use AES-128.
        final PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, 50); // Set up with salt and high iterationCount=50
        // Create a new instance of the Cipher class using our key factory and the specified parameters. (CBC mode is default for PBEWithHmacSHA256AndAES_128)
        cipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_128"); // Use AES 128-bit keys with HMAC SHA-256 as PRF (Password-Based Key Derivation Function) and the given parameters (salt + iterationCount)
        cipher.init(Cipher.ENCRYPT_MODE, temporarySecretKey, parameterSpec); // Initialize our cipher for a single round of encryption using the AES 128-bit key we have generated from our user's password and a salt value obtained from server.
        encryptedData = cipher.doFinal(data); // Encrypt passed data into one "chunk" of binary data suitable for use as an input to the hash function in HMAC-SHA256 process
    }

    void decryptData() throws Exception {
        // Use PBE - AES (128-bit keys) + SHA-256
        Cipher cipher = Cipher.getInstance("PBEWithHmacSHA256AndAES_128"); // Use PBE, with AES 128-bit keys and HMAC SHA-256 as PRF (Password-Based Key Derivation Function)
        final PBEParameterSpec parameterSpec = new PBEParameterSpec(salt, 50); // Set up with salt and high iterationCount=50
        cipher.init(Cipher.DECRYPT_MODE, temporarySecretKey, parameterSpec); // Initialize our cipher to be ready for decrypting our encrypted data using the AES-128-bit key we have generated from our user's password and a salt value obtained from server.
        originalData = cipher.doFinal(encryptedData); // Decrypt data into one "chunk" of binary data for use as an output.
    }

    public static void main(String[] args) {
        try {
            CryptoExample cryptoExample = new CryptoExample();
            cryptoExample.setupCrypto();
            byte[] data = "Hello, World!".getBytes();
            cryptoExample.encryptData(data, salt);
            cryptoExample.decryptData();
            System.out.println("Original data: " + new String(cryptoExample.originalData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}