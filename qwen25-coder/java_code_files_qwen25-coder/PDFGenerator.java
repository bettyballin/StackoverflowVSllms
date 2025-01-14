import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFGenerator {

    public static void generatePDF(String[] formPages, String outputFilePath) {
        try (FileOutputStream fos = new FileOutputStream(new File(outputFilePath));
             PdfWriter writer = new PdfWriter(fos);
             PdfDocument pdfDoc = new PdfDocument(writer)) {

            for (String htmlContent : formPages) {
                HtmlConverter.convertToPdf(htmlContent, pdfDoc);
            }

        } catch (IOException e) {
            System.err.println("Error generating PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Simulated HTML content from your WebObjects forms
        String[] formPages = new String[]{
                "<html><body><h1>Page 1</h1><p>This is the first page of the form.</p></body></html>",
                "<html><body><h1>Page 2</h1><p>This is the second page of the form.</p></body></html>"
        };

        String outputPath = "output.pdf";
        generatePDF(formPages, outputPath);
        System.out.println("PDF generated successfully at: " + outputPath);
    }
}