import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.Provider;

public class AESEncryptor {
    public static void main(String[] args) throws Exception {
        Provider provider = null; // Initialize your provider here
        Key key = null; // Initialize your key here
        IvParameterSpec ivspec = null; // Initialize your IvParameterSpec here
        String plainTxt = "Your plaintext here"; // Provide your plaintext here

        Cipher encrypt = Cipher.getInstance("AES/CBC/PKCS5Padding", provider);
        encrypt.init(Cipher.ENCRYPT_MODE, key, ivspec); // Don't forget to pass an IvParameterSpec for CBC mode
        byte[] encrypted = encrypt.doFinal(plainTxt.getBytes());
    }
}