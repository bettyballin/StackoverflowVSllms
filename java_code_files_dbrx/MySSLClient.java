import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.HttpsURLConnection;

import java.security.Security;

public class MySSLClient {
    public static void main(String[] args) throws Exception {
        // Load the keystore (key manager)
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        String password = "keystore_password";
        FileInputStream fis = new FileInputStream("/path/to/myKeystore.p12");
        try {
            keyStore.load(fis, password.toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new RuntimeException("Error loading keystore", e);
        } finally {
            // close the input stream or it will leak a file handle
            fis.close();
        }

        // Initialize KeyManagerFactory with the keystore
        String kmfAlgorithm = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        if (kmfAlgorithm == null) {
            kmfAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        }
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(kmfAlgorithm);
        kmf.init(keyStore, password.toCharArray());
        KeyManager[] kms = kmf.getKeyManagers();

        // Load the trust store (trust manager)
        KeyStore trustStore = KeyStore.getInstance("JKS");
        String tspassword = "truststore_password";
        FileInputStream ftis = new FileInputStream("/path/to/myTruststore.jks");
        try {
            trustStore.load(ftis, tspassword.toCharArray());
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new RuntimeException("Error loading trust store", e);
        } finally {
            // close the input stream or it will leak a file handle
            ftis.close();
        }

        // Initialize TrustManagerFactory with the truststore
        String tmfAlgorithm = Security.getProperty("ssl.TrustManagerFactory.algorithm");
        if (tmfAlgorithm == null) {
            tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        }
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(trustStore);
        TrustManager[] tmss = tmf.getTrustManagers();

        // Create the SSL context with our key managers and trust managers set up earlier
        SSLContext sslc = null;
        try {
            sslc = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error setting up SSL context", e);
        }
        sslc.init(kms, tmss, new SecureRandom());

        // Use the HttpsURLConnection class and set it to use our SSLContext
        SSLSocketFactory sof = sslc.getSocketFactory();
        URL url = new URL("https://somehost.dk:3049");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setSSLSocketFactory(sof);
    }
}