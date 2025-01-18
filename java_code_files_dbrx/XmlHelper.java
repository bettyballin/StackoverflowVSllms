import javax.xml.namespace.QName;

public class XmlHelper {
    Node node;
    String bar = node.getStringValue(new QName("bar"));
    String fiizz = node.getStringValue(new QName("fiizz"));

    public static void main(String[] args) {
    }

    class Node {
        public String getStringValue(QName qName) {
            return null;
        }
    }
}