import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class EncryptExample {
    public static void main(String[] args) {
        try {
            String plaintext = "Your plaintext here";

            String keyMaterial = "your-secret-key-here"; // should be same as used to decrypt data on PHP side
            SecretKeySpec keySpec = new SecretKeySpec(keyMaterial.getBytes(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec("AAAAAAAAAAAAAA".getBytes());  // fixed IV. In production code, don't hardcode your IV value and secretKeyMaterial
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] encryptedBytes = new byte[cipher.getOutputSize(plaintext.length())];
            int encryptionLength = cipher.update(plaintext.getBytes(), 0, plaintext.length(),
                    encryptedBytes, 0);
            encryptionLength += cipher.doFinal(encryptedBytes, encryptionLength);
            String encryptedStr = Base64.getEncoder().encodeToString(encryptedBytes); // encode to base64 for safe transmission between JSP and PHP pages.

            System.out.println("Encrypted string: " + encryptedStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}