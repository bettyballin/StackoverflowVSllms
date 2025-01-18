import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RC5Encryption {
    private static final String ALGORITHM = "RC5";
    private static final int KEY_SIZE = 128; // Change it according to your needs (must be a multiple of 32)
    private static final int BLOCK_SIZE = 64;

    public byte[] encrypt(String input, String keyString) throws Exception {
        SecretKeySpec key = new SecretKeySpec(keyString.getBytes(), ALGORITHM); // Converts the string into a secret key
        Cipher cipher = Cipher.getInstance(ALGORITHM);// Creates an instance of the cipher
        cipher.init(Cipher.ENCRYPT_MODE, key);   // Sets the algorithm to be used for encryption/decryption
        return cipher.doFinal(input.getBytes());  // Performs the encryption and returns it as a byte array
    }

    public static void main(String[] args) {
        // Add BouncyCastle Provider
        Security.addProvider(new BouncyCastleProvider());
        RC5Encryption rc5 = new RC5Encryption();
        try {
            String key = "0123456789abcdef"; // 16-byte key, can be longer if you want (must have length multiple of 16 bytes(128 bits))
            byte[] text = "Hello World!".getBytes();   // Text to be encrypted.
            System.out.println("Input Data: " + new String(text));
            byte[] cipherText = rc5.encrypt(new String(text), key);    // Encryption of the input data using RC5 algorithm and a secret key
            System.out.println("\nCipher Text (Base64): \n" + Base64.getEncoder().encodeToString(cipherText));// Prints the cipher text data. Remember, this byte array cannot be decoded as it will show only gibberish string due to encoding differences
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }
    }
}