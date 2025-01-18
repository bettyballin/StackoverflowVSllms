import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FOUserAgent;
import org.apache.xmlgraphics.util.MimeConstants;

public class Main_348 {
    public static void main(String[] args) throws Exception {
        File xslfoFile = new File("input.fo"); // Your input XSL-FO file
        File pdfFile = new File("output.pdf");
        
        // Create the FopFactory instance with a base URI
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent(); // Create a user agent

        try (OutputStream out = new FileOutputStream(pdfFile)) {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup Transformer to transform the FO file
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(); // Identity transformer

            // Setup input and output for transformation
            Source src = new StreamSource(xslfoFile);
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start transformation and FOP processing
            transformer.transform(src, res);
        }
    }
}