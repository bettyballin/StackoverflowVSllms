import java.util.ArrayList;
import java.util.List;
import java.security.KeyStore;
import java.security.PublicKey;
import java.util.Enumeration;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.TrustManager;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509CertSelector;
import java.net.Socket;
import javax.net.ssl.SSLEngine;

public class CertificateValidatorManager {

    List<TrustManager> managers = new ArrayList<>();
    String[] keyTypes = { "RSA", "DSA" };

    public CertificateValidatorManager() throws Exception {
        KeyStore ts = KeyStore.getInstance(KeyStore.getDefaultType());
        ts.load(null, null); // Load an empty keystore

        // Normally, you would load the keystore from a file or resource
        // For this example, we'll assume it has certificates added somewhere

        // For example, add a dummy certificate to the keystore
        // ts.setCertificateEntry("alias", certificate);

        Enumeration<String> aliases = ts.aliases();

        while (aliases.hasMoreElements()) {
            String alias = aliases.nextElement();
            java.security.cert.Certificate cert = ts.getCertificate(alias);

            if (cert instanceof X509Certificate) {
                X509Certificate x509Cert = (X509Certificate) cert;

                try {
                    x509Cert.checkValidity();
                } catch (CertificateException e) {
                    e.printStackTrace();
                    continue; // invalid certificate
                }

                PublicKey publicKey = x509Cert.getPublicKey();
                
                X509CertSelector selector = new X509CertSelector();

                for (String keyType : keyTypes) {
                    if (publicKey.getAlgorithm().equals(keyType)) {
                        // Set the selector's criteria if needed
                        selector.setSubjectPublicKey(publicKey);
                        System.out.println("Key Type is :" + keyType + " And Cert is valid .");
                        X509TrustManager tm = new X509ExtendedTrustManager() {
                            @Override
                            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

                            @Override
                            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException { }

                            @Override
                            public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }

                            @Override
                            public void checkClientTrusted(X509Certificate[] chain, String authType, Socket socket)
                                throws CertificateException {}

                            @Override
                            public void checkServerTrusted(X509Certificate[] chain, String authType, Socket socket)
                                throws CertificateException {}

                            @Override
                            public void checkClientTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
                                throws CertificateException {}

                            @Override
                            public void checkServerTrusted(X509Certificate[] chain, String authType, SSLEngine engine)
                                throws CertificateException {}
                        };

                        managers.add(tm);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new CertificateValidatorManager();
    }
}