import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SSLContext;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class MyActivity_1_1 extends Activity {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Your code here...

        // Example HTTPS POST request
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    URL url = new URL("https://yourserver.com/path");
                    HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                    // If you need to trust a self-signed certificate or a certificate from a non-trusted CA,
                    // customize the SSL context as shown below.
                    // Otherwise, the default SSL context is used.

                    // Trust a specific certificate by creating a custom SSLSocketFactory
                    // SSLContext sslContext = createSSLSocketFactory();
                    // connection.setSSLSocketFactory(sslContext.getSocketFactory());

                    connection.setRequestMethod("POST");
                    connection.setDoOutput(true);
                    // Add headers and data to the request...

                    int responseCode = connection.getResponseCode();
                    Log.d(TAG, "Response code: " + responseCode);
                } catch (Exception e) {
                    Log.e(TAG, "Error making HTTPS request", e);
                }
                return null;
            }
        }.execute();
    }

    // Method to create a custom SSL context that trusts a self-signed certificate.
    // !!Caution!! This significantly compromises the security of your application.
    // Only use this approach for development or with a very clear understanding of the risks.
    private SSLContext createSSLSocketFactory() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        // Load your self-signed certificate as an InputStream
        InputStream is = getResources().openRawResource(R.raw.your_self_signed_certificate);
        // Create a KeyStore and load the certificate into it
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        Certificate ca = cf.generateCertificate(is);
        keyStore.setCertificateEntry("ca", ca);

        // Create a TrustManager that trusts the KeyStore
        String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
        tmf.init(keyStore);

        // Create an SSLContext that uses the TrustManager
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);
        return sslContext;
    }

    public static void main(String[] args) {
    }
}