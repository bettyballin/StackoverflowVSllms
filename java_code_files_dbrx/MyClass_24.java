import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.codec.binary.Hex;
import java.nio.charset.StandardCharsets;

public class MyClass {
    public static final int SHA256_HASH_LENGTH = 32; // SHA256 hash length is 32 bytes
    public static void main(String[] args) throws Exception {
        String urlSafeEncryptedValue = "some/encrypted/value"; // placeholder
        int index = 0; // placeholder index
        Cipher cipher = Cipher.getInstance("AES");
        byte[] keyBytes = new byte[16]; // placeholder for key bytes (AES key size)
        Key key = new SecretKeySpec(keyBytes, "AES"); // placeholder key
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        
        String[] parts = urlSafeEncryptedValue.split("/");
        byte[] bytes = Hex.decodeHex(parts[index].toCharArray()); // assuming index contains our encrypted hash & salt in hex form
        cipher.init(Cipher.DECRYPT_MODE, key); // Reinitialize the cipher to decrypt mode with secret key object
        String recoveredHashAndSalt = new String(cipher.doFinal(bytes), StandardCharsets.UTF_8); // recover original hash and salt as a string
        byte[] splitBytes = recoveredHashAndSalt.getBytes(StandardCharsets.UTF_8);
        byte[] recoveredHash = Arrays.copyOfRange(splitBytes, 0, SHA256_HASH_LENGTH); // first n bytes will be the id's Hash value (you can determine this beforehand as it is fixed based on hash implementation - here, it is 32 bytes)
        byte[] recoveredSalt = Arrays.copyOfRange(splitBytes, SHA256_HASH_LENGTH, splitBytes.length); // remaining are the salt's bytes.

        // Concatenate recoveredHash and recoveredSalt
        byte[] combinedHashAndSalt = new byte[recoveredHash.length + recoveredSalt.length];
        System.arraycopy(recoveredHash, 0, combinedHashAndSalt, 0, recoveredHash.length);
        System.arraycopy(recoveredSalt, 0, combinedHashAndSalt, recoveredHash.length, recoveredSalt.length);

        String strRecoveredHash = Hex.encodeHexString(digest.digest(combinedHashAndSalt)); // recreate hash for comparison - should match original one stored in db
    }
}