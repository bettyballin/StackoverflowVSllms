import java.lang.String;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SelfSignedHttpClient {

    public static DefaultHttpClient getNewHttpClient(InputStream keyStore, char[] passphrase) {
        try {
            KeyStore trustore = KeyStore.getInstance(KeyStore.getDefaultType());
            // Load your self-signed certificate here.
            trustore.load(keyStore, passphrase);

            SSLSocketFactory socketFactory = new SelfSignedSSLSocketFactory(trustore);
            Scheme sch = new Scheme("https", socketFactory, 443);
            ClientConnectionManager ccm = new SingleClientConnManager();
            ccm.getSchemeRegistry().register(sch);

            return new DefaultHttpClient(ccm);
        } catch (Exception e) {
            Log.e("SelfSignedHttpClient", "Error occurred while loading keystore or creating SSL context", e);
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
    }
}

class SelfSignedSSLSocketFactory extends SSLSocketFactory {
    SSLContext sslContext = SSLContext.getInstance("TLS");

    public SelfSignedSSLSocketFactory(KeyStore truststore) throws Exception {
        super(truststore);

        TrustManager tm = new X509TrustManager() {

            public void checkClientTrusted(X509Certificate[] chain, String authType)
                    throws CertificateException {
                // Accept all client certificates
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType)
                    throws CertificateException {
                // Accept all server certificates
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

        };

        sslContext.init(null, new TrustManager[]{tm}, null);

    }

    @Override
    public Socket createSocket(Socket socket, String host, int port, boolean autoClose)
            throws IOException, UnknownHostException {
        return sslContext.getSocketFactory().createSocket(socket, host, port,
                autoClose);
    }

    @Override
    public Socket createSocket() throws IOException {
        return sslContext.getSocketFactory().createSocket();
    }
}

class Log {
    public static void e(String tag, String msg, Throwable tr) {
        System.err.println(tag + ": " + msg);
        tr.printStackTrace(System.err);
    }
}