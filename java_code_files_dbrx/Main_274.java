import javax.xml.xpath.*;

public class Main {
    public static void main(String[] args) {
        // Create an empty expression (it will change below)
        XPathExpression xpath = null;

        try {
            // Initialize the factory object
            XPathFactory fact = XPathFactory.newInstance();

            // Generate a new instance of this factory
            XPath xp = fact.newXPath();

            // Create an expression from an external string and use it to compile
            xpath = xp.compile("//books/book[@category='FITNESS']");

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}