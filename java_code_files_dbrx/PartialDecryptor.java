import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class PartialDecryptor {
    public void PartialDecrypt() throws Exception {
        byte[] buffer = new byte[1000]; // The 1000 bytes buffer.
        // Initialize buffer with sample data (optional)
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) i;
        }

        byte[] keyByte = new byte[16]; // AES requires a 16-byte key for 128-bit encryption.
        // Initialize keyByte with sample data (optional)
        for (int i = 0; i < keyByte.length; i++) {
            keyByte[i] = (byte) i;
        }

        // Encryption: Divide the content into two chunks, then encrypt independently.
        Cipher ci = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        SecretKeySpec key = new SecretKeySpec(keyByte, "AES");

        ci.init(Cipher.ENCRYPT_MODE, key);
        byte[] cryptedChunk1 = ci.doFinal(Arrays.copyOfRange(buffer, 0, 500));

        // Re-initialize the cipher for the next chunk
        ci.init(Cipher.ENCRYPT_MODE, key);
        byte[] cryptedChunk2 = ci.doFinal(Arrays.copyOfRange(buffer, 500, buffer.length));

        // Decryption: If you just want to decrypt the second chunk.
        Cipher dc = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        SecretKeySpec dk = new SecretKeySpec(keyByte, "AES");

        dc.init(Cipher.DECRYPT_MODE, dk);
        byte[] decryptedChunk2 = dc.doFinal(cryptedChunk2);

        // (Optional) Display the decrypted data
        System.out.println("Decrypted Chunk 2: " + Arrays.toString(decryptedChunk2));
    }

    public static void main(String[] args) throws Exception {
        PartialDecryptor pd = new PartialDecryptor();
        pd.PartialDecrypt();
    }
}