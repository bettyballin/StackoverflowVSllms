import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main_365 {
    public static void main(String[] args) {
        // assume 'htmlChunk' is the HTML string you want to render
        String htmlChunk = "<p>Hello, <b>World!</b></p>";

        // parse the HTML chunk using Jsoup
        Document doc = Jsoup.parse(htmlChunk);

        // render the parsed HTML as a string
        String renderedHtml = doc.html();

        // use the rendered HTML to generate your PDF
        System.out.println(renderedHtml);
    }
}