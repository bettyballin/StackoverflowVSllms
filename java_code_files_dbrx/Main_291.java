import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.Document;

public class Main {
    public static void main(String[] args) {
        List<Node> nodesToCopy = null;
        Document newDoc = null;
        for(Node n : nodesToCopy) {
            Node importedNode = newDoc.importNode(n, true); // imports the node with its child and copies as well into target document context, instead of original one
        }
    }
}