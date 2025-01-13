import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_126 {
    public static void main(String[] args) {
        try (XWPFDocument doc = new XWPFDocument(new FileInputStream("input.docx"));
             FileOutputStream out = new FileOutputStream("output.docx")) {
            // Work with your document here
            // Saving back to docx for simplicity
            doc.write(out);
        } catch (IOException e) {
            System.err.println("Error handling the document: " + e.getMessage());
        }
    }
}