import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.File;
import java.io.FileInputStream;

public class DocumentParser {
    public static String parseWord(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        XWPFDocument document = new XWPFDocument(fis);
        StringBuilder text = new StringBuilder();
        for (XWPFParagraph paragraph : document.getParagraphs()) {
            text.append(paragraph.getText()).append("\n");
        }
        return text.toString();
    }

    // Similarly, you can implement parsers for PDF and other formats.

    public static void main(String[] args) {
    }
}