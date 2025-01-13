/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class Main_258 {
    public static void main(String[] stringArray) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(3072);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        Signature signature = Signature.getInstance("SHA512withRSA");
        byte[] byArray = "Hello, World!".getBytes();
        signature.initSign(keyPair.getPrivate());
        signature.update(byArray);
        byte[] byArray2 = signature.sign();
        signature.initVerify(keyPair.getPublic());
        signature.update(byArray);
        boolean bl = signature.verify(byArray2);
        System.out.println("Signature verified: " + bl);
    }
}
