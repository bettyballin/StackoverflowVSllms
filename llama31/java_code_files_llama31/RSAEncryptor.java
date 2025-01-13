/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

public class RSAEncryptor {
    public static void main(String[] stringArray) throws Exception {
        byte[] byArray;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] byArray2 = "Hello, World!".getBytes();
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, publicKey);
        for (byte by : byArray = cipher.doFinal(byArray2)) {
            System.out.print(by + " ");
        }
    }
}
