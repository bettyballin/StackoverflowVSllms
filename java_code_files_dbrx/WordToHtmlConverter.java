import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileInputStream;
import java.io.IOException;

public class WordToHtmlConverter {
    public String getHTMLFromDoc(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            XWPFDocument document = new XWPFDocument(fis);
            XWPFWordExtractor extractor = new XWPFWordExtractor(document);
            String textVersionOfDoc = extractor.getText(); // Extract plain text from MS Word file

            return "<html><body>" + textVersionOfDoc + "</body></html>";
        } catch (IOException e) {
            // Exception handling code here
            return null;
        }
    }
}