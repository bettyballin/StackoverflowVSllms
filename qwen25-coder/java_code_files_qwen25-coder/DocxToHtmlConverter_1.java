import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

public class DocxToHtmlConverter_1 {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fis = new FileInputStream("input.docx");
             XWPFDocument document = new XWPFDocument(fis)) {

            List<String> paragraphs = new ArrayList<>();
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                paragraphs.add(paragraph.getText());
            }

            String markdownContent = String.join("\n", paragraphs);
            Parser parser = Parser.builder().build();
            HtmlRenderer renderer = HtmlRenderer.builder().build();

            String htmlContent = renderer.render(parser.parse(markdownContent));
            System.out.println(htmlContent); // This is your HTML.
        }
    }
}