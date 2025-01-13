import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.util.Arrays;

import javax.crypto.Cipher;

public class Main_335 {
    public static void main(String[] args) throws Exception {
        // Define alias and password
        String alias = "your_alias";
        String password = "your_password";

        // Generate a key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048); // key size
        KeyPair kp = kpg.generateKeyPair();

        // Encrypt and store password
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, kp.getPublic());
        byte[] encryptedPassword = cipher.doFinal(password.getBytes());

        // Print encrypted password
        System.out.println(Arrays.toString(encryptedPassword));
    }
}