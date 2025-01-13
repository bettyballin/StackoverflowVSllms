import java.io.StringReader;
import java.lang.String;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;

import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import com.ximpleware.VTDGen;

public class XmlBenchmark {
  public static void main(String[] args) throws Exception {
    // Create a sample XML document
    String xml = "<root><node>text</node></root>";

    // DOM parsing
    long start = System.currentTimeMillis();
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    domFactory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
    long end = System.currentTimeMillis();
    System.out.println("DOM parsing time: " + (end - start) + "ms");

    // SAX parsing
    start = System.currentTimeMillis();
    SAXParserFactory saxFactory = SAXParserFactory.newInstance();
    saxFactory.newSAXParser().parse(new InputSource(new StringReader(xml)), new DefaultHandler());
    end = System.currentTimeMillis();
    System.out.println("SAX parsing time: " + (end - start) + "ms");

    // StAX parsing
    start = System.currentTimeMillis();
    XMLInputFactory staxFactory = XMLInputFactory.newInstance();
    staxFactory.createXMLStreamReader(new StringReader(xml));
    end = System.currentTimeMillis();
    System.out.println("StAX parsing time: " + (end - start) + "ms");

    // VTD parsing
    start = System.currentTimeMillis();
    VTDGen vg = new VTDGen();
    vg.parse(new StringReader(xml), true);
    end = System.currentTimeMillis();
    System.out.println("VTD parsing time: " + (end - start) + "ms");
  }
}