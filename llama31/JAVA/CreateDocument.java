import java.lang.String;
import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

public class CreateDocument {
    public static void main(String[] args) throws Exception {
        // Create a new text document
        OdfTextDocument doc = new OdfTextDocument();

        // Add some text
        doc.addText("Hello, World!");

        // Save the document
        doc.save("example.odt");
    }
}