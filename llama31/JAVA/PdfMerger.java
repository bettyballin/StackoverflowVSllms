import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

public class PdfMerger {
    public byte[] mergePdfs(File[] pdfFiles) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdfDoc = new PdfDocument(writer);

        for (File file : pdfFiles) {
            PdfReader reader = new PdfReader(new FileInputStream(file));
            PdfDocument srcDoc = new PdfDocument(reader);
            for (int i = 1; i <= srcDoc.getNumberOfPages(); i++) {
                PdfPage page = srcDoc.getPage(i);
                pdfDoc.addPage(page);
            }
            srcDoc.close();
            reader.close();
        }
        pdfDoc.close();
        writer.close();
        return baos.toByteArray();
    }

    public static void main(String[] args) {
        // Create an instance of PdfMerger and call mergePdfs method
        PdfMerger merger = new PdfMerger();
        File[] pdfFiles = {new File("file1.pdf"), new File("file2.pdf")};
        try {
            byte[] mergedPdf = merger.mergePdfs(pdfFiles);
            System.out.println("PDF files merged successfully.");
        } catch (IOException e) {
            System.out.println("Error merging PDF files: " + e.getMessage());
        }
    }
}