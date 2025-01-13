/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class ClientCertExample {
    public static void main(String[] stringArray) throws Exception {
        int n;
        KeyStore keyStore = KeyStore.getInstance("JKS");
        keyStore.load(new FileInputStream("/path/to/keystore"), "keystorepassword".toCharArray());
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
        keyManagerFactory.init(keyStore, "clientcertpassword".toCharArray());
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerFactory.getKeyManagers(), null, null);
        SSLSocketFactory sSLSocketFactory = sSLContext.getSocketFactory();
        URL uRL = new URL("https://somehost.dk:3049");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)uRL.openConnection();
        httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
        httpsURLConnection.connect();
        InputStream inputStream = httpsURLConnection.getInputStream();
        while ((n = inputStream.read()) != -1) {
            System.out.print((char)n);
        }
        inputStream.close();
    }
}
