import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

public class HtmlToPdf_3_3 {
    public static void main(String[] args) throws Exception {
        String inputFile = "input.html";
        String outputFile = "output.pdf";

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream(inputFile));
        document.close();
    }
}