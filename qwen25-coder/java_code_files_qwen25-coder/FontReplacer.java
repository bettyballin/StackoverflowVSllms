import com.itextpdf.layout.Document;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FontReplacer {
    public static final String DEST = "output.pdf";
    public static final String SRC = "input.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        
        PdfReader reader = new PdfReader(SRC);
        PdfWriter writer = new PdfWriter(new FileOutputStream(DEST));
        PdfDocument pdfDoc = new PdfDocument(reader, writer);

        // Create font
        PdfFont font = PdfFontFactory.createFont("path/to/your/bold-font.ttf", PdfEncodings.IDENTITY_H, true);

        Document doc = new Document(pdfDoc);
        // Iterate through pages and replace fonts
        for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
            doc.showTextAligned(new Paragraph()
                    .add(new Text("This is a test").setFont(font)), 36, 750, i, TextAlignment.LEFT, 0, 1.2f);
        }
        doc.close();
    }
}