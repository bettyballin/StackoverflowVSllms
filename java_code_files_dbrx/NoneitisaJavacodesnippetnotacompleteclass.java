import java.lang.String;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class NoneitisaJavacodesnippetnotacompleteclass {
    public static void main(String[] args) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket();
            sslSocket.setEnabledCipherSuites(new String[] {
                "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", // ECC, 1.0
                "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",   // 1.0
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}