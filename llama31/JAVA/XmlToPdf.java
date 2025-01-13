import org.xhtmlrenderer.pdf.ITextRenderer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;

public class XmlToPdf {
    public static void main(String[] args) throws Exception {
        // Load the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("path/to/your/xml/file.xml"));

        // Load the XSL stylesheet
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setURIResolver(new URIResolver() {
            @Override
            public javax.xml.transform.Source resolve(String href, String base) {
                return new StreamSource(new File("path/to/your/xsl/stylesheet.xsl"));
            }
        });

        // Transform the XML to HTML
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new StringWriter());
        transformer.transform(source, result);
        String html = result.getWriter().toString();

        // Render the HTML to PDF
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(new FileOutputStream("path/to/your/output.pdf"));
    }
}