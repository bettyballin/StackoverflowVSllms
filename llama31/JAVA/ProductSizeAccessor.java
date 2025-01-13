import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductSizeAccessor {
    // Assuming 'sizeIndex' is the parameter you want to use for direct access
    public void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String sizeIndex = request.getParameter("sizeIndex");
        // Assuming 'productXML' is your XML document
        Document productXML = getYourXMLDocumentSomehow();

        // Preprocess the XPath expression
        String xpathExpr = "/product/sizes/size[" + sizeIndex + "]";
        XPath xpath = XPathFactory.newInstance().newXPath();
        Node sizeNode = (Node) xpath.compile(xpathExpr).evaluate(productXML, XPathConstants.NODE);

        // Place 'sizeNode' in the request or session scope for direct access in JSP
        request.setAttribute("sizeNode", sizeNode);
    }

    public Document getYourXMLDocumentSomehow() {
        // This method should be implemented to load your XML document
        // For demonstration purposes, it returns null
        return null;
    }

    public static void main(String[] args) {
        // This main method is empty because this class seems to be designed for use in a servlet or similar environment
        // The processRequest method is where the actual processing happens
    }
}