import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextProcessor;

public class PdfTextReplace {
    public static void main(String[] args) throws IOException {
        String inputDir = "/path/to/input/files";
        String outputDir = "/path/to/output/files";
        String searchString = "http://example.com"; // URL to remove
        String replaceString = ""; // empty string to remove the URL

        File inputDirFile = new File(inputDir);
        File[] files = inputDirFile.listFiles();

        for (File file : files) {
            if (file.getName().endsWith(".pdf")) {
                PDDocument document = PDDocument.load(file);
                String text = PDFTextProcessor.getText(document);
                text = text.replace(searchString, replaceString);
                document = new PDDocument();
                document.addPage(new PDPage());
                PDFTextProcessor.writeText(document, new BufferedWriter(new FileWriter(outputDir + File.separator + file.getName())), text);
                document.save(outputDir + File.separator + file.getName());
                document.close();
            }
        }
    }
}