import javax.net.ssl.*;
import java.io.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;

public class Main {
    public static void main(String[] args) throws Exception {
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, new TrustManager[]{ new MyTrustManager() }, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        // Add any additional code here if needed
    }
}

class MyTrustManager implements X509TrustManager {
    private static final X509Certificate[] _AcceptedIssuers = new X509Certificate[]{};
    
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        // Trust all client certificates
    }
    
    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        // Trust all server certificates
    }
    
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return _AcceptedIssuers;
    }
}