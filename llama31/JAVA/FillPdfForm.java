import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.colorspace.PdfColorSpace;
import com.itextpdf.kernel.pdf.font.PdfFont;
import com.itextpdf.kernel.pdf.font.PdfFontFactory;

public class FillPdfForm {
    public static void main(String[] args) throws IOException {
        // Load the original PDF document
        PdfDocument pdfDoc = new PdfDocument(new PdfReader("path/to/original.pdf"));

        // Get the first page
        PdfPage page = pdfDoc.getPage(1);

        // Create a new PDF writer
        PdfWriter writer = new PdfWriter("path/to/output.pdf");

        // Create a new PDF document with the same page size
        PdfDocument newPdfDoc = new PdfDocument(writer);
        PdfPage newPage = newPdfDoc.addNewPage();

        // Copy the original page content to the new page
        newPage.copyContent(page);

        // Get the canvas to draw on
        PdfCanvas canvas = new PdfCanvas(newPage);

        // Set the font and font size
        PdfFont font = PdfFontFactory.createFont("Helvetica");
        canvas.setFontAndSize(font, 12);

        // Draw the text at the desired position
        canvas.showTextAligned(PdfContentByte.ALIGN_LEFT, "John Doe", 100, 700, 0);

        // Close the documents
        pdfDoc.close();
        newPdfDoc.close();
    }
}