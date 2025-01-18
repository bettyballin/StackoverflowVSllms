// Encrypt/decrypt data using AES in Google's Tink library.

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import javax.crypto.AEADBadTagException;
import java.security.GeneralSecurityException;

public class EncryptionExample {
    public static void main(String[] args) throws Exception {
        // Initialize AES algorithm with a key material.
        AeadConfig.register();

        KeysetHandle keysetHandle = getKeysetHandle(); // Load the encrypted keyset from your secure storage and decrypt it.

        // Create an instance of AEAD cipher (e.g., AesGcm).
        String algorithm = "AES128-GCM";
        Aead aead = keysetHandle.getPrimitive(Aead.class);

        // Encrypt/decrypt some plaintext.
        byte[] ciphertext = null;
        try {
            byte[] plainText = getPlainText(); // The text to be encrypted or decrypted.
            ciphertext = aead.encrypt(plainText, new byte[0]);
            System.out.println("Ciphertext: " + bytesToHexString(ciphertext));
        } catch (GeneralSecurityException e) {
            // Handle encryption errors.
            e.printStackTrace();
        }

        try {
            byte[] decryptedText = aead.decrypt(ciphertext, new byte[0]);
            System.out.println("Plaintext: " + new String(decryptedText));
        } catch (GeneralSecurityException e) {
            // Handle decryption errors.
            e.printStackTrace();
        }
    }

    private static KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        // Load the encrypted keyset from your secure storage and decrypt it.
        // Placeholder implementation.
        // For this example, we generate a new keyset.
        return KeysetHandle.generateNew(AeadKeyTemplates.AES128_GCM);
    }

    private static byte[] getPlainText() {
        // Return the plaintext to be encrypted or decrypted.
        // Placeholder implementation.
        return "Hello, World!".getBytes();
    }

    private static String bytesToHexString(byte[] bytes) {
        // Convert bytes to hex string.
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}