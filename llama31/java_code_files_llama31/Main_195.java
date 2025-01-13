/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Main_195 {
    public static void main(String[] stringArray) throws Exception {
        String string = "your_private_key_here";
        String string2 = "your_public_key_here";
        PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(string.getBytes());
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(string2.getBytes());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        byte[] byArray = "Hello, World!".getBytes();
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(byArray);
        byte[] byArray2 = signature.sign();
        Signature signature2 = Signature.getInstance("SHA256withRSA");
        signature2.initVerify(publicKey);
        signature2.update(byArray);
        boolean bl = signature2.verify(byArray2);
        System.out.println("Is signature valid? " + bl);
    }
}
