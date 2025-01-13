import net.sf.saxon.s9api.*;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main_135 {
    public static void main(String[] args) throws SaxonApiException, FileNotFoundException {
        // assuming you have an XPathCompiler and an XPathSelector
        Processor processor = new Processor(false);
        XPathCompiler compiler = processor.newXPathCompiler();
        XPathSelector selector = compiler.compile("your/xpath/expression").load();

        // set the source as a stream
        selector.setSource(new StreamSource(new FileInputStream("yourfile.xml")));

        // Evaluate and iterate over the results
        XdmValue result = selector.evaluate();
        for (XdmItem item : result) {
            // process the item
            System.out.println(item);
        }
    }
}