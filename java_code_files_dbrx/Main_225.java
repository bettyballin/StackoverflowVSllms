import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.io.ByteArrayOutputStream;

public class Main {
    static String key = "ExampleEncryptionKey123"; // Use proper encryption, don't use simple XOR with same fixed-length key for any real application
    public static void main(String[] args) throws Exception{
        // Loads base64 encoded byte array from file.
        byte[] encryptedStringFromFile = Base64.getDecoder().decode("VXNpZGxpbmUYCg=="); // Example data loaded from an actual ini/registry/db.

        // Uses symmetric cipher for decryption with XOR method using same key as encryption, then writes plain text to another byte array.
        final byte[] decryptedString = toPlainText(encryptedStringFromFile, key.getBytes(StandardCharsets.UTF_8));

        // Does operations with data then immediately overwrite and zeros out the sensitive bytes.
        doSomethingWithDecryptedData(decryptedString);
        Arrays.fill(decryptedString, (byte)0x25); // Using '%' as placeholder for zeroed-out byte in this example.
    }

    static void doSomethingWithDecryptedData(byte[] decryptedBytes){
        System.arraycopy(decryptedBytes, 0, new byte[4], 0, Math.min(4, decryptedBytes.length)); // Copy to another array for processing
        // Perform useful operations with data here (e.g., parsing XML docs, sending requests etc).
        System.out.println("Decrypted data: " + new String(decryptedBytes));
    }

    public static byte[] toPlainText(byte[] rawCipherData, byte[] keyBytes) throws Exception {
        int inputLen = rawCipherData.length;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // Stream buffer for decrypted bytes.
        int keyLen = keyBytes.length;
        for (int i = 0; i < inputLen; i++) {
            int keyIndex = i % keyLen;
            byte decryptedByte = (byte)(rawCipherData[i] ^ keyBytes[keyIndex]);
            outputStream.write(decryptedByte);
        }
        return outputStream.toByteArray();
    }
}