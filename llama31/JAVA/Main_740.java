import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main_740 {
    public static void main(String[] args) throws IOException {
        // Create a new Word document
        XWPFDocument document = new XWPFDocument();

        // Add some content
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Hello, World!");

        // Save the document to a file
        try (FileOutputStream out = new FileOutputStream("document.docx")) {
            document.write(out);
        }
        document.close();
    }
}