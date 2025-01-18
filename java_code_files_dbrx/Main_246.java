import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;
 
public class Main {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://yoururl.com");
            // create an HTTP URLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // use one of the following 4 lines to connect with the page,
            // depending on what you want to do:
            // 1. to write and then read from/to it
            //    conn.setDoInput(true); conn.setDoOutput(true);
            // 2. just to retrieve the contents of the URL
            //    conn.setRequestMethod("GET");
            // (no connection will be made if the content has not changed)
            // 3. just to get the response code for a new URLConnection
            //    conn.setRequestMethod("HEAD");
            // no need to read from or write to it after making a request
            // 4. to use POST method, where data is sent back
            //    conn.setDoOutput(true); // send your request body as OutputStream...
        } catch (MalformedURLException e) {
            System.out.println("Error: Malformed URL");
        } catch (IOException e1) {
            System.out.println("Error: IO Exception " + e1.getMessage());
        }
    }
}