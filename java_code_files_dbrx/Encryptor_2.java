import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class Encryptor {
    public static void main(String[] args) throws Exception {
        String input = "namedata" + "hello";    // Your input string for encryption

        // Define keySym
        byte[] keySym = new byte[16]; // 16-byte key (128-bit key for AES)

        // Define a zero IV (Initialization Vector)
        byte[] iv = new byte[16]; // 16-byte IV for AES
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keySym, "AES"), ivSpec);
        String keyCode = Base64.getEncoder().encodeToString(aesCipher.doFinal(input.getBytes("UTF-8")));   // Ciphertext - your 'key code' for the user to enter in game app

        System.out.println("Key code: " + keyCode);
    }
}