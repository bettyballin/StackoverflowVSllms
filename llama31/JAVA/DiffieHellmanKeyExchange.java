import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class DiffieHellmanKeyExchange {
    public static void main(String[] args) throws Exception {
        // Alice's private and public keys
        KeyPairGenerator aliceKeyGen = KeyPairGenerator.getInstance("DH");
        aliceKeyGen.initialize(2048);
        KeyPair aliceKeyPair = aliceKeyGen.generateKeyPair();
        PrivateKey alicePrivateKey = aliceKeyPair.getPrivate();
        PublicKey alicePublicKey = aliceKeyPair.getPublic();

        // Bob's private and public keys
        KeyPairGenerator bobKeyGen = KeyPairGenerator.getInstance("DH");
        bobKeyGen.initialize(2048);
        KeyPair bobKeyPair = bobKeyGen.generateKeyPair();
        PrivateKey bobPrivateKey = bobKeyPair.getPrivate();
        PublicKey bobPublicKey = bobKeyPair.getPublic();

        // Alice sends her public key to Bob
        KeyAgreement aliceKeyAgreement = KeyAgreement.getInstance("DH");
        aliceKeyAgreement.init(alicePrivateKey);
        aliceKeyAgreement.doPhase(bobPublicKey, true);
        byte[] aliceSharedSecret = aliceKeyAgreement.generateSecret();

        // Bob sends his public key to Alice
        KeyAgreement bobKeyAgreement = KeyAgreement.getInstance("DH");
        bobKeyAgreement.init(bobPrivateKey);
        bobKeyAgreement.doPhase(alicePublicKey, true);
        byte[] bobSharedSecret = bobKeyAgreement.generateSecret();

        // Both Alice and Bob now have the shared secret key
        SecretKeySpec sharedSecretKey = new SecretKeySpec(aliceSharedSecret, "AES");
        // Use the shared secret key for encryption and decryption
    }
}