import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class MyClass {
    public static void main(String[] args) throws Exception {
        HttpsURLConnection con = (HttpsURLConnection) new URL("https://localhost")
          .openConnection();
        // add headers, set method and other properties...
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        PrintWriter out = new PrintWriter(con.getOutputStream());
        out.print("<message data>");
        // ...
    }
}