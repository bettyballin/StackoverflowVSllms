/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;
import javax.crypto.Cipher;

public class Main_817 {
    public static void main(String[] stringArray) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec eCGenParameterSpec = new ECGenParameterSpec("secp256r1");
        keyPairGenerator.initialize(eCGenParameterSpec, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        byte[] byArray = "Score Data".getBytes();
        Cipher cipher = Cipher.getInstance("ECIES");
        cipher.init(1, publicKey);
        byte[] byArray2 = cipher.doFinal(byArray);
        Signature signature = Signature.getInstance("SHA256withECDSA");
        signature.initSign(privateKey);
        signature.update(byArray2);
        byte[] byArray3 = signature.sign();
        Signature signature2 = Signature.getInstance("SHA256withECDSA");
        signature2.initVerify(publicKey);
        signature2.update(byArray2);
        boolean bl = signature2.verify(byArray3);
        if (bl) {
            System.out.println("Digital signature is valid");
        } else {
            System.out.println("Digital signature is invalid");
        }
        Cipher cipher2 = Cipher.getInstance("ECIES");
        cipher2.init(2, privateKey);
        byte[] byArray4 = cipher2.doFinal(byArray2);
        System.out.println(new String(byArray4));
    }
}
