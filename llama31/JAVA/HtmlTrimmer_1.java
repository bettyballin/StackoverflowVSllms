import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class HtmlTrimmer_1_1 {
    public static String trimHtml(String html, int length) {
        Document doc = Jsoup.parse(html);
        StringBuilder text = new StringBuilder();
        for (Element element : doc.getAllElements()) {
            for (TextNode node : element.textNodes()) {
                text.append(node.text());
            }
        }
        String trimmedText = text.toString().substring(0, Math.min(text.length(), length));
        int textIndex = 0;
        for (Element element : doc.getAllElements()) {
            for (TextNode node : element.textNodes()) {
                int nodeLength = node.text().length();
                if (textIndex + nodeLength > length) {
                    node.text(trimmedText.substring(textIndex));
                    break;
                }
                textIndex += nodeLength;
            }
        }
        return doc.toString();
    }

    public static void main(String[] args) {
        String html = "<p>This problem is a challenging one. Our application allows users to post news on the homepage. That news is input via a rich text editor which allows HTML. On the homepage we want to only display a truncated summary of the news item.</p>";
        System.out.println(trimHtml(html, 250));
    }
}