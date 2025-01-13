import java.lang.String;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownExample {
    public static void main(String[] args) {
        String markdown = "# Heading\n## Subheading\n\nThis is a paragraph of text.\n\n* Item 1\n* Item 2\n* Item 3\n\n[Link text](http://www.example.com)";
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(document);
        System.out.println(html);
    }
}