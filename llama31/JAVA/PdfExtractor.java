import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextProcessor;

public class PdfExtractor {
    public static void main(String[] args) throws Exception {
        // Assuming 'pdfResponse' is the HTTP response containing the PDF file
        // Note: pdfResponse is not defined in the original code, 
        // you need to define it or replace it with actual HTTP response
        // For demonstration purposes, let's assume pdfBytes is defined as follows:
        byte[] pdfBytes = // your pdf bytes here, for example:
                           // Files.readAllBytes(Paths.get("path/to/your/file.pdf"));

        PDDocument pdfDocument = PDDocument.load(pdfBytes);
        String pdfText = new PDFTextProcessor().getText(pdfDocument);

        // Now you can use 'pdfText' to perform assertions
        System.out.println(pdfText);
    }
}