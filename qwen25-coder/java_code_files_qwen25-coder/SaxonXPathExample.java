import net.sf.saxon.Configuration;
import net.sf.saxon.s9api.*;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class SaxonXPathExample {
    public static void main(String[] args) {
        String xml = "<root><a>#BBB#</a><a>#CCC#</a><b><a>#DDD#</a></b></root>";
        
        try {
            // Create a Processor instance
            Processor processor = new Processor(false);
            Configuration config = processor.getUnderlyingConfiguration();
            
            // Parse the XML string into an XdmNode
            DocumentBuilder docBuilder = processor.newDocumentBuilder();
            XdmNode xdmDoc = docBuilder.build(new StreamSource(new StringReader(xml)));
            
            // Compile the XPath expression
            XPathCompiler xpathCompiler = processor.getXPathCompiler();
            XPathExecutable xpathExecutable = xpathCompiler.compile("//a[matches(.,'#...#')]");
            
            // Evaluate the XPath expression on the document
            XPathSelector xpathSelector = xpathExecutable.load();
            xpathSelector.setContextItem(xdmDoc);
            XdmValue results = xpathSelector.evaluate();

            // Process the results
            for (XdmItem item : results) {
                System.out.println(item.getStringValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}