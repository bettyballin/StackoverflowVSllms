import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Arrays;

public class Main_806 {
    public static void main(String[] args) throws Exception {
        // Assume 'data' is the received object with encrypted score and signature
        String encryptedScore = "your_encrypted_score"; // Replace with actual encrypted score
        String signature = "your_signature"; // Replace with actual signature
        byte[] privateKeyBytes = "your_private_key_bytes".getBytes(); // Replace with actual private key bytes
        String sharedSecretKey = "your_shared_secret_key"; // Replace with actual shared secret key

        // Load the private key (in PKCS#8 format) from a secure source
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));

        // Verify the digital signature
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(sharedSecretKey.getBytes(), "HmacSHA256"));
        byte[] expectedSignature = mac.doFinal(Base64.getDecoder().decode(encryptedScore));
        if (!Arrays.equals(expectedSignature, Base64.getDecoder().decode(signature))) {
            // Signature verification failed
            System.out.println("Signature verification failed");
            return; // Add a return statement to exit the program if signature verification fails
        }

        // Decrypt the score using the private key
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        String score = new String(cipher.doFinal(Base64.getDecoder().decode(encryptedScore)));
        System.out.println("Decrypted score: " + score);
    }
}