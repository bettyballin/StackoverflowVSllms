import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFText2HTML;

public class PDFToHtmlConverter {
    public static void main(String[] args) throws IOException {
        // Load a PDF document
        File inputPdf = new File("input.pdf");
        
        // Setup output file for HTML
        File outputFile = new File("output.html");

        try (PDDocument pdfDocument = PDDocument.load(inputPdf);
             Writer writer = new FileWriter(outputFile)) {

            // Convert PDF to HTML using PDFBox's PDFText2HTML
            PDFText2HTML converter = new PDFText2HTML();
            String htmlContent = converter.getText(pdfDocument);
            writer.write(htmlContent);

            System.out.println("PDF converted to HTML successfully!");
        }
    }
}