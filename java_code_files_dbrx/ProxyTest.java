import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class ProxyTest {
    public static void main(String[] args) throws IOException {
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("proxy_user", "proxy_password".toCharArray());
            }
        };
        Authenticator.setDefault(authenticator);

        URL url = new URL("https://ssl.site");
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy_address", 8080));
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection(proxy);

        InputStream inputStream = null;
        BufferedReader br = null;
        String tmpLine = "";

        try {
            inputStream = connection.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));

            while ((tmpLine = br.readLine()) != null) {
                System.out.println(tmpLine);
            }
        } finally {
            if (br != null) br.close();
            if (inputStream != null) inputStream.close();
            // It is important to close the streams in reverse-order - first buffered reader, then stream.
        }
    }
}