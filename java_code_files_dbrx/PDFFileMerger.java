import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PDFFileMerger {
    public static void main(String[] args) throws IOException {
        List<File> pdfFiles = new ArrayList<>();
        // Add your 3 PDF files to the list (generated from legacy library).
        File file1 = new File("document_1.pdf");
        pdfFiles.add(file1);
        File file2 = new File("document_2.pdf");
        pdfFiles.add(file2);
        File file3 = new File("document_3.pdf");
        pdfFiles.add(file3);

        ByteArrayOutputStream mergedPDFStream = mergePDFDocuments(pdfFiles);
    }

    public static ByteArrayOutputStream mergePDFDocuments(List<File> pdfFiles) throws IOException {
        PDFMergerUtility mergerUtility = new PDFMergerUtility();

        for (File file : pdfFiles) {
            if (file.exists()) { // Ensure the file exists before adding it to the list of files to be merged.
                mergerUtility.addSource(file);  // Modified this line to add each PDF file to the input list for merge operation.
            } else {
                System.err.println("ERROR: The file " + file.getAbsolutePath() + " does not exist.");
            }
        }
        ByteArrayOutputStream mergedPDFStream = new ByteArrayOutputStream();
        mergerUtility.setDestinationStream(mergedPDFStream);
        mergerUtility.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly()); // Corrected method call with appropriate parameter.

        return mergedPDFStream;
    }
}