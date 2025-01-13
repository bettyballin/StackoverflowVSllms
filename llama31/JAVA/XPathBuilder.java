import org.jaxen.BaseXPath;
import org.jaxen.JaxenException;
import org.jaxen.XPath;

public class XPathBuilder {
    public static void main(String[] args) {
        try {
            XPath xpath = new BaseXPath("//Root");

            // Add Policy elements based on user input
            xpath.addPredicate(new BaseXPath("Policy[Report/Name/text() = 'report #1']"));
            xpath.addPredicate(new BaseXPath("Policy[Report/Name/text() = 'report #2']"));

            System.out.println(xpath.toString());
        } catch (JaxenException e) {
            System.err.println("Error creating or manipulating XPath: " + e.getMessage());
        }
    }
}