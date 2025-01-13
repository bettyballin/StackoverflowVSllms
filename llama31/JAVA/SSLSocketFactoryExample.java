import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLSocketFactory;

public class SSLSocketFactoryExample {
    public static void main(String[] args) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore keyStore1 = LoadKeyStore("path/to/keystore1.jks", "password1");
        KeyStore keyStore2 = LoadKeyStore("path/to/keystore2.jks", "password2");

        MultipleKeyStoreSSLSocketFactory socketFactory = new MultipleKeyStoreSSLSocketFactory(new KeyStore[] {keyStore1, keyStore2}, new char[][] {{'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1'}, {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '2'}});

        Socket socket1 = socketFactory.createSocket("host1", 443);
        Socket socket2 = socketFactory.createSocket("host2", 443);
    }

    public static KeyStore LoadKeyStore(String path, String password) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream(path), password.toCharArray());
        return keyStore;
    }
}

class MultipleKeyStoreSSLSocketFactory extends SSLSocketFactory {
    // implementation of MultipleKeyStoreSSLSocketFactory
}