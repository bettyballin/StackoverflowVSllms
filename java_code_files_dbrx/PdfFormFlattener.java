import java.io.*;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

public class PdfFormFlattener {
    public static void main(String[] args) throws IOException, DocumentException {
        String src = "path/to/your/input.pdf"; // src is your source PDF file
        OutputStream os = new FileOutputStream("path/to/your/output.pdf"); // OutputStream for the destination file

        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, os);
        stamper.setFormFlattening(true);
        stamper.removeAcroForms();
        stamper.close();
    }
}