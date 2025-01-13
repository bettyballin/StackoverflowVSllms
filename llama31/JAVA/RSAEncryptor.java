import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import java.security.spec.PKCS8EncodedKeySpec;

public class RSAEncryptor {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PublicKey userPublicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();

        // Data to be encrypted
        byte[] data = "Hello, World!".getBytes();

        // Encrypt the data
        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.ENCRYPT_MODE, userPublicKey);
        byte[] encryptedData = rsa.doFinal(data);

        // Print the encrypted data
        for (byte b : encryptedData) {
            System.out.print(b + " ");
        }
    }
}