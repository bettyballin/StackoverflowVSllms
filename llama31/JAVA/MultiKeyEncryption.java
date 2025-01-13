import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class MultiKeyEncryption {
    public static void main(String[] args) throws Exception {
        // Generate multiple keys
        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128); // 128-bit key size

        SecretKey key1 = kg.generateKey();
        SecretKey key2 = kg.generateKey();
        SecretKey key3 = kg.generateKey();
        SecretKey key4 = kg.generateKey();

        // Encrypt data with key1
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key1);
        byte[] encryptedData = cipher.doFinal("Hello, World!".getBytes());

        // Wrap key1 with key2, key3, and key4
        byte[] wrappedKey1WithKey2 = wrapKey(key1, key2);
        byte[] wrappedKey1WithKey3 = wrapKey(key1, key3);
        byte[] wrappedKey1WithKey4 = wrapKey(key1, key4);

        // Store the wrapped keys and encrypted data

        // Later, decrypt with one of the wrapped keys
        byte[] unwrappedKey1WithKey2 = unwrapKey(wrappedKey1WithKey2, key2);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(unwrappedKey1WithKey2, "AES"));
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println(new String(decryptedData)); // "Hello, World!"
    }

    private static byte[] wrapKey(SecretKey keyToWrap, SecretKey wrappingKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.WRAP_MODE, wrappingKey);
        return cipher.wrap(keyToWrap);
    }

    private static byte[] unwrapKey(byte[] wrappedKey, SecretKey unwrappingKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.UNWRAP_MODE, unwrappingKey);
        return cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY).getEncoded();
    }
}