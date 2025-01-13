import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextProcessor;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.Patch;

public class PdfDiff {
    public static void main(String[] args) throws IOException {
        PDDocument doc1 = PDDocument.load(new File("file1.pdf"));
        PDDocument doc2 = PDDocument.load(new File("file2.pdf"));

        String text1 = PDFTextProcessor.getText(doc1);
        String text2 = PDFTextProcessor.getText(doc2);

        Patch<String> patch = DiffUtils.diff(text1.split("\n"), text2.split("\n"));

        System.out.println(patch.toString());
    }
}