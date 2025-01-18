import java.lang.String;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.nio.charset.*;
import java.util.Base64;

public class Main_230 {
    public static void main(String[] args) throws Exception {
        String secretKey = "my-secret-key-should-be-32-bytes"; // 32 byte common key base64 encoded
        String plaintext = "username_to_send";
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(secretKey), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[cipher.getBlockSize()]); // Create a zero-filled initialization vector as Java and PHP will automatically expect it
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        String ciphertext = Base64.getEncoder().encodeToString(cipher.doFinal(plaintext.getBytes("UTF-8"))); // base64 encoded cipher text to send in query
    }
}