import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlFetcher {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com"); // replace with the desired URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder htmlBuilder = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                htmlBuilder.append(line).append("\n");
            }

            reader.close();
            String html = htmlBuilder.toString();
            System.out.println(html);

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch (IOException e) {
            System.out.println("Failed to fetch HTML: " + e.getMessage());
        }
    }
}