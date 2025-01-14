import java.lang.String;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

public class HtmlTrimmer {

    public static String trimHtml(String html, int maxLength) {
        Document doc = Jsoup.parseBodyFragment(html);
        StringBuilder textBuilder = new StringBuilder();

        // Extract all text while maintaining the structure of HTML nodes
        getTextNodes(doc.body(), textBuilder);

        String trimmedText = textBuilder.substring(0, Math.min(textBuilder.length(), maxLength));

        // Rebuild the HTML with trimmed text keeping original tags
        Document trimmedDoc = Jsoup.parseBodyFragment(replaceWithTrimmedText(doc.body().clone(), trimmedText));
        return trimmedDoc.body().html();
    }

    private static void getTextNodes(Node parent, StringBuilder builder) {
        for (Node node : parent.childNodes()) {
            if (node instanceof TextNode) {
                builder.append(((TextNode) node).getWholeText());
            } else if (!(node instanceof org.jsoup.nodes.Comment)) {
                getTextNodes(node, builder);
            }
        }
    }

    private static String replaceWithTrimmedText(Node node, String trimmedText) {
        StringBuilder builder = new StringBuilder();
        int[] pos = {0}; // Using an array to have a mutable position variable
        appendNodeWithTrimmedText(node, trimmedText, pos, builder);
        return builder.toString();
    }

    private static void appendNodeWithTrimmedText(Node node, String trimmedText, int[] pos, StringBuilder builder) {
        if (node instanceof TextNode) {
            TextNode textNode = (TextNode) node;
            if (pos[0] < trimmedText.length()) {
                String part = textNode.text().substring(0, Math.min(textNode.text().length(), trimmedText.length() - pos[0]));
                builder.append(part);
                pos[0] += part.length();
            }
        } else {
            builder.append("<").append(node.nodeName());
            if (node instanceof Element) {
                Element element = (Element) node;
                for (org.jsoup.nodes.Attribute attr : element.attributes()) {
                    builder.append(" ").append(attr.getKey()).append("=\"").append(attr.getValue()).append("\"");
                }
            }
            if (node.childNodes().isEmpty() || node instanceof org.jsoup.nodes.DataNode) {
                builder.append("/>");
            } else {
                builder.append(">");
                for (Node child : node.childNodes()) {
                    appendNodeWithTrimmedText(child, trimmedText, pos, builder);
                }
                builder.append("</").append(node.nodeName()).append(">");
            }
        }
    }

    public static void main(String[] args) {
        String htmlContent = "<p>In an attempt to make a bit more space in the office, kitchen, I've pulled out all of the random mugs and put them onto the lunch room table. <strong>Unless you feel strongly about the ownership of that Cheyenne Courier mug from 1992 or perhaps that BC Tel Advanced Communications mug from 1997, they will be put in a box and donated to an office in more need of mugs than us.</strong></p>";
        System.out.println(trimHtml(htmlContent, 250));
    }
}