/*
 * Decompiled with CFR 0.152.
 */
public class SSLConfigurator {
    public static void main(String[] stringArray) {
    }

    static {
        System.setProperty("javax.net.ssl.trustStore", "/path/to/yourTruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "yourPassword");
    }
}
