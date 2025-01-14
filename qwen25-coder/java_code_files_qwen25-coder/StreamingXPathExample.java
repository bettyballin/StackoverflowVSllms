import net.sf.saxon.s9api.*;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class StreamingXPathExample {
    public static void main(String[] args) {
        try {
            // Create a Processor instance.
            Processor processor = new Processor(false);

            // Prepare a StreamSource from an XML file
            StreamSource xmlSource = new StreamSource(new File("largefile.xml"));

            // Compile an XPath expression. The result is an XPathExecutable.
            XPathCompiler xpathCompiler = processor.newXPathCompiler();
            XPathExecutable xpathExe = xpathCompiler.compile("/root/element[@type='specificType']");

            // Create the XPath selector
            XPathSelector selector = xpathExe.load();

            // Set the source document
            selector.setSource(xmlSource);

            // Iterate over matching elements
            for (XdmItem item : selector) {
                System.out.println(item.getStringValue());
            }
        } catch (SaxonApiException e) {
            e.printStackTrace();
        }
    }
}