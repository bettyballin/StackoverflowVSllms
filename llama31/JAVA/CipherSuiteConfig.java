import java.lang.String;

public class CipherSuiteConfig {
    String[] enabledCipherSuites = new String[] {
        "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_RSA_WITH_AES_128_GCM_SHA256"
    };

    public static void main(String[] args) {
        CipherSuiteConfig config = new CipherSuiteConfig();
        for (String suite : config.enabledCipherSuites) {
            System.out.println(suite);
        }
    }
}