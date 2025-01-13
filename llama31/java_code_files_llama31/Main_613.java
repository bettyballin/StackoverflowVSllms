/*
 * Decompiled with CFR 0.152.
 */
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class Main_613 {
    public static void main(String[] stringArray) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        documentBuilderFactory.setNamespaceAware(true);
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpression = xPath.compile("/root/node");
        String string = "<root><node>value</node></root>";
        InputSource inputSource = new InputSource(new StringReader(string));
        Node node = (Node)xPathExpression.evaluate(inputSource, XPathConstants.NODE);
        System.out.println(node.getTextContent());
    }
}
