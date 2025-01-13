import java.lang.String;

public class DigitalSignatureVerifier {

    // Alice sends a message to Bob with a digital signature
    static String message = "Hello, Bob!";
    static String alicePrivateKey = "alice_private_key";
    static String signature = sign(message, alicePrivateKey);

    // Bob verifies the signature
    static String alicePublicKey = "alice_public_key";
    static boolean isValid = verify(message, signature, alicePublicKey);

    public static void main(String[] args) {
        if (isValid) {
            System.out.println("Alice sent the message and cannot deny it.");
        }
    }

    // Dummy implementation for sign and verify methods
    public static String sign(String message, String privateKey) {
        return "dummy_signature";
    }

    public static boolean verify(String message, String signature, String publicKey) {
        return true; // Always returns true for demonstration purposes
    }
}