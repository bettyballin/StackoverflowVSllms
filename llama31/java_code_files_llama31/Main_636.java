/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class Main_636 {
    public static void main(String[] stringArray) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        byte[] byArray = "product-key-123".getBytes();
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(byArray);
        byte[] byArray2 = signature.sign();
        signature.initVerify(publicKey);
        signature.update(byArray);
        boolean bl = signature.verify(byArray2);
        System.out.println("Is signature valid? " + bl);
    }
}
