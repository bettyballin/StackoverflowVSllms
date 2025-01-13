/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.security.KeyStore;

public class KeystoreLoader {
    public static void main(String[] stringArray) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        FileInputStream fileInputStream = new FileInputStream("keystore.jks");
        char[] cArray = "mysecretpassword".toCharArray();
        keyStore.load(fileInputStream, cArray);
    }
}
