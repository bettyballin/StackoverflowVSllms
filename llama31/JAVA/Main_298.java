import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Main_298 {
    public static void main(String[] args) throws Exception {
        // Receive the base64-encoded public key string from the iPhone app
        String base64PublicKey = "your_base64_encoded_public_key_here";

        // Decode the base64 string to a byte array
        byte[] publicKeyBytes = Base64.getDecoder().decode(base64PublicKey);

        // Create an X509EncodedKeySpec from the byte array
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);

        // Create an RSA key object from the X509EncodedKeySpec
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

        System.out.println("Public Key: " + publicKey);
    }
}