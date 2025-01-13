import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLConnection;

public class ProxyTest {

  public static void main(String[] args) throws Exception {
    URL url = new URL("https://ssl.site");

    // Set the proxy authentication
    Authenticator.setDefault(new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("proxy_username", "proxy_password".toCharArray());
      }
    });

    // Set the proxy
    System.setProperty("http.proxyHost", "proxy.address");
    System.setProperty("http.proxyPort", "8080");

    URLConnection connection = url.openConnection();
    InputStream inputStream = connection.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
    String tmpLine = "";

    while ((tmpLine = br.readLine()) != null) {
      System.out.println(tmpLine);
    }
  }
}