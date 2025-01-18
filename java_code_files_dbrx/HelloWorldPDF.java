import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class HelloWorldPDF {
    public static void main(String[] args) {
        // create a new document with the desired dimensions for your report / table
        Document document = new Document(PageSize.A4, 50, 50, 50, 25);
        try {
            PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("helloWorld.pdf"));
            // before adding the content, open your document for writing
            document.open();
            Paragraph paragraph = new Paragraph("Hello World!"); // add custom text or table content here
            // code to add content goes here
        } finally {
            // always close your PDF file after writing / updating data
            if (document != null) {
                document.close();
            }
        }
    }
}