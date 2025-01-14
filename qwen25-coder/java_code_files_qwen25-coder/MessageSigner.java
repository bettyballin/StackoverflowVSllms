import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class MessageSigner {
    private static final int SPLIT_PARTS = 3;

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        // Simulate splitting the private key into parts
        byte[][] splitPrivateKeys = splitPrivateKey(pair.getPrivate().getEncoded());

        // Reconstruct the private key from parts (should be done in a secure manner and preferably not on client side)
        PrivateKey privateKey = reconstructPrivateKey(splitPrivateKeys);

        String message = "HighScore=100";
        byte[] signatureBytes = signMessage(privateKey, message.getBytes());

        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signatureBytes));
    }

    private static byte[][] splitPrivateKey(byte[] privateKey) {
        // Simple naive example of splitting
        byte[][] parts = new byte[SPLIT_PARTS][(privateKey.length / SPLIT_PARTS)];
        for (int i = 0; i < SPLIT_PARTS; i++) {
            System.arraycopy(privateKey, i * parts[i].length, parts[i], 0, parts[i].length);
        }
        return parts;
    }

    private static PrivateKey reconstructPrivateKey(byte[][] splitKeys) throws Exception {
        byte[] combined = new byte[splitKeys.length * splitKeys[0].length];
        for (int i = 0; i < splitKeys.length; i++) {
            System.arraycopy(splitKeys[i], 0, combined, i * splitKeys[i].length, splitKeys[i].length);
        }
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(new PKCS8EncodedKeySpec(combined));
    }

    private static byte[] signMessage(PrivateKey privateKey, byte[] messageBytes) throws Exception {
        Signature signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(privateKey);
        signature.update(messageBytes);
        return signature.sign();
    }
}