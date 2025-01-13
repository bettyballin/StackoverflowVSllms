import java.lang.String;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureExample {
    public static void main(String[] args) throws Exception {
        // Generate a key pair
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();

        // Create a signature
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(privateKey);
        byte[] data = "Hello, World!".getBytes();
        sig.update(data);
        byte[] signature = sig.sign();

        // Verify the signature
        sig.initVerify(publicKey);
        sig.update(data);
        boolean verified = sig.verify(signature);
        System.out.println("Verified: " + verified);
    }
}