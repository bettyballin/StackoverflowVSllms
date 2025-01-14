import net.sf.saxon.s9api.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import javax.xml.transform.stream.StreamSource;

public class XQueryTest {

    @Test
    public void testSimpleXQuery() throws SaxonApiException {
        Processor processor = new Processor(false);
        XdmNode inputNode = processor.newDocumentBuilder().build(new StreamSource(this.getClass().getResourceAsStream("/testData.xml")));

        String xQueryExpr1 = "for $x in doc('testData.xml')/library/book return ($x/title/text(), $x/author/text())";
        XPathCompiler xpath = processor.getXPathCompiler();
        xpath.setContextItem(inputNode);

        XdmValue result = xpath.evaluate(xQueryExpr1);
        String expectedOutput = "Harry Potter and the Philosopher's StoneJ.K. RowlingHerman MelvilleMoby Dick";

        StringBuilder actualOutput = new StringBuilder();
        for (XdmItem item : result) {
            actualOutput.append(item.getStringValue()).append("");
        }

        assertEquals(expectedOutput, actualOutput.substring(0, actualOutput.length() - 1));
    }

    public static void main(String[] args) {
    }
}