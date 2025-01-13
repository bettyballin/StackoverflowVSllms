import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator_2_2 {
    public static void main(String[] args) throws DocumentException, IOException {
        FileOutputStream fileOutput = new FileOutputStream("output.pdf");
        Document document = new Document(PageSize.LETTER, 0, 0, 0, 0);
        PdfWriter writer = PdfWriter.getInstance(document, fileOutput);
        writer.setStrictImageSequence(true); 
        document.open();
        document.add(new Paragraph("hello world1"));
        addImage(document);
        addImage(document);
        addImage(document);
        document.add(new Paragraph("hello world2"));
        document.close();
    }

    public static void addImage(Document document) throws DocumentException {
        // Implementation of addImage method is missing in the original code
        // You need to implement it according to your requirements
        // For example:
        // document.add(Image.getInstance("image.jpg"));
    }
}