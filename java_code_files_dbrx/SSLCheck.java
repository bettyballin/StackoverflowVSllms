import java.lang.String;
// Example in Java on how to check if a URL is HTTPS/SSL Enabled
import java.net.*;
public class SSLCheck {
  public static void main(String[] args) throws MalformedURLException {
    String url = "https://yoursite.com"; // enter your site here
    URL myUrl = new URL(url);
    System.out.println("Protocol used: "+myUrl.getProtocol());
  }
}