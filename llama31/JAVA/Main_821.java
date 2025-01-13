import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_821 {
    public static void main(String[] args) throws IOException {
        // Load HTML content
        String htmlContent = "<html><body>This is a simple HTML page.</body></html>";

        // Create a new Word document
        HWPFDocument document = new HWPFDocument();

        // Add HTML content to the document
        Range range = document.getRange();
        Paragraph paragraph = range.insertAfter(new Paragraph());
        paragraph.setText(htmlContent);

        // Save the document to a file
        try (FileOutputStream out = new FileOutputStream("output.doc")) {
            document.write(out);
        }
        document.close();
    }
}