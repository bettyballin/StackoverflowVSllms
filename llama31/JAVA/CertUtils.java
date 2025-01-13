import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.util.*;

import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;

public class CertUtils {
    public static byte[] getBytesFromInputStream(InputStream is) {
        try {
            return IOUtils.toByteArray(is);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<X509Certificate> getCertificatesFromP12File(
            InputStream p12FileStream, String p12Password)
            throws CertificateException, IOException {
        final CertificateFactory certificateFactory = CertificateFactory
                .getInstance("X.509");
        final List<X509Certificate> certificates = new ArrayList<X509Certificate>();
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(p12FileStream, p12Password.toCharArray());
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String alias = (String) aliases.nextElement();
            Certificate cert = keyStore.getCertificate(alias);
            X509Certificate x509Cert = (X509Certificate) cert;
            certificates.add(x509Cert);
        }
        return certificates;
    }

    public static X509TrustManager getX509TrustManagerFromP12File(
            InputStream p12FileStream, String p12Password)
            throws CertificateException, IOException {
        final X509TrustManager[] x509TrustManagers = new X509TrustManager[1];
        x509TrustManagers[0] = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1)
                    throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1)
                    throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                List<X509Certificate> certificates = getCertificatesFromP12File(
                        p12FileStream, p12Password);
                X509Certificate[] x509Certificates = new X509Certificate[certificates
                        .size()];
                certificates.toArray(x509Certificates);
                return x509Certificates;
            }
        };
        return x509TrustManagers[0];
    }

    public static void main(String[] args) {
    }
}