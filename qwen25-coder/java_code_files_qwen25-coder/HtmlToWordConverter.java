import java.lang.String;
import com.aspose.words.Document;
import com.aspose.words.LoadOptions;
import com.aspose.words.LoadFormat;
import java.io.InputStream;

public class HtmlToWordConverter {
    public static void main(String[] args) throws Exception {
        String html = "<html><body><h1>This is a header</h1><p>Normal text and <b>bold</b> text.</p></body></html>";

        // Convert HTML to an input stream
        InputStream inputStream = new java.io.ByteArrayInputStream(html.getBytes("UTF-8"));

        // Set the load options to specify the format
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setLoadFormat(LoadFormat.HTML);

        // Create an Aspose Document instance from the HTML stream
        Document document = new Document(inputStream, loadOptions);

        // Save the Document in DOCX format
        document.save("output.docx");
    }
}