/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class CodeSigner {
    public static void main(String[] stringArray) {
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("keystore.jks"), "password".toCharArray());
            X509Certificate x509Certificate = (X509Certificate)keyStore.getCertificate("alias");
            PrivateKey privateKey = (PrivateKey)keyStore.getKey("alias", "password".toCharArray());
        }
        catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
