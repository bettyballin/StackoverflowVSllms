import java.lang.String;
import java.net.*;
import java.io.*;
public class Main_113 {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://example.com");
    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
    StringBuilder html = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      html.append(line);
    }
    System.out.println("HTML: " +  html.toString());
    reader.close();
  }
}