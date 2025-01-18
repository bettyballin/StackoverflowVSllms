import java.io.*;
import java.net.Socket;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class SSLChecker {
    public static void main(String[] args) throws IOException, KeyStoreException,
            CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException,
            KeyManagementException{
        String host = "<example.com>";
        int port = 443;
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLSv1");
            X509TrustManager tm = new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {}
                public void checkServerTrusted(X509Certificate[] xcs, String string)throws CertificateException{}
                public X509Certificate[] getAcceptedIssuers() {return null; }
            };
            ctx.init(null, new TrustManager[]{tm}, null);
        } catch (GeneralSecurityException e) {}
        SSLSocketFactory factory = ctx.getSocketFactory();
        try (SSLSocket sslSocket = (SSLSocket) factory.createSocket(host, port)) {
            sslSocket.startHandshake();
            SSLSession sess = sslSocket.getSession();
            for (Certificate cert : sess.getPeerCertificates()) {
                System.out.println(cert);
            }
        } // auto-closes sockets
    }
}