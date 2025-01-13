import java.security.*;
import java.security.spec.*;

public class Main_636 {
    public static void main(String[] args) throws Exception {
        // Generate a private key and a corresponding public key
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048); // Key size
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();

        // Data to sign (product key)
        byte[] data = "product-key-123".getBytes();

        // Sign the data using the private key
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initSign(privateKey);
        sig.update(data);
        byte[] signature = sig.sign();

        // Verify the signature using the public key
        sig.initVerify(publicKey);
        sig.update(data);
        boolean isValid = sig.verify(signature);

        System.out.println("Is signature valid? " + isValid);
    }
}