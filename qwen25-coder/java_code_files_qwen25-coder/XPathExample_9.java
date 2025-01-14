import java.lang.String;
// Example in Java using XPath with DOM
  import javax.xml.parsers.DocumentBuilderFactory;
  import javax.xml.parsers.DocumentBuilder;
  import org.w3c.dom.Document;
  import org.w3c.dom.NodeList;
  import org.w3c.dom.Node;
  import org.w3c.dom.Element;
  import javax.xml.xpath.XPathFactory;
  import javax.xml.xpath.XPathExpression;
  import javax.xml.xpath.XPathConstants;

  public class XPathExample_9 {
      public static void main(String[] args) throws Exception {
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse("example.xml");
          doc.getDocumentElement().normalize();

          XPathExpression xPathExpr = XPathFactory
              .newInstance()
              .newXPath()
              .compile("//node");

          NodeList nl = (NodeList)xPathExpr.evaluate(doc, XPathConstants.NODESET);
          for (int i=0; i<nl.getLength(); i++) {
              Node n = nl.item(i);
              System.out.println(n.getTextContent());
          }
      }
  }
