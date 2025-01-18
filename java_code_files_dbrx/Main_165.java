import java.lang.String;
import java.io.*;
import java.net.URL;
import javax.net.ssl.*;

public class Main_165 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com");  // Replace with your webservice's URL

        SSLContext sslcontext = SSLContext.getInstance("TLS");

        // Create a trust manager that will purposefully accept any certificate we encounter:
        TrustManager[]   trustAllCerts = new TrustManager[]{new X509TrustManager(){
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {return null;}
            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
        }};

        // Create a context with our custom trust manager:
        sslcontext.init(null, trustAllCerts, new java.security.SecureRandom());

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setSSLSocketFactory(sslcontext.getSocketFactory());
        connection.connect(); // It'll use the custom trust manager now, and will work for all certificates!

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // Consume the input stream and print it out, just for debugging purpose!
        }
    }
}