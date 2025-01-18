import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r = p.createRun();
        r.setText("..."); // set your text here

        // Save the document to a file
        try (FileOutputStream out = new FileOutputStream("document.docx")) {
            doc.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}