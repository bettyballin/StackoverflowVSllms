import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Main_195 {
    public static void main(String[] args) throws Exception {
        // Load private key and public key
        String privateKeyString = "your_private_key_here";
        String publicKeyString = "your_public_key_here";
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyString.getBytes());
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyString.getBytes());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        // File contents to be signed
        byte[] fileContents = "Hello, World!".getBytes();

        // Sign file contents
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(fileContents);
        byte[] signatureBytes = signature.sign();

        // Verify signature
        Signature verification = Signature.getInstance("SHA256withRSA");
        verification.initVerify(publicKey);
        verification.update(fileContents);
        boolean isValid = verification.verify(signatureBytes);

        System.out.println("Is signature valid? " + isValid);
    }
}