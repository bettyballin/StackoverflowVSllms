import java.io.IOException;
import java.util.Date;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.font.PdfEncodings;

public class GeneratePdf {
  public static void main(String[] args) throws IOException {
    PdfWriter writer = new PdfWriter("path/to/output.pdf");
    PdfDocument pdfDoc = new PdfDocument(writer);
    Document doc = new Document(pdfDoc);
    
    // Load the custom TTF font
    PdfFont font = PdfFontFactory.createFont("path/to/your/font.ttf", PdfEncodings.IDENTITY_H);
    
    // Create a paragraph with the current time
    Paragraph para = new Paragraph("Current Time: " + new Date());
    para.setFont(font);
    doc.add(para);
    
    // Load the EPS image and convert it to a PDF image
    Image image = new com.itextpdf.layout.element.Image(com.itextpdf.io.IOException.class.getResource("/path/to/your/image.eps"));
    image.setAbsolutePosition(100, 100);
    doc.add(image);
    
    doc.close();
  }
}