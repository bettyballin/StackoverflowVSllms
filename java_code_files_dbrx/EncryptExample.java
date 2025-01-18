import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class EncryptExample {
    public static void main(String[] args) throws Exception {
        String str = "secret message!"; // text to encrypt
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        byte[] iv = new byte[cipher.getBlockSize()]; // IV size must be equal block size of the algorithm
        SecureRandom prng = new SecureRandom();
        prng.nextBytes(iv); // generate random iv
        IvParameterSpec ivParams = new IvParameterSpec(iv);
        SecretKey secretKey = new SecretKeySpec("secret key".getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParams);
        byte[] encryptedData = cipher.doFinal(str.getBytes()); // encryption
    }
}