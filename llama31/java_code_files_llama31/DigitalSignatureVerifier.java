/*
 * Decompiled with CFR 0.152.
 */
public class DigitalSignatureVerifier {
    static String message = "Hello, Bob!";
    static String alicePrivateKey = "alice_private_key";
    static String signature = DigitalSignatureVerifier.sign(message, alicePrivateKey);
    static String alicePublicKey = "alice_public_key";
    static boolean isValid = DigitalSignatureVerifier.verify(message, signature, alicePublicKey);

    public static void main(String[] stringArray) {
        if (isValid) {
            System.out.println("Alice sent the message and cannot deny it.");
        }
    }

    public static String sign(String string, String string2) {
        return "dummy_signature";
    }

    public static boolean verify(String string, String string2, String string3) {
        return true;
    }
}
