import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.utils.PdfMerger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PdfMergeExample {

    public static void main(String[] args) throws IOException {
        // Create a ByteArrayOutputStream to hold the merged PDF in memory
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Initialize a PdfWriter that writes to the ByteArrayOutputStream
        PdfWriter writer = new PdfWriter(baos);

        // Create a PdfDocument object with the PdfWriter
        PdfDocument outputPdf = new PdfDocument(writer);

        // Create an instance of PdfMerger
        PdfMerger merger = new PdfMerger(outputPdf);

        // Define the paths to your PDF files
        String[] pdfPaths = {
                "path/to/document1.pdf",
                "path/to/document2.pdf",
                "path/to/document3.pdf"
        };

        // Merge each PDF file into the output PDF document
        for (String path : pdfPaths) {
            PdfDocument pdfDoc = new PdfDocument(new PdfReader(path));
            merger.merge(pdfDoc, 1, pdfDoc.getNumberOfPages());
            pdfDoc.close();
        }

        // Close the outputPdf
        outputPdf.close();

        // The merged PDF content is now available in baos as a byte array
        byte[] mergedPdfBytes = baos.toByteArray();

        // You can return this byte array to the client or write it to disk
    }
}