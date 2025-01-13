import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class RtfToPdf {
    public static void main(String[] args) throws DocumentException, IOException {
        String rtfFile = "input.rtf";
        String pdfFile = "output.pdf";

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
        document.open();

        XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
        worker.parseXHtml(writer, document, new FileInputStream(rtfFile));

        document.close();
    }
}