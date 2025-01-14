import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class UnicodePdfGenerator {
    public static void main(String[] args) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("unicode.pdf"));
        document.open();

        // Load a font that supports the characters
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        Font unicodeFont = new Font(baseFont, 12);

        document.add(new Paragraph("漢字 and some math symbols: √ π", unicodeFont));

        document.close();
    }
}