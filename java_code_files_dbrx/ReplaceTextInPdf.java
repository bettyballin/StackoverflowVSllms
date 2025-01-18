import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ReplaceTextInPdf {
    public static void main(String[] args) throws Exception {
        String src = "sourceFile.pdf";  // specify the source file name here as string
        String tgt = "targetFile.pdf";  // specify the target file name here as string
        try (InputStream inputStream = new FileInputStream(new File(src))) {
            PDDocument doc = Loader.loadPDF(inputStream);
            replaceTextInPdf(doc, "original_text", "replacement_text");
            doc.save(tgt);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void replaceTextInPdf(PDDocument doc, String searchString, String replacement) {
        try {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);

            String text = stripper.getText(doc);
            List<String> linesAfterSearch = replaceTextIntoList(text, searchString, replacement);

            PDFont font = PDType1Font.COURIER_BOLD;

            PDPage page = new PDPage();
            doc.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(doc, page);

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.setLeading(14.5f); // set line spacing

            // Set the starting text position
            contentStream.newLineAtOffset(25, 700);

            for (String line : linesAfterSearch) {
                if (!line.matches("\\s*")) {    // blank checker to prevent adding blank lines as text content on pdf.
                    contentStream.showText(line);
                    contentStream.newLine();
                }
            }

            contentStream.endText();
            contentStream.close();
        } catch (IOException e) {
            System.err.println("IOException caught!");
        }
    }

    private static List<String> replaceTextIntoList(String text, String searchString, String replacement) {
        text = text.replace(searchString, replacement);
        String[] lines = text.split("\\r?\\n");
        return Arrays.asList(lines);
    }
}