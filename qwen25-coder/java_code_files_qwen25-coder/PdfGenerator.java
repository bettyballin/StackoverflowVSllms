import java.io.File;
import java.io.OutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.sax.SAXResult;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.xmlgraphics.util.MimeConstants;

public class PdfGenerator {
    private FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());

    public void writeDownload(OutputStream out) throws UtilException {
        File fo = new File("C:\\somedirectory", "HelloWorld.fo");
        
        try {
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(); // identity transformer

            Source src = new StreamSource(fo);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);

        } catch (Exception e) {
            throw new UtilException("Could not generate PDF. Msg = " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Optionally, write code to test the writeDownload method
    }
}

class UtilException extends Exception {
    public UtilException(String message) {
        super(message);
    }
}