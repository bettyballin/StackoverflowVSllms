import java.lang.String;
public class TLSCipherSuiteConstants {
    String[] cipherSuites = {
        "TLS_AES_128_GCM_SHA256", // TLS 1.3
        "TLS_AES_256_GCM_SHA384", // TLS 1.3
        "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
        "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
        "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384",
        "TLS_ECDHE_RSAC_WITH_AES_128_CBC_SHA256"
    };
    public static void main(String[] args) {
    }
}