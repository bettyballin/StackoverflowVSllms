import javax.crypto.Cipher;
import java.security.PrivateKey;

public class Main {
    public static void main(String[] args) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA"); // specify a padding type as needed...
        PrivateKey privateKey = null; // Initialize with your actual private key
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encryptedBytes = cipher.doFinal(longNumberToByteArray(123456789012L)); // convert your 12-digit number to byte format before encryption
    }

    public static byte[] longNumberToByteArray(long number) {
        // Convert long to byte array
        return java.nio.ByteBuffer.allocate(8).putLong(number).array();
    }
}