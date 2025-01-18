import java.lang.String;
import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class Main_342 {
  public static void main(String[] args) throws Exception {
    if(args.length < 3) {
      System.err.println("Usage: java Main_342 <AUTH_SERVER> <uname> <pass>");
      return;
    }
    String AUTH_SERVER = args[0];
    String uname = args[1];
    String pass = args[2];

    URL url = new URL("https://" + AUTH_SERVER + "/auth/authenticate.asp?pt1="
                     + URLEncoder.encode(uname, "UTF-8") + "&pt2=" +
                     URLEncoder.encode(pass, "UTF-8") + "&pt4=full");
    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    int responseCode = conn.getResponseCode();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    String inputLine;
    StringBuilder response = new StringBuilder();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    System.out.println("The server replied: " + response.toString());
  }
}