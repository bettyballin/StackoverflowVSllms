import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.google.diffmatchpatch.diff_match_patch;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class PdfDiff {

    public static void main(String[] args) throws IOException {
        String text1 = extractTextFromPdf("path/to/first.pdf");
        String text2 = extractTextFromPdf("path/to/second.pdf");

        diff_match_patch patcher = new diff_match_patch();

        // Compute the difference
        LinkedList<diff_match_patch.Diff> diffs = patcher.diff_main(text1, text2);

        // Generate a pretty HTML or simple representation of the diff
        String prettyHtml = patcher.diff_prettyHtml(diffs);
        System.out.println(prettyHtml);

        // Alternatively, generate patches
        LinkedList<diff_match_patch.Patch> patches = patcher.patch_make(diffs);
        String patchesText = patcher.patch_toText(patches);
        System.out.println(patchesText);
    }

    private static String extractTextFromPdf(String filePath) throws IOException {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }
}