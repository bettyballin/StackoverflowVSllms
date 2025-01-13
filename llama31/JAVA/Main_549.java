import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main_549 {
    public static void main(String[] args) throws Exception {
        // Load the PDF file (not Excel file, as PdfReader is used for PDFs)
        PdfReader pdfReader = new PdfReader("example.pdf");

        // Create a new PDF document
        Document document = new Document();

        // Create a PDF writer
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));

        // Open the document for writing
        document.open();

        // Close the document and writer
        document.close();
        pdfWriter.close();

        // Note: The input file should be a PDF, not an Excel file
        // If you want to convert an Excel file to PDF, you need to use a different library or approach
    }
}