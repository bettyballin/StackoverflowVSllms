import com.itextpdf.html2pdf.HtmlConverter;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlToPdfConverter {

    public static void main(String[] args) throws Exception {
        // Define paths
        String xmlPath = "path/to/your/input.xml";
        String xsltPath = "path/to/your/style.xsl";
        String outputPath = "path/to/output.pdf";

        // Transform XML to HTML using XSLT
        ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
        TransformerFactory.newInstance()
                .newTransformer(new StreamSource(xsltPath))
                .transform(new StreamSource(xmlPath), new StreamResult(htmlStream));

        // Convert HTML to PDF using iText
        HtmlConverter.convertToPdf(htmlStream.toString(), Files.newOutputStream(Paths.get(outputPath)));

        System.out.println("PDF created successfully at " + outputPath);
    }
}