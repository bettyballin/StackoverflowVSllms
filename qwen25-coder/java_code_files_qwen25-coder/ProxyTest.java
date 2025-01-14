import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class ProxyTest {
    public static void main(String[] args) throws Exception {
        // Set the proxy host and port
        System.setProperty("https.proxyHost", "proxy.address");
        System.setProperty("https.proxyPort", "8080");

        // Set up authenticator with username and password for the proxy server
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "username", "password".toCharArray());
            }
        });

        // Make a request to an SSL URL
        URL url = new URL("https://ssl.site");
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

        int responseCode = httpCon.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}