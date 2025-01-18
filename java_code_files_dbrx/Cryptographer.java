import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Cryptographer {
    public static void main(String[] args) throws Exception {
      KeyGenerator keyGen = KeyGenerator.getInstance("AES");
      keyGen.init(128); // for example use 128 bit key size
      SecretKey secretKey = keyGen.generateKey();
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);
      byte[] plainText = "Hello world".getBytes();
      byte[] encryptedText = cipher.doFinal(plainText);
     // Decrypt the output using AES
    }
}