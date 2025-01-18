import javax.xml.xpath.*;
import org.w3c.dom.*;

public class BookQuery {
    int bookId = 1; // assuming you want to find Book A's with id=1

    XPath xpath;
    Document xmlDocument;

    NodeList authors;

    public BookQuery() throws XPathExpressionException {
        xpath = XPathFactory.newInstance().newXPath();
        // Initialize xmlDocument appropriately in your actual code
        xmlDocument = null; // Placeholder for compilation
        authors = (NodeList) xpath.evaluate(
            "/bookstore/book[@id='" + bookId + "']//author",
            xmlDocument,
            XPathConstants.NODESET
        );
    }

    public static void main(String[] args) throws XPathExpressionException {
        BookQuery bq = new BookQuery();
    }
}