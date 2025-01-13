/*
 * Decompiled with CFR 0.152.
 */
public class CipherSuiteConfig {
    String[] enabledCipherSuites = new String[]{"TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_AES_128_GCM_SHA256"};

    public static void main(String[] stringArray) {
        CipherSuiteConfig cipherSuiteConfig = new CipherSuiteConfig();
        for (String string : cipherSuiteConfig.enabledCipherSuites) {
            System.out.println(string);
        }
    }
}
