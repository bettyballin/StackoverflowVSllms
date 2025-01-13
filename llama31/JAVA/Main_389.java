import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.XmpReader;
import com.itextpdf.text.pdf.XmpWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main_389 {
    public static void main(String[] args) throws IOException, DocumentException {
        // Load the PDF file
        PdfReader reader = new PdfReader("input.pdf");

        // Create a new PdfStamper object
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("output.pdf"));

        // Create an XMP writer
        XmpWriter xmpWriter = new XmpWriter();

        // Add custom metadata
        xmpWriter.addRDFDescription("http://example.com/metadata",
                "MRN", "TEST000001");
        xmpWriter.addRDFDescription("http://example.com/metadata",
                "ACCT", "TEST0000000000001");
        xmpWriter.addRDFDescription("http://example.com/metadata",
                "DATE", "01/01/2009^16:44");
        xmpWriter.addRDFDescription("http://example.com/metadata",
                "DOC_TYPE", "Clinical");
        xmpWriter.addRDFDescription("http://example.com/metadata",
                "DOC_NUM", "192837475");
        xmpWriter.addRDFDescription("http://example.com/metadata",
                "DOC_VER", "1");

        // Add the XMP metadata to the PDF file
        stamper.getXmpWriter().addXmpMetadata(xmpWriter);

        // Close the PdfStamper object
        stamper.close();
    }
}