import java.lang.String;
import java.io.*;
import java.net.*;

public class HtmlPageFetcher {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://example.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        // Get the charset from content-type header if possible
        String contentType = conn.getContentType();
        String charset = null;
        for (String param : contentType.replace(" ", "").split(";")) {
            if (param.startsWith("charset=")) {
                charset = param.split("=")[1];
                break;
            }
        }

        BufferedReader reader;
        if (charset == null) {
            // Fallback to ISO-8859-1 or platform default otherwise
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
        }

        String line;
        StringBuilder html = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            html.append(line);
        }
        reader.close();
        
        System.out.println(html.toString());
    }
}