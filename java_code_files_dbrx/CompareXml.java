import java.lang.String;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.custommonkey.xmlunit.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CompareXml {

    @Test
    public void testEquivalence() throws Exception {
        final String xmlStr1 = "<tag>Hello</tag>";
        final String xmlStr2 = "<tag>\n\tHello\n</tag>"; // note the inconsistent formatting

        try (InputStream is1 = new ByteArrayInputStream(xmlStr1.getBytes());
             InputStream is2 = new ByteArrayInputStream(xmlStr2.getBytes())) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc1 = factory.newDocumentBuilder().parse(is1);
            Document doc2 = factory.newDocumentBuilder().parse(is2);

            XMLUnit.setIgnoreWhitespace(true); // optionally ignore whitespaces during the comparison if needed
            XMLAssert.assertXMLEqual("The two documents are not identical", doc1, doc2);
        }
    }

    public static void main(String[] args) {
        // Run the test method
        CompareXml tester = new CompareXml();
        try {
            tester.testEquivalence();
            System.out.println("Test passed: The two documents are identical.");
        } catch (AssertionError e) {
            System.err.println("Test failed: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}