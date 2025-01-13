import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_813_813 {
    public static void main(String[] args) throws IOException {
        String url = "http://example.com"; // replace with your website URL
        Document document = Jsoup.connect(url).get();

        Elements metaTags = document.select("meta");
        for (Element metaTag : metaTags) {
            String name = metaTag.attr("name");
            if (name.equals("generator")) {
                String value = metaTag.attr("value");
                System.out.println("Value: " + value);
                break;
            }
        }

        // Alternatively, using regular expressions
        String html = document.html();
        Pattern pattern = Pattern.compile("<meta name=\"generator\" value=\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            System.out.println("Value: " + matcher.group(1));
        }
    }
}