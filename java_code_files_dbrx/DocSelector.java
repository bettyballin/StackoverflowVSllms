import java.lang.String;
public class DocSelector {
    // Example: Testing XPath query with default XBean engine explicitly set.
    public static void main(String[] args) {
        XmlObject doc = new XmlObject();
        String queryElement = "someElement";
        XmlObject[] objList = doc.selectPath( ".//" + queryElement ); // Query for elements matching our desired path
    }
}

class XmlObject {
    public XmlObject[] selectPath(String path) {
        return new XmlObject[0];
    }
}