import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCipherEncryption {

    public AESCipherEncryption() throws Exception {
        SecretKey secretKey = new SecretKeySpec("your_secret_key".getBytes("UTF8"), "AES"); // replace your_secret_key with the actual key
        Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding"); // AES in cipher feedback mode, PKCS#7 Padding
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] dataBytes = "yourData".getBytes("UTF8"); // replace yourData with the payload data
        byte[] encryptedData = cipher.doFinal(dataBytes);
        // You can add code here to use the encryptedData, such as printing or storing it
    }

    public static void main(String[] args) throws Exception {
        new AESCipherEncryption();
    }
}