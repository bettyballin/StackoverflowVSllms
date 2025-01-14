// Example of using HTMLEditorKit
import java.io.IOException;
import java.io.StringReader;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class HtmlParserExample_2 {
    public static void main(String[] args) throws IOException, BadLocationException {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        HTMLEditorKit.Parser parser = new ParserDelegator();
        parser.parse(new StringReader(html), null, true);
        // Note: This example is simplified and does not extract content.
    }
}