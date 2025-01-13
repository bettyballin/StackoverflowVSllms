/*
 * Decompiled with CFR 0.152.
 */
import java.security.KeyStore;

public class Main_772 {
    public static void main(String[] stringArray) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, "password".toCharArray());
    }
}
