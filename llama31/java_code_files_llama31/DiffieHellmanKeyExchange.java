/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;

public class DiffieHellmanKeyExchange {
    public static void main(String[] stringArray) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("DH");
        keyPairGenerator2.initialize(2048);
        KeyPair keyPair2 = keyPairGenerator2.generateKeyPair();
        PrivateKey privateKey2 = keyPair2.getPrivate();
        PublicKey publicKey2 = keyPair2.getPublic();
        KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(publicKey2, true);
        byte[] byArray = keyAgreement.generateSecret();
        KeyAgreement keyAgreement2 = KeyAgreement.getInstance("DH");
        keyAgreement2.init(privateKey2);
        keyAgreement2.doPhase(publicKey, true);
        byte[] byArray2 = keyAgreement2.generateSecret();
        SecretKeySpec secretKeySpec = new SecretKeySpec(byArray, "AES");
    }
}
