import java.lang.String;
import org.w3c.dom.NodeList;

public class NodePrinter {
    static NodeList nodes;

    public static void main(String[] args) {
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getTextContent());
        }
    }
}