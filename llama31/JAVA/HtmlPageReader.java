import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlPageReader {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://example.com"); // Replace with your URL
        URLConnection conn = url.openConnection();
        String encoding = conn.getContentEncoding(); // Try to get encoding from headers
        
        if (encoding == null) {
            // If encoding is not specified in headers, we'll read the stream to a byte array
            // and then try to determine the encoding from the HTML content
            byte[] content = conn.getInputStream().readAllBytes();
            Document doc = Jsoup.parse(new String(content, StandardCharsets.UTF_8)); // Initially parse with UTF-8
            String metaTagEncoding = doc.selectFirst("meta[charset]") != null ? doc.selectFirst("meta[charset]").attr("charset") : null;
            if (metaTagEncoding != null) {
                encoding = metaTagEncoding;
                // Now that we know the encoding, let's re-parse the HTML content with it
                doc = Jsoup.parse(new String(content, Charset.forName(encoding)));
            }
            // You can use the 'doc' object here for further processing
            System.out.println(doc.toString());
        } else {
            // If encoding is specified, we can directly use it to read the stream
            try (InputStream is = conn.getInputStream();
                 BufferedReader d = new BufferedReader(new InputStreamReader(is, Charset.forName(encoding)))) {
                String line;
                while ((line = d.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
    }
}