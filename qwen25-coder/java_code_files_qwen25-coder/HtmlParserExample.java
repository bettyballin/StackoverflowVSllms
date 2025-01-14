import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlParserExample {
    public static void main(String[] args) {
        String html = "<html>\n" +
                      "    <body>\n" +
                      "        <p>Hello <span id=\"1\">name</span> you are <span id=\"2\">age</span></p>\n" +
                      "    </body>\n" +
                      "</html>";

        Document document = Jsoup.parse(html);
        
        Element nameSpan = document.getElementById("1");
        if (nameSpan != null) {
            nameSpan.text("John");
        }
        
        Element ageSpan = document.getElementById("2");
        if (ageSpan != null) {
            ageSpan.text("99");
        }

        System.out.println(document.outerHtml());
    }
}