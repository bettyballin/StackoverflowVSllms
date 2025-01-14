import java.lang.String;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser_3 {
    public static void main(String[] args) {
        try {
            // URL of the web page to fetch
            URL url = new URL("http://example.com");
            Scanner scanner = new Scanner(url.openStream());
            
            // Read all content from the URL into a single String
            String content = "";
            while (scanner.hasNext()) {
                content += scanner.nextLine();
            }
            scanner.close();

            // Regex pattern to find the 'value' attribute of the <meta> tag with name="generator"
            Pattern pattern = Pattern.compile("<meta\\s+name=\"generator\"\\s+value=\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(content);

            if (matcher.find()) {
                String value = matcher.group(1);
                System.out.println("The value is: " + value);
            } else {
                System.out.println("Value not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}