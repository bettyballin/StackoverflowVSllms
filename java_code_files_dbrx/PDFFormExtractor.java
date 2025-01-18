import java.io.*;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;

public class PDFFormExtractor {
    public static void main(String[] args) throws IOException {
        String inputFile = "path/to/input_file.pdf";
        String outputFile = "path/to/output_file.csv";
        extractFormDataToCSV(inputFile, outputFile);
    } 

    private static void extractFormDataToCSV(String inputPath, String outputPath) throws IOException {
        PdfReader reader = new PdfReader(inputPath);
        AcroFields fields = reader.getAcroFields();
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(outputPath))) {
            for (String fieldName : fields.getFields().keySet()) {
                pw.println(""); // CSV separator
                String value = fields.getField(fieldName);
                if (value != null)
                    pw.print("\"" + value + "\"\n");
            }
        }
        reader.close();
    } 
}