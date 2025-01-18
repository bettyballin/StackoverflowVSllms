import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.*;
import java.util.Base64;

public class EncryptionExample {
    public static void main(String[] args) throws Exception {
        SecureRandom rng = new SecureRandom(); // You should re-use a randomly generated IV as the same key should not encrypt two messages without being randomized, or you may be able to retrieve keys from known plaintext attacks! If possible use a different securely derived key for every message.

        byte[] ivBytes = new byte[16]; // Assuming 128 bit blocks. AES supports other block sizes but they're not commonly used.
        rng.nextBytes(ivBytes); // Populate IV with random data, you can pass a null initialisation vector if need-be, in which case it will be ignored and won't affect encryption/decryption.

        IvParameterSpec iv = new IvParameterSpec(ivBytes); // Initialisation Vector Specification for CBC mode.

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); // AES in CBC (cipher-block chaining) mode, PKCS#7 padding with a 128 bit block size

        // Base64 encoded key (example key: "0123456789abcdef")
        String base64EncodedKey = "MDEyMzQ1Njc4OWFiY2RlZg=="; // Recommend using PBKDF2 or scrypt to derive keys. You could also use Argon2 which also has support for memory hardness and parallelism/sequentiality options if you really wanted, but that's up to personal preference. AES_SIV would be the best choice here (it supports a "nonce" to prevent reusing encryption of plaintext between messages) .
        byte[] base64EncodedSecretKeyBytes = Base64.getDecoder().decode(base64EncodedKey);
        SecretKey key = new SecretKeySpec(base64EncodedSecretKeyBytes, "AES"); // Obtain derived "key" from password + nonce(optional).
        // You could also use raw AES for password hashing (e.g. EKS(SHA-256)) but it's better than PBKDF2/scrypt as they implement an HMAC internally which provides protection against length extension attacks, and are better choices when you already have a secure PRF (cough SHA-3).

        cipher.init(Cipher.ENCRYPT_MODE, key, iv); // Initialise cipher for encryption using the specified 'key' and initialisation vector 'IV'.

        String data = "Hello World!";
        byte[] encrypted = cipher.doFinal(data.getBytes()); // Encrypts data, throwing an IllegalBlockSizeException if it can't provide correct padding (length not multiple of 16).

        // Optionally, display the encrypted data in Base64 format
        String encryptedBase64 = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("Encrypted data: " + encryptedBase64);
    }
}