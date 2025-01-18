import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import java.io.*;

public class ConvertWordMLToPDF {
    public static void main(String[] args) throws Exception {
        // Load WordML Document to Apache POI XWPFDocument Object
        InputStream is = new FileInputStream("input.xml");
        XWPFDocument document = new XWPFDocument(OPCPackage.open(is));

        // Convert WordML to PDF using ITextPdfConverter
        OutputStream out = new FileOutputStream("output.pdf");
        PdfOptions options = PdfOptions.create();
        PdfConverter.getInstance().convert(document, out, options);
    }
}