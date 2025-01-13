import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Main_258 {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(3072);
        KeyPair kp = kpg.generateKeyPair();

        // Create a signature instance
        Signature sig = Signature.getInstance("SHA512withRSA");

        // Sign a message
        byte[] message = "Hello, World!".getBytes();
        sig.initSign(kp.getPrivate());
        sig.update(message);
        byte[] signature = sig.sign();

        // Verify the signature
        sig.initVerify(kp.getPublic());
        sig.update(message);
        boolean verified = sig.verify(signature);

        System.out.println("Signature verified: " + verified);
    }
}