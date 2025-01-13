import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DataProcessor {
    // Presentation layer example (simplified)
    public static void main(String[] args) throws Exception {
        byte[] data = "Hello, world!".getBytes();
        byte[] compressed_data = compress(data, "gzip");
        byte[] encrypted_data = encrypt(compressed_data, "AES");
        send_data(encrypted_data);
    }

    public static byte[] compress(byte[] data, String algorithm) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data);
        gzip.close();
        return bos.toByteArray();
    }

    public static byte[] encrypt(byte[] data, String algorithm) throws Exception {
        Key key = new SecretKeySpec("mysecretkey1234".getBytes(), algorithm);
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static void send_data(byte[] data) {
        // Send the data (e.g., over a network connection)
        System.out.println("Sending data...");
        // For demonstration purposes, just print the data
        for (byte b : data) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}