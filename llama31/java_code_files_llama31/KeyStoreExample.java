/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileOutputStream;
import java.security.KeyStore;
import javax.crypto.spec.SecretKeySpec;

public class KeyStoreExample {
    public static void main(String[] stringArray) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(null, null);
        SecretKeySpec secretKeySpec = new SecretKeySpec("mysecretkey".getBytes(), "AES");
        keyStore.setKeyEntry("mykey", secretKeySpec, "mypassword".toCharArray(), null);
        keyStore.store(new FileOutputStream("keystore.jks"), "mypassword".toCharArray());
    }
}
