import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Base64;

public class Main_86 {
    public static void main(String[] args) throws Exception {
        String input = "Hello, World!";
        byte[] key = new byte[32]; // 256-bit key
        new SecureRandom().nextBytes(key);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        byte[] iv = new byte[12]; // 96-bit IV
        new SecureRandom().nextBytes(iv);
        GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv); // 128-bit authentication tag
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, parameterSpec);
        byte[] ciphertext = cipher.doFinal(input.getBytes());
        ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + ciphertext.length);
        byteBuffer.put(iv);
        byteBuffer.put(ciphertext);
        byte[] output = byteBuffer.array();
        System.out.println("Output size: " + output.length);
        System.out.println("Base64-encoded output: " + Base64.getEncoder().encodeToString(output));
    }
}