import java.net.*;
import java.io.*;

public class MyProgram {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://somewebsite.com");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            //process the line here
        }
    }
}