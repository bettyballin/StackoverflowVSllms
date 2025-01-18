import net.sf.saxon.Configuration;
import net.sf.saxon.om.NodeInfo;
import net.sf.saxon.s9api.*;

import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class SaxonExample {
    public static void main(String[] args) throws SaxonApiException {
        String xml = "<root><a>#BBB#</a><a>#CCC#</a><b><a>#DDD#</a></b></root>";
        Configuration config = new Configuration();  // create a configuration for Saxon-HE
        Processor proc = new Processor(config);      // and a processor with this configuration
        XPathCompiler xpathComp = proc.newXPathCompiler();    // create an XPath compiler
        xpathComp.declareNamespace("xs", "http://www.w3.org/2001/XMLSchema");  // make sure Saxon is aware of namespace if required
        DocumentBuilder builder = proc.newDocumentBuilder();   // and a document builder
        StringReader sr = new StringReader(xml);
        StreamSource in = new StreamSource(sr);
        XdmNode root = builder.build(in);           // build the input document as an XDM node
        String xpathStr = "/root/a[matches(.,'#...#')]";      // define your path expression with 'matches' function supported by Saxon
        xpathComp.setLanguageVersion("3.1");  // make sure you ask for at least version 3.0 to support the "match" function
        XPathExecutable xPathExec = xpathComp.compile(xpathStr);   // compile your expression
        List<NodeInfo> nodes = new ArrayList<>();    // create a list of NodeInfo for results (optional if you can use XdmValue)
        try {
            XPathSelector selector = xPathExec.load();      // use the compiled path with 'load()' to return a XPathSelector object
            selector.setContextItem(root);         // supply input document as context item for this selection
            for (XdmItem item : selector) {       // iterate over results
                NodeInfo node = ((XdmNode) item).getUnderlyingNode(); // get the NodeInfo
                nodes.add(node);          // store NodeInfo instance
            }
        } catch (SaxonApiException ex) {              // exception handling for invalid expressions or processing problems
            throw new RuntimeException("Failure in xpath evaluation", ex);  // rethrow the original exception to report the error.
        }
        nodes.forEach(System.out::println);     // print each matching node from result list (if required)
    }
}