import java.lang.String;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class None_46 {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslSocket = (SSLSocket) factory.createSocket("www.example.com", 443);

        sslSocket.setEnabledCipherSuites(new String[] {
            "TLS_RSA_WITH_AES_128_CBC_SHA",         // 1.0
            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA",     // 1.0
            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",   // ECC, 1.0 & TLSv1.3
        });
    }
}