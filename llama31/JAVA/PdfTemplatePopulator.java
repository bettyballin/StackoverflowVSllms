import com.itextpdf.text.BaseFont;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfTemplatePopulator {

    public static void main(String[] args) throws DocumentException, IOException {
        // Create a new document
        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File("output.pdf")));
        document.open();

        // create a PDF template with placeholders
        PdfTemplate template = writer.getDirectContent().createTemplate(PageSize.A4.getWidth(), PageSize.A4.getHeight());
        template.add(new Paragraph("#{title}"));
        template.add(new Paragraph("#{content}"));

        // populate the template with data
        PdfContentByte cb = writer.getDirectContent();
        cb.beginText();
        cb.setFontAndSize(BaseFont.createFont(), 12);
        cb.showTextAligned(Element.ALIGN_LEFT, "My Title", 100, 100, 0);
        cb.showTextAligned(Element.ALIGN_LEFT, "My Content", 100, 150, 0);
        cb.endText();

        // Add the template to the document
        cb.addTemplate(template, 0, 0);

        document.close();
    }
}