import java.lang.String;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

public class XPathVsDomBenchmark {

    public static void main(String[] args) throws Exception {
        StringBuilder xml = new StringBuilder("<root>");
        for (int i = 0; i < 1000; i++) {
            xml.append("  <childNode attribute1=\"value1\">");
            xml.append("     <grandChildNode attrib1=\"val1\" attrib2=\"val2\">some content1</grandChildNode>");
            xml.append("     <grandChildNode attrib1=\"val1\" attrib2=\"val2\">some content2</grandChildNode>");
            xml.append("     <grandChildNode attrib1=\"val1\" attrib2=\"val2\">some content3</grandChildNode>");
            xml.append("  </childNode>");
        }
        xml.append("</root>");

        Document document = DocumentHelper.parseText(xml.toString());

        // Warm up
        for (int i = 0; i < 100; i++) {
            traverseDom(document);
            traverseXPath(document);
        }

        int iterations = 1000;
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            traverseDom(document);
        }
        long domTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            traverseXPath(document);
        }
        long xpathTime = System.nanoTime() - start;

        System.out.println("DOM traversal took " + domTime / iterations + " ns per iteration");
        System.out.println("XPath traversal took " + xpathTime / iterations + " ns per iteration");
    }

    private static void traverseDom(Document document) {
        Element root = document.getRootElement();
        for (Element childNode : root.elements("childNode")) {
            for (Element grandChildNode : childNode.elements("grandChildNode")) {
                // Do something with grandChildNode
            }
        }
    }

    private static void traverseXPath(Document document) throws Exception {
        XPath xpath = document.createXPath("/root/childNode/grandChildNode");
        for (Node node : xpath.selectNodes(document)) {
            // Do something with node
        }
    }
}