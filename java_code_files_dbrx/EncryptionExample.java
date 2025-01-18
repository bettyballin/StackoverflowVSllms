import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import java.util.Base64;

public class EncryptionExample {

    public static String encrypt(String password) {

        try {
            // Create DES key and IV using 8 random bytes for each.
            SecureRandom sr = new SecureRandom();
            byte[] rawKeyBytes1 = new byte[8];
            byte[] rawKeyBytes2 = new byte[8];
            sr.nextBytes(rawKeyBytes1);
            sr.nextBytes(rawKeyBytes2);

            // Set 1st key and IVs
            SecretKeySpec skeySpec1 = new SecretKeySpec(rawKeyBytes1, "DES");
            IvParameterSpec ivspec1 = new IvParameterSpec(rawKeyBytes2);

            // Set up Cipher
            Cipher decipher = Cipher.getInstance("DES/CBC/PKCS5PADDING");//Use padding scheme as your code suggest it to be used
            decipher.init(Cipher.ENCRYPT_MODE, skeySpec1, ivspec1);

            // Generate encrypted byte array, encoded with Base64 in the end
            byte[] utf8 = password.getBytes("UTF8");
            byte[] encryptedData = decipher.doFinal(utf8);  // Do it all at once for simplicity's sake; not how you should do this in prod code!
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception ex) {
            // Handle exception
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String password = "your_password_here";
        String encrypted = encrypt(password);
        System.out.println("Encrypted: " + encrypted);
    }
}